/* eslint-disable no-useless-escape */
// monaco-shonax-language.js

export const ShonaxLanguageDefinition = {
  defaultToken: '',
  tokenPostfix: '.shonax',

  keywords: [
    'pane', 'kana', 'tarisa', 'zvanyorwa', 'ikanyorwa', 'ikasarudzwa',
    'zvasarudzwa', 'ronga', 'vakasiyana', 'akasiyana', 'dzakasiyana',
    'tambira', 'ane', 'vane', 'mune', 'mine', 'une', 'rine', 'ine',
    'dzine', 'chokwadi', 'kwete', 'uye', 'and', 'or', 'zvimwe',
    'function', 'basa', 'kuti', 'nyora', 'return', 'dzosa', 'isa',
    'bvisa', 'mu', 'class', 'className', 'verenga', 'batanidza', 'pa', 'bvunza',
    'tora', 'kubva', 'ku', 'jamba', 'mira', 'dzokorora', 'mirira',
    'seconds', 'ndi'
  ],

  operators: [
    '=', '>', '<', '!', '~', '?', ':', '==', '<=', '>=', '!=',
    '&&', '||', '++', '--', '+', '-', '*', '/', '&', '|', '^',
    '%', '<<', '>>', '>>>', '+=', '-=', '*=', '/=', '&=', '|=',
    '^=', '%=', '<<=', '>>=', '>>>='
  ],

  // Regular expressions
  symbols: /[=><!~?:&|+\-*\/\^%]+/,
  escapes: /\\(?:[abfnrtv\\"'`]|x[0-9A-Fa-f]{1,4}|u[0-9A-Fa-f]{4}|U[0-9A-Fa-f]{8})/,

  tokenizer: {
    root: [
      // HTML tags
      [/<\/?[a-zA-Z][\w\-]*/, 'tag'],

      // Identifiers and keywords
      [/[a-zA-Z_]\w*/, {
        cases: {
          '@keywords': 'keyword',
          '@default': 'identifier'
        }
      }],

      // Whitespace
      { include: '@whitespace' },

      // Numbers
      [/\d*\.\d+([eE][\-+]?\d+)?/, 'number.float'],
      [/0[xX][0-9a-fA-F]+/, 'number.hex'],
      [/\d+/, 'number'],

      // Strings
      [/"/, { token: 'string.quote', bracket: '@open', next: '@string' }],
      [/'/, { token: 'string.quote', bracket: '@open', next: '@stringSingle' }],

      // Delimiters and operators
       [/[{}()\[\]]/, '@brackets'],
      [/@symbols/, {
        cases: {
          '@operators': 'operator',
          '@default': ''
        }
      }],

      // Shona expressions in HTML
      [/{/, { token: 'delimiter.bracket', next: '@shonaExpression' }],
    ],

    string: [
      [/[^\\"]+/, 'string'],
      [/@escapes/, 'string.escape'],
      [/\\./, 'string.escape.invalid'],
      [/"/, { token: 'string.quote', bracket: '@close', next: '@pop' }]
    ],

    stringSingle: [
      [/[^\\']+/, 'string'],
      [/@escapes/, 'string.escape'],
      [/\\./, 'string.escape.invalid'],
      [/'/, { token: 'string.quote', bracket: '@close', next: '@pop' }]
    ],

    shonaExpression: [
      [/}/, { token: 'delimiter.bracket', next: '@pop' }],
      { include: '@root' }
    ],

    whitespace: [
      [/[ \t\r\n]+/, 'white'],
      [/\/\/.*$/, 'comment'],
      [/\/\*/, 'comment', '@comment']
    ],

    comment: [
      [/[^\/*]+/, 'comment'],
      [/\/\*/, 'comment', '@push'],
      [/\*\//, 'comment', '@pop'],
      [/[\/*]/, 'comment']
    ]
  }
};

export const ShonaxTheme = {
  base: 'vs-dark',
  inherit: true,
  rules: [
    { token: 'keyword', foreground: 'c586c0' },
    { token: 'identifier', foreground: '9cdcfe' },
    { token: 'string', foreground: 'ce9178' },
    { token: 'number', foreground: 'b5cea8' },
    { token: 'comment', foreground: '6a9955' },
    { token: 'tag', foreground: '569cd6' },
    { token: 'operator', foreground: 'd4d4d4' },
    { token: 'delimiter.bracket', foreground: 'ffd700' }
  ],
  colors: {
    'editor.background': '#1e1e1e',
    'editor.foreground': '#d4d4d4',
    'editor.lineHighlightBackground': '#2a2a2a',
    'editorCursor.foreground': '#ffffff',
    'editor.selectionBackground': '#264f78',
    'editor.inactiveSelectionBackground': '#3a3d41'
  }
};

// Language configuration for auto-closing tags and brackets with Python-like indentation
export const ShonaxLanguageConfiguration = {
  comments: {
    lineComment: '//',
    blockComment: ['/*', '*/']
  },
  brackets: [
    ['{', '}'],
    ['[', ']'],
    ['(', ')'],
    ['<', '>']
  ],
  autoClosingPairs: [
    { open: '{', close: '}' },
    { open: '[', close: ']' },
    { open: '(', close: ')' },
    { open: '"', close: '"' },
    { open: "'", close: "'" },
    { open: '<', close: '>' }
  ],
  surroundingPairs: [
    { open: '{', close: '}' },
    { open: '[', close: ']' },
    { open: '(', close: ')' },
    { open: '"', close: '"' },
    { open: "'", close: "'" },
    { open: '<', close: '>' }
  ],
  onEnterRules: [
    {
      // Auto-indent after colon for Shonax control structures
      // Matches: kana ... :, pane ... :, basa ... :, tarisa:, etc.
      beforeText: /^.*:\s*$/,
      action: { 
        indentAction: 1, // IndentAction.Indent
        appendText: '    ' // Add 4 spaces for indentation
      }
    },
    {
      // Auto-indent after colon in HTML context (for control flow in templates)
      // Matches: {kana ... :, {pane ... :
      beforeText: /{\s*(kana|pane|tarisa|basa|function)\s+.*:\s*$/,
      action: { 
        indentAction: 1,
        appendText: '    '
      }
    },
    {
      // Dedent on 'zvimwe' (else)
      beforeText: /^\s*zvimwe\s*:\s*$/,
      action: {
        indentAction: 3, // IndentAction.Outdent
        outdentCurrentLine: true
      }
    },
    {
      // Auto-close HTML tags
      beforeText: new RegExp(`<([_:\\w][_:\\w\\-.\\d]*)([^/>]*(?!/)>)[^<]*$`, 'i'),
      afterText: /^<\/([_:\w][_:\w\-.\d]*)\s*>$/i,
      action: { indentAction: 2 } // IndentAction.IndentOutdent
    },
    {
      // Auto-close HTML tags when pressing Enter after >
      beforeText: new RegExp(`<(\\w[\\w\\d]*)([^/>]*(?!/)>)[^<]*$`, 'i'),
      action: { indentAction: 1 } // IndentAction.Indent
    }
  ],
  // Enable auto-closing tags
  autoCloseBefore: ';:.,=}])> \n\t',
  // Folding markers
  folding: {
    markers: {
      start: new RegExp("^\\s*<!--\\s*#?region\\b.*-->"),
      end: new RegExp("^\\s*<!--\\s*#?endregion\\b.*-->")
    }
  },
  // Indentation rules for better Python-like behavior
  indentationRules: {
    increaseIndentPattern: /^.*:\s*$/,
    decreaseIndentPattern: /^\s*(zvimwe|else|}\s*$)/
  }
}