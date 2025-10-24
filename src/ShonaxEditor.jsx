// ShonaxEditor.jsx - Complete Updated Version with File Management
import React, { useState, useEffect, useRef, useCallback } from 'react';
import Editor from '@monaco-editor/react';
import { Panel, PanelGroup, PanelResizeHandle } from 'react-resizable-panels';
import { 
  Play, 
  AlertCircle, 
  CheckCircle, 
  FileCode, 
  Eye, 
  Download,
  Copy,
  RefreshCw,
  Settings,
  Maximize2,
  Minimize2,
  Terminal,
  Trash2,
  Clock,
  Save,
  FolderOpen,
  X,
  Plus,
  File,
  FileText,
  Code2
} from 'lucide-react';
import FileManager from './FileManager';
import { ShonaxLanguageDefinition, ShonaxTheme, ShonaxLanguageConfiguration } from './monaco-shonax-language';
import { compileComponent } from '../shonascript/translator-core-shonax';
import { translateShona } from '../shonascript/translator-core';

// Custom debounce function
const debounce = (func, wait) => {
  let timeout;
  return function executedFunction(...args) {
    const later = () => {
      clearTimeout(timeout);
      func(...args);
    };
    clearTimeout(timeout);
    timeout = setTimeout(later, wait);
  };
};

const ShonaxEditor = () => {
  // Initialize with empty arrays/null
  const [files, setFiles] = useState([]);
  const [currentFile, setCurrentFile] = useState(null);
  const [openTabs, setOpenTabs] = useState([]);
  const [showFileManager, setShowFileManager] = useState(true);
  
  // Editor state - initialize with empty string
  const [code, setCode] = useState('');
  const [compiledCode, setCompiledCode] = useState('');
  const [previewHtml, setPreviewHtml] = useState('');
  const [errors, setErrors] = useState([]);
  const [, setWarnings] = useState([]);
  const [isCompiling, setIsCompiling] = useState(false);
  const [showSettings, setShowSettings] = useState(false);
  const [isFullscreen, setIsFullscreen] = useState(false);
  const [activeTab, setActiveTab] = useState('preview');
  const [editorTheme, setEditorTheme] = useState('shonax-dark');
  const [consoleMessages, setConsoleMessages] = useState([]);
  const [filesInitialized, setFilesInitialized] = useState(false);
  
  const monacoRef = useRef(null);
  const editorRef = useRef(null);
  const previewRef = useRef(null);
  const consoleEndRef = useRef(null);

  // Default file contents
  const DEFAULT_FILES = [
    {
      type: 'file',
      name: 'main.shonax',
      path: 'main.shonax',
      content: `// Shonax Counter Example
count = 0

basa wedzera():
    count++

<div>
    <h1 class="text-xl font-bold">ShonascriptX Counter</h1>
    <p class="my-3">Count yave: {count}</p>
    <button class="bg-green-500 text-white p-2" rikabayiwa={wedzera}>
        Wedzera
    </button>
      <button class="bg-red-600 text-white p-2 ml-4" rikabayiwa={basa(): count -=1}>
    Bvisa
    </button>

</div>`,
      modified: false
    },
    {
      type: 'file',
      name: 'example.shona',
      path: 'example.shona',
      content: `// Regular Shonascript (non-component)
basa main():
    nyora "Hello from Shonascript!"
    
    pane i mu [1, 2, 3, 4, 5]:
        nyora "Nhamba i ", i

main()`,
      modified: false
    }
  ];

  // Initialize files on mount - single source of truth
  useEffect(() => {
    if (filesInitialized) return; // Prevent re-initialization
    
    // Check localStorage first
    const savedFiles = [];
    const savedFilePaths = new Set();
    
    for (let i = 0; i < localStorage.length; i++) {
      const key = localStorage.key(i);
      if (key.startsWith('shonax_file_')) {
        const path = key.replace('shonax_file_', '');
        const content = localStorage.getItem(key);
        if (content) {
          savedFiles.push({
            type: 'file',
            name: path.split('/').pop(),
            path,
            content,
            modified: false
          });
          savedFilePaths.add(path);
        }
      }
    }
    
    // Only add default files if they don't exist in localStorage
    const filesToUse = [...savedFiles];
    for (const defaultFile of DEFAULT_FILES) {
      if (!savedFilePaths.has(defaultFile.path)) {
        filesToUse.push(defaultFile);
        // Save default files to localStorage
        localStorage.setItem(`shonax_file_${defaultFile.path}`, defaultFile.content);
      }
    }
    
    // Set files and select the first one
    if (filesToUse.length > 0) {
      setFiles(filesToUse);
      const firstFile = filesToUse[0];
      setCurrentFile(firstFile);
      setCode(firstFile.content);
      setOpenTabs([firstFile]);
    }
    
    setFilesInitialized(true);
  }, []); // Run only once on mount

  // Configure Monaco on mount
  const handleEditorWillMount = (monaco) => {
    // Register Shonax language
    monaco.languages.register({ id: 'shonax' });
    monaco.languages.setMonarchTokensProvider('shonax', ShonaxLanguageDefinition);
    monaco.editor.defineTheme('shonax-dark', ShonaxTheme);
    
    // Also register regular Shona language
    monaco.languages.register({ id: 'shona' });
    monaco.languages.setMonarchTokensProvider('shona', ShonaxLanguageDefinition);
    
    // Set language configuration with auto-indent rules
    monaco.languages.setLanguageConfiguration('shonax', ShonaxLanguageConfiguration);
    monaco.languages.setLanguageConfiguration('shona', ShonaxLanguageConfiguration);
    
    // Register completion provider for auto-closing tags (only for shonax)
    monaco.languages.registerCompletionItemProvider('shonax', {
      triggerCharacters: ['>'],
      provideCompletionItems: (model, position) => {
        const textUntilPosition = model.getValueInRange({
          startLineNumber: 1,
          startColumn: 1,
          endLineNumber: position.lineNumber,
          endColumn: position.column
        });
        
        // Check if we just typed a closing >
        const match = textUntilPosition.match(/<(\w+)(?:\s+[^>]*)?>$/);
        if (match) {
          const tagName = match[1];
          const word = model.getWordUntilPosition(position);
          const range = {
            startLineNumber: position.lineNumber,
            endLineNumber: position.lineNumber,
            startColumn: word.startColumn,
            endColumn: word.endColumn
          };
          
          return {
            suggestions: [{
              label: `</${tagName}>`,
              kind: monaco.languages.CompletionItemKind.Snippet,
              insertText: `</${tagName}>`,
              insertTextRules: monaco.languages.CompletionItemInsertTextRule.InsertAsSnippet,
              range: range,
              detail: 'Close tag',
              sortText: '0'
            }]
          };
        }
        
        return { suggestions: [] };
      }
    });

    // Register on-type formatting for auto-closing tags (only for shonax)
    monaco.languages.registerOnTypeFormattingEditProvider('shonax', {
      autoFormatTriggerCharacters: ['>'],
      provideOnTypeFormattingEdits: (model, position, ch) => {
        if (ch === '>') {
          const textUntilPosition = model.getValueInRange({
            startLineNumber: 1,
            startColumn: 1,
            endLineNumber: position.lineNumber,
            endColumn: position.column
          });
          
          const match = textUntilPosition.match(/<(\w+)(?:\s+[^>]*)?>$/);
          if (match) {
            const tagName = match[1];
            const selfClosingTags = ['br', 'hr', 'img', 'input', 'meta', 'link'];
            if (!selfClosingTags.includes(tagName.toLowerCase())) {
              return [{
                range: {
                  startLineNumber: position.lineNumber,
                  startColumn: position.column,
                  endLineNumber: position.lineNumber,
                  endColumn: position.column
                },
                text: `</${tagName}>`
              }];
            }
          }
        }
        return [];
      }
    });

    // Register document formatting provider for both languages
    ['shonax', 'shona'].forEach(lang => {
      monaco.languages.registerDocumentFormattingEditProvider(lang, {
        provideDocumentFormattingEdits: (model) => {
          const edits = [];
          const lineCount = model.getLineCount();
          let indentLevel = 0;
          
          for (let i = 1; i <= lineCount; i++) {
            const lineContent = model.getLineContent(i);
            const trimmedContent = lineContent.trim();
            
            if (!trimmedContent) continue;
            
            // Decrease indent for zvimwe/else
            if (trimmedContent.startsWith('zvimwe') || trimmedContent.startsWith('else')) {
              indentLevel = Math.max(0, indentLevel - 1);
            }
            
            // Calculate proper indentation
            const properIndent = '    '.repeat(indentLevel);
            const currentIndent = lineContent.match(/^\s*/)[0];
            
            // Add edit if indentation is wrong
            if (currentIndent !== properIndent) {
              edits.push({
                range: new monaco.Range(i, 1, i, currentIndent.length + 1),
                text: properIndent
              });
            }
            
            // Increase indent after colon
            if (trimmedContent.endsWith(':')) {
              indentLevel++;
            }
            
            // Decrease indent after blocks
            if (trimmedContent === '}' || 
                (i < lineCount && model.getLineContent(i + 1).trim().match(/^(zvimwe|else|kana)/))) {
              indentLevel = Math.max(0, indentLevel - 1);
            }
          }
          
          return edits;
        }
      });
    });
  };

  const handleEditorDidMount = (editor, monaco) => {
    editorRef.current = editor;
    monacoRef.current = monaco;
  };

  // File operations
  const handleFileSelect = (file) => {
    // Save current file changes to localStorage before switching
    if (currentFile && code !== currentFile.content) {
      updateFileContent(currentFile.path, code);
      localStorage.setItem(`shonax_file_${currentFile.path}`, code);
    }

    setCurrentFile(file);
    setCode(file.content);
    
    // Add to open tabs if not already open
    if (!openTabs.find(tab => tab.path === file.path)) {
      setOpenTabs([...openTabs, file]);
    }
  };

  const handleFileCreate = (path, content = '') => {
    // Check if file already exists
    if (files.find(f => f.path === path)) {
      console.warn(`File ${path} already exists`);
      // Generate a unique name
      const timestamp = Date.now();
      const extension = path.includes('.') ? path.split('.').pop() : 'shonax';
      const baseName = path.includes('.') ? path.split('.').slice(0, -1).join('.') : path;
      path = `${baseName}-${timestamp}.${extension}`;
    }
    
    // Determine default content based on file extension
    let defaultContent = content;
    if (!content) {
      if (path.endsWith('.shonax')) {
        defaultContent = `// New Shonax Component\n\n<div>\n    <h1>Hello World</h1>\n</div>`;
      } else if (path.endsWith('.shona')) {
        defaultContent = `// New Shona Script\n\nnyora "Hello World!"`;
      }
    }

    const newFile = {
      type: 'file',
      name: path.split('/').pop(),
      path,
      content: defaultContent,
      modified: false
    };
    
    setFiles([...files, newFile]);
    handleFileSelect(newFile);
    
    // Save to localStorage immediately
    localStorage.setItem(`shonax_file_${path}`, defaultContent);
  };

  const handleFileDelete = (path) => {
    // Show confirmation dialog
    const fileToDelete = files.find(f => f.path === path);
    if (!fileToDelete) return;
    
    const confirmDelete = window.confirm(
      `Are you sure you want to delete "${fileToDelete.name}"? This action cannot be undone.`
    );
    
    if (!confirmDelete) return;
    
    // Remove from localStorage
    const storageKey = `shonax_file_${path}`;
    localStorage.removeItem(storageKey);
    
    // Remove from state
    setFiles(files.filter(f => f.path !== path));
    setOpenTabs(openTabs.filter(t => t.path !== path));
    
    // If the deleted file was the current file, switch to another
    if (currentFile?.path === path) {
      const remainingFile = files.find(f => f.path !== path);
      if (remainingFile) {
        handleFileSelect(remainingFile);
      } else {
        setCurrentFile(null);
        setCode('');
        setCompiledCode('');
        setPreviewHtml('');
      }
    }
    
    console.log(`Deleted file: ${path} from localStorage`);
  };

  const handleFileRename = (oldPath, newName) => {
    // Remove old file from localStorage
    localStorage.removeItem(`shonax_file_${oldPath}`);
    
    const updatedFiles = files.map(f => {
      if (f.path === oldPath) {
        const newPath = oldPath.replace(f.name, newName);
        // Save with new name to localStorage
        localStorage.setItem(`shonax_file_${newPath}`, f.content);
        return { ...f, name: newName, path: newPath };
      }
      return f;
    });
    
    setFiles(updatedFiles);
    
    // Update open tabs
    const updatedTabs = openTabs.map(tab => {
      if (tab.path === oldPath) {
        const newPath = oldPath.replace(tab.name, newName);
        return { ...tab, name: newName, path: newPath };
      }
      return tab;
    });
    setOpenTabs(updatedTabs);
    
    if (currentFile?.path === oldPath) {
      const updatedFile = updatedFiles.find(f => f.name === newName);
      setCurrentFile(updatedFile);
    }
  };

  const handleFolderCreate = (path) => {
    // For simplicity, we're using a flat structure
    // You can enhance this to support nested folders
    console.log('Creating folder:', path);
  };

  const updateFileContent = (path, content) => {
    setFiles(prevFiles => prevFiles.map(f => 
      f.path === path 
        ? { ...f, content, modified: true }
        : f
    ));
  };

  const handleSaveFile = () => {
    if (currentFile) {
      // Update file content and mark as not modified
      setFiles(prevFiles => prevFiles.map(f => 
        f.path === currentFile.path 
          ? { ...f, content: code, modified: false }
          : f
      ));
      
      // Update current file reference
      setCurrentFile(prev => ({ ...prev, content: code, modified: false }));
      
      // Update open tabs
      setOpenTabs(prevTabs => prevTabs.map(tab =>
        tab.path === currentFile.path
          ? { ...tab, content: code, modified: false }
          : tab
      ));
      
      // Save to localStorage
      localStorage.setItem(`shonax_file_${currentFile.path}`, code);
      
      // Show success message (you can add a toast notification here)
      console.log(`Saved ${currentFile.name}`);
    }
  };

  const handleCloseTab = (tab) => {
    // Save before closing if modified
    if (tab.modified && tab.path === currentFile?.path) {
      handleSaveFile();
    }
    
    const newTabs = openTabs.filter(t => t.path !== tab.path);
    setOpenTabs(newTabs);
    
    if (currentFile?.path === tab.path && newTabs.length > 0) {
      handleFileSelect(newTabs[newTabs.length - 1]);
    } else if (newTabs.length === 0) {
      setCurrentFile(null);
      setCode('');
    }
  };

  // Listen for console messages from iframe
  useEffect(() => {
    const handleMessage = (event) => {
      if (event.data && event.data.type === 'console') {
        const timestamp = new Date().toLocaleTimeString();
        setConsoleMessages(prev => [...prev, {
          ...event.data,
          timestamp,
          id: Date.now() + Math.random()
        }]);
      }
    };

    window.addEventListener('message', handleMessage);
    return () => window.removeEventListener('message', handleMessage);
  }, []);

  // Scroll to bottom of console when new messages arrive
  useEffect(() => {
    if (consoleEndRef.current) {
      consoleEndRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  }, [consoleMessages]);

  // Clear console messages when code changes
  useEffect(() => {
    setConsoleMessages([]);
  }, [code]);

  const compileCode = useCallback(
    debounce(async (sourceCode, fileName) => {
      if (!fileName) return;
      
      setIsCompiling(true);
      setErrors([]);
      setWarnings([]);
      
      try {
        const isShonax = fileName.endsWith('.shonax');
        const isShona = fileName.endsWith('.shona');
        
        let jsCode = '';
        
        if (isShonax) {
          // Component file - use component compiler
          const componentName = fileName.replace(/\.(shonax|shona)$/, '');
          jsCode = compileComponent(sourceCode, componentName, {
            target: 'component',
            generateSourceMap: true
          });
          
          // Use the new preview HTML with import support
          const previewHtml = createPreviewHtmlWithImports(jsCode, files, currentFile);
          setPreviewHtml(previewHtml);
        } else if (isShona) {
          // Regular Shona script - use regular translator
          jsCode = translateShona(sourceCode, {
            target: 'browser'
          });
          
          // Create a simple HTML wrapper for non-component scripts
          const scriptHtml = createScriptHtml(jsCode);
          setPreviewHtml(scriptHtml);
        } else {
          throw new Error('Unsupported file type. Use .shona or .shonax extension.');
        }
        
        setCompiledCode(jsCode);
        
      } catch (error) {
        console.error('Compilation error:', error);
        setErrors([error.message]);
      } finally {
        setIsCompiling(false);
      }
    }, 500),
    [files, currentFile]
  );

  // Create HTML for non-component scripts
  const createScriptHtml = (jsCode) => {
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
        // Override console to show output in page
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
            
            // Also send to parent
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
        
        // Execute the script
        try {
            ${jsCode}
        } catch (error) {
            console.error('Script error:', error.message);
        }
    </script>
</body>
</html>`;
  };


  const createPreviewHtmlWithImports = (jsCode, files) => {
    // Create virtual file system with all compiled components AND regular shona files
    const virtualFS = {};
    
    files.forEach(file => {
      if (file.path.endsWith('.shonax')) {
        try {
          const moduleName = file.name.replace(/\.(shonax|shona)$/, '');
          const compiledCode = compileComponent(file.content, moduleName, {
            target: 'component',
            generateSourceMap: false
          });
          
          // Store with multiple possible paths
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
        // Virtual file system with compiled components and modules
        const virtualFS = ${JSON.stringify(virtualFS)};
        const moduleCache = {};
        const externalModuleCache = {};
        
        // Helper functions that will be available in all modules
        window.$$createText = function(data){
            if (data && data.nodeType) return data;
            return document.createTextNode(data);
        }
        window.$$listen = function(node,e,h){node.addEventListener(e,h);}
        window.$$setAttribute = function(n,a,v){
            if(a==='value'||a==='checked'||a==='selected'){n[a]=v;}
            else if (v === false || v === null || v === undefined) { n.removeAttribute(a); }
            else{n.setAttribute(a,v);}
        }
        
        // Load external module from URL
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
        
        // Transform ES module code to be executable in browser
        async function transformModuleCode(code, modulePath, moduleType) {
            let transformedCode = code;
            const imports = [];
            
            // Extract all imports first
            const importRegex = /import\\s+(?:({[^}]*})|([\\w$]+)|\\*\\s+as\\s+([\\w$]+))\\s+from\\s+['"](.*?)['"]/g;
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
            
            // Load all external modules first
            const loadedModules = {};
            for (const imp of imports) {
                if (imp.isExternal) {
                    const module = await loadExternalModule(imp.modulePath);
                    if (module) {
                        loadedModules[imp.modulePath] = module;
                    }
                }
            }
            
            // Replace imports with loaded modules
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
                    // Handle local imports
                    const replacement = \`const \${imp.defaultImport || imp.namespaceImport} = window.__localModules['\${imp.modulePath}'] || window.__localModules['\${imp.modulePath}.js'] || window.__localModules['./\${imp.modulePath}'] || window.__localModules['./\${imp.modulePath}.js'];\`;
                    transformedCode = transformedCode.replace(imp.fullMatch, replacement);
                }
            }
            
            // Store loaded external modules globally
            window.__externalModules = loadedModules;
            
            if (moduleType === 'component') {
                // Remove export default
                transformedCode = transformedCode.replace(/export\\s+default\\s+function\\s+(\\w+)/g, 'function $1');
                transformedCode = transformedCode.replace(/export\\s+default\\s+/g, '');
                
                // Find the main function and return it
                const funcMatch = transformedCode.match(/function\\s+(\\w+)\\s*\\([^)]*\\)\\s*{/);
                if (funcMatch) {
                    transformedCode += \`\\n; return \${funcMatch[1]};\`;
                }
            }
            
            return transformedCode;
        }
        
        // Load a module from virtual FS
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
                            moduleCache[p] = moduleFunc();
                        } catch (error) {
                            console.error('Error loading module', p, error);
                            moduleCache[p] = null;
                        }
                    }
                    return moduleCache[p];
                }
            }
            
            console.error('Module not found:', path);
            return null;
        }
        
        // Store local modules globally
        window.__localModules = {};
        
        // Pre-load all local modules
        for (const [path, moduleInfo] of Object.entries(virtualFS)) {
            const module = await loadModule(path);
            if (module) {
                window.__localModules[path] = module;
            }
        }
        
        // Console override
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

        // Execute the main component
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

  const wrapShonaModule = (jsCode) => {
    // Remove the helper functions and IIFE wrapper
    let cleanCode = jsCode;
    
    // Remove the helper functions block
    cleanCode = cleanCode.replace(/function \$\$createText[\s\S]*?function _runEffects\(\)[^}]*}/m, '');
    
    // Remove the wrapping (function(){ ... })();
    cleanCode = cleanCode.replace(/^\s*\(\s*function\s*\(\)\s*{\s*/m, '');
    cleanCode = cleanCode.replace(/\s*}\s*\)\s*\(\s*\)\s*;\s*$/m, '');
    
    // Extract all function declarations
    const exportedFunctions = [];
    
    // Match function declarations (like "function sanganisa")
    const funcMatches = cleanCode.matchAll(/function\s+(\w+)\s*\([^)]*\)/gm);
    for (const match of funcMatches) {
      exportedFunctions.push(match[1]);
    }
    
    // Build the export statement
    if (exportedFunctions.length > 0) {
      // Export each function as a named export
      const exports = exportedFunctions.map(fn => `export { ${fn} };`).join('\n');
      
      // Also create a default export with all functions
      const defaultExport = `\nexport default { ${exportedFunctions.join(', ')} };`;
      
      return `${cleanCode}\n${exports}\n${defaultExport}`;
    }
    
    return cleanCode;
  };

  // Update code when file changes
  useEffect(() => {
    if (currentFile && filesInitialized) {
      compileCode(code, currentFile.name);
      
      // Mark file as modified if content changed
      if (code !== currentFile.content) {
        setFiles(prevFiles => prevFiles.map(f =>
          f.path === currentFile.path
            ? { ...f, modified: true }
            : f
        ));
        setOpenTabs(prevTabs => prevTabs.map(tab =>
          tab.path === currentFile.path
            ? { ...tab, modified: true }
            : tab
        ));
      }
    }
  }, [code, currentFile, filesInitialized]);

  // Keyboard shortcuts
  useEffect(() => {
    const handleKeyDown = (e) => {
      // Cmd/Ctrl + S to save
      if ((e.metaKey || e.ctrlKey) && e.key === 's') {
        e.preventDefault();
        handleSaveFile();
      }
      // Cmd/Ctrl + B to toggle file manager
      if ((e.metaKey || e.ctrlKey) && e.key === 'b') {
        e.preventDefault();
        setShowFileManager(prev => !prev);
      }
      // Cmd/Ctrl + N for new file
      if ((e.metaKey || e.ctrlKey) && e.key === 'n') {
        e.preventDefault();
        const timestamp = Date.now();
        handleFileCreate(`untitled-${timestamp}.shonax`);
      }
    };

    window.addEventListener('keydown', handleKeyDown);
    return () => window.removeEventListener('keydown', handleKeyDown);
  }, [code, currentFile]);

  const toggleFullscreen = () => {
    setIsFullscreen(!isFullscreen);
  };

  const copyToClipboard = async (text) => {
    try {
      await navigator.clipboard.writeText(text);
      // You can add a toast notification here
      console.log('Copied to clipboard');
    } catch (err) {
      console.error('Failed to copy:', err);
    }
  };

  const downloadCode = (filename, content) => {
    const blob = new Blob([content], { type: 'text/plain' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = filename;
    a.click();
    URL.revokeObjectURL(url);
  };

  const clearConsole = () => {
    setConsoleMessages([]);
  };

  const formatConsoleMessage = (message) => {
    return message.args.join(' ');
  };

  const getConsoleMessageClass = (method) => {
    switch (method) {
      case 'error': return 'console-error';
      case 'warn': return 'console-warn';
      case 'info': return 'console-info';
      default: return 'console-log';
    }
  };

  const getFileIcon = (fileName) => {
    if (fileName.endsWith('.shonax')) {
      return <Code2 size={14} className="text-blue-400" />;
    } else if (fileName.endsWith('.shona')) {
      return <FileText size={14} className="text-green-400" />;
    }
    return <File size={14} className="text-gray-400" />;
  };

  return (
    <div className={`shonax-editor ${isFullscreen ? 'fullscreen' : ''}`}>
      <div className="editor-toolbar">
        <div className="toolbar-left">
          <button
            className="toolbar-btn"
            onClick={() => setShowFileManager(!showFileManager)}
            title="Toggle File Manager (Cmd/Ctrl+B)"
          >
            <FolderOpen size={18} />
          </button>
          <h2 className="editor-title">
            <FileCode className="icon" size={20} />
            Shonascript Studio
          </h2>
        </div>
        
        <div className="toolbar-center">
          <div className="open-tabs">
            {openTabs.map(tab => (
              <div
                key={tab.path}
                className={`tab-item ${currentFile?.path === tab.path ? 'active' : ''}`}
                onClick={() => handleFileSelect(tab)}
              >
                {getFileIcon(tab.name)}
                <span className="tab-name">{tab.name}</span>
                {tab.modified && <span className="modified-dot">•</span>}
                <button
                  className="tab-close"
                  onClick={(e) => {
                    e.stopPropagation();
                    handleCloseTab(tab);
                  }}
                >
                  <X size={12} />
                </button>
              </div>
            ))}
            <button
              className="new-tab-btn"
              onClick={() => {
                const timestamp = Date.now();
                handleFileCreate(`untitled-${timestamp}.shonax`);
              }}
              title="New File (Cmd/Ctrl+N)"
            >
              <Plus size={14} />
            </button>
          </div>
          
          {isCompiling && (
            <div className="status-indicator compiling">
              <RefreshCw className="icon spinning" size={16} />
              <span>Compiling...</span>
            </div>
          )}
          {!isCompiling && errors.length === 0 && currentFile && (
            <div className="status-indicator success">
              <CheckCircle className="icon" size={16} />
              <span>Ready</span>
            </div>
          )}
          {!isCompiling && errors.length > 0 && (
            <div className="status-indicator error">
              <AlertCircle className="icon" size={16} />
              <span>{errors.length} {errors.length === 1 ? 'error' : 'errors'}</span>
            </div>
          )}
        </div>
        
        <div className="toolbar-right">
          <button 
            className="toolbar-btn"
            onClick={handleSaveFile}
            title="Save (Cmd/Ctrl+S)"
            disabled={!currentFile}
          >
            <Save size={18} />
          </button>
          <button 
            className="toolbar-btn"
            onClick={() => copyToClipboard(code)}
            title="Copy Source Code"
            disabled={!currentFile}
          >
            <Copy size={18} />
          </button>
          <button 
            className="toolbar-btn"
            onClick={() => currentFile && downloadCode(currentFile.name, code)}
            title="Download Source File"
            disabled={!currentFile}
          >
            <Download size={18} />
          </button>
          <button 
            className="toolbar-btn"
            onClick={() => setShowSettings(!showSettings)}
            title="Settings"
          >
            <Settings size={18} />
          </button>
          <button 
            className="toolbar-btn"
            onClick={toggleFullscreen}
            title={isFullscreen ? 'Exit Fullscreen' : 'Fullscreen'}
          >
            {isFullscreen ? <Minimize2 size={18} /> : <Maximize2 size={18} />}
          </button>
        </div>
      </div>

      <div className="editor-content h-full">
        <PanelGroup direction="horizontal" className="h-full">
          {showFileManager && (
            <>
              <Panel defaultSize={20} minSize={15} maxSize={30}>
                <FileManager
                  files={files}
                  currentFile={currentFile}
                  onFileSelect={handleFileSelect}
                  onFileCreate={handleFileCreate}
                  onFileDelete={handleFileDelete}
                  onFileRename={handleFileRename}
                  onFolderCreate={handleFolderCreate}
                  onFileSave={handleSaveFile}
                />
              </Panel>
              <PanelResizeHandle className="w-1 bg-gray-700 hover:bg-blue-500 transition-colors cursor-col-resize" />
            </>
          )}
          
          <Panel defaultSize={showFileManager ? 40 : 50} minSize={30}>
            <div className="editor-panel h-full">
              {currentFile ? (
                <Editor
                  height="100%"
                  language={currentFile.name.endsWith('.shonax') ? 'shonax' : 'shona'}
                  theme={editorTheme}
                  value={code}
                  onChange={setCode}
                  beforeMount={handleEditorWillMount}
                  onMount={handleEditorDidMount}
                  path={currentFile.path}
                  options={{
                    minimap: { enabled: false },
                    fontSize: 14,
                    fontFamily: "'Jetbrains Mono', 'Fira Code', 'Cascadia Code', monospace",
                    lineNumbers: 'on',
                    roundedSelection: false,
                    scrollBeyondLastLine: false,
                    automaticLayout: true,
                    tabSize: 4,
                    insertSpaces: true,
                    detectIndentation: false,
                    wordWrap: 'on',
                    suggest: {
                      showKeywords: true,
                      showSnippets: true
                    },
                    autoClosingBrackets: 'always',
                    autoClosingQuotes: 'always',
                    autoClosingOvertype: 'always',
                    autoSurround: 'languageDefined',
                    formatOnType: true,
                    formatOnPaste: true,
                    autoIndent: 'full',
                    quickSuggestions: {
                      other: true,
                      comments: false,
                      strings: false
                    },
                    acceptSuggestionOnEnter: 'on',
                    suggestOnTriggerCharacters: true,
                    smartSelect: {
                      selectLeadingAndTrailingWhitespace: false
                    }
                  }}
                />
              ) : (
                <div className="no-file-selected">
                  <FileCode size={48} />
                  <p>No file selected</p>
                  <button 
                    className="create-file-btn"
                    onClick={() => handleFileCreate('new.shonax')}
                  >
                    Create New File
                  </button>
                </div>
              )}
            </div>
          </Panel>

          <PanelResizeHandle className="w-1 bg-gray-700 hover:bg-blue-500 transition-colors cursor-col-resize" />

          <Panel defaultSize={showFileManager ? 40 : 50} minSize={30}>
            <div className="preview-panel h-full">
              <div className="preview-tabs">
                <button
                  className={`tab ${activeTab === 'preview' ? 'active' : ''}`}
                  onClick={() => setActiveTab('preview')}
                >
                  <Eye size={16} />
                  Preview
                </button>
                <button
                  className={`tab ${activeTab === 'console' ? 'active' : ''}`}
                  onClick={() => setActiveTab('console')}
                >
                  <Terminal size={16} />
                  Console
                </button>
                <button
                  className={`tab ${activeTab === 'compiled' ? 'active' : ''}`}
                  onClick={() => setActiveTab('compiled')}
                >
                  <FileCode size={16} />
                  Compiled JS
                </button>
              </div>

              <div className="preview-content">
                {activeTab === 'preview' && (
                  <iframe
                    ref={previewRef}
                    className="preview-iframe"
                    srcDoc={previewHtml}
                    title="Preview"
                    sandbox="allow-scripts"
                  />
                )}

                {activeTab === 'console' && (
                  <div className="console-panel">
                    <div className="console-header">
                      <span className="console-title">Console Output</span>
                      <button 
                        className="console-clear-btn"
                        onClick={clearConsole}
                        title="Clear Console"
                      >
                        <Trash2 size={14} />
                        Clear
                      </button>
                    </div>
                    <div className="console-content">
                      {consoleMessages.length === 0 ? (
                        <div className="console-empty">
                          <Terminal size={24} />
                          <p>Console output will appear here</p>
                        </div>
                      ) : (
                        <div className="console-messages">
                          {consoleMessages.map((msg) => (
                            <div key={msg.id} className={`console-message ${getConsoleMessageClass(msg.method)}`}>
                              <span className="console-timestamp">
                                <Clock size={12} />
                                {msg.timestamp}
                              </span>
                              <span className="console-text">
                                {formatConsoleMessage(msg)}
                              </span>
                            </div>
                          ))}
                          <div ref={consoleEndRef} />
                        </div>
                      )}
                    </div>
                  </div>
                )}
                
                {activeTab === 'compiled' && (
                  <div className="compiled-code">
                    <div className="code-actions">
                      <button 
                        className="action-btn"
                        onClick={() => copyToClipboard(compiledCode)}
                      >
                        <Copy size={14} />
                        Copy JS
                      </button>
                      <button 
                        className="action-btn"
                        onClick={() => downloadCode(
                          currentFile ? currentFile.name.replace(/\.(shona|shonax)$/, '.js') : 'compiled.js', 
                          compiledCode
                        )}
                      >
                        <Download size={14} />
                        Download JS
                      </button>
                    </div>
                    <Editor
                      height="calc(100% - 40px)"
                      defaultLanguage="javascript"
                      theme="vs-dark"
                      value={compiledCode}
                      options={{
                        minimap: { enabled: false },
                        fontSize: 14,
                        fontFamily: "'Jetbrains Mono', 'Fira Code', monospace",
                        lineNumbers: 'on',
                        scrollBeyondLastLine: false,
                        automaticLayout: true,
                        wordWrap: 'on'
                      }}
                    />
                  </div>
                )}
              </div>

              {errors.length > 0 && (
                <div className="error-panel">
                  <div className="error-header">
                    <AlertCircle size={16} />
                    <span>Compilation Errors</span>
                  </div>
                  <div className="error-list">
                    {errors.map((error, index) => (
                      <div key={index} className="error-item">
                        {error}
                      </div>
                    ))}
                  </div>
                </div>
              )}
            </div>
          </Panel>
        </PanelGroup>
      </div>

      {showSettings && (
        <div className="settings-modal">
          <div className="settings-content">
            <h3>Editor Settings</h3>
            <div className="setting-item">
              <label>Theme:</label>
              <select 
                value={editorTheme} 
                onChange={(e) => setEditorTheme(e.target.value)}
              >
                <option value="shonax-dark">Shonax Dark</option>
                <option value="vs-dark">VS Dark</option>
                <option value="vs">VS Light</option>
              </select>
            </div>
            <div className="setting-item">
              <label>Font Size:</label>
              <input
                type="number"
                min="10"
                max="24"
                defaultValue="14"
                onChange={(e) => {
                  if (editorRef.current) {
                    editorRef.current.updateOptions({ fontSize: parseInt(e.target.value) });
                  }
                }}
              />
            </div>
            <button 
              className="close-btn"
              onClick={() => setShowSettings(false)}
            >
              Close
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default ShonaxEditor;