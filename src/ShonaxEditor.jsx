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
import { compileComponent, translateShonax } from '../shonascript/translator-core-shonax';
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
  // File management state
  const [files, setFiles] = useState([
    {
      type: 'file',
      name: 'main.shonax',
      path: 'main.shonax',
      content: `// Shonax Component Example
count = 0

basa increment():
    count++
    nyora "Count is now:", count

<div class="container">
    <h1>Shonax Counter Demo</h1>
    <p>Current count: {count}</p>
    <button rikabayiwa={increment}>
        Increment Counter
    </button>
    
    {kana count > 5:
        <p class="warning">Count is getting high!</p>
    zvimwe:
        <p class="info">Keep clicking!</p>
    }
    
    <ul>
        {pane ix mu [1, 2, 3]:
            <li>Item {ix}</li>
        }
    </ul>
</div>`,
      modified: false
    },
    {
      type: 'file',
      name: 'example.shona',
      path: 'example.shona',
      content: `// Regular Shona Script (non-component)
basa main():
    nyora "Hello from Shona!"
    
    pane i mu [1, 2, 3, 4, 5]:
        nyora "Number:", i

main()`,
      modified: false
    }
  ]);

  const [currentFile, setCurrentFile] = useState(files[0]);
  const [openTabs, setOpenTabs] = useState([files[0]]);
  const [showFileManager, setShowFileManager] = useState(true);
  
  // Editor state
  const [code, setCode] = useState(files[0].content);
  const [compiledCode, setCompiledCode] = useState('');
  const [previewHtml, setPreviewHtml] = useState('');
  const [errors, setErrors] = useState([]);
  const [warnings, setWarnings] = useState([]);
  const [isCompiling, setIsCompiling] = useState(false);
  const [showSettings, setShowSettings] = useState(false);
  const [isFullscreen, setIsFullscreen] = useState(false);
  const [activeTab, setActiveTab] = useState('preview');
  const [editorTheme, setEditorTheme] = useState('shonax-dark');
  const [consoleMessages, setConsoleMessages] = useState([]);
  
  const monacoRef = useRef(null);
  const editorRef = useRef(null);
  const previewRef = useRef(null);
  const consoleEndRef = useRef(null);

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
    // Save current file changes
    if (currentFile && code !== currentFile.content) {
      updateFileContent(currentFile.path, code);
    }

    setCurrentFile(file);
    setCode(file.content);
    
    // Add to open tabs if not already open
    if (!openTabs.find(tab => tab.path === file.path)) {
      setOpenTabs([...openTabs, file]);
    }
  };

  const handleFileCreate = (path, content = '') => {
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
  };

  const handleFileDelete = (path) => {
    setFiles(files.filter(f => f.path !== path));
    setOpenTabs(openTabs.filter(t => t.path !== path));
    
    if (currentFile?.path === path) {
      const remainingFile = files.find(f => f.path !== path);
      if (remainingFile) {
        handleFileSelect(remainingFile);
      } else {
        setCurrentFile(null);
        setCode('');
      }
    }
  };

  const handleFileRename = (oldPath, newName) => {
    const updatedFiles = files.map(f => {
      if (f.path === oldPath) {
        const newPath = oldPath.replace(f.name, newName);
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

  // Compile based on file type
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
          jsCode = compileComponent(sourceCode, 'ShonaxComponent', {
            target: 'component',
            generateSourceMap: true
          });
          
          const previewHtml = createPreviewHtml(jsCode);
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
    []
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

  const createPreviewHtml = (jsCode) => {
    const modifiedJsCode = jsCode
      .replace('export default function', 'function')
      .replace(/export\s+default\s+/, '');

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
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .warning { color: #ff9800; }
        .info { color: #2196f3; }
        button {
            background: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background: #45a049;
        }
    </style>
</head>
<body>
    <div id="root"></div>
    <script>
        // Infinite loop protection
        let renderCount = 0;
        let lastRenderTime = Date.now();
        const MAX_RENDERS_PER_SECOND = 50;
        
        // Store original console methods
        const originalConsole = {
            log: console.log.bind(console),
            error: console.error.bind(console),
            warn: console.warn.bind(console),
            info: console.info.bind(console)
        };

        // Override console methods to send messages to parent
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

        // Execute the component code
        (function() {
            try {
                let isRendering = false;
                let effectQueue = [];
                let isProcessingEffects = false;
                
                ${modifiedJsCode}
                
                if (typeof ShonaxComponent !== 'undefined') {
                    const component = ShonaxComponent();
                    if (component) {
                        document.getElementById('root').appendChild(component);
                    } else {
                        console.error('Component returned null or undefined');
                    }
                } else {
                    console.error('ShonaxComponent is not defined');
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

  // Update code when file changes
  useEffect(() => {
    if (currentFile) {
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
  }, [code, currentFile]);

  // Load files from localStorage on mount
  useEffect(() => {
    const savedFiles = [];
    for (let i = 0; i < localStorage.length; i++) {
      const key = localStorage.key(i);
      if (key.startsWith('shonax_file_')) {
        const path = key.replace('shonax_file_', '');
        const content = localStorage.getItem(key);
        if (content && !files.find(f => f.path === path)) {
          savedFiles.push({
            type: 'file',
            name: path.split('/').pop(),
            path,
            content,
            modified: false
          });
        }
      }
    }
    
    if (savedFiles.length > 0) {
      setFiles(prevFiles => [...prevFiles, ...savedFiles]);
    }
  }, []);

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
                        // readOnly: true,
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