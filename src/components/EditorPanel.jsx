// src/components/EditorPanel.jsx

import React from 'react';
import Editor from '@monaco-editor/react';

const EditorPanel = ({
  code,
  onChange,
  theme,
  isReadOnly, // <-- New prop
  language,   // <-- New prop
  onEditorWillMount,
  onEditorDidMount,
  path,       // <-- New prop
}) => {
  return (
    <div className="editor-panel h-full">
      <Editor
        height="100%"
        // If no language, default to plaintext to avoid errors
        language={language || 'plaintext'}
        theme={theme}
        // If no code, show an empty string
        value={code || ''}
        onChange={onChange}
        beforeMount={onEditorWillMount}
        onMount={onEditorDidMount}
        path={path}
        options={{
          readOnly: isReadOnly, // <-- Control read-only state
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
            showSnippets: true,
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
            strings: false,
          },
          acceptSuggestionOnEnter: 'on',
          suggestOnTriggerCharacters: true,
          smartSelect: {
            selectLeadingAndTrailingWhitespace: false,
          },
        }}
      />
    </div>
  );
};

export default EditorPanel;