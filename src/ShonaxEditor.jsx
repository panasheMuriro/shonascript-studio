// ShonaxEditor.jsx
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
  Clock
} from 'lucide-react';
import { ShonaxLanguageDefinition, ShonaxTheme } from './monaco-shonax-language';
import { compileComponent } from '../shonascript/translator-core-shonax';

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
  const [code, setCode] = useState(`// Shonax Component Example
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
</div>`);

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
    monaco.languages.register({ id: 'shonax' });
    monaco.languages.setMonarchTokensProvider('shonax', ShonaxLanguageDefinition);
    monaco.editor.defineTheme('shonax-dark', ShonaxTheme);
    monaco.languages.setLanguageConfiguration('shonax', {
      comments: {
        lineComment: '//',
        blockComment: ['/*', '*/']
      },
      brackets: [
        ['{', '}'],
        ['[', ']'],
        ['(', ')'],
        ['<', '>']
      ],
      autoClosingPairs: [
        { open: '{', close: '}' },
        { open: '[', close: ']' },
        { open: '(', close: ')' },
        { open: '"', close: '"' },
        { open: '<', close: '>' }
      ],
      surroundingPairs: [
        { open: '{', close: '}' },
        { open: '[', close: ']' },
        { open: '(', close: ')' },
        { open: '"', close: '"' },
        { open: '<', close: '>' }
      ]
    });
  };

  const handleEditorDidMount = (editor, monaco) => {
    editorRef.current = editor;
    monacoRef.current = monaco;
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

  // Compile Shonax code
  const compileCode = useCallback(
    debounce(async (sourceCode) => {
      setIsCompiling(true);
      setErrors([]);
      setWarnings([]);
      
      try {
        const jsCode = compileComponent(sourceCode, 'ShonaxComponent', {
          target: 'component',
          generateSourceMap: true
        });
        
        setCompiledCode(jsCode);
        
        const previewHtml = createPreviewHtml(jsCode);
        setPreviewHtml(previewHtml);
        
      } catch (error) {
        console.error('Compilation error:', error);
        setErrors([error.message]);
      } finally {
        setIsCompiling(false);
      }
    }, 500),
    []
  );


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
        <!-- Tailwind CSS CDN -->
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { 
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
            padding: 20px;
            background: #f5f5f5;
            color: #333;
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
                // Process arguments safely
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
                
                // Send to parent window
                if (window.parent && window.parent !== window) {
                    window.parent.postMessage({
                        type: 'console',
                        method: method,
                        args: processedArgs
                    }, '*');
                }
                
                // Call original method
                originalConsole[method](...args);
            } catch (error) {
                originalConsole.error('Console override error:', error);
            }
        };

        console.log = function() { sendConsoleMessage('log', arguments); };
        console.error = function() { sendConsoleMessage('error', arguments); };
        console.warn = function() { sendConsoleMessage('warn', arguments); };
        console.info = function() { sendConsoleMessage('info', arguments); };

        // Wrap the component code to add infinite loop protection
        (function() {
            try {
                // Inject render protection
                const originalRender = window._render || function() {};
                const originalRunEffects = window._runEffects || function() {};
                
                // Track render calls to prevent infinite loops
                let isRendering = false;
                let effectQueue = [];
                let isProcessingEffects = false;
                
                if (typeof window._render === 'function') {
                    window._render = function() {
                        if (isRendering) {
                            console.warn('Prevented recursive render call');
                            return;
                        }
                        
                        const now = Date.now();
                        if (now - lastRenderTime < 1000) {
                            renderCount++;
                            if (renderCount > MAX_RENDERS_PER_SECOND) {
                                console.error('Too many renders detected. Possible infinite loop.');
                                return;
                            }
                        } else {
                            renderCount = 0;
                            lastRenderTime = now;
                        }
                        
                        isRendering = true;
                        try {
                            return originalRender.apply(this, arguments);
                        } finally {
                            isRendering = false;
                        }
                    };
                }
                
                if (typeof window._runEffects === 'function') {
                    window._runEffects = function() {
                        if (isProcessingEffects) {
                            // Queue the effect for later
                            effectQueue.push(arguments);
                            return;
                        }
                        
                        isProcessingEffects = true;
                        try {
                            const result = originalRunEffects.apply(this, arguments);
                            
                            // Process queued effects
                            while (effectQueue.length > 0) {
                                const args = effectQueue.shift();
                                originalRunEffects.apply(this, args);
                            }
                            
                            return result;
                        } finally {
                            isProcessingEffects = false;
                        }
                    };
                }
                
                // Execute the component code
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
  useEffect(() => {
    compileCode(code);
  }, [code, compileCode]);

  const toggleFullscreen = () => {
    setIsFullscreen(!isFullscreen);
  };

  const copyToClipboard = async (text) => {
    try {
      await navigator.clipboard.writeText(text);
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

  return (
    <div className={`shonax-editor ${isFullscreen ? 'fullscreen' : ''}`}>
      <div className="editor-toolbar">
        <div className="toolbar-left">
          <h2 className="editor-title">
            <FileCode className="icon" size={20} />
            Shonax Editor
          </h2>
          <span className="file-name">untitled.shonax</span>
        </div>
        
        <div className="toolbar-center">
          {isCompiling && (
            <div className="status-indicator compiling">
              <RefreshCw className="icon spinning" size={16} />
              <span>Compiling...</span>
            </div>
          )}
          {!isCompiling && errors.length === 0 && (
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
            onClick={() => copyToClipboard(code)}
            title="Copy Shonax Code"
          >
            <Copy size={18} />
          </button>
          <button 
            className="toolbar-btn"
            onClick={() => downloadCode('component.shonax', code)}
            title="Download Shonax File"
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
          <Panel defaultSize={50} minSize={30}>
            <div className="editor-panel h-full">
              <Editor
                height="100%"
                defaultLanguage="shonax"
                theme={editorTheme}
                value={code}
                onChange={setCode}
                beforeMount={handleEditorWillMount}
                onMount={handleEditorDidMount}
                options={{
                  minimap: { enabled: false },
                  fontSize: 14,
                  fontFamily: "'Jetbrains Mono', monospace",
                  lineNumbers: 'on',
                  roundedSelection: false,
                  scrollBeyondLastLine: false,
                  automaticLayout: true,
                  tabSize: 4,
                  wordWrap: 'on',
                  suggest: {
                    showKeywords: true,
                    showSnippets: true
                  }
                }}
              />
            </div>
          </Panel>

          <PanelResizeHandle className="w-1 bg-gray-700 hover:bg-blue-500 transition-colors cursor-col-resize" />

          <Panel defaultSize={50} minSize={30}>
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
                        onClick={() => downloadCode('component.js', compiledCode)}
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
                        readOnly: true,
                        minimap: { enabled: false },
                        fontSize: 13,
                        fontFamily: "'Jetbrains Mono', monospace",
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