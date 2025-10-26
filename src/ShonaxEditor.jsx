// export default ShonaxEditor;

// src/ShonaxEditor.jsx

import React, { useState, useEffect} from 'react';
import { Panel, PanelGroup, PanelResizeHandle } from 'react-resizable-panels';

// Hooks
import { useFileSystem } from './hooks/useFileSystem';
import { useCompiler } from './hooks/useCompiler';
import { useMonacoSetup } from './hooks/useMonacoSetup';

// Components
import Toolbar from './components/Toolbar';
import EditorPanel from './components/EditorPanel';
import PreviewPanel from './components/PreviewPanel';
import SettingsModal from './components/SettingsModal';
import FileManager from './components/FileManager'; // <-- Make sure this is imported

// Utils
import { copyToClipboard, downloadCode } from './utils';

const ShonaxEditor = () => {
  // 1. The useFileSystem hook now provides all file-related state and actions
  const {
    fileTree,         // The entire nested structure of files and folders
    currentFile,
    openTabs,
    code,
    setCode,          // Renamed from updateCurrentCode for clarity
    filesInitialized,
    expandedFolders,  // State for which folders are expanded
    handleFileSelect,
    handleFolderCreate, // New action for creating folders
    handleFileCreate,
    handleDelete,
    handleRename,
    handleSaveFile,
    handleCloseTab,
    toggleFolder,     // New action for expanding/collapsing folders
    getAllFiles,      // Helper to get a flat list of all file objects
  } = useFileSystem();

  // The compiler hook now receives the flat list of all files for bundling
  const {
    compiledCode,
    previewHtml,
    errors,
    isCompiling
  } = useCompiler(code, currentFile, getAllFiles());

  // Monaco setup logic is cleanly separated
  const {
    editorRef,
    handleEditorWillMount,
    handleEditorDidMount
  } = useMonacoSetup();

  // UI-specific state remains here
  const [showFileManager, setShowFileManager] = useState(true);
  const [showSettings, setShowSettings] = useState(false);
  const [isFullscreen, setIsFullscreen] = useState(false);
  const [editorTheme, setEditorTheme] = useState('shonax-dark');
  const [consoleMessages, setConsoleMessages] = useState([]);

  // --- useEffects for handling side-effects ---

  // Listen for console messages from the preview iframe
  useEffect(() => {
    const handleMessage = (event) => {
        if (event.data?.type === 'console') {
            const timestamp = new Date().toLocaleTimeString();
            setConsoleMessages(prev => [...prev, { id: Date.now() + Math.random(), timestamp, ...event.data }]);
        }
    };
    window.addEventListener('message', handleMessage);
    return () => window.removeEventListener('message', handleMessage);
  }, []);

  // Clear console when code changes
  useEffect(() => {
    setConsoleMessages([]);
  }, [code]);

  // Keyboard shortcuts
  useEffect(() => {
    const handleKeyDown = (e) => {
      if ((e.metaKey || e.ctrlKey) && e.key === 's') {
        e.preventDefault();
        handleSaveFile();
      }
      // Add other shortcuts here...
    };
    window.addEventListener('keydown', handleKeyDown);
    return () => window.removeEventListener('keydown', handleKeyDown);
  }, [handleSaveFile]);


  if (!filesInitialized) {
    return (
      <div className="loading-container">
        {/* You can add a nice spinner here */}
        <p>Loading Shonascript Studio...</p>
      </div>
    );
  }

  return (
    <div className={`shonax-editor ${isFullscreen ? 'fullscreen' : ''}`}>
      <Toolbar
        isCompiling={isCompiling}
        errors={errors}
        openTabs={openTabs}
        currentFile={currentFile}
        onSelectTab={handleFileSelect}
        onCloseTab={handleCloseTab}
        onNewFile={handleFileCreate}
        onSaveFile={handleSaveFile}
        onToggleFileManager={() => setShowFileManager(p => !p)}
        onToggleFullscreen={() => setIsFullscreen(p => !p)}
        onShowSettings={() => setShowSettings(true)}
        isFullscreen={isFullscreen}
        onCopyCode={() => copyToClipboard(code)}
        onDownloadCode={() => currentFile && downloadCode(currentFile.name, code)}
      />

      <div className="editor-content h-full">
        <PanelGroup direction="horizontal" className="h-full">
          {showFileManager && (
            <>
              <Panel defaultSize={20} minSize={15} maxSize={30}>
                {/*
                  <<< HERE IS THE CONNECTION >>>
                  We pass the state and actions from the useFileSystem hook
                  directly to the FileManager component as props.
                */}
                <FileManager
                  fileTree={fileTree}
                  currentFile={currentFile}
                  expandedFolders={expandedFolders}
                  onFileSelect={handleFileSelect}
                  onFileCreate={handleFileCreate}
                  onFolderCreate={handleFolderCreate}
                  onDelete={handleDelete}
                  onRename={handleRename}
                  onFileSave={handleSaveFile}
                  toggleFolder={toggleFolder}
                />
              </Panel>
              <PanelResizeHandle className="w-1 bg-gray-700 hover:bg-blue-500 transition-colors cursor-col-resize" />
            </>
          )}
          
          <Panel defaultSize={showFileManager ? 40 : 50} minSize={30}>
            <EditorPanel
              currentFile={currentFile}
              code={code}
              onChange={setCode}
              theme={editorTheme}
              onCreateFile={handleFileCreate}
              onEditorWillMount={handleEditorWillMount}
              onEditorDidMount={handleEditorDidMount}
            />
          </Panel>

          <PanelResizeHandle className="w-1 bg-gray-700 hover:bg-blue-500 transition-colors cursor-col-resize" />

          <Panel defaultSize={showFileManager ? 40 : 50} minSize={30}>
            <PreviewPanel
              previewHtml={previewHtml}
              compiledCode={compiledCode}
              errors={errors}
              consoleMessages={consoleMessages}
              onClearConsole={() => setConsoleMessages([])}
              currentFile={currentFile}
            />
          </Panel>
        </PanelGroup>
      </div>

      <SettingsModal
        isOpen={showSettings}
        onClose={() => setShowSettings(false)}
        editorTheme={editorTheme}
        onThemeChange={setEditorTheme}
        editorRef={editorRef}
      />
    </div>
  );
};

export default ShonaxEditor;