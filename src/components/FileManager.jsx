// src/components/FileManager.jsx

import React, { useState } from 'react';
import {
  File,
  Folder,
  FolderOpen,
  Plus,
  Trash2,
  Edit2,
  Save,
  X,
  FileText,
  Code2,
  ChevronRight,
  ChevronDown
} from 'lucide-react';

const FileTreeItem = ({
  item,
  level = 0,
  currentFile,
  expandedFolders,
  onSelect,
  onDelete,
  onRename,
  onToggleFolder,
  onCreateFile,
  onCreateFolder
}) => {
  const [isRenaming, setIsRenaming] = useState(false);
  const [newName, setNewName] = useState(item.name);
  const [showActions, setShowActions] = useState(false);

  const isFolder = item.type === 'folder';
  const isExpanded = isFolder && expandedFolders.has(item.path);
  const isSelected = currentFile?.path === item.path;

  const handleRename = () => {
    if (newName && newName !== item.name) {
      onRename(item.path, newName);
    }
    setIsRenaming(false);
  };

  const handleClick = (e) => {
    e.stopPropagation();
    if (isFolder) {
      onToggleFolder(item.path);
    } else {
      onSelect(item);
    }
  };

  const getFileIcon = () => {
    if (isFolder) {
      return isExpanded ? <FolderOpen size={16} /> : <Folder size={16} />;
    }
    if (item.name.endsWith('.shonax')) {
      return <Code2 size={16} className="text-blue-400" />;
    }
    if (item.name.endsWith('.shona')) {
      return <FileText size={16} className="text-green-400" />;
    }
    return <File size={16} className="text-gray-400" />;
  };

  return (
    <div>
      <div
        className={`file-tree-item ${isSelected ? 'selected' : ''} ${showActions ? 'show-actions' : ''}`}
        style={{ paddingLeft: `${level * 16 + 8}px` }}
        onClick={handleClick}
        onMouseEnter={() => setShowActions(true)}
        onMouseLeave={() => setShowActions(false)}
      >
        <div className="file-tree-item-content">
          {isFolder && (
            <span className="folder-arrow">
              {isExpanded ? <ChevronDown size={14} /> : <ChevronRight size={14} />}
            </span>
          )}
          
          <span className="file-icon">{getFileIcon()}</span>
          
          {isRenaming ? (
            <input
              type="text"
              value={newName}
              onChange={(e) => setNewName(e.target.value)}
              onBlur={handleRename}
              onKeyDown={(e) => {
                if (e.key === 'Enter') handleRename();
                if (e.key === 'Escape') {
                  setNewName(item.name);
                  setIsRenaming(false);
                }
              }}
              onClick={(e) => e.stopPropagation()}
              autoFocus
              className="rename-input"
            />
          ) : (
            <span className="file-name">
              {item.name}
              {item.modified && <span className="modified-indicator">•</span>}
            </span>
          )}
        </div>

        {showActions && !isRenaming && (
          <div className="file-actions">
            {isFolder && (
              <>
                <button
                  title="New File"
                  onClick={(e) => {
                    e.stopPropagation();
                    const name = prompt('File name:');
                    if (name) onCreateFile(`${item.path}/${name}`);
                  }}
                >
                  <Plus size={14} />
                </button>
                <button
                  title="New Folder"
                  onClick={(e) => {
                    e.stopPropagation();
                    const name = prompt('Folder name:');
                    if (name) onCreateFolder(item.path, name);
                  }}
                >
                  <Folder size={14} />
                </button>
              </>
            )}
            <button
              title="Rename"
              onClick={(e) => {
                e.stopPropagation();
                setIsRenaming(true);
              }}
            >
              <Edit2 size={14} />
            </button>
            <button
              title="Delete"
              onClick={(e) => {
                e.stopPropagation();
                onDelete(item.path);
              }}
            >
              <Trash2 size={14} />
            </button>
          </div>
        )}
      </div>

      {isFolder && isExpanded && item.children && (
        <div className="file-tree-children">
          {item.children.map((child) => (
            <FileTreeItem
              key={child.path}
              item={child}
              level={level + 1}
              currentFile={currentFile}
              expandedFolders={expandedFolders}
              onSelect={onSelect}
              onDelete={onDelete}
              onRename={onRename}
              onToggleFolder={onToggleFolder}
              onCreateFile={onCreateFile}
              onCreateFolder={onCreateFolder}
            />
          ))}
        </div>
      )}
    </div>
  );
};

const FileManager = ({
  fileTree,
  currentFile,
  expandedFolders,
  onFileSelect,
  onFileCreate,
  onFolderCreate,
  onDelete,
  onRename,
  onFileSave,
  toggleFolder
}) => {
  return (
    <div className="file-manager">
      <div className="file-manager-header">
        <h3>Files</h3>
        <div className="file-manager-actions">
          <button
            title="New File"
            onClick={() => {
              const name = prompt('File name:');
              if (name) onFileCreate(name);
            }}
          >
            <Plus size={16} />
          </button>
          <button
            title="New Folder"
            onClick={() => {
              const name = prompt('Folder name:');
              if (name) onFolderCreate(null, name);
            }}
          >
            <Folder size={16} />
          </button>
          {currentFile?.modified && (
            <button title="Save" onClick={onFileSave}>
              <Save size={16} />
            </button>
          )}
        </div>
      </div>

      <div className="file-tree">
        {fileTree.map((item) => (
          <FileTreeItem
            key={item.path}
            item={item}
            currentFile={currentFile}
            expandedFolders={expandedFolders}
            onSelect={onFileSelect}
            onDelete={onDelete}
            onRename={onRename}
            onToggleFolder={toggleFolder}
            onCreateFile={onFileCreate}
            onCreateFolder={onFolderCreate}
          />
        ))}
      </div>
    </div>
  );
};

export default FileManager;