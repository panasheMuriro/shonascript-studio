// src/utils/htmlGenerators.js

export const wrapShonaModule = (jsCode) => {
  let cleanCode = jsCode;
  
  cleanCode = cleanCode.replace(/^\s*\(\s*function\s*\(\)\s*{\s*/m, '');
  cleanCode = cleanCode.replace(/\s*}\s*\)\s*\(\s*\)\s*;\s*$/m, '');
  
  cleanCode = cleanCode.replace(/function\s+\$\$createText[\s\S]*?(?=function\s+\w+|$)/m, '');
  cleanCode = cleanCode.replace(/function\s+\$\$listen[\s\S]*?(?=function\s+\w+|$)/m, '');
  cleanCode = cleanCode.replace(/function\s+\$\$setAttribute[\s\S]*?(?=function\s+\w+|$)/m, '');
  cleanCode = cleanCode.replace(/function\s+_runEffects[\s\S]*?(?=function\s+\w+|$)/m, '');
  cleanCode = cleanCode.replace(/function\s+_render[\s\S]*?(?=function\s+\w+|$)/m, '');
  cleanCode = cleanCode.replace(/function\s+_runComputations[\s\S]*?(?=function\s+\w+|$)/m, '');
  
  const exportedFunctions = [];
  const functionBodies = {};
  const functionRegex = /function\s+(\w+)\s*\([^)]*\)\s*{([^}]+{[^}]*}[^}]*|[^}]*)}/g;
  let match;
  
  while ((match = functionRegex.exec(cleanCode)) !== null) {
    const funcName = match[1];
    const fullFunction = match[0];
    if (!funcName.startsWith('$$') && !funcName.startsWith('_') && funcName !== 'main') {
      exportedFunctions.push(funcName);
      functionBodies[funcName] = fullFunction;
    }
  }
  
  const arrowFuncRegex = /((?:const|let|var)\s+(\w+)\s*=\s*(?:\([^)]*\)|[^=])\s*=>[^;]+;)/g;
  while ((match = arrowFuncRegex.exec(cleanCode)) !== null) {
    const funcName = match[2];
    const fullFunction = match[1];
    if (!funcName.startsWith('$$') && !funcName.startsWith('_')) {
      exportedFunctions.push(funcName);
      functionBodies[funcName] = fullFunction;
    }
  }
  
  if (exportedFunctions.length > 0) {
    const functionDefinitions = exportedFunctions
      .map(funcName => functionBodies[funcName] || '')
      .filter(Boolean)
      .join('\n\n');
    
    const moduleCode = `
// Module exports only - no code execution
${functionDefinitions}

// Return module exports
return {
  ${exportedFunctions.join(',\n  ')}
};
`;
    return moduleCode;
  }
  
  return 'return {};';
};

export const createScriptHtml = (jsCode, allFiles, sourceCode, currentFile, translateShona) => {
  const importRegex = /tora\s+(\w+)\s+kubva\s+mu\s+["']([^"']+)["']/g;
  const imports = [];
  let match;
  
  while ((match = importRegex.exec(sourceCode)) !== null) {
    const [, importName, modulePath] = match;
    const cleanPath = modulePath.replace(/\.(shona|shonax)$/, '');
    imports.push({ importName, modulePath: cleanPath });
  }
  
  const compiledModules = {};
  
  allFiles.forEach(file => {
    if (file.path.endsWith('.shona') && file.path !== currentFile?.path) {
      try {
        const compiled = translateShona(file.content, { target: 'browser' });
        const wrapped = wrapShonaModule(compiled);
        const moduleName = file.name.replace('.shona', '');
        compiledModules[moduleName] = wrapped;
        compiledModules[file.name] = wrapped;
        compiledModules[`./${file.name}`] = wrapped;
        compiledModules[file.path] = wrapped;
      } catch (error) {
        console.error(`Error compiling ${file.path}:`, error);
      }
    }
  });

  return `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shona Script Preview</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { 
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            padding: 20px;
            background: #1a1a1a;
            color: #e0e0e0;
        }
        .console-output {
            background: #0a0a0a;
            border: 1px solid #333;
            border-radius: 4px;
            padding: 10px;
            font-family: 'Consolas', 'Monaco', monospace;
            white-space: pre-wrap;
            min-height: 100px;
        }
        .output-line {
            margin: 2px 0;
            font-family: 'Consolas', 'Monaco', monospace;
        }
        .output-line.error { color: #ff6b6b; }
        .output-line.warn { color: #ffd93d; }
        .output-line.log { color: #6bcf7f; }
    </style>
</head>
<body>
    <div id="console-output" class="console-output"></div>
    <script>
        const __modules = ${JSON.stringify(compiledModules)};
        const __moduleCache = {};
        
        function loadModule(moduleName) {            
            if (__moduleCache[moduleName]) {
                return __moduleCache[moduleName];
            }
            
            const moduleCode = __modules[moduleName] || 
                              __modules[moduleName + '.shona'] || 
                              __modules['./' + moduleName] ||
                              __modules['./' + moduleName + '.shona'];
                              
            if (moduleCode) {
                try {
                    const moduleFunc = new Function(moduleCode);
                    const moduleExports = moduleFunc();
                    __moduleCache[moduleName] = moduleExports;
                    return moduleExports;
                } catch (error) {
                    console.error('Error loading module ' + moduleName + ':', error);
                    return null;
                }
            }
            
            console.error('Module not found: ' + moduleName);
            return null;
        }
        
        const output = document.getElementById('console-output');
        const originalConsole = {
            log: console.log.bind(console),
            error: console.error.bind(console),
            warn: console.warn.bind(console),
            info: console.info.bind(console)
        };
        
        const addToOutput = (method, args) => {
            const line = document.createElement('div');
            line.className = 'output-line ' + method;
            line.textContent = Array.from(args).map(arg => 
                typeof arg === 'object' ? JSON.stringify(arg, null, 2) : String(arg)
            ).join(' ');
            output.appendChild(line);
            
            if (window.parent && window.parent !== window) {
                window.parent.postMessage({
                    type: 'console',
                    method: method,
                    args: Array.from(args).map(arg => String(arg))
                }, '*');
            }
        };
        
        console.log = function() { 
            addToOutput('log', arguments);
            originalConsole.log(...arguments);
        };
        console.error = function() { 
            addToOutput('error', arguments);
            originalConsole.error(...arguments);
        };
        console.warn = function() { 
            addToOutput('warn', arguments);
            originalConsole.warn(...arguments);
        };
        console.info = function() { 
            addToOutput('log', arguments);
            originalConsole.info(...arguments);
        };
        
        const imports = ${JSON.stringify(imports)};
        const importedModules = {};
        
        for (const imp of imports) {
            const module = loadModule(imp.modulePath);
            if (module) {
                if (module[imp.importName]) {
                    window[imp.importName] = module[imp.importName];
                    importedModules[imp.importName] = module[imp.importName];
                } else if (typeof module === 'function') {
                    window[imp.importName] = module;
                    importedModules[imp.importName] = module;
                } else {
                    window[imp.importName] = module;
                    importedModules[imp.importName] = module;
                }
            } else {
                console.error('Failed to import', imp.importName, 'from', imp.modulePath);
            }
        }
        
        let mainCode = ${JSON.stringify(jsCode)};
        mainCode = mainCode.replace(/\\/\\/ Import from "[^"]*" ignored\\s*\\n/g, '');
        
        try {
            const scriptFunc = new Function(...Object.keys(importedModules), mainCode);
            scriptFunc(...Object.values(importedModules));
        } catch (error) {
            console.error('Script error:', error.message);
            console.error('Stack:', error.stack);
        }
    </script>
</body>
</html>`;
};

export const createPreviewHtmlWithImports = (jsCode, files, compileComponent, translateShona) => {
    const virtualFS = {};
    
    files.forEach(file => {
      if (file.path.endsWith('.shonax')) {
        try {
          const moduleName = file.name.replace(/\.(shonax|shona)$/, '');
          const compiledCode = compileComponent(file.content, moduleName, {
            target: 'component',
            generateSourceMap: false
          });
          
          const paths = [
            `./${file.name.replace('.shonax', '.js')}`,
            `./${file.name.replace('.shonax', '')}`,
            file.name.replace('.shonax', '.js'),
            file.name.replace('.shonax', '')
          ];
          
          paths.forEach(path => {
            virtualFS[path] = { type: 'component', code: compiledCode };
          });
        } catch (error) {
          console.error(`Error compiling ${file.path}:`, error);
        }
      } else if (file.path.endsWith('.shona')) {
        try {
          const compiledCode = translateShona(file.content, {
            target: 'browser'
          });
          
          const wrappedCode = wrapShonaModule(compiledCode);
          
          const paths = [
            `./${file.name.replace('.shona', '.js')}`,
            `./${file.name.replace('.shona', '')}`,
            file.name.replace('.shona', '.js'),
            file.name.replace('.shona', '')
          ];
          
          paths.forEach(path => {
            virtualFS[path] = { type: 'module', code: wrappedCode };
          });
        } catch (error) {
          console.error(`Error compiling ${file.path}:`, error);
        }
      }
    });

    return `<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shonax Preview</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/lucide@latest"></script>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { 
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            padding: 20px;
            background: #f5f5f5;
            color: #333;
        }
        .warning { color: #ff9800; }
        .info { color: #2196f3; }
    </style>
</head>
<body>
    <div id="root"></div>
    <script type="module">
        const virtualFS = ${JSON.stringify(virtualFS)};
        const moduleCache = {};
        const externalModuleCache = {};
        
        window.$$createText = function(data){
            if (data && data.nodeType) return data;
            return document.createTextNode(data);
        }
        window.$$listen = function(node,e,h){node.addEventListener(e,h);}
        window.$$setAttribute = function(n,a,v){
            if(a==='value'||a==='checked'||a==='selected'){
                n[a]=v;
            } else if (v === false || v === null || v === undefined) { 
                n.removeAttribute(a); 
            } else {
                n.setAttribute(a,v);
                if (a === 'data-lucide' && window.lucide) {
                    queueMicrotask(() => {
                        if (n.isConnected) {
                            lucide.createIcons({ icons: { nodes: [n] } });
                        }
                    });
                }
            }
        }
        
        async function loadExternalModule(url) {
            if (externalModuleCache[url]) {
                return externalModuleCache[url];
            }
            try {
                const module = await import(url);
                externalModuleCache[url] = module;
                return module;
            } catch (error) {
                console.error('Failed to load external module:', url, error);
                return null;
            }
        }
        
        async function transformModuleCode(code, modulePath, moduleType) {
            let transformedCode = code;
            const imports = [];
            const importRegex = /import\\s+(?:(\\{[^}]*\\})|([\\w$]+)|\\*\\s+as\\s+([\\w$]+))\\s+from\\s+['"](.*?)['"]/g;
            let match;
            
            while ((match = importRegex.exec(code)) !== null) {
                const [fullMatch, namedImports, defaultImport, namespaceImport, modulePath] = match;
                imports.push({
                    fullMatch,
                    namedImports,
                    defaultImport,
                    namespaceImport,
                    modulePath,
                    isExternal: modulePath.startsWith('http')
                });
            }
            
            const loadedModules = {};
            for (const imp of imports) {
                if (imp.isExternal) {
                    const module = await loadExternalModule(imp.modulePath);
                    if (module) {
                        loadedModules[imp.modulePath] = module;
                    }
                }
            }
            
            for (const imp of imports) {
                if (imp.isExternal) {
                    const module = loadedModules[imp.modulePath];
                    if (module) {
                        let replacement = '';
                        if (imp.defaultImport) {
                            replacement = \`const \${imp.defaultImport} = window.__externalModules['\${imp.modulePath}'].default || window.__externalModules['\${imp.modulePath}'];\`;
                        } else if (imp.namedImports) {
                            const names = imp.namedImports.replace(/[{}\\s]/g, '').split(',');
                            replacement = names.map(name => {
                                const [original, alias] = name.split(' as ').map(s => s.trim());
                                const varName = alias || original;
                                return \`const \${varName} = window.__externalModules['\${imp.modulePath}'].\${original};\`;
                            }).join('\\n');
                        } else if (imp.namespaceImport) {
                            replacement = \`const \${imp.namespaceImport} = window.__externalModules['\${imp.modulePath}'];\`;
                        }
                        transformedCode = transformedCode.replace(imp.fullMatch, replacement);
                    }
                } else {
                    const moduleName = imp.defaultImport || imp.namespaceImport;
                    const replacement = \`
const __tempModule_\${moduleName} = window.__localModules['\${imp.modulePath}'] || 
                    window.__localModules['\${imp.modulePath}.js'] || 
                    window.__localModules['./\${imp.modulePath}'] || 
                    window.__localModules['./\${imp.modulePath}.js'];
const \${moduleName} = __tempModule_\${moduleName} && __tempModule_\${moduleName}.\${moduleName} ? __tempModule_\${moduleName}.\${moduleName} : __tempModule_\${moduleName};\`;
                    transformedCode = transformedCode.replace(imp.fullMatch, replacement);
                }
            }
            
            window.__externalModules = loadedModules;
            
            if (moduleType === 'component') {
                transformedCode = transformedCode.replace(/export\\s+default\\s+function\\s+(\\w+)/g, 'function $1');
                transformedCode = transformedCode.replace(/export\\s+default\\s+/g, '');
                const funcMatch = transformedCode.match(/function\\s+(\\w+)\\s*\\([^)]*\\)\\s*{/);
                if (funcMatch) {
                    transformedCode += \`\\n; return \${funcMatch[1]};\`;
                }
            } else if (moduleType === 'module') {
                if (!transformedCode.includes('return {')) {
                    transformedCode += '\\nreturn {};';
                }
            }
            
            return transformedCode;
        }
        
        async function loadModule(path) {
            const normalizedPath = path.endsWith('.js') ? path : path + '.js';
            const possiblePaths = [
                normalizedPath,
                \`./\${normalizedPath}\`,
                normalizedPath.replace('.js', ''),
                \`./\${normalizedPath.replace('.js', '')}\`
            ];
            
            for (const p of possiblePaths) {
                if (virtualFS[p]) {
                    if (!moduleCache[p]) {
                        const moduleInfo = virtualFS[p];
                        const transformedCode = await transformModuleCode(moduleInfo.code, p, moduleInfo.type);
                        try {
                            const moduleFunc = new Function(transformedCode);
                            const result = moduleFunc();
                            moduleCache[p] = result;
                        } catch (error) {
                            console.error('Error loading module', p, error);
                            console.error('Transformed code:', transformedCode);
                            moduleCache[p] = null;
                        }
                    }
                    return moduleCache[p];
                }
            }
            console.error('Module not found:', path);
            return null;
        }
        
        window.__localModules = {};
        for (const [path, moduleInfo] of Object.entries(virtualFS)) {
            const module = await loadModule(path);
            if (module) {
                window.__localModules[path] = module;
            }
        }
        
        const originalConsole = {
            log: console.log.bind(console),
            error: console.error.bind(console),
            warn: console.warn.bind(console),
            info: console.info.bind(console)
        };

        const sendConsoleMessage = (method, args) => {
            try {
                const processedArgs = [];
                for (let i = 0; i < args.length; i++) {
                    const arg = args[i];
                    if (arg === undefined) {
                        processedArgs.push('undefined');
                    } else if (arg === null) {
                        processedArgs.push('null');
                    } else if (typeof arg === 'function') {
                        processedArgs.push('[Function: ' + (arg.name || 'anonymous') + ']');
                    } else if (typeof arg === 'object') {
                        try {
                            processedArgs.push(JSON.stringify(arg, null, 2));
                        } catch (e) {
                            processedArgs.push('[Object]');
                        }
                    } else {
                        processedArgs.push(String(arg));
                    }
                }
                
                if (window.parent && window.parent !== window) {
                    window.parent.postMessage({
                        type: 'console',
                        method: method,
                        args: processedArgs
                    }, '*');
                }
                
                originalConsole[method](...args);
            } catch (error) {
                originalConsole.error('Console override error:', error);
            }
        };

        console.log = function() { sendConsoleMessage('log', arguments); };
        console.error = function() { sendConsoleMessage('error', arguments); };
        console.warn = function() { sendConsoleMessage('warn', arguments); };
        console.info = function() { sendConsoleMessage('info', arguments); };

        function initializeLucideIcons() {
            if (window.lucide) {
                requestAnimationFrame(() => {
                    lucide.createIcons();
                });
            }
        }

        function setupIconObserver() {
            if (!window.lucide) return;
            
            const observer = new MutationObserver((mutations) => {
                let hasNewIcons = false;
                
                mutations.forEach((mutation) => {
                    if (mutation.type === 'childList') {
                        mutation.addedNodes.forEach((node) => {
                            if (node.nodeType === 1) {
                                if (node.hasAttribute('data-lucide') || 
                                    node.querySelector('[data-lucide]')) {
                                    hasNewIcons = true;
                                }
                            }
                        });
                    } else if (mutation.type === 'attributes' && 
                               mutation.attributeName === 'data-lucide') {
                        hasNewIcons = true;
                    }
                });
                
                if (hasNewIcons) {
                    requestAnimationFrame(() => {
                        lucide.createIcons();
                    });
                }
            });
            
            observer.observe(document.body, {
                childList: true,
                subtree: true,
                attributes: true,
                attributeFilter: ['data-lucide']
            });
            
            return observer;
        }

        (async function() {
            try {
                const mainCode = ${JSON.stringify(jsCode)};
                const transformedMainCode = await transformModuleCode(mainCode, 'main', 'component');
                
                const executeCode = new Function(transformedMainCode);
                const MainComponent = executeCode();
                
                if (typeof MainComponent === 'function') {
                    const component = MainComponent();
                    if (component) {
                        document.getElementById('root').appendChild(component);
                        initializeLucideIcons();
                        setupIconObserver();
                    } else {
                        console.error('Component returned null or undefined');
                    }
                } else {
                    console.error('MainComponent is not a function:', typeof MainComponent);
                }
            } catch (error) {
                console.error('Error rendering component:', error.message || error);
                document.getElementById('root').innerHTML = 
                    '<div style="color: red; padding: 20px; border: 2px solid red; border-radius: 4px;">' +
                    '<h3>Render Error</h3>' +
                    '<pre>' + (error.stack || error.toString()) + '</pre>' +
                    '</div>';
            }
        })();
    </script>
</body>
</html>`;
};