// App.jsx
import React, { useState, useEffect, useCallback, useRef } from 'react';
import Editor from '@monaco-editor/react';
import {
  Folder,
  File,
  FileText,
  Play,
  Plus,
  X,
  Save,
  FolderPlus,
  Download,
  Upload,
  Settings,
  Terminal,
  Code2,
  ChevronRight,
  ChevronDown,
  Trash2,
  Edit2,
  Check,
  XCircle,
  AlertCircle,
  Copy,
  FileCode
} from 'lucide-react';
import { translateShona, translateShonax, compileComponent } from '../shonascript/translator-core';
import './App.css';

// File System Store
class FileSystem {
  constructor() {
    this.files = new Map();
    this.folders = new Map();
    this.loadFromStorage();
  }

// Update the FileSystem class loadFromStorage method to include a .shona file:

loadFromStorage() {
  const stored = localStorage.getItem('shonascript-files');
  if (stored) {
    const data = JSON.parse(stored);
    this.files = new Map(data.files);
    this.folders = new Map(data.folders);
  } else {
    // Initialize with sample files
    this.folders.set('/', { name: '/', parent: null, children: ['examples'] });
    this.folders.set('examples', { name: 'examples', parent: '/', children: [] });

    // Add a .shona file example
    this.files.set('examples/hello.shona', {
      name: 'hello.shona',
      path: 'examples/hello.shona',
      content: `// Hello World in Shonascript
nyora "Mhoro Nyika!"

// Variables
name = "Tendai"
age = 25

nyora "Zita rangu ndi", name
nyora "Ndine makore", age

// Arrays and loops
vanhu = ["Tatenda", "Rudo", "Tapiwa", "Chipo", "Farai"]
nyora "Vanhu vese:"

pane munhu mu vanhu:
    nyora "- ", munhu

// Simple calculation
nhamba1 = 10
nhamba2 = 20
huwandu = nhamba1 + nhamba2
nyora "10 + 20 =", huwandu

// Function
basa greet(zita):
    nyora "Mhoro", zita, "!"
    dzosa "Zvakanaka"

mhinduro = greet("Zimbabwe")
nyora "Mhinduro:", mhinduro

// Conditionals
kana age > 18:
    nyora "Uri mukuru"
zvimwe:
    nyora "Uchiri mudiki"`,
      folder: 'examples'
    });

    this.files.set('examples/component.shonax', {
      name: 'component.shonax',
      path: 'examples/component.shonax',
      content: `// Shonax Component Example
count = 0

basa increment():
    count++

basa decrement():
    count--

<div>
    <h1>Counter Demo</h1>
    <h2>Current Count: {count}</h2>
    <div>
        <button rikabayiwa={increment}>
            Wedzera (+)
        </button>
        <button rikabayiwa={decrement}>
            Bvisa (-)
        </button>
    </div>
</div>`,
      folder: 'examples'
    });

    // Also add a simpler example
    this.files.set('examples/list.shonax', {
      name: 'list.shonax',
      path: 'examples/list.shonax',
      content: `// List Example
vanhu = ["Tendai", "Rudo", "Tapiwa", "Chipo"]

<div>
    <h2>Vanhu List</h2>
    <ul>
        {pane m mu vanhu:
            <li>{m}</li>
        }
    </ul>
    <p>Total: {verenga vanhu} people</p>
</div>`,
      folder: 'examples'
    });

    this.saveToStorage();
  }
}

  saveToStorage() {
    const data = {
      files: Array.from(this.files.entries()),
      folders: Array.from(this.folders.entries())
    };
    localStorage.setItem('shonascript-files', JSON.stringify(data));
  }

  createFile(path, content = '') {
    const parts = path.split('/');
    const name = parts.pop();
    const folderPath = parts.join('/') || '/';

    this.files.set(path, {
      name,
      path,
      content,
      folder: folderPath
    });

    const folder = this.folders.get(folderPath);
    if (folder && !folder.children.includes(path)) {
      folder.children.push(path);
    }

    this.saveToStorage();
    return path;
  }

  createFolder(path) {
    const parts = path.split('/');
    const name = parts[parts.length - 1];
    const parent = parts.slice(0, -1).join('/') || '/';

    this.folders.set(path, {
      name,
      parent,
      children: []
    });

    const parentFolder = this.folders.get(parent);
    if (parentFolder) {
      parentFolder.children.push(path);
    }

    this.saveToStorage();
    return path;
  }

  deleteFile(path) {
    const file = this.files.get(path);
    if (file) {
      const folder = this.folders.get(file.folder);
      if (folder) {
        folder.children = folder.children.filter(child => child !== path);
      }
      this.files.delete(path);
      this.saveToStorage();
    }
  }

  deleteFolder(path) {
    const folder = this.folders.get(path);
    if (folder) {
      // Delete all children recursively
      folder.children.forEach(child => {
        if (this.files.has(child)) {
          this.deleteFile(child);
        } else if (this.folders.has(child)) {
          this.deleteFolder(child);
        }
      });

      // Remove from parent
      const parent = this.folders.get(folder.parent);
      if (parent) {
        parent.children = parent.children.filter(child => child !== path);
      }

      this.folders.delete(path);
      this.saveToStorage();
    }
  }

  updateFile(path, content) {
    const file = this.files.get(path);
    if (file) {
      file.content = content;
      this.saveToStorage();
    }
  }

  getFile(path) {
    return this.files.get(path);
  }

  getFolder(path) {
    return this.folders.get(path);
  }

  getAllFiles() {
    return Array.from(this.files.values());
  }
}

// Initialize file system
const fileSystem = new FileSystem();

// Monaco Editor Configuration
const monacoOptions = {
  minimap: { enabled: false },
  fontSize: 14,
  lineNumbers: 'on',
  renderLineHighlight: 'all',
  automaticLayout: true,
  scrollBeyondLastLine: false,
  wordWrap: 'on',
  theme: 'vs-dark'
};

// FileTree Component
function FileTree({ files, folders, selectedFile, onSelectFile, onDeleteFile, onDeleteFolder, onRenameFile, onCreateFile, onCreateFolder }) {
  const [expanded, setExpanded] = useState(new Set(['/', 'examples']));
  const [renaming, setRenaming] = useState(null);
  const [newName, setNewName] = useState('');
  const [creating, setCreating] = useState(null);

  const toggleFolder = (path) => {
    const newExpanded = new Set(expanded);
    if (newExpanded.has(path)) {
      newExpanded.delete(path);
    } else {
      newExpanded.add(path);
    }
    setExpanded(newExpanded);
  };

  const handleRename = (path, isFolder) => {
    setRenaming(path);
    setNewName(isFolder ? folders.get(path).name : files.get(path).name);
  };

  const submitRename = (path, isFolder) => {
    if (newName && newName !== (isFolder ? folders.get(path).name : files.get(path).name)) {
      onRenameFile(path, newName);
    }
    setRenaming(null);
    setNewName('');
  };

  const handleCreate = (parentPath, type) => {
    setCreating({ parent: parentPath, type });
    setNewName('');
  };

  const submitCreate = () => {
    if (newName) {
      const path = creating.parent === '/'
        ? newName
        : `${creating.parent}/${newName}`;

      if (creating.type === 'file') {
        const extension = newName.includes('.') ? '' : '.shona';
        onCreateFile(path + (newName.includes('.') ? '' : extension));
      } else {
        onCreateFolder(path);
      }
    }
    setCreating(null);
    setNewName('');
  };

  const renderFolder = (path) => {
    const folder = folders.get(path);
    if (!folder) return null;

    const isExpanded = expanded.has(path);
    const isRenaming = renaming === path;

    return (
      <div key={path} className="select-none">
        <div className="group flex items-center px-2 py-1 hover:bg-gray-700 rounded cursor-pointer">
          <button
            onClick={() => toggleFolder(path)}
            className="mr-1 p-0.5 hover:bg-gray-600 rounded"
          >
            {isExpanded ? (
              <ChevronDown className="w-4 h-4" />
            ) : (
              <ChevronRight className="w-4 h-4" />
            )}
          </button>

          <Folder className="w-4 h-4 mr-2 text-yellow-500" />

          {isRenaming ? (
            <input
              type="text"
              value={newName}
              onChange={(e) => setNewName(e.target.value)}
              onBlur={() => submitRename(path, true)}
              onKeyDown={(e) => {
                if (e.key === 'Enter') submitRename(path, true);
                if (e.key === 'Escape') setRenaming(null);
              }}
              className="bg-gray-800 border border-blue-500 rounded px-1 text-sm"
              autoFocus
            />
          ) : (
            <>
              <span className="flex-1 text-sm">{folder.name}</span>
              <div className="hidden group-hover:flex items-center gap-1">
                <button
                  onClick={(e) => {
                    e.stopPropagation();
                    handleCreate(path, 'file');
                  }}
                  className="p-1 hover:bg-gray-600 rounded"
                  title="New File"
                >
                  <File className="w-3 h-3" />
                </button>
                <button
                  onClick={(e) => {
                    e.stopPropagation();
                    handleCreate(path, 'folder');
                  }}
                  className="p-1 hover:bg-gray-600 rounded"
                  title="New Folder"
                >
                  <FolderPlus className="w-3 h-3" />
                </button>
                <button
                  onClick={(e) => {
                    e.stopPropagation();
                    handleRename(path, true);
                  }}
                  className="p-1 hover:bg-gray-600 rounded"
                  title="Rename"
                >
                  <Edit2 className="w-3 h-3" />
                </button>
                {path !== '/' && (
                  <button
                    onClick={(e) => {
                      e.stopPropagation();
                      onDeleteFolder(path);
                    }}
                    className="p-1 hover:bg-gray-600 rounded text-red-400"
                    title="Delete"
                  >
                    <Trash2 className="w-3 h-3" />
                  </button>
                )}
              </div>
            </>
          )}
        </div>

        {isExpanded && (
          <div className="ml-4">
            {creating && creating.parent === path && (
              <div className="flex items-center px-2 py-1">
                {creating.type === 'file' ? (
                  <File className="w-4 h-4 mr-2 text-gray-400" />
                ) : (
                  <Folder className="w-4 h-4 mr-2 text-yellow-500" />
                )}
                <input
                  type="text"
                  value={newName}
                  onChange={(e) => setNewName(e.target.value)}
                  onBlur={() => setCreating(null)}
                  onKeyDown={(e) => {
                    if (e.key === 'Enter') submitCreate();
                    if (e.key === 'Escape') setCreating(null);
                  }}
                  placeholder={creating.type === 'file' ? 'filename.shona' : 'folder name'}
                  className="bg-gray-800 border border-blue-500 rounded px-1 text-sm flex-1"
                  autoFocus
                />
              </div>
            )}

            {folder.children.map(child => {
              if (folders.has(child)) {
                return renderFolder(child);
              } else {
                const file = files.get(child);
                if (!file) return null;

                const isSelected = selectedFile === child;
                const isRenaming = renaming === child;
                const icon = file.name.endsWith('.shonax')
                  ? <FileCode className="w-4 h-4 mr-2 text-purple-400" />
                  : <FileText className="w-4 h-4 mr-2 text-blue-400" />;

                return (
                  <div
                    key={child}
                    className={`group flex items-center px-2 py-1 hover:bg-gray-700 rounded cursor-pointer ${isSelected ? 'bg-gray-700' : ''
                      }`}
                    onClick={() => onSelectFile(child)}
                  >
                    {icon}
                    {isRenaming ? (
                      <input
                        type="text"
                        value={newName}
                        onChange={(e) => setNewName(e.target.value)}
                        onBlur={() => submitRename(child, false)}
                        onClick={(e) => e.stopPropagation()}
                        onKeyDown={(e) => {
                          if (e.key === 'Enter') submitRename(child, false);
                          if (e.key === 'Escape') setRenaming(null);
                        }}
                        className="bg-gray-800 border border-blue-500 rounded px-1 text-sm flex-1"
                        autoFocus
                      />
                    ) : (
                      <>
                        <span className="flex-1 text-sm">{file.name}</span>
                        <div className="hidden group-hover:flex items-center gap-1">
                          <button
                            onClick={(e) => {
                              e.stopPropagation();
                              handleRename(child, false);
                            }}
                            className="p-1 hover:bg-gray-600 rounded"
                            title="Rename"
                          >
                            <Edit2 className="w-3 h-3" />
                          </button>
                          <button
                            onClick={(e) => {
                              e.stopPropagation();
                              onDeleteFile(child);
                            }}
                            className="p-1 hover:bg-gray-600 rounded text-red-400"
                            title="Delete"
                          >
                            <Trash2 className="w-3 h-3" />
                          </button>
                        </div>
                      </>
                    )}
                  </div>
                );
              }
            })}
          </div>
        )}
      </div>
    );
  };

  return (
    <div className="p-2">
      {renderFolder('/')}
    </div>
  );
}

// Console Component
function Console({ output, errors }) {
  const consoleRef = useRef(null);

  useEffect(() => {
    if (consoleRef.current) {
      consoleRef.current.scrollTop = consoleRef.current.scrollHeight;
    }
  }, [output, errors]);

  return (
    <div className="h-full flex flex-col bg-gray-900">
      <div className="flex items-center justify-between px-4 py-2 bg-gray-800 border-b border-gray-700">
        <div className="flex items-center gap-2">
          <Terminal className="w-4 h-4" />
          <span className="text-sm font-medium">Console</span>
        </div>
        <button
          onClick={() => {
            // Clear console logic would go here
          }}
          className="text-xs text-gray-400 hover:text-white"
        >
          Clear
        </button>
      </div>

      <div
        ref={consoleRef}
        className="flex-1 p-4 overflow-auto font-mono text-sm"
      >
        {errors.map((error, index) => (
          <div key={`error-${index}`} className="flex items-start gap-2 text-red-400 mb-2">
            <XCircle className="w-4 h-4 mt-0.5 flex-shrink-0" />
            <pre className="whitespace-pre-wrap">{error}</pre>
          </div>
        ))}

        {output.map((line, index) => (
          <div key={`output-${index}`} className="text-gray-300 mb-1">
            <pre className="whitespace-pre-wrap">{line}</pre>
          </div>
        ))}
      </div>
    </div>
  );
}

// Main App Component
export default function App() {
  const [files, setFiles] = useState(fileSystem.getAllFiles());
  const [folders, setFolders] = useState(Array.from(fileSystem.folders));
  const [selectedFile, setSelectedFile] = useState(null);
  const [editorContent, setEditorContent] = useState('');
  const [output, setOutput] = useState([]);
  const [errors, setErrors] = useState([]);
  const [isRunning, setIsRunning] = useState(false);
  const [showOutput, setShowOutput] = useState(true);
  const [compiledCode, setCompiledCode] = useState('');
  const [activeTab, setActiveTab] = useState('console');
  const iframeRef = useRef(null);

  // Load file content when selected
  useEffect(() => {
    if (selectedFile) {
      const file = fileSystem.getFile(selectedFile);
      if (file) {
        setEditorContent(file.content);
      }
    }
  }, [selectedFile]);

  // Save file content
  const saveFile = useCallback(() => {
    if (selectedFile) {
      fileSystem.updateFile(selectedFile, editorContent);
      setFiles(fileSystem.getAllFiles());
    }
  }, [selectedFile, editorContent]);

  // Auto-save
  useEffect(() => {
    const timer = setTimeout(() => {
      saveFile();
    }, 1000);
    return () => clearTimeout(timer);
  }, [editorContent, saveFile]);

  // Create new file
  const createFile = (path) => {
    fileSystem.createFile(path);
    setFiles(fileSystem.getAllFiles());
    setFolders(Array.from(fileSystem.folders));
    setSelectedFile(path);
  };

  // Create new folder
  const createFolder = (path) => {
    fileSystem.createFolder(path);
    setFolders(Array.from(fileSystem.folders));
  };

  // Delete file
  const deleteFile = (path) => {
    if (window.confirm(`Delete ${path}?`)) {
      fileSystem.deleteFile(path);
      setFiles(fileSystem.getAllFiles());
      setFolders(Array.from(fileSystem.folders));
      if (selectedFile === path) {
        setSelectedFile(null);
        setEditorContent('');
      }
    }
  };

  // Delete folder
  const deleteFolder = (path) => {
    if (window.confirm(`Delete folder ${path} and all its contents?`)) {
      fileSystem.deleteFolder(path);
      setFiles(fileSystem.getAllFiles());
      setFolders(Array.from(fileSystem.folders));
    }
  };

  // Run code
  //   const runCode = async () => {
  //     if (!selectedFile) {
  //       setErrors(['No file selected']);
  //       return;
  //     }

  //     setIsRunning(true);
  //     setErrors([]);
  //     setOutput([]);
  //     setCompiledCode('');

  //     try {
  //       let jsCode;
  //       const file = fileSystem.getFile(selectedFile);

  //       if (file.name.endsWith('.shonax')) {
  //         // Component file
  //         const componentName = file.name.replace('.shonax', '').replace(/^\w/, c => c.toUpperCase());
  //         jsCode = compileComponent(editorContent, componentName);

  //         // Create preview HTML
  //         const html = `
  // <!DOCTYPE html>
  // <html>
  // <head>
  //   <style>
  //     body { 
  //       font-family: system-ui, -apple-system, sans-serif; 
  //       padding: 20px;
  //       background: #f3f4f6;
  //     }
  //     button {
  //       background: #3b82f6;
  //       color: white;
  //       border: none;
  //       padding: 8px 16px;
  //       border-radius: 6px;
  //       cursor: pointer;
  //     }
  //     button:hover {
  //       background: #2563eb;
  //     }
  //   </style>
  // </head>
  // <body>
  //   <div id="root"></div>
  //   <script>
  //     // Capture console.log
  //     const originalLog = console.log;
  //     console.log = (...args) => {
  //       window.parent.postMessage({ 
  //         type: 'console', 
  //         data: args.map(a => String(a)).join(' ') 
  //       }, '*');
  //       originalLog(...args);
  //     };

  //     // Capture errors
  //     window.onerror = (msg, source, lineno, colno, error) => {
  //       window.parent.postMessage({ 
  //         type: 'error', 
  //         data: msg 
  //       }, '*');
  //     };

  //     ${jsCode}

  //     // Mount component
  //     const root = document.getElementById('root');
  //     const component = ${componentName}();
  //     root.appendChild(component);
  //   </script>
  // </body>
  // </html>`;

  //         // Update iframe
  //         if (iframeRef.current) {
  //           const doc = iframeRef.current.contentDocument;
  //           doc.open();
  //           doc.write(html);
  //           doc.close();
  //         }

  //         setActiveTab('preview');
  //       } else {
  //         // Regular .shona file
  //         jsCode = translateShona(editorContent, { target: 'browser' });

  //         // Execute in sandboxed context
  //         const sandbox = {
  //           console: {
  //             log: (...args) => {
  //               setOutput(prev => [...prev, args.map(a => String(a)).join(' ')]);
  //             }
  //           },
  //           prompt: (msg) => {
  //             return window.prompt(msg);
  //           }
  //         };

  //         // Create function with sandbox
  //         const func = new Function('console', 'prompt', jsCode);
  //         func(sandbox.console, sandbox.prompt);

  //         setActiveTab('console');
  //       }

  //       setCompiledCode(jsCode);
  //     } catch (error) {
  //       setErrors([error.message]);
  //       setActiveTab('console');
  //     } finally {
  //       setIsRunning(false);
  //     }
  //   };
  // Update the runCode function in App.jsx
const runCode = async () => {
    if (!selectedFile) {
        setErrors(['No file selected']);
        return;
    }

    setIsRunning(true);
    setErrors([]);
    setOutput([]);
    setCompiledCode('');

    try {
        let jsCode;
        const file = fileSystem.getFile(selectedFile);

        if (file.name.endsWith('.shonax')) {
            // --- HANDLE .shonax COMPONENT FILES ---

            // 1. COMPILE
            const componentName = file.name
                .replace('.shonax', '')
                .replace(/[^a-zA-Z0-9]/g, '')
                .replace(/^\w/, c => c.toUpperCase());

            jsCode = compileComponent(editorContent, componentName, { target: 'component' });
            setCompiledCode(jsCode);

            // 2. PROCESS FOR BROWSER
            let functionCode = jsCode.replace(
                /function \$\$createText[\s\S]*?function _runEffects\(\)\{ for\(const f of _effects\) f\(\);\}\s*/,
                ''
            );
            functionCode = functionCode.replace(/^export\s+default\s+function/, 'function');
const fnMatch = functionCode.match(/function\s+([A-Za-z0-9_]+)\s*\(/);
const runtimeName = fnMatch ? fnMatch[1] : componentName;   // <= fallback
            // 3. CREATE PREVIEW HTML
const html = `
<!DOCTYPE html>
<html>
<head> … </head>
<body>
  <div id="root"></div>
  <script>
    (function () {
      /* helpers … */
      ${functionCode}

      const root   = document.getElementById('root');
      const CompFn = typeof ${runtimeName} === 'function' ? ${runtimeName} : null;

      if (CompFn) {
          const node = CompFn();
          if (node instanceof Node) root.appendChild(node);
          else console.error('Component did not return a DOM node');
      } else {
          console.error('Component function "${runtimeName}" was not found');
      }
    })();
  </script>
</body>
</html>`;

            if (iframeRef.current) {
                const doc = iframeRef.current.contentDocument;
                doc.open();
                doc.write(html);
                doc.close();
            }
            setActiveTab('preview');

        } else {
            // --- HANDLE .shona SCRIPT FILES ---

            // 1. COMPILE
            jsCode = translateShona(editorContent, { target: 'browser' });
            setCompiledCode(jsCode);

            // 2. PROCESS FOR BROWSER: Extract the core logic
            // The compiler wraps it in helpers and an IIFE. We just want the inside part.
            let executableCode = jsCode;
            const match = jsCode.match(/\(function\(\)\{\s*([\s\S]*?)\s*\}\)\(\);/);
            if (match && match[1]) {
                executableCode = match[1];
            }
            // Also remove helpers if they are outside the IIFE
            executableCode = executableCode.replace(/function \$\$createText[\s\S]*?function _runEffects\(\)[\s\S]*?\}\s*/, '');


            // 3. CREATE PREVIEW HTML
            const html = `
<!DOCTYPE html>
<html>
<head>
  <style>
    body { font-family: 'Courier New', monospace; padding: 20px; background: #1e1e1e; color: #d4d4d4; margin: 0; }
    .output-line { margin-bottom: 8px; white-space: pre-wrap; word-wrap: break-word; }
  </style>
</head>
<body>
  <div id="console-output"></div>
  <script>
    (function() {
      const outputDiv = document.getElementById('console-output');
      // Polyfill console.log to write to our div
      console.log = (...args) => {
        const line = document.createElement('div');
        line.className = 'output-line';
        line.textContent = args.map(a => typeof a === 'object' ? JSON.stringify(a) : String(a)).join(' ');
        outputDiv.appendChild(line);
        // Also send to parent IDE
        window.parent.postMessage({ type: 'console', data: line.textContent }, '*');
      };
      // Polyfill prompt
      window.prompt = (msg) => window.parent.prompt(msg);

      try {
        // 4. INJECT THE CLEANED, EXECUTABLE CODE
        ${executableCode}
      } catch (error) {
        console.log('❌ Error: ' + error.message);
      }
    })();
  </script>
</body>
</html>`;

            if (iframeRef.current) {
                const doc = iframeRef.current.contentDocument;
                doc.open();
                doc.write(html);
                doc.close();
            }
            setActiveTab('preview');
        }

    } catch (error) {
        console.error('Compilation error:', error);
        setErrors([error.message]);
        setCompiledCode(error.stack || error.message);
        setActiveTab('console');
    } finally {
        setIsRunning(false);
    }
};


  // Listen for messages from iframe
  useEffect(() => {
    const handleMessage = (event) => {
      if (event.data.type === 'console') {
        setOutput(prev => [...prev, event.data.data]);
      } else if (event.data.type === 'error') {
        setErrors(prev => [...prev, event.data.data]);
      }
    };

    window.addEventListener('message', handleMessage);
    return () => window.removeEventListener('message', handleMessage);
  }, []);

  return (
    <div className="h-screen flex flex-col bg-gray-900 text-white">
      {/* Header */}
      <header className="bg-gray-800 border-b border-gray-700 px-4 py-2 flex items-center justify-between">
        <div className="flex items-center gap-4">
          <div className="flex items-center gap-2">
            <Code2 className="w-6 h-6 text-blue-400" />
            <h1 className="text-xl font-bold">Shonascript Studio</h1>
          </div>

          {selectedFile && (
            <div className="flex items-center gap-2 text-sm text-gray-400">
              <span>/</span>
              <span>{selectedFile}</span>
            </div>
          )}
        </div>

        <div className="flex items-center gap-2">
          <button
            onClick={saveFile}
            className="p-2 hover:bg-gray-700 rounded transition-colors"
            title="Save (Ctrl+S)"
          >
            <Save className="w-4 h-4" />
          </button>

          <button
            onClick={runCode}
            disabled={!selectedFile || isRunning}
            className="flex items-center gap-2 px-4 py-2 bg-green-600 hover:bg-green-700 rounded transition-colors disabled:opacity-50 disabled:cursor-not-allowed"
          >
            <Play className="w-4 h-4" />
            <span>Run</span>
          </button>
        </div>
      </header>

      {/* Main Content */}
      <div className="flex-1 flex overflow-hidden">
        {/* Sidebar */}
        <div className="w-64 bg-gray-800 border-r border-gray-700 flex flex-col">
          <div className="p-3 border-b border-gray-700 flex items-center justify-between">
            <span className="text-sm font-medium">Files</span>
            <div className="flex gap-1">
              <button
                onClick={() => createFile('untitled.shona')}
                className="p-1 hover:bg-gray-700 rounded"
                title="New File"
              >
                <Plus className="w-4 h-4" />
              </button>
              <button
                onClick={() => createFolder('new-folder')}
                className="p-1 hover:bg-gray-700 rounded"
                title="New Folder"
              >
                <FolderPlus className="w-4 h-4" />
              </button>
            </div>
          </div>

          <div className="flex-1 overflow-auto">
            <FileTree
              files={new Map(files.map(f => [f.path, f]))}
              folders={new Map(folders)}
              selectedFile={selectedFile}
              onSelectFile={setSelectedFile}
              onDeleteFile={deleteFile}
              onDeleteFolder={deleteFolder}
              onRenameFile={(oldPath, newName) => {
                // Implement rename logic
                console.log('Rename', oldPath, 'to', newName);
              }}
              onCreateFile={createFile}
              onCreateFolder={createFolder}
            />
          </div>
        </div>

        {/* Editor */}
        <div className="flex-1 flex flex-col">
          {selectedFile ? (
            <>
              <div className="flex-1">
                <Editor
                  height="100%"
                  defaultLanguage="javascript"
                  value={editorContent}
                  onChange={setEditorContent}
                  options={monacoOptions}
                  theme="vs-dark"
                />
              </div>

              {/* Output Panel */}
              <div className="h-80 border-t border-gray-700">
   
  <div className="flex bg-gray-800">
    <button
      onClick={() => setActiveTab('console')}
      className={`px-4 py-2 text-sm ${
        activeTab === 'console'
          ? 'bg-gray-900 text-white border-b-2 border-blue-500'
          : 'text-gray-400 hover:text-white'
      }`}
    >
      Console
    </button>
    <button
      onClick={() => setActiveTab('compiled')}
      className={`px-4 py-2 text-sm ${
        activeTab === 'compiled'
          ? 'bg-gray-900 text-white border-b-2 border-blue-500'
          : 'text-gray-400 hover:text-white'
      }`}
    >
      Compiled JS
    </button>
    {/* Show preview for both .shona and .shonax files */}
    <button
      onClick={() => setActiveTab('preview')}
      className={`px-4 py-2 text-sm ${
        activeTab === 'preview'
          ? 'bg-gray-900 text-white border-b-2 border-blue-500'
          : 'text-gray-400 hover:text-white'
      }`}
    >
      Preview
    </button>
  </div>

                <div className="h-full bg-gray-900">
                  {activeTab === 'console' && (
                    <Console output={output} errors={errors} />
                  )}

                  {activeTab === 'compiled' && (
                    <div className="h-full overflow-auto">
                      <Editor
                        height="100%"
                        defaultLanguage="javascript"
                        value={compiledCode}
                        options={{
                          ...monacoOptions,
                          readOnly: true
                        }}
                        theme="vs-dark"
                      />
                    </div>
                  )}

                  {activeTab === 'preview' && (
                    <iframe
                      ref={iframeRef}
                      className="w-full h-full bg-white"
                      title="Preview"
                      sandbox="allow-scripts allow-same-origin allow-modals"
                    />
                  )}
                </div>
              </div>
            </>
          ) : (
            <div className="flex-1 flex items-center justify-center text-gray-500">
              <div className="text-center">
                <FileText className="w-16 h-16 mx-auto mb-4 opacity-50" />
                <p>Select a file to start coding</p>
                <p className="text-sm mt-2">or create a new file</p>
              </div>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}