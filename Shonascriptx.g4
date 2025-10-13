grammar Shonascriptx;

/* ───────────────────── PROGRAM ───────────────────── */
program : programElement* EOF ;
programElement : htmlElement | line | reactiveBlock ;
line : statement NEWLINE | NEWLINE ;
statement : simpleStatement | compoundStatement ;

/* ───────── SIMPLE / COMPOUND STATEMENTS ───────── */
simpleStatement
    : anonymousFunctionAssignment
    | assignment
    | incrementStatement
    | decrementStatement
    | compoundAssignment
    | nyoraStatement
    | propertyDelete
    | returnStatement
    | arrayAdd
    | arrayRemove
    | setDeclaration      
    | sortStatement      
    | filterStatement    
    | classStatement
    | continueStatement
    | breakStatement
    | expression
    | inputStatement
    | importStatement
    | intervalStatement
    | timeoutStatement
    | fetchStatement
    | linearObjectDefinition 
    | propsDeclaration 
    | reactiveOneLiner       
    ;

reactiveOneLiner
    : TARISA COLON statement           
    ;

reactiveBlock
    : TARISA COLON NEWLINE INDENT
      programElement+ DEDENT            #reactiveBlockStmt
    ;

// Updated linear object definition to handle both inline and block forms
linearObjectDefinition
    : ID (HAS | PANE) COLON linearObjectBody
    ;
anonymousFunctionAssignment
    : assignable ('=' | NDI) (FUNCTION | BASA) '(' parameterList? ')' COLON suite
    ;

linearObjectBody
    : linearObjectEntries ';'?                                    #inlineObjectBody
    | NEWLINE INDENT objectEntries DEDENT                        #blockObjectBody
    ;

linearObjectEntries
    : linearObjectEntry (',' linearObjectEntry)* 
    ;


linearObjectEntry
    : ID '=' expression
    | ID (HAS | PANE) COLON linearObjectBody    // Add support for nested objects
    | (FUNCTION | BASA) ID '(' parameterList? ')' COLON expression
    ;

objectEntries
    : objectEntry
      ( NEWLINE*                // ←  allow newline first
        (',' | ';' | INDENT | DEDENT)* 
        NEWLINE*
        objectEntry
      )*
      NEWLINE* (',' | ';' | INDENT | DEDENT)* NEWLINE*
    ;


objectEntry
    : ID '=' expression                                          #objValue
    | ID (HAS | PANE) COLON NEWLINE 
      INDENT objectEntries DEDENT                                #nestedObj
    | ID (HAS | PANE) COLON ';'                                 #emptyNestedObj
    | ID (HAS | PANE) COLON linearObjectEntries ';'?            #inlineNestedObj  // ADD THIS
    | (FUNCTION | BASA)? ID '(' parameterList? ')' COLON suite  #objMethod
    ;

propsDeclaration
    : PROPS_KW ID (COMMA ID)*
    ;

compoundStatement
    : functionDefinition
    | eventListenerStatement
    | conditionalStatement
    | loopStatement
    | whileStatement
    ;

incrementStatement : assignable '++' ;
decrementStatement : assignable '--' ;
compoundAssignment : assignable compoundOp expression ;
compoundOp : '+=' | '-=' | '*=' | '/=' | '%=' ;  

setDeclaration 
    : ID '=' '[' arrayElements? ']' VAKASIYANA   #newSet
    | ID '=' ID VAKASIYANA                        #arrayToSet
    | ID '=' primaryExpression VAKASIYANA         #exprToSet
    ;

sortStatement 
    : RONGA ID                                    #defaultSort
    | RONGA ID CHIDZIKA                          #descendingSort
    | RONGA ID EQUALITY_PREPOSITION ID CHIDZIKA  #objectDescSort
    | RONGA ID EQUALITY_PREPOSITION ID CHIKWIRA  #objectAscSort
    | RONGA ID CHIKWIRA                          #ascendingSort
    ;

filterStatement
    : BVISA ID HAS ID comparisonOperator expression   #objectFilter
    | BVISA HAS ID comparisonOperator expression MU ID #nounClassFilter
    | BVISA HAS comparisonOperator expression MU ID   #primitiveFilter     
    | BVISA expression MU ID                           #directValueFilter 
    | BVISA HAS logicalFilterExpression MU ID         #complexFilter  // NEW
    ;
logicalFilterExpression
    : ID comparisonOperator expression ((KANA KUTI | KANA | OR | LOGICAL_OR | UYE | AND | LOGICAL_AND) ID comparisonOperator expression)*
    ;

comparisonOperator : '>' | '<' | '>=' | '<=' | '==' | '!=' ;

/* ─────────────── HTML ELEMENTS ──────────────── */
// htmlElement
//     : LT tagName 
//       ( WS_IN_HTML |                         
//         attribute                            
//       | NEWLINE )*
//       GT
//        htmlContent
//        LT SLASH tagName GT NEWLINE*         #htmlBlockElement
//     | LT tagName 
//       (attribute | WS_IN_HTML | NEWLINE)*
//       SLASH GT NEWLINE*
//        #htmlSelfClosingElement
//     ;

// htmlElement
//     : LT tagName
//       (attribute | WS_IN_HTML | NEWLINE)*        // attr list
//       GT NEWLINE*                                #htmlVoidElement   // ① NEW
//     | LT tagName
//       ( WS_IN_HTML | attribute | NEWLINE )*
//       GT
//       htmlContent
//       LT SLASH tagName GT NEWLINE*               #htmlBlockElement
//     | LT tagName
//       (attribute | WS_IN_HTML | NEWLINE)*
//       SLASH GT NEWLINE*                          #htmlSelfClosingElement
//     ;

// htmlElement
//     : LT tagName
//       (attribute | WS_IN_HTML | NEWLINE)*
//       GT                          #htmlVoidElement    // no NEWLINE* here
//     | LT tagName
//       ( WS_IN_HTML | attribute | NEWLINE )*
//       GT
//       htmlContent
//       LT SLASH tagName GT NEWLINE*  #htmlBlockElement
//     | LT tagName
//       (attribute | WS_IN_HTML | NEWLINE)*
//       SLASH GT NEWLINE*             #htmlSelfClosingElement
//     ;


htmlElement
    // 1️⃣  FULL form  <tag …> … </tag>
    : LT tagName
      ( WS_IN_HTML | attribute | NEWLINE )*
      GT
      htmlContent
      LT SLASH tagName GT NEWLINE*              #htmlBlockElement

    // 2️⃣  Self–closing form <tag … />
    | LT tagName
      (attribute | WS_IN_HTML | NEWLINE)*
      SLASH GT NEWLINE*                         #htmlSelfClosingElement

    // 3️⃣  Void-without-slash  <input …>
    | LT tagName
      (attribute | WS_IN_HTML | NEWLINE)*
      GT NEWLINE*                               #htmlVoidElement
    ;
    
tagName : ID | BASA | KANA | KUTI | ZVIMWE | PANE | MU | NYORA | ISA | BVISA ;

attribute
    : attrName EQ (STRING | shonaExpression) #htmlAttribute
    | eventHandler                           #htmlEventHandler
    ;

attrName : ID | EVENT_CLICK | EVENT_SUBMIT | EVENT_CHANGE | CLASS | ZVANYORWA | IKANYORWA | IKASARUDZWA | ZVASARUDZWA ;

eventHandler : (EVENT_CLICK | EVENT_SUBMIT | EVENT_CHANGE) EQ shonaExpression;

/* ─────────────── HTML CONTENT ──────────────── */
htmlContent
    : htmlContentElement*
    ;

htmlContentElement
    : htmlElement
    | shonaControlFlow      
    | shonaExpression       
    | htmlText              
    | NEWLINE
    | INDENT
    | DEDENT
    ;

shonaControlFlow
    : LBRACE conditionalInHtml RBRACE
    | LBRACE loopInHtml RBRACE
    | LBRACE whileInHtml RBRACE
    ;

conditionalInHtml
    : KANA expression COLON htmlContentUntilKeyword
      ( KANA KUTI expression COLON htmlContentUntilKeyword )*
      ( ZVIMWE COLON htmlContentToEnd )?
    ;

htmlContentUntilKeyword
    : htmlContentPart*
    ;

htmlContentToEnd
    : htmlContentPart*
    ;

htmlContentPart
    : htmlElement
    | LBRACE loopInHtml RBRACE     
    | LBRACE conditionalInHtml RBRACE  
    | shonaExpression               
    | htmlTextNotKeyword            
    | NEWLINE
    | INDENT
    | DEDENT
    ;

htmlTextNotKeyword
    : htmlTextContentNotKeyword+
    ;

htmlTextContentNotKeyword
    : ID 
    | BASA 
    | NYORA 
    | ISA 
    | BVISA
    | NUMBER 
    | AND 
    | OR 
    | UYE 
    | RETURN 
    | DZOSA
    | COLON 
    | COMMA 
    | DOT
    | LPAREN 
    | RPAREN 
    | LBRACKET 
    | RBRACKET
    | EQ 
    | PLUS 
    | MINUS 
    | MUL 
    | SLASH 
    | MOD 
    | GTE 
    | LTE 
    | EQ_EQ 
    | NOT_EQ
    | NOT
    | STRING    
    | WS_IN_HTML 
    | OTHER_TEXT
    | '++'        
    | '--'        
    | '+='        
    | '-='        
    | '*='        
    | '/='        
    | '%='     
    | LBRACE          //  ←  allow “{ … }” in normal HTML text
    | RBRACE
    ;

loopInHtml
    : PANE ID MU primaryExpression COLON htmlContentToEnd
    ;

whileInHtml
    : KANA expression DZOKORORA COLON htmlContentToEnd
    ;

htmlSuite
    : htmlContent                           #htmlBlockSuite
    | NEWLINE INDENT htmlContent DEDENT     #htmlIndentedSuite
    ;

shonaExpression : LBRACE expression RBRACE ;

htmlText
    : htmlTextContent+
    ;

htmlTextContent
    : ID 
    | BASA 
    | KUTI 
    | ZVIMWE 
    | MU 
    | NYORA 
    | ISA 
    | BVISA
    | NUMBER 
    | AND 
    | OR 
    | UYE 
    | RETURN 
    | DZOSA
    | COLON 
    | COMMA 
    | DOT
    | LPAREN 
    | RPAREN 
    | LBRACKET 
    | RBRACKET
    | EQ 
    | PLUS 
    | MINUS 
    | MUL 
    | SLASH 
    | MOD 
    | GTE 
    | LTE 
    | EQ_EQ 
    | NOT_EQ
    | NOT
    | WS_IN_HTML 
    | OTHER_TEXT
    | '++'        
    | '--'        
    | '+='        
    | '-='        
    | '*='        
    | '/='        
    | '%='
    | LBRACE          //  ←  allow “{ … }” in normal HTML text
    | RBRACE
    ;

/* ─────────────── ORIGINAL SHONASCRIPT FEATURES ────── */
inputStatement : BVUNZA ID STRING ;
// importStatement : TORA ID KUBVA MU ID ;
fetchStatement  : TAMBIRA ID KUBVA KU (STRING | ID) ;
importStatement
    : TORA idList KUBVA MU modulePath
    ;

idList      : ID (COMMA ID)* ;
modulePath  : ID | STRING ;

propName : ID | BASA ;
// propertyRef : propName POS ID (POS ID)* ;
propertyRef
    : propName (POS propName)* POS primaryExpression
    ;
propertyDelete : BVISA propertyRef ;

domSelector    : ID ID ;
domPropertyRef : ID POS domSelector ;
eventListenerStatement : KANA domSelector (EVENT_CLICK | EVENT_SUBMIT) COLON suite ;
classStatement : (ISA | BVISA) CLASS STRING PA domSelector ;

loopStatement : PANE ID MU primaryExpression COLON suite ;
whileStatement : KANA expression DZOKORORA COLON suite ;

intervalStatement : primaryExpression DZOKORORA expression SECONDS ;
timeoutStatement  : primaryExpression MIRIRA expression SECONDS ;

continueStatement : JAMBA ;
breakStatement : MIRA ;

assignable
    : assignRoot memberAccess*
    ;

assignRoot
    : ID
    | propertyRef
    | domPropertyRef
    ;

memberAccess
    : '.' ID
    | '[' expression ']'
    ;

assignment : assignable ('=' | NDI) NEWLINE* expression ;

nyoraStatement : NYORA expression (',' expression)* ;
arrayAdd : ISA expression MU expression ;
arrayRemove    : BVISA expression MU ID ;

// conditionalStatement
//     : KANA expression COLON suite
//       ( NEWLINE? KANA KUTI expression COLON suite )*
//       ( NEWLINE? ZVIMWE COLON suite )?
//     ;

conditionalStatement
    : KANA expression COLON suite
      ( NEWLINE? (KANA KUTI | KANA) expression COLON suite )*
      ( NEWLINE? ZVIMWE COLON suite )?
    ;

functionDefinition
    : (FUNCTION | BASA) ID '(' parameterList? ')' COLON suite ;

anonymousFunction
    : (FUNCTION | BASA) '(' parameterList? ')' COLON suite ;

returnStatement : (RETURN | DZOSA) expression ;

/* ─────────────── SUITE ───────────────────────────── */
suite
    : simpleStatement #singleLineSuite
    | NEWLINE INDENT programElement+ DEDENT #blockSuite
    ;

/* ─────────────── EXPRESSIONS (WITH PRECEDENCE) ────────── */
expression
    : conditionalExpression
    ;

conditionalExpression
    : logicalOrExpression ('?' expression COLON expression)?
    ;

logicalOrExpression
    : logicalAndExpression ((KANA KUTI | KANA | OR | LOGICAL_OR) logicalAndExpression)*
    ;

// logicalOrExpression
//     : logicalAndExpression ((KANA | OR)  logicalAndExpression)*
//     ;

// logicalAndExpression
//     : equalityExpression  ((UYE  | AND) equalityExpression)*
//     ;

logicalAndExpression
    : equalityExpression ((UYE | AND | LOGICAL_AND) equalityExpression)*
    ;

equalityExpression
    : comparisonExpression (('==' | '!=') comparisonExpression)*
    ;

comparisonExpression
    : additiveExpression (('>' | '<' | '>=' | '<=') additiveExpression)*
    ;

additiveExpression
    : multiplicativeExpression (('+' | '-') multiplicativeExpression)*
    ;

multiplicativeExpression
    : powerExpression (('*' | '/' | '%') powerExpression)*   // ← was unaryExpression
    ;
powerExpression
    : unaryExpression ('**' powerExpression)?
    ;

unaryExpression
    : ('+' | '-'|NOT) unaryExpression #unaryOp
    | primaryExpression #primaryExpr
    ;

primaryExpression
    : domPropertyRef #domPropertyGet
    | propertyRef #propertyGet
    | ID POS ID (POS ID)+ #propertyAccess
    | BASA POS ID (POS ID)* ID '(' argumentList? ')' #methodCall 
    | ID '(' argumentList? ')' #functionCall
    | (FUNCTION | BASA) '(' parameterList? ')' COLON suite #anonymousFunctionExpr
    | '[' NEWLINE* arrayElements? NEWLINE* ']' #arrayLiteral
    | '[' rangeExpression ']' #arrayRange 
    | VERENGA primaryExpression #lengthExpr
    | BATANIDZA primaryExpression #joinExpr
    | PA expression MU (ID | STRING) #indexOp
    | '[' arrayElements? ']' VAKASIYANA #setExpr
    | ID VAKASIYANA #varToSetExpr
    | primaryExpression VAKASIYANA #exprToSetExpr
    | BVUNZA STRING                       #inputExpr
    | primaryExpression DZOKORORA expression SECONDS #intervalExpr
    | primaryExpression MIRIRA expression SECONDS #timeoutExpr
    | TAMBIRA ID KUBVA KU (STRING | ID)      #fetchExpr
    | NUMBER #number
    | BOOLEAN #boolean
    | STRING #string
    | ID #variable
    | ZVANYORWA #zvanyorwaVar 
    | '(' expression ')' #parens
    | primaryExpression NCLASS MU expression #inArrayOp
    | primaryExpression NCLASS MU STRING #inStringOp
    | primaryExpression EQUALITY_VERB EQUALITY_PREPOSITION expression #naturalEqualityOp
    | primaryExpression NCLASS primaryExpression #nounClassEquality
    | primaryExpression SIRI_SUFFIX primaryExpression #nounClassInequality
    | primaryExpression RIPO_SUFFIX #nounClassExistence
    | primaryExpression SIPO_SUFFIX #nounClassNonExistence
    | objectLiteral #objLiteral
    | jsObjectLiteral #jsObjLiteral
    | primaryExpression '.' ID #dotAccess
    | primaryExpression '[' expression ']' #bracketAccess
    | htmlElement                                   #htmlExpr
    ;

// Inline object literal (for use in arrays, expressions, etc.)
objectLiteral
    : (HAS | PANE) COLON linearObjectEntries ';'?
    ;

// JavaScript-style object literal
jsObjectLiteral
    : '{' NEWLINE* jsObjectEntries? NEWLINE* '}'
    ;

jsObjectEntries
    : jsObjectEntry ((',' NEWLINE* | NEWLINE+) jsObjectEntry)* ','? NEWLINE*
    ;

jsObjectEntry
    : (ID | STRING) COLON expression
    ;

rangeExpression
    : expression ',' expression ',' ELLIPSIS expression   #fullRange
    | expression ',' ELLIPSIS expression                  #simpleRange
    ;

arrayElements 
    : NEWLINE* arrayElement ((',' NEWLINE* | NEWLINE+) arrayElement)* ','? NEWLINE*
    ;

arrayElement
    : objectLiteral
    | expression
    ;

argumentList  : expression (',' expression)* ;
parameterList : ID (',' ID)* ;

/* ─────────────── LEXER RULES ───────────────────────── */
// Keywords - ORDER MATTERS!

LOGICAL_AND : '&&' ;
LOGICAL_OR  : '||' ;
PANE      : 'pane' ;
KANA     : 'kana' ;
TARISA : 'tarisa' ;
ZVANYORWA : 'zvanyorwa' ;
IKANYORWA : 'ikanyorwa' ;
IKASARUDZWA : 'ikasarudzwa' ;
ZVASARUDZWA : 'zvasarudzwa' ;
RONGA : 'ronga' ;
VAKASIYANA : 'vakasiyana' | 'akasiyana' | 'dzakasiyana' | 'rakasiyana' 
           | 'chakasiyana' | 'zvakasiyana' | 'kwakasiyana' | 'svakasiyana' ;
CHIDZIKA : 'vachidzika' | 'richidzika' | 'chichidzika' | 'zvichidzika' 
         | 'ichidzika' | 'dzichidzika' | 'achidzika' | 'kachidzika'
         | 'tuchidzika' | 'uchidzika' | 'pachidzika' | 'svichidzika' 
         | 'zichidzika' | 'ruchidzika' ;
CHIKWIRA : 'vachikwira' | 'richikwira' | 'chichikwira' | 'zvichikwira'
         | 'ichikwira' | 'dzichikwira' | 'achikwira' | 'kachikwira'
         | 'tuchikwira' | 'uchikwira' | 'pachikwira' | 'svichikwira' 
         | 'zichikwira' | 'ruchikwira' ;
TAMBIRA   : 'tambira' ;
HAS : 'ane' | 'vane' | 'mune' | 'mine' | 'une' | 'rine' | 'ine' | 'dzine' |
      'rune' | 'kune' | 'svine' | 'kane' | 'tune' | 'chine' | 'zvine' ;
BOOLEAN  : 'chokwadi' | 'kwete' ;
UYE      : 'uye' ;
AND : 'and' ;
OR  : 'or'  ;
ZVIMWE   : 'zvimwe' ;
FUNCTION : 'function' ;
BASA     : 'basa' ;
KUTI     : 'kuti' ;
NYORA    : 'nyora' ;
RETURN   : 'return' ;
DZOSA    : 'dzosa' ;
ISA      : 'isa' ;
BVISA    : 'bvisa' ;
MU       : 'mu' ;
CLASS    : 'class';
NCLASS : 'ari' | 'vari' | 'uri' | 'iri' | 'riri' | 'chiri' | 'zviri' | 'dziri' | 'ruri'
       | 'kari' | 'turi' | 'kuri' | 'pari' | 'muri' | 'sviri' ;
SIRI_SUFFIX : 'asiri' | 'vasiri' | 'usiri' | 'isiri' | 'risiri' | 'chisiri' | 'zvisiri' 
            | 'dzisiri' | 'rusiri' | 'kasiri' | 'tusiri' | 'kusiri' | 'pasiri' | 'musiri' | 'svisiri' ;
RIPO_SUFFIX : 'aripo' | 'varipo' | 'uripo' | 'iripo' | 'riripo' | 'chiripo' | 'zviripo' 
            | 'dziripo' | 'ruripo' | 'karipo' | 'turipo' | 'kuripo' | 'paripo' | 'muripo' | 'sviripo' ;
SIPO_SUFFIX : 'asipo' | 'vasipo' | 'usipo' | 'isipo' | 'risipo' | 'chisipo' | 'zvisipo' 
            | 'dzisipo' | 'rusipo' | 'kasipo' | 'tusipo' | 'kusipo' | 'pasipo' | 'musipo' | 'svisipo' ;
PA        : 'pa' ;
VERENGA   : 'verenga' ;
BATANIDZA : 'batanidza' ;
POS : 'ya' | 'e' | 'ye' | 're' | 've' | 'zve' | 'che' | 'ke' | 'kwe' | 'sve'
    | 'dze' | 'rwe' | 'twe' | 'we' | 'wa' | 'dza' | 'ra' | 'cha' | 'zva' | 'ka' | 'sva' | 'rwa' ;
PROPS_KW
    : 'ipe'   | 'mupe' | 'vape' | 'ripe'
    | 'chipe' | 'zvipe'| 'kape' | 'tupe'
    | 'zipe'    ;
BVUNZA    : 'bvunza' ;
TORA      : 'tora' ;
KUBVA     : 'kubva' ;
KU        : 'ku' ;
JAMBA     : 'jamba' ;
MIRA      : 'mira' ;
DZOKORORA : 'dzokorora';
MIRIRA    : 'mirira';
SECONDS   : 'seconds';
EVENT_CLICK : 'rikabayiwa' | 'rakabayiwa' | 'rikapresswa' | 'rakapresswa' ;
EVENT_SUBMIT: 'rikasubmitwa' ;
EVENT_CHANGE: 'ikachinjwa';
NDI : 'ndi' ;
// I   : 'i' ;
EQUALITY_VERB : ('a'|'ya'|'va'|'wa'|'ra'|'zva'|'cha'|'kwa'|'sva'|'dza'|'rwa'|'twa')
              ('kaenzana' | 'kafanana') ;
EQUALITY_PREPOSITION : 'na' | 'ne' ;
ELLIPSIS  : '...' ;

// Special tokens
INDENT  : 'INDENT' ;
DEDENT  : 'DEDENT' ;

// Identifiers and literals
ID     : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMBER : [0-9]+ ('.' [0-9]+)? ;
STRING : '"' (ESC | ~["\\\r\n])* '"' ;
fragment ESC : '\\' ["\\/bfnrt] | '\\\\' | '\\u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

// HTML & Operators
HTML_COMMENT : '<!--' .*? '-->' -> skip ;
LT : '<' ; 
GT : '>' ; 
SLASH : '/' ; 
LBRACE : '{' ; 
RBRACE : '}' ; 
LPAREN : '(' ;
RPAREN : ')' ;
LBRACKET : '[' ;
RBRACKET : ']' ;
EQ : '=' ;
PLUS : '+' ; 
MINUS : '-' ; 
MUL : '*' ; 
MOD : '%' ;
POWER : '**' ;
GTE : '>=' ; 
LTE : '<=' ; 
EQ_EQ : '==' ; 
NOT_EQ : '!=' ;
NOT : '!' ;  
COMMA : ',' ;
DOT : '.' ;
COLON : ':' ;

// Whitespace and newlines
NEWLINE : '\r'? '\n' ;
WS : [ \t]+ -> skip ;
WS_IN_HTML : [ \t]+ ;

// Comments
COMMENT : '//' ~[\r\n]* -> skip ;

// Catch-all
OTHER_TEXT : [#] | . ;