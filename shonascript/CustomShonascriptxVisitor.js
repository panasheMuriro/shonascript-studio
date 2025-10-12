
import antlr4 from 'antlr4';
import ShonascriptxVisitor from './build/ShonascriptxVisitor.js';

export default class CustomShonascriptxVisitor extends ShonascriptxVisitor {
    constructor(options = {}) {
        super();
        this.target = options.target || 'browser';
        this.componentName = options.componentName || 'Component';

        this.effects = [];   // collected effect functions
        this.effectCounter = 0;

        this.textNodeCounter = 0;
         this.componentImports = new Map();


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



    }

    /* =============================================
    =            STATE & HELPER METHODS           =
    ============================================= */


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

    // Replace the visitProgram method with this updated version:
    visitProgram(ctx) {
        const input = ctx.start.getInputStream();
        const fullText = input.getText(0, input.size - 1);

        if (/^\s*\w+\s*=\s*<style\b/im.test(fullText)) {
            throw new Error('style elements cannot be assigned to variables');
        }

        this.computedCode = [];

        const isComponent = this.target === 'component';
        if (isComponent) {
            this.parentStack = ['root'];
            this.elementCounter = 0;
        }
        if (this.target === 'node' && this.containsFetch(ctx))
            this.inAsyncWrapper = true;

        const emittedLines = [];
        const componentVars = [];
        const componentFns = [];
        let rootElement = null;

        // Special handling for style tags at the top level
        if (isComponent && fullText.includes('<style>')) {
            // Extract style content manually from the full text
            const styleMatch = fullText.match(/<style>([\s\S]*?)<\/style>/);
            if (styleMatch) {
                const styleContent = styleMatch[1].trim();
                const styleElName = `el${this.elementCounter++}`;

                const styleCode = `const ${styleElName} = document.createElement('style');\n` +
                    `${styleElName}.textContent = \`${styleContent.replace(/`/g, '\\`').replace(/\$/g, '\\$')}\`;\n` +
                    `document.head.appendChild(${styleElName});\n`;

                emittedLines.push(styleCode);

                // Now process the rest of the content after removing the style tag
                const remainingText = fullText.replace(/<style>[\s\S]*?<\/style>/, '').trim();

                // Parse the remaining content by skipping past the style-related parse errors
                let skipUntilValidElement = false;

                for (const child of ctx.children ?? []) {
                    const childText = child.getText ? child.getText() : '';

                    // Skip the broken style-related parse nodes
                    if (childText.includes('style>') || childText.includes('.redText') ||
                        childText.includes('color:') || childText.includes('red;}') ||
                        childText === '{' || childText === '}' || childText === '<' ||
                        childText === '</' || childText === ':' ||
                        childText.includes('<missing')) {
                        continue;
                    }

                    // Look for the actual HTML content
                    if (childText.includes('<div>') ||
                        (child.constructor.name === 'ProgramElementContext' &&
                            child.htmlElement && child.htmlElement())) {

                        // Found valid HTML element
                        const currentElName = `el${this.elementCounter}`;
                        const code = this.visit(child);
                        if (code) {
                            emittedLines.push(code);
                            if (!rootElement) {
                                rootElement = currentElName;
                            }
                        }
                        continue;
                    }

                    // Process other valid children
                    if (child.symbol?.type === antlr4.Token.EOF ||
                        child.constructor.name === 'ErrorNodeImpl') continue;

                    if (child.constructor.name === 'ProgramElementContext') {
                        if (child.line && child.line()) {
                            const stmt = child.line().statement?.();
                            if (!stmt) continue;

                            if (stmt.simpleStatement?.()?.assignment?.()) {
                                const code = this.visit(stmt);
                                if (code.trim()) componentVars.push(code.replace(/;$/, ''));
                                continue;
                            }

                            if (stmt.compoundStatement?.()?.functionDefinition?.()) {
                                const code = this.visit(stmt.compoundStatement().functionDefinition());
                                if (code.trim()) componentFns.push(code);
                                continue;
                            }
                        }
                    }
                }
            }
        } else {
            // Normal processing for non-style content
            for (const child of ctx.children ?? []) {



                if (child.symbol?.type === antlr4.Token.EOF || child.constructor.name === 'ErrorNodeImpl') continue;

                if (isComponent && child.constructor.name === 'ProgramElementContext') {


                    if (child.reactiveBlock && child.reactiveBlock()) {

                        this.visit(child.reactiveBlock());
                        continue;
                    }

                    if (child.htmlElement && child.htmlElement()) {

                        const currentElName = `el${this.elementCounter}`;
                        const htmlElCtx = child.htmlElement();



                        if (!htmlElCtx.tagName || typeof htmlElCtx.tagName !== 'function') {

                            continue;
                        }
                        const tagName = htmlElCtx.tagName(0).getText().toLowerCase();


                        const code = this.visit(child.htmlElement());
                        if (code) emittedLines.push(code);

                        if (!rootElement && tagName !== 'style') {
                            rootElement = currentElName;
                        }
                        continue;
                    }

                    if (child.line && child.line()) {

                        const stmt = child.line().statement?.();
                        if (!stmt) continue;

                        if (stmt.simpleStatement?.()?.assignment?.()) {
                            const code = this.visit(stmt);
                            if (code.trim()) componentVars.push(code.replace(/;$/, ''));
                            continue;
                        }

                        if (stmt.simpleStatement?.()?.linearObjectDefinition?.()) {
                            const code = this.visit(stmt);
                            if (code.trim()) componentVars.push(code.replace(/;$/, ''));
                            continue;
                        }

                        if (stmt.compoundStatement?.()?.functionDefinition?.()) {
                            const code = this.visit(stmt.compoundStatement().functionDefinition());
                            if (code.trim()) componentFns.push(code);
                            continue;
                        }
                    }
                }

                const code = this.visit(child);

                if (code) emittedLines.push(code);
            }
        }

        const bodyCode = emittedLines.filter(Boolean).join('\n');

        /* ========== 3. helper snippets ========== */
        const helpers = `

function $$createText(data){

    if (data && data.nodeType) return data;
    return document.createTextNode(data);
}
function $$listen(node,e,h){node.addEventListener(e,h);}
function $$setAttribute(n,a,v){
    if(a==='value'||a==='checked'||a==='selected'){n[a]=v;}

    else if (v === false || v === null || v === undefined) { n.removeAttribute(a); }
    else{n.setAttribute(a,v);}
}const _effects = [];
function _runEffects(){ for(const f of _effects) f();}`;

        /* ========== 4. COMPONENT OUTPUT (RE-ARCHITECTURED) ========== */
        if (isComponent) {
   let importStatements = '';
    if (this.componentImports && this.componentImports.size > 0) {
        for (const [path, symbols] of this.componentImports) {
            for (const symbol of symbols) {
                importStatements += `import ${symbol} from '${path}';\n`;
            }
        }
        if (importStatements) {
            importStatements += '\n';  // Add extra newline after imports
        }
    }

            const hasIntervals = bodyCode.includes('setInterval(');
    const hasTimeouts = bodyCode.includes('setTimeout(');
    
    // Separate setup code (intervals/timeouts) from render code
    let setupCode = '';
    let renderBodyCode = bodyCode;
    
    if (hasIntervals || hasTimeouts) {
        // Extract interval/timeout statements from the body
        const lines = bodyCode.split('\n');
        const setupLines = [];
        const renderLines = [];
        
        for (const line of lines) {
            if (line.trim().includes('setInterval(') || line.trim().includes('setTimeout(')) {
                setupLines.push(line);
            } else {
                renderLines.push(line);
            }
        }
        
        setupCode = setupLines.join('\n');
        renderBodyCode = renderLines.join('\n');
    }
            const destructure = this.componentProps.length
                ? `const { ${this.componentProps.join(', ')} } = props;`
                : '';
            const varDecls = componentVars.length
                ? componentVars.map(l => '    ' + l + ';').join('\n')
                : '';
            const fnDecls = componentFns.length
                ? componentFns.map(fn => fn.split('\n').map(l => '    ' + l).join('\n')).join('\n\n')
                : '';

            // Check if zvanyorwa is needed
            const needsZvanyorwa = bodyCode.includes('zvanyorwa');
            const zvanyorwaDecl = needsZvanyorwa ? '    let zvanyorwa;' : '';




            // Indent the DOM creation logic to fit inside the _render function
            // const indentedBody = bodyCode.split('\n').map(l => '        ' + l).join('\n');
    const indentedBody = renderBodyCode.split('\n').map(l => '        ' + l).join('\n');



               return `${importStatements}${helpers}

export default function ${this.componentName}(props = {}) {

    const root = document.createElement('div');

    ${destructure}
${varDecls}
${zvanyorwaDecl}
${fnDecls}

    function _runComputations() {
${this.computedCode.map(line => '        ' + line).join('\n')}
    }

   function _render() {
    /* remember focus */
    const activeElem = root.contains(document.activeElement)
                       ? document.activeElement : null;
    const activeKey  = activeElem ? activeElem.getAttribute('data-k') : null;
    const caretStart = activeElem?.selectionStart ?? null;
    const caretEnd   = activeElem?.selectionEnd   ?? null;

    _runComputations();

    root.innerHTML = '';
${indentedBody}

    /* restore focus */
    if (activeKey) {
        requestAnimationFrame(() => {
            const fresh = root.querySelector('[data-k="'+activeKey+'"]');
            if (fresh && fresh !== document.activeElement) {
                fresh.focus({ preventScroll:true });
                if (caretStart!==null && caretEnd!==null && fresh.setSelectionRange)
                    fresh.setSelectionRange(caretStart, caretEnd);
            }
        });
    }
}

    const _effects = [_render];
    function _runEffects() {
        for (const f of _effects) f();
    }

    _render(); // Initial render call.
    
    // Set up intervals and timeouts after initial render
${setupCode}

    return root;
}`;
}

        /* ========== 5. REGULAR (SCRIPT) OUTPUT (UNCHANGED) ========== */
        let header = '';
        if (this.target === 'node') {
            for (const [mod, symbols] of this.imports)
                header += `import { ${[...symbols].sort().join(', ')} } from "./${mod}.js";\n`;
            if (this.imports.size) header += '\n';
            if (this.promptInjected) header +=
                'import promptSync from "prompt-sync";\n' +
                'const prompt = promptSync({ sigint: true });\n\n';
        }

        const globals = [...this.scopeStack[0].keys()].filter(n => !n.startsWith('_'));
        if (this.inAsyncWrapper && globals.length)
            header += `let ${globals.join(', ')};\n\n`;

        if (this.inAsyncWrapper) {
            const wrapper = `(async () => {\n${bodyCode}\n})();\n`;
            const exports = globals.length && this.target === 'node'
                ? `export { ${globals.join(', ')} };\n` : '';
            return header + helpers + '\n\n' + wrapper + exports;
        }

        if (globals.length && this.target === 'node')
            header += `export { ${globals.join(', ')} };\n\n`;

        return header + helpers + '\n\n(function(){\n' + bodyCode + '\n})();';
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
        /* ---- guard <style> mis-use  (keep your existing checks) ---- */
        if (ctx.getText().includes('<style'))
            throw Error("<style> elements cannot be assigned to variables – they must stay at the top level of the component.");

        if (
            ctx.expression &&
            ctx.expression().htmlElement &&
            ctx.expression().htmlElement()
        ) {
            const tag = ctx.expression().htmlElement().tagName(0).getText().toLowerCase();
            if (tag === 'style')
                throw Error("<style> elements cannot be assigned to variables – they must stay at the top level of the component.");
        }

        /* ---- build the left-hand side string ---------------------- */
        const lhsString = this._getAssignableString(ctx.assignable());

        /* ---- auto-declare bare identifiers ------------------------ */
        let decl = '';
        const isBareId = /^[a-zA-Z_]\w*$/.test(lhsString);

        if (isBareId && !this.isDeclared(lhsString)) {
            decl = (this.inAsyncWrapper && this.scopeStack.length === 1) ? '' : 'let ';
            this.declare(lhsString);
        }

        /* ---- right side & emit ------------------------------------ */
        const rhs = this.visit(ctx.expression());

        console.log(`Assignment: ${lhsString} = ${rhs}`);
        return `${decl}${lhsString} = ${rhs}`;
    }
    visitIncrementStatement(ctx) {
        const lhs = this._getAssignableString(ctx.assignable());
        return `${lhs}++`;
    }

    visitDecrementStatement(ctx) {
        const lhs = this._getAssignableString(ctx.assignable());
        return `${lhs}--`;
    }


    visitCompoundAssignment(ctx) {
        const lhs = this._getAssignableString(ctx.assignable());
        const op = ctx.compoundOp().getText();
        const rhs = this.visit(ctx.expression());
        return `${lhs} ${op} ${rhs}${this._maybeRunEffects()}`;
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

        if (this.target === 'browser') {
            return `${decl}${name} = prompt(${q});`;
        }
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


    // visitConditionalStatement(ctx) {
    //     const condition = this.visit(ctx.expression(0));

    //     // Clean the first condition - remove outer parentheses if present
    //     const cleanCondition = condition.startsWith('(') && condition.endsWith(')')
    //         ? condition.slice(1, -1)
    //         : condition;

    //     let code = `if (${cleanCondition}) {\n`;
    //     this.enterScope();
    //     code += this.visit(ctx.suite(0));
    //     this.leaveScope();
    //     code += '\n' + this.getIndent() + '}';

    //     const elseIfs = ctx.KUTI() || [];
    //     for (let i = 0; i < elseIfs.length; i++) {
    //         const elseIfCondition = this.visit(ctx.expression(i + 1));

    //         // Clean each else-if condition too
    //         const cleanElseIfCond = elseIfCondition.startsWith('(') && elseIfCondition.endsWith(')')
    //             ? elseIfCondition.slice(1, -1)
    //             : elseIfCondition;

    //         code += ` else if (${cleanElseIfCond}) {\n`;
    //         this.enterScope();
    //         code += this.visit(ctx.suite(i + 1));
    //         this.leaveScope();
    //         code += '\n' + this.getIndent() + '}';
    //     }

    //     if (ctx.ZVIMWE()) {
    //         code += ` else {\n`;
    //         this.enterScope();
    //         code += this.visit(ctx.suite().at(-1));
    //         this.leaveScope();
    //         code += '\n' + this.getIndent() + '}';
    //     }

    //     return this.removeTrailingCommas(code);
    // }

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

        // Check if this is likely a submit handler
        const isSubmitHandler = params.includes('event') || name.toLowerCase().includes('submit');

        let bodyCode = this.visit(ctx.suite());

        // Replace mavalues references with FormData extraction
        if (isSubmitHandler && bodyCode.includes('mavalues')) {
            bodyCode = bodyCode.replace(/mavalues\.(\w+)/g,
                'Object.fromEntries(new FormData(event.target).entries()).$1');
            bodyCode = bodyCode.replace(/mavalues(?!\w)/g,
                'Object.fromEntries(new FormData(event.target).entries())');
        }

        let finalBody = bodyCode;

        // Add preventDefault for submit handlers
        if (isSubmitHandler && params.includes('event')) {
            finalBody = `${this.getIndent()}    event.preventDefault();\n` + finalBody;
        }

        // In component mode, any mutation should trigger a re-render.
        if (this.target === 'component') {
            // const needsEffects = /(\+\+|--|[^=!<>]=(?!=)|\.push\(|\.pop\(|\.shift\(|\.unshift\(|\.splice\()/s.test(bodyCode);
            const needsEffects = /(\+\+|--|[^=!<>]=(?!=)|\.push\(|\.pop\(|\.shift\(|\.unshift\(|\.splice\(|delete\b)/s.test(bodyCode);

            if (needsEffects) {
                finalBody += `${this.getIndent()}    _runEffects();\n`;
            }
        }

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


    visitHtmlBlockElement(ctx) {
        /* ---------- basic info ---------- */
        const elName = `el${this.elementCounter++}`;
        const rawTag = ctx.tagName(0).getText();
        const tagName = rawTag.toLowerCase();
         const isCustom = /^[A-Z]/.test(rawTag);  // ADD THIS LINE
        const inExpr = ctx.parentCtx &&
            ctx.parentCtx.constructor.name === 'HtmlExprContext';


             if (isCustom) {  // ADD THIS BLOCK
        const kvPairs = [];
        
        // Process attributes as props
        for (const a of ctx.attribute() || []) {
            const key = a.attrName
                ? a.attrName().getText()
                : a.getChild(0).getText();
                
            const val = a.STRING()
                ? a.STRING().getText()
                : this.visit(a.shonaExpression());
                
            kvPairs.push(`${key}: ${val}`);
        }
        
        // Process children
        let childrenCode = '';
        if (ctx.htmlContent()) {
            this.parentStack.push(elName);
            this.tagStack.push(tagName);
            
            // Temporarily change parent to collect children
            const tempParent = `_children${this.elementCounter}`;
            const oldParent = this.parentStack[this.parentStack.length - 1];
            this.parentStack[this.parentStack.length - 1] = tempParent;
            
            const childContent = this.visit(ctx.htmlContent());
            
            // Restore parent
            this.parentStack[this.parentStack.length - 1] = oldParent;
            
            this.parentStack.pop();
            this.tagStack.pop();
            
            if (childContent && childContent.trim()) {
                // Wrap children collection
                childrenCode = `const ${tempParent} = [];\n${childContent}\n`;
                kvPairs.push(`children: ${tempParent}`);
            }
        }
        
        const call = `${rawTag}({ ${kvPairs.join(', ')} })`;
        const parent = this.parentStack.at(-1);
        
        if (inExpr) {
            return `(() => {\n${childrenCode}    return ${call};\n})()`;
        } else {
            let code = childrenCode;
            if (parent && parent !== 'root') {
                code += `${parent}.appendChild(${call});\n`;
            } else {
                code += `const ${elName} = ${call};\n`;
                if (parent === 'root') {
                    code += `root.appendChild(${elName});\n`;
                }
            }
            return code;
        }
    }

        /* ---------- where to append ---------- */
        const inComponent = this.target === 'component';
        let parent;
        if (inExpr) parent = null;
        else if (tagName === 'style') parent = 'document.head';
        else parent = this.parentStack.at(-1);

        /* ---------- create element + stable key ---------- */
        const key = this._getStableKey(ctx);
        let code = inExpr
            ? `(() => {\n    const ${elName} = document.createElement('${tagName}');\n`
            : `const ${elName} = document.createElement('${tagName}');\n`;
        code += inExpr
            ? `    ${elName}.setAttribute('data-k', '${key}');\n`
            : `${elName}.setAttribute('data-k', '${key}');\n`;

        /* ---------- attributes ---------- */
        const attrs = ctx.attribute() || [];
        let hasExplicitValue = false;
        let selectBindExpr = null;      // remember zvasarudzwa expr

        for (const a of attrs) {
            const aName = a.attrName ? a.attrName().getText() : '';
            if (aName === 'value') hasExplicitValue = true;
            if (aName === 'zvasarudzwa') selectBindExpr = this.visit(a.shonaExpression());

            const snip = this.visitAttribute(a, elName);
            if (!snip) continue;
            code += inExpr
                ? snip.split('\n').filter(Boolean).map(l => '    ' + l).join('\n') + '\n'
                : snip;
        }

        /* ---------- auto id for form fields ---------- */
        if (['input', 'textarea', 'select'].includes(tagName)) {
            const already = attrs.some(a => a.attrName && a.attrName().getText() === 'id');
            if (!already) {
                code += inExpr
                    ? `    ${elName}.id = 'input_${this.elementCounter}';\n`
                    : `${elName}.id = 'input_${this.elementCounter}';\n`;
            }
        }

        /* ---------- children ---------- */
        const isVoid = this.voidTags?.has(tagName);          // <- needs voidTags Set
        if (!isVoid) {
            this.parentStack.push(elName);
            this.tagStack.push(tagName);
        }

        let childrenCode = '';

        /* text-only <option> */
        if (tagName === 'option' && !ctx.htmlContent()) {
            const m = ctx.getText().match(/>([\s\S]*?)<\/option/i);
            const txt = (m ? m[1] : '').trim();
            if (txt) {
                const esc = txt.replace(/`/g, '\\`').replace(/\$/g, '\\$');
                const line = `${elName}.appendChild($$createText(\`${esc}\`));\n`;
                childrenCode += inExpr ? '    ' + line : line;
            }
        }

        /* normal inner html */
        if (ctx.htmlContent()) {
            let inner = this.visit(ctx.htmlContent());
            if (inner) {
                inner = inExpr
                    ? inner.split('\n').filter(Boolean).map(l => '    ' + l).join('\n') + '\n'
                    : inner;
                childrenCode += inner;
            }

            /* default value for <option> without explicit value */
            if (tagName === 'option' && !hasExplicitValue) {
                const fix = `if(!${elName}.hasAttribute('value'))${elName}.value=${elName}.textContent;\n`;
                childrenCode += inExpr ? '    ' + fix : fix;
            }
        }

        if (!isVoid) {
            this.parentStack.pop();
            this.tagStack.pop();
        }

        /* ---------- assemble ---------- */
        if (inExpr) {
            code += childrenCode;
            if (tagName === 'select' && selectBindExpr)
                code += `    ${elName}.value = ${selectBindExpr};\n`;
            code += `    return ${elName};\n})();`;
            return code;
        } else {
            code += childrenCode;
            if (tagName === 'select' && selectBindExpr)
                code += `${elName}.value = ${selectBindExpr};\n`;
            if (parent) code += `${parent}.appendChild(${elName});\n`;
            return code;
        }
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
    visitHtmlSelfClosingElement(ctx) {
        const elName = `el${this.elementCounter++}`;
        const rawTag = ctx.tagName().getText();
        const tagName = rawTag.toLowerCase();
        if (tagName === 'style')
            throw Error('<style> cannot be self-closing – write <style>…</style>.');

        const stableKey = this._getStableKey(ctx);
        const isCustom = /^[A-Z]/.test(rawTag);
        const inComp = this.target === 'component';
        let parent = inComp ? (this.parentStack.at(-1) === 'root' ? null : this.parentStack.at(-1))
            : this.parentStack.at(-1);

        /* ---- custom component (unchanged) ---- */

        if (isCustom) {
            const kvPairs = [];

            for (const a of ctx.attribute() || []) {
                const key = a.attrName
                    ? a.attrName().getText()
                    : a.getChild(0).getText();

                const val = a.STRING()
                    ? a.STRING().getText()
                    : this.visit(a.shonaExpression());

                kvPairs.push(`${key}: ${val}`);
            }

            const call = `${rawTag}({ ${kvPairs.join(', ')} })`;

            if (parent)
                return `${parent}.appendChild(${call});\n`;

            return `const ${elName} = ${call};\n`;
        }

        /* ---- native element ---- */
        let code = `const ${elName} = document.createElement('${tagName}');\n`;
        code += `${elName}.setAttribute('data-k', '${stableKey}');\n`;

        for (const a of ctx.attribute() || []) {
            const snip = this.visitAttribute(a, elName);
            if (snip) code += snip;
        }

        if (parent) code += `${parent}.appendChild(${elName});\n`;
        return code;
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
        const attrName = ctx.attrName ? ctx.attrName().getText() : '';

        /* ────────────────────────────────
           1.  EVENT ATTRIBUTES
           ──────────────────────────────── */
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

            /* special case  ikanyorwa  → inject zvanyorwa = e.target.value */
            if (attrName === 'ikanyorwa') {
                return `$$listen(${elName}, '${domEvent}', e => {
                zvanyorwa = e.target.value;
                (${jsHandler})(e);
            });\n`;
            }

            /* normal custom handler */
            return `$$listen(${elName}, '${domEvent}', ${jsHandler});\n`;
        }

        /* ────────────────────────────────
           2.  TWO-WAY TEXT INPUT binding  ( zvanyorwa )
           ──────────────────────────────── */
        if (attrName === 'zvanyorwa') {
            const bindExpr = this.visit(ctx.shonaExpression());
            let code = `$$setAttribute(${elName}, 'value', ${bindExpr});\n`;
            code += `$$listen(${elName}, 'input', e => {
            const zvanyorwa = e.target.value;
            ${bindExpr} = zvanyorwa;
            _runEffects();
        });\n`;
            return code;
        }

        /* ────────────────────────────────
           3.  TWO-WAY SELECT binding      ( zvasarudzwa )
           ──────────────────────────────── */
        if (attrName === 'zvasarudzwa') {
            const bindExpr = this.visit(ctx.shonaExpression());
            let code = `$$setAttribute(${elName}, 'value', ${bindExpr});\n`;
            code += `$$listen(${elName}, 'change', e => {
            ${bindExpr} = e.target.value;
            _runEffects();
        });\n`;
            return code;
        }

        /* ────────────────────────────────
           4.  NORMAL ATTRIBUTE
           ──────────────────────────────── */
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
                results.push(result);

                // Check if we need to add a space between elements
                if (i + 1 < elements.length) {
                    const nextElement = elements[i + 1];

                    // Add space between text and expression
                    if (element.htmlText && element.htmlText() &&
                        nextElement.shonaExpression && nextElement.shonaExpression()) {
                        const parent = this.parentStack.at(-1);
                        results.push(`${parent}.appendChild($$createText(' '));`);
                    }

                    // Add space between expression and expression
                    if (element.shonaExpression && element.shonaExpression() &&
                        nextElement.shonaExpression && nextElement.shonaExpression()) {
                        const parent = this.parentStack.at(-1);
                        results.push(`${parent}.appendChild($$createText(' '));`);
                    }

                    // Add space between expression and text (but not before punctuation)
                    if (element.shonaExpression && element.shonaExpression() &&
                        nextElement.htmlText && nextElement.htmlText()) {
                        // Check if the next text doesn't already start with a space or punctuation
                        const nextTextCtx = nextElement.htmlText();
                        const start = nextTextCtx.start.start;
                        const stop = nextTextCtx.stop.stop;
                        const inputStream = nextTextCtx.start.getInputStream();
                        const nextText = inputStream.getText(start, stop);

                        // Don't add space if text starts with space or punctuation
                        const punctuation = /^[\s,;:.!?)/```\}]/;
                        if (nextText && !nextText.match(punctuation)) {
                            const parent = this.parentStack.at(-1);
                            results.push(`${parent}.appendChild($$createText(' '));`);
                        }
                    }
                }
            }
        }

        return results.filter(Boolean).join('\n');
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


    visitHtmlContentElement(ctx) {
        // Check what type of content element this is
        if (ctx.shonaControlFlow && ctx.shonaControlFlow()) {
            return this.visit(ctx.shonaControlFlow());
        }
        if (ctx.shonaExpression && ctx.shonaExpression()) {
            const expr = this.visit(ctx.shonaExpression().expression());
            const parent = this.parentStack.at(-1);
            return `${parent}.appendChild($$createText(${expr}));`;
        }
        if (ctx.htmlElement && ctx.htmlElement()) {
            return this.visit(ctx.htmlElement());
        }
        if (ctx.WS_IN_HTML && ctx.WS_IN_HTML()) {
            const parent = this.parentStack.at(-1);
            return `${parent}.appendChild($$createText(' '));`;
        }
        if (ctx.htmlText && ctx.htmlText()) {
            // Try to get the original text with spaces preserved
            const start = ctx.htmlText().start.start;
            const stop = ctx.htmlText().stop.stop;
            const inputStream = ctx.htmlText().start.getInputStream();
            let raw = inputStream.getText(start, stop);

            // Check if the next token after this text is a shonaExpression
            // by looking at the parent context
            const parent = ctx.parentNode;
            if (parent && parent.children) {
                const myIndex = parent.children.indexOf(ctx);
                if (myIndex >= 0 && myIndex + 1 < parent.children.length) {
                    const nextChild = parent.children[myIndex + 1];
                    if (nextChild.shonaExpression && nextChild.shonaExpression()) {
                        // There's an expression following this text, ensure we have a space
                        if (!raw.endsWith(' ')) {
                            raw += ' ';
                        }
                    }
                }
            }

            const parentEl = this.parentStack.at(-1);
            const tagName = this.tagStack.at(-1);
            const insideStyle = tagName === 'style';

            return this._emitInterpolatedText(raw, parentEl, insideStyle);
        }
        // Handle standalone whitespace tokens
        return '';
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
        const condition = this.visit(ctx.expression(0));
        const cleanCondition = condition.startsWith('(') && condition.endsWith(')')
            ? condition.slice(1, -1)
            : condition;

        let code = `if (${cleanCondition}) {\n`;
        this.enterScope();

        // Visit the first branch content
        if (ctx.htmlContentUntilKeyword) {
            code += this.visit(ctx.htmlContentUntilKeyword(0));
        }

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
            if (ctx.htmlContentUntilKeyword(i + 1)) {
                code += this.visit(ctx.htmlContentUntilKeyword(i + 1));
            }
            this.leaveScope();
            code += '\n' + this.getIndent() + '}';
        }

        // Handle else branch
        if (ctx.ZVIMWE()) {
            code += ` else {\n`;
            this.enterScope();
            if (ctx.htmlContentToEnd) {
                code += this.visit(ctx.htmlContentToEnd());
            }
            this.leaveScope();
            code += '\n' + this.getIndent() + '}';
        }

        return code;
    }

    visitHtmlExpr(ctx) {
        // Only allow in component mode
        if (this.target !== 'component') {
            throw new Error('HTML elements as expressions are only allowed in component files (.shonax)');
        }

        // Visit the HTML element - it will return an IIFE that creates the element
        return this.visit(ctx.htmlElement());
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
        const collection = this.visit(ctx.primaryExpression());

        this.loopDepth++;
        this.enterScope();
        this.declare(item);

        let code = `for (let ${item} of ${collection}) {\n`;

        // Visit htmlContentToEnd instead of htmlSuite
        if (ctx.htmlContentToEnd && ctx.htmlContentToEnd()) {
            code += this.visit(ctx.htmlContentToEnd());
        }

        code += this.getIndent() + "}";

        this.leaveScope();
        this.loopDepth--;

        return this.removeTrailingCommas(code);
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

    // visitImportStatement(ctx) {
    //     if (this.target !== 'node') {
    //         console.warn("Warning: 'tora ... kubva mu' (imports) are ignored in the browser target.");
    //         return `// Import for '${ctx.ID(0).getText()}' ignored in browser target.`;
    //     }
    //     const symbol = ctx.ID(0).getText();
    //     const module = ctx.ID(1).getText();
    //     if (!this.imports.has(module)) this.imports.set(module, new Set());
    //     this.imports.get(module).add(symbol);
    //     return "";
    // }

    visitImportStatement(ctx) {
    const symbol = ctx.ID(0).getText();
    
    // Get the module path - could be ID or STRING
    let modulePath;
    if (ctx.ID(1)) {
        modulePath = ctx.ID(1).getText();
    } else if (ctx.STRING && ctx.STRING()) {
        // Remove quotes from string
        modulePath = ctx.STRING().getText().replace(/^["']|["']$/g, '');
    } else {
        console.warn(`Invalid import statement: ${ctx.getText()}`);
        return '';
    }
    
    // Check if this is a component import using various heuristics:
    // 1. Ends with .shonax or .shonax.js
    // 2. Contains path separators (/ or .)
    // 3. Ends with "Component" (naming convention)
    // 4. Starts with uppercase letter (component convention)
    const isComponentImport = 
        modulePath.endsWith('.shonax') || 
        modulePath.endsWith('.shonax.js') ||
        modulePath.includes('/') || 
        modulePath.startsWith('.') ||
        modulePath.endsWith('Component') ||
        /^[A-Z]/.test(modulePath); // Starts with uppercase
    
    if (isComponentImport) {
        // Convert module path to proper import path
        let importPath = modulePath;
        
        // If it ends with Component, assume it's a .js file
        if (modulePath.endsWith('Component')) {
            importPath = `./${modulePath}.js`;
        } else if (!modulePath.includes('/') && !modulePath.startsWith('.')) {
            // Simple ID that starts with uppercase - assume local component
            importPath = `./${modulePath}.js`;
        } else if (modulePath.endsWith('.shonax')) {
            // Convert .shonax to .js
            importPath = modulePath.replace(/\.shonax$/, '.js');
        } else if (!modulePath.endsWith('.js')) {
            // Add .js extension if missing
            importPath = modulePath + '.js';
        }
        
        // Store component import
        if (!this.componentImports.has(importPath)) {
            this.componentImports.set(importPath, new Set());
        }
        this.componentImports.get(importPath).add(symbol);
        
        // Return empty string as this will be handled in the header
        return "";
    }
    
    // Handle regular Node.js imports (existing logic)
    if (this.target !== 'node' && this.target !== 'component') {
        console.warn(`Warning: 'tora ... kubva mu' (imports) are ignored in the browser target.`);
        return `// Import for '${symbol}' ignored in browser target.`;
    }
    
    // In component mode, non-component imports are ignored
    if (this.target === 'component') {
        return `// Import for '${symbol}' ignored in browser target.`;
    }
    
    if (!this.imports.has(modulePath)) {
        this.imports.set(modulePath, new Set());
    }
    this.imports.get(modulePath).add(symbol);
    return "";
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

    // visitLogicalOrExpression(ctx) {
    //     return this._visitBinary(ctx, { kana: '||', or: '||' });
    // }

    visitLogicalOrExpression(ctx) {
        if (ctx.getChildCount() === 1) {
            return this.visit(ctx.getChild(0));
        }

        let result = this.visit(ctx.getChild(0));

        for (let i = 1; i < ctx.getChildCount(); i += 2) {
            const opNode = ctx.getChild(i);
            const rightNode = ctx.getChild(i + 1);

            let op = '||'; // Default to OR
            const opText = opNode.getText();

            // Handle "kana kuti" as a two-token OR operator
            if (opText === 'kana' && i + 1 < ctx.getChildCount() - 1) {
                const nextToken = ctx.getChild(i + 1);
                if (nextToken && nextToken.getText() === 'kuti') {
                    // Skip the 'kuti' token and get the actual right operand
                    i++; // Extra increment to skip 'kuti'
                    const actualRightNode = ctx.getChild(i + 1);
                    const right = this.visit(actualRightNode);
                    result = `(${result} || ${right})`;
                    continue;
                }
            }

            const right = this.visit(rightNode);
            result = `(${result} ${op} ${right})`;
        }

        return result;
    }



    // visitLogicalAndExpression(ctx) {
    //     return this._visitBinary(ctx, { uye: '&&', and: '&&' });
    // }

    visitLogicalAndExpression(ctx) {
        return this._visitBinary(ctx, {
            uye: '&&',
            and: '&&',
            '&&': '&&'
        });
    }

    visitEqualityExpression(ctx) {
        return this._visitBinary(ctx);
    }

    visitComparisonExpression(ctx) {
        return this._visitBinary(ctx);
    }

    visitAdditiveExpression(ctx) {
        return this._visitBinary(ctx);
    }

    visitMultiplicativeExpression(ctx) {
        return this._visitBinary(ctx);
    }

    visitUnaryExpression(ctx) {
        return this.visit(ctx.getChild(0));
    }

    visitUnaryOp(ctx) {
        const op = ctx.getChild(0).getText();
        const expr = this.visit(ctx.unaryExpression());
        return `${op}${expr}`;
    }

    visitPostfixIncExpr(ctx) {
        const lhs = this._getAssignableString(ctx.assignable());
        return `${lhs}++${this._maybeRunEffects()}`;
    }

    visitPostfixDecExpr(ctx) {
        const lhs = this._getAssignableString(ctx.assignable());
        return `${lhs}--${this._maybeRunEffects()}`;
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
        const allIds = ctx.ID().map(id => id.getText());
        const methodName = allIds[allIds.length - 1];
        const owners = allIds.slice(0, -1).reverse();
        const chain = owners.join('.');
        const args = ctx.argumentList() ? this.visit(ctx.argumentList()) : "";
        return `${chain}.${methodName}(${args})`;
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

    // visitVariable(ctx) {
    //     const name = ctx.ID().getText();

    //     /* 1️⃣  Inside an object-method?  
    //        → use   this.<prop>   instead of a global variable        */
    //     if (
    //         this.objectPropsStack.length &&              // we are compiling an object
    //         this.currentFunction !== null &&             // inside *a* function/method
    //         this.objectPropsStack.at(-1).has(name)       // name is one of that object’s props
    //     ) {
    //         return `this.${name}`;
    //     }

    //     /* 2️⃣  Special helper for submit-handlers */
    //     if (this.currentEvent?.type === 'submit' && name === 'mavalues') {
    //         return 'Object.fromEntries(new FormData(event.target).entries())';
    //     }

    //     /* 3️⃣  Fallback: plain variable */
    //     return name;
    // }
    visitVariable(ctx) {
        const name = ctx.ID().getText();

        // Check if zvanyorwa is being used
        if (name === 'zvanyorwa') {
            // In the context of an event handler, zvanyorwa should be available
            return 'zvanyorwa';
        }

        /* Inside an object-method? */
        if (
            this.objectPropsStack.length &&
            this.currentFunction !== null &&
            this.objectPropsStack.at(-1).has(name)
        ) {
            return `this.${name}`;
        }

        /* Special helper for submit-handlers */
        if (this.currentEvent?.type === 'submit' && name === 'mavalues') {
            return 'Object.fromEntries(new FormData(event.target).entries())';
        }

        /* Fallback: plain variable */
        return name;
    }

    visitParens(ctx) {
        return this.visit(ctx.expression());
    }

    visitChildren(ctx) {
        return ctx.children ? ctx.children.map(c => c.accept(this)).filter(Boolean).join('') : '';
    }
}