// // src/components/Toolbar.jsx

// import React from 'react';
// import { 
//   AlertCircle, CheckCircle, FileCode, RefreshCw,
//   Settings, Maximize2, Minimize2, Save,
//   FolderOpen, X, Plus, Copy, Download,
//   File, FileText, Code2
// } from 'lucide-react';

// const getFileIcon = (fileName) => {
//   if (fileName.endsWith('.shonax')) {
//     return <Code2 size={14} className="text-blue-400" />;
//   } else if (fileName.endsWith('.shona')) {
//     return <FileText size={14} className="text-green-400" />;
//   }
//   return <File size={14} className="text-gray-400" />;
// };

// const Toolbar = ({
//   isCompiling,
//   errors,
//   openTabs,
//   currentFile,
// //   showFileManager,
//   isFullscreen,
//   onFileSelect,
//   onCloseTab,
//   onNewFile,
//   onSaveFile,
//   onToggleFileManager,
//   onToggleFullscreen,
//   onShowSettings,
//   onCopyCode,
//   onDownloadCode
// }) => {
//   return (
//     <div className="editor-toolbar">
//       <div className="toolbar-left">
//         <button
//           className="toolbar-btn"
//           onClick={onToggleFileManager}
//           title="Toggle File Manager (Cmd/Ctrl+B)"
//         >
//           <FolderOpen size={18} />
//         </button>
//         <h2 className="editor-title">
//           <FileCode className="icon" size={20} />
//           Shonascript Studio
//         </h2>
//       </div>
      
//       <div className="toolbar-center">
//         <div className="open-tabs">
//           {openTabs.map(tab => (
//             <div
//               key={tab.path}
//               className={`tab-item ${currentFile?.path === tab.path ? 'active' : ''}`}
//               onClick={() => onFileSelect(tab)}
//             >
//               {getFileIcon(tab.name)}
//               <span className="tab-name">{tab.name}</span>
//               {tab.modified && <span className="modified-dot">•</span>}
//               <button
//                 className="tab-close"
//                 onClick={(e) => {
//                   e.stopPropagation();
//                   onCloseTab(tab);
//                 }}
//               >
//                 <X size={12} />
//               </button>
//             </div>
//           ))}
//           <button
//             className="new-tab-btn"
//             onClick={() => {
//               const timestamp = Date.now();
//               onNewFile(`untitled-${timestamp}.shonax`);
//             }}
//             title="New File (Cmd/Ctrl+N)"
//           >
//             <Plus size={14} />
//           </button>
//         </div>
        
//         {isCompiling && (
//           <div className="status-indicator compiling">
//             <RefreshCw className="icon spinning" size={16} />
//             <span>Compiling...</span>
//           </div>
//         )}
//         {!isCompiling && errors.length === 0 && currentFile && (
//           <div className="status-indicator success">
//             <CheckCircle className="icon" size={16} />
//             <span>Ready</span>
//           </div>
//         )}
//         {!isCompiling && errors.length > 0 && (
//           <div className="status-indicator error">
//             <AlertCircle className="icon" size={16} />
//             <span>{errors.length} {errors.length === 1 ? 'error' : 'errors'}</span>
//           </div>
//         )}
//       </div>
      
//       <div className="toolbar-right">
//         <button 
//           className="toolbar-btn"
//           onClick={onSaveFile}
//           title="Save (Cmd/Ctrl+S)"
//           disabled={!currentFile}
//         >
//           <Save size={18} />
//         </button>
//         <button 
//           className="toolbar-btn"
//           onClick={onCopyCode}
//           title="Copy Source Code"
//           disabled={!currentFile}
//         >
//           <Copy size={18} />
//         </button>
//         <button 
//           className="toolbar-btn"
//           onClick={onDownloadCode}
//           title="Download Source File"
//           disabled={!currentFile}
//         >
//           <Download size={18} />
//         </button>
//         <button 
//           className="toolbar-btn"
//           onClick={onShowSettings}
//           title="Settings"
//         >
//           <Settings size={18} />
//         </button>
//         <button 
//           className="toolbar-btn"
//           onClick={onToggleFullscreen}
//           title={isFullscreen ? 'Exit Fullscreen' : 'Fullscreen'}
//         >
//           {isFullscreen ? <Minimize2 size={18} /> : <Maximize2 size={18} />}
//         </button>
//       </div>
//     </div>
//   );
// };

// export default Toolbar;

// src/components/Toolbar.jsx

import React, { useState, useRef, useEffect } from 'react';
import { 
  AlertCircle, CheckCircle, FileCode, RefreshCw,
  Settings, Maximize2, Minimize2, Save,
  FolderOpen, X, Plus, Copy, Download,
  File, FileText, Code2, MoreHorizontal
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
  const activeTabRef = useRef(null);
  const [showAllTabs, setShowAllTabs] = useState(false);

  // This effect ensures the active tab is always visible if it's within the scroll area
  useEffect(() => {
    if (activeTabRef.current) {
      activeTabRef.current.scrollIntoView({
        behavior: 'smooth',
        inline: 'center',
        block: 'nearest'
      });
    }
  }, [currentFile]);

  // Logic to determine which tabs to display
  const getVisibleTabs = () => {
    if (openTabs.length <= 3) {
      return openTabs; // If 3 or fewer tabs, show all
    }
    
    if (!currentFile) {
      return openTabs.slice(-3); // If no file is active, show the last 3 opened
    }

    const visible = [currentFile];
    const otherTabs = openTabs.filter(tab => tab.path !== currentFile.path);
    
    // Add the two most recent other tabs to the visible list
    for (let i = otherTabs.length - 1; i >= 0 && visible.length < 3; i--) {
      visible.unshift(otherTabs[i]); // Add to the beginning to maintain some order
    }

    // Sort them back into the original open order for consistent placement
    return visible.sort((a, b) => openTabs.indexOf(a) - openTabs.indexOf(b));
  };

  const visibleTabs = getVisibleTabs();
  const hiddenTabs = openTabs.filter(tab => !visibleTabs.find(visibleTab => visibleTab.path === tab.path));
  const hiddenTabsCount = hiddenTabs.length;

  return (
    <div className="flex items-center bg-[#252526] text-gray-300 h-12 border-b border-black/30 overflow-hidden">
      {/* Left Section */}
      <div className="flex items-center flex-shrink-0 px-2">
        <button
          className="p-2 rounded hover:bg-white/10"
          onClick={onToggleFileManager}
          title="Toggle File Manager (Cmd+B)"
        >
          <FolderOpen size={18} />
        </button>
        <h2 className="flex items-center gap-2 ml-2 text-sm font-semibold select-none">
          <FileCode size={20} />
          Shonascript Studio
        </h2>
      </div>
      
      {/* Center Section (Tabs & Status) */}
      <div className="flex-grow flex items-center min-w-0">
        <div className="flex-grow flex items-center overflow-hidden">
          {/* Visible Tabs */}
          {visibleTabs.map(tab => {
            const isActive = currentFile?.path === tab.path;
            return (
              <div
                ref={isActive ? activeTabRef : null}
                key={tab.path}
                className={`flex items-center gap-1.5 h-12 px-3 border-r border-black/30 cursor-pointer flex-shrink-0 ${isActive ? 'bg-[#1e1e1e]' : 'hover:bg-white/5'}`}
                onClick={() => onFileSelect(tab)}
                title={tab.path}
              >
                {getFileIcon(tab.name)}
                <span className={`text-sm truncate max-w-[150px] ${isActive ? 'text-white' : 'text-gray-400'}`}>
                  {tab.name}
                </span>
                {tab.modified && <span className="text-yellow-400 -ml-1 font-bold text-lg leading-none">•</span>}
                <button
                  className="p-1 rounded-full hover:bg-white/20"
                  onClick={(e) => { e.stopPropagation(); onCloseTab(tab); }}
                >
                  <X size={12} />
                </button>
              </div>
            );
          })}
          
          {/* "More" button and dropdown */}
          {hiddenTabsCount > 0 && (
            <div className="relative">
              <button
                className="flex items-center justify-center h-12 w-10 flex-shrink-0 hover:bg-white/10"
                onClick={() => setShowAllTabs(!showAllTabs)}
                title={`${hiddenTabsCount} more tabs`}
              >
                <MoreHorizontal size={16} />
              </button>
              {showAllTabs && (
                <div 
                  className="absolute top-full left-0 mt-1 bg-[#2d2d2d] border border-black/50 rounded-md shadow-lg z-20 w-56 max-h-80 overflow-y-auto"
                  onMouseLeave={() => setShowAllTabs(false)}
                >
                  <div className="py-1">
                    <div className="px-3 py-2 text-xs text-gray-400 uppercase tracking-wider">More Open Tabs</div>
                    {hiddenTabs.map(hiddenTab => (
                      <a
                        key={hiddenTab.path}
                        href="#"
                        onClick={(e) => {
                          e.preventDefault();
                          onFileSelect(hiddenTab);
                          setShowAllTabs(false);
                        }}
                        className="flex items-center gap-2 px-3 py-2 text-sm text-gray-300 hover:bg-blue-600/30"
                        title={hiddenTab.path}
                      >
                        {getFileIcon(hiddenTab.name)}
                        <span className="truncate">{hiddenTab.name}</span>
                        {hiddenTab.modified && <span className="text-yellow-400 ml-auto font-bold text-lg leading-none">•</span>}
                      </a>
                    ))}
                  </div>
                </div>
              )}
            </div>
          )}

          {/* "New Tab" button */}
          <button
            className="flex items-center justify-center h-12 w-10 flex-shrink-0 border-l border-black/30 hover:bg-white/10"
            onClick={() => onNewFile(`untitled-${Date.now()}.shonax`)}
            title="New File (Cmd+N)"
          >
            <Plus size={14} />
          </button>
        </div>
        
        {/* Status Indicators */}
        <div className="flex-shrink-0 px-4 text-sm">
          {isCompiling && (
            <div className="flex items-center gap-2 text-yellow-400">
              <RefreshCw className="animate-spin" size={16} />
              <span>Compiling...</span>
            </div>
          )}
          {!isCompiling && errors.length === 0 && currentFile && (
            <div className="flex items-center gap-2 text-green-400">
              <CheckCircle size={16} />
              <span>Ready</span>
            </div>
          )}
          {!isCompiling && errors.length > 0 && (
            <div className="flex items-center gap-2 text-red-400">
              <AlertCircle size={16} />
              <span>{errors.length} {errors.length === 1 ? 'Error' : 'Errors'}</span>
            </div>
          )}
        </div>
      </div>
      
      {/* Right Section */}
      <div className="flex items-center flex-shrink-0 px-2 gap-1">
        <button 
          className="p-2 rounded hover:bg-white/10 disabled:opacity-30 disabled:cursor-not-allowed"
          onClick={onSaveFile}
          title="Save (Cmd+S)"
          disabled={!currentFile?.modified}
        >
          <Save size={18} />
        </button>
        <button className="p-2 rounded hover:bg-white/10 disabled:opacity-30" onClick={onCopyCode} title="Copy Source" disabled={!currentFile}><Copy size={18} /></button>
        <button className="p-2 rounded hover:bg-white/10 disabled:opacity-30" onClick={onDownloadCode} title="Download File" disabled={!currentFile}><Download size={18} /></button>
        <button className="p-2 rounded hover:bg-white/10" onClick={onShowSettings} title="Settings"><Settings size={18} /></button>
        <button className="p-2 rounded hover:bg-white/10" onClick={onToggleFullscreen} title={isFullscreen ? 'Exit Fullscreen' : 'Fullscreen'}>
          {isFullscreen ? <Minimize2 size={18} /> : <Maximize2 size={18} />}
        </button>
      </div>
    </div>
  );
};

export default Toolbar;