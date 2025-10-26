// src/hooks/useMonacoSetup.js

import { useRef, useCallback } from 'react';
import { ShonaxLanguageDefinition, ShonaxTheme, ShonaxLanguageConfiguration } from '../monaco-shonax-language';

export const useMonacoSetup = () => {
  const monacoRef = useRef(null);
  const editorRef = useRef(null);

  const handleEditorWillMount = useCallback((monaco) => {
    monaco.languages.register({ id: 'shonax' });
    monaco.languages.setMonarchTokensProvider('shonax', ShonaxLanguageDefinition);
    monaco.editor.defineTheme('shonax-dark', ShonaxTheme);
    
    monaco.languages.register({ id: 'shona' });
    monaco.languages.setMonarchTokensProvider('shona', ShonaxLanguageDefinition);
    
    monaco.languages.setLanguageConfiguration('shonax', ShonaxLanguageConfiguration);
    monaco.languages.setLanguageConfiguration('shona', ShonaxLanguageConfiguration);
    
    monaco.languages.registerCompletionItemProvider('shonax', {
      triggerCharacters: ['>'],
      provideCompletionItems: (model, position) => {
        const textUntilPosition = model.getValueInRange({
          startLineNumber: 1,
          startColumn: 1,
          endLineNumber: position.lineNumber,
          endColumn: position.column
        });
        
        const match = textUntilPosition.match(/<(\w+)(?:\s+[^>]*)?>$/);
        if (match) {
          const tagName = match[1];
          const word = model.getWordUntilPosition(position);
          const range = {
            startLineNumber: position.lineNumber,
            endLineNumber: position.lineNumber,
            startColumn: word.startColumn,
            endColumn: word.endColumn
          };
          
          return {
            suggestions: [{
              label: `</${tagName}>`,
              kind: monaco.languages.CompletionItemKind.Snippet,
              insertText: `</${tagName}>`,
              insertTextRules: monaco.languages.CompletionItemInsertTextRule.InsertAsSnippet,
              range: range,
              detail: 'Close tag',
              sortText: '0'
            }]
          };
        }
        
        return { suggestions: [] };
      }
    });

    monaco.languages.registerOnTypeFormattingEditProvider('shonax', {
      autoFormatTriggerCharacters: ['>'],
      provideOnTypeFormattingEdits: (model, position, ch) => {
        if (ch === '>') {
          const textUntilPosition = model.getValueInRange({
            startLineNumber: 1,
            startColumn: 1,
            endLineNumber: position.lineNumber,
            endColumn: position.column
          });
          
          const match = textUntilPosition.match(/<(\w+)(?:\s+[^>]*)?>$/);
          if (match) {
            const tagName = match[1];
            const selfClosingTags = ['br', 'hr', 'img', 'input', 'meta', 'link'];
            if (!selfClosingTags.includes(tagName.toLowerCase())) {
              return [{
                range: {
                  startLineNumber: position.lineNumber,
                  startColumn: position.column,
                  endLineNumber: position.lineNumber,
                  endColumn: position.column
                },
                text: `</${tagName}>`
              }];
            }
          }
        }
        return [];
      }
    });

    ['shonax', 'shona'].forEach(lang => {
      monaco.languages.registerDocumentFormattingEditProvider(lang, {
        provideDocumentFormattingEdits: (model) => {
          const edits = [];
          const lineCount = model.getLineCount();
          let indentLevel = 0;
          
          for (let i = 1; i <= lineCount; i++) {
            const lineContent = model.getLineContent(i);
            const trimmedContent = lineContent.trim();
            
            if (!trimmedContent) continue;
            
            if (trimmedContent.startsWith('zvimwe') || trimmedContent.startsWith('else')) {
              indentLevel = Math.max(0, indentLevel - 1);
            }
            
            const properIndent = '    '.repeat(indentLevel);
            const currentIndent = lineContent.match(/^\s*/)[0];
            
            if (currentIndent !== properIndent) {
              edits.push({
                range: new monaco.Range(i, 1, i, currentIndent.length + 1),
                text: properIndent
              });
            }
            
            if (trimmedContent.endsWith(':')) {
              indentLevel++;
            }
            
            if (trimmedContent === '}' || 
                (i < lineCount && model.getLineContent(i + 1).trim().match(/^(zvimwe|else|kana)/))) {
              indentLevel = Math.max(0, indentLevel - 1);
            }
          }
          
          return edits;
        }
      });
    });
  }, []);

  const handleEditorDidMount = useCallback((editor, monaco) => {
    editorRef.current = editor;
    monacoRef.current = monaco;
  }, []);

  return {
    monacoRef,
    editorRef,
    handleEditorWillMount,
    handleEditorDidMount
  };
};