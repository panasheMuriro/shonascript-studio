// src/components/PreviewPanel.jsx

import React, { useState, useEffect, useRef } from 'react';
import Editor from '@monaco-editor/react';
import { 
  Eye, Terminal, FileCode, Trash2, Clock, 
  Copy, Download, AlertCircle 
} from 'lucide-react';
import { copyToClipboard, downloadCode, formatConsoleMessage, getConsoleMessageClass } from '../utils';

const PreviewPanel = ({
  previewHtml,
  compiledCode,
  errors,
  consoleMessages,
  onClearConsole,
  currentFile
}) => {
  const [activeTab, setActiveTab] = useState('preview');
  const consoleEndRef = useRef(null);
  const previewRef = useRef(null);

  useEffect(() => {
    if (consoleEndRef.current) {
      consoleEndRef.current.scrollIntoView({ behavior: 'smooth' });
    }
  }, [consoleMessages]);

  return (
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
                onClick={onClearConsole}
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
                readOnly: true,
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
  );
};

export default PreviewPanel;