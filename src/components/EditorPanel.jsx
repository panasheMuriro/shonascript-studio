// src/components/EditorPanel.jsx

import React from 'react';
import Editor from '@monaco-editor/react';
import { FileCode } from 'lucide-react';

const EditorPanel = ({
  currentFile,
  code,
  onChange,
  theme,
  onCreateFile,
  onEditorWillMount,
  onEditorDidMount
}) => {
  if (!currentFile) {
    return (
      <div className="no-file-selected">
        <FileCode size={48} />
        <p>No file selected</p>
        <button 
          className="create-file-btn"
          onClick={() => onCreateFile('new.shonax')}
        >
          Create New File
        </button>
      </div>
    );
  }

  return (
    <div className="editor-panel h-full">
      <Editor
        height="100%"
        language={currentFile.name.endsWith('.shonax') ? 'shonax' : 'shona'}
        theme={theme}
        value={code}
        onChange={onChange}
        beforeMount={onEditorWillMount}
        onMount={onEditorDidMount}
        path={currentFile.path}
        options={{
          minimap: { enabled: false },
          fontSize: 14,
          fontFamily: "'Jetbrains Mono', 'Fira Code', 'Cascadia Code', monospace",
          lineNumbers: 'on',
          roundedSelection: false,
          scrollBeyondLastLine: false,
          automaticLayout: true,
          tabSize: 4,
          insertSpaces: true,
          detectIndentation: false,
          wordWrap: 'on',
          suggest: {
            showKeywords: true,
            showSnippets: true
          },
          autoClosingBrackets: 'always',
          autoClosingQuotes: 'always',
          autoClosingOvertype: 'always',
          autoSurround: 'languageDefined',
          formatOnType: true,
          formatOnPaste: true,
          autoIndent: 'full',
          quickSuggestions: {
            other: true,
            comments: false,
            strings: false
          },
          acceptSuggestionOnEnter: 'on',
          suggestOnTriggerCharacters: true,
          smartSelect: {
            selectLeadingAndTrailingWhitespace: false
          }
        }}
      />
    </div>
  );
};

export default EditorPanel;