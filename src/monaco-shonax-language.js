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
      [/<\//, { token: 'tag.bracket', next: '@htmlClosingTag' }],
      [/</, { token: 'tag.bracket', next: '@htmlOpeningTag' }],
      [/{/, { token: 'delimiter.bracket', next: '@shonaExpression' }],
      [/[a-zA-Z_]\w*(?=\s*\()/, { cases: { '@keywords': 'keyword', '@default': 'entity.name.function' } }],
      [/[a-zA-Z_]\w*/, { cases: { '@keywords': 'keyword', '@default': 'identifier' } }],
      [/\d*\.\d+([eE][\-+]?\d+)?/, 'number.float'],
      [/0[xX][0-9a-fA-F]+/, 'number.hex'],
      [/\d+/, 'number'],
      [/"/, { token: 'string.quote', bracket: '@open', next: '@string' }],
      [/'/, { token: 'string.quote', bracket: '@open', next: '@stringSingle' }],
      [/[{}()\[\]]/, '@brackets'],
      [/@symbols/, { cases: { '@operators': 'operator', '@default': '' } }],
      [/[<>]/, 'operator'],
    ],

    htmlContent: [
      [/[^<{]+/, ''],
      [/<\//, { token: 'tag.bracket', next: '@htmlClosingTag' }],
      [/</, { token: 'tag.bracket', next: '@htmlOpeningTag' }],
      [/{/, { token: 'delimiter.bracket', next: '@shonaExpression' }],
    ],
    
    // State for an opening tag: <tag attr="value">
    htmlOpeningTag: [
      // *** MODIFICATION START: Differentiate components from HTML tags ***
      // Rule for custom components (starts with uppercase), must be first.
      [/[A-Z][\w\-]*/, 'entity.name.tag.component'],
      // Rule for standard HTML tags (starts with lowercase).
      [/[a-z][\w\-]*/, 'tag.name'],
      // *** MODIFICATION END ***
      
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
      // *** MODIFICATION START: Differentiate components from HTML tags ***
      // Apply the same logic for closing tags.
      [/[A-Z][\w\-]*/, 'entity.name.tag.component'],
      [/[a-z][\w\-]*/, 'tag.name'],
      // *** MODIFICATION END ***
      
      [/>/, { token: 'tag.bracket', next: '@pop' }], 
    ],

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
    { token: 'tag.name', foreground: '569cd6' }, // Standard HTML tags (blue)
    { token: 'attribute.name', foreground: '9cdcfe' },
    { token: 'operator', foreground: 'd4d4d4' },
    { token: 'delimiter.bracket', foreground: 'ffd700' },
    { token: 'entity.name.function', foreground: 'DCDCAA' }, // Functions (yellow)

    // *** MODIFICATION: Add color for custom components ***
    { token: 'entity.name.tag.component', foreground: '4EC9B0' }, // Components (green/teal)
    
    { token: '', foreground: 'ffffff' },
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

// No changes needed for the language configuration
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
        // REMOVED: appendText: '    ' <-- This was causing the double indent
      }
    },
    {
      beforeText: /{\s*(kana|pane|tarisa|basa|function)\s+.*:\s*$/,
      action: { 
        indentAction: 1, // IndentAction.Indent
        // REMOVED: appendText: '    ' <-- This was also causing a double indent
      }
    },
    {
      // This rule for 'zvimwe' is correct as-is
      beforeText: /^\s*zvimwe\s*:\s*$/,
      action: {
        indentAction: 3, // IndentAction.Outdent
        outdentCurrentLine: true
      }
    },
    {
      // These rules for HTML tags are correct as-is
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

