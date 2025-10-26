/* eslint-disable no-unused-vars */

import antlr4 from 'antlr4';
import ShonascriptxVisitor from './build/ShonascriptxVisitor.js';

export default class CustomShonascriptxVisitor extends ShonascriptxVisitor {
    constructor(options = {}) {
        super();
        this.target = options.target || 'browser';
        this.componentName = options.componentName || 'Component';

        this.effects = [];   // collected effect functions
        this.effectCounter = 0;

        this.hoistedVars = new Set(); 

        this.textNodeCounter = 0;
        this.componentImports = new Map();
        this.voidTags = new Set(['img', 'br', 'hr', 'input', 'meta', 'link', 'area', 'base', 'col', 'embed', 'source', 'track', 'wbr']);


        // Scope management
        this.scopeStack = [new Map()];
        this.scopes = [new Set()]; // For simpler scope tracking
        this.indentLevel = 0;

        // Function and event context
        this.currentFunction = null;
        this.currentEvent = null;
        this.loopDepth = 0;

        this.brokenAnonStarts = [];

        // HTML context
        this.elementCounter = 0;
        this.parentStack = ['document.body'];
        this.tagStack = ['body'];

        // Import and async handling
        this.promptInjected = false;
        this.imports = new Map();
        this.inAsyncWrapper = false;

        // DOM style properties
        this.styleProps = new Set([
            'color', 'backgroundColor', 'width', 'height', 'fontSize',
            'border', 'padding', 'margin', 'display', 'position',
            'top', 'left', 'right', 'bottom', 'fontFamily'
        ]);

        this.componentProps = [];
        this.computedCode = [];

        this.objectPropsStack = [];
        this.currentObjectName = null;

        this.tailwindEnabled = options.tailwind !== false; // Enable by default

        this.updateBlocks = [];        // Stores individual update functions
        this.dependencies = new Map(); // variable → Set of update block IDs
        this.currentDeps = new Set();  // Temp storage while visiting expressions
        this.mountCode = [];           // DOM creation (runs once)
        this.updateCounter = 0;        // Unique ID for update blocks
        this.elementRefs = new Map();  // elName → persistent reference
        this.textNodeRefs = new Map(); // textNode → {parent, expr, deps}


    }

    /* =============================================
    =            STATE & HELPER METHODS           =
    ============================================= */

    _getStateAwareAssignable(ctx) {
        const lhs = this._getAssignableString(ctx);

        // In component mode, prefix bare state variables with $$state.
        if (this.target === 'component') {
            const isBareId = /^[a-zA-Z_]\w*$/.test(lhs);
            if (isBareId && this.scopeStack[0]?.has(lhs)) {
                return `$$state.${lhs}`;
            }
        }

        return lhs;
    }

    _startTrackingDeps() {
        this.currentDeps = new Set();
    }

    _recordDep(varName) {
        if (this.currentDeps) {
            this.currentDeps.add(varName);
        }
    }

    _finishTrackingDeps() {
        const deps = this.currentDeps;
        this.currentDeps = null;
        return deps;
    }

    _registerUpdateBlock(code, deps) {
        const blockId = this.updateCounter++;

        this.updateBlocks.push({
            id: blockId,
            code: code,
            deps: deps
        });

        // Index by dependency for quick lookup
        for (const dep of deps) {
            if (!this.dependencies.has(dep)) {
                this.dependencies.set(dep, new Set());
            }
            this.dependencies.get(dep).add(blockId);
        }

        return blockId;
    }

    _processTailwindClasses(classString) {
        return classString;
    }
    _maybeRunEffects() {
        return this.effects.length ? ' _runEffects();' : '';
    }

    _getStableKey(node) {
        const token = node.start || node;
        return `k_${token.line}_${token.column}`;
    }

    _emitInterpolatedText(raw, parent, insideStyle) {
        const lines = [];
        const re = insideStyle ? /{\s*(`[\s\S]*?`)\s*}/g : /{([^}]*)}/g;
        let lastIndex = 0;
        let m;

        while ((m = re.exec(raw)) !== null) {
            const literal = raw.slice(lastIndex, m.index);

            // Emit any non-empty literal (including spaces)
            if (literal !== '') {
                const esc = literal
                    .replace(/^(['"])([\s\S]*?)\1$/, '$2')
                    .replace(/`/g, '\\`');
                lines.push(`${parent}.appendChild($$createText(\`${esc}\`));`);
            }

            const expr = m[1].trim();
            if (expr) {
                lines.push(`${parent}.appendChild($$createText(${expr}));`);
            }
            lastIndex = re.lastIndex;
        }

        const tail = raw.slice(lastIndex);

        // Emit any non-empty tail (including spaces)
        if (tail !== '') {
            const escTail = tail
                .replace(/^(['"])([\s\S]*?)\1$/, '$2')
                .replace(/`/g, '\\`');
            lines.push(`${parent}.appendChild($$createText(\`${escTail}\`));`);
        }

        return lines.join('\n');
    }

    _getAssignableString(ctx) {
        // First, check if we have an assignRoot
        if (!ctx.assignRoot || !ctx.assignRoot()) {
            return ctx.getText();
        }

        const assignRoot = ctx.assignRoot();
        if (assignRoot.propertyRef && assignRoot.propertyRef()) {
            // This now correctly handles all cases, including assignments.
            return this._getPropertyRefString(assignRoot.propertyRef());
        }

        // Check for domPropertyRef in assignRoot
        if (assignRoot.domPropertyRef && assignRoot.domPropertyRef()) {
            return this._getDomPropertyString(assignRoot.domPropertyRef());
        }

        // Handle simple ID with potential memberAccess
        let base = '';

        // Get the base identifier
        if (assignRoot.ID && assignRoot.ID()) {
            base = assignRoot.ID().getText();

            // Check if this bare ID should be "this.prop"
            if (
                this.objectPropsStack.length &&
                this.currentFunction &&
                this.objectPropsStack.at(-1).has(base)
            ) {
                base = `this.${base}`;
            }
        }

        // Handle memberAccess (for things like .prop or [index])
        if (ctx.memberAccess && ctx.memberAccess()) {
            const memberAccessList = Array.isArray(ctx.memberAccess())
                ? ctx.memberAccess()
                : [ctx.memberAccess()];

            for (const ma of memberAccessList) {
                if (ma.ID && ma.ID()) {
                    base += '.' + ma.ID().getText();
                } else if (ma.expression && ma.expression()) {
                    const indexExpr = this.visit(ma.expression());
                    base += '[' + indexExpr + ']';
                }
            }
            return base;
        }

        // If we have a base, return it
        if (base) {
            return base;
        }

        // Final fallback
        return ctx.getText();
    }


    _getPropertyRefString(propertyRefCtx) {
        // 1. Get the base object (the rightmost part of the chain).
        const base = this.visit(propertyRefCtx.primaryExpression());

        // 2. Get all the property names that came before it.
        const props = propertyRefCtx.propName().map(p => p.getText());

        // 3. Reverse the properties and join them.
        const propChain = props.reverse().join('.');

        // 4. Combine the base with the property chain.
        return `${base}.${propChain}`;
    }

    enterScope() {
        this.scopeStack.push(new Map());
        this.scopes.push(new Set());
    }

    leaveScope() {
        this.scopeStack.pop();
        this.scopes.pop();
    }

    declare(name) {
        this.scopeStack.at(-1).set(name, true);
        this.scopes.at(-1).add(name);
    }

    // isDeclared(name) {
    //     return this.scopeStack.some(s => s.has(name)) ||
    //         this.scopes.some(scope => scope.has(name));
    // }

    isDeclared(name) {
        // Check the current scope stack
        for (let i = this.scopeStack.length - 1; i >= 0; i--) {
            if (this.scopeStack[i].has(name)) {
                return true;
            }
        }


        // Fallback for older scope tracking if needed
        for (let i = this.scopes.length - 1; i >= 0; i--) {
            if (this.scopes[i].has(name)) {
                return true;
            }
        }
        return false;
    }

    isLoopVariable(name) {
        // A variable is a loop variable if it's declared and we are inside a loop.
        // We only need to check the most recent scope.
        if (this.loopDepth > 0 && this.scopes.at(-1).has(name)) {
            return true;
        }
        return false;
    }


    declareVar(name) { this.declare(name); }

    getIndent() { return "    ".repeat(this.indentLevel); }

    containsFetch(ctx) {
        if (!ctx) return false;
        if (ctx.constructor.name === 'FetchStatementContext') return true;
        if (ctx.children) return ctx.children.some(child => this.containsFetch(child));
        return false;
    }

    removeTrailingCommas(code) {
        return code.replace(/^(,\s*)+/gm, (match) => " ".repeat(match.length));
    }

    /* =============================================
    =            PROGRAM (ENTRY POINT)            =
    ============================================= */



    visitProgram(ctx) {
        const isComponent = this.target === 'component';

        if (isComponent) {
            this.parentStack = ['root'];
            this.elementCounter = 0;
            // Reset precision update tracking
            this.mountCode = [];
            this.updateBlocks = [];
            this.dependencies = new Map();
            this.currentDeps = null;
            this.updateCounter = 0;
            this.elementRefs = new Map();
            this.textNodeRefs = new Map();
        }

        if (this.target === 'node' && this.containsFetch(ctx)) {
            this.inAsyncWrapper = true;
        }

        const emittedLines = [];
        const componentVars = [];
        const componentFns = [];
        this.computedCode = [];
        let rootElement = null;

        // ========================================================================
        // 1. MAIN PROCESSING LOOP
        // ========================================================================
        for (const child of ctx.children ?? []) {
            if (child.symbol?.type === antlr4.Token.EOF || child.constructor.name === 'ErrorNodeImpl') {
                continue;
            }

            let handled = false;

            if (isComponent && child.constructor.name === 'ProgramElementContext') {
                const line = child.line?.();
                const stmt = line?.statement?.();

                if (stmt) {
                    const simpleStmt = stmt.simpleStatement?.();
                    const compoundStmt = stmt.compoundStatement?.();

                    let isAssignment = false;
                    if (simpleStmt?.assignment?.()) {
                        isAssignment = true;
                    } else if (simpleStmt?.expression?.()) {
                        const exprText = line.getText();
                        isAssignment = /^[^=!<>]*=[^=>]/.test(exprText) && !exprText.includes('=>');
                    }

                    // A1: Variable/object declaration
                    if (isAssignment || simpleStmt?.linearObjectDefinition?.()) {
                        const code = this.visit(stmt);
                        if (code.trim()) {
                            const cleanCode = code.trim().replace(/;+$/, '');
                            componentVars.push(cleanCode);
                        }
                        handled = true;
                    }
                    // A2: Function declaration
                    else if (compoundStmt?.functionDefinition?.()) {
                        const code = this.visit(compoundStmt.functionDefinition());
                        if (code.trim()) componentFns.push(code);
                        handled = true;
                    }
                    // A3: Reactive one-liner
                    else if (simpleStmt?.reactiveOneLiner?.()) {
                        this.visit(simpleStmt);
                        handled = true;
                    }
                }
                // Case B: Reactive block
                else if (child.reactiveBlock?.()) {
                    this.visit(child.reactiveBlock());
                    handled = true;
                }
                // Case C: Blank line
                else if (line && !stmt) {
                    handled = true;
                }
            }

            if (!handled) {
                const code = this.visit(child);
                if (code) {
                    emittedLines.push(code);

                    if (isComponent && !rootElement && child.htmlElement?.()) {
                        const tagName = child.htmlElement().tagName(0).getText().toLowerCase();
                        if (tagName !== 'style') {
                            rootElement = `el${this.elementCounter - 1}`;
                        }
                    }
                }
            }
        }

        const bodyCode = emittedLines.filter(Boolean).join('\n');

        /* ========== 2. HELPER FUNCTIONS ========== */
        const helpers = isComponent ? `
function $$createText(data){
    if (data && data.nodeType) return data;
    return document.createTextNode(data);
}
function $$listen(node,e,h){node.addEventListener(e,h);}
function $$setAttribute(n,a,v){
    if(a==='value'||a==='checked'||a==='selected'){n[a]=v;}
    else if (v === false || v === null || v === undefined) { n.removeAttribute(a); }
    else{n.setAttribute(a,v);}
}
function $$detachListeners(node) {
    const clone = node.cloneNode(true);
    node.parentNode?.replaceChild(clone, node);
    return clone;
}` : '';

        /* ========== 3. COMPONENT OUTPUT WITH PRECISION UPDATES ========== */
        if (isComponent) {
            // Generate imports
            let importStatements = '';
            if (this.componentImports.size > 0) {
                for (const [path, imports] of this.componentImports) {
                    let importPath = path.replace(/["']/g, '');
                    const isLocalFile = importPath.endsWith('.shonax') || importPath.endsWith('.shona');

                    if (isLocalFile) {
                        if (!importPath.startsWith('./')) {
                            importPath = './' + importPath;
                        }
                        importPath = importPath.replace(/\.shonax?$/, '.js');
                    }

                    const parts = [];
                    if (imports.default) {
                        parts.push(imports.default);
                    }
                    if (imports.named.size > 0) {
                        const namedList = [...imports.named].sort().join(', ');
                        parts.push(`{ ${namedList} }`);
                    }

                    if (parts.length > 0) {
                        importStatements += `import ${parts.join(', ')} from '${importPath}';\n`;
                    }
                }
            }
            if (importStatements) importStatements += '\n';

            // Extract state variables from componentVars
            const stateVars = [];
            const stateInitializers = [];

            for (const varDecl of componentVars) {
                const match = varDecl.match(/^\s*(?:let|const)?\s*(\w+)\s*=\s*(.+)$/);
                if (match) {
                    const [, varName, initialValue] = match;
                    stateVars.push(varName);
                    stateInitializers.push({ name: varName, value: initialValue });
                }
            }

            // Generate reactive state wrappers
            const reactiveWrappers = stateVars.map(varName => `
    let _${varName};
    Object.defineProperty($$state, '${varName}', {
        get() { return _${varName}; },
        set(value) {
            if (_${varName} !== value) {
                _${varName} = value;
                $$invalidate('${varName}');
            }
        }
    });`).join('');

            // Generate state initialization
            const stateInits = stateInitializers.map(init =>
                `    $$state.${init.name} = ${init.value};`
            ).join('\n');

            // Props destructuring
            const destructure = this.componentProps.length
                ? `    const { ${this.componentProps.join(', ')} } = props;`
                : '';

            // Generate update blocks
            const updateFunctions = this.updateBlocks.map((block, idx) => {
                const depsArray = [...block.deps];
                const dirtyCheck = depsArray.length > 0
                    ? depsArray.map(d => `$$dirty.${d}`).join(' || ')
                    : 'false';

                return `
    function $$update${idx}() {
        if (${dirtyCheck}) {
            ${block.code.split('\n').map(line => '            ' + line).join('\n').trim()}
        }
    }`;
            }).join('');

            // Generate update calls
            const updateCalls = this.updateBlocks.map((_, idx) =>
                `        $$update${idx}();`
            ).join('\n');

            // Generate dependency map for debugging
            const depMap = [];
            for (const [varName, blockIds] of this.dependencies.entries()) {
                depMap.push(`        '${varName}': [${[...blockIds].join(', ')}]`);
            }
            const depMapStr = depMap.length > 0 ? `{\n${depMap.join(',\n')}\n    }` : '{}';

            // Generate function declarations with proper indentation
            const fnDecls = componentFns.length
                ? componentFns.map(fn => fn.split('\n').map(l => '    ' + l).join('\n')).join('\n\n')
                : '';

            // Check if zvanyorwa is needed
            const needsZvanyorwa = bodyCode.includes('zvanyorwa') ||
                componentVars.some(v => v.includes('zvanyorwa'));
            const zvanyorwaDecl = needsZvanyorwa ? '    let zvanyorwa;' : '';

            // Generate mount code
            const mountCodeStr = this.mountCode.length > 0
                ? this.mountCode.join('\n').split('\n').map(l => l ? '        ' + l : '').join('\n')
                : bodyCode.split('\n').map(l => '        ' + l).join('\n');

            // Generate computed code
            const computedCodeStr = this.computedCode.length > 0
                ? this.computedCode.map(line => '        ' + line).join('\n')
                : '';

                const hoistedDecls =
    [...this.hoistedVars].map(n => `let ${n};`).join('\n    ');

            return `${importStatements}${helpers}

export default function ${this.componentName}(props = {}) {
    const root = document.createElement('div');
    ${hoistedDecls}   
    /* ================== STATE ================== */
    const $$state = {};
    const state    = $$state; 
    const $$dirty = {};
    let $$updateScheduled = false;
    const $$dependencyMap = ${depMapStr};

${destructure}
${zvanyorwaDecl}

    /* ================== REACTIVE STATE WRAPPERS ================== */
${reactiveWrappers}

    /* ================== STATE INITIALIZATION ================== */
${stateInits}

    /* ================== FUNCTIONS ================== */
${fnDecls}

    /* ================== COMPUTED PROPERTIES ================== */
    function $$runComputations() {
${computedCodeStr}
    }

    /* ================== UPDATE BLOCKS ================== */
${updateFunctions}

    /* ================== INVALIDATION SYSTEM ================== */
    function $$invalidate(key) {
        if (!$$dirty[key]) {
            $$dirty[key] = true;
            $$scheduleUpdate();
        }
    }

    function $$scheduleUpdate() {
        if (!$$updateScheduled) {
            $$updateScheduled = true;
            queueMicrotask(() => $$update());
        }
    }

    function $$update() {
        $$updateScheduled = false;
        
        // Run computations first (they may set more dirty flags)
        $$runComputations();
        
        // Run all update blocks
${updateCalls}
        
        // Clear dirty flags
        Object.keys($$dirty).forEach(key => $$dirty[key] = false);
    }

    /* ================== MOUNT (CREATE DOM) ================== */
    function $$mount() {
        $$runComputations();
${mountCodeStr}
    }

    /* ================== LIFECYCLE ================== */
    $$mount();
    
    return root;
}`;
        }

        /* ========== 4. REGULAR SCRIPT OUTPUT (Browser/Node) ========== */
        const globals = [...this.scopeStack[0].keys()].filter(n => !n.startsWith('_'));

        if (this.target === 'node') {
            let header = '';
            for (const [mod, symbols] of this.imports)
                header += `import { ${[...symbols].sort().join(', ')} } from "./${mod}.js";\n`;
            if (this.imports.size) header += '\n';
            if (this.promptInjected) header +=
                'import promptSync from "prompt-sync";\n' +
                'const prompt = promptSync({ sigint: true });\n\n';

            if (this.inAsyncWrapper && globals.length)
                header += `let ${globals.join(', ')};\n\n`;

            if (this.inAsyncWrapper) {
                const wrapper = `(async () => {\n${bodyCode}\n})();\n`;
                const exports = globals.length ? `export { ${globals.join(', ')} };\n` : '';
                return header + wrapper + exports;
            }

            if (globals.length)
                header += `export { ${globals.join(', ')} };\n\n`;

            return header + bodyCode;
        } else {
            // Browser Script
            if (this.inAsyncWrapper) {
                return `(async () => {\n${bodyCode}\n})();`;
            }
            return bodyCode;
        }
    }
    visitArrowFuncSingleParam(ctx) {
        const param = ctx.ID().getText();
        const body = this.visit(ctx.expression());

        // Remove unnecessary parentheses from the body if it's a simple expression
        let cleanBody = body;
        if (cleanBody.startsWith('(') && cleanBody.endsWith(')')) {
            // Check if removing outer parens would be safe
            const inner = cleanBody.slice(1, -1);
            // Keep parens only if there's a comma at the top level (would indicate a sequence expression)
            if (!inner.includes(',') || inner.includes('(')) {
                cleanBody = inner;
            }
        }

        // Single parameter doesn't need parentheses
        return `${param} => ${cleanBody}`;
    }

    visitArrowFuncMultiParam(ctx) {
        const paramString = ctx.parameterList()
            ? ctx.parameterList().ID().map(id => id.getText()).join(', ')
            : '';
        const body = this.visit(ctx.expression());

        // Remove unnecessary parentheses from the body
        let cleanBody = body;
        if (cleanBody.startsWith('(') && cleanBody.endsWith(')')) {
            const inner = cleanBody.slice(1, -1);
            if (!inner.includes(',') || inner.includes('(')) {
                cleanBody = inner;
            }
        }

        // Multiple parameters or no parameters need parentheses
        return `(${paramString}) => ${cleanBody}`;
    }

    visitPrimitiveFilter(ctx) {
        // Add null check
        if (!ctx.ID()) {
            console.error('PrimitiveFilter: ID is null, context:', ctx.getText());
            return `/* Error: invalid filter syntax */`;
        }

        const varName = ctx.ID().getText();
        const op = ctx.comparisonOperator().getText();
        const value = this.visit(ctx.expression());

        let comparison;
        // INVERTED logic - "bvisa" means remove
        switch (op) {
            case '>': comparison = `x <= ${value}`; break;
            case '<': comparison = `x >= ${value}`; break;
            case '>=': comparison = `x < ${value}`; break;
            case '<=': comparison = `x > ${value}`; break;
            case '==': comparison = `x !== ${value}`; break;
            case '!=': comparison = `x === ${value}`; break;
            default: comparison = `x !== ${value}`;
        }

        return `${varName} = ${varName}.filter(x => ${comparison})`;
    }

    visitDirectValueFilter(ctx) {
        const varName = ctx.ID().getText();
        const value = this.visit(ctx.expression());

        // Remove all occurrences of the specific value
        return `${varName} = ${varName}.filter(x => x !== ${value})`;
    }


    visitProgramElement(ctx) {


        if (ctx.line && ctx.line()) {

            return this.visit(ctx.line());
        }
        if (ctx.htmlElement && ctx.htmlElement()) {

            return this.visit(ctx.htmlElement());
        }
        if (ctx.reactiveBlock && ctx.reactiveBlock()) {

            return this.visit(ctx.reactiveBlock());
        }


        return '';
    }

    visitLine(ctx) {
        if (/=\s*<style/i.test(ctx.getText())) {
            throw Error('<style> elements cannot be assigned to variables – they must stay at the top level of the component.');
        }
        if (!ctx.statement()) return "";
        const code = this.visit(ctx.statement());

        // In component mode, don't add indentation here
        if (this.target === 'component') {
            return code ? code + "\n" : "";
        }

        return code ? this.getIndent() + code + "\n" : "";
    }



    /* =============================================
    =            STATEMENTS                       =
    ============================================= */

    visitStatement(ctx) {
        return ctx.simpleStatement()
            ? this.visit(ctx.simpleStatement())
            : this.visit(ctx.compoundStatement());
    }

    visitSimpleStatement(ctx) {

        const inEventHandler = this.currentFunction === "anonymous" || this.currentEvent;
        const txt = ctx.getText().trim();

        if (txt.includes('=') && txt.endsWith('zvanyorwa')) {
            const [lhsRaw/* "zita " */,] = txt.split('=');
            const lhs = lhsRaw.trim();            // ==>  "zita"
            let decl = '';

            if (!this.isDeclared(lhs)) {          // auto-declare if necessary
                decl = (this.inAsyncWrapper && this.scopeStack.length === 1) ? '' : 'let ';
                this.declare(lhs);
            }
            // trigger re-render in component mode
            const effects = this.target === 'component' ? ' _runEffects();' : '';
            return `${decl}${lhs} = zvanyorwa;${effects}`;
        }

        if (
            this.target === 'component' &&
            this.parentStack.at(-1) !== 'root' &&     // we are inside HTML
            ctx.expression() &&                       // it is a bare expression
            !ctx.assignment() && !ctx.incrementStatement() &&
            !ctx.decrementStatement() && !ctx.compoundAssignment() &&
            !inEventHandler  // BUT not inside an event handler
        ) {
            const expr = this.visit(ctx.expression());
            const parent = this.parentStack.at(-1);
            return `${parent}.appendChild($$createText(${expr}));`;
        }
        if (ctx.anonymousFunctionAssignment()) {
            return this.visitAnonymousFunctionAssignment(ctx.anonymousFunctionAssignment());
        }

        if (ctx.assignment()) return this.visit(ctx.assignment()) + ";";

        if (ctx.reactiveOneLiner()) return this.visitReactiveOneLiner(ctx.reactiveOneLiner());
        if (ctx.propsDeclaration()) return this.visitPropsDeclaration(ctx.propsDeclaration());
        if (ctx.incrementStatement()) return this.visit(ctx.incrementStatement()) + ";";
        if (ctx.decrementStatement()) return this.visit(ctx.decrementStatement()) + ";";
        if (ctx.compoundAssignment()) return this.visit(ctx.compoundAssignment()) + ";";
        if (ctx.nyoraStatement()) return this.visit(ctx.nyoraStatement()) + ";";
        if (ctx.returnStatement()) return this.visit(ctx.returnStatement()) + ";";
        if (ctx.arrayAdd()) return this.visit(ctx.arrayAdd()) + ";";
        if (ctx.arrayRemove()) return this.visit(ctx.arrayRemove()) + ";";
        if (ctx.classStatement()) return this.visit(ctx.classStatement()) + ";";
        if (ctx.setDeclaration()) return this.visit(ctx.setDeclaration()) + ";";
        if (ctx.sortStatement()) return this.visit(ctx.sortStatement()) + ";";
        if (ctx.filterStatement()) return this.visit(ctx.filterStatement()) + ";";
        if (ctx.importStatement()) return this.visit(ctx.importStatement());
        if (ctx.continueStatement()) return this.visit(ctx.continueStatement()) + ";";
        if (ctx.breakStatement()) return this.visit(ctx.breakStatement()) + ";";
        if (ctx.propertyDelete()) return this.visit(ctx.propertyDelete()) + ";";
        if (ctx.intervalStatement()) return this.visit(ctx.intervalStatement()) + ";";
        if (ctx.timeoutStatement()) return this.visit(ctx.timeoutStatement()) + ";";
        if (ctx.linearObjectDefinition()) return this.visit(ctx.linearObjectDefinition()) + ";";
        if (ctx.inputStatement()) return this.visit(ctx.inputStatement()) + ";";
        if (ctx.fetchStatement()) return this.visit(ctx.fetchStatement()) + ";";
        if (ctx.expression()) return this.visit(ctx.expression()) + ";";
        return "";
    }

    visitCompoundStatement(ctx) {
        if (ctx.conditionalStatement()) return this.visit(ctx.conditionalStatement());
        if (ctx.loopStatement()) return this.visit(ctx.loopStatement());
        if (ctx.whileStatement()) return this.visit(ctx.whileStatement());
        if (ctx.functionDefinition()) return this.visit(ctx.functionDefinition());
        if (ctx.eventListenerStatement()) return this.visit(ctx.eventListenerStatement());
        return "";
    }

    /* =============================================
    =            ASSIGNMENTS & OPERATIONS         =
    ============================================= */
    visitAssignment(ctx) {
        if (ctx.getText().includes('<style')) {
            throw Error("<style> elements cannot be assigned to variables – they must stay at the top level of the component.");
        }

        if (
            ctx.expression &&
            ctx.expression().primaryExpression &&
            ctx.expression().primaryExpression().htmlElement
        ) {
            const htmlElement = ctx.expression().primaryExpression().htmlElement();
            if (htmlElement) {
                const tag = htmlElement.tagName(0).getText().toLowerCase();
                if (tag === 'style') {
                    throw Error("<style> elements cannot be assigned to variables – they must stay at the top level of the component.");
                }
            }
        }

        const lhsString = this._getAssignableString(ctx.assignable());
        let decl = '';
        const isBareId = /^[a-zA-Z_]\w*$/.test(lhsString);

        if (isBareId && !this.isDeclared(lhsString)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1 && this.target === 'node') {
                decl = '';
            } else {
                decl = 'let ';
            }
            this.declare(lhsString);
        }

        const rhs = this.visit(ctx.expression());

        const finalLhs = this.target === 'component' && isBareId && !decl && this.scopeStack[0]?.has(lhsString)
            ? `$$state.${lhsString}`
            : lhsString;

        return `${decl}${finalLhs} = ${rhs}`;
    }
    visitIncrementStatement(ctx) {
        const lhs = this._getStateAwareAssignable(ctx.assignable());
        return `${lhs}++`;
    }

    visitDecrementStatement(ctx) {
        const lhs = this._getStateAwareAssignable(ctx.assignable());
        return `${lhs}--`;
    }


    visitCompoundAssignment(ctx) {
        const lhs = this._getStateAwareAssignable(ctx.assignable());
        const op = ctx.compoundOp().getText();
        const rhs = this.visit(ctx.expression());
        return `${lhs} ${op} ${rhs}`;
    }

    visitReturnStatement(ctx) {
        const expr = this.visit(ctx.expression());
        return `return ${expr}`;
    }

    /* =============================================
    =            I/O & CONSOLE                    =
    ============================================= */

    visitNyoraStatement(ctx) {
        const parts = ctx.expression().map(e => this.visit(e)).join(", ");
        return `console.log(${parts})`;
    }


    visitAnonymousFunctionAssignment(ctx) {
        const js = [];

        /*  lhs  */
        // const lhs = this.visit(ctx.assignable());

        const lhs = this._getAssignableString(ctx.assignable());

        /*  parameters  */
        const paramsCtx = ctx.parameterList && ctx.parameterList();
        const params = paramsCtx
            ? paramsCtx.ID().map(id => id.getText()).join(', ')
            : '';

        /*  body  */
        const body = this.visit(ctx.suite());   // suite → returns JS code for the body

        js.push(`let ${lhs} = function(${params}) {`);
        js.push(body);                          // already indented by visit(suite)
        js.push('};');

        return js.join(' ');
    }



    visitInputStatement(ctx) {
        const name = ctx.ID().getText();
        const q = ctx.STRING().getText();
        const decl = this.isDeclared(name) ? '' : 'let ';

        if (!this.isDeclared(name)) this.declare(name);

        // For browser target, use built-in prompt
        if (this.target === 'browser' || this.target === 'component') {
            return `${decl}${name} = prompt(${q});`;
        }

        // For Node.js, use prompt-sync
        this.promptInjected = true;
        return `${decl}${name} = prompt(${q} + " ");`;
    }

    visitInputExpr(ctx) {
        const q = ctx.STRING().getText();
        if (this.target === 'browser')
            return `prompt(${q})`;

        this.promptInjected = true;
        return `prompt(${q} + " ")`;
    }

    /* =============================================
    =            CONTROL FLOW                     =
    ============================================= */

    visitConditionalStatement(ctx) {
        const condition = this.visit(ctx.expression(0));
        const cleanCondition = condition.startsWith('(') && condition.endsWith(')')
            ? condition.slice(1, -1)
            : condition;

        let code = `if (${cleanCondition}) {\n`;
        this.enterScope();
        code += this.visit(ctx.suite(0));
        this.leaveScope();
        code += '\n' + this.getIndent() + '}';

        // Count else-if branches - both KANA KUTI and standalone KANA after first statement
        let elseIfIndex = 1;
        let i = 1;

        while (i < ctx.children.length) {
            const child = ctx.children[i];

            // Check for KANA or KANA KUTI
            if (child.getText() === 'kana' || (child.getText() === 'kana' &&
                i + 1 < ctx.children.length && ctx.children[i + 1].getText() === 'kuti')) {

                // Skip 'kuti' if present
                if (i + 1 < ctx.children.length && ctx.children[i + 1].getText() === 'kuti') {
                    i++;
                }

                const elseIfCondition = this.visit(ctx.expression(elseIfIndex));
                const cleanElseIfCond = elseIfCondition.startsWith('(') && elseIfCondition.endsWith(')')
                    ? elseIfCondition.slice(1, -1)
                    : elseIfCondition;

                code += ` else if (${cleanElseIfCond}) {\n`;
                this.enterScope();
                code += this.visit(ctx.suite(elseIfIndex));
                this.leaveScope();
                code += '\n' + this.getIndent() + '}';

                elseIfIndex++;
            }
            i++;
        }

        if (ctx.ZVIMWE()) {
            code += ` else {\n`;
            this.enterScope();
            code += this.visit(ctx.suite().at(-1));
            this.leaveScope();
            code += '\n' + this.getIndent() + '}';
        }

        return this.removeTrailingCommas(code);
    }

    visitConditionalExpression(ctx) {
        // If there's only one child, it's not a ternary expression.
        if (ctx.getChildCount() === 1) {
            return this.visit(ctx.logicalOrExpression());
        }

        // It's a ternary expression with 5 children: condition, '?', true-expr, ':', false-expr
        const condition = this.visit(ctx.logicalOrExpression());
        const consequent = this.visit(ctx.expression(0)); // The expression after '?'
        const alternate = this.visit(ctx.expression(1));  // The expression after ':'

        return `(${condition} ? ${consequent} : ${alternate})`;
    }

    visitLoopStatement(ctx) {
        const item = ctx.ID().getText();
        const collection = this.visit(ctx.primaryExpression());

        this.loopDepth++;
        this.enterScope();
        this.declare(item);

        let code = `for (let ${item} of ${collection}) {\n`;
        code += this.visit(ctx.suite());
        code += this.getIndent() + "}";

        this.leaveScope();
        this.loopDepth--;

        return this.removeTrailingCommas(code);
    }

    visitWhileStatement(ctx) {
        const condition = this.visit(ctx.expression());

        this.loopDepth++;
        this.enterScope();

        // Remove extra parentheses if present
        const cleanCondition = condition.startsWith('(') && condition.endsWith(')')
            ? condition.slice(1, -1)
            : condition;

        let code = `while (${cleanCondition}) {\n`;
        code += this.visit(ctx.suite());
        code += this.getIndent() + "}";

        this.leaveScope();
        this.loopDepth--;

        return this.removeTrailingCommas(code);
    }

    visitContinueStatement() {
        if (!this.loopDepth)
            throw Error("'jamba' haafane kushandiswa kunze kwe loop");
        return "continue";
    }

    visitBreakStatement() {
        if (!this.loopDepth)
            throw Error("'mira' haafane kushandiswa kunze kwe loop");
        return "break";
    }

    visitSuite(ctx) {
        let code;

        if (ctx.simpleStatement && ctx.simpleStatement()) {
            this.indentLevel++;
            // Just visit the statement and add a semicolon. No effect logic here.
            code = this.getIndent() + this.visit(ctx.simpleStatement()) + "\n";
            this.indentLevel--;
        } else {
            this.indentLevel++;
            const elements = ctx.programElement ? ctx.programElement() : ctx.line ? ctx.line() : [];
            code = elements.map(el => {
                const result = this.visit(el);
                if (!result) return '';

                if (el.htmlElement && el.htmlElement()) {
                    return result.split('\n').map(line => line ? this.getIndent() + line : '').join('\n');
                }

                if (result && !result.endsWith('\n')) {
                    return this.getIndent() + result + '\n';
                }
                return result;
            }).join("");
            this.indentLevel--;
        }

        return code;
    }

    visitHtmlVoidElement(ctx) {
        // same treatment as   <tag ... /> 
        return this.visitHtmlSelfClosingElement(ctx);
    }

    /* =============================================
    =            FUNCTIONS                        =
    ============================================= */

    visitFunctionDefinition(ctx) {
        const isAsync = this.containsFetch(ctx.suite());
        const asyncKeyword = isAsync ? "async " : "";
        const name = ctx.ID().getText();
        this.declare(name);

        this.enterScope();
        const params = ctx.parameterList() ? ctx.parameterList().ID().map(t => {
            const p = t.getText();
            this.declare(p);
            return p;
        }) : [];
        const paramString = params.join(", ");

        const isSubmitHandler = params.includes('event') || name.toLowerCase().includes('submit');

        let bodyCode = this.visit(ctx.suite());

        if (isSubmitHandler && bodyCode.includes('mavalues')) {
            bodyCode = bodyCode.replace(/mavalues\.(\w+)/g,
                'Object.fromEntries(new FormData(event.target).entries()).$1');
            bodyCode = bodyCode.replace(/mavalues(?!\w)/g,
                'Object.fromEntries(new FormData(event.target).entries())');
        }

        let finalBody = bodyCode;

        if (isSubmitHandler && params.includes('event')) {
            finalBody = `${this.getIndent()}    event.preventDefault();\n` + finalBody;
        }

        // In component mode, mutations should NOT call _runEffects (reactivity handles it)
        // Remove the old _runEffects logic since we now have $$invalidate

        let code;
        if (this.inAsyncWrapper && this.scopeStack.length === 1) {
            code = `${name} = ${asyncKeyword}function(${paramString}) {\n${finalBody}${this.getIndent()}}`;
        } else {
            code = `${asyncKeyword}function ${name}(${paramString}) {\n${finalBody}${this.getIndent()}}`;
        }

        this.leaveScope();
        return this.removeTrailingCommas(code);
    }


    visitAnonymousFunctionExpr(ctx) {
        const isAsync = this.containsFetch(ctx.suite());
        const asyncKeyword = isAsync ? "async " : "";

        const previousFn = this.currentFunction;
        this.currentFunction = "anonymous";

        this.enterScope();
        const params = ctx.parameterList() ? ctx.parameterList().ID().map(t => {
            const p = t.getText();
            this.declare(p);
            return p;
        }) : [];

        // Check if the function body uses zvanyorwa
        let bodyCode = this.visit(ctx.suite());
        const usesZvanyorwa = bodyCode.includes('zvanyorwa');

        // If it uses zvanyorwa, ensure it's declared in scope
        if (usesZvanyorwa && !this.isDeclared('zvanyorwa')) {
            // zvanyorwa will be available in the wrapper scope
            this.declare('zvanyorwa');
        }

        let finalBody = bodyCode;

        if (this.target === 'component') {
            const needsEffects = /(\+\+|--|[^=!<>]=(?!=)|\.push\(|\.pop\(|\.shift\(|\.unshift\(|\.splice\(|delete\b)/s.test(bodyCode);
            if (needsEffects) {
                finalBody += `${this.getIndent()}    _runEffects();\n`;
            }
        }

        let code = `${asyncKeyword}function(${params.join(", ")}) {\n${finalBody}${this.getIndent()}}`;

        this.leaveScope();
        this.currentFunction = previousFn;

        return this.removeTrailingCommas(code).trimEnd();
    }


    visitFunctionCall(ctx) {
        const func = ctx.ID().getText();
        const args = ctx.argumentList() ?
            ctx.argumentList().expression().map(e => this.visit(e)).join(", ") : "";
        return `${func}(${args})`;
    }

    /* =============================================
    =            HTML ELEMENTS                    =
    ============================================= */
    visitReactiveOneLiner(ctx) {
        // The statement() is the "doubled = count * 2" part
        const body = this.visit(ctx.statement());
        this.computedCode.push(body);
        return '';
    }
    /* tarisa: block */


    visitReactiveBlockStmt(ctx) {
        const inner = ctx.programElement()
            .map(pe => this.visit(pe)) // Visit each line inside the tarisa: block
            .filter(Boolean)
            .join('\n');
        this.computedCode.push(inner);
        return '';
    }

_visitAttributeWithTracking(ctx, elName) {
    const attrName = this._getAttributeName(ctx);  // Changed from ctx.attrName ? ctx.attrName().getText() : ''
    const result = { mount: '', update: null, deps: new Set() };

    /* ─────────────────────────  EVENTS  ───────────────────────── */
    const eventMap = {
        rikabayiwa   : 'click',
        rikasubmitwa : 'submit',
        ikanyorwa    : 'input',
        ikachinjwa   : 'change',
        ikasarudzwa  : 'change',
        rikapresswa  : 'keypress',
        rakapresswa  : 'keypress',
        rakabayiwa   : 'click'
    };

    if (eventMap[attrName]) {
        const jsHandler = this.visit(ctx.shonaExpression());
        const domEvt    = eventMap[attrName];
        const clean     = jsHandler.replace(/^\$\$state\./, '');

        if (attrName === 'ikanyorwa') {
            result.mount = `$$listen(${elName}, '${domEvt}', e => {
                const zvanyorwa = e.target.value;
                (${clean})(e);
            });\n`;
        } else {
            result.mount = `$$listen(${elName}, '${domEvt}', ${clean});\n`;
        }
        return result;
    }

    /* ───────────────  TWO-WAY <input>  (zvanyorwa)  ────────────── */
    if (attrName === 'zvanyorwa') {
        this._startTrackingDeps();
        const bindExpr = this.visit(ctx.shonaExpression());  // records deps
        let   deps     = this._finishTrackingDeps();         

        /* mount */
        result.mount = `$$setAttribute(${elName}, 'value', ${bindExpr});\n` +
                       `$$listen(${elName}, 'input', e => {
            const zvanyorwa = e.target.value;
            ${bindExpr} = zvanyorwa;
        });\n`;

        /* fallback if tracking missed */
        if (deps.size === 0) {
            const m = bindExpr.match(/\$\$state\.([A-Za-z_]\w*)/);
            if (m) deps = new Set([m[1]]);
        }

        /* update */
        if (deps.size) {
            result.update = `$$setAttribute(${elName}, 'value', ${bindExpr});`;
            result.deps   = deps;
        }
        return result;
    }

    /* ───────────────  TWO-WAY <select>  (zvasarudzwa)  ─────────── */
    if (attrName === 'zvasarudzwa') {
        this._startTrackingDeps();
        const bindExpr = this.visit(ctx.shonaExpression());
        let   deps     = this._finishTrackingDeps();

        result.mount = `$$setAttribute(${elName}, 'value', ${bindExpr});\n` +
                       `$$listen(${elName}, 'change', e => {
            ${bindExpr} = e.target.value;
        });\n`;

        if (deps.size === 0) {
            const m = bindExpr.match(/\$\$state\.([A-Za-z_]\w*)/);
            if (m) deps = new Set([m[1]]);
        }

        if (deps.size) {
            result.update = `$$setAttribute(${elName}, 'value', ${bindExpr});`;
            result.deps   = deps;
        }
        return result;
    }

    /* ──────────────────────  STATIC ATTR  ─────────────────────── */
    if (ctx.STRING()) {
        const real = attrName === 'className' ? 'class' : attrName;
        const val  = ctx.STRING().getText();
        result.mount = `$$setAttribute(${elName}, '${real}', ${val});\n`;
        return result;
    }

    /* ─────────────────────  DYNAMIC ATTR  ─────────────────────── */
    this._startTrackingDeps();
    const value = this.visit(ctx.shonaExpression());
    const deps  = this._finishTrackingDeps();
    const real  = attrName === 'className' ? 'class' : attrName;

    result.mount = `$$setAttribute(${elName}, '${real}', ${value});\n`;
    if (deps.size) {
        result.update = `$$setAttribute(${elName}, '${real}', ${value});`;
        result.deps   = deps;
    }
    return result;
}

visitHtmlBlockElement(ctx) {
    /* ───────────────  bookkeeping  ─────────────── */
    const elName  = `el${this.elementCounter++}`;         // variable that refers to the element
    const rawTag  = ctx.tagName(0).getText();             // exactly as in template
    const tagName = rawTag.toLowerCase();                 // normalised
    const key     = this._getStableKey(ctx);              // data-k for diff/debug
    const isCustom = /^[A-Z]/.test(rawTag);               // <MyWidget>

    /* =======================================================================
       1.  CUSTOM COMPONENT  (<MyWidget …>)
       ======================================================================= */
    if (isCustom) {
        const kvPairs = [];

        for (const a of ctx.attribute() || []) {
            const attrKey = a.attrName ? a.attrName().getText()
                                       : a.getChild(0).getText();   // shorthand  {expr}
            const val = a.STRING() ? a.STRING().getText()
                                   : this.visit(a.shonaExpression());
            kvPairs.push(`${attrKey}: ${val}`);
        }

        /* optional children → gathered in a temporary array */
        let childSnippet = '';
        if (ctx.htmlContent()) {
            this.parentStack.push(elName);
            this.tagStack.push(tagName);

            const tmpArr = `_children${this.elementCounter}`;
            const former = this.parentStack[this.parentStack.length - 1];
            this.parentStack[this.parentStack.length - 1] = tmpArr;

            const contentCode = this.visit(ctx.htmlContent());

            this.parentStack[this.parentStack.length - 1] = former;
            this.parentStack.pop();
            this.tagStack.pop();

            if (contentCode.trim()) {
                childSnippet = `const ${tmpArr} = [];\n${contentCode}\n`;
                kvPairs.push(`children: ${tmpArr}`);
            }
        }

        const ctor = `${rawTag}({ ${kvPairs.join(', ')} })`;
        const parent = this.parentStack.at(-1);

        let mount = childSnippet;
        if (parent && parent !== 'root') {
            mount += `${parent}.appendChild(${ctor});\n`;
        } else {
            mount += `const ${elName} = ${ctor};\n`;
            if (parent === 'root') mount += `root.appendChild(${elName});\n`;
        }

        if (parent === 'root') this.mountCode.push(mount);
        return { mount, element: elName };
    }

    /* =======================================================================
       2.  NATIVE ELEMENT
       ======================================================================= */

    /* ---------- 2-a  : hoisting decision -------------------------------- */
    const attrs = ctx.attribute() || [];
    let needsHoist = false;

    // Any two-way binding attribute forces hoisting immediately
    for (const a of attrs) {
        const n = a.attrName ? a.attrName().getText() : '';
        if (n === 'zvanyorwa' || n === 'zvasarudzwa') {
            needsHoist = true;
            this.hoistedVars.add(elName);
            break;
        }
    }

    /* ---------- 2-b : process attributes, gather mount/update code ------ */
    const attrResults = [];
    for (const a of attrs) {
        const res = this._visitAttributeWithTracking(a, elName);
        attrResults.push(res);

        if (!needsHoist && res.update && res.deps && res.deps.size) {
            needsHoist = true;
            this.hoistedVars.add(elName);
        }
    }

    /* ---------- 2-c : create the element -------------------------------- */
    let mount = '';
    mount += needsHoist
        ? `${elName} = document.createElement('${tagName}');\n`
        : `const ${elName} = document.createElement('${tagName}');\n`;
    mount += `${elName}.setAttribute('data-k', '${key}');\n`;

    this.elementRefs.set(elName, { tag: tagName, key });

    /* ---------- 2-d : apply attributes / register update blocks --------- */
    for (const r of attrResults) {
        if (r.mount) mount += r.mount;
        if (r.update && r.deps && r.deps.size)
            this._registerUpdateBlock(r.update, r.deps);
    }

    /* ---------- 2-e : auto-id for form fields --------------------------- */
    if (['input', 'textarea', 'select'].includes(tagName)) {
        const hasId = attrs.some(a => a.attrName && a.attrName().getText() === 'id');
        if (!hasId) mount += `${elName}.id = 'input_${this.elementCounter}';\n`;
    }

    /* ---------- 2-f : children ------------------------------------------ */
    if (!this.voidTags.has(tagName)) {
        this.parentStack.push(elName);
        this.tagStack.push(tagName);

        if (ctx.htmlContent()) {
            const kids = this.visit(ctx.htmlContent());
            if (kids.trim()) mount += kids;
        } else if (tagName === 'option') {
            const m = ctx.getText().match(/>([\s\S]*?)<\/option/i);
            const txt = m ? m[1].trim() : '';
            if (txt) mount += `${elName}.appendChild($$createText(\`${txt.replace(/`/g, '\\`')}\`));\n`;
        }

        /* <option> default value fallback */
        if (tagName === 'option') {
            const hasVal = attrs.some(a => a.attrName && a.attrName().getText() === 'value');
            if (!hasVal) mount += `if(!${elName}.hasAttribute('value'))${elName}.value=${elName}.textContent;\n`;
        }

        this.parentStack.pop();
        this.tagStack.pop();
    }

    /* ---------- 2-g : append to parent ---------------------------------- */
    const parent = this.parentStack.at(-1);
    if (tagName === 'style') {
        mount += `document.head.appendChild(${elName});\n`;
    } else if (parent === 'root') {
        mount += `root.appendChild(${elName});\n`;
    } else if (parent) {
        mount += `${parent}.appendChild(${elName});\n`;
    }

    /* ---------- 2-h : store at top-level if root ------------------------- */
    if (parent === 'root') this.mountCode.push(mount);

    return { mount, element: elName };
}
    visitHtmlExpr(ctx) {
        // Only allow in component mode
        if (this.target !== 'component') {
            throw new Error(
                'HTML elements as expressions are only allowed in component files (.shonax)'
            );
        }
        return this.visit(ctx.htmlElement());   // returns the IIFE string
    }
    // visitHtmlSelfClosingElement(ctx) {
    //     const elName = `el${this.elementCounter++}`;
    //     const rawTag = ctx.tagName().getText();
    //     const tagName = rawTag.toLowerCase();
    //     if (tagName === 'style')
    //         throw Error('<style> cannot be self-closing – write <style>…</style>.');

    //     const stableKey = this._getStableKey(ctx);
    //     const isCustom = /^[A-Z]/.test(rawTag);
    //     const inComp = this.target === 'component';
    //     let parent = inComp ? (this.parentStack.at(-1) === 'root' ? null : this.parentStack.at(-1))
    //         : this.parentStack.at(-1);

    //     /* ---- custom component (unchanged) ---- */

    //     if (isCustom) {
    //         const kvPairs = [];

    //         for (const a of ctx.attribute() || []) {
    //             const key = a.attrName
    //                 ? a.attrName().getText()
    //                 : a.getChild(0).getText();

    //             const val = a.STRING()
    //                 ? a.STRING().getText()
    //                 : this.visit(a.shonaExpression());

    //             kvPairs.push(`${key}: ${val}`);
    //         }

    //         const call = `${rawTag}({ ${kvPairs.join(', ')} })`;

    //         if (parent)
    //             return `${parent}.appendChild(${call});\n`;

    //         return `const ${elName} = ${call};\n`;
    //     }

    //     /* ---- native element ---- */
    //     let code = `const ${elName} = document.createElement('${tagName}');\n`;
    //     code += `${elName}.setAttribute('data-k', '${stableKey}');\n`;

    //     for (const a of ctx.attribute() || []) {
    //         const snip = this.visitAttribute(a, elName);
    //         if (snip) code += snip;
    //     }

    //     if (parent) code += `${parent}.appendChild(${elName});\n`;
    //     return code;
    // }

    visitHtmlSelfClosingElement(ctx) {
    const elName  = `el${this.elementCounter++}`;
    const rawTag  = ctx.tagName().getText();
    const tagName = rawTag.toLowerCase();

    if (tagName === 'style')
        throw Error('<style> cannot be self-closing – write <style>…</style>.');

    const key = this._getStableKey(ctx);
    const isCustom = /^[A-Z]/.test(rawTag);

    /* ───────────── custom component (unchanged) ───────────── */
    if (isCustom) {
        const kv = [];
        for (const a of ctx.attribute() || []) {
            const k = a.attrName ? a.attrName().getText() : a.getChild(0).getText();
            const v = a.STRING()   ? a.STRING().getText()
                                   : this.visit(a.shonaExpression());
            kv.push(`${k}: ${v}`);
        }
        const call   = `${rawTag}({ ${kv.join(', ')} })`;
        const parent = this.parentStack.at(-1);
        return parent
            ? `${parent}.appendChild(${call});\n`
            : `const ${elName} = ${call};\n`;
    }

    /* ───────────── native element ───────────── */
    const attrs = ctx.attribute() || [];
    let needsHoist = false;

    /* pre-scan for two-way binding */
    for (const a of attrs) {
        const n = a.attrName ? a.attrName().getText() : '';
        if (n === 'zvanyorwa' || n === 'zvasarudzwa') {
            needsHoist = true;
            this.hoistedVars.add(elName);
            break;
        }
    }

    /* handle every attribute with tracking */
    const attrResults = [];
    for (const a of attrs) {
        const r = this._visitAttributeWithTracking(a, elName);
        attrResults.push(r);

        if (!needsHoist && r.update && r.deps && r.deps.size) {
            needsHoist = true;
            this.hoistedVars.add(elName);
        }
    }

    /* build mount code */
    let code = '';
    code += needsHoist
        ? `${elName} = document.createElement('${tagName}');\n`
        : `const ${elName} = document.createElement('${tagName}');\n`;
    code += `${elName}.setAttribute('data-k', '${key}');\n`;

    for (const r of attrResults) {
        if (r.mount)  code += r.mount;
        if (r.update && r.deps && r.deps.size)
            this._registerUpdateBlock(r.update, r.deps);
    }

    /* auto-id for form controls */
    if (['input','textarea','select'].includes(tagName)) {
        const hasId = attrs.some(a => a.attrName && a.attrName().getText() === 'id');
        if (!hasId) code += `${elName}.id = 'input_${this.elementCounter}';\n`;
    }

    /* append to parent */
    const parent = this.parentStack.at(-1);
    if (parent) code += `${parent}.appendChild(${elName});\n`;

    /* if we’re at root level, push into global mount array */
    if (parent === 'root') this.mountCode.push(code);

    return code;          // returned string is inserted by caller
}

_getAttributeName(ctx) {
    if (!ctx.attrName) return '';
    
    const attrNameCtx = ctx.attrName();
    
    // Handle special keywords
    const specialAttrs = ['EVENT_CLICK', 'EVENT_SUBMIT', 'EVENT_CHANGE', 
                         'CLASS', 'ZVANYORWA', 'IKANYORWA', 'IKASARUDZWA', 'ZVASARUDZWA'];
    
    for (const attr of specialAttrs) {
        if (attrNameCtx[attr] && attrNameCtx[attr]()) {
            return attrNameCtx[attr]().getText();
        }
    }
    
    // Handle ID with potential hyphens
    if (attrNameCtx.ID && attrNameCtx.ID()) {
        const ids = attrNameCtx.ID();
        if (Array.isArray(ids)) {
            return ids.map(id => id.getText()).join('-');
        }
        return ids.getText();
    }
    
    return attrNameCtx.getText();
}

    visitInlineNestedObj(ctx) {
        const objName = ctx.ID().getText();
        const entries = ctx.linearObjectEntries() ? this.visit(ctx.linearObjectEntries()) : "";
        return `${objName}: { ${entries} }`;
    }


    visitPropsDeclaration(ctx) {
        // collect the identifiers
        const names = ctx.ID().map(t => t.getText());

        // mark them as “declared” so later references won’t be auto-‘let’-ed
        names.forEach(n => this.declare(n));

        // if we are building a component, remember them for destructuring
        if (this.target === 'component') {
            names.forEach(n => { if (!this.componentProps.includes(n)) this.componentProps.push(n); });
        }
        return '';                      // <- generates no JS by itself
    }

    visitZvanyorwaVar(ctx) {
        return 'zvanyorwa';
    }

    /** Handle every HTML attribute (events, bindings, …) */
    visitAttribute(ctx, elName) {
        // const attrName = ctx.attrName ? ctx.attrName().getText() : '';
          const attrName = this._getAttributeName(ctx);  

        // EVENT HANDLERS
        const eventMap = {
            rikasubmitwa: 'submit',
            rikabayiwa: 'click',
            rakabayiwa: 'click',
            rikapresswa: 'keypress',
            rakapresswa: 'keypress',
            ikachinjwa: 'change',
            ikanyorwa: 'input',
            ikasarudzwa: 'change'
        };

        if (eventMap[attrName]) {
            const jsHandler = this.visit(ctx.shonaExpression());
            const domEvent = eventMap[attrName];

            if (attrName === 'ikanyorwa') {
                return `$$listen(${elName}, '${domEvent}', e => {
                zvanyorwa = e.target.value;
                (${jsHandler})(e);
            });\n`;
            }

            // return `$$listen(${elName}, '${domEvent}', ${jsHandler});\n`;
        const cleanHandler = jsHandler.replace(/^\$\$state\./, '');
return `$$listen(${elName}, '${domEvent}', ${cleanHandler});\n`;
        }

        // TWO-WAY BINDINGS - these now work through reactive setters
        if (attrName === 'zvanyorwa') {
            const bindExpr = this.visit(ctx.shonaExpression());
            let code = `$$setAttribute(${elName}, 'value', ${bindExpr});\n`;
            code += `$$listen(${elName}, 'input', e => {
            const zvanyorwa = e.target.value;
            ${bindExpr} = zvanyorwa;
        });\n`;
            return code;
        }

        if (attrName === 'zvasarudzwa') {
            const bindExpr = this.visit(ctx.shonaExpression());
            let code = `$$setAttribute(${elName}, 'value', ${bindExpr});\n`;
            code += `$$listen(${elName}, 'change', e => {
            ${bindExpr} = e.target.value;
        });\n`;
            return code;
        }

        // NORMAL ATTRIBUTE
        let realAttr = attrName === 'className' ? 'class' : attrName;
        const value = ctx.STRING()
            ? ctx.STRING().getText()
            : this.visit(ctx.shonaExpression());

        return `$$setAttribute(${elName}, '${realAttr}', ${value});\n`;
    }


    visitHtmlContent(ctx) {
        const elements = ctx.htmlContentElement() || [];
        const results = [];

        for (let i = 0; i < elements.length; i++) {
            const element = elements[i];
            const result = this.visitHtmlContentElement(element);

            if (result) {
                // Result is now always a string (mount code)
                results.push(result);

                // Spacing logic
                if (i + 1 < elements.length) {
                    const nextElement = elements[i + 1];

                    if (element.htmlText && element.htmlText() &&
                        nextElement.shonaExpression && nextElement.shonaExpression()) {
                        const parent = this.parentStack.at(-1);
                        results.push(`${parent}.appendChild($$createText(' '));\n`);
                    }

                    if (element.shonaExpression && element.shonaExpression() &&
                        nextElement.shonaExpression && nextElement.shonaExpression()) {
                        const parent = this.parentStack.at(-1);
                        results.push(`${parent}.appendChild($$createText(' '));\n`);
                    }

                    if (element.shonaExpression && element.shonaExpression() &&
                        nextElement.htmlText && nextElement.htmlText()) {
                        const nextTextCtx = nextElement.htmlText();
                        const start = nextTextCtx.start.start;
                        const stop = nextTextCtx.stop.stop;
                        const inputStream = nextTextCtx.start.getInputStream();
                        const nextText = inputStream.getText(start, stop);

                        const punctuation = /^[\s,;:.!?)`}\]]/;

                        if (nextText && !nextText.match(punctuation)) {
                            const parent = this.parentStack.at(-1);
                            results.push(`${parent}.appendChild($$createText(' '));\n`);
                        }
                    }
                }
            }
        }

        // Return concatenated string, not joined with \n (already has \n in each piece)
        return results.filter(Boolean).join('');
    }

    visitHtmlConditionalStatement(ctx) {
        const condition = this.visit(ctx.expression(0));
        const cleanCondition = condition.startsWith('(') && condition.endsWith(')')
            ? condition.slice(1, -1)
            : condition;

        let code = `if (${cleanCondition}) {\n`;
        this.enterScope();

        // Process HTML content inside the braces
        const content = this.visit(ctx.htmlContent());
        code += content;

        this.leaveScope();
        code += '\n' + this.getIndent() + '}';

        // Handle else-if branches
        const elseIfs = ctx.KUTI() || [];
        for (let i = 0; i < elseIfs.length; i++) {
            const elseIfCondition = this.visit(ctx.expression(i + 1));
            const cleanElseIfCond = elseIfCondition.startsWith('(') && elseIfCondition.endsWith(')')
                ? elseIfCondition.slice(1, -1)
                : elseIfCondition;

            code += ` else if (${cleanElseIfCond}) {\n`;
            this.enterScope();
            code += this.visit(ctx.htmlContent(i + 1));
            this.leaveScope();
            code += '\n' + this.getIndent() + '}';
        }

        // Handle else branch
        if (ctx.ZVIMWE()) {
            code += ` else {\n`;
            this.enterScope();
            code += this.visit(ctx.htmlContent().at(-1));
            this.leaveScope();
            code += '\n' + this.getIndent() + '}';
        }

        return code;
    }

    visitHtmlLoopStatement(ctx) {
        const item = ctx.ID().getText();
        const collection = this.visit(ctx.expression());

        this.loopDepth++;
        this.enterScope();
        this.declare(item);

        let code = `for (let ${item} of ${collection}) {\n`;

        // Process HTML content inside the braces
        const content = this.visit(ctx.htmlContent());
        code += content;

        code += this.getIndent() + "}";

        this.leaveScope();
        this.loopDepth--;

        return code;
    }


    _generateReactiveWrapper(varName) {
        return `
let _${varName};
Object.defineProperty(_state, '${varName}', {
    get() { return _${varName}; },
    set(value) { 
        if (_${varName} !== value) {
            _${varName} = value; 
            _invalidate('${varName}'); 
        }
    }
});`;
    }

    visitHtmlContentElement(ctx) {
        // 1. Control flow ONLY from inside {}
        if (ctx.shonaControlFlow && ctx.shonaControlFlow()) {
            return this.visit(ctx.shonaControlFlow());
        }

        // 2. Expression inside {}
        if (ctx.shonaExpression && ctx.shonaExpression()) {
            this._startTrackingDeps();
            const expr = this.visit(ctx.shonaExpression().expression());
            const deps = this._finishTrackingDeps();

            const parent = this.parentStack.at(-1);
            const textName = `text${this.textNodeCounter++}`;
            this.hoistedVars.add(textName);

            // Mount code - DON'T push to this.mountCode, return it instead
            const mountCode = `${textName} = $$createText(${expr});\n` +
                `${parent}.appendChild(${textName});\n`;

            // Update block
            if (deps && deps.size > 0) {
                const dirtyChecks = [...deps].map(d => `$$dirty.${d}`).join(' || ');
                const updateCode = `if (${dirtyChecks}) {
                ${textName}.data = ${expr};
            }`;
                this._registerUpdateBlock(updateCode, deps);
            }

            // Return mount code for parent to include
            return mountCode;
        }

        // 3. Nested HTML element
        if (ctx.htmlElement && ctx.htmlElement()) {
            const result = this.visit(ctx.htmlElement());
            // If it's an object with .mount, extract the mount code
            return result && typeof result === 'object' && result.mount ? result.mount : result;
        }

        // 4. Whitespace
        if (ctx.WS_IN_HTML && ctx.WS_IN_HTML()) {
            const parent = this.parentStack.at(-1);
            return `${parent}.appendChild($$createText(' '));\n`;
        }

        // 5. HTML text - get the complete text with spaces
        if (ctx.htmlText && ctx.htmlText()) {
            const text = this.visit(ctx.htmlText());

            if (text) {
                const parent = this.parentStack.at(-1);
                const escaped = text
                    .replace(/\\/g, '\\\\')
                    .replace(/`/g, '\\`')
                    .replace(/\$/g, '\\$');

                return `${parent}.appendChild($$createText(\`${escaped}\`));\n`;
            }
        }

        return '';
    }

    visitHtmlText(ctx) {
        // Get the full text span including spaces
        const start = ctx.start.start;
        const stop = ctx.stop.stop;
        const inputStream = ctx.start.getInputStream();
        const fullText = inputStream.getText(start, stop);

        return fullText;
    }

    visitShonaControlFlow(ctx) {
        // The control flow statement is inside the braces
        if (ctx.conditionalInHtml && ctx.conditionalInHtml()) {
            return this.visit(ctx.conditionalInHtml());
        }
        if (ctx.loopInHtml && ctx.loopInHtml()) {
            return this.visit(ctx.loopInHtml());
        }
        if (ctx.whileInHtml && ctx.whileInHtml()) {
            return this.visit(ctx.whileInHtml());
        }
        return '';
    }

    visitConditionalInHtml(ctx) {
        const anchorName = `anchor${this.elementCounter++}`;
        const blockName = `if_block${this.elementCounter++}`;

        this._startTrackingDeps();
        const condition = this.visit(ctx.expression(0));
        const deps = this._finishTrackingDeps();

        // Mount
        const mountCode = `
    const ${anchorName} = document.createComment('if');
    ${this.parentStack.at(-1)}.appendChild(${anchorName});
    let ${blockName} = null;
    `;

        this.mountCode.push(mountCode);

        // Update function
        const dirtyChecks = [...deps].map(d => `$$dirty.${d}`).join(' || ');  // ← Fixed

        // Generate the true branch
        this.parentStack.push(anchorName + '.parentNode');
        const trueContent = this.visit(ctx.htmlContentUntilKeyword(0));
        this.parentStack.pop();

        const updateCode = `
    if (${dirtyChecks}) {
        if (${condition}) {
            if (!${blockName}) {
                ${blockName} = document.createDocumentFragment();
                ${trueContent.mount}
                ${anchorName}.parentNode.insertBefore(${blockName}, ${anchorName});
            }
        } else {
            if (${blockName}) {
                ${blockName}.remove();
                ${blockName} = null;
            }
        }
    }`;

        this._registerUpdateBlock(updateCode, deps);

        return { mount: mountCode };
    }


    visitHtmlContentUntilKeyword(ctx) {
        const parts = ctx.htmlContentPart() || [];
        return parts.map(part => this.visit(part)).filter(Boolean).join('\n');
    }

    visitHtmlContentToEnd(ctx) {
        const parts = ctx.htmlContentPart() || [];
        return parts.map(part => this.visit(part)).filter(Boolean).join('\n');
    }

    visitHtmlContentPart(ctx) {
        if (ctx.htmlElement && ctx.htmlElement()) {
            return this.visit(ctx.htmlElement());
        }
        if (ctx.shonaExpression && ctx.shonaExpression()) {
            const expr = this.visit(ctx.shonaExpression().expression());
            const parent = this.parentStack.at(-1);
            return `${parent}.appendChild($$createText(${expr}));`;
        }
        if (ctx.htmlTextNotKeyword && ctx.htmlTextNotKeyword()) {
            const start = ctx.htmlTextNotKeyword().start.start;
            const stop = ctx.htmlTextNotKeyword().stop.stop;
            const inputStream = ctx.htmlTextNotKeyword().start.getInputStream();
            const raw = inputStream.getText(start, stop);

            const parent = this.parentStack.at(-1);
            const tagName = this.tagStack.at(-1);
            const insideStyle = tagName === 'style';

            return this._emitInterpolatedText(raw, parent, insideStyle);
        }
        // Handle nested control flow
        if (ctx.getChildCount() === 1) {
            const child = ctx.getChild(0);
            if (child.getText().startsWith('{')) {
                return this.visit(child.getChild(1)); // Visit the content inside braces
            }
        }
        return '';
    }

    visitLoopInHtml(ctx) {
        const item = ctx.ID().getText();
        const collectionExpr = this.visit(ctx.expression());
        const anchorName = `each_anchor${this.elementCounter++}`;
        const blocksName = `each_blocks${this.elementCounter++}`;

        this._startTrackingDeps();
        ctx.expression().accept(this);
        const deps = this._finishTrackingDeps();

        // Mount
        const mountCode = `
    const ${anchorName} = document.createComment('each');
    ${this.parentStack.at(-1)}.appendChild(${anchorName});
    const ${blocksName} = [];
    `;

        this.mountCode.push(mountCode);

        // Generate item template function
        this.parentStack.push('fragment');
        const itemContent = this.visit(ctx.htmlContentToEnd());
        this.parentStack.pop();

        const createItemFn = `
    function _create_${blocksName}_item(${item}) {
        const fragment = document.createDocumentFragment();
        ${itemContent.mount}
        return fragment;
    }`;

        this.mountCode.push(createItemFn);

        // Update function
        const dirtyChecks = [...deps].map(d => `$$dirty.${d}`).join(' || ');  // ← Fixed
        const updateCode = `
    if (${dirtyChecks}) {
        const items = ${collectionExpr};
        
        // Remove excess blocks
        while (${blocksName}.length > items.length) {
            ${blocksName}.pop().remove();
        }
        
        // Update/create blocks
        items.forEach((${item}, i) => {
            if (i >= ${blocksName}.length) {
                const block = _create_${blocksName}_item(${item});
                ${blocksName}.push(block);
                ${anchorName}.parentNode.insertBefore(block, ${anchorName});
            }
        });
    }`;

        this._registerUpdateBlock(updateCode, deps);

        return { mount: mountCode };
    }

    visitWhileInHtml(ctx) {
        const condition = this.visit(ctx.expression());
        const cleanCondition = condition.startsWith('(') && condition.endsWith(')')
            ? condition.slice(1, -1)
            : condition;

        this.loopDepth++;
        this.enterScope();

        let code = `while (${cleanCondition}) {\n`;

        // Visit htmlContentToEnd instead of htmlSuite
        if (ctx.htmlContentToEnd && ctx.htmlContentToEnd()) {
            code += this.visit(ctx.htmlContentToEnd());
        }

        code += this.getIndent() + "}";

        this.leaveScope();
        this.loopDepth--;

        return this.removeTrailingCommas(code);
    }

    visitHtmlSuite(ctx) {
        if (ctx.htmlContent && ctx.htmlContent()) {
            return this.visit(ctx.htmlContent());
        }
        return '';
    }

    visitHtmlBlockSuite(ctx) {
        return this.visit(ctx.htmlContent());
    }

    visitHtmlIndentedSuite(ctx) {
        this.indentLevel++;
        const content = this.visit(ctx.htmlContent());
        this.indentLevel--;
        return content;
    }
    visitShonaExpression(ctx) {
        return this.visit(ctx.expression());
    }

    visitShonaBlock(ctx) {
        return this.visit(ctx.expression());
    }

    /* =============================================
    =            DATA STRUCTURES                  =
    ============================================= */

    visitLinearObjectDefinition(ctx) {
        const objName = ctx.ID().getText();
        let decl = "";
        if (!this.isDeclared(objName)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1) decl = "";
            else decl = "let ";
            this.declare(objName);
        }

        const body = this.visit(ctx.linearObjectBody());
        return `${decl}${objName} = ${body}`;
    }

    visitInlineObjectBody(ctx) {
        const entries = this.visit(ctx.linearObjectEntries());
        return `{ ${entries} }`;
    }

    visitBlockObjectBody(ctx) {
        const entries = ctx.objectEntries() ? this.visit(ctx.objectEntries()) : "";
        return `{\n${this.getIndent()}    ${entries}\n${this.getIndent()}}`;
    }

    visitPowerExpression(ctx) {
        // 1 child → just forward to unary level
        if (ctx.getChildCount() === 1) {
            return this.visit(ctx.unaryExpression());
        }

        // form is  unaryExpression '**' powerExpression
        const left = this.visit(ctx.unaryExpression());
        const right = this.visit(ctx.powerExpression());   //  recurse (right-assoc)
        return `(${left} ** ${right})`;
    }

    visitObjectEntries(ctx) {
        const entries = [];
        // Collect all object entries
        if (ctx.objectEntry()) {
            for (const entry of ctx.objectEntry()) {
                const result = this.visit(entry);
                if (result) entries.push(result);
            }
        }

        return entries.join(",\n" + this.getIndent() + "    ");
    }


    visitLinearObjectEntries(ctx) {
        return ctx.linearObjectEntry().map(e => this.visit(e)).join(', ');
    }

    visitEmptyNestedObj(ctx) {
        return `${ctx.ID().getText()}: { }`;
    }

    visitLinearObjectEntry(ctx) {
        // Handle property assignments
        if (ctx.ID() && ctx.expression && ctx.expression()) {
            const prop = ctx.ID().getText();
            const value = this.visit(ctx.expression());
            return `${prop}: ${value}`;
        }

        // Handle nested objects (NEW)
        if (ctx.ID() && ctx.linearObjectBody && ctx.linearObjectBody()) {
            const prop = ctx.ID().getText();
            const nestedObj = this.visit(ctx.linearObjectBody());
            return `${prop}: ${nestedObj}`;
        }

        // Handle inline functions
        if (ctx.FUNCTION || ctx.BASA) {
            const funcName = ctx.ID(0).getText();
            const params = ctx.parameterList() ?
                ctx.parameterList().ID().map(t => t.getText()).join(', ') : '';
            const body = this.visit(ctx.expression());
            return `${funcName}: function(${params}) { return ${body}; }`;
        }

        return '';
    }


    visitObjectDefinition(ctx) {
        const objName = ctx.ID().getText();
        let decl = "";
        if (!this.isDeclared(objName)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1) decl = "";
            else decl = "let ";
            this.declare(objName);
        }

        const propNames = new Set(
            ctx.objectEntry().map(e => e.ID(0).getText())
        );

        // Track the current object name
        const previousObjectName = this.currentObjectName;
        this.currentObjectName = objName;
        this.objectPropsStack.push(propNames);

        const entries = ctx.objectEntry()
            .map(e => this.visit(e))
            .filter(Boolean)
            .join(",\n" + this.getIndent());

        this.objectPropsStack.pop();
        this.currentObjectName = previousObjectName;

        let text = `${decl}${objName} = {\n${this.getIndent()}${entries}\n${this.getIndent()}};`;
        return this.removeTrailingCommas(text);
    }


    visitObjValue(ctx) {
        const prop = ctx.ID().getText();
        const value = this.visit(ctx.expression());
        return `${prop}: ${value}`;
    }

    visitNestedObj(ctx) {
        const objName = ctx.ID().getText();
        const entries = ctx.objectEntries() ? this.visit(ctx.objectEntries()) : "";
        return `${objName}: {\n${this.getIndent()}        ${entries}\n${this.getIndent()}    }`;
    }

    visitObjMethod(ctx) {
        const isAsync = this.containsFetch(ctx.suite());
        const asyncKeyword = isAsync ? "async " : "";
        const methodName = ctx.ID(0).getText();
        const previousFn = this.currentFunction;
        this.currentFunction = methodName;

        this.enterScope();
        const params = ctx.parameterList() ? ctx.parameterList().ID().map(t => t.getText()) : [];
        params.forEach(p => this.declare(p));
        const paramList = params.join(", ");

        let bodyCode = this.visit(ctx.suite());

        // Add _runEffects() if the method mutates state
        if (this.target === 'component') {
            const needsEffects = /(\+\+|--|[^=!<>]=(?!=)|\.push\(|\.pop\(|\.shift\(|\.unshift\(|\.splice\(|delete\b)/s.test(bodyCode);
            if (needsEffects) {
                bodyCode += `${this.getIndent()}    _runEffects();\n`;
            }
        }

        let body = `${methodName}: ${asyncKeyword}function(${paramList}) {\n${bodyCode}${this.getIndent()}    }`;

        this.leaveScope();
        this.currentFunction = previousFn;
        return this.removeTrailingCommas(body);
    }
    visitArrayAdd(ctx) {
        const value = this.visit(ctx.expression(0));  // The value to add
        const target = this.visit(ctx.expression(1));  // The target array/expression
        return `${target}.push(${value})`;
    }

    visitArrayRemove(ctx) {
        const array = ctx.ID().getText();
        const val = this.visit(ctx.expression());
        return `${array} = ${array}.filter(_x => _x !== ${val})`;
    }

    /* =============================================
    =            SET OPERATIONS                   =
    ============================================= */

    visitNewSet(ctx) {
        const varName = ctx.ID().getText();
        const elements = ctx.arrayElements()
            ? this.visit(ctx.arrayElements())
            : "";

        let decl = "";
        if (!this.isDeclared(varName)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1) decl = "";
            else decl = "let ";
            this.declare(varName);
        }

        return `${decl}${varName} = [...new Set([${elements}])]`;
    }

    visitArrayToSet(ctx) {
        const varName = ctx.ID(0).getText();
        const sourceArray = ctx.ID(1).getText();

        let decl = "";
        if (!this.isDeclared(varName)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1) decl = "";
            else decl = "let ";
            this.declare(varName);
        }

        return `${decl}${varName} = [...new Set(${sourceArray})]`;
    }

    visitExprToSet(ctx) {
        const varName = ctx.ID().getText();
        const expr = this.visit(ctx.primaryExpression());

        let decl = "";
        if (!this.isDeclared(varName)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1) decl = "";
            else decl = "let ";
            this.declare(varName);
        }

        return `${decl}${varName} = [...new Set(${expr})]`;
    }

    /* =============================================
    =            SORT & FILTER                    =
    ============================================= */

    visitDefaultSort(ctx) {
        const varName = ctx.ID().getText();
        return `${varName}.sort((a, b) => {
        if (typeof a === 'number' && typeof b === 'number') return a - b;
        return String(a).localeCompare(String(b));
    })`;
    }

    visitDescendingSort(ctx) {
        const varName = ctx.ID().getText();
        return `${varName}.sort((a, b) => b - a)`;
    }

    visitAscendingSort(ctx) {
        const varName = ctx.ID().getText();
        return `${varName}.sort((a, b) => a - b)`;
    }

    visitObjectDescSort(ctx) {
        const varName = ctx.ID(0).getText();
        const prop = ctx.ID(1).getText();
        return `${varName}.sort((a, b) => b.${prop} - a.${prop})`;
    }

    visitObjectAscSort(ctx) {
        const varName = ctx.ID(0).getText();
        const prop = ctx.ID(1).getText();
        return `${varName}.sort((a, b) => a.${prop} - b.${prop})`;
    }

    visitObjectFilter(ctx) {
        const varName = ctx.ID(0).getText();
        const prop = ctx.ID(1).getText();
        const op = ctx.comparisonOperator().getText();
        const value = this.visit(ctx.expression());

        let comparison;
        // INVERTED logic - we're REMOVING items that match, so we KEEP items that DON'T match
        switch (op) {
            case '>': comparison = `x.${prop} <= ${value}`; break;
            case '<': comparison = `x.${prop} >= ${value}`; break;
            case '>=': comparison = `x.${prop} < ${value}`; break;
            case '<=': comparison = `x.${prop} > ${value}`; break;
            case '==': comparison = `x.${prop} !== ${value}`; break;
            case '!=': comparison = `x.${prop} === ${value}`; break;
            default: comparison = `x.${prop} !== ${value}`;
        }

        return `${varName} = ${varName}.filter(x => ${comparison})`;
    }

    visitNounClassFilter(ctx) {
        const varName = ctx.ID(1).getText();
        const prop = ctx.ID(0).getText();
        const op = ctx.comparisonOperator().getText();
        const value = this.visit(ctx.expression());

        // Check if this is filtering primitives (when prop is a noun class prefix)
        const isNounClass = ['ane', 'vane', 'rine', 'chine', 'zvine', 'dzine', 'kune', 'svine'].includes(prop);

        if (isNounClass) {
            // For primitives, ignore the noun class and filter directly
            let comparison;
            // INVERTED logic for "bvisa" (remove)
            switch (op) {
                case '>': comparison = `x <= ${value}`; break;
                case '<': comparison = `x >= ${value}`; break;
                case '>=': comparison = `x < ${value}`; break;
                case '<=': comparison = `x > ${value}`; break;
                case '==': comparison = `x !== ${value}`; break;
                case '!=': comparison = `x === ${value}`; break;
                default: comparison = `x !== ${value}`;
            }
            return `${varName} = ${varName}.filter(x => ${comparison})`;
        } else {
            // For objects with properties
            let comparison;
            // INVERTED logic
            switch (op) {
                case '>': comparison = `x.${prop} <= ${value}`; break;
                case '<': comparison = `x.${prop} >= ${value}`; break;
                case '>=': comparison = `x.${prop} < ${value}`; break;
                case '<=': comparison = `x.${prop} > ${value}`; break;
                case '==': comparison = `x.${prop} !== ${value}`; break;
                case '!=': comparison = `x.${prop} === ${value}`; break;
                default: comparison = `x.${prop} !== ${value}`;
            }
            return `${varName} = ${varName}.filter(x => ${comparison})`;
        }
    }

    /* =============================================
    =            DOM & EVENTS                     =
    ============================================= */

    visitEventListenerStatement(ctx) {
        const tagName = ctx.domSelector().ID(0).getText();
        const selectorId = ctx.domSelector().ID(1).getText();
        const selector = `'${tagName}#${selectorId}'`;

        let eventType = '';
        let callbackParams = '()';
        let preventDefault = '';
        const previousEvent = this.currentEvent;

        if (ctx.EVENT_CLICK()) {
            eventType = 'click';
            this.currentEvent = { type: 'click' };
        } else if (ctx.EVENT_SUBMIT()) {
            eventType = 'submit';
            callbackParams = '(event)';
            preventDefault = this.getIndent() + '    ' + 'event.preventDefault();\n';
            this.currentEvent = { type: 'submit' };
        }

        this.enterScope();
        if (this.currentEvent?.type === 'submit') {
            this.declare('mavalues');
            this.declare('zvanyorwa');
        }
        const bodyCode = this.visit(ctx.suite());
        this.leaveScope();

        this.currentEvent = previousEvent;
        const innerCode = this.removeTrailingCommas(preventDefault + bodyCode);

        return `document.querySelector(${selector})?.addEventListener('${eventType}', ${callbackParams} => {\n${innerCode}${this.getIndent()}});`;
    }

    visitClassStatement(ctx) {
        const action = ctx.ISA() ? 'add' : 'remove';
        const classNameWithQuotes = ctx.STRING().getText();
        const className = classNameWithQuotes.substring(1, classNameWithQuotes.length - 1);
        const tagName = ctx.domSelector().ID(0).getText();
        const selectorId = ctx.domSelector().ID(1).getText();
        const selector = `'${tagName}#${selectorId}'`;
        return `document.querySelector(${selector})?.classList.${action}('${className}')`;
    }

    _getDomPropertyString(ctx) {
        const prop = ctx.ID().getText();
        const domSelectorCtx = ctx.domSelector();
        const tagName = domSelectorCtx.ID(0).getText();
        const selectorName = domSelectorCtx.ID(1).getText();
        const elementRef = `document.querySelector('${tagName}#${selectorName}')`;

        if (prop === 'mavalues' || prop === 'zvanyorwa') {
            return `Object.fromEntries(new FormData(${elementRef}).entries())`;
        }

        if (this.styleProps.has(prop)) {
            return `${elementRef}.style.${prop}`;
        } else {
            return `${elementRef}.${prop}`;
        }
    }

    visitDomPropertyGet(ctx) {
        return this._getDomPropertyString(ctx.domPropertyRef());
    }

    /* =============================================
    =            IMPORTS & NETWORKING             =
    ============================================= */

    visitDefaultAndNamedImport(ctx) {
        const defaultImport = ctx.ID().getText();
        const namedImports = new Set();
        if (ctx.idList()) {
            ctx.idList().ID().forEach(id => namedImports.add(id.getText()));
        }
        return { default: defaultImport, named: namedImports };
    }

    visitNamedOnlyImport(ctx) {
        const namedImports = new Set();
        ctx.idList().ID().forEach(id => namedImports.add(id.getText()));
        return { default: null, named: namedImports };
    }

    visitImportStatement(ctx) {
        const modulePath = ctx.modulePath().getText();

        // Visit the specifier, which will return a structured object like:
        // { default: 'confetti' | null, named: Set('faker') }
        const importData = this.visit(ctx.importSpecifier());

        // For components, we collect all imports and generate them at the top.
        if (this.target === 'component') {
            // If we haven't seen this module path before, initialize it.
            if (!this.componentImports.has(modulePath)) {
                this.componentImports.set(modulePath, { default: null, named: new Set() });
            }

            // Get the collection of imports for this module path.
            const existing = this.componentImports.get(modulePath);

            // Merge the newly found imports into the existing collection.
            if (importData.default) {
                if (existing.default && existing.default !== importData.default) {
                    throw new Error(`Cannot import multiple different default members from module "${modulePath}".`);
                }
                existing.default = importData.default;
            }

            importData.named.forEach(name => existing.named.add(name));

            // This statement itself doesn't generate code directly.
            return '';
        }

        // --- Fallback for non-component targets (e.g., plain .shona scripts) ---
        // This logic generates immediate import statements for Node.js or warns for browser.
        if (this.target === 'node') {
            const parts = [];
            if (importData.default) parts.push(importData.default);
            if (importData.named.size > 0) parts.push(`{ ${[...importData.named].join(', ')} }`);

            return `import ${parts.join(', ')} from "${modulePath.replace(/'/g, '')}";`;
        }

        console.warn(`Warning: 'tora' statements are ignored in standard browser script target.`);
        return `// Import from ${modulePath} ignored`;
    }

    visitFetchStatement(ctx) {
        const varName = ctx.ID(0).getText();
        const urlSource = ctx.STRING() ? ctx.STRING().getText() : ctx.ID(1).getText();
        let decl = "";
        if (!this.isDeclared(varName)) {
            if (this.inAsyncWrapper && this.scopeStack.length === 1) decl = "";
            else decl = "let ";
            this.declare(varName);
        }
        const fetchCode = `await fetch(${urlSource})
${this.getIndent()}        .then(res => res.ok ? res.json() : Promise.reject(res.statusText))
${this.getIndent()}        .catch(err => { console.error('Kukanganisa paku tambira data kubva ku ${urlSource}:', err); return null; })`;
        return `${decl}${varName} = ${fetchCode}`;
    }

    visitFetchExpr(ctx) {
        const url = ctx.STRING() ? ctx.STRING().getText() : ctx.ID(1).getText();

        if (this.scopeStack.length === 1 && this.target === 'node')
            this.inAsyncWrapper = true;

        return `await fetch(${url})
${this.getIndent()}    .then(res => res.ok ? res.json() : Promise.reject(res.statusText))
${this.getIndent()}    .catch(err => { console.error('Kukanganisa paku tambira data kubva ku ${url}:', err); return null; })`;
    }

    /* =============================================
    =            TIMERS                           =
    ============================================= */

    visitIntervalStatement(ctx) {
        let callbackCode = this.visit(ctx.primaryExpression());
        if (/^\s*\w+\s*\(\s*\)\s*$/.test(callbackCode)) {           //  "foo()"
            callbackCode = callbackCode.replace(/\(\s*\)$/, '');    //  -> "foo"
        }
        const timeValue = this.visit(ctx.expression());
        const milliseconds = `(${timeValue}) * 1000`;
        return `setInterval(${callbackCode}, ${milliseconds})`;
    }

    visitTimeoutStatement(ctx) {
        const callbackExpr = ctx.primaryExpression();
        let callbackCode = this.visit(callbackExpr);

        // If the callback is a function call like showMessage(), extract just the function name
        if (callbackExpr.functionCall && callbackExpr.functionCall()) {
            const funcName = callbackExpr.functionCall().ID().getText();
            const args = callbackExpr.functionCall().argumentList();
            if (!args || !args.expression || args.expression().length === 0) {
                // No arguments, just use the function name
                callbackCode = funcName;
            }
        } else {
            // Fallback to regex approach
            if (/^\s*\w+\s*\(\s*\)\s*$/.test(callbackCode)) {
                callbackCode = callbackCode.replace(/\(\s*\)$/, '');
            }
        }

        const timeValue = this.visit(ctx.expression());
        const milliseconds = `(${timeValue}) * 1000`;
        return `setTimeout(${callbackCode}, ${milliseconds})`;
    }

    visitIntervalExpr(ctx) {
        const callbackExpr = ctx.primaryExpression();
        let callbackCode = this.visit(callbackExpr);

        // If the callback is a function call like showMessage(), extract just the function name
        if (callbackExpr.functionCall && callbackExpr.functionCall()) {
            const funcName = callbackExpr.functionCall().ID().getText();
            const args = callbackExpr.functionCall().argumentList();
            if (!args || !args.expression || args.expression().length === 0) {
                // No arguments, just use the function name
                callbackCode = funcName;
            }
        } else {
            // Fallback to regex approach
            if (/^\s*\w+\s*\(\s*\)\s*$/.test(callbackCode)) {
                callbackCode = callbackCode.replace(/\(\s*\)$/, '');
            }
        }

        const timeValue = this.visit(ctx.expression());
        const milliseconds = `(${timeValue}) * 1000`;
        return `setInterval(${callbackCode}, ${milliseconds})`;
    }
    visitTimeoutExpr(ctx) {
        const callbackExpr = ctx.primaryExpression();
        let callbackCode = this.visit(callbackExpr);

        // If the callback is a function call like showMessage(), extract just the function name
        if (callbackExpr.functionCall && callbackExpr.functionCall()) {
            const funcName = callbackExpr.functionCall().ID().getText();
            const args = callbackExpr.functionCall().argumentList();
            if (!args || !args.expression || args.expression().length === 0) {
                // No arguments, just use the function name
                callbackCode = funcName;
            }
        } else {
            // Fallback to regex approach
            if (/^\s*\w+\s*\(\s*\)\s*$/.test(callbackCode)) {
                callbackCode = callbackCode.replace(/\(\s*\)$/, '');
            }
        }

        const timeValue = this.visit(ctx.expression());
        const milliseconds = `(${timeValue}) * 1000`;
        return `setTimeout(${callbackCode}, ${milliseconds})`;
    }

    /* =============================================
    =            PROPERTIES                       =
    ============================================= */


    visitPropertyDelete(ctx) {
        const fullChain = this._getPropertyRefString(ctx.propertyRef());
        return `delete ${fullChain}`;
    }


    visitPropertyGet(ctx) {
        return this._getPropertyRefString(ctx.propertyRef());
    }

    visitPropertyAccess(ctx) {
        const ids = ctx.ID().map(id => id.getText());
        return ids.join('.');
    }

    /* =============================================
    =            EXPRESSIONS                      =
    ============================================= */


    visitExpression(ctx) {
        // Don't add semicolons when visiting expressions inside HTML
        if (this.parentStack.length > 1 && this.parentStack[0] === 'root') {
            return this.visit(ctx.conditionalExpression());
        }
        return this.visit(ctx.conditionalExpression());
    }


    visitLogicalOrExpression(ctx) {
        if (ctx.getChildCount() === 1) return this.visit(ctx.getChild(0));

        let result = this.visit(ctx.logicalAndExpression(0));
        for (let i = 1; i < ctx.logicalAndExpression().length; i++) {
            const op = ctx.getChild(i * 2 - 1).getText(); // Gets the operator token
            let jsOp = '||'; // Default for KANA, OR, etc.
            result = `(${result} ${jsOp} ${this.visit(ctx.logicalAndExpression(i))})`;
        }
        return result;
    }




    visitLogicalAndExpression(ctx) {
        if (ctx.getChildCount() === 1) return this.visit(ctx.getChild(0));

        let result = this.visit(ctx.equalityExpression(0));
        for (let i = 1; i < ctx.equalityExpression().length; i++) {
            let jsOp = '&&';
            result = `(${result} ${jsOp} ${this.visit(ctx.equalityExpression(i))})`;
        }
        return result;
    }

    visitEqualityExpression(ctx) {
        if (ctx.getChildCount() === 1) return this.visit(ctx.getChild(0));

        let result = this.visit(ctx.comparisonExpression(0));
        for (let i = 1; i < ctx.comparisonExpression().length; i++) {
            const op = ctx.getChild(i * 2 - 1).getText();
            result = `(${result} ${op} ${this.visit(ctx.comparisonExpression(i))})`;
        }
        return result;
    }

    visitComparisonExpression(ctx) {
        if (ctx.getChildCount() === 1) return this.visit(ctx.getChild(0));

        let result = this.visit(ctx.additiveExpression(0));
        for (let i = 1; i < ctx.additiveExpression().length; i++) {
            const op = ctx.getChild(i * 2 - 1).getText();
            const right = this.visit(ctx.additiveExpression(i));
            result = `${result} ${op} ${right}`;  // Don't wrap in parentheses here
        }
        return result;  // Return without wrapping
    }

    visitAdditiveExpression(ctx) {
        // If there is only one child, it's not an addition.
        if (ctx.multiplicativeExpression().length === 1) {
            return this.visit(ctx.multiplicativeExpression(0));
        }

        // Build the expression chain flatly
        let result = this.visit(ctx.multiplicativeExpression(0));
        for (let i = 1; i < ctx.multiplicativeExpression().length; i++) {
            const op = ctx.getChild(i * 2 - 1).getText(); // Gets the '+' or '-' token
            const rightOperand = this.visit(ctx.multiplicativeExpression(i));
            result += ` ${op} ${rightOperand}`;
        }

        // Wrap the entire final result in parentheses for precedence safety.
        return `(${result})`;
    }

    visitMultiplicativeExpression(ctx) {
        if (ctx.getChildCount() === 1) return this.visit(ctx.getChild(0));

        let result = this.visit(ctx.powerExpression(0));
        for (let i = 1; i < ctx.powerExpression().length; i++) {
            const op = ctx.getChild(i * 2 - 1).getText();
            const right = this.visit(ctx.powerExpression(i));
            result = `${result} ${op} ${right}`;  // Don't wrap in parentheses
        }
        return `(${result})`;
    }

    // visitUnaryExpression(ctx) {
    //     return this.visit(ctx.getChild(0));
    // }

    visitUnaryExpression(ctx) {
    // no operator  → just recurse
    if (ctx.getChildCount() === 1) {
        return this.visit(ctx.getChild(0));
    }

    // operator + operand
    const op   = ctx.getChild(0).getText();   //  '!', '+', '-'
    const expr = this.visit(ctx.getChild(1)); //  the real sub-expression
    return `${op}${expr}`;}

    visitUnaryOp(ctx) {
        const op = ctx.getChild(0).getText();
        const expr = this.visit(ctx.unaryExpression());
        return `${op}${expr}`;
    }

    visitPostfixIncExpr(ctx) {
        const lhs = this._getStateAwareAssignable(ctx.assignable());
        return `${lhs}++`;
    }

    visitPostfixDecExpr(ctx) {
        const lhs = this._getStateAwareAssignable(ctx.assignable());
        return `${lhs}--`;
    }

    visitPrimaryExpr(ctx) {
        return this.visit(ctx.primaryExpression());
    }

    visitPrimaryExpression(ctx) {
        return this.visit(ctx.getChild(0));
    }

    _visitBinary(ctx, operatorMap = {}) {
        if (ctx.getChildCount() === 1) {
            return this.visit(ctx.getChild(0));
        }

        // Start with the text of the first operand
        let result = this.visit(ctx.getChild(0));

        // Append operators and subsequent operands without adding extra parentheses
        for (let i = 1; i < ctx.getChildCount(); i += 2) {
            const opNode = ctx.getChild(i);
            const rightNode = ctx.getChild(i + 1);

            let op = opNode.getText();
            if (operatorMap[op]) {
                op = operatorMap[op];
            }

            const right = this.visit(rightNode);

            // This is the key: build a flat string, don't nest parentheses
            result = `${result} ${op} ${right}`;
        }

        // Wrap the entire flat expression once at the end to ensure correct outer precedence.
        return `(${result})`;
    }

    /* =============================================
    =            ARRAY OPERATIONS                 =
    ============================================= */

    visitArrayLiteral(ctx) {
        const elements = ctx.arrayElements()
            ? this.visit(ctx.arrayElements())
            : "";
        return `[${elements}]`;
    }

    visitArrayElements(ctx) {
        if (!ctx.arrayElement()) return "";
        return ctx.arrayElement().map(e => this.visit(e)).join(', ');
    }

    visitArrayElement(ctx) {
        if (ctx.objectLiteral()) {
            const objectLiteral = ctx.objectLiteral();
            const entries = objectLiteral.linearObjectEntries()
                ? this.visit(objectLiteral.linearObjectEntries())
                : "";
            return `{ ${entries} }`;
        }
        return this.visit(ctx.expression());
    }

    visitArrayRange(ctx) {
        return this.visit(ctx.rangeExpression());
    }

    visitFullRange(ctx) {
        const exprs = ctx.expression();
        const start = this.visit(exprs[0]);
        const second = this.visit(exprs[1]);
        const end = this.visit(exprs[2]);

        const startNum = this._tryParseNumber(start);
        const secondNum = this._tryParseNumber(second);
        const endNum = this._tryParseNumber(end);

        if (startNum !== null && secondNum !== null && endNum !== null) {
            const step = secondNum - startNum;
            const values = [];

            if (step > 0) {
                for (let i = startNum; i <= endNum; i += step) {
                    values.push(i);
                }
            } else if (step < 0) {
                for (let i = startNum; i >= endNum; i += step) {
                    values.push(i);
                }
            } else {
                values.push(startNum);
            }

            return `[${values.join(', ')}]`;
        }

        // For dynamic expressions, generate runtime code
        // Fixed: Added the missing })() at the end
        return `(() => { const _start = ${start}; const _step = ${second} - ${start}; const _end = ${end}; const _arr = []; if (_step > 0) { for (let i = _start; i <= _end; i += _step) _arr.push(i); } else { for (let i = _start; i >= _end; i += _step) _arr.push(i); } return _arr; })()`;
    }

    visitSimpleRange(ctx) {
        const exprs = ctx.expression();
        const start = this.visit(exprs[0]);
        const end = this.visit(exprs[1]);

        const startNum = this._tryParseNumber(start);
        const endNum = this._tryParseNumber(end);

        if (startNum !== null && endNum !== null) {
            const step = startNum <= endNum ? 1 : -1;
            const values = [];

            if (step > 0) {
                for (let i = startNum; i <= endNum; i += step) {
                    values.push(i);
                }
            } else {
                for (let i = startNum; i >= endNum; i += step) {
                    values.push(i);
                }
            }

            return `[${values.join(', ')}]`;
        }

        // For dynamic expressions
        // Make sure this also has the complete })() at the end
        return `(() => { const _start = ${start}; const _end = ${end}; const _step = _start <= _end ? 1 : -1; const _arr = []; if (_step > 0) { for (let i = _start; i <= _end; i += _step) _arr.push(i); } else { for (let i = _start; i >= _end; i += _step) _arr.push(i); } return _arr; })()`;
    }

    _tryParseNumber(str) {
        const match = str.match(/^-?\d+(\.\d+)?$/) || str.match(/^\((-?\d+(\.\d+)?)\)$/);
        if (match) {
            return parseFloat(str.replace(/[()]/g, ''));
        }
        return null;
    }

    /* =============================================
    =            OBJECT LITERALS                  =
    ============================================= */

    visitObjLiteral(ctx) {
        const objectLiteral = ctx.objectLiteral();
        const entries = objectLiteral.linearObjectEntries()
            ? this.visit(objectLiteral.linearObjectEntries())
            : "";
        return `{ ${entries} }`;
    }

    visitJsObjectLiteral(ctx) {
        if (!ctx.jsObjectEntries()) return '{}';
        const entries = this.visit(ctx.jsObjectEntries());
        return `{ ${entries} }`;
    }

    visitJsObjectEntries(ctx) {
        return ctx.jsObjectEntry().map(e => this.visit(e)).join(', ');
    }

    visitJsObjectEntry(ctx) {
        const prop = ctx.ID().getText();
        const value = this.visit(ctx.expression());
        return `${prop}: ${value}`;
    }

    /* =============================================
    =            SPECIAL OPERATIONS               =
    ============================================= */

    visitNaturalEqualityOp(ctx) {
        const left = this.visit(ctx.primaryExpression());
        const right = this.visit(ctx.expression());
        return `(${left} === ${right})`;
    }

    visitNounClassEquality(ctx) {
        const left = this.visit(ctx.primaryExpression(0));
        const right = this.visit(ctx.primaryExpression(1));
        return `(${left} === ${right})`;
    }

    visitNounClassInequality(ctx) {
        const left = this.visit(ctx.primaryExpression(0));
        const right = this.visit(ctx.primaryExpression(1));
        return `(${left} !== ${right})`;
    }

    // visitNounClassExistence(ctx) {
    //     const expr = this.visit(ctx.primaryExpression());
    //     return expr;
    // }

    visitNounClassExistence(ctx) {
        const expr = this.visit(ctx.primaryExpression());
        return `(${expr})`;
    }

    visitNounClassNonExistence(ctx) {
        const expr = this.visit(ctx.primaryExpression());
        return `!${expr}`;
    }

    visitComplexFilter(ctx) {
        const varName = ctx.ID().getText();
        const filterExpr = this.visit(ctx.logicalFilterExpression());

        // Convert the filter expression to keep items that DON'T match (inverted logic for bvisa)
        return `${varName} = ${varName}.filter(x => !(${filterExpr}))`;
    }
    visitLogicalFilterExpression(ctx) {
        const conditions = [];
        const ids = ctx.ID();
        const ops = ctx.comparisonOperator();
        const exprs = ctx.expression();

        for (let i = 0; i < ids.length; i++) {
            const id = ids[i].getText();
            const op = ops[i].getText();
            const expr = this.visit(exprs[i]);

            conditions.push(`x ${op} ${expr}`);
        }

        // Join with the logical operators found in the expression
        let result = conditions[0];
        let opIndex = 0;

        for (let i = 1; i < conditions.length; i++) {
            const logicalOp = this._getLogicalOpBetween(ctx, opIndex);
            result += ` ${logicalOp} ${conditions[i]}`;
            opIndex++;
        }

        return result;
    }

    _getLogicalOpBetween(ctx, index) {
        // Check which logical operator was used
        const text = ctx.getText();
        if (text.includes('kanakuti') || text.includes('kana') || text.includes('or') || text.includes('||')) {
            return '||';
        }
        return '&&';
    }
    visitInArrayOp(ctx) {
        const elem = this.visit(ctx.primaryExpression());
        const collection = this.visit(ctx.expression());
        return `${collection}.includes(${elem})`;
    }

    visitInStringOp(ctx) {
        const sub = this.visit(ctx.primaryExpression());
        const big = ctx.STRING().getText();
        return `${big}.includes(${sub})`;
    }

    visitLengthExpr(ctx) {
        return `(${this.visit(ctx.primaryExpression())}).length`;
    }

    visitJoinExpr(ctx) {
        return `(${this.visit(ctx.primaryExpression())}).join("")`;
    }

    visitIndexOp(ctx) {
        const index = this.visit(ctx.expression());

        if (index.includes('%') && index.endsWith(' + 1)')) {
            const moduloPart = index.slice(0, -5).replace(/^\(/, '').replace(/\)$/, '');

            if (ctx.STRING()) {
                return `${ctx.STRING().getText()}[${moduloPart}]`;
            } else {
                const varName = ctx.ID().getText();
                return `${varName}[${moduloPart}]`;
            }
        }

        if (ctx.STRING()) {
            return `${ctx.STRING().getText()}[(${index}) - 1]`;
        } else {
            const varName = ctx.ID().getText();
            return `${varName}[(${index}) - 1]`;
        }
    }

    visitSetExpr(ctx) {
        const elements = ctx.arrayElements()
            ? this.visit(ctx.arrayElements())
            : "";
        return `[...new Set([${elements}])]`;
    }

    visitVarToSetExpr(ctx) {
        const varName = ctx.ID().getText();
        return `[...new Set(${varName})]`;
    }

    visitExprToSetExpr(ctx) {
        const expr = this.visit(ctx.primaryExpression());
        return `[...new Set(${expr})]`;
    }


    visitMethodCall(ctx) {
        const obj = this.visit(ctx.primaryExpression());
        const args = ctx.argumentList() ? this.visit(ctx.argumentList()) : "";
        return `${obj}(${args})`;
    }

    visitArgumentList(ctx) {
        return ctx.expression().map(expr => this.visit(expr)).join(', ');
    }

    visitDotAccess(ctx) {
        const obj = this.visit(ctx.primaryExpression());
        const prop = ctx.ID().getText();
        return `${obj}.${prop}`;
    }



    visitBracketAccess(ctx) {
        const obj = this.visit(ctx.primaryExpression());
        const key = this.visit(ctx.expression());
        return `${obj}[${key}]`;
    }

    /* =============================================
    =            ATOMS                            =
    ============================================= */

    visitNumber(ctx) {
        return ctx.NUMBER().getText();
    }

    visitBoolean(ctx) {
        return ctx.BOOLEAN().getText() === "chokwadi" ? "true" : "false";
    }

    visitString(ctx) {
        return ctx.STRING().getText();
    }

    visitVariable(ctx) {
        const name = ctx.ID().getText();

        // Record this variable access for dependency tracking (only in component mode)
        if (this.target === 'component' && this.currentDeps) {
            this._recordDep(name);
        }

        if (name === 'zvanyorwa') {
            return 'zvanyorwa';
        }

        if (
            this.objectPropsStack.length &&
            this.currentFunction !== null &&
            this.objectPropsStack.at(-1).has(name)
        ) {
            return `this.${name}`;
        }

        if (this.currentEvent?.type === 'submit' && name === 'mavalues') {
            return 'Object.fromEntries(new FormData(event.target).entries())';
        }

        // In component mode, access state through $$state
        if (this.target === 'component' && this.scopeStack[0]?.has(name)) {
            return `$$state.${name}`;
        }

        return name;
    }

    visitParens(ctx) {
        return this.visit(ctx.expression());
    }

    visitChildren(ctx) {
        return ctx.children ? ctx.children.map(c => c.accept(this)).filter(Boolean).join('') : '';
    }
}