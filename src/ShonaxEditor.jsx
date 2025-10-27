// src/ShonaxEditor.jsx

import React, { useState, useEffect } from 'react';
import { Panel, PanelGroup, PanelResizeHandle } from 'react-resizable-panels';
import { FileCode } from 'lucide-react';

// Hooks
import { useFileSystem } from './hooks/useFileSystem';
import { useCompiler } from './hooks/useCompiler';
import { useMonacoSetup } from './hooks/useMonacoSetup';

// Components & Utils
import Toolbar from './components/Toolbar';
import EditorPanel from './components/EditorPanel';
import PreviewPanel from './components/PreviewPanel';
import SettingsModal from './components/SettingsModal';
import FileManager from './components/FileManager';
import { copyToClipboard, downloadCode } from './utils';

const ShonaxEditor = () => {
  // Hooks remain the same
  const {
    fileTree, currentFile, openTabs, code, setCode, filesInitialized, expandedFolders,
    handleFileSelect, handleFolderCreate, handleFileCreate, handleDelete, handleRename,
    handleSaveFile, handleCloseTab, toggleFolder, getAllFiles,
  } = useFileSystem();

  const { compiledCode, previewHtml, errors, isCompiling } = useCompiler(code, currentFile, getAllFiles());
  const { editorRef, handleEditorWillMount, handleEditorDidMount } = useMonacoSetup();

  // UI state remains the same
  const [showFileManager, setShowFileManager] = useState(true);
  const [showSettings, setShowSettings] = useState(false);
  const [isFullscreen, setIsFullscreen] = useState(false);
  const [editorTheme, setEditorTheme] = useState('shonax-dark');
  const [consoleMessages, setConsoleMessages] = useState([]);

  // useEffects remain the same
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

  if (!filesInitialized) {
    return <div className="loading-container"><p>Loading Shonascript Studio...</p></div>;
  }

  return (
    <div className={`shonax-editor ${isFullscreen ? 'fullscreen' : ''}`}>
      {/* Toolbar remains the same */}
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
                {/* FileManager remains the same */}
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
            {/* EditorPanel and overlay logic remains the same */}
            <div className="editor-panel-wrapper">
              <EditorPanel
                code={code}
                onChange={setCode}
                theme={editorTheme}
                isReadOnly={!currentFile}
                language={currentFile?.name.endsWith('.shonax') ? 'shonax' : 'shona'}
                path={currentFile?.path}
                onEditorWillMount={handleEditorWillMount}
                onEditorDidMount={handleEditorDidMount}
              />
              {!currentFile && (
                <div className="no-file-overlay">
                  <FileCode size={48} className="text-gray-500" />
                  <p>No file open</p>
                  <button className="create-file-btn" onClick={() => handleFileCreate('new-example.shonax')}>Create New File</button>
                </div>
              )}
            </div>
          </Panel>

          <PanelResizeHandle className="w-1 bg-gray-700 hover:bg-blue-500 transition-colors cursor-col-resize" />

          <Panel defaultSize={showFileManager ? 40 : 50} minSize={30}>
            {/* --- THIS IS THE KEY FIX --- */}
            <PreviewPanel
              previewHtml={previewHtml}
              compiledCode={compiledCode}
              errors={errors}
              consoleMessages={consoleMessages}
              onClearConsole={() => setConsoleMessages([])}
              currentFile={currentFile}
              onEditorWillMount={handleEditorWillMount} // <-- Pass the setup function
              editorTheme={editorTheme}               // <-- Pass the current theme
            />
          </Panel>
        </PanelGroup>
      </div>

      {/* SettingsModal remains the same */}
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