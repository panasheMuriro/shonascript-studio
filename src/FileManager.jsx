// FileManager.jsx
import React, { useState, useEffect } from 'react';
import {
  Folder,
  FolderOpen,
  File,
  FileCode,
  FilePlus,
  FolderPlus,
  Trash2,
  Edit2,
  Save,
  X,
  ChevronRight,
  ChevronDown,
  Search,
  FileText,
  Code2
} from 'lucide-react';

const FileManager = ({ 
  files, 
  currentFile, 
  onFileSelect, 
  onFileCreate, 
  onFileDelete, 
  onFileRename,
  onFolderCreate,
//   onFileSave 
}) => {
  const [expandedFolders, setExpandedFolders] = useState(new Set(['root']));
  const [selectedItem, setSelectedItem] = useState(null);
  const [renamingItem, setRenamingItem] = useState(null);
  const [newName, setNewName] = useState('');
  const [searchQuery, setSearchQuery] = useState('');
  const [contextMenu, setContextMenu] = useState(null);
  const [creatingNew, setCreatingNew] = useState(null);

  const getFileIcon = (fileName) => {
    if (fileName.endsWith('.shonax')) {
      return <Code2 size={16} className="text-blue-400" />;
    } else if (fileName.endsWith('.shona')) {
      return <FileText size={16} className="text-green-400" />;
    }
    return <File size={16} className="text-gray-400" />;
  };

  const toggleFolder = (path) => {
    const newExpanded = new Set(expandedFolders);
    if (newExpanded.has(path)) {
      newExpanded.delete(path);
    } else {
      newExpanded.add(path);
    }
    setExpandedFolders(newExpanded);
  };

  const handleContextMenu = (e, item) => {
    e.preventDefault();
    setContextMenu({
      x: e.clientX,
      y: e.clientY,
      item
    });
  };

  const handleRename = (item) => {
    setRenamingItem(item.path);
    setNewName(item.name);
    setContextMenu(null);
  };

  const handleDelete = (item) => {
    if (window.confirm(`Delete ${item.type === 'folder' ? 'folder' : 'file'} "${item.name}"?`)) {
      onFileDelete(item.path);
    }
    setContextMenu(null);
  };

  const handleCreateNew = (type, parentPath = '') => {
    setCreatingNew({ type, parentPath });
    setContextMenu(null);
  };

  const submitNewItem = () => {
    if (creatingNew && newName.trim()) {
      const fullPath = creatingNew.parentPath 
        ? `${creatingNew.parentPath}/${newName}`
        : newName;
      
      if (creatingNew.type === 'file') {
        // Auto-add extension if not provided
        const finalName = newName.includes('.') ? newName : `${newName}.shonax`;
        onFileCreate(fullPath.replace(newName, finalName), '');
      } else {
        onFolderCreate(fullPath);
        setExpandedFolders(prev => new Set([...prev, fullPath]));
      }
      
      setCreatingNew(null);
      setNewName('');
    }
  };

  const submitRename = () => {
    if (renamingItem && newName.trim()) {
      onFileRename(renamingItem, newName);
      setRenamingItem(null);
      setNewName('');
    }
  };

  const renderFileTree = (items, level = 0) => {
    const filtered = items.filter(item => 
      searchQuery === '' || 
      item.name.toLowerCase().includes(searchQuery.toLowerCase())
    );

    return filtered.map((item) => {
      const isExpanded = expandedFolders.has(item.path);
      const isSelected = selectedItem === item.path;
      const isCurrent = currentFile?.path === item.path;
      const isRenaming = renamingItem === item.path;

      return (
        <div key={item.path}>
          <div
            className={`file-tree-item ${isSelected ? 'selected' : ''} ${isCurrent ? 'current' : ''}`}
            style={{ paddingLeft: `${level * 16 + 8}px` }}
            onClick={() => {
              if (item.type === 'folder') {
                toggleFolder(item.path);
              } else {
                onFileSelect(item);
              }
              setSelectedItem(item.path);
            }}
            onContextMenu={(e) => handleContextMenu(e, item)}
          >
            {item.type === 'folder' ? (
              <>
                <span className="folder-icon">
                  {isExpanded ? <ChevronDown size={14} /> : <ChevronRight size={14} />}
                </span>
                {isExpanded ? <FolderOpen size={16} /> : <Folder size={16} />}
              </>
            ) : (
              <span style={{ width: '14px', display: 'inline-block' }} />
            )}
            
            {isRenaming ? (
              <input
                type="text"
                value={newName}
                onChange={(e) => setNewName(e.target.value)}
                onBlur={submitRename}
                onKeyPress={(e) => e.key === 'Enter' && submitRename()}
                autoFocus
                className="rename-input"
                onClick={(e) => e.stopPropagation()}
              />
            ) : (
              <>
                {item.type === 'file' && getFileIcon(item.name)}
                <span className="item-name">
                  {item.name}
                  {item.modified && <span className="modified-indicator">•</span>}
                </span>
              </>
            )}
          </div>
          
          {item.type === 'folder' && isExpanded && item.children && (
            <div className="folder-children">
              {renderFileTree(item.children, level + 1)}
            </div>
          )}
        </div>
      );
    });
  };

  useEffect(() => {
    const handleClick = () => setContextMenu(null);
    document.addEventListener('click', handleClick);
    return () => document.removeEventListener('click', handleClick);
  }, []);

  return (
    <div className="file-manager">
      <div className="file-manager-header">
        <h3>Files</h3>
        <div className="file-manager-actions">
          <button
            className="icon-btn"
            onClick={() => handleCreateNew('file')}
            title="New File"
          >
            <FilePlus size={16} />
          </button>
          <button
            className="icon-btn"
            onClick={() => handleCreateNew('folder')}
            title="New Folder"
          >
            <FolderPlus size={16} />
          </button>
        </div>
      </div>

      <div className="file-search">
        <Search size={14} />
        <input
          type="text"
          placeholder="Search files..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
      </div>

      <div className="file-tree">
        {renderFileTree(files)}
        
        {creatingNew && (
          <div className="new-item-input" style={{ paddingLeft: '24px' }}>
            {creatingNew.type === 'folder' ? <Folder size={16} /> : <File size={16} />}
            <input
              type="text"
              placeholder={`New ${creatingNew.type} name...`}
              value={newName}
              onChange={(e) => setNewName(e.target.value)}
              onBlur={() => {
                setCreatingNew(null);
                setNewName('');
              }}
              onKeyPress={(e) => {
                if (e.key === 'Enter') submitNewItem();
                if (e.key === 'Escape') {
                  setCreatingNew(null);
                  setNewName('');
                }
              }}
              autoFocus
            />
          </div>
        )}
      </div>

      {contextMenu && (
        <div
          className="context-menu"
          style={{ left: contextMenu.x, top: contextMenu.y }}
        >
          <button onClick={() => handleRename(contextMenu.item)}>
            <Edit2 size={14} /> Rename
          </button>
          <button onClick={() => handleDelete(contextMenu.item)}>
            <Trash2 size={14} /> Delete
          </button>
          {contextMenu.item.type === 'folder' && (
            <>
              <div className="context-menu-divider" />
              <button onClick={() => handleCreateNew('file', contextMenu.item.path)}>
                <FilePlus size={14} /> New File
              </button>
              <button onClick={() => handleCreateNew('folder', contextMenu.item.path)}>
                <FolderPlus size={14} /> New Folder
              </button>
            </>
          )}
        </div>
      )}
    </div>
  );
};

export default FileManager;