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
    '=', '!', '~', '?', ':', '==', '<=', '>=', '!=',
    '&&', '||', '++', '--', '+', '-', '*', '/', '&', '|', '^',
    '%', '<<', '>>', '>>>', '+=', '-=', '*=', '/=', '&=', '|=',
    '^=', '%=', '<<=', '>>=', '>>>='
  ],

  symbols: /[=!~?:&|+\-*\/\^%]+/,
  escapes: /\\(?:[abfnrtv\\"'`]|x[0-9A-Fa-f]{1,4}|u[0-9A-Fa-f]{4}|U[0-9A-Fa-f]{8})/,

  tokenizer: {
    root: [
      { include: '@whitespace' },

      // HTML Tags
      [/<\//, { token: 'tag.bracket', next: '@htmlClosingTag' }],
      [/</, { token: 'tag.bracket', next: '@htmlOpeningTag' }],
      
      // Shona Expressions
      [/{/, { token: 'delimiter.bracket', next: '@shonaExpression' }],
      
      // Rule for Function Calls (must be before general identifier)
      [/[a-zA-Z_]\w*(?=\s*\()/, {
        cases: {
          '@keywords': 'keyword',
          '@default': 'entity.name.function'
        }
      }],
      
      // General Identifiers and Keywords
      [/[a-zA-Z_]\w*/, { cases: { '@keywords': 'keyword', '@default': 'identifier' } }],
      
      // Other language constructs
      [/\d*\.\d+([eE][\-+]?\d+)?/, 'number.float'],
      [/0[xX][0-9a-fA-F]+/, 'number.hex'],
      [/\d+/, 'number'],
      [/"/, { token: 'string.quote', bracket: '@open', next: '@string' }],
      [/'/, { token: 'string.quote', bracket: '@open', next: '@stringSingle' }],
      [/[{}()\[\]]/, '@brackets'],
      [/@symbols/, { cases: { '@operators': 'operator', '@default': '' } }],
      [/[<>]/, 'operator'], // Fallback for < > operators
    ],

    // State for the content BETWEEN tags
    htmlContent: [
      [/[^<{]+/, ''], // Plain text content
      [/<\//, { token: 'tag.bracket', next: '@htmlClosingTag' }],
      [/</, { token: 'tag.bracket', next: '@htmlOpeningTag' }],
      [/{/, { token: 'delimiter.bracket', next: '@shonaExpression' }],
    ],
    
    // State for an opening tag: <tag attr="value">
    htmlOpeningTag: [
      [/[a-zA-Z][\w\-]*/, 'tag.name'],
      [/\s+/, 'white'],
      [/[a-zA-Z\-:]+/, 'attribute.name'],
      [/=/, 'operator'],
      [/"/, { token: 'string.quote', next: '@stringInHtml' }],
      [/'/, { token: 'string.quote', next: '@stringSingleInHtml' }],
      [/\/>/, { token: 'tag.bracket', next: '@pop' }], 
      [/>/, { token: 'tag.bracket', next: '@htmlContent' }],
    ],
    
    // State for a closing tag: </tag>
    htmlClosingTag: [
      [/[a-zA-Z][\w\-]*/, 'tag.name'],
      [/>/, { token: 'tag.bracket', next: '@pop' }], 
    ],

    // Helper states for strings and expressions
    stringInHtml: [
      [/[^\\"]+/, 'string'],
      [/"/, { token: 'string.quote', next: '@pop' }]
    ],
    stringSingleInHtml: [
      [/[^\\']+/, 'string'],
      [/'/, { token: 'string.quote', next: '@pop' }]
    ],
    shonaExpression: [
      [/}/, { token: 'delimiter.bracket', next: '@pop' }],
      { include: '@root' }
    ],
    string: [
      [/[^\\"]+/, 'string'],
      [/@escapes/, 'string.escape'],
      [/"/, { token: 'string.quote', bracket: '@close', next: '@pop' }]
    ],
    stringSingle: [
      [/[^\\']+/, 'string'],
      [/@escapes/, 'string.escape'],
      [/'/, { token: 'string.quote', bracket: '@close', next: '@pop' }]
    ],
    whitespace: [
      [/[ \t\r\n]+/, 'white'],
      [/\/\/.*$/, 'comment'],
      [/\/\*/, 'comment', '@comment']
    ],
    comment: [
      [/[^\/*]+/, 'comment'],
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
    { token: 'tag.bracket', foreground: '808080' },
    { token: 'tag.name', foreground: '569cd6' },
    { token: 'attribute.name', foreground: '9cdcfe' },
    { token: 'operator', foreground: 'd4d4d4' },
    { token: 'delimiter.bracket', foreground: 'ffd700' },
    { token: 'entity.name.function', foreground: 'DCDCAA' }, // Yellow for functions
    { token: '', foreground: 'ffffff' }, // Default text (including HTML content)
  ],
  colors: {
    'editor.background': '#1e1e1e',
    'editor.foreground': '#ffffff',
    'editor.lineHighlightBackground': '#2a2a2a',
    'editorCursor.foreground': '#ffffff',
    'editor.selectionBackground': '#264f78',
    'editor.inactiveSelectionBackground': '#3a3d41'
  }
};

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
      beforeText: /^.*:\s*$/,
      action: { 
        indentAction: 1, // IndentAction.Indent
        appendText: '    '
      }
    },
    {
      beforeText: /{\s*(kana|pane|tarisa|basa|function)\s+.*:\s*$/,
      action: { 
        indentAction: 1,
        appendText: '    '
      }
    },
    {
      beforeText: /^\s*zvimwe\s*:\s*$/,
      action: {
        indentAction: 3, // IndentAction.Outdent
        outdentCurrentLine: true
      }
    },
    {
      beforeText: new RegExp(`<([_:\\w][_:\\w\\-.\\d]*)([^/>]*(?!/)>)[^<]*$`, 'i'),
      afterText: /^<\/([_:\w][_:\w\-.\d]*)\s*>$/i,
      action: { indentAction: 2 } // IndentAction.IndentOutdent
    },
    {
      beforeText: new RegExp(`<(\\w[\\w\\d]*)([^/>]*(?!/)>)[^<]*$`, 'i'),
      action: { indentAction: 1 } // IndentAction.Indent
    }
  ],
  autoCloseBefore: ';:.,=}])> \n\t',
  folding: {
    markers: {
      start: new RegExp("^\\s*<!--\\s*#?region\\b.*-->"),
      end: new RegExp("^\\s*<!--\\s*#?endregion\\b.*-->")
    }
  },
  indentationRules: {
    increaseIndentPattern: /^.*:\s*$/,
    decreaseIndentPattern: /^\s*(zvimwe|else|}\s*$)/
  }
};