// Generated from /Users/panashe/workplace/2025/shonascript-studio/Shonascriptx.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ShonascriptxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		LOGICAL_AND=10, LOGICAL_OR=11, PANE=12, KANA=13, TARISA=14, ZVANYORWA=15, 
		IKANYORWA=16, IKASARUDZWA=17, ZVASARUDZWA=18, RONGA=19, VAKASIYANA=20, 
		CHIDZIKA=21, CHIKWIRA=22, TAMBIRA=23, HAS=24, BOOLEAN=25, UYE=26, AND=27, 
		OR=28, ZVIMWE=29, FUNCTION=30, BASA=31, KUTI=32, NYORA=33, RETURN=34, 
		DZOSA=35, ISA=36, BVISA=37, MU=38, CLASS=39, NCLASS=40, SIRI_SUFFIX=41, 
		RIPO_SUFFIX=42, SIPO_SUFFIX=43, PA=44, VERENGA=45, BATANIDZA=46, POS=47, 
		PROPS_KW=48, BVUNZA=49, TORA=50, KUBVA=51, KU=52, JAMBA=53, MIRA=54, DZOKORORA=55, 
		MIRIRA=56, SECONDS=57, EVENT_CLICK=58, EVENT_SUBMIT=59, EVENT_CHANGE=60, 
		NDI=61, EQUALITY_VERB=62, EQUALITY_PREPOSITION=63, ELLIPSIS=64, INDENT=65, 
		DEDENT=66, ID=67, NUMBER=68, STRING=69, HTML_COMMENT=70, LT=71, GT=72, 
		SLASH=73, LBRACE=74, RBRACE=75, LPAREN=76, RPAREN=77, LBRACKET=78, RBRACKET=79, 
		EQ=80, PLUS=81, MINUS=82, MUL=83, MOD=84, POWER=85, GTE=86, LTE=87, EQ_EQ=88, 
		NOT_EQ=89, NOT=90, COMMA=91, DOT=92, COLON=93, NEWLINE=94, WS=95, WS_IN_HTML=96, 
		COMMENT=97, OTHER_TEXT=98;
	public static final int
		RULE_program = 0, RULE_programElement = 1, RULE_line = 2, RULE_statement = 3, 
		RULE_simpleStatement = 4, RULE_reactiveOneLiner = 5, RULE_reactiveBlock = 6, 
		RULE_linearObjectDefinition = 7, RULE_anonymousFunctionAssignment = 8, 
		RULE_linearObjectBody = 9, RULE_linearObjectEntries = 10, RULE_linearObjectEntry = 11, 
		RULE_objectEntries = 12, RULE_objectEntry = 13, RULE_propsDeclaration = 14, 
		RULE_compoundStatement = 15, RULE_incrementStatement = 16, RULE_decrementStatement = 17, 
		RULE_compoundAssignment = 18, RULE_compoundOp = 19, RULE_setDeclaration = 20, 
		RULE_sortStatement = 21, RULE_filterStatement = 22, RULE_logicalFilterExpression = 23, 
		RULE_comparisonOperator = 24, RULE_htmlElement = 25, RULE_tagName = 26, 
		RULE_attribute = 27, RULE_attrName = 28, RULE_eventHandler = 29, RULE_htmlContent = 30, 
		RULE_htmlContentElement = 31, RULE_shonaControlFlow = 32, RULE_conditionalInHtml = 33, 
		RULE_htmlContentUntilKeyword = 34, RULE_htmlContentToEnd = 35, RULE_htmlContentPart = 36, 
		RULE_htmlTextNotKeyword = 37, RULE_htmlTextContentNotKeyword = 38, RULE_loopInHtml = 39, 
		RULE_whileInHtml = 40, RULE_htmlSuite = 41, RULE_shonaExpression = 42, 
		RULE_htmlText = 43, RULE_htmlTextContent = 44, RULE_inputStatement = 45, 
		RULE_fetchStatement = 46, RULE_importStatement = 47, RULE_idList = 48, 
		RULE_modulePath = 49, RULE_propName = 50, RULE_propertyRef = 51, RULE_propertyDelete = 52, 
		RULE_domSelector = 53, RULE_domPropertyRef = 54, RULE_eventListenerStatement = 55, 
		RULE_classStatement = 56, RULE_loopStatement = 57, RULE_whileStatement = 58, 
		RULE_intervalStatement = 59, RULE_timeoutStatement = 60, RULE_continueStatement = 61, 
		RULE_breakStatement = 62, RULE_assignable = 63, RULE_assignRoot = 64, 
		RULE_memberAccess = 65, RULE_assignment = 66, RULE_nyoraStatement = 67, 
		RULE_arrayAdd = 68, RULE_arrayRemove = 69, RULE_conditionalStatement = 70, 
		RULE_functionDefinition = 71, RULE_anonymousFunction = 72, RULE_returnStatement = 73, 
		RULE_suite = 74, RULE_expression = 75, RULE_conditionalExpression = 76, 
		RULE_logicalOrExpression = 77, RULE_logicalAndExpression = 78, RULE_equalityExpression = 79, 
		RULE_comparisonExpression = 80, RULE_additiveExpression = 81, RULE_multiplicativeExpression = 82, 
		RULE_powerExpression = 83, RULE_unaryExpression = 84, RULE_primaryExpression = 85, 
		RULE_objectLiteral = 86, RULE_jsObjectLiteral = 87, RULE_jsObjectEntries = 88, 
		RULE_jsObjectEntry = 89, RULE_rangeExpression = 90, RULE_arrayElements = 91, 
		RULE_arrayElement = 92, RULE_argumentList = 93, RULE_parameterList = 94;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programElement", "line", "statement", "simpleStatement", 
			"reactiveOneLiner", "reactiveBlock", "linearObjectDefinition", "anonymousFunctionAssignment", 
			"linearObjectBody", "linearObjectEntries", "linearObjectEntry", "objectEntries", 
			"objectEntry", "propsDeclaration", "compoundStatement", "incrementStatement", 
			"decrementStatement", "compoundAssignment", "compoundOp", "setDeclaration", 
			"sortStatement", "filterStatement", "logicalFilterExpression", "comparisonOperator", 
			"htmlElement", "tagName", "attribute", "attrName", "eventHandler", "htmlContent", 
			"htmlContentElement", "shonaControlFlow", "conditionalInHtml", "htmlContentUntilKeyword", 
			"htmlContentToEnd", "htmlContentPart", "htmlTextNotKeyword", "htmlTextContentNotKeyword", 
			"loopInHtml", "whileInHtml", "htmlSuite", "shonaExpression", "htmlText", 
			"htmlTextContent", "inputStatement", "fetchStatement", "importStatement", 
			"idList", "modulePath", "propName", "propertyRef", "propertyDelete", 
			"domSelector", "domPropertyRef", "eventListenerStatement", "classStatement", 
			"loopStatement", "whileStatement", "intervalStatement", "timeoutStatement", 
			"continueStatement", "breakStatement", "assignable", "assignRoot", "memberAccess", 
			"assignment", "nyoraStatement", "arrayAdd", "arrayRemove", "conditionalStatement", 
			"functionDefinition", "anonymousFunction", "returnStatement", "suite", 
			"expression", "conditionalExpression", "logicalOrExpression", "logicalAndExpression", 
			"equalityExpression", "comparisonExpression", "additiveExpression", "multiplicativeExpression", 
			"powerExpression", "unaryExpression", "primaryExpression", "objectLiteral", 
			"jsObjectLiteral", "jsObjectEntries", "jsObjectEntry", "rangeExpression", 
			"arrayElements", "arrayElement", "argumentList", "parameterList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'++'", "'--'", "'+='", "'-='", "'*='", "'/='", "'%='", 
			"'?'", "'&&'", "'||'", "'pane'", "'kana'", "'tarisa'", "'zvanyorwa'", 
			"'ikanyorwa'", "'ikasarudzwa'", "'zvasarudzwa'", "'ronga'", null, null, 
			null, "'tambira'", null, null, "'uye'", "'and'", "'or'", "'zvimwe'", 
			"'function'", "'basa'", "'kuti'", "'nyora'", "'return'", "'dzosa'", "'isa'", 
			"'bvisa'", "'mu'", "'class'", null, null, null, null, "'pa'", "'verenga'", 
			"'batanidza'", null, null, "'bvunza'", "'tora'", "'kubva'", "'ku'", "'jamba'", 
			"'mira'", "'dzokorora'", "'mirira'", "'seconds'", null, "'rikasubmitwa'", 
			"'ikachinjwa'", "'ndi'", null, null, "'...'", "'INDENT'", "'DEDENT'", 
			null, null, null, null, "'<'", "'>'", "'/'", "'{'", "'}'", "'('", "')'", 
			"'['", "']'", "'='", "'+'", "'-'", "'*'", "'%'", "'**'", "'>='", "'<='", 
			"'=='", "'!='", "'!'", "','", "'.'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "LOGICAL_AND", 
			"LOGICAL_OR", "PANE", "KANA", "TARISA", "ZVANYORWA", "IKANYORWA", "IKASARUDZWA", 
			"ZVASARUDZWA", "RONGA", "VAKASIYANA", "CHIDZIKA", "CHIKWIRA", "TAMBIRA", 
			"HAS", "BOOLEAN", "UYE", "AND", "OR", "ZVIMWE", "FUNCTION", "BASA", "KUTI", 
			"NYORA", "RETURN", "DZOSA", "ISA", "BVISA", "MU", "CLASS", "NCLASS", 
			"SIRI_SUFFIX", "RIPO_SUFFIX", "SIPO_SUFFIX", "PA", "VERENGA", "BATANIDZA", 
			"POS", "PROPS_KW", "BVUNZA", "TORA", "KUBVA", "KU", "JAMBA", "MIRA", 
			"DZOKORORA", "MIRIRA", "SECONDS", "EVENT_CLICK", "EVENT_SUBMIT", "EVENT_CHANGE", 
			"NDI", "EQUALITY_VERB", "EQUALITY_PREPOSITION", "ELLIPSIS", "INDENT", 
			"DEDENT", "ID", "NUMBER", "STRING", "HTML_COMMENT", "LT", "GT", "SLASH", 
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "EQ", 
			"PLUS", "MINUS", "MUL", "MOD", "POWER", "GTE", "LTE", "EQ_EQ", "NOT_EQ", 
			"NOT", "COMMA", "DOT", "COLON", "NEWLINE", "WS", "WS_IN_HTML", "COMMENT", 
			"OTHER_TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Shonascriptx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShonascriptxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ShonascriptxParser.EOF, 0); }
		public List<ProgramElementContext> programElement() {
			return getRuleContexts(ProgramElementContext.class);
		}
		public ProgramElementContext programElement(int i) {
			return getRuleContext(ProgramElementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29115337472012288L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0)) {
				{
				{
				setState(190);
				programElement();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramElementContext extends ParserRuleContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public ReactiveBlockContext reactiveBlock() {
			return getRuleContext(ReactiveBlockContext.class,0);
		}
		public ProgramElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterProgramElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitProgramElement(this);
		}
	}

	public final ProgramElementContext programElement() throws RecognitionException {
		ProgramElementContext _localctx = new ProgramElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programElement);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				line();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				reactiveBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);
		try {
			setState(207);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PANE:
			case KANA:
			case TARISA:
			case ZVANYORWA:
			case RONGA:
			case TAMBIRA:
			case HAS:
			case BOOLEAN:
			case FUNCTION:
			case BASA:
			case NYORA:
			case RETURN:
			case DZOSA:
			case ISA:
			case BVISA:
			case PA:
			case VERENGA:
			case BATANIDZA:
			case PROPS_KW:
			case BVUNZA:
			case TORA:
			case JAMBA:
			case MIRA:
			case ID:
			case NUMBER:
			case STRING:
			case LT:
			case LBRACE:
			case LPAREN:
			case LBRACKET:
			case PLUS:
			case MINUS:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				statement();
				setState(204);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				simpleStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				compoundStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatementContext extends ParserRuleContext {
		public AnonymousFunctionAssignmentContext anonymousFunctionAssignment() {
			return getRuleContext(AnonymousFunctionAssignmentContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IncrementStatementContext incrementStatement() {
			return getRuleContext(IncrementStatementContext.class,0);
		}
		public DecrementStatementContext decrementStatement() {
			return getRuleContext(DecrementStatementContext.class,0);
		}
		public CompoundAssignmentContext compoundAssignment() {
			return getRuleContext(CompoundAssignmentContext.class,0);
		}
		public NyoraStatementContext nyoraStatement() {
			return getRuleContext(NyoraStatementContext.class,0);
		}
		public PropertyDeleteContext propertyDelete() {
			return getRuleContext(PropertyDeleteContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ArrayAddContext arrayAdd() {
			return getRuleContext(ArrayAddContext.class,0);
		}
		public ArrayRemoveContext arrayRemove() {
			return getRuleContext(ArrayRemoveContext.class,0);
		}
		public SetDeclarationContext setDeclaration() {
			return getRuleContext(SetDeclarationContext.class,0);
		}
		public SortStatementContext sortStatement() {
			return getRuleContext(SortStatementContext.class,0);
		}
		public FilterStatementContext filterStatement() {
			return getRuleContext(FilterStatementContext.class,0);
		}
		public ClassStatementContext classStatement() {
			return getRuleContext(ClassStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public ImportStatementContext importStatement() {
			return getRuleContext(ImportStatementContext.class,0);
		}
		public IntervalStatementContext intervalStatement() {
			return getRuleContext(IntervalStatementContext.class,0);
		}
		public TimeoutStatementContext timeoutStatement() {
			return getRuleContext(TimeoutStatementContext.class,0);
		}
		public FetchStatementContext fetchStatement() {
			return getRuleContext(FetchStatementContext.class,0);
		}
		public LinearObjectDefinitionContext linearObjectDefinition() {
			return getRuleContext(LinearObjectDefinitionContext.class,0);
		}
		public PropsDeclarationContext propsDeclaration() {
			return getRuleContext(PropsDeclarationContext.class,0);
		}
		public ReactiveOneLinerContext reactiveOneLiner() {
			return getRuleContext(ReactiveOneLinerContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitSimpleStatement(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleStatement);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				anonymousFunctionAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				incrementStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				decrementStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(217);
				compoundAssignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(218);
				nyoraStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				propertyDelete();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(220);
				returnStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(221);
				arrayAdd();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(222);
				arrayRemove();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(223);
				setDeclaration();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(224);
				sortStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(225);
				filterStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(226);
				classStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(227);
				continueStatement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(228);
				breakStatement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(229);
				expression();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(230);
				inputStatement();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(231);
				importStatement();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(232);
				intervalStatement();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(233);
				timeoutStatement();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(234);
				fetchStatement();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(235);
				linearObjectDefinition();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(236);
				propsDeclaration();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(237);
				reactiveOneLiner();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReactiveOneLinerContext extends ParserRuleContext {
		public TerminalNode TARISA() { return getToken(ShonascriptxParser.TARISA, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ReactiveOneLinerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reactiveOneLiner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterReactiveOneLiner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitReactiveOneLiner(this);
		}
	}

	public final ReactiveOneLinerContext reactiveOneLiner() throws RecognitionException {
		ReactiveOneLinerContext _localctx = new ReactiveOneLinerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_reactiveOneLiner);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(TARISA);
			setState(241);
			match(COLON);
			setState(242);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReactiveBlockContext extends ParserRuleContext {
		public ReactiveBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reactiveBlock; }
	 
		public ReactiveBlockContext() { }
		public void copyFrom(ReactiveBlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReactiveBlockStmtContext extends ReactiveBlockContext {
		public TerminalNode TARISA() { return getToken(ShonascriptxParser.TARISA, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public List<ProgramElementContext> programElement() {
			return getRuleContexts(ProgramElementContext.class);
		}
		public ProgramElementContext programElement(int i) {
			return getRuleContext(ProgramElementContext.class,i);
		}
		public ReactiveBlockStmtContext(ReactiveBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterReactiveBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitReactiveBlockStmt(this);
		}
	}

	public final ReactiveBlockContext reactiveBlock() throws RecognitionException {
		ReactiveBlockContext _localctx = new ReactiveBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_reactiveBlock);
		int _la;
		try {
			_localctx = new ReactiveBlockStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(TARISA);
			setState(245);
			match(COLON);
			setState(246);
			match(NEWLINE);
			setState(247);
			match(INDENT);
			setState(249); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(248);
				programElement();
				}
				}
				setState(251); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 29115337472012288L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0) );
			setState(253);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinearObjectDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public LinearObjectBodyContext linearObjectBody() {
			return getRuleContext(LinearObjectBodyContext.class,0);
		}
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public LinearObjectDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearObjectDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLinearObjectDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLinearObjectDefinition(this);
		}
	}

	public final LinearObjectDefinitionContext linearObjectDefinition() throws RecognitionException {
		LinearObjectDefinitionContext _localctx = new LinearObjectDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_linearObjectDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ID);
			setState(256);
			_la = _input.LA(1);
			if ( !(_la==PANE || _la==HAS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(257);
			match(COLON);
			setState(258);
			linearObjectBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousFunctionAssignmentContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode NDI() { return getToken(ShonascriptxParser.NDI, 0); }
		public TerminalNode FUNCTION() { return getToken(ShonascriptxParser.FUNCTION, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public AnonymousFunctionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunctionAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAnonymousFunctionAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAnonymousFunctionAssignment(this);
		}
	}

	public final AnonymousFunctionAssignmentContext anonymousFunctionAssignment() throws RecognitionException {
		AnonymousFunctionAssignmentContext _localctx = new AnonymousFunctionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_anonymousFunctionAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			assignable();
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==NDI || _la==EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION || _la==BASA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(263);
			match(LPAREN);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(264);
				parameterList();
				}
			}

			setState(267);
			match(RPAREN);
			setState(268);
			match(COLON);
			setState(269);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinearObjectBodyContext extends ParserRuleContext {
		public LinearObjectBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearObjectBody; }
	 
		public LinearObjectBodyContext() { }
		public void copyFrom(LinearObjectBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineObjectBodyContext extends LinearObjectBodyContext {
		public LinearObjectEntriesContext linearObjectEntries() {
			return getRuleContext(LinearObjectEntriesContext.class,0);
		}
		public InlineObjectBodyContext(LinearObjectBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterInlineObjectBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitInlineObjectBody(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockObjectBodyContext extends LinearObjectBodyContext {
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public ObjectEntriesContext objectEntries() {
			return getRuleContext(ObjectEntriesContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public BlockObjectBodyContext(LinearObjectBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterBlockObjectBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitBlockObjectBody(this);
		}
	}

	public final LinearObjectBodyContext linearObjectBody() throws RecognitionException {
		LinearObjectBodyContext _localctx = new LinearObjectBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_linearObjectBody);
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
			case BASA:
			case ID:
				_localctx = new InlineObjectBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				linearObjectEntries();
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(272);
					match(T__0);
					}
					break;
				}
				}
				break;
			case NEWLINE:
				_localctx = new BlockObjectBodyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				match(NEWLINE);
				setState(276);
				match(INDENT);
				setState(277);
				objectEntries();
				setState(278);
				match(DEDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinearObjectEntriesContext extends ParserRuleContext {
		public List<LinearObjectEntryContext> linearObjectEntry() {
			return getRuleContexts(LinearObjectEntryContext.class);
		}
		public LinearObjectEntryContext linearObjectEntry(int i) {
			return getRuleContext(LinearObjectEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public LinearObjectEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearObjectEntries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLinearObjectEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLinearObjectEntries(this);
		}
	}

	public final LinearObjectEntriesContext linearObjectEntries() throws RecognitionException {
		LinearObjectEntriesContext _localctx = new LinearObjectEntriesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_linearObjectEntries);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			linearObjectEntry();
			setState(287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(283);
					match(COMMA);
					setState(284);
					linearObjectEntry();
					}
					} 
				}
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinearObjectEntryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public LinearObjectBodyContext linearObjectBody() {
			return getRuleContext(LinearObjectBodyContext.class,0);
		}
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode FUNCTION() { return getToken(ShonascriptxParser.FUNCTION, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public LinearObjectEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearObjectEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLinearObjectEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLinearObjectEntry(this);
		}
	}

	public final LinearObjectEntryContext linearObjectEntry() throws RecognitionException {
		LinearObjectEntryContext _localctx = new LinearObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_linearObjectEntry);
		int _la;
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				match(ID);
				setState(291);
				match(EQ);
				setState(292);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(ID);
				setState(294);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(295);
				match(COLON);
				setState(296);
				linearObjectBody();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				_la = _input.LA(1);
				if ( !(_la==FUNCTION || _la==BASA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(298);
				match(ID);
				setState(299);
				match(LPAREN);
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(300);
					parameterList();
					}
				}

				setState(303);
				match(RPAREN);
				setState(304);
				match(COLON);
				setState(305);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectEntriesContext extends ParserRuleContext {
		public List<ObjectEntryContext> objectEntry() {
			return getRuleContexts(ObjectEntryContext.class);
		}
		public ObjectEntryContext objectEntry(int i) {
			return getRuleContext(ObjectEntryContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public List<TerminalNode> INDENT() { return getTokens(ShonascriptxParser.INDENT); }
		public TerminalNode INDENT(int i) {
			return getToken(ShonascriptxParser.INDENT, i);
		}
		public List<TerminalNode> DEDENT() { return getTokens(ShonascriptxParser.DEDENT); }
		public TerminalNode DEDENT(int i) {
			return getToken(ShonascriptxParser.DEDENT, i);
		}
		public ObjectEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectEntries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjectEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjectEntries(this);
		}
	}

	public final ObjectEntriesContext objectEntries() throws RecognitionException {
		ObjectEntriesContext _localctx = new ObjectEntriesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_objectEntries);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			objectEntry();
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(312);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(309);
							match(NEWLINE);
							}
							} 
						}
						setState(314);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0 || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 67108867L) != 0)) {
						{
						{
						setState(315);
						_la = _input.LA(1);
						if ( !(_la==T__0 || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 67108867L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						}
						setState(320);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(324);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(321);
						match(NEWLINE);
						}
						}
						setState(326);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(327);
					objectEntry();
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(333);
					match(NEWLINE);
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(339);
					_la = _input.LA(1);
					if ( !(_la==T__0 || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 67108867L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(345);
				match(NEWLINE);
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectEntryContext extends ParserRuleContext {
		public ObjectEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectEntry; }
	 
		public ObjectEntryContext() { }
		public void copyFrom(ObjectEntryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyNestedObjContext extends ObjectEntryContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public EmptyNestedObjContext(ObjectEntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterEmptyNestedObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitEmptyNestedObj(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjMethodContext extends ObjectEntryContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(ShonascriptxParser.FUNCTION, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public ObjMethodContext(ObjectEntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjMethod(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjValueContext extends ObjectEntryContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjValueContext(ObjectEntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjValue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedObjContext extends ObjectEntryContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public ObjectEntriesContext objectEntries() {
			return getRuleContext(ObjectEntriesContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public NestedObjContext(ObjectEntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNestedObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNestedObj(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InlineNestedObjContext extends ObjectEntryContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public LinearObjectEntriesContext linearObjectEntries() {
			return getRuleContext(LinearObjectEntriesContext.class,0);
		}
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public InlineNestedObjContext(ObjectEntryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterInlineNestedObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitInlineNestedObj(this);
		}
	}

	public final ObjectEntryContext objectEntry() throws RecognitionException {
		ObjectEntryContext _localctx = new ObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_objectEntry);
		int _la;
		try {
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ObjValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(ID);
				setState(352);
				match(EQ);
				setState(353);
				expression();
				}
				break;
			case 2:
				_localctx = new NestedObjContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				match(ID);
				setState(355);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(356);
				match(COLON);
				setState(357);
				match(NEWLINE);
				setState(358);
				match(INDENT);
				setState(359);
				objectEntries();
				setState(360);
				match(DEDENT);
				}
				break;
			case 3:
				_localctx = new EmptyNestedObjContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				match(ID);
				setState(363);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(364);
				match(COLON);
				setState(365);
				match(T__0);
				}
				break;
			case 4:
				_localctx = new InlineNestedObjContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
				match(ID);
				setState(367);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(368);
				match(COLON);
				setState(369);
				linearObjectEntries();
				setState(371);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(370);
					match(T__0);
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new ObjMethodContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FUNCTION || _la==BASA) {
					{
					setState(373);
					_la = _input.LA(1);
					if ( !(_la==FUNCTION || _la==BASA) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(376);
				match(ID);
				setState(377);
				match(LPAREN);
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(378);
					parameterList();
					}
				}

				setState(381);
				match(RPAREN);
				setState(382);
				match(COLON);
				setState(383);
				suite();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropsDeclarationContext extends ParserRuleContext {
		public TerminalNode PROPS_KW() { return getToken(ShonascriptxParser.PROPS_KW, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public PropsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propsDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPropsDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPropsDeclaration(this);
		}
	}

	public final PropsDeclarationContext propsDeclaration() throws RecognitionException {
		PropsDeclarationContext _localctx = new PropsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propsDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(PROPS_KW);
			setState(387);
			match(ID);
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(388);
					match(COMMA);
					setState(389);
					match(ID);
					}
					} 
				}
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundStatementContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public EventListenerStatementContext eventListenerStatement() {
			return getRuleContext(EventListenerStatementContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitCompoundStatement(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compoundStatement);
		try {
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(395);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(396);
				eventListenerStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
				conditionalStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(398);
				loopStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(399);
				whileStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncrementStatementContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public IncrementStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterIncrementStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitIncrementStatement(this);
		}
	}

	public final IncrementStatementContext incrementStatement() throws RecognitionException {
		IncrementStatementContext _localctx = new IncrementStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_incrementStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			assignable();
			setState(403);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecrementStatementContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public DecrementStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decrementStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDecrementStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDecrementStatement(this);
		}
	}

	public final DecrementStatementContext decrementStatement() throws RecognitionException {
		DecrementStatementContext _localctx = new DecrementStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_decrementStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			assignable();
			setState(406);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundAssignmentContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public CompoundOpContext compoundOp() {
			return getRuleContext(CompoundOpContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterCompoundAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitCompoundAssignment(this);
		}
	}

	public final CompoundAssignmentContext compoundAssignment() throws RecognitionException {
		CompoundAssignmentContext _localctx = new CompoundAssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_compoundAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			assignable();
			setState(409);
			compoundOp();
			setState(410);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompoundOpContext extends ParserRuleContext {
		public CompoundOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterCompoundOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitCompoundOp(this);
		}
	}

	public final CompoundOpContext compoundOp() throws RecognitionException {
		CompoundOpContext _localctx = new CompoundOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_compoundOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 496L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetDeclarationContext extends ParserRuleContext {
		public SetDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setDeclaration; }
	 
		public SetDeclarationContext() { }
		public void copyFrom(SetDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprToSetContext extends SetDeclarationContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public ExprToSetContext(SetDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterExprToSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitExprToSet(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayToSetContext extends SetDeclarationContext {
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public ArrayToSetContext(SetDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayToSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayToSet(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewSetContext extends SetDeclarationContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public ArrayElementsContext arrayElements() {
			return getRuleContext(ArrayElementsContext.class,0);
		}
		public NewSetContext(SetDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNewSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNewSet(this);
		}
	}

	public final SetDeclarationContext setDeclaration() throws RecognitionException {
		SetDeclarationContext _localctx = new SetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_setDeclaration);
		int _la;
		try {
			setState(431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new NewSetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				match(ID);
				setState(415);
				match(EQ);
				setState(416);
				match(LBRACKET);
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0)) {
					{
					setState(417);
					arrayElements();
					}
				}

				setState(420);
				match(RBRACKET);
				setState(421);
				match(VAKASIYANA);
				}
				break;
			case 2:
				_localctx = new ArrayToSetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(422);
				match(ID);
				setState(423);
				match(EQ);
				setState(424);
				match(ID);
				setState(425);
				match(VAKASIYANA);
				}
				break;
			case 3:
				_localctx = new ExprToSetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				match(ID);
				setState(427);
				match(EQ);
				setState(428);
				primaryExpression(0);
				setState(429);
				match(VAKASIYANA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SortStatementContext extends ParserRuleContext {
		public SortStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortStatement; }
	 
		public SortStatementContext() { }
		public void copyFrom(SortStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AscendingSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode CHIKWIRA() { return getToken(ShonascriptxParser.CHIKWIRA, 0); }
		public AscendingSortContext(SortStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAscendingSort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAscendingSort(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectAscSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode EQUALITY_PREPOSITION() { return getToken(ShonascriptxParser.EQUALITY_PREPOSITION, 0); }
		public TerminalNode CHIKWIRA() { return getToken(ShonascriptxParser.CHIKWIRA, 0); }
		public ObjectAscSortContext(SortStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjectAscSort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjectAscSort(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DescendingSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode CHIDZIKA() { return getToken(ShonascriptxParser.CHIDZIKA, 0); }
		public DescendingSortContext(SortStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDescendingSort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDescendingSort(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public DefaultSortContext(SortStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDefaultSort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDefaultSort(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectDescSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode EQUALITY_PREPOSITION() { return getToken(ShonascriptxParser.EQUALITY_PREPOSITION, 0); }
		public TerminalNode CHIDZIKA() { return getToken(ShonascriptxParser.CHIDZIKA, 0); }
		public ObjectDescSortContext(SortStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjectDescSort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjectDescSort(this);
		}
	}

	public final SortStatementContext sortStatement() throws RecognitionException {
		SortStatementContext _localctx = new SortStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sortStatement);
		try {
			setState(451);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new DefaultSortContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(433);
				match(RONGA);
				setState(434);
				match(ID);
				}
				break;
			case 2:
				_localctx = new DescendingSortContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				match(RONGA);
				setState(436);
				match(ID);
				setState(437);
				match(CHIDZIKA);
				}
				break;
			case 3:
				_localctx = new ObjectDescSortContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(438);
				match(RONGA);
				setState(439);
				match(ID);
				setState(440);
				match(EQUALITY_PREPOSITION);
				setState(441);
				match(ID);
				setState(442);
				match(CHIDZIKA);
				}
				break;
			case 4:
				_localctx = new ObjectAscSortContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(RONGA);
				setState(444);
				match(ID);
				setState(445);
				match(EQUALITY_PREPOSITION);
				setState(446);
				match(ID);
				setState(447);
				match(CHIKWIRA);
				}
				break;
			case 5:
				_localctx = new AscendingSortContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(448);
				match(RONGA);
				setState(449);
				match(ID);
				setState(450);
				match(CHIKWIRA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FilterStatementContext extends ParserRuleContext {
		public FilterStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterStatement; }
	 
		public FilterStatementContext() { }
		public void copyFrom(FilterStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DirectValueFilterContext extends FilterStatementContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public DirectValueFilterContext(FilterStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDirectValueFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDirectValueFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectFilterContext extends FilterStatementContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjectFilterContext(FilterStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjectFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjectFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveFilterContext extends FilterStatementContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public PrimitiveFilterContext(FilterStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPrimitiveFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPrimitiveFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassFilterContext extends FilterStatementContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public NounClassFilterContext(FilterStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNounClassFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNounClassFilter(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComplexFilterContext extends FilterStatementContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public LogicalFilterExpressionContext logicalFilterExpression() {
			return getRuleContext(LogicalFilterExpressionContext.class,0);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public ComplexFilterContext(FilterStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterComplexFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitComplexFilter(this);
		}
	}

	public final FilterStatementContext filterStatement() throws RecognitionException {
		FilterStatementContext _localctx = new FilterStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_filterStatement);
		try {
			setState(486);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ObjectFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				match(BVISA);
				setState(454);
				match(ID);
				setState(455);
				match(HAS);
				setState(456);
				match(ID);
				setState(457);
				comparisonOperator();
				setState(458);
				expression();
				}
				break;
			case 2:
				_localctx = new NounClassFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				match(BVISA);
				setState(461);
				match(HAS);
				setState(462);
				match(ID);
				setState(463);
				comparisonOperator();
				setState(464);
				expression();
				setState(465);
				match(MU);
				setState(466);
				match(ID);
				}
				break;
			case 3:
				_localctx = new PrimitiveFilterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(468);
				match(BVISA);
				setState(469);
				match(HAS);
				setState(470);
				comparisonOperator();
				setState(471);
				expression();
				setState(472);
				match(MU);
				setState(473);
				match(ID);
				}
				break;
			case 4:
				_localctx = new DirectValueFilterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(475);
				match(BVISA);
				setState(476);
				expression();
				setState(477);
				match(MU);
				setState(478);
				match(ID);
				}
				break;
			case 5:
				_localctx = new ComplexFilterContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(480);
				match(BVISA);
				setState(481);
				match(HAS);
				setState(482);
				logicalFilterExpression();
				setState(483);
				match(MU);
				setState(484);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalFilterExpressionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public List<ComparisonOperatorContext> comparisonOperator() {
			return getRuleContexts(ComparisonOperatorContext.class);
		}
		public ComparisonOperatorContext comparisonOperator(int i) {
			return getRuleContext(ComparisonOperatorContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> KANA() { return getTokens(ShonascriptxParser.KANA); }
		public TerminalNode KANA(int i) {
			return getToken(ShonascriptxParser.KANA, i);
		}
		public List<TerminalNode> KUTI() { return getTokens(ShonascriptxParser.KUTI); }
		public TerminalNode KUTI(int i) {
			return getToken(ShonascriptxParser.KUTI, i);
		}
		public List<TerminalNode> OR() { return getTokens(ShonascriptxParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ShonascriptxParser.OR, i);
		}
		public List<TerminalNode> LOGICAL_OR() { return getTokens(ShonascriptxParser.LOGICAL_OR); }
		public TerminalNode LOGICAL_OR(int i) {
			return getToken(ShonascriptxParser.LOGICAL_OR, i);
		}
		public List<TerminalNode> UYE() { return getTokens(ShonascriptxParser.UYE); }
		public TerminalNode UYE(int i) {
			return getToken(ShonascriptxParser.UYE, i);
		}
		public List<TerminalNode> AND() { return getTokens(ShonascriptxParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ShonascriptxParser.AND, i);
		}
		public List<TerminalNode> LOGICAL_AND() { return getTokens(ShonascriptxParser.LOGICAL_AND); }
		public TerminalNode LOGICAL_AND(int i) {
			return getToken(ShonascriptxParser.LOGICAL_AND, i);
		}
		public LogicalFilterExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalFilterExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLogicalFilterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLogicalFilterExpression(this);
		}
	}

	public final LogicalFilterExpressionContext logicalFilterExpression() throws RecognitionException {
		LogicalFilterExpressionContext _localctx = new LogicalFilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logicalFilterExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(ID);
			setState(489);
			comparisonOperator();
			setState(490);
			expression();
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 469773312L) != 0)) {
				{
				{
				setState(499);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(491);
					match(KANA);
					setState(492);
					match(KUTI);
					}
					break;
				case 2:
					{
					setState(493);
					match(KANA);
					}
					break;
				case 3:
					{
					setState(494);
					match(OR);
					}
					break;
				case 4:
					{
					setState(495);
					match(LOGICAL_OR);
					}
					break;
				case 5:
					{
					setState(496);
					match(UYE);
					}
					break;
				case 6:
					{
					setState(497);
					match(AND);
					}
					break;
				case 7:
					{
					setState(498);
					match(LOGICAL_AND);
					}
					break;
				}
				setState(501);
				match(ID);
				setState(502);
				comparisonOperator();
				setState(503);
				expression();
				}
				}
				setState(509);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(ShonascriptxParser.GT, 0); }
		public TerminalNode LT() { return getToken(ShonascriptxParser.LT, 0); }
		public TerminalNode GTE() { return getToken(ShonascriptxParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(ShonascriptxParser.LTE, 0); }
		public TerminalNode EQ_EQ() { return getToken(ShonascriptxParser.EQ_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(ShonascriptxParser.NOT_EQ, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitComparisonOperator(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			_la = _input.LA(1);
			if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 491523L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlVoidElementContext extends HtmlElementContext {
		public TerminalNode LT() { return getToken(ShonascriptxParser.LT, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode GT() { return getToken(ShonascriptxParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> WS_IN_HTML() { return getTokens(ShonascriptxParser.WS_IN_HTML); }
		public TerminalNode WS_IN_HTML(int i) {
			return getToken(ShonascriptxParser.WS_IN_HTML, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public HtmlVoidElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlVoidElement(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSelfClosingElementContext extends HtmlElementContext {
		public TerminalNode LT() { return getToken(ShonascriptxParser.LT, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(ShonascriptxParser.SLASH, 0); }
		public TerminalNode GT() { return getToken(ShonascriptxParser.GT, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> WS_IN_HTML() { return getTokens(ShonascriptxParser.WS_IN_HTML); }
		public TerminalNode WS_IN_HTML(int i) {
			return getToken(ShonascriptxParser.WS_IN_HTML, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public HtmlSelfClosingElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlSelfClosingElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlSelfClosingElement(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlBlockElementContext extends HtmlElementContext {
		public List<TerminalNode> LT() { return getTokens(ShonascriptxParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(ShonascriptxParser.LT, i);
		}
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(ShonascriptxParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(ShonascriptxParser.GT, i);
		}
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(ShonascriptxParser.SLASH, 0); }
		public List<TerminalNode> WS_IN_HTML() { return getTokens(ShonascriptxParser.WS_IN_HTML); }
		public TerminalNode WS_IN_HTML(int i) {
			return getToken(ShonascriptxParser.WS_IN_HTML, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public HtmlBlockElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlBlockElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlBlockElement(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_htmlElement);
		int _la;
		try {
			int _alt;
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new HtmlBlockElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				match(LT);
				setState(513);
				tagName();
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017613182818287616L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 671088641L) != 0)) {
					{
					setState(517);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WS_IN_HTML:
						{
						setState(514);
						match(WS_IN_HTML);
						}
						break;
					case ZVANYORWA:
					case IKANYORWA:
					case IKASARUDZWA:
					case ZVASARUDZWA:
					case CLASS:
					case EVENT_CLICK:
					case EVENT_SUBMIT:
					case EVENT_CHANGE:
					case ID:
						{
						setState(515);
						attribute();
						}
						break;
					case NEWLINE:
						{
						setState(516);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(521);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(522);
				match(GT);
				setState(523);
				htmlContent();
				setState(524);
				match(LT);
				setState(525);
				match(SLASH);
				setState(526);
				tagName();
				setState(527);
				match(GT);
				setState(531);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(528);
						match(NEWLINE);
						}
						} 
					}
					setState(533);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(534);
				match(LT);
				setState(535);
				tagName();
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017613182818287616L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 671088641L) != 0)) {
					{
					setState(539);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ZVANYORWA:
					case IKANYORWA:
					case IKASARUDZWA:
					case ZVASARUDZWA:
					case CLASS:
					case EVENT_CLICK:
					case EVENT_SUBMIT:
					case EVENT_CHANGE:
					case ID:
						{
						setState(536);
						attribute();
						}
						break;
					case WS_IN_HTML:
						{
						setState(537);
						match(WS_IN_HTML);
						}
						break;
					case NEWLINE:
						{
						setState(538);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(543);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(544);
				match(SLASH);
				setState(545);
				match(GT);
				setState(549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(546);
						match(NEWLINE);
						}
						} 
					}
					setState(551);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new HtmlVoidElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(552);
				match(LT);
				setState(553);
				tagName();
				setState(559);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017613182818287616L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 671088641L) != 0)) {
					{
					setState(557);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ZVANYORWA:
					case IKANYORWA:
					case IKASARUDZWA:
					case ZVASARUDZWA:
					case CLASS:
					case EVENT_CLICK:
					case EVENT_SUBMIT:
					case EVENT_CHANGE:
					case ID:
						{
						setState(554);
						attribute();
						}
						break;
					case WS_IN_HTML:
						{
						setState(555);
						match(WS_IN_HTML);
						}
						break;
					case NEWLINE:
						{
						setState(556);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(561);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(562);
				match(GT);
				setState(566);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(563);
						match(NEWLINE);
						}
						} 
					}
					setState(568);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public TerminalNode KANA() { return getToken(ShonascriptxParser.KANA, 0); }
		public TerminalNode KUTI() { return getToken(ShonascriptxParser.KUTI, 0); }
		public TerminalNode ZVIMWE() { return getToken(ShonascriptxParser.ZVIMWE, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode NYORA() { return getToken(ShonascriptxParser.NYORA, 0); }
		public TerminalNode ISA() { return getToken(ShonascriptxParser.ISA, 0); }
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitTagName(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_tagName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			_la = _input.LA(1);
			if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 36028797140205571L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlEventHandlerContext extends AttributeContext {
		public EventHandlerContext eventHandler() {
			return getRuleContext(EventHandlerContext.class,0);
		}
		public HtmlEventHandlerContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlEventHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlEventHandler(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends AttributeContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public ShonaExpressionContext shonaExpression() {
			return getRuleContext(ShonaExpressionContext.class,0);
		}
		public HtmlAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_attribute);
		try {
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new HtmlAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(573);
				attrName();
				setState(574);
				match(EQ);
				setState(577);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(575);
					match(STRING);
					}
					break;
				case LBRACE:
					{
					setState(576);
					shonaExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new HtmlEventHandlerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(579);
				eventHandler();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode EVENT_CLICK() { return getToken(ShonascriptxParser.EVENT_CLICK, 0); }
		public TerminalNode EVENT_SUBMIT() { return getToken(ShonascriptxParser.EVENT_SUBMIT, 0); }
		public TerminalNode EVENT_CHANGE() { return getToken(ShonascriptxParser.EVENT_CHANGE, 0); }
		public TerminalNode CLASS() { return getToken(ShonascriptxParser.CLASS, 0); }
		public TerminalNode ZVANYORWA() { return getToken(ShonascriptxParser.ZVANYORWA, 0); }
		public TerminalNode IKANYORWA() { return getToken(ShonascriptxParser.IKANYORWA, 0); }
		public TerminalNode IKASARUDZWA() { return getToken(ShonascriptxParser.IKASARUDZWA, 0); }
		public TerminalNode ZVASARUDZWA() { return getToken(ShonascriptxParser.ZVASARUDZWA, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAttrName(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_attrName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			_la = _input.LA(1);
			if ( !(((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & 4565172295303183L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventHandlerContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public ShonaExpressionContext shonaExpression() {
			return getRuleContext(ShonaExpressionContext.class,0);
		}
		public TerminalNode EVENT_CLICK() { return getToken(ShonascriptxParser.EVENT_CLICK, 0); }
		public TerminalNode EVENT_SUBMIT() { return getToken(ShonascriptxParser.EVENT_SUBMIT, 0); }
		public TerminalNode EVENT_CHANGE() { return getToken(ShonascriptxParser.EVENT_CHANGE, 0); }
		public EventHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventHandler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterEventHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitEventHandler(this);
		}
	}

	public final EventHandlerContext eventHandler() throws RecognitionException {
		EventHandlerContext _localctx = new EventHandlerContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_eventHandler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017612633061982208L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(585);
			match(EQ);
			setState(586);
			shonaExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ParserRuleContext {
		public List<HtmlContentElementContext> htmlContentElement() {
			return getRuleContexts(HtmlContentElementContext.class);
		}
		public HtmlContentElementContext htmlContentElement(int i) {
			return getRuleContext(HtmlContentElementContext.class,i);
		}
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlContent(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_htmlContent);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(588);
					htmlContentElement();
					}
					} 
				}
				setState(593);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentElementContext extends ParserRuleContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public ShonaControlFlowContext shonaControlFlow() {
			return getRuleContext(ShonaControlFlowContext.class,0);
		}
		public ShonaExpressionContext shonaExpression() {
			return getRuleContext(ShonaExpressionContext.class,0);
		}
		public HtmlTextContext htmlText() {
			return getRuleContext(HtmlTextContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public HtmlContentElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContentElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlContentElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlContentElement(this);
		}
	}

	public final HtmlContentElementContext htmlContentElement() throws RecognitionException {
		HtmlContentElementContext _localctx = new HtmlContentElementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_htmlContentElement);
		try {
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(594);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(595);
				shonaControlFlow();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(596);
				shonaExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(597);
				htmlText();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(598);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(599);
				match(INDENT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(600);
				match(DEDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShonaControlFlowContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ShonascriptxParser.LBRACE, 0); }
		public ConditionalInHtmlContext conditionalInHtml() {
			return getRuleContext(ConditionalInHtmlContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ShonascriptxParser.RBRACE, 0); }
		public LoopInHtmlContext loopInHtml() {
			return getRuleContext(LoopInHtmlContext.class,0);
		}
		public WhileInHtmlContext whileInHtml() {
			return getRuleContext(WhileInHtmlContext.class,0);
		}
		public ShonaControlFlowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shonaControlFlow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterShonaControlFlow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitShonaControlFlow(this);
		}
	}

	public final ShonaControlFlowContext shonaControlFlow() throws RecognitionException {
		ShonaControlFlowContext _localctx = new ShonaControlFlowContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_shonaControlFlow);
		try {
			setState(615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(603);
				match(LBRACE);
				setState(604);
				conditionalInHtml();
				setState(605);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
				match(LBRACE);
				setState(608);
				loopInHtml();
				setState(609);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(611);
				match(LBRACE);
				setState(612);
				whileInHtml();
				setState(613);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalInHtmlContext extends ParserRuleContext {
		public List<TerminalNode> KANA() { return getTokens(ShonascriptxParser.KANA); }
		public TerminalNode KANA(int i) {
			return getToken(ShonascriptxParser.KANA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ShonascriptxParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ShonascriptxParser.COLON, i);
		}
		public List<HtmlContentUntilKeywordContext> htmlContentUntilKeyword() {
			return getRuleContexts(HtmlContentUntilKeywordContext.class);
		}
		public HtmlContentUntilKeywordContext htmlContentUntilKeyword(int i) {
			return getRuleContext(HtmlContentUntilKeywordContext.class,i);
		}
		public List<TerminalNode> KUTI() { return getTokens(ShonascriptxParser.KUTI); }
		public TerminalNode KUTI(int i) {
			return getToken(ShonascriptxParser.KUTI, i);
		}
		public TerminalNode ZVIMWE() { return getToken(ShonascriptxParser.ZVIMWE, 0); }
		public HtmlContentToEndContext htmlContentToEnd() {
			return getRuleContext(HtmlContentToEndContext.class,0);
		}
		public ConditionalInHtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalInHtml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterConditionalInHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitConditionalInHtml(this);
		}
	}

	public final ConditionalInHtmlContext conditionalInHtml() throws RecognitionException {
		ConditionalInHtmlContext _localctx = new ConditionalInHtmlContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_conditionalInHtml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(KANA);
			setState(618);
			expression();
			setState(619);
			match(COLON);
			setState(620);
			htmlContentUntilKeyword();
			setState(629);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KANA) {
				{
				{
				setState(621);
				match(KANA);
				setState(622);
				match(KUTI);
				setState(623);
				expression();
				setState(624);
				match(COLON);
				setState(625);
				htmlContentUntilKeyword();
				}
				}
				setState(631);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ZVIMWE) {
				{
				setState(632);
				match(ZVIMWE);
				setState(633);
				match(COLON);
				setState(634);
				htmlContentToEnd();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentUntilKeywordContext extends ParserRuleContext {
		public List<HtmlContentPartContext> htmlContentPart() {
			return getRuleContexts(HtmlContentPartContext.class);
		}
		public HtmlContentPartContext htmlContentPart(int i) {
			return getRuleContext(HtmlContentPartContext.class,i);
		}
		public HtmlContentUntilKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContentUntilKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlContentUntilKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlContentUntilKeyword(this);
		}
	}

	public final HtmlContentUntilKeywordContext htmlContentUntilKeyword() throws RecognitionException {
		HtmlContentUntilKeywordContext _localctx = new HtmlContentUntilKeywordContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_htmlContentUntilKeyword);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(637);
					htmlContentPart();
					}
					} 
				}
				setState(642);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentToEndContext extends ParserRuleContext {
		public List<HtmlContentPartContext> htmlContentPart() {
			return getRuleContexts(HtmlContentPartContext.class);
		}
		public HtmlContentPartContext htmlContentPart(int i) {
			return getRuleContext(HtmlContentPartContext.class,i);
		}
		public HtmlContentToEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContentToEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlContentToEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlContentToEnd(this);
		}
	}

	public final HtmlContentToEndContext htmlContentToEnd() throws RecognitionException {
		HtmlContentToEndContext _localctx = new HtmlContentToEndContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_htmlContentToEnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(643);
					htmlContentPart();
					}
					} 
				}
				setState(648);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentPartContext extends ParserRuleContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ShonascriptxParser.LBRACE, 0); }
		public LoopInHtmlContext loopInHtml() {
			return getRuleContext(LoopInHtmlContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ShonascriptxParser.RBRACE, 0); }
		public ConditionalInHtmlContext conditionalInHtml() {
			return getRuleContext(ConditionalInHtmlContext.class,0);
		}
		public ShonaExpressionContext shonaExpression() {
			return getRuleContext(ShonaExpressionContext.class,0);
		}
		public HtmlTextNotKeywordContext htmlTextNotKeyword() {
			return getRuleContext(HtmlTextNotKeywordContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public HtmlContentPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContentPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlContentPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlContentPart(this);
		}
	}

	public final HtmlContentPartContext htmlContentPart() throws RecognitionException {
		HtmlContentPartContext _localctx = new HtmlContentPartContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_htmlContentPart);
		try {
			setState(663);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(649);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(650);
				match(LBRACE);
				setState(651);
				loopInHtml();
				setState(652);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(654);
				match(LBRACE);
				setState(655);
				conditionalInHtml();
				setState(656);
				match(RBRACE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(658);
				shonaExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(659);
				htmlTextNotKeyword();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(660);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(661);
				match(INDENT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(662);
				match(DEDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextNotKeywordContext extends ParserRuleContext {
		public List<HtmlTextContentNotKeywordContext> htmlTextContentNotKeyword() {
			return getRuleContexts(HtmlTextContentNotKeywordContext.class);
		}
		public HtmlTextContentNotKeywordContext htmlTextContentNotKeyword(int i) {
			return getRuleContext(HtmlTextContentNotKeywordContext.class,i);
		}
		public HtmlTextNotKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlTextNotKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlTextNotKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlTextNotKeyword(this);
		}
	}

	public final HtmlTextNotKeywordContext htmlTextNotKeyword() throws RecognitionException {
		HtmlTextNotKeywordContext _localctx = new HtmlTextNotKeywordContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_htmlTextNotKeyword);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(666); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(665);
					htmlTextContentNotKeyword();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(668); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContentNotKeywordContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public TerminalNode NYORA() { return getToken(ShonascriptxParser.NYORA, 0); }
		public TerminalNode ISA() { return getToken(ShonascriptxParser.ISA, 0); }
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public TerminalNode NUMBER() { return getToken(ShonascriptxParser.NUMBER, 0); }
		public TerminalNode AND() { return getToken(ShonascriptxParser.AND, 0); }
		public TerminalNode OR() { return getToken(ShonascriptxParser.OR, 0); }
		public TerminalNode UYE() { return getToken(ShonascriptxParser.UYE, 0); }
		public TerminalNode RETURN() { return getToken(ShonascriptxParser.RETURN, 0); }
		public TerminalNode DZOSA() { return getToken(ShonascriptxParser.DZOSA, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public TerminalNode COMMA() { return getToken(ShonascriptxParser.COMMA, 0); }
		public TerminalNode DOT() { return getToken(ShonascriptxParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode PLUS() { return getToken(ShonascriptxParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ShonascriptxParser.MINUS, 0); }
		public TerminalNode MUL() { return getToken(ShonascriptxParser.MUL, 0); }
		public TerminalNode SLASH() { return getToken(ShonascriptxParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(ShonascriptxParser.MOD, 0); }
		public TerminalNode GTE() { return getToken(ShonascriptxParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(ShonascriptxParser.LTE, 0); }
		public TerminalNode EQ_EQ() { return getToken(ShonascriptxParser.EQ_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(ShonascriptxParser.NOT_EQ, 0); }
		public TerminalNode NOT() { return getToken(ShonascriptxParser.NOT, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public TerminalNode WS_IN_HTML() { return getToken(ShonascriptxParser.WS_IN_HTML, 0); }
		public TerminalNode OTHER_TEXT() { return getToken(ShonascriptxParser.OTHER_TEXT, 0); }
		public TerminalNode LBRACE() { return getToken(ShonascriptxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ShonascriptxParser.RBRACE, 0); }
		public HtmlTextContentNotKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlTextContentNotKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlTextContentNotKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlTextContentNotKeyword(this);
		}
	}

	public final HtmlTextContentNotKeywordContext htmlTextContentNotKeyword() throws RecognitionException {
		HtmlTextContentNotKeywordContext _localctx = new HtmlTextContentNotKeywordContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_htmlTextContentNotKeyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 268905218556L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 2818310087L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopInHtmlContext extends ParserRuleContext {
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public HtmlContentToEndContext htmlContentToEnd() {
			return getRuleContext(HtmlContentToEndContext.class,0);
		}
		public LoopInHtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopInHtml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLoopInHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLoopInHtml(this);
		}
	}

	public final LoopInHtmlContext loopInHtml() throws RecognitionException {
		LoopInHtmlContext _localctx = new LoopInHtmlContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_loopInHtml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			match(PANE);
			setState(673);
			match(ID);
			setState(674);
			match(MU);
			setState(675);
			primaryExpression(0);
			setState(676);
			match(COLON);
			setState(677);
			htmlContentToEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileInHtmlContext extends ParserRuleContext {
		public TerminalNode KANA() { return getToken(ShonascriptxParser.KANA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DZOKORORA() { return getToken(ShonascriptxParser.DZOKORORA, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public HtmlContentToEndContext htmlContentToEnd() {
			return getRuleContext(HtmlContentToEndContext.class,0);
		}
		public WhileInHtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileInHtml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterWhileInHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitWhileInHtml(this);
		}
	}

	public final WhileInHtmlContext whileInHtml() throws RecognitionException {
		WhileInHtmlContext _localctx = new WhileInHtmlContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_whileInHtml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			match(KANA);
			setState(680);
			expression();
			setState(681);
			match(DZOKORORA);
			setState(682);
			match(COLON);
			setState(683);
			htmlContentToEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlSuiteContext extends ParserRuleContext {
		public HtmlSuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlSuite; }
	 
		public HtmlSuiteContext() { }
		public void copyFrom(HtmlSuiteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlBlockSuiteContext extends HtmlSuiteContext {
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public HtmlBlockSuiteContext(HtmlSuiteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlBlockSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlBlockSuite(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlIndentedSuiteContext extends HtmlSuiteContext {
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public HtmlIndentedSuiteContext(HtmlSuiteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlIndentedSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlIndentedSuite(this);
		}
	}

	public final HtmlSuiteContext htmlSuite() throws RecognitionException {
		HtmlSuiteContext _localctx = new HtmlSuiteContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_htmlSuite);
		try {
			setState(691);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				_localctx = new HtmlBlockSuiteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(685);
				htmlContent();
				}
				break;
			case 2:
				_localctx = new HtmlIndentedSuiteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(686);
				match(NEWLINE);
				setState(687);
				match(INDENT);
				setState(688);
				htmlContent();
				setState(689);
				match(DEDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShonaExpressionContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ShonascriptxParser.LBRACE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ShonascriptxParser.RBRACE, 0); }
		public ShonaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shonaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterShonaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitShonaExpression(this);
		}
	}

	public final ShonaExpressionContext shonaExpression() throws RecognitionException {
		ShonaExpressionContext _localctx = new ShonaExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_shonaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			match(LBRACE);
			setState(694);
			expression();
			setState(695);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContext extends ParserRuleContext {
		public List<HtmlTextContentContext> htmlTextContent() {
			return getRuleContexts(HtmlTextContentContext.class);
		}
		public HtmlTextContentContext htmlTextContent(int i) {
			return getRuleContext(HtmlTextContentContext.class,i);
		}
		public HtmlTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlText(this);
		}
	}

	public final HtmlTextContext htmlText() throws RecognitionException {
		HtmlTextContext _localctx = new HtmlTextContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_htmlText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(698); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(697);
					htmlTextContent();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(700); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlTextContentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public TerminalNode KUTI() { return getToken(ShonascriptxParser.KUTI, 0); }
		public TerminalNode ZVIMWE() { return getToken(ShonascriptxParser.ZVIMWE, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode NYORA() { return getToken(ShonascriptxParser.NYORA, 0); }
		public TerminalNode ISA() { return getToken(ShonascriptxParser.ISA, 0); }
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public TerminalNode NUMBER() { return getToken(ShonascriptxParser.NUMBER, 0); }
		public TerminalNode AND() { return getToken(ShonascriptxParser.AND, 0); }
		public TerminalNode OR() { return getToken(ShonascriptxParser.OR, 0); }
		public TerminalNode UYE() { return getToken(ShonascriptxParser.UYE, 0); }
		public TerminalNode RETURN() { return getToken(ShonascriptxParser.RETURN, 0); }
		public TerminalNode DZOSA() { return getToken(ShonascriptxParser.DZOSA, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public TerminalNode COMMA() { return getToken(ShonascriptxParser.COMMA, 0); }
		public TerminalNode DOT() { return getToken(ShonascriptxParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode PLUS() { return getToken(ShonascriptxParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ShonascriptxParser.MINUS, 0); }
		public TerminalNode MUL() { return getToken(ShonascriptxParser.MUL, 0); }
		public TerminalNode SLASH() { return getToken(ShonascriptxParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(ShonascriptxParser.MOD, 0); }
		public TerminalNode GTE() { return getToken(ShonascriptxParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(ShonascriptxParser.LTE, 0); }
		public TerminalNode EQ_EQ() { return getToken(ShonascriptxParser.EQ_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(ShonascriptxParser.NOT_EQ, 0); }
		public TerminalNode NOT() { return getToken(ShonascriptxParser.NOT, 0); }
		public TerminalNode WS_IN_HTML() { return getToken(ShonascriptxParser.WS_IN_HTML, 0); }
		public TerminalNode OTHER_TEXT() { return getToken(ShonascriptxParser.OTHER_TEXT, 0); }
		public TerminalNode LBRACE() { return getToken(ShonascriptxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ShonascriptxParser.RBRACE, 0); }
		public HtmlTextContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlTextContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlTextContent(this);
		}
	}

	public final HtmlTextContentContext htmlTextContent() throws RecognitionException {
		HtmlTextContentContext _localctx = new HtmlTextContentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_htmlTextContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(702);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 548614963708L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 2818310083L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode BVUNZA() { return getToken(ShonascriptxParser.BVUNZA, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitInputStatement(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(BVUNZA);
			setState(705);
			match(ID);
			setState(706);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FetchStatementContext extends ParserRuleContext {
		public TerminalNode TAMBIRA() { return getToken(ShonascriptxParser.TAMBIRA, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode KUBVA() { return getToken(ShonascriptxParser.KUBVA, 0); }
		public TerminalNode KU() { return getToken(ShonascriptxParser.KU, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public FetchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterFetchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitFetchStatement(this);
		}
	}

	public final FetchStatementContext fetchStatement() throws RecognitionException {
		FetchStatementContext _localctx = new FetchStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_fetchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			match(TAMBIRA);
			setState(709);
			match(ID);
			setState(710);
			match(KUBVA);
			setState(711);
			match(KU);
			setState(712);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode TORA() { return getToken(ShonascriptxParser.TORA, 0); }
		public IdListContext idList() {
			return getRuleContext(IdListContext.class,0);
		}
		public TerminalNode KUBVA() { return getToken(ShonascriptxParser.KUBVA, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public ModulePathContext modulePath() {
			return getRuleContext(ModulePathContext.class,0);
		}
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			match(TORA);
			setState(715);
			idList();
			setState(716);
			match(KUBVA);
			setState(717);
			match(MU);
			setState(718);
			modulePath();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public IdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitIdList(this);
		}
	}

	public final IdListContext idList() throws RecognitionException {
		IdListContext _localctx = new IdListContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_idList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			match(ID);
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(721);
				match(COMMA);
				setState(722);
				match(ID);
				}
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModulePathContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public ModulePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modulePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterModulePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitModulePath(this);
		}
	}

	public final ModulePathContext modulePath() throws RecognitionException {
		ModulePathContext _localctx = new ModulePathContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_modulePath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public PropNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPropName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPropName(this);
		}
	}

	public final PropNameContext propName() throws RecognitionException {
		PropNameContext _localctx = new PropNameContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_propName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			_la = _input.LA(1);
			if ( !(_la==BASA || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyRefContext extends ParserRuleContext {
		public List<PropNameContext> propName() {
			return getRuleContexts(PropNameContext.class);
		}
		public PropNameContext propName(int i) {
			return getRuleContext(PropNameContext.class,i);
		}
		public List<TerminalNode> POS() { return getTokens(ShonascriptxParser.POS); }
		public TerminalNode POS(int i) {
			return getToken(ShonascriptxParser.POS, i);
		}
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PropertyRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPropertyRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPropertyRef(this);
		}
	}

	public final PropertyRefContext propertyRef() throws RecognitionException {
		PropertyRefContext _localctx = new PropertyRefContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_propertyRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			propName();
			setState(737);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(733);
					match(POS);
					setState(734);
					propName();
					}
					} 
				}
				setState(739);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			setState(740);
			match(POS);
			setState(741);
			primaryExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDeleteContext extends ParserRuleContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public PropertyRefContext propertyRef() {
			return getRuleContext(PropertyRefContext.class,0);
		}
		public PropertyDeleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDelete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPropertyDelete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPropertyDelete(this);
		}
	}

	public final PropertyDeleteContext propertyDelete() throws RecognitionException {
		PropertyDeleteContext _localctx = new PropertyDeleteContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_propertyDelete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(743);
			match(BVISA);
			setState(744);
			propertyRef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomSelectorContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public DomSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDomSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDomSelector(this);
		}
	}

	public final DomSelectorContext domSelector() throws RecognitionException {
		DomSelectorContext _localctx = new DomSelectorContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_domSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			match(ID);
			setState(747);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DomPropertyRefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode POS() { return getToken(ShonascriptxParser.POS, 0); }
		public DomSelectorContext domSelector() {
			return getRuleContext(DomSelectorContext.class,0);
		}
		public DomPropertyRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domPropertyRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDomPropertyRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDomPropertyRef(this);
		}
	}

	public final DomPropertyRefContext domPropertyRef() throws RecognitionException {
		DomPropertyRefContext _localctx = new DomPropertyRefContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_domPropertyRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			match(ID);
			setState(750);
			match(POS);
			setState(751);
			domSelector();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventListenerStatementContext extends ParserRuleContext {
		public TerminalNode KANA() { return getToken(ShonascriptxParser.KANA, 0); }
		public DomSelectorContext domSelector() {
			return getRuleContext(DomSelectorContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode EVENT_CLICK() { return getToken(ShonascriptxParser.EVENT_CLICK, 0); }
		public TerminalNode EVENT_SUBMIT() { return getToken(ShonascriptxParser.EVENT_SUBMIT, 0); }
		public EventListenerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eventListenerStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterEventListenerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitEventListenerStatement(this);
		}
	}

	public final EventListenerStatementContext eventListenerStatement() throws RecognitionException {
		EventListenerStatementContext _localctx = new EventListenerStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_eventListenerStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(KANA);
			setState(754);
			domSelector();
			setState(755);
			_la = _input.LA(1);
			if ( !(_la==EVENT_CLICK || _la==EVENT_SUBMIT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(756);
			match(COLON);
			setState(757);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassStatementContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(ShonascriptxParser.CLASS, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public TerminalNode PA() { return getToken(ShonascriptxParser.PA, 0); }
		public DomSelectorContext domSelector() {
			return getRuleContext(DomSelectorContext.class,0);
		}
		public TerminalNode ISA() { return getToken(ShonascriptxParser.ISA, 0); }
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public ClassStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterClassStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitClassStatement(this);
		}
	}

	public final ClassStatementContext classStatement() throws RecognitionException {
		ClassStatementContext _localctx = new ClassStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_classStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			_la = _input.LA(1);
			if ( !(_la==ISA || _la==BVISA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(760);
			match(CLASS);
			setState(761);
			match(STRING);
			setState(762);
			match(PA);
			setState(763);
			domSelector();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopStatementContext extends ParserRuleContext {
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLoopStatement(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(765);
			match(PANE);
			setState(766);
			match(ID);
			setState(767);
			match(MU);
			setState(768);
			primaryExpression(0);
			setState(769);
			match(COLON);
			setState(770);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode KANA() { return getToken(ShonascriptxParser.KANA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DZOKORORA() { return getToken(ShonascriptxParser.DZOKORORA, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(KANA);
			setState(773);
			expression();
			setState(774);
			match(DZOKORORA);
			setState(775);
			match(COLON);
			setState(776);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntervalStatementContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode DZOKORORA() { return getToken(ShonascriptxParser.DZOKORORA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SECONDS() { return getToken(ShonascriptxParser.SECONDS, 0); }
		public IntervalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterIntervalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitIntervalStatement(this);
		}
	}

	public final IntervalStatementContext intervalStatement() throws RecognitionException {
		IntervalStatementContext _localctx = new IntervalStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_intervalStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			primaryExpression(0);
			setState(779);
			match(DZOKORORA);
			setState(780);
			expression();
			setState(781);
			match(SECONDS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeoutStatementContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode MIRIRA() { return getToken(ShonascriptxParser.MIRIRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SECONDS() { return getToken(ShonascriptxParser.SECONDS, 0); }
		public TimeoutStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeoutStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterTimeoutStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitTimeoutStatement(this);
		}
	}

	public final TimeoutStatementContext timeoutStatement() throws RecognitionException {
		TimeoutStatementContext _localctx = new TimeoutStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_timeoutStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(783);
			primaryExpression(0);
			setState(784);
			match(MIRIRA);
			setState(785);
			expression();
			setState(786);
			match(SECONDS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode JAMBA() { return getToken(ShonascriptxParser.JAMBA, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitContinueStatement(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			match(JAMBA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode MIRA() { return getToken(ShonascriptxParser.MIRA, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitBreakStatement(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			match(MIRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableContext extends ParserRuleContext {
		public AssignRootContext assignRoot() {
			return getRuleContext(AssignRootContext.class,0);
		}
		public List<MemberAccessContext> memberAccess() {
			return getRuleContexts(MemberAccessContext.class);
		}
		public MemberAccessContext memberAccess(int i) {
			return getRuleContext(MemberAccessContext.class,i);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAssignable(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_assignable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			assignRoot();
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET || _la==DOT) {
				{
				{
				setState(793);
				memberAccess();
				}
				}
				setState(798);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignRootContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public PropertyRefContext propertyRef() {
			return getRuleContext(PropertyRefContext.class,0);
		}
		public DomPropertyRefContext domPropertyRef() {
			return getRuleContext(DomPropertyRefContext.class,0);
		}
		public AssignRootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRoot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAssignRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAssignRoot(this);
		}
	}

	public final AssignRootContext assignRoot() throws RecognitionException {
		AssignRootContext _localctx = new AssignRootContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_assignRoot);
		try {
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(799);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(800);
				propertyRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(801);
				domPropertyRef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ShonascriptxParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitMemberAccess(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_memberAccess);
		try {
			setState(810);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(804);
				match(DOT);
				setState(805);
				match(ID);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(806);
				match(LBRACKET);
				setState(807);
				expression();
				setState(808);
				match(RBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public TerminalNode NDI() { return getToken(ShonascriptxParser.NDI, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
			assignable();
			setState(813);
			_la = _input.LA(1);
			if ( !(_la==NDI || _la==EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(814);
				match(NEWLINE);
				}
				}
				setState(819);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(820);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NyoraStatementContext extends ParserRuleContext {
		public TerminalNode NYORA() { return getToken(ShonascriptxParser.NYORA, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public NyoraStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nyoraStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNyoraStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNyoraStatement(this);
		}
	}

	public final NyoraStatementContext nyoraStatement() throws RecognitionException {
		NyoraStatementContext _localctx = new NyoraStatementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_nyoraStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(NYORA);
			setState(823);
			expression();
			setState(828);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(824);
					match(COMMA);
					setState(825);
					expression();
					}
					} 
				}
				setState(830);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAddContext extends ParserRuleContext {
		public TerminalNode ISA() { return getToken(ShonascriptxParser.ISA, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public ArrayAddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAdd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayAdd(this);
		}
	}

	public final ArrayAddContext arrayAdd() throws RecognitionException {
		ArrayAddContext _localctx = new ArrayAddContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_arrayAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			match(ISA);
			setState(832);
			expression();
			setState(833);
			match(MU);
			setState(834);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayRemoveContext extends ParserRuleContext {
		public TerminalNode BVISA() { return getToken(ShonascriptxParser.BVISA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public ArrayRemoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayRemove; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayRemove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayRemove(this);
		}
	}

	public final ArrayRemoveContext arrayRemove() throws RecognitionException {
		ArrayRemoveContext _localctx = new ArrayRemoveContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_arrayRemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			match(BVISA);
			setState(837);
			expression();
			setState(838);
			match(MU);
			setState(839);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalStatementContext extends ParserRuleContext {
		public List<TerminalNode> KANA() { return getTokens(ShonascriptxParser.KANA); }
		public TerminalNode KANA(int i) {
			return getToken(ShonascriptxParser.KANA, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(ShonascriptxParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ShonascriptxParser.COLON, i);
		}
		public List<SuiteContext> suite() {
			return getRuleContexts(SuiteContext.class);
		}
		public SuiteContext suite(int i) {
			return getRuleContext(SuiteContext.class,i);
		}
		public TerminalNode ZVIMWE() { return getToken(ShonascriptxParser.ZVIMWE, 0); }
		public List<TerminalNode> KUTI() { return getTokens(ShonascriptxParser.KUTI); }
		public TerminalNode KUTI(int i) {
			return getToken(ShonascriptxParser.KUTI, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitConditionalStatement(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_conditionalStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			match(KANA);
			setState(842);
			expression();
			setState(843);
			match(COLON);
			setState(844);
			suite();
			setState(859);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(846);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NEWLINE) {
						{
						setState(845);
						match(NEWLINE);
						}
					}

					setState(851);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						setState(848);
						match(KANA);
						setState(849);
						match(KUTI);
						}
						break;
					case 2:
						{
						setState(850);
						match(KANA);
						}
						break;
					}
					setState(853);
					expression();
					setState(854);
					match(COLON);
					setState(855);
					suite();
					}
					} 
				}
				setState(861);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			}
			setState(868);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(863);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(862);
					match(NEWLINE);
					}
				}

				setState(865);
				match(ZVIMWE);
				setState(866);
				match(COLON);
				setState(867);
				suite();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(ShonascriptxParser.FUNCTION, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION || _la==BASA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(871);
			match(ID);
			setState(872);
			match(LPAREN);
			setState(874);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(873);
				parameterList();
				}
			}

			setState(876);
			match(RPAREN);
			setState(877);
			match(COLON);
			setState(878);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousFunctionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(ShonascriptxParser.FUNCTION, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public AnonymousFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAnonymousFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAnonymousFunction(this);
		}
	}

	public final AnonymousFunctionContext anonymousFunction() throws RecognitionException {
		AnonymousFunctionContext _localctx = new AnonymousFunctionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_anonymousFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(880);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION || _la==BASA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(881);
			match(LPAREN);
			setState(883);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(882);
				parameterList();
				}
			}

			setState(885);
			match(RPAREN);
			setState(886);
			match(COLON);
			setState(887);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(ShonascriptxParser.RETURN, 0); }
		public TerminalNode DZOSA() { return getToken(ShonascriptxParser.DZOSA, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(889);
			_la = _input.LA(1);
			if ( !(_la==RETURN || _la==DZOSA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(890);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuiteContext extends ParserRuleContext {
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
	 
		public SuiteContext() { }
		public void copyFrom(SuiteContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleLineSuiteContext extends SuiteContext {
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public SingleLineSuiteContext(SuiteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterSingleLineSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitSingleLineSuite(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockSuiteContext extends SuiteContext {
		public TerminalNode NEWLINE() { return getToken(ShonascriptxParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(ShonascriptxParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(ShonascriptxParser.DEDENT, 0); }
		public List<ProgramElementContext> programElement() {
			return getRuleContexts(ProgramElementContext.class);
		}
		public ProgramElementContext programElement(int i) {
			return getRuleContext(ProgramElementContext.class,i);
		}
		public BlockSuiteContext(SuiteContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterBlockSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitBlockSuite(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_suite);
		int _la;
		try {
			setState(902);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PANE:
			case TARISA:
			case ZVANYORWA:
			case RONGA:
			case TAMBIRA:
			case HAS:
			case BOOLEAN:
			case FUNCTION:
			case BASA:
			case NYORA:
			case RETURN:
			case DZOSA:
			case ISA:
			case BVISA:
			case PA:
			case VERENGA:
			case BATANIDZA:
			case PROPS_KW:
			case BVUNZA:
			case TORA:
			case JAMBA:
			case MIRA:
			case ID:
			case NUMBER:
			case STRING:
			case LT:
			case LBRACE:
			case LPAREN:
			case LBRACKET:
			case PLUS:
			case MINUS:
			case NOT:
				_localctx = new SingleLineSuiteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(892);
				simpleStatement();
				}
				break;
			case NEWLINE:
				_localctx = new BlockSuiteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(893);
				match(NEWLINE);
				setState(894);
				match(INDENT);
				setState(896); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(895);
					programElement();
					}
					}
					setState(898); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 29115337472012288L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0) );
				setState(900);
				match(DEDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			conditionalExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitConditionalExpression(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			logicalOrExpression();
			setState(912);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(907);
				match(T__8);
				setState(908);
				expression();
				setState(909);
				match(COLON);
				setState(910);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public List<LogicalAndExpressionContext> logicalAndExpression() {
			return getRuleContexts(LogicalAndExpressionContext.class);
		}
		public LogicalAndExpressionContext logicalAndExpression(int i) {
			return getRuleContext(LogicalAndExpressionContext.class,i);
		}
		public List<TerminalNode> KANA() { return getTokens(ShonascriptxParser.KANA); }
		public TerminalNode KANA(int i) {
			return getToken(ShonascriptxParser.KANA, i);
		}
		public List<TerminalNode> KUTI() { return getTokens(ShonascriptxParser.KUTI); }
		public TerminalNode KUTI(int i) {
			return getToken(ShonascriptxParser.KUTI, i);
		}
		public List<TerminalNode> OR() { return getTokens(ShonascriptxParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ShonascriptxParser.OR, i);
		}
		public List<TerminalNode> LOGICAL_OR() { return getTokens(ShonascriptxParser.LOGICAL_OR); }
		public TerminalNode LOGICAL_OR(int i) {
			return getToken(ShonascriptxParser.LOGICAL_OR, i);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLogicalOrExpression(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_logicalOrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			logicalAndExpression();
			setState(925);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(920);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
					case 1:
						{
						setState(915);
						match(KANA);
						setState(916);
						match(KUTI);
						}
						break;
					case 2:
						{
						setState(917);
						match(KANA);
						}
						break;
					case 3:
						{
						setState(918);
						match(OR);
						}
						break;
					case 4:
						{
						setState(919);
						match(LOGICAL_OR);
						}
						break;
					}
					setState(922);
					logicalAndExpression();
					}
					} 
				}
				setState(927);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public List<EqualityExpressionContext> equalityExpression() {
			return getRuleContexts(EqualityExpressionContext.class);
		}
		public EqualityExpressionContext equalityExpression(int i) {
			return getRuleContext(EqualityExpressionContext.class,i);
		}
		public List<TerminalNode> UYE() { return getTokens(ShonascriptxParser.UYE); }
		public TerminalNode UYE(int i) {
			return getToken(ShonascriptxParser.UYE, i);
		}
		public List<TerminalNode> AND() { return getTokens(ShonascriptxParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ShonascriptxParser.AND, i);
		}
		public List<TerminalNode> LOGICAL_AND() { return getTokens(ShonascriptxParser.LOGICAL_AND); }
		public TerminalNode LOGICAL_AND(int i) {
			return getToken(ShonascriptxParser.LOGICAL_AND, i);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLogicalAndExpression(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_logicalAndExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
			equalityExpression();
			setState(933);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(929);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 201327616L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(930);
					equalityExpression();
					}
					} 
				}
				setState(935);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<ComparisonExpressionContext> comparisonExpression() {
			return getRuleContexts(ComparisonExpressionContext.class);
		}
		public ComparisonExpressionContext comparisonExpression(int i) {
			return getRuleContext(ComparisonExpressionContext.class,i);
		}
		public List<TerminalNode> EQ_EQ() { return getTokens(ShonascriptxParser.EQ_EQ); }
		public TerminalNode EQ_EQ(int i) {
			return getToken(ShonascriptxParser.EQ_EQ, i);
		}
		public List<TerminalNode> NOT_EQ() { return getTokens(ShonascriptxParser.NOT_EQ); }
		public TerminalNode NOT_EQ(int i) {
			return getToken(ShonascriptxParser.NOT_EQ, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitEqualityExpression(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_equalityExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			comparisonExpression();
			setState(941);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(937);
					_la = _input.LA(1);
					if ( !(_la==EQ_EQ || _la==NOT_EQ) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(938);
					comparisonExpression();
					}
					} 
				}
				setState(943);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<TerminalNode> GT() { return getTokens(ShonascriptxParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(ShonascriptxParser.GT, i);
		}
		public List<TerminalNode> LT() { return getTokens(ShonascriptxParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(ShonascriptxParser.LT, i);
		}
		public List<TerminalNode> GTE() { return getTokens(ShonascriptxParser.GTE); }
		public TerminalNode GTE(int i) {
			return getToken(ShonascriptxParser.GTE, i);
		}
		public List<TerminalNode> LTE() { return getTokens(ShonascriptxParser.LTE); }
		public TerminalNode LTE(int i) {
			return getToken(ShonascriptxParser.LTE, i);
		}
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitComparisonExpression(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_comparisonExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(944);
			additiveExpression();
			setState(949);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(945);
					_la = _input.LA(1);
					if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 98307L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(946);
					additiveExpression();
					}
					} 
				}
				setState(951);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(ShonascriptxParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(ShonascriptxParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(ShonascriptxParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(ShonascriptxParser.MINUS, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_additiveExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(952);
			multiplicativeExpression();
			setState(957);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(953);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(954);
					multiplicativeExpression();
					}
					} 
				}
				setState(959);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<PowerExpressionContext> powerExpression() {
			return getRuleContexts(PowerExpressionContext.class);
		}
		public PowerExpressionContext powerExpression(int i) {
			return getRuleContext(PowerExpressionContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(ShonascriptxParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(ShonascriptxParser.MUL, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(ShonascriptxParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(ShonascriptxParser.SLASH, i);
		}
		public List<TerminalNode> MOD() { return getTokens(ShonascriptxParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(ShonascriptxParser.MOD, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_multiplicativeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			powerExpression();
			setState(965);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(961);
					_la = _input.LA(1);
					if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 3073L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(962);
					powerExpression();
					}
					} 
				}
				setState(967);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PowerExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode POWER() { return getToken(ShonascriptxParser.POWER, 0); }
		public PowerExpressionContext powerExpression() {
			return getRuleContext(PowerExpressionContext.class,0);
		}
		public PowerExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPowerExpression(this);
		}
	}

	public final PowerExpressionContext powerExpression() throws RecognitionException {
		PowerExpressionContext _localctx = new PowerExpressionContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_powerExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(968);
			unaryExpression();
			setState(971);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(969);
				match(POWER);
				setState(970);
				powerExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	 
		public UnaryExpressionContext() { }
		public void copyFrom(UnaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends UnaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public PrimaryExprContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPrimaryExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOpContext extends UnaryExpressionContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ShonascriptxParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ShonascriptxParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(ShonascriptxParser.NOT, 0); }
		public UnaryOpContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitUnaryOp(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_unaryExpression);
		int _la;
		try {
			setState(976);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT:
				_localctx = new UnaryOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(973);
				_la = _input.LA(1);
				if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 515L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(974);
				unaryExpression();
				}
				break;
			case PANE:
			case ZVANYORWA:
			case TAMBIRA:
			case HAS:
			case BOOLEAN:
			case FUNCTION:
			case BASA:
			case PA:
			case VERENGA:
			case BATANIDZA:
			case BVUNZA:
			case ID:
			case NUMBER:
			case STRING:
			case LT:
			case LBRACE:
			case LPAREN:
			case LBRACKET:
				_localctx = new PrimaryExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(975);
				primaryExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarToSetExprContext extends PrimaryExpressionContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public VarToSetExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterVarToSetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitVarToSetExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends PrimaryExpressionContext {
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public ParensContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitParens(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousFunctionExprContext extends PrimaryExpressionContext {
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode FUNCTION() { return getToken(ShonascriptxParser.FUNCTION, 0); }
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public AnonymousFunctionExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterAnonymousFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitAnonymousFunctionExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends PrimaryExpressionContext {
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public StringContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassExistenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode RIPO_SUFFIX() { return getToken(ShonascriptxParser.RIPO_SUFFIX, 0); }
		public NounClassExistenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNounClassExistence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNounClassExistence(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends PrimaryExpressionContext {
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public ArrayElementsContext arrayElements() {
			return getRuleContext(ArrayElementsContext.class,0);
		}
		public ArrayLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexOpContext extends PrimaryExpressionContext {
		public TerminalNode PA() { return getToken(ShonascriptxParser.PA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public IndexOpContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterIndexOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitIndexOp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InStringOpContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode NCLASS() { return getToken(ShonascriptxParser.NCLASS, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public InStringOpContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterInStringOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitInStringOp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertyAccessContext extends PrimaryExpressionContext {
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public List<TerminalNode> POS() { return getTokens(ShonascriptxParser.POS); }
		public TerminalNode POS(int i) {
			return getToken(ShonascriptxParser.POS, i);
		}
		public PropertyAccessContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPropertyAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPropertyAccess(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassInequalityContext extends PrimaryExpressionContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public TerminalNode SIRI_SUFFIX() { return getToken(ShonascriptxParser.SIRI_SUFFIX, 0); }
		public NounClassInequalityContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNounClassInequality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNounClassInequality(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimeoutExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode MIRIRA() { return getToken(ShonascriptxParser.MIRIRA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SECONDS() { return getToken(ShonascriptxParser.SECONDS, 0); }
		public TimeoutExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterTimeoutExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitTimeoutExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketAccessContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public BracketAccessContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterBracketAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitBracketAccess(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LengthExprContext extends PrimaryExpressionContext {
		public TerminalNode VERENGA() { return getToken(ShonascriptxParser.VERENGA, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public LengthExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterLengthExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitLengthExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends PrimaryExpressionContext {
		public TerminalNode NUMBER() { return getToken(ShonascriptxParser.NUMBER, 0); }
		public NumberContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JoinExprContext extends PrimaryExpressionContext {
		public TerminalNode BATANIDZA() { return getToken(ShonascriptxParser.BATANIDZA, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public JoinExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterJoinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitJoinExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprToSetExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public ExprToSetExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterExprToSetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitExprToSetExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ZvanyorwaVarContext extends PrimaryExpressionContext {
		public TerminalNode ZVANYORWA() { return getToken(ShonascriptxParser.ZVANYORWA, 0); }
		public ZvanyorwaVarContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterZvanyorwaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitZvanyorwaVar(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NaturalEqualityOpContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode EQUALITY_VERB() { return getToken(ShonascriptxParser.EQUALITY_VERB, 0); }
		public TerminalNode EQUALITY_PREPOSITION() { return getToken(ShonascriptxParser.EQUALITY_PREPOSITION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NaturalEqualityOpContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNaturalEqualityOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNaturalEqualityOp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JsObjLiteralContext extends PrimaryExpressionContext {
		public JsObjectLiteralContext jsObjectLiteral() {
			return getRuleContext(JsObjectLiteralContext.class,0);
		}
		public JsObjLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterJsObjLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitJsObjLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayRangeContext extends PrimaryExpressionContext {
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public RangeExpressionContext rangeExpression() {
			return getRuleContext(RangeExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public ArrayRangeContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayRange(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlExprContext extends PrimaryExpressionContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterHtmlExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitHtmlExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjLiteralContext extends PrimaryExpressionContext {
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ObjLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InputExprContext extends PrimaryExpressionContext {
		public TerminalNode BVUNZA() { return getToken(ShonascriptxParser.BVUNZA, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public InputExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterInputExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitInputExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassEqualityContext extends PrimaryExpressionContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public TerminalNode NCLASS() { return getToken(ShonascriptxParser.NCLASS, 0); }
		public NounClassEqualityContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNounClassEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNounClassEquality(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertyGetContext extends PrimaryExpressionContext {
		public PropertyRefContext propertyRef() {
			return getRuleContext(PropertyRefContext.class,0);
		}
		public PropertyGetContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterPropertyGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitPropertyGet(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotAccessContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ShonascriptxParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public DotAccessContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDotAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDotAccess(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InArrayOpContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode NCLASS() { return getToken(ShonascriptxParser.NCLASS, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InArrayOpContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterInArrayOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitInArrayOp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends PrimaryExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(ShonascriptxParser.BOOLEAN, 0); }
		public BooleanContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitBoolean(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomPropertyGetContext extends PrimaryExpressionContext {
		public DomPropertyRefContext domPropertyRef() {
			return getRuleContext(DomPropertyRefContext.class,0);
		}
		public DomPropertyGetContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterDomPropertyGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitDomPropertyGet(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends PrimaryExpressionContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitFunctionCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FetchExprContext extends PrimaryExpressionContext {
		public TerminalNode TAMBIRA() { return getToken(ShonascriptxParser.TAMBIRA, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode KUBVA() { return getToken(ShonascriptxParser.KUBVA, 0); }
		public TerminalNode KU() { return getToken(ShonascriptxParser.KU, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public FetchExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterFetchExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitFetchExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends PrimaryExpressionContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public VariableContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitVariable(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassNonExistenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode SIPO_SUFFIX() { return getToken(ShonascriptxParser.SIPO_SUFFIX, 0); }
		public NounClassNonExistenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterNounClassNonExistence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitNounClassNonExistence(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntervalExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode DZOKORORA() { return getToken(ShonascriptxParser.DZOKORORA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SECONDS() { return getToken(ShonascriptxParser.SECONDS, 0); }
		public IntervalExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterIntervalExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitIntervalExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SetExprContext extends PrimaryExpressionContext {
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public ArrayElementsContext arrayElements() {
			return getRuleContext(ArrayElementsContext.class,0);
		}
		public SetExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterSetExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitSetExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends PrimaryExpressionContext {
		public TerminalNode BASA() { return getToken(ShonascriptxParser.BASA, 0); }
		public List<TerminalNode> POS() { return getTokens(ShonascriptxParser.POS); }
		public TerminalNode POS(int i) {
			return getToken(ShonascriptxParser.POS, i);
		}
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitMethodCall(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 170;
		enterRecursionRule(_localctx, 170, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1077);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				_localctx = new DomPropertyGetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(979);
				domPropertyRef();
				}
				break;
			case 2:
				{
				_localctx = new PropertyGetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(980);
				propertyRef();
				}
				break;
			case 3:
				{
				_localctx = new PropertyAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(981);
				match(ID);
				setState(982);
				match(POS);
				setState(983);
				match(ID);
				setState(986); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(984);
						match(POS);
						setState(985);
						match(ID);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(988); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				_localctx = new MethodCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(990);
				match(BASA);
				setState(991);
				match(POS);
				setState(992);
				match(ID);
				setState(997);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==POS) {
					{
					{
					setState(993);
					match(POS);
					setState(994);
					match(ID);
					}
					}
					setState(999);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1000);
				match(ID);
				setState(1001);
				match(LPAREN);
				setState(1003);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 8440471L) != 0)) {
					{
					setState(1002);
					argumentList();
					}
				}

				setState(1005);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1006);
				match(ID);
				setState(1007);
				match(LPAREN);
				setState(1009);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 8440471L) != 0)) {
					{
					setState(1008);
					argumentList();
					}
				}

				setState(1011);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new AnonymousFunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1012);
				_la = _input.LA(1);
				if ( !(_la==FUNCTION || _la==BASA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1013);
				match(LPAREN);
				setState(1015);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(1014);
					parameterList();
					}
				}

				setState(1017);
				match(RPAREN);
				setState(1018);
				match(COLON);
				setState(1019);
				suite();
				}
				break;
			case 7:
				{
				_localctx = new ArrayLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1020);
				match(LBRACKET);
				setState(1024);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1021);
						match(NEWLINE);
						}
						} 
					}
					setState(1026);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
				}
				setState(1028);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
				case 1:
					{
					setState(1027);
					arrayElements();
					}
					break;
				}
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(1030);
					match(NEWLINE);
					}
					}
					setState(1035);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1036);
				match(RBRACKET);
				}
				break;
			case 8:
				{
				_localctx = new ArrayRangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1037);
				match(LBRACKET);
				setState(1038);
				rangeExpression();
				setState(1039);
				match(RBRACKET);
				}
				break;
			case 9:
				{
				_localctx = new LengthExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1041);
				match(VERENGA);
				setState(1042);
				primaryExpression(28);
				}
				break;
			case 10:
				{
				_localctx = new JoinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1043);
				match(BATANIDZA);
				setState(1044);
				primaryExpression(27);
				}
				break;
			case 11:
				{
				_localctx = new IndexOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1045);
				match(PA);
				setState(1046);
				expression();
				setState(1047);
				match(MU);
				setState(1048);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 12:
				{
				_localctx = new SetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1050);
				match(LBRACKET);
				setState(1052);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0)) {
					{
					setState(1051);
					arrayElements();
					}
				}

				setState(1054);
				match(RBRACKET);
				setState(1055);
				match(VAKASIYANA);
				}
				break;
			case 13:
				{
				_localctx = new VarToSetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1056);
				match(ID);
				setState(1057);
				match(VAKASIYANA);
				}
				break;
			case 14:
				{
				_localctx = new InputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1058);
				match(BVUNZA);
				setState(1059);
				match(STRING);
				}
				break;
			case 15:
				{
				_localctx = new FetchExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1060);
				match(TAMBIRA);
				setState(1061);
				match(ID);
				setState(1062);
				match(KUBVA);
				setState(1063);
				match(KU);
				setState(1064);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 16:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1065);
				match(NUMBER);
				}
				break;
			case 17:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1066);
				match(BOOLEAN);
				}
				break;
			case 18:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1067);
				match(STRING);
				}
				break;
			case 19:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1068);
				match(ID);
				}
				break;
			case 20:
				{
				_localctx = new ZvanyorwaVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1069);
				match(ZVANYORWA);
				}
				break;
			case 21:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1070);
				match(LPAREN);
				setState(1071);
				expression();
				setState(1072);
				match(RPAREN);
				}
				break;
			case 22:
				{
				_localctx = new ObjLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1074);
				objectLiteral();
				}
				break;
			case 23:
				{
				_localctx = new JsObjLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1075);
				jsObjectLiteral();
				}
				break;
			case 24:
				{
				_localctx = new HtmlExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1076);
				htmlElement();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1121);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
					case 1:
						{
						_localctx = new NounClassEqualityContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1079);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1080);
						match(NCLASS);
						setState(1081);
						primaryExpression(10);
						}
						break;
					case 2:
						{
						_localctx = new NounClassInequalityContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1082);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1083);
						match(SIRI_SUFFIX);
						setState(1084);
						primaryExpression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprToSetExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1085);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(1086);
						match(VAKASIYANA);
						}
						break;
					case 4:
						{
						_localctx = new IntervalExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1087);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(1088);
						match(DZOKORORA);
						setState(1089);
						expression();
						setState(1090);
						match(SECONDS);
						}
						break;
					case 5:
						{
						_localctx = new TimeoutExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1092);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1093);
						match(MIRIRA);
						setState(1094);
						expression();
						setState(1095);
						match(SECONDS);
						}
						break;
					case 6:
						{
						_localctx = new InArrayOpContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1097);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1098);
						match(NCLASS);
						setState(1099);
						match(MU);
						setState(1100);
						expression();
						}
						break;
					case 7:
						{
						_localctx = new InStringOpContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1101);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1102);
						match(NCLASS);
						setState(1103);
						match(MU);
						setState(1104);
						match(STRING);
						}
						break;
					case 8:
						{
						_localctx = new NaturalEqualityOpContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1105);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1106);
						match(EQUALITY_VERB);
						setState(1107);
						match(EQUALITY_PREPOSITION);
						setState(1108);
						expression();
						}
						break;
					case 9:
						{
						_localctx = new NounClassExistenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1109);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1110);
						match(RIPO_SUFFIX);
						}
						break;
					case 10:
						{
						_localctx = new NounClassNonExistenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1111);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1112);
						match(SIPO_SUFFIX);
						}
						break;
					case 11:
						{
						_localctx = new DotAccessContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1113);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1114);
						match(DOT);
						setState(1115);
						match(ID);
						}
						break;
					case 12:
						{
						_localctx = new BracketAccessContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1116);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1117);
						match(LBRACKET);
						setState(1118);
						expression();
						setState(1119);
						match(RBRACKET);
						}
						break;
					}
					} 
				}
				setState(1125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjectLiteralContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public LinearObjectEntriesContext linearObjectEntries() {
			return getRuleContext(LinearObjectEntriesContext.class,0);
		}
		public TerminalNode HAS() { return getToken(ShonascriptxParser.HAS, 0); }
		public TerminalNode PANE() { return getToken(ShonascriptxParser.PANE, 0); }
		public ObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterObjectLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitObjectLiteral(this);
		}
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1126);
			_la = _input.LA(1);
			if ( !(_la==PANE || _la==HAS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1127);
			match(COLON);
			setState(1128);
			linearObjectEntries();
			setState(1130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(1129);
				match(T__0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JsObjectLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ShonascriptxParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ShonascriptxParser.RBRACE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public JsObjectEntriesContext jsObjectEntries() {
			return getRuleContext(JsObjectEntriesContext.class,0);
		}
		public JsObjectLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsObjectLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterJsObjectLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitJsObjectLiteral(this);
		}
	}

	public final JsObjectLiteralContext jsObjectLiteral() throws RecognitionException {
		JsObjectLiteralContext _localctx = new JsObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_jsObjectLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			match(LBRACE);
			setState(1136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1133);
					match(NEWLINE);
					}
					} 
				}
				setState(1138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,93,_ctx);
			}
			setState(1140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID || _la==STRING) {
				{
				setState(1139);
				jsObjectEntries();
				}
			}

			setState(1145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(1142);
				match(NEWLINE);
				}
				}
				setState(1147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1148);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JsObjectEntriesContext extends ParserRuleContext {
		public List<JsObjectEntryContext> jsObjectEntry() {
			return getRuleContexts(JsObjectEntryContext.class);
		}
		public JsObjectEntryContext jsObjectEntry(int i) {
			return getRuleContext(JsObjectEntryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public JsObjectEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsObjectEntries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterJsObjectEntries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitJsObjectEntries(this);
		}
	}

	public final JsObjectEntriesContext jsObjectEntries() throws RecognitionException {
		JsObjectEntriesContext _localctx = new JsObjectEntriesContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_jsObjectEntries);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1150);
			jsObjectEntry();
			setState(1168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1163);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(1151);
						match(COMMA);
						setState(1155);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(1152);
							match(NEWLINE);
							}
							}
							setState(1157);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case NEWLINE:
						{
						setState(1159); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1158);
							match(NEWLINE);
							}
							}
							setState(1161); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1165);
					jsObjectEntry();
					}
					} 
				}
				setState(1170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
			}
			setState(1172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1171);
				match(COMMA);
				}
			}

			setState(1177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1174);
					match(NEWLINE);
					}
					} 
				}
				setState(1179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JsObjectEntryContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ShonascriptxParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public JsObjectEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsObjectEntry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterJsObjectEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitJsObjectEntry(this);
		}
	}

	public final JsObjectEntryContext jsObjectEntry() throws RecognitionException {
		JsObjectEntryContext _localctx = new JsObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_jsObjectEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1180);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1181);
			match(COLON);
			setState(1182);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RangeExpressionContext extends ParserRuleContext {
		public RangeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpression; }
	 
		public RangeExpressionContext() { }
		public void copyFrom(RangeExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FullRangeContext extends RangeExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public TerminalNode ELLIPSIS() { return getToken(ShonascriptxParser.ELLIPSIS, 0); }
		public FullRangeContext(RangeExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterFullRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitFullRange(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleRangeContext extends RangeExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ShonascriptxParser.COMMA, 0); }
		public TerminalNode ELLIPSIS() { return getToken(ShonascriptxParser.ELLIPSIS, 0); }
		public SimpleRangeContext(RangeExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterSimpleRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitSimpleRange(this);
		}
	}

	public final RangeExpressionContext rangeExpression() throws RecognitionException {
		RangeExpressionContext _localctx = new RangeExpressionContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_rangeExpression);
		try {
			setState(1196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				_localctx = new FullRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1184);
				expression();
				setState(1185);
				match(COMMA);
				setState(1186);
				expression();
				setState(1187);
				match(COMMA);
				setState(1188);
				match(ELLIPSIS);
				setState(1189);
				expression();
				}
				break;
			case 2:
				_localctx = new SimpleRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1191);
				expression();
				setState(1192);
				match(COMMA);
				setState(1193);
				match(ELLIPSIS);
				setState(1194);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayElementsContext extends ParserRuleContext {
		public List<ArrayElementContext> arrayElement() {
			return getRuleContexts(ArrayElementContext.class);
		}
		public ArrayElementContext arrayElement(int i) {
			return getRuleContext(ArrayElementContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ShonascriptxParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ShonascriptxParser.NEWLINE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public ArrayElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayElements(this);
		}
	}

	public final ArrayElementsContext arrayElements() throws RecognitionException {
		ArrayElementsContext _localctx = new ArrayElementsContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_arrayElements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(1198);
				match(NEWLINE);
				}
				}
				setState(1203);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1204);
			arrayElement();
			setState(1222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1217);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(1205);
						match(COMMA);
						setState(1209);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(1206);
							match(NEWLINE);
							}
							}
							setState(1211);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case NEWLINE:
						{
						setState(1213); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1212);
							match(NEWLINE);
							}
							}
							setState(1215); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1219);
					arrayElement();
					}
					} 
				}
				setState(1224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
			}
			setState(1226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1225);
				match(COMMA);
				}
			}

			setState(1231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1228);
					match(NEWLINE);
					}
					} 
				}
				setState(1233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayElementContext extends ParserRuleContext {
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArrayElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArrayElement(this);
		}
	}

	public final ArrayElementContext arrayElement() throws RecognitionException {
		ArrayElementContext _localctx = new ArrayElementContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_arrayElement);
		try {
			setState(1236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1234);
				objectLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1235);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1238);
			expression();
			setState(1243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1239);
				match(COMMA);
				setState(1240);
				expression();
				}
				}
				setState(1245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShonascriptxParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShonascriptxParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShonascriptxListener ) ((ShonascriptxListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			match(ID);
			setState(1251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1247);
				match(COMMA);
				setState(1248);
				match(ID);
				}
				}
				setState(1253);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 85:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 21);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001b\u04e7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0001"+
		"\u0000\u0005\u0000\u00c0\b\u0000\n\u0000\f\u0000\u00c3\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00ca\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00d0\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00d4\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00ef\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00fa\b\u0006"+
		"\u000b\u0006\f\u0006\u00fb\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u010a\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003"+
		"\t\u0112\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0119\b\t"+
		"\u0001\n\u0001\n\u0001\n\u0005\n\u011e\b\n\n\n\f\n\u0121\t\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u012e\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0133\b\u000b\u0001\f"+
		"\u0001\f\u0005\f\u0137\b\f\n\f\f\f\u013a\t\f\u0001\f\u0005\f\u013d\b\f"+
		"\n\f\f\f\u0140\t\f\u0001\f\u0005\f\u0143\b\f\n\f\f\f\u0146\t\f\u0001\f"+
		"\u0005\f\u0149\b\f\n\f\f\f\u014c\t\f\u0001\f\u0005\f\u014f\b\f\n\f\f\f"+
		"\u0152\t\f\u0001\f\u0005\f\u0155\b\f\n\f\f\f\u0158\t\f\u0001\f\u0005\f"+
		"\u015b\b\f\n\f\f\f\u015e\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0174\b\r\u0001\r\u0003"+
		"\r\u0177\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u017c\b\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u0181\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u0187\b\u000e\n\u000e\f\u000e\u018a\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0191\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01a3\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01b0"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u01c4\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u01e7\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u01f4\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u01fa\b\u0017\n\u0017\f\u0017\u01fd\t\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0005\u0019\u0206\b\u0019\n\u0019\f\u0019\u0209\t\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005"+
		"\u0019\u0212\b\u0019\n\u0019\f\u0019\u0215\t\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u021c\b\u0019\n\u0019"+
		"\f\u0019\u021f\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u0224\b\u0019\n\u0019\f\u0019\u0227\t\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u022e\b\u0019\n\u0019\f\u0019"+
		"\u0231\t\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0235\b\u0019\n\u0019"+
		"\f\u0019\u0238\t\u0019\u0003\u0019\u023a\b\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0242\b\u001b"+
		"\u0001\u001b\u0003\u001b\u0245\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0005\u001e\u024e\b\u001e"+
		"\n\u001e\f\u001e\u0251\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u025a\b\u001f\u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u0268\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0005!\u0274\b!\n!\f!\u0277\t!\u0001!\u0001!\u0001"+
		"!\u0003!\u027c\b!\u0001\"\u0005\"\u027f\b\"\n\"\f\"\u0282\t\"\u0001#\u0005"+
		"#\u0285\b#\n#\f#\u0288\t#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0298\b$\u0001"+
		"%\u0004%\u029b\b%\u000b%\f%\u029c\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001("+
		"\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u02b4\b)\u0001"+
		"*\u0001*\u0001*\u0001*\u0001+\u0004+\u02bb\b+\u000b+\f+\u02bc\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u00010\u0005"+
		"0\u02d4\b0\n0\f0\u02d7\t0\u00011\u00011\u00012\u00012\u00013\u00013\u0001"+
		"3\u00053\u02e0\b3\n3\f3\u02e3\t3\u00013\u00013\u00013\u00014\u00014\u0001"+
		"4\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00018\u00018\u00018\u00018\u00018\u00018\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0001"+
		":\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001=\u0001=\u0001>\u0001>\u0001?\u0001?\u0005?\u031b"+
		"\b?\n?\f?\u031e\t?\u0001@\u0001@\u0001@\u0003@\u0323\b@\u0001A\u0001A"+
		"\u0001A\u0001A\u0001A\u0001A\u0003A\u032b\bA\u0001B\u0001B\u0001B\u0005"+
		"B\u0330\bB\nB\fB\u0333\tB\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0005"+
		"C\u033b\bC\nC\fC\u033e\tC\u0001D\u0001D\u0001D\u0001D\u0001D\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0001F\u0001F\u0003F\u034f"+
		"\bF\u0001F\u0001F\u0001F\u0003F\u0354\bF\u0001F\u0001F\u0001F\u0001F\u0005"+
		"F\u035a\bF\nF\fF\u035d\tF\u0001F\u0003F\u0360\bF\u0001F\u0001F\u0001F"+
		"\u0003F\u0365\bF\u0001G\u0001G\u0001G\u0001G\u0003G\u036b\bG\u0001G\u0001"+
		"G\u0001G\u0001G\u0001H\u0001H\u0001H\u0003H\u0374\bH\u0001H\u0001H\u0001"+
		"H\u0001H\u0001I\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0004J\u0381"+
		"\bJ\u000bJ\fJ\u0382\u0001J\u0001J\u0003J\u0387\bJ\u0001K\u0001K\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0001L\u0003L\u0391\bL\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0003M\u0399\bM\u0001M\u0005M\u039c\bM\nM\fM\u039f"+
		"\tM\u0001N\u0001N\u0001N\u0005N\u03a4\bN\nN\fN\u03a7\tN\u0001O\u0001O"+
		"\u0001O\u0005O\u03ac\bO\nO\fO\u03af\tO\u0001P\u0001P\u0001P\u0005P\u03b4"+
		"\bP\nP\fP\u03b7\tP\u0001Q\u0001Q\u0001Q\u0005Q\u03bc\bQ\nQ\fQ\u03bf\t"+
		"Q\u0001R\u0001R\u0001R\u0005R\u03c4\bR\nR\fR\u03c7\tR\u0001S\u0001S\u0001"+
		"S\u0003S\u03cc\bS\u0001T\u0001T\u0001T\u0003T\u03d1\bT\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0004U\u03db\bU\u000bU\fU\u03dc\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0005U\u03e4\bU\nU\fU\u03e7\tU\u0001U\u0001"+
		"U\u0001U\u0003U\u03ec\bU\u0001U\u0001U\u0001U\u0001U\u0003U\u03f2\bU\u0001"+
		"U\u0001U\u0001U\u0001U\u0003U\u03f8\bU\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0005U\u03ff\bU\nU\fU\u0402\tU\u0001U\u0003U\u0405\bU\u0001U\u0005U"+
		"\u0408\bU\nU\fU\u040b\tU\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0003"+
		"U\u041d\bU\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0003U\u0436\bU\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0001U\u0005U\u0462"+
		"\bU\nU\fU\u0465\tU\u0001V\u0001V\u0001V\u0001V\u0003V\u046b\bV\u0001W"+
		"\u0001W\u0005W\u046f\bW\nW\fW\u0472\tW\u0001W\u0003W\u0475\bW\u0001W\u0005"+
		"W\u0478\bW\nW\fW\u047b\tW\u0001W\u0001W\u0001X\u0001X\u0001X\u0005X\u0482"+
		"\bX\nX\fX\u0485\tX\u0001X\u0004X\u0488\bX\u000bX\fX\u0489\u0003X\u048c"+
		"\bX\u0001X\u0005X\u048f\bX\nX\fX\u0492\tX\u0001X\u0003X\u0495\bX\u0001"+
		"X\u0005X\u0498\bX\nX\fX\u049b\tX\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0001"+
		"Z\u0003Z\u04ad\bZ\u0001[\u0005[\u04b0\b[\n[\f[\u04b3\t[\u0001[\u0001["+
		"\u0001[\u0005[\u04b8\b[\n[\f[\u04bb\t[\u0001[\u0004[\u04be\b[\u000b[\f"+
		"[\u04bf\u0003[\u04c2\b[\u0001[\u0005[\u04c5\b[\n[\f[\u04c8\t[\u0001[\u0003"+
		"[\u04cb\b[\u0001[\u0005[\u04ce\b[\n[\f[\u04d1\t[\u0001\\\u0001\\\u0003"+
		"\\\u04d5\b\\\u0001]\u0001]\u0001]\u0005]\u04da\b]\n]\f]\u04dd\t]\u0001"+
		"^\u0001^\u0001^\u0005^\u04e2\b^\n^\f^\u04e5\t^\u0001^\u0000\u0001\u00aa"+
		"_\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"+
		"\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"+
		"\u00b4\u00b6\u00b8\u00ba\u00bc\u0000\u0016\u0002\u0000\f\f\u0018\u0018"+
		"\u0002\u0000==PP\u0001\u0000\u001e\u001f\u0003\u0000\u0001\u0001AB[[\u0001"+
		"\u0000\u0004\b\u0002\u0000GHVY\u0005\u0000\f\r\u001d\u001d\u001f!$&CC"+
		"\u0004\u0000\u000f\u0012\'\':<CC\u0001\u0000:<\t\u0000\u0002\b\u001a\u001c"+
		"\u001f\u001f!%CEITV]``bb\b\u0000\u0002\b\u001a\u001d\u001f&CDITV]``bb"+
		"\u0002\u0000CCEE\u0002\u0000\u001f\u001fCC\u0001\u0000:;\u0001\u0000$"+
		"%\u0001\u0000\"#\u0002\u0000\n\n\u001a\u001b\u0001\u0000XY\u0002\u0000"+
		"GHVW\u0001\u0000QR\u0002\u0000IIST\u0002\u0000QRZZ\u0556\u0000\u00c1\u0001"+
		"\u0000\u0000\u0000\u0002\u00c9\u0001\u0000\u0000\u0000\u0004\u00cf\u0001"+
		"\u0000\u0000\u0000\u0006\u00d3\u0001\u0000\u0000\u0000\b\u00ee\u0001\u0000"+
		"\u0000\u0000\n\u00f0\u0001\u0000\u0000\u0000\f\u00f4\u0001\u0000\u0000"+
		"\u0000\u000e\u00ff\u0001\u0000\u0000\u0000\u0010\u0104\u0001\u0000\u0000"+
		"\u0000\u0012\u0118\u0001\u0000\u0000\u0000\u0014\u011a\u0001\u0000\u0000"+
		"\u0000\u0016\u0132\u0001\u0000\u0000\u0000\u0018\u0134\u0001\u0000\u0000"+
		"\u0000\u001a\u0180\u0001\u0000\u0000\u0000\u001c\u0182\u0001\u0000\u0000"+
		"\u0000\u001e\u0190\u0001\u0000\u0000\u0000 \u0192\u0001\u0000\u0000\u0000"+
		"\"\u0195\u0001\u0000\u0000\u0000$\u0198\u0001\u0000\u0000\u0000&\u019c"+
		"\u0001\u0000\u0000\u0000(\u01af\u0001\u0000\u0000\u0000*\u01c3\u0001\u0000"+
		"\u0000\u0000,\u01e6\u0001\u0000\u0000\u0000.\u01e8\u0001\u0000\u0000\u0000"+
		"0\u01fe\u0001\u0000\u0000\u00002\u0239\u0001\u0000\u0000\u00004\u023b"+
		"\u0001\u0000\u0000\u00006\u0244\u0001\u0000\u0000\u00008\u0246\u0001\u0000"+
		"\u0000\u0000:\u0248\u0001\u0000\u0000\u0000<\u024f\u0001\u0000\u0000\u0000"+
		">\u0259\u0001\u0000\u0000\u0000@\u0267\u0001\u0000\u0000\u0000B\u0269"+
		"\u0001\u0000\u0000\u0000D\u0280\u0001\u0000\u0000\u0000F\u0286\u0001\u0000"+
		"\u0000\u0000H\u0297\u0001\u0000\u0000\u0000J\u029a\u0001\u0000\u0000\u0000"+
		"L\u029e\u0001\u0000\u0000\u0000N\u02a0\u0001\u0000\u0000\u0000P\u02a7"+
		"\u0001\u0000\u0000\u0000R\u02b3\u0001\u0000\u0000\u0000T\u02b5\u0001\u0000"+
		"\u0000\u0000V\u02ba\u0001\u0000\u0000\u0000X\u02be\u0001\u0000\u0000\u0000"+
		"Z\u02c0\u0001\u0000\u0000\u0000\\\u02c4\u0001\u0000\u0000\u0000^\u02ca"+
		"\u0001\u0000\u0000\u0000`\u02d0\u0001\u0000\u0000\u0000b\u02d8\u0001\u0000"+
		"\u0000\u0000d\u02da\u0001\u0000\u0000\u0000f\u02dc\u0001\u0000\u0000\u0000"+
		"h\u02e7\u0001\u0000\u0000\u0000j\u02ea\u0001\u0000\u0000\u0000l\u02ed"+
		"\u0001\u0000\u0000\u0000n\u02f1\u0001\u0000\u0000\u0000p\u02f7\u0001\u0000"+
		"\u0000\u0000r\u02fd\u0001\u0000\u0000\u0000t\u0304\u0001\u0000\u0000\u0000"+
		"v\u030a\u0001\u0000\u0000\u0000x\u030f\u0001\u0000\u0000\u0000z\u0314"+
		"\u0001\u0000\u0000\u0000|\u0316\u0001\u0000\u0000\u0000~\u0318\u0001\u0000"+
		"\u0000\u0000\u0080\u0322\u0001\u0000\u0000\u0000\u0082\u032a\u0001\u0000"+
		"\u0000\u0000\u0084\u032c\u0001\u0000\u0000\u0000\u0086\u0336\u0001\u0000"+
		"\u0000\u0000\u0088\u033f\u0001\u0000\u0000\u0000\u008a\u0344\u0001\u0000"+
		"\u0000\u0000\u008c\u0349\u0001\u0000\u0000\u0000\u008e\u0366\u0001\u0000"+
		"\u0000\u0000\u0090\u0370\u0001\u0000\u0000\u0000\u0092\u0379\u0001\u0000"+
		"\u0000\u0000\u0094\u0386\u0001\u0000\u0000\u0000\u0096\u0388\u0001\u0000"+
		"\u0000\u0000\u0098\u038a\u0001\u0000\u0000\u0000\u009a\u0392\u0001\u0000"+
		"\u0000\u0000\u009c\u03a0\u0001\u0000\u0000\u0000\u009e\u03a8\u0001\u0000"+
		"\u0000\u0000\u00a0\u03b0\u0001\u0000\u0000\u0000\u00a2\u03b8\u0001\u0000"+
		"\u0000\u0000\u00a4\u03c0\u0001\u0000\u0000\u0000\u00a6\u03c8\u0001\u0000"+
		"\u0000\u0000\u00a8\u03d0\u0001\u0000\u0000\u0000\u00aa\u0435\u0001\u0000"+
		"\u0000\u0000\u00ac\u0466\u0001\u0000\u0000\u0000\u00ae\u046c\u0001\u0000"+
		"\u0000\u0000\u00b0\u047e\u0001\u0000\u0000\u0000\u00b2\u049c\u0001\u0000"+
		"\u0000\u0000\u00b4\u04ac\u0001\u0000\u0000\u0000\u00b6\u04b1\u0001\u0000"+
		"\u0000\u0000\u00b8\u04d4\u0001\u0000\u0000\u0000\u00ba\u04d6\u0001\u0000"+
		"\u0000\u0000\u00bc\u04de\u0001\u0000\u0000\u0000\u00be\u00c0\u0003\u0002"+
		"\u0001\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\u0000\u0000\u0001\u00c5\u0001\u0001\u0000"+
		"\u0000\u0000\u00c6\u00ca\u00032\u0019\u0000\u00c7\u00ca\u0003\u0004\u0002"+
		"\u0000\u00c8\u00ca\u0003\f\u0006\u0000\u00c9\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000"+
		"\u00ca\u0003\u0001\u0000\u0000\u0000\u00cb\u00cc\u0003\u0006\u0003\u0000"+
		"\u00cc\u00cd\u0005^\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d0\u0005^\u0000\u0000\u00cf\u00cb\u0001\u0000\u0000\u0000\u00cf\u00ce"+
		"\u0001\u0000\u0000\u0000\u00d0\u0005\u0001\u0000\u0000\u0000\u00d1\u00d4"+
		"\u0003\b\u0004\u0000\u00d2\u00d4\u0003\u001e\u000f\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u0007\u0001"+
		"\u0000\u0000\u0000\u00d5\u00ef\u0003\u0010\b\u0000\u00d6\u00ef\u0003\u0084"+
		"B\u0000\u00d7\u00ef\u0003 \u0010\u0000\u00d8\u00ef\u0003\"\u0011\u0000"+
		"\u00d9\u00ef\u0003$\u0012\u0000\u00da\u00ef\u0003\u0086C\u0000\u00db\u00ef"+
		"\u0003h4\u0000\u00dc\u00ef\u0003\u0092I\u0000\u00dd\u00ef\u0003\u0088"+
		"D\u0000\u00de\u00ef\u0003\u008aE\u0000\u00df\u00ef\u0003(\u0014\u0000"+
		"\u00e0\u00ef\u0003*\u0015\u0000\u00e1\u00ef\u0003,\u0016\u0000\u00e2\u00ef"+
		"\u0003p8\u0000\u00e3\u00ef\u0003z=\u0000\u00e4\u00ef\u0003|>\u0000\u00e5"+
		"\u00ef\u0003\u0096K\u0000\u00e6\u00ef\u0003Z-\u0000\u00e7\u00ef\u0003"+
		"^/\u0000\u00e8\u00ef\u0003v;\u0000\u00e9\u00ef\u0003x<\u0000\u00ea\u00ef"+
		"\u0003\\.\u0000\u00eb\u00ef\u0003\u000e\u0007\u0000\u00ec\u00ef\u0003"+
		"\u001c\u000e\u0000\u00ed\u00ef\u0003\n\u0005\u0000\u00ee\u00d5\u0001\u0000"+
		"\u0000\u0000\u00ee\u00d6\u0001\u0000\u0000\u0000\u00ee\u00d7\u0001\u0000"+
		"\u0000\u0000\u00ee\u00d8\u0001\u0000\u0000\u0000\u00ee\u00d9\u0001\u0000"+
		"\u0000\u0000\u00ee\u00da\u0001\u0000\u0000\u0000\u00ee\u00db\u0001\u0000"+
		"\u0000\u0000\u00ee\u00dc\u0001\u0000\u0000\u0000\u00ee\u00dd\u0001\u0000"+
		"\u0000\u0000\u00ee\u00de\u0001\u0000\u0000\u0000\u00ee\u00df\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e0\u0001\u0000\u0000\u0000\u00ee\u00e1\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e2\u0001\u0000\u0000\u0000\u00ee\u00e3\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e4\u0001\u0000\u0000\u0000\u00ee\u00e5\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e6\u0001\u0000\u0000\u0000\u00ee\u00e7\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e8\u0001\u0000\u0000\u0000\u00ee\u00e9\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ea\u0001\u0000\u0000\u0000\u00ee\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ef\t\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u000e\u0000"+
		"\u0000\u00f1\u00f2\u0005]\u0000\u0000\u00f2\u00f3\u0003\u0006\u0003\u0000"+
		"\u00f3\u000b\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u000e\u0000\u0000"+
		"\u00f5\u00f6\u0005]\u0000\u0000\u00f6\u00f7\u0005^\u0000\u0000\u00f7\u00f9"+
		"\u0005A\u0000\u0000\u00f8\u00fa\u0003\u0002\u0001\u0000\u00f9\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0005B\u0000\u0000\u00fe\r\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0005C\u0000\u0000\u0100\u0101\u0007\u0000\u0000"+
		"\u0000\u0101\u0102\u0005]\u0000\u0000\u0102\u0103\u0003\u0012\t\u0000"+
		"\u0103\u000f\u0001\u0000\u0000\u0000\u0104\u0105\u0003~?\u0000\u0105\u0106"+
		"\u0007\u0001\u0000\u0000\u0106\u0107\u0007\u0002\u0000\u0000\u0107\u0109"+
		"\u0005L\u0000\u0000\u0108\u010a\u0003\u00bc^\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0005M\u0000\u0000\u010c\u010d\u0005]\u0000\u0000"+
		"\u010d\u010e\u0003\u0094J\u0000\u010e\u0011\u0001\u0000\u0000\u0000\u010f"+
		"\u0111\u0003\u0014\n\u0000\u0110\u0112\u0005\u0001\u0000\u0000\u0111\u0110"+
		"\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0119"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0005^\u0000\u0000\u0114\u0115\u0005"+
		"A\u0000\u0000\u0115\u0116\u0003\u0018\f\u0000\u0116\u0117\u0005B\u0000"+
		"\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u010f\u0001\u0000\u0000"+
		"\u0000\u0118\u0113\u0001\u0000\u0000\u0000\u0119\u0013\u0001\u0000\u0000"+
		"\u0000\u011a\u011f\u0003\u0016\u000b\u0000\u011b\u011c\u0005[\u0000\u0000"+
		"\u011c\u011e\u0003\u0016\u000b\u0000\u011d\u011b\u0001\u0000\u0000\u0000"+
		"\u011e\u0121\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000"+
		"\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u0015\u0001\u0000\u0000\u0000"+
		"\u0121\u011f\u0001\u0000\u0000\u0000\u0122\u0123\u0005C\u0000\u0000\u0123"+
		"\u0124\u0005P\u0000\u0000\u0124\u0133\u0003\u0096K\u0000\u0125\u0126\u0005"+
		"C\u0000\u0000\u0126\u0127\u0007\u0000\u0000\u0000\u0127\u0128\u0005]\u0000"+
		"\u0000\u0128\u0133\u0003\u0012\t\u0000\u0129\u012a\u0007\u0002\u0000\u0000"+
		"\u012a\u012b\u0005C\u0000\u0000\u012b\u012d\u0005L\u0000\u0000\u012c\u012e"+
		"\u0003\u00bc^\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012d\u012e\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0130\u0005"+
		"M\u0000\u0000\u0130\u0131\u0005]\u0000\u0000\u0131\u0133\u0003\u0096K"+
		"\u0000\u0132\u0122\u0001\u0000\u0000\u0000\u0132\u0125\u0001\u0000\u0000"+
		"\u0000\u0132\u0129\u0001\u0000\u0000\u0000\u0133\u0017\u0001\u0000\u0000"+
		"\u0000\u0134\u014a\u0003\u001a\r\u0000\u0135\u0137\u0005^\u0000\u0000"+
		"\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000"+
		"\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"+
		"\u0139\u013e\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"+
		"\u013b\u013d\u0007\u0003\u0000\u0000\u013c\u013b\u0001\u0000\u0000\u0000"+
		"\u013d\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000"+
		"\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0144\u0001\u0000\u0000\u0000"+
		"\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0143\u0005^\u0000\u0000\u0142"+
		"\u0141\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000\u0000\u0144"+
		"\u0142\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145"+
		"\u0147\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147"+
		"\u0149\u0003\u001a\r\u0000\u0148\u0138\u0001\u0000\u0000\u0000\u0149\u014c"+
		"\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014a\u014b"+
		"\u0001\u0000\u0000\u0000\u014b\u0150\u0001\u0000\u0000\u0000\u014c\u014a"+
		"\u0001\u0000\u0000\u0000\u014d\u014f\u0005^\u0000\u0000\u014e\u014d\u0001"+
		"\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0156\u0001"+
		"\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0155\u0007"+
		"\u0003\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0155\u0158\u0001"+
		"\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001"+
		"\u0000\u0000\u0000\u0157\u015c\u0001\u0000\u0000\u0000\u0158\u0156\u0001"+
		"\u0000\u0000\u0000\u0159\u015b\u0005^\u0000\u0000\u015a\u0159\u0001\u0000"+
		"\u0000\u0000\u015b\u015e\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u0019\u0001\u0000"+
		"\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0160\u0005C\u0000"+
		"\u0000\u0160\u0161\u0005P\u0000\u0000\u0161\u0181\u0003\u0096K\u0000\u0162"+
		"\u0163\u0005C\u0000\u0000\u0163\u0164\u0007\u0000\u0000\u0000\u0164\u0165"+
		"\u0005]\u0000\u0000\u0165\u0166\u0005^\u0000\u0000\u0166\u0167\u0005A"+
		"\u0000\u0000\u0167\u0168\u0003\u0018\f\u0000\u0168\u0169\u0005B\u0000"+
		"\u0000\u0169\u0181\u0001\u0000\u0000\u0000\u016a\u016b\u0005C\u0000\u0000"+
		"\u016b\u016c\u0007\u0000\u0000\u0000\u016c\u016d\u0005]\u0000\u0000\u016d"+
		"\u0181\u0005\u0001\u0000\u0000\u016e\u016f\u0005C\u0000\u0000\u016f\u0170"+
		"\u0007\u0000\u0000\u0000\u0170\u0171\u0005]\u0000\u0000\u0171\u0173\u0003"+
		"\u0014\n\u0000\u0172\u0174\u0005\u0001\u0000\u0000\u0173\u0172\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0181\u0001\u0000"+
		"\u0000\u0000\u0175\u0177\u0007\u0002\u0000\u0000\u0176\u0175\u0001\u0000"+
		"\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000"+
		"\u0000\u0000\u0178\u0179\u0005C\u0000\u0000\u0179\u017b\u0005L\u0000\u0000"+
		"\u017a\u017c\u0003\u00bc^\u0000\u017b\u017a\u0001\u0000\u0000\u0000\u017b"+
		"\u017c\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d"+
		"\u017e\u0005M\u0000\u0000\u017e\u017f\u0005]\u0000\u0000\u017f\u0181\u0003"+
		"\u0094J\u0000\u0180\u015f\u0001\u0000\u0000\u0000\u0180\u0162\u0001\u0000"+
		"\u0000\u0000\u0180\u016a\u0001\u0000\u0000\u0000\u0180\u016e\u0001\u0000"+
		"\u0000\u0000\u0180\u0176\u0001\u0000\u0000\u0000\u0181\u001b\u0001\u0000"+
		"\u0000\u0000\u0182\u0183\u00050\u0000\u0000\u0183\u0188\u0005C\u0000\u0000"+
		"\u0184\u0185\u0005[\u0000\u0000\u0185\u0187\u0005C\u0000\u0000\u0186\u0184"+
		"\u0001\u0000\u0000\u0000\u0187\u018a\u0001\u0000\u0000\u0000\u0188\u0186"+
		"\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u001d"+
		"\u0001\u0000\u0000\u0000\u018a\u0188\u0001\u0000\u0000\u0000\u018b\u0191"+
		"\u0003\u008eG\u0000\u018c\u0191\u0003n7\u0000\u018d\u0191\u0003\u008c"+
		"F\u0000\u018e\u0191\u0003r9\u0000\u018f\u0191\u0003t:\u0000\u0190\u018b"+
		"\u0001\u0000\u0000\u0000\u0190\u018c\u0001\u0000\u0000\u0000\u0190\u018d"+
		"\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u018f"+
		"\u0001\u0000\u0000\u0000\u0191\u001f\u0001\u0000\u0000\u0000\u0192\u0193"+
		"\u0003~?\u0000\u0193\u0194\u0005\u0002\u0000\u0000\u0194!\u0001\u0000"+
		"\u0000\u0000\u0195\u0196\u0003~?\u0000\u0196\u0197\u0005\u0003\u0000\u0000"+
		"\u0197#\u0001\u0000\u0000\u0000\u0198\u0199\u0003~?\u0000\u0199\u019a"+
		"\u0003&\u0013\u0000\u019a\u019b\u0003\u0096K\u0000\u019b%\u0001\u0000"+
		"\u0000\u0000\u019c\u019d\u0007\u0004\u0000\u0000\u019d\'\u0001\u0000\u0000"+
		"\u0000\u019e\u019f\u0005C\u0000\u0000\u019f\u01a0\u0005P\u0000\u0000\u01a0"+
		"\u01a2\u0005N\u0000\u0000\u01a1\u01a3\u0003\u00b6[\u0000\u01a2\u01a1\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a4\u01a5\u0005O\u0000\u0000\u01a5\u01b0\u0005\u0014"+
		"\u0000\u0000\u01a6\u01a7\u0005C\u0000\u0000\u01a7\u01a8\u0005P\u0000\u0000"+
		"\u01a8\u01a9\u0005C\u0000\u0000\u01a9\u01b0\u0005\u0014\u0000\u0000\u01aa"+
		"\u01ab\u0005C\u0000\u0000\u01ab\u01ac\u0005P\u0000\u0000\u01ac\u01ad\u0003"+
		"\u00aaU\u0000\u01ad\u01ae\u0005\u0014\u0000\u0000\u01ae\u01b0\u0001\u0000"+
		"\u0000\u0000\u01af\u019e\u0001\u0000\u0000\u0000\u01af\u01a6\u0001\u0000"+
		"\u0000\u0000\u01af\u01aa\u0001\u0000\u0000\u0000\u01b0)\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b2\u0005\u0013\u0000\u0000\u01b2\u01c4\u0005C\u0000\u0000"+
		"\u01b3\u01b4\u0005\u0013\u0000\u0000\u01b4\u01b5\u0005C\u0000\u0000\u01b5"+
		"\u01c4\u0005\u0015\u0000\u0000\u01b6\u01b7\u0005\u0013\u0000\u0000\u01b7"+
		"\u01b8\u0005C\u0000\u0000\u01b8\u01b9\u0005?\u0000\u0000\u01b9\u01ba\u0005"+
		"C\u0000\u0000\u01ba\u01c4\u0005\u0015\u0000\u0000\u01bb\u01bc\u0005\u0013"+
		"\u0000\u0000\u01bc\u01bd\u0005C\u0000\u0000\u01bd\u01be\u0005?\u0000\u0000"+
		"\u01be\u01bf\u0005C\u0000\u0000\u01bf\u01c4\u0005\u0016\u0000\u0000\u01c0"+
		"\u01c1\u0005\u0013\u0000\u0000\u01c1\u01c2\u0005C\u0000\u0000\u01c2\u01c4"+
		"\u0005\u0016\u0000\u0000\u01c3\u01b1\u0001\u0000\u0000\u0000\u01c3\u01b3"+
		"\u0001\u0000\u0000\u0000\u01c3\u01b6\u0001\u0000\u0000\u0000\u01c3\u01bb"+
		"\u0001\u0000\u0000\u0000\u01c3\u01c0\u0001\u0000\u0000\u0000\u01c4+\u0001"+
		"\u0000\u0000\u0000\u01c5\u01c6\u0005%\u0000\u0000\u01c6\u01c7\u0005C\u0000"+
		"\u0000\u01c7\u01c8\u0005\u0018\u0000\u0000\u01c8\u01c9\u0005C\u0000\u0000"+
		"\u01c9\u01ca\u00030\u0018\u0000\u01ca\u01cb\u0003\u0096K\u0000\u01cb\u01e7"+
		"\u0001\u0000\u0000\u0000\u01cc\u01cd\u0005%\u0000\u0000\u01cd\u01ce\u0005"+
		"\u0018\u0000\u0000\u01ce\u01cf\u0005C\u0000\u0000\u01cf\u01d0\u00030\u0018"+
		"\u0000\u01d0\u01d1\u0003\u0096K\u0000\u01d1\u01d2\u0005&\u0000\u0000\u01d2"+
		"\u01d3\u0005C\u0000\u0000\u01d3\u01e7\u0001\u0000\u0000\u0000\u01d4\u01d5"+
		"\u0005%\u0000\u0000\u01d5\u01d6\u0005\u0018\u0000\u0000\u01d6\u01d7\u0003"+
		"0\u0018\u0000\u01d7\u01d8\u0003\u0096K\u0000\u01d8\u01d9\u0005&\u0000"+
		"\u0000\u01d9\u01da\u0005C\u0000\u0000\u01da\u01e7\u0001\u0000\u0000\u0000"+
		"\u01db\u01dc\u0005%\u0000\u0000\u01dc\u01dd\u0003\u0096K\u0000\u01dd\u01de"+
		"\u0005&\u0000\u0000\u01de\u01df\u0005C\u0000\u0000\u01df\u01e7\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e1\u0005%\u0000\u0000\u01e1\u01e2\u0005\u0018\u0000"+
		"\u0000\u01e2\u01e3\u0003.\u0017\u0000\u01e3\u01e4\u0005&\u0000\u0000\u01e4"+
		"\u01e5\u0005C\u0000\u0000\u01e5\u01e7\u0001\u0000\u0000\u0000\u01e6\u01c5"+
		"\u0001\u0000\u0000\u0000\u01e6\u01cc\u0001\u0000\u0000\u0000\u01e6\u01d4"+
		"\u0001\u0000\u0000\u0000\u01e6\u01db\u0001\u0000\u0000\u0000\u01e6\u01e0"+
		"\u0001\u0000\u0000\u0000\u01e7-\u0001\u0000\u0000\u0000\u01e8\u01e9\u0005"+
		"C\u0000\u0000\u01e9\u01ea\u00030\u0018\u0000\u01ea\u01fb\u0003\u0096K"+
		"\u0000\u01eb\u01ec\u0005\r\u0000\u0000\u01ec\u01f4\u0005 \u0000\u0000"+
		"\u01ed\u01f4\u0005\r\u0000\u0000\u01ee\u01f4\u0005\u001c\u0000\u0000\u01ef"+
		"\u01f4\u0005\u000b\u0000\u0000\u01f0\u01f4\u0005\u001a\u0000\u0000\u01f1"+
		"\u01f4\u0005\u001b\u0000\u0000\u01f2\u01f4\u0005\n\u0000\u0000\u01f3\u01eb"+
		"\u0001\u0000\u0000\u0000\u01f3\u01ed\u0001\u0000\u0000\u0000\u01f3\u01ee"+
		"\u0001\u0000\u0000\u0000\u01f3\u01ef\u0001\u0000\u0000\u0000\u01f3\u01f0"+
		"\u0001\u0000\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5\u01f6"+
		"\u0005C\u0000\u0000\u01f6\u01f7\u00030\u0018\u0000\u01f7\u01f8\u0003\u0096"+
		"K\u0000\u01f8\u01fa\u0001\u0000\u0000\u0000\u01f9\u01f3\u0001\u0000\u0000"+
		"\u0000\u01fa\u01fd\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000"+
		"\u0000\u01fb\u01fc\u0001\u0000\u0000\u0000\u01fc/\u0001\u0000\u0000\u0000"+
		"\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fe\u01ff\u0007\u0005\u0000\u0000"+
		"\u01ff1\u0001\u0000\u0000\u0000\u0200\u0201\u0005G\u0000\u0000\u0201\u0207"+
		"\u00034\u001a\u0000\u0202\u0206\u0005`\u0000\u0000\u0203\u0206\u00036"+
		"\u001b\u0000\u0204\u0206\u0005^\u0000\u0000\u0205\u0202\u0001\u0000\u0000"+
		"\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0205\u0204\u0001\u0000\u0000"+
		"\u0000\u0206\u0209\u0001\u0000\u0000\u0000\u0207\u0205\u0001\u0000\u0000"+
		"\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u020a\u0001\u0000\u0000"+
		"\u0000\u0209\u0207\u0001\u0000\u0000\u0000\u020a\u020b\u0005H\u0000\u0000"+
		"\u020b\u020c\u0003<\u001e\u0000\u020c\u020d\u0005G\u0000\u0000\u020d\u020e"+
		"\u0005I\u0000\u0000\u020e\u020f\u00034\u001a\u0000\u020f\u0213\u0005H"+
		"\u0000\u0000\u0210\u0212\u0005^\u0000\u0000\u0211\u0210\u0001\u0000\u0000"+
		"\u0000\u0212\u0215\u0001\u0000\u0000\u0000\u0213\u0211\u0001\u0000\u0000"+
		"\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214\u023a\u0001\u0000\u0000"+
		"\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0216\u0217\u0005G\u0000\u0000"+
		"\u0217\u021d\u00034\u001a\u0000\u0218\u021c\u00036\u001b\u0000\u0219\u021c"+
		"\u0005`\u0000\u0000\u021a\u021c\u0005^\u0000\u0000\u021b\u0218\u0001\u0000"+
		"\u0000\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021b\u021a\u0001\u0000"+
		"\u0000\u0000\u021c\u021f\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000"+
		"\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e\u0220\u0001\u0000"+
		"\u0000\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0221\u0005I\u0000"+
		"\u0000\u0221\u0225\u0005H\u0000\u0000\u0222\u0224\u0005^\u0000\u0000\u0223"+
		"\u0222\u0001\u0000\u0000\u0000\u0224\u0227\u0001\u0000\u0000\u0000\u0225"+
		"\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000\u0000\u0000\u0226"+
		"\u023a\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0228"+
		"\u0229\u0005G\u0000\u0000\u0229\u022f\u00034\u001a\u0000\u022a\u022e\u0003"+
		"6\u001b\u0000\u022b\u022e\u0005`\u0000\u0000\u022c\u022e\u0005^\u0000"+
		"\u0000\u022d\u022a\u0001\u0000\u0000\u0000\u022d\u022b\u0001\u0000\u0000"+
		"\u0000\u022d\u022c\u0001\u0000\u0000\u0000\u022e\u0231\u0001\u0000\u0000"+
		"\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000"+
		"\u0000\u0230\u0232\u0001\u0000\u0000\u0000\u0231\u022f\u0001\u0000\u0000"+
		"\u0000\u0232\u0236\u0005H\u0000\u0000\u0233\u0235\u0005^\u0000\u0000\u0234"+
		"\u0233\u0001\u0000\u0000\u0000\u0235\u0238\u0001\u0000\u0000\u0000\u0236"+
		"\u0234\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000\u0000\u0237"+
		"\u023a\u0001\u0000\u0000\u0000\u0238\u0236\u0001\u0000\u0000\u0000\u0239"+
		"\u0200\u0001\u0000\u0000\u0000\u0239\u0216\u0001\u0000\u0000\u0000\u0239"+
		"\u0228\u0001\u0000\u0000\u0000\u023a3\u0001\u0000\u0000\u0000\u023b\u023c"+
		"\u0007\u0006\u0000\u0000\u023c5\u0001\u0000\u0000\u0000\u023d\u023e\u0003"+
		"8\u001c\u0000\u023e\u0241\u0005P\u0000\u0000\u023f\u0242\u0005E\u0000"+
		"\u0000\u0240\u0242\u0003T*\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241"+
		"\u0240\u0001\u0000\u0000\u0000\u0242\u0245\u0001\u0000\u0000\u0000\u0243"+
		"\u0245\u0003:\u001d\u0000\u0244\u023d\u0001\u0000\u0000\u0000\u0244\u0243"+
		"\u0001\u0000\u0000\u0000\u02457\u0001\u0000\u0000\u0000\u0246\u0247\u0007"+
		"\u0007\u0000\u0000\u02479\u0001\u0000\u0000\u0000\u0248\u0249\u0007\b"+
		"\u0000\u0000\u0249\u024a\u0005P\u0000\u0000\u024a\u024b\u0003T*\u0000"+
		"\u024b;\u0001\u0000\u0000\u0000\u024c\u024e\u0003>\u001f\u0000\u024d\u024c"+
		"\u0001\u0000\u0000\u0000\u024e\u0251\u0001\u0000\u0000\u0000\u024f\u024d"+
		"\u0001\u0000\u0000\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250=\u0001"+
		"\u0000\u0000\u0000\u0251\u024f\u0001\u0000\u0000\u0000\u0252\u025a\u0003"+
		"2\u0019\u0000\u0253\u025a\u0003@ \u0000\u0254\u025a\u0003T*\u0000\u0255"+
		"\u025a\u0003V+\u0000\u0256\u025a\u0005^\u0000\u0000\u0257\u025a\u0005"+
		"A\u0000\u0000\u0258\u025a\u0005B\u0000\u0000\u0259\u0252\u0001\u0000\u0000"+
		"\u0000\u0259\u0253\u0001\u0000\u0000\u0000\u0259\u0254\u0001\u0000\u0000"+
		"\u0000\u0259\u0255\u0001\u0000\u0000\u0000\u0259\u0256\u0001\u0000\u0000"+
		"\u0000\u0259\u0257\u0001\u0000\u0000\u0000\u0259\u0258\u0001\u0000\u0000"+
		"\u0000\u025a?\u0001\u0000\u0000\u0000\u025b\u025c\u0005J\u0000\u0000\u025c"+
		"\u025d\u0003B!\u0000\u025d\u025e\u0005K\u0000\u0000\u025e\u0268\u0001"+
		"\u0000\u0000\u0000\u025f\u0260\u0005J\u0000\u0000\u0260\u0261\u0003N\'"+
		"\u0000\u0261\u0262\u0005K\u0000\u0000\u0262\u0268\u0001\u0000\u0000\u0000"+
		"\u0263\u0264\u0005J\u0000\u0000\u0264\u0265\u0003P(\u0000\u0265\u0266"+
		"\u0005K\u0000\u0000\u0266\u0268\u0001\u0000\u0000\u0000\u0267\u025b\u0001"+
		"\u0000\u0000\u0000\u0267\u025f\u0001\u0000\u0000\u0000\u0267\u0263\u0001"+
		"\u0000\u0000\u0000\u0268A\u0001\u0000\u0000\u0000\u0269\u026a\u0005\r"+
		"\u0000\u0000\u026a\u026b\u0003\u0096K\u0000\u026b\u026c\u0005]\u0000\u0000"+
		"\u026c\u0275\u0003D\"\u0000\u026d\u026e\u0005\r\u0000\u0000\u026e\u026f"+
		"\u0005 \u0000\u0000\u026f\u0270\u0003\u0096K\u0000\u0270\u0271\u0005]"+
		"\u0000\u0000\u0271\u0272\u0003D\"\u0000\u0272\u0274\u0001\u0000\u0000"+
		"\u0000\u0273\u026d\u0001\u0000\u0000\u0000\u0274\u0277\u0001\u0000\u0000"+
		"\u0000\u0275\u0273\u0001\u0000\u0000\u0000\u0275\u0276\u0001\u0000\u0000"+
		"\u0000\u0276\u027b\u0001\u0000\u0000\u0000\u0277\u0275\u0001\u0000\u0000"+
		"\u0000\u0278\u0279\u0005\u001d\u0000\u0000\u0279\u027a\u0005]\u0000\u0000"+
		"\u027a\u027c\u0003F#\u0000\u027b\u0278\u0001\u0000\u0000\u0000\u027b\u027c"+
		"\u0001\u0000\u0000\u0000\u027cC\u0001\u0000\u0000\u0000\u027d\u027f\u0003"+
		"H$\u0000\u027e\u027d\u0001\u0000\u0000\u0000\u027f\u0282\u0001\u0000\u0000"+
		"\u0000\u0280\u027e\u0001\u0000\u0000\u0000\u0280\u0281\u0001\u0000\u0000"+
		"\u0000\u0281E\u0001\u0000\u0000\u0000\u0282\u0280\u0001\u0000\u0000\u0000"+
		"\u0283\u0285\u0003H$\u0000\u0284\u0283\u0001\u0000\u0000\u0000\u0285\u0288"+
		"\u0001\u0000\u0000\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0286\u0287"+
		"\u0001\u0000\u0000\u0000\u0287G\u0001\u0000\u0000\u0000\u0288\u0286\u0001"+
		"\u0000\u0000\u0000\u0289\u0298\u00032\u0019\u0000\u028a\u028b\u0005J\u0000"+
		"\u0000\u028b\u028c\u0003N\'\u0000\u028c\u028d\u0005K\u0000\u0000\u028d"+
		"\u0298\u0001\u0000\u0000\u0000\u028e\u028f\u0005J\u0000\u0000\u028f\u0290"+
		"\u0003B!\u0000\u0290\u0291\u0005K\u0000\u0000\u0291\u0298\u0001\u0000"+
		"\u0000\u0000\u0292\u0298\u0003T*\u0000\u0293\u0298\u0003J%\u0000\u0294"+
		"\u0298\u0005^\u0000\u0000\u0295\u0298\u0005A\u0000\u0000\u0296\u0298\u0005"+
		"B\u0000\u0000\u0297\u0289\u0001\u0000\u0000\u0000\u0297\u028a\u0001\u0000"+
		"\u0000\u0000\u0297\u028e\u0001\u0000\u0000\u0000\u0297\u0292\u0001\u0000"+
		"\u0000\u0000\u0297\u0293\u0001\u0000\u0000\u0000\u0297\u0294\u0001\u0000"+
		"\u0000\u0000\u0297\u0295\u0001\u0000\u0000\u0000\u0297\u0296\u0001\u0000"+
		"\u0000\u0000\u0298I\u0001\u0000\u0000\u0000\u0299\u029b\u0003L&\u0000"+
		"\u029a\u0299\u0001\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000\u0000"+
		"\u029c\u029a\u0001\u0000\u0000\u0000\u029c\u029d\u0001\u0000\u0000\u0000"+
		"\u029dK\u0001\u0000\u0000\u0000\u029e\u029f\u0007\t\u0000\u0000\u029f"+
		"M\u0001\u0000\u0000\u0000\u02a0\u02a1\u0005\f\u0000\u0000\u02a1\u02a2"+
		"\u0005C\u0000\u0000\u02a2\u02a3\u0005&\u0000\u0000\u02a3\u02a4\u0003\u00aa"+
		"U\u0000\u02a4\u02a5\u0005]\u0000\u0000\u02a5\u02a6\u0003F#\u0000\u02a6"+
		"O\u0001\u0000\u0000\u0000\u02a7\u02a8\u0005\r\u0000\u0000\u02a8\u02a9"+
		"\u0003\u0096K\u0000\u02a9\u02aa\u00057\u0000\u0000\u02aa\u02ab\u0005]"+
		"\u0000\u0000\u02ab\u02ac\u0003F#\u0000\u02acQ\u0001\u0000\u0000\u0000"+
		"\u02ad\u02b4\u0003<\u001e\u0000\u02ae\u02af\u0005^\u0000\u0000\u02af\u02b0"+
		"\u0005A\u0000\u0000\u02b0\u02b1\u0003<\u001e\u0000\u02b1\u02b2\u0005B"+
		"\u0000\u0000\u02b2\u02b4\u0001\u0000\u0000\u0000\u02b3\u02ad\u0001\u0000"+
		"\u0000\u0000\u02b3\u02ae\u0001\u0000\u0000\u0000\u02b4S\u0001\u0000\u0000"+
		"\u0000\u02b5\u02b6\u0005J\u0000\u0000\u02b6\u02b7\u0003\u0096K\u0000\u02b7"+
		"\u02b8\u0005K\u0000\u0000\u02b8U\u0001\u0000\u0000\u0000\u02b9\u02bb\u0003"+
		"X,\u0000\u02ba\u02b9\u0001\u0000\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000"+
		"\u0000\u02bc\u02ba\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000"+
		"\u0000\u02bdW\u0001\u0000\u0000\u0000\u02be\u02bf\u0007\n\u0000\u0000"+
		"\u02bfY\u0001\u0000\u0000\u0000\u02c0\u02c1\u00051\u0000\u0000\u02c1\u02c2"+
		"\u0005C\u0000\u0000\u02c2\u02c3\u0005E\u0000\u0000\u02c3[\u0001\u0000"+
		"\u0000\u0000\u02c4\u02c5\u0005\u0017\u0000\u0000\u02c5\u02c6\u0005C\u0000"+
		"\u0000\u02c6\u02c7\u00053\u0000\u0000\u02c7\u02c8\u00054\u0000\u0000\u02c8"+
		"\u02c9\u0007\u000b\u0000\u0000\u02c9]\u0001\u0000\u0000\u0000\u02ca\u02cb"+
		"\u00052\u0000\u0000\u02cb\u02cc\u0003`0\u0000\u02cc\u02cd\u00053\u0000"+
		"\u0000\u02cd\u02ce\u0005&\u0000\u0000\u02ce\u02cf\u0003b1\u0000\u02cf"+
		"_\u0001\u0000\u0000\u0000\u02d0\u02d5\u0005C\u0000\u0000\u02d1\u02d2\u0005"+
		"[\u0000\u0000\u02d2\u02d4\u0005C\u0000\u0000\u02d3\u02d1\u0001\u0000\u0000"+
		"\u0000\u02d4\u02d7\u0001\u0000\u0000\u0000\u02d5\u02d3\u0001\u0000\u0000"+
		"\u0000\u02d5\u02d6\u0001\u0000\u0000\u0000\u02d6a\u0001\u0000\u0000\u0000"+
		"\u02d7\u02d5\u0001\u0000\u0000\u0000\u02d8\u02d9\u0007\u000b\u0000\u0000"+
		"\u02d9c\u0001\u0000\u0000\u0000\u02da\u02db\u0007\f\u0000\u0000\u02db"+
		"e\u0001\u0000\u0000\u0000\u02dc\u02e1\u0003d2\u0000\u02dd\u02de\u0005"+
		"/\u0000\u0000\u02de\u02e0\u0003d2\u0000\u02df\u02dd\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e3\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000\u0000"+
		"\u0000\u02e1\u02e2\u0001\u0000\u0000\u0000\u02e2\u02e4\u0001\u0000\u0000"+
		"\u0000\u02e3\u02e1\u0001\u0000\u0000\u0000\u02e4\u02e5\u0005/\u0000\u0000"+
		"\u02e5\u02e6\u0003\u00aaU\u0000\u02e6g\u0001\u0000\u0000\u0000\u02e7\u02e8"+
		"\u0005%\u0000\u0000\u02e8\u02e9\u0003f3\u0000\u02e9i\u0001\u0000\u0000"+
		"\u0000\u02ea\u02eb\u0005C\u0000\u0000\u02eb\u02ec\u0005C\u0000\u0000\u02ec"+
		"k\u0001\u0000\u0000\u0000\u02ed\u02ee\u0005C\u0000\u0000\u02ee\u02ef\u0005"+
		"/\u0000\u0000\u02ef\u02f0\u0003j5\u0000\u02f0m\u0001\u0000\u0000\u0000"+
		"\u02f1\u02f2\u0005\r\u0000\u0000\u02f2\u02f3\u0003j5\u0000\u02f3\u02f4"+
		"\u0007\r\u0000\u0000\u02f4\u02f5\u0005]\u0000\u0000\u02f5\u02f6\u0003"+
		"\u0094J\u0000\u02f6o\u0001\u0000\u0000\u0000\u02f7\u02f8\u0007\u000e\u0000"+
		"\u0000\u02f8\u02f9\u0005\'\u0000\u0000\u02f9\u02fa\u0005E\u0000\u0000"+
		"\u02fa\u02fb\u0005,\u0000\u0000\u02fb\u02fc\u0003j5\u0000\u02fcq\u0001"+
		"\u0000\u0000\u0000\u02fd\u02fe\u0005\f\u0000\u0000\u02fe\u02ff\u0005C"+
		"\u0000\u0000\u02ff\u0300\u0005&\u0000\u0000\u0300\u0301\u0003\u00aaU\u0000"+
		"\u0301\u0302\u0005]\u0000\u0000\u0302\u0303\u0003\u0094J\u0000\u0303s"+
		"\u0001\u0000\u0000\u0000\u0304\u0305\u0005\r\u0000\u0000\u0305\u0306\u0003"+
		"\u0096K\u0000\u0306\u0307\u00057\u0000\u0000\u0307\u0308\u0005]\u0000"+
		"\u0000\u0308\u0309\u0003\u0094J\u0000\u0309u\u0001\u0000\u0000\u0000\u030a"+
		"\u030b\u0003\u00aaU\u0000\u030b\u030c\u00057\u0000\u0000\u030c\u030d\u0003"+
		"\u0096K\u0000\u030d\u030e\u00059\u0000\u0000\u030ew\u0001\u0000\u0000"+
		"\u0000\u030f\u0310\u0003\u00aaU\u0000\u0310\u0311\u00058\u0000\u0000\u0311"+
		"\u0312\u0003\u0096K\u0000\u0312\u0313\u00059\u0000\u0000\u0313y\u0001"+
		"\u0000\u0000\u0000\u0314\u0315\u00055\u0000\u0000\u0315{\u0001\u0000\u0000"+
		"\u0000\u0316\u0317\u00056\u0000\u0000\u0317}\u0001\u0000\u0000\u0000\u0318"+
		"\u031c\u0003\u0080@\u0000\u0319\u031b\u0003\u0082A\u0000\u031a\u0319\u0001"+
		"\u0000\u0000\u0000\u031b\u031e\u0001\u0000\u0000\u0000\u031c\u031a\u0001"+
		"\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031d\u007f\u0001"+
		"\u0000\u0000\u0000\u031e\u031c\u0001\u0000\u0000\u0000\u031f\u0323\u0005"+
		"C\u0000\u0000\u0320\u0323\u0003f3\u0000\u0321\u0323\u0003l6\u0000\u0322"+
		"\u031f\u0001\u0000\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0322"+
		"\u0321\u0001\u0000\u0000\u0000\u0323\u0081\u0001\u0000\u0000\u0000\u0324"+
		"\u0325\u0005\\\u0000\u0000\u0325\u032b\u0005C\u0000\u0000\u0326\u0327"+
		"\u0005N\u0000\u0000\u0327\u0328\u0003\u0096K\u0000\u0328\u0329\u0005O"+
		"\u0000\u0000\u0329\u032b\u0001\u0000\u0000\u0000\u032a\u0324\u0001\u0000"+
		"\u0000\u0000\u032a\u0326\u0001\u0000\u0000\u0000\u032b\u0083\u0001\u0000"+
		"\u0000\u0000\u032c\u032d\u0003~?\u0000\u032d\u0331\u0007\u0001\u0000\u0000"+
		"\u032e\u0330\u0005^\u0000\u0000\u032f\u032e\u0001\u0000\u0000\u0000\u0330"+
		"\u0333\u0001\u0000\u0000\u0000\u0331\u032f\u0001\u0000\u0000\u0000\u0331"+
		"\u0332\u0001\u0000\u0000\u0000\u0332\u0334\u0001\u0000\u0000\u0000\u0333"+
		"\u0331\u0001\u0000\u0000\u0000\u0334\u0335\u0003\u0096K\u0000\u0335\u0085"+
		"\u0001\u0000\u0000\u0000\u0336\u0337\u0005!\u0000\u0000\u0337\u033c\u0003"+
		"\u0096K\u0000\u0338\u0339\u0005[\u0000\u0000\u0339\u033b\u0003\u0096K"+
		"\u0000\u033a\u0338\u0001\u0000\u0000\u0000\u033b\u033e\u0001\u0000\u0000"+
		"\u0000\u033c\u033a\u0001\u0000\u0000\u0000\u033c\u033d\u0001\u0000\u0000"+
		"\u0000\u033d\u0087\u0001\u0000\u0000\u0000\u033e\u033c\u0001\u0000\u0000"+
		"\u0000\u033f\u0340\u0005$\u0000\u0000\u0340\u0341\u0003\u0096K\u0000\u0341"+
		"\u0342\u0005&\u0000\u0000\u0342\u0343\u0003\u0096K\u0000\u0343\u0089\u0001"+
		"\u0000\u0000\u0000\u0344\u0345\u0005%\u0000\u0000\u0345\u0346\u0003\u0096"+
		"K\u0000\u0346\u0347\u0005&\u0000\u0000\u0347\u0348\u0005C\u0000\u0000"+
		"\u0348\u008b\u0001\u0000\u0000\u0000\u0349\u034a\u0005\r\u0000\u0000\u034a"+
		"\u034b\u0003\u0096K\u0000\u034b\u034c\u0005]\u0000\u0000\u034c\u035b\u0003"+
		"\u0094J\u0000\u034d\u034f\u0005^\u0000\u0000\u034e\u034d\u0001\u0000\u0000"+
		"\u0000\u034e\u034f\u0001\u0000\u0000\u0000\u034f\u0353\u0001\u0000\u0000"+
		"\u0000\u0350\u0351\u0005\r\u0000\u0000\u0351\u0354\u0005 \u0000\u0000"+
		"\u0352\u0354\u0005\r\u0000\u0000\u0353\u0350\u0001\u0000\u0000\u0000\u0353"+
		"\u0352\u0001\u0000\u0000\u0000\u0354\u0355\u0001\u0000\u0000\u0000\u0355"+
		"\u0356\u0003\u0096K\u0000\u0356\u0357\u0005]\u0000\u0000\u0357\u0358\u0003"+
		"\u0094J\u0000\u0358\u035a\u0001\u0000\u0000\u0000\u0359\u034e\u0001\u0000"+
		"\u0000\u0000\u035a\u035d\u0001\u0000\u0000\u0000\u035b\u0359\u0001\u0000"+
		"\u0000\u0000\u035b\u035c\u0001\u0000\u0000\u0000\u035c\u0364\u0001\u0000"+
		"\u0000\u0000\u035d\u035b\u0001\u0000\u0000\u0000\u035e\u0360\u0005^\u0000"+
		"\u0000\u035f\u035e\u0001\u0000\u0000\u0000\u035f\u0360\u0001\u0000\u0000"+
		"\u0000\u0360\u0361\u0001\u0000\u0000\u0000\u0361\u0362\u0005\u001d\u0000"+
		"\u0000\u0362\u0363\u0005]\u0000\u0000\u0363\u0365\u0003\u0094J\u0000\u0364"+
		"\u035f\u0001\u0000\u0000\u0000\u0364\u0365\u0001\u0000\u0000\u0000\u0365"+
		"\u008d\u0001\u0000\u0000\u0000\u0366\u0367\u0007\u0002\u0000\u0000\u0367"+
		"\u0368\u0005C\u0000\u0000\u0368\u036a\u0005L\u0000\u0000\u0369\u036b\u0003"+
		"\u00bc^\u0000\u036a\u0369\u0001\u0000\u0000\u0000\u036a\u036b\u0001\u0000"+
		"\u0000\u0000\u036b\u036c\u0001\u0000\u0000\u0000\u036c\u036d\u0005M\u0000"+
		"\u0000\u036d\u036e\u0005]\u0000\u0000\u036e\u036f\u0003\u0094J\u0000\u036f"+
		"\u008f\u0001\u0000\u0000\u0000\u0370\u0371\u0007\u0002\u0000\u0000\u0371"+
		"\u0373\u0005L\u0000\u0000\u0372\u0374\u0003\u00bc^\u0000\u0373\u0372\u0001"+
		"\u0000\u0000\u0000\u0373\u0374\u0001\u0000\u0000\u0000\u0374\u0375\u0001"+
		"\u0000\u0000\u0000\u0375\u0376\u0005M\u0000\u0000\u0376\u0377\u0005]\u0000"+
		"\u0000\u0377\u0378\u0003\u0094J\u0000\u0378\u0091\u0001\u0000\u0000\u0000"+
		"\u0379\u037a\u0007\u000f\u0000\u0000\u037a\u037b\u0003\u0096K\u0000\u037b"+
		"\u0093\u0001\u0000\u0000\u0000\u037c\u0387\u0003\b\u0004\u0000\u037d\u037e"+
		"\u0005^\u0000\u0000\u037e\u0380\u0005A\u0000\u0000\u037f\u0381\u0003\u0002"+
		"\u0001\u0000\u0380\u037f\u0001\u0000\u0000\u0000\u0381\u0382\u0001\u0000"+
		"\u0000\u0000\u0382\u0380\u0001\u0000\u0000\u0000\u0382\u0383\u0001\u0000"+
		"\u0000\u0000\u0383\u0384\u0001\u0000\u0000\u0000\u0384\u0385\u0005B\u0000"+
		"\u0000\u0385\u0387\u0001\u0000\u0000\u0000\u0386\u037c\u0001\u0000\u0000"+
		"\u0000\u0386\u037d\u0001\u0000\u0000\u0000\u0387\u0095\u0001\u0000\u0000"+
		"\u0000\u0388\u0389\u0003\u0098L\u0000\u0389\u0097\u0001\u0000\u0000\u0000"+
		"\u038a\u0390\u0003\u009aM\u0000\u038b\u038c\u0005\t\u0000\u0000\u038c"+
		"\u038d\u0003\u0096K\u0000\u038d\u038e\u0005]\u0000\u0000\u038e\u038f\u0003"+
		"\u0096K\u0000\u038f\u0391\u0001\u0000\u0000\u0000\u0390\u038b\u0001\u0000"+
		"\u0000\u0000\u0390\u0391\u0001\u0000\u0000\u0000\u0391\u0099\u0001\u0000"+
		"\u0000\u0000\u0392\u039d\u0003\u009cN\u0000\u0393\u0394\u0005\r\u0000"+
		"\u0000\u0394\u0399\u0005 \u0000\u0000\u0395\u0399\u0005\r\u0000\u0000"+
		"\u0396\u0399\u0005\u001c\u0000\u0000\u0397\u0399\u0005\u000b\u0000\u0000"+
		"\u0398\u0393\u0001\u0000\u0000\u0000\u0398\u0395\u0001\u0000\u0000\u0000"+
		"\u0398\u0396\u0001\u0000\u0000\u0000\u0398\u0397\u0001\u0000\u0000\u0000"+
		"\u0399\u039a\u0001\u0000\u0000\u0000\u039a\u039c\u0003\u009cN\u0000\u039b"+
		"\u0398\u0001\u0000\u0000\u0000\u039c\u039f\u0001\u0000\u0000\u0000\u039d"+
		"\u039b\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e"+
		"\u009b\u0001\u0000\u0000\u0000\u039f\u039d\u0001\u0000\u0000\u0000\u03a0"+
		"\u03a5\u0003\u009eO\u0000\u03a1\u03a2\u0007\u0010\u0000\u0000\u03a2\u03a4"+
		"\u0003\u009eO\u0000\u03a3\u03a1\u0001\u0000\u0000\u0000\u03a4\u03a7\u0001"+
		"\u0000\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a5\u03a6\u0001"+
		"\u0000\u0000\u0000\u03a6\u009d\u0001\u0000\u0000\u0000\u03a7\u03a5\u0001"+
		"\u0000\u0000\u0000\u03a8\u03ad\u0003\u00a0P\u0000\u03a9\u03aa\u0007\u0011"+
		"\u0000\u0000\u03aa\u03ac\u0003\u00a0P\u0000\u03ab\u03a9\u0001\u0000\u0000"+
		"\u0000\u03ac\u03af\u0001\u0000\u0000\u0000\u03ad\u03ab\u0001\u0000\u0000"+
		"\u0000\u03ad\u03ae\u0001\u0000\u0000\u0000\u03ae\u009f\u0001\u0000\u0000"+
		"\u0000\u03af\u03ad\u0001\u0000\u0000\u0000\u03b0\u03b5\u0003\u00a2Q\u0000"+
		"\u03b1\u03b2\u0007\u0012\u0000\u0000\u03b2\u03b4\u0003\u00a2Q\u0000\u03b3"+
		"\u03b1\u0001\u0000\u0000\u0000\u03b4\u03b7\u0001\u0000\u0000\u0000\u03b5"+
		"\u03b3\u0001\u0000\u0000\u0000\u03b5\u03b6\u0001\u0000\u0000\u0000\u03b6"+
		"\u00a1\u0001\u0000\u0000\u0000\u03b7\u03b5\u0001\u0000\u0000\u0000\u03b8"+
		"\u03bd\u0003\u00a4R\u0000\u03b9\u03ba\u0007\u0013\u0000\u0000\u03ba\u03bc"+
		"\u0003\u00a4R\u0000\u03bb\u03b9\u0001\u0000\u0000\u0000\u03bc\u03bf\u0001"+
		"\u0000\u0000\u0000\u03bd\u03bb\u0001\u0000\u0000\u0000\u03bd\u03be\u0001"+
		"\u0000\u0000\u0000\u03be\u00a3\u0001\u0000\u0000\u0000\u03bf\u03bd\u0001"+
		"\u0000\u0000\u0000\u03c0\u03c5\u0003\u00a6S\u0000\u03c1\u03c2\u0007\u0014"+
		"\u0000\u0000\u03c2\u03c4\u0003\u00a6S\u0000\u03c3\u03c1\u0001\u0000\u0000"+
		"\u0000\u03c4\u03c7\u0001\u0000\u0000\u0000\u03c5\u03c3\u0001\u0000\u0000"+
		"\u0000\u03c5\u03c6\u0001\u0000\u0000\u0000\u03c6\u00a5\u0001\u0000\u0000"+
		"\u0000\u03c7\u03c5\u0001\u0000\u0000\u0000\u03c8\u03cb\u0003\u00a8T\u0000"+
		"\u03c9\u03ca\u0005U\u0000\u0000\u03ca\u03cc\u0003\u00a6S\u0000\u03cb\u03c9"+
		"\u0001\u0000\u0000\u0000\u03cb\u03cc\u0001\u0000\u0000\u0000\u03cc\u00a7"+
		"\u0001\u0000\u0000\u0000\u03cd\u03ce\u0007\u0015\u0000\u0000\u03ce\u03d1"+
		"\u0003\u00a8T\u0000\u03cf\u03d1\u0003\u00aaU\u0000\u03d0\u03cd\u0001\u0000"+
		"\u0000\u0000\u03d0\u03cf\u0001\u0000\u0000\u0000\u03d1\u00a9\u0001\u0000"+
		"\u0000\u0000\u03d2\u03d3\u0006U\uffff\uffff\u0000\u03d3\u0436\u0003l6"+
		"\u0000\u03d4\u0436\u0003f3\u0000\u03d5\u03d6\u0005C\u0000\u0000\u03d6"+
		"\u03d7\u0005/\u0000\u0000\u03d7\u03da\u0005C\u0000\u0000\u03d8\u03d9\u0005"+
		"/\u0000\u0000\u03d9\u03db\u0005C\u0000\u0000\u03da\u03d8\u0001\u0000\u0000"+
		"\u0000\u03db\u03dc\u0001\u0000\u0000\u0000\u03dc\u03da\u0001\u0000\u0000"+
		"\u0000\u03dc\u03dd\u0001\u0000\u0000\u0000\u03dd\u0436\u0001\u0000\u0000"+
		"\u0000\u03de\u03df\u0005\u001f\u0000\u0000\u03df\u03e0\u0005/\u0000\u0000"+
		"\u03e0\u03e5\u0005C\u0000\u0000\u03e1\u03e2\u0005/\u0000\u0000\u03e2\u03e4"+
		"\u0005C\u0000\u0000\u03e3\u03e1\u0001\u0000\u0000\u0000\u03e4\u03e7\u0001"+
		"\u0000\u0000\u0000\u03e5\u03e3\u0001\u0000\u0000\u0000\u03e5\u03e6\u0001"+
		"\u0000\u0000\u0000\u03e6\u03e8\u0001\u0000\u0000\u0000\u03e7\u03e5\u0001"+
		"\u0000\u0000\u0000\u03e8\u03e9\u0005C\u0000\u0000\u03e9\u03eb\u0005L\u0000"+
		"\u0000\u03ea\u03ec\u0003\u00ba]\u0000\u03eb\u03ea\u0001\u0000\u0000\u0000"+
		"\u03eb\u03ec\u0001\u0000\u0000\u0000\u03ec\u03ed\u0001\u0000\u0000\u0000"+
		"\u03ed\u0436\u0005M\u0000\u0000\u03ee\u03ef\u0005C\u0000\u0000\u03ef\u03f1"+
		"\u0005L\u0000\u0000\u03f0\u03f2\u0003\u00ba]\u0000\u03f1\u03f0\u0001\u0000"+
		"\u0000\u0000\u03f1\u03f2\u0001\u0000\u0000\u0000\u03f2\u03f3\u0001\u0000"+
		"\u0000\u0000\u03f3\u0436\u0005M\u0000\u0000\u03f4\u03f5\u0007\u0002\u0000"+
		"\u0000\u03f5\u03f7\u0005L\u0000\u0000\u03f6\u03f8\u0003\u00bc^\u0000\u03f7"+
		"\u03f6\u0001\u0000\u0000\u0000\u03f7\u03f8\u0001\u0000\u0000\u0000\u03f8"+
		"\u03f9\u0001\u0000\u0000\u0000\u03f9\u03fa\u0005M\u0000\u0000\u03fa\u03fb"+
		"\u0005]\u0000\u0000\u03fb\u0436\u0003\u0094J\u0000\u03fc\u0400\u0005N"+
		"\u0000\u0000\u03fd\u03ff\u0005^\u0000\u0000\u03fe\u03fd\u0001\u0000\u0000"+
		"\u0000\u03ff\u0402\u0001\u0000\u0000\u0000\u0400\u03fe\u0001\u0000\u0000"+
		"\u0000\u0400\u0401\u0001\u0000\u0000\u0000\u0401\u0404\u0001\u0000\u0000"+
		"\u0000\u0402\u0400\u0001\u0000\u0000\u0000\u0403\u0405\u0003\u00b6[\u0000"+
		"\u0404\u0403\u0001\u0000\u0000\u0000\u0404\u0405\u0001\u0000\u0000\u0000"+
		"\u0405\u0409\u0001\u0000\u0000\u0000\u0406\u0408\u0005^\u0000\u0000\u0407"+
		"\u0406\u0001\u0000\u0000\u0000\u0408\u040b\u0001\u0000\u0000\u0000\u0409"+
		"\u0407\u0001\u0000\u0000\u0000\u0409\u040a\u0001\u0000\u0000\u0000\u040a"+
		"\u040c\u0001\u0000\u0000\u0000\u040b\u0409\u0001\u0000\u0000\u0000\u040c"+
		"\u0436\u0005O\u0000\u0000\u040d\u040e\u0005N\u0000\u0000\u040e\u040f\u0003"+
		"\u00b4Z\u0000\u040f\u0410\u0005O\u0000\u0000\u0410\u0436\u0001\u0000\u0000"+
		"\u0000\u0411\u0412\u0005-\u0000\u0000\u0412\u0436\u0003\u00aaU\u001c\u0413"+
		"\u0414\u0005.\u0000\u0000\u0414\u0436\u0003\u00aaU\u001b\u0415\u0416\u0005"+
		",\u0000\u0000\u0416\u0417\u0003\u0096K\u0000\u0417\u0418\u0005&\u0000"+
		"\u0000\u0418\u0419\u0007\u000b\u0000\u0000\u0419\u0436\u0001\u0000\u0000"+
		"\u0000\u041a\u041c\u0005N\u0000\u0000\u041b\u041d\u0003\u00b6[\u0000\u041c"+
		"\u041b\u0001\u0000\u0000\u0000\u041c\u041d\u0001\u0000\u0000\u0000\u041d"+
		"\u041e\u0001\u0000\u0000\u0000\u041e\u041f\u0005O\u0000\u0000\u041f\u0436"+
		"\u0005\u0014\u0000\u0000\u0420\u0421\u0005C\u0000\u0000\u0421\u0436\u0005"+
		"\u0014\u0000\u0000\u0422\u0423\u00051\u0000\u0000\u0423\u0436\u0005E\u0000"+
		"\u0000\u0424\u0425\u0005\u0017\u0000\u0000\u0425\u0426\u0005C\u0000\u0000"+
		"\u0426\u0427\u00053\u0000\u0000\u0427\u0428\u00054\u0000\u0000\u0428\u0436"+
		"\u0007\u000b\u0000\u0000\u0429\u0436\u0005D\u0000\u0000\u042a\u0436\u0005"+
		"\u0019\u0000\u0000\u042b\u0436\u0005E\u0000\u0000\u042c\u0436\u0005C\u0000"+
		"\u0000\u042d\u0436\u0005\u000f\u0000\u0000\u042e\u042f\u0005L\u0000\u0000"+
		"\u042f\u0430\u0003\u0096K\u0000\u0430\u0431\u0005M\u0000\u0000\u0431\u0436"+
		"\u0001\u0000\u0000\u0000\u0432\u0436\u0003\u00acV\u0000\u0433\u0436\u0003"+
		"\u00aeW\u0000\u0434\u0436\u00032\u0019\u0000\u0435\u03d2\u0001\u0000\u0000"+
		"\u0000\u0435\u03d4\u0001\u0000\u0000\u0000\u0435\u03d5\u0001\u0000\u0000"+
		"\u0000\u0435\u03de\u0001\u0000\u0000\u0000\u0435\u03ee\u0001\u0000\u0000"+
		"\u0000\u0435\u03f4\u0001\u0000\u0000\u0000\u0435\u03fc\u0001\u0000\u0000"+
		"\u0000\u0435\u040d\u0001\u0000\u0000\u0000\u0435\u0411\u0001\u0000\u0000"+
		"\u0000\u0435\u0413\u0001\u0000\u0000\u0000\u0435\u0415\u0001\u0000\u0000"+
		"\u0000\u0435\u041a\u0001\u0000\u0000\u0000\u0435\u0420\u0001\u0000\u0000"+
		"\u0000\u0435\u0422\u0001\u0000\u0000\u0000\u0435\u0424\u0001\u0000\u0000"+
		"\u0000\u0435\u0429\u0001\u0000\u0000\u0000\u0435\u042a\u0001\u0000\u0000"+
		"\u0000\u0435\u042b\u0001\u0000\u0000\u0000\u0435\u042c\u0001\u0000\u0000"+
		"\u0000\u0435\u042d\u0001\u0000\u0000\u0000\u0435\u042e\u0001\u0000\u0000"+
		"\u0000\u0435\u0432\u0001\u0000\u0000\u0000\u0435\u0433\u0001\u0000\u0000"+
		"\u0000\u0435\u0434\u0001\u0000\u0000\u0000\u0436\u0463\u0001\u0000\u0000"+
		"\u0000\u0437\u0438\n\t\u0000\u0000\u0438\u0439\u0005(\u0000\u0000\u0439"+
		"\u0462\u0003\u00aaU\n\u043a\u043b\n\b\u0000\u0000\u043b\u043c\u0005)\u0000"+
		"\u0000\u043c\u0462\u0003\u00aaU\t\u043d\u043e\n\u0017\u0000\u0000\u043e"+
		"\u0462\u0005\u0014\u0000\u0000\u043f\u0440\n\u0015\u0000\u0000\u0440\u0441"+
		"\u00057\u0000\u0000\u0441\u0442\u0003\u0096K\u0000\u0442\u0443\u00059"+
		"\u0000\u0000\u0443\u0462\u0001\u0000\u0000\u0000\u0444\u0445\n\u0014\u0000"+
		"\u0000\u0445\u0446\u00058\u0000\u0000\u0446\u0447\u0003\u0096K\u0000\u0447"+
		"\u0448\u00059\u0000\u0000\u0448\u0462\u0001\u0000\u0000\u0000\u0449\u044a"+
		"\n\f\u0000\u0000\u044a\u044b\u0005(\u0000\u0000\u044b\u044c\u0005&\u0000"+
		"\u0000\u044c\u0462\u0003\u0096K\u0000\u044d\u044e\n\u000b\u0000\u0000"+
		"\u044e\u044f\u0005(\u0000\u0000\u044f\u0450\u0005&\u0000\u0000\u0450\u0462"+
		"\u0005E\u0000\u0000\u0451\u0452\n\n\u0000\u0000\u0452\u0453\u0005>\u0000"+
		"\u0000\u0453\u0454\u0005?\u0000\u0000\u0454\u0462\u0003\u0096K\u0000\u0455"+
		"\u0456\n\u0007\u0000\u0000\u0456\u0462\u0005*\u0000\u0000\u0457\u0458"+
		"\n\u0006\u0000\u0000\u0458\u0462\u0005+\u0000\u0000\u0459\u045a\n\u0003"+
		"\u0000\u0000\u045a\u045b\u0005\\\u0000\u0000\u045b\u0462\u0005C\u0000"+
		"\u0000\u045c\u045d\n\u0002\u0000\u0000\u045d\u045e\u0005N\u0000\u0000"+
		"\u045e\u045f\u0003\u0096K\u0000\u045f\u0460\u0005O\u0000\u0000\u0460\u0462"+
		"\u0001\u0000\u0000\u0000\u0461\u0437\u0001\u0000\u0000\u0000\u0461\u043a"+
		"\u0001\u0000\u0000\u0000\u0461\u043d\u0001\u0000\u0000\u0000\u0461\u043f"+
		"\u0001\u0000\u0000\u0000\u0461\u0444\u0001\u0000\u0000\u0000\u0461\u0449"+
		"\u0001\u0000\u0000\u0000\u0461\u044d\u0001\u0000\u0000\u0000\u0461\u0451"+
		"\u0001\u0000\u0000\u0000\u0461\u0455\u0001\u0000\u0000\u0000\u0461\u0457"+
		"\u0001\u0000\u0000\u0000\u0461\u0459\u0001\u0000\u0000\u0000\u0461\u045c"+
		"\u0001\u0000\u0000\u0000\u0462\u0465\u0001\u0000\u0000\u0000\u0463\u0461"+
		"\u0001\u0000\u0000\u0000\u0463\u0464\u0001\u0000\u0000\u0000\u0464\u00ab"+
		"\u0001\u0000\u0000\u0000\u0465\u0463\u0001\u0000\u0000\u0000\u0466\u0467"+
		"\u0007\u0000\u0000\u0000\u0467\u0468\u0005]\u0000\u0000\u0468\u046a\u0003"+
		"\u0014\n\u0000\u0469\u046b\u0005\u0001\u0000\u0000\u046a\u0469\u0001\u0000"+
		"\u0000\u0000\u046a\u046b\u0001\u0000\u0000\u0000\u046b\u00ad\u0001\u0000"+
		"\u0000\u0000\u046c\u0470\u0005J\u0000\u0000\u046d\u046f\u0005^\u0000\u0000"+
		"\u046e\u046d\u0001\u0000\u0000\u0000\u046f\u0472\u0001\u0000\u0000\u0000"+
		"\u0470\u046e\u0001\u0000\u0000\u0000\u0470\u0471\u0001\u0000\u0000\u0000"+
		"\u0471\u0474\u0001\u0000\u0000\u0000\u0472\u0470\u0001\u0000\u0000\u0000"+
		"\u0473\u0475\u0003\u00b0X\u0000\u0474\u0473\u0001\u0000\u0000\u0000\u0474"+
		"\u0475\u0001\u0000\u0000\u0000\u0475\u0479\u0001\u0000\u0000\u0000\u0476"+
		"\u0478\u0005^\u0000\u0000\u0477\u0476\u0001\u0000\u0000\u0000\u0478\u047b"+
		"\u0001\u0000\u0000\u0000\u0479\u0477\u0001\u0000\u0000\u0000\u0479\u047a"+
		"\u0001\u0000\u0000\u0000\u047a\u047c\u0001\u0000\u0000\u0000\u047b\u0479"+
		"\u0001\u0000\u0000\u0000\u047c\u047d\u0005K\u0000\u0000\u047d\u00af\u0001"+
		"\u0000\u0000\u0000\u047e\u0490\u0003\u00b2Y\u0000\u047f\u0483\u0005[\u0000"+
		"\u0000\u0480\u0482\u0005^\u0000\u0000\u0481\u0480\u0001\u0000\u0000\u0000"+
		"\u0482\u0485\u0001\u0000\u0000\u0000\u0483\u0481\u0001\u0000\u0000\u0000"+
		"\u0483\u0484\u0001\u0000\u0000\u0000\u0484\u048c\u0001\u0000\u0000\u0000"+
		"\u0485\u0483\u0001\u0000\u0000\u0000\u0486\u0488\u0005^\u0000\u0000\u0487"+
		"\u0486\u0001\u0000\u0000\u0000\u0488\u0489\u0001\u0000\u0000\u0000\u0489"+
		"\u0487\u0001\u0000\u0000\u0000\u0489\u048a\u0001\u0000\u0000\u0000\u048a"+
		"\u048c\u0001\u0000\u0000\u0000\u048b\u047f\u0001\u0000\u0000\u0000\u048b"+
		"\u0487\u0001\u0000\u0000\u0000\u048c\u048d\u0001\u0000\u0000\u0000\u048d"+
		"\u048f\u0003\u00b2Y\u0000\u048e\u048b\u0001\u0000\u0000\u0000\u048f\u0492"+
		"\u0001\u0000\u0000\u0000\u0490\u048e\u0001\u0000\u0000\u0000\u0490\u0491"+
		"\u0001\u0000\u0000\u0000\u0491\u0494\u0001\u0000\u0000\u0000\u0492\u0490"+
		"\u0001\u0000\u0000\u0000\u0493\u0495\u0005[\u0000\u0000\u0494\u0493\u0001"+
		"\u0000\u0000\u0000\u0494\u0495\u0001\u0000\u0000\u0000\u0495\u0499\u0001"+
		"\u0000\u0000\u0000\u0496\u0498\u0005^\u0000\u0000\u0497\u0496\u0001\u0000"+
		"\u0000\u0000\u0498\u049b\u0001\u0000\u0000\u0000\u0499\u0497\u0001\u0000"+
		"\u0000\u0000\u0499\u049a\u0001\u0000\u0000\u0000\u049a\u00b1\u0001\u0000"+
		"\u0000\u0000\u049b\u0499\u0001\u0000\u0000\u0000\u049c\u049d\u0007\u000b"+
		"\u0000\u0000\u049d\u049e\u0005]\u0000\u0000\u049e\u049f\u0003\u0096K\u0000"+
		"\u049f\u00b3\u0001\u0000\u0000\u0000\u04a0\u04a1\u0003\u0096K\u0000\u04a1"+
		"\u04a2\u0005[\u0000\u0000\u04a2\u04a3\u0003\u0096K\u0000\u04a3\u04a4\u0005"+
		"[\u0000\u0000\u04a4\u04a5\u0005@\u0000\u0000\u04a5\u04a6\u0003\u0096K"+
		"\u0000\u04a6\u04ad\u0001\u0000\u0000\u0000\u04a7\u04a8\u0003\u0096K\u0000"+
		"\u04a8\u04a9\u0005[\u0000\u0000\u04a9\u04aa\u0005@\u0000\u0000\u04aa\u04ab"+
		"\u0003\u0096K\u0000\u04ab\u04ad\u0001\u0000\u0000\u0000\u04ac\u04a0\u0001"+
		"\u0000\u0000\u0000\u04ac\u04a7\u0001\u0000\u0000\u0000\u04ad\u00b5\u0001"+
		"\u0000\u0000\u0000\u04ae\u04b0\u0005^\u0000\u0000\u04af\u04ae\u0001\u0000"+
		"\u0000\u0000\u04b0\u04b3\u0001\u0000\u0000\u0000\u04b1\u04af\u0001\u0000"+
		"\u0000\u0000\u04b1\u04b2\u0001\u0000\u0000\u0000\u04b2\u04b4\u0001\u0000"+
		"\u0000\u0000\u04b3\u04b1\u0001\u0000\u0000\u0000\u04b4\u04c6\u0003\u00b8"+
		"\\\u0000\u04b5\u04b9\u0005[\u0000\u0000\u04b6\u04b8\u0005^\u0000\u0000"+
		"\u04b7\u04b6\u0001\u0000\u0000\u0000\u04b8\u04bb\u0001\u0000\u0000\u0000"+
		"\u04b9\u04b7\u0001\u0000\u0000\u0000\u04b9\u04ba\u0001\u0000\u0000\u0000"+
		"\u04ba\u04c2\u0001\u0000\u0000\u0000\u04bb\u04b9\u0001\u0000\u0000\u0000"+
		"\u04bc\u04be\u0005^\u0000\u0000\u04bd\u04bc\u0001\u0000\u0000\u0000\u04be"+
		"\u04bf\u0001\u0000\u0000\u0000\u04bf\u04bd\u0001\u0000\u0000\u0000\u04bf"+
		"\u04c0\u0001\u0000\u0000\u0000\u04c0\u04c2\u0001\u0000\u0000\u0000\u04c1"+
		"\u04b5\u0001\u0000\u0000\u0000\u04c1\u04bd\u0001\u0000\u0000\u0000\u04c2"+
		"\u04c3\u0001\u0000\u0000\u0000\u04c3\u04c5\u0003\u00b8\\\u0000\u04c4\u04c1"+
		"\u0001\u0000\u0000\u0000\u04c5\u04c8\u0001\u0000\u0000\u0000\u04c6\u04c4"+
		"\u0001\u0000\u0000\u0000\u04c6\u04c7\u0001\u0000\u0000\u0000\u04c7\u04ca"+
		"\u0001\u0000\u0000\u0000\u04c8\u04c6\u0001\u0000\u0000\u0000\u04c9\u04cb"+
		"\u0005[\u0000\u0000\u04ca\u04c9\u0001\u0000\u0000\u0000\u04ca\u04cb\u0001"+
		"\u0000\u0000\u0000\u04cb\u04cf\u0001\u0000\u0000\u0000\u04cc\u04ce\u0005"+
		"^\u0000\u0000\u04cd\u04cc\u0001\u0000\u0000\u0000\u04ce\u04d1\u0001\u0000"+
		"\u0000\u0000\u04cf\u04cd\u0001\u0000\u0000\u0000\u04cf\u04d0\u0001\u0000"+
		"\u0000\u0000\u04d0\u00b7\u0001\u0000\u0000\u0000\u04d1\u04cf\u0001\u0000"+
		"\u0000\u0000\u04d2\u04d5\u0003\u00acV\u0000\u04d3\u04d5\u0003\u0096K\u0000"+
		"\u04d4\u04d2\u0001\u0000\u0000\u0000\u04d4\u04d3\u0001\u0000\u0000\u0000"+
		"\u04d5\u00b9\u0001\u0000\u0000\u0000\u04d6\u04db\u0003\u0096K\u0000\u04d7"+
		"\u04d8\u0005[\u0000\u0000\u04d8\u04da\u0003\u0096K\u0000\u04d9\u04d7\u0001"+
		"\u0000\u0000\u0000\u04da\u04dd\u0001\u0000\u0000\u0000\u04db\u04d9\u0001"+
		"\u0000\u0000\u0000\u04db\u04dc\u0001\u0000\u0000\u0000\u04dc\u00bb\u0001"+
		"\u0000\u0000\u0000\u04dd\u04db\u0001\u0000\u0000\u0000\u04de\u04e3\u0005"+
		"C\u0000\u0000\u04df\u04e0\u0005[\u0000\u0000\u04e0\u04e2\u0005C\u0000"+
		"\u0000\u04e1\u04df\u0001\u0000\u0000\u0000\u04e2\u04e5\u0001\u0000\u0000"+
		"\u0000\u04e3\u04e1\u0001\u0000\u0000\u0000\u04e3\u04e4\u0001\u0000\u0000"+
		"\u0000\u04e4\u00bd\u0001\u0000\u0000\u0000\u04e5\u04e3\u0001\u0000\u0000"+
		"\u0000q\u00c1\u00c9\u00cf\u00d3\u00ee\u00fb\u0109\u0111\u0118\u011f\u012d"+
		"\u0132\u0138\u013e\u0144\u014a\u0150\u0156\u015c\u0173\u0176\u017b\u0180"+
		"\u0188\u0190\u01a2\u01af\u01c3\u01e6\u01f3\u01fb\u0205\u0207\u0213\u021b"+
		"\u021d\u0225\u022d\u022f\u0236\u0239\u0241\u0244\u024f\u0259\u0267\u0275"+
		"\u027b\u0280\u0286\u0297\u029c\u02b3\u02bc\u02d5\u02e1\u031c\u0322\u032a"+
		"\u0331\u033c\u034e\u0353\u035b\u035f\u0364\u036a\u0373\u0382\u0386\u0390"+
		"\u0398\u039d\u03a5\u03ad\u03b5\u03bd\u03c5\u03cb\u03d0\u03dc\u03e5\u03eb"+
		"\u03f1\u03f7\u0400\u0404\u0409\u041c\u0435\u0461\u0463\u046a\u0470\u0474"+
		"\u0479\u0483\u0489\u048b\u0490\u0494\u0499\u04ac\u04b1\u04b9\u04bf\u04c1"+
		"\u04c6\u04ca\u04cf\u04d4\u04db\u04e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}