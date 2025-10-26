// src/components/Toolbar.jsx

import React from 'react';
import { 
  AlertCircle, CheckCircle, FileCode, RefreshCw,
  Settings, Maximize2, Minimize2, Save,
  FolderOpen, X, Plus, Copy, Download,
  File, FileText, Code2
} from 'lucide-react';

const getFileIcon = (fileName) => {
  if (fileName.endsWith('.shonax')) {
    return <Code2 size={14} className="text-blue-400" />;
  } else if (fileName.endsWith('.shona')) {
    return <FileText size={14} className="text-green-400" />;
  }
  return <File size={14} className="text-gray-400" />;
};

const Toolbar = ({
  isCompiling,
  errors,
  openTabs,
  currentFile,
//   showFileManager,
  isFullscreen,
  onFileSelect,
  onCloseTab,
  onNewFile,
  onSaveFile,
  onToggleFileManager,
  onToggleFullscreen,
  onShowSettings,
  onCopyCode,
  onDownloadCode
}) => {
  return (
    <div className="editor-toolbar">
      <div className="toolbar-left">
        <button
          className="toolbar-btn"
          onClick={onToggleFileManager}
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
              onClick={() => onFileSelect(tab)}
            >
              {getFileIcon(tab.name)}
              <span className="tab-name">{tab.name}</span>
              {tab.modified && <span className="modified-dot">•</span>}
              <button
                className="tab-close"
                onClick={(e) => {
                  e.stopPropagation();
                  onCloseTab(tab);
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
              onNewFile(`untitled-${timestamp}.shonax`);
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
          onClick={onSaveFile}
          title="Save (Cmd/Ctrl+S)"
          disabled={!currentFile}
        >
          <Save size={18} />
        </button>
        <button 
          className="toolbar-btn"
          onClick={onCopyCode}
          title="Copy Source Code"
          disabled={!currentFile}
        >
          <Copy size={18} />
        </button>
        <button 
          className="toolbar-btn"
          onClick={onDownloadCode}
          title="Download Source File"
          disabled={!currentFile}
        >
          <Download size={18} />
        </button>
        <button 
          className="toolbar-btn"
          onClick={onShowSettings}
          title="Settings"
        >
          <Settings size={18} />
        </button>
        <button 
          className="toolbar-btn"
          onClick={onToggleFullscreen}
          title={isFullscreen ? 'Exit Fullscreen' : 'Fullscreen'}
        >
          {isFullscreen ? <Minimize2 size={18} /> : <Maximize2 size={18} />}
        </button>
      </div>
    </div>
  );
};

export default Toolbar;