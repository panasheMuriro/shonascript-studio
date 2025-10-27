// src/components/SettingsModal.jsx

import React from 'react';

const SettingsModal = ({ 
  isOpen, 
  onClose, 
  editorTheme, 
  onThemeChange, 
  editorRef 
}) => {
  if (!isOpen) return null;

  return (
    <div className="settings-modal">
      <div className="settings-content">
        <h3>Editor Settings</h3>
        <div className="setting-item">
          <label>Theme:</label>
          <select 
            value={editorTheme} 
            onChange={(e) => onThemeChange(e.target.value)}
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
                editorRef.current.updateOptions({ 
                  fontSize: parseInt(e.target.value) 
                });
              }
            }}
          />
        </div>
        <button 
          className="close-btn"
          onClick={onClose}
        >
          Close
        </button>
      </div>
    </div>
  );
};

export default SettingsModal;