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
		RULE_importStatement = 46, RULE_fetchStatement = 47, RULE_propName = 48, 
		RULE_propertyRef = 49, RULE_propertyDelete = 50, RULE_domSelector = 51, 
		RULE_domPropertyRef = 52, RULE_eventListenerStatement = 53, RULE_classStatement = 54, 
		RULE_loopStatement = 55, RULE_whileStatement = 56, RULE_intervalStatement = 57, 
		RULE_timeoutStatement = 58, RULE_continueStatement = 59, RULE_breakStatement = 60, 
		RULE_assignable = 61, RULE_assignRoot = 62, RULE_memberAccess = 63, RULE_assignment = 64, 
		RULE_nyoraStatement = 65, RULE_arrayAdd = 66, RULE_arrayRemove = 67, RULE_conditionalStatement = 68, 
		RULE_functionDefinition = 69, RULE_anonymousFunction = 70, RULE_returnStatement = 71, 
		RULE_suite = 72, RULE_expression = 73, RULE_conditionalExpression = 74, 
		RULE_logicalOrExpression = 75, RULE_logicalAndExpression = 76, RULE_equalityExpression = 77, 
		RULE_comparisonExpression = 78, RULE_additiveExpression = 79, RULE_multiplicativeExpression = 80, 
		RULE_powerExpression = 81, RULE_unaryExpression = 82, RULE_primaryExpression = 83, 
		RULE_objectLiteral = 84, RULE_jsObjectLiteral = 85, RULE_jsObjectEntries = 86, 
		RULE_jsObjectEntry = 87, RULE_rangeExpression = 88, RULE_arrayElements = 89, 
		RULE_arrayElement = 90, RULE_argumentList = 91, RULE_parameterList = 92;
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
			"htmlTextContent", "inputStatement", "importStatement", "fetchStatement", 
			"propName", "propertyRef", "propertyDelete", "domSelector", "domPropertyRef", 
			"eventListenerStatement", "classStatement", "loopStatement", "whileStatement", 
			"intervalStatement", "timeoutStatement", "continueStatement", "breakStatement", 
			"assignable", "assignRoot", "memberAccess", "assignment", "nyoraStatement", 
			"arrayAdd", "arrayRemove", "conditionalStatement", "functionDefinition", 
			"anonymousFunction", "returnStatement", "suite", "expression", "conditionalExpression", 
			"logicalOrExpression", "logicalAndExpression", "equalityExpression", 
			"comparisonExpression", "additiveExpression", "multiplicativeExpression", 
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29115337472012288L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0)) {
				{
				{
				setState(186);
				programElement();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
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
	}

	public final ProgramElementContext programElement() throws RecognitionException {
		ProgramElementContext _localctx = new ProgramElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programElement);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				line();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
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
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);
		try {
			setState(203);
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
				setState(199);
				statement();
				setState(200);
				match(NEWLINE);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				simpleStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
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
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_simpleStatement);
		try {
			setState(234);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				anonymousFunctionAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				incrementStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				decrementStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(213);
				compoundAssignment();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(214);
				nyoraStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(215);
				propertyDelete();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(216);
				returnStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(217);
				arrayAdd();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(218);
				arrayRemove();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(219);
				setDeclaration();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(220);
				sortStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(221);
				filterStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(222);
				classStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(223);
				continueStatement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(224);
				breakStatement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(225);
				expression();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(226);
				inputStatement();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(227);
				importStatement();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(228);
				intervalStatement();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(229);
				timeoutStatement();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(230);
				fetchStatement();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(231);
				linearObjectDefinition();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(232);
				propsDeclaration();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(233);
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
	}

	public final ReactiveOneLinerContext reactiveOneLiner() throws RecognitionException {
		ReactiveOneLinerContext _localctx = new ReactiveOneLinerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_reactiveOneLiner);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(TARISA);
			setState(237);
			match(COLON);
			setState(238);
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
	}

	public final ReactiveBlockContext reactiveBlock() throws RecognitionException {
		ReactiveBlockContext _localctx = new ReactiveBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_reactiveBlock);
		int _la;
		try {
			_localctx = new ReactiveBlockStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(TARISA);
			setState(241);
			match(COLON);
			setState(242);
			match(NEWLINE);
			setState(243);
			match(INDENT);
			setState(245); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(244);
				programElement();
				}
				}
				setState(247); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 29115337472012288L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0) );
			setState(249);
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
	}

	public final LinearObjectDefinitionContext linearObjectDefinition() throws RecognitionException {
		LinearObjectDefinitionContext _localctx = new LinearObjectDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_linearObjectDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(ID);
			setState(252);
			_la = _input.LA(1);
			if ( !(_la==PANE || _la==HAS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(253);
			match(COLON);
			setState(254);
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
	}

	public final AnonymousFunctionAssignmentContext anonymousFunctionAssignment() throws RecognitionException {
		AnonymousFunctionAssignmentContext _localctx = new AnonymousFunctionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_anonymousFunctionAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			assignable();
			setState(257);
			_la = _input.LA(1);
			if ( !(_la==NDI || _la==EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(258);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION || _la==BASA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(259);
			match(LPAREN);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(260);
				parameterList();
				}
			}

			setState(263);
			match(RPAREN);
			setState(264);
			match(COLON);
			setState(265);
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
	}

	public final LinearObjectBodyContext linearObjectBody() throws RecognitionException {
		LinearObjectBodyContext _localctx = new LinearObjectBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_linearObjectBody);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
			case BASA:
			case ID:
				_localctx = new InlineObjectBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				linearObjectEntries();
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(268);
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
				setState(271);
				match(NEWLINE);
				setState(272);
				match(INDENT);
				setState(273);
				objectEntries();
				setState(274);
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
	}

	public final LinearObjectEntriesContext linearObjectEntries() throws RecognitionException {
		LinearObjectEntriesContext _localctx = new LinearObjectEntriesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_linearObjectEntries);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			linearObjectEntry();
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(279);
					match(COMMA);
					setState(280);
					linearObjectEntry();
					}
					} 
				}
				setState(285);
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
	}

	public final LinearObjectEntryContext linearObjectEntry() throws RecognitionException {
		LinearObjectEntryContext _localctx = new LinearObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_linearObjectEntry);
		int _la;
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(ID);
				setState(287);
				match(EQ);
				setState(288);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(ID);
				setState(290);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(291);
				match(COLON);
				setState(292);
				linearObjectBody();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(293);
				_la = _input.LA(1);
				if ( !(_la==FUNCTION || _la==BASA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(294);
				match(ID);
				setState(295);
				match(LPAREN);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(296);
					parameterList();
					}
				}

				setState(299);
				match(RPAREN);
				setState(300);
				match(COLON);
				setState(301);
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
	}

	public final ObjectEntriesContext objectEntries() throws RecognitionException {
		ObjectEntriesContext _localctx = new ObjectEntriesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_objectEntries);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			objectEntry();
			setState(326);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(308);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(305);
							match(NEWLINE);
							}
							} 
						}
						setState(310);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0 || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 67108867L) != 0)) {
						{
						{
						setState(311);
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
						setState(316);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(317);
						match(NEWLINE);
						}
						}
						setState(322);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(323);
					objectEntry();
					}
					} 
				}
				setState(328);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(332);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(329);
					match(NEWLINE);
					}
					} 
				}
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(335);
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
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(341);
				match(NEWLINE);
				}
				}
				setState(346);
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjValueContext extends ObjectEntryContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode EQ() { return getToken(ShonascriptxParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjValueContext(ObjectEntryContext ctx) { copyFrom(ctx); }
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
	}

	public final ObjectEntryContext objectEntry() throws RecognitionException {
		ObjectEntryContext _localctx = new ObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_objectEntry);
		int _la;
		try {
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ObjValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				match(ID);
				setState(348);
				match(EQ);
				setState(349);
				expression();
				}
				break;
			case 2:
				_localctx = new NestedObjContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(ID);
				setState(351);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(352);
				match(COLON);
				setState(353);
				match(NEWLINE);
				setState(354);
				match(INDENT);
				setState(355);
				objectEntries();
				setState(356);
				match(DEDENT);
				}
				break;
			case 3:
				_localctx = new EmptyNestedObjContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(358);
				match(ID);
				setState(359);
				_la = _input.LA(1);
				if ( !(_la==PANE || _la==HAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(360);
				match(COLON);
				setState(361);
				match(T__0);
				}
				break;
			case 4:
				_localctx = new InlineNestedObjContext(_localctx);
				enterOuterAlt(_localctx, 4);
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
				linearObjectEntries();
				setState(367);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(366);
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
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FUNCTION || _la==BASA) {
					{
					setState(369);
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

				setState(372);
				match(ID);
				setState(373);
				match(LPAREN);
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(374);
					parameterList();
					}
				}

				setState(377);
				match(RPAREN);
				setState(378);
				match(COLON);
				setState(379);
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
	}

	public final PropsDeclarationContext propsDeclaration() throws RecognitionException {
		PropsDeclarationContext _localctx = new PropsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propsDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(PROPS_KW);
			setState(383);
			match(ID);
			setState(388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(384);
					match(COMMA);
					setState(385);
					match(ID);
					}
					} 
				}
				setState(390);
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
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compoundStatement);
		try {
			setState(396);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(392);
				eventListenerStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				conditionalStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(394);
				loopStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(395);
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
	}

	public final IncrementStatementContext incrementStatement() throws RecognitionException {
		IncrementStatementContext _localctx = new IncrementStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_incrementStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			assignable();
			setState(399);
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
	}

	public final DecrementStatementContext decrementStatement() throws RecognitionException {
		DecrementStatementContext _localctx = new DecrementStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_decrementStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			assignable();
			setState(402);
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
	}

	public final CompoundAssignmentContext compoundAssignment() throws RecognitionException {
		CompoundAssignmentContext _localctx = new CompoundAssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_compoundAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			assignable();
			setState(405);
			compoundOp();
			setState(406);
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
	}

	public final CompoundOpContext compoundOp() throws RecognitionException {
		CompoundOpContext _localctx = new CompoundOpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_compoundOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
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
	}

	public final SetDeclarationContext setDeclaration() throws RecognitionException {
		SetDeclarationContext _localctx = new SetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_setDeclaration);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new NewSetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				match(ID);
				setState(411);
				match(EQ);
				setState(412);
				match(LBRACKET);
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0)) {
					{
					setState(413);
					arrayElements();
					}
				}

				setState(416);
				match(RBRACKET);
				setState(417);
				match(VAKASIYANA);
				}
				break;
			case 2:
				_localctx = new ArrayToSetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				match(ID);
				setState(419);
				match(EQ);
				setState(420);
				match(ID);
				setState(421);
				match(VAKASIYANA);
				}
				break;
			case 3:
				_localctx = new ExprToSetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				match(ID);
				setState(423);
				match(EQ);
				setState(424);
				primaryExpression(0);
				setState(425);
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DescendingSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public TerminalNode CHIDZIKA() { return getToken(ShonascriptxParser.CHIDZIKA, 0); }
		public DescendingSortContext(SortStatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultSortContext extends SortStatementContext {
		public TerminalNode RONGA() { return getToken(ShonascriptxParser.RONGA, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public DefaultSortContext(SortStatementContext ctx) { copyFrom(ctx); }
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
	}

	public final SortStatementContext sortStatement() throws RecognitionException {
		SortStatementContext _localctx = new SortStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sortStatement);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new DefaultSortContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				match(RONGA);
				setState(430);
				match(ID);
				}
				break;
			case 2:
				_localctx = new DescendingSortContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(RONGA);
				setState(432);
				match(ID);
				setState(433);
				match(CHIDZIKA);
				}
				break;
			case 3:
				_localctx = new ObjectDescSortContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(434);
				match(RONGA);
				setState(435);
				match(ID);
				setState(436);
				match(EQUALITY_PREPOSITION);
				setState(437);
				match(ID);
				setState(438);
				match(CHIDZIKA);
				}
				break;
			case 4:
				_localctx = new ObjectAscSortContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(439);
				match(RONGA);
				setState(440);
				match(ID);
				setState(441);
				match(EQUALITY_PREPOSITION);
				setState(442);
				match(ID);
				setState(443);
				match(CHIKWIRA);
				}
				break;
			case 5:
				_localctx = new AscendingSortContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(444);
				match(RONGA);
				setState(445);
				match(ID);
				setState(446);
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
	}

	public final FilterStatementContext filterStatement() throws RecognitionException {
		FilterStatementContext _localctx = new FilterStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_filterStatement);
		try {
			setState(482);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new ObjectFilterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				match(BVISA);
				setState(450);
				match(ID);
				setState(451);
				match(HAS);
				setState(452);
				match(ID);
				setState(453);
				comparisonOperator();
				setState(454);
				expression();
				}
				break;
			case 2:
				_localctx = new NounClassFilterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(456);
				match(BVISA);
				setState(457);
				match(HAS);
				setState(458);
				match(ID);
				setState(459);
				comparisonOperator();
				setState(460);
				expression();
				setState(461);
				match(MU);
				setState(462);
				match(ID);
				}
				break;
			case 3:
				_localctx = new PrimitiveFilterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(464);
				match(BVISA);
				setState(465);
				match(HAS);
				setState(466);
				comparisonOperator();
				setState(467);
				expression();
				setState(468);
				match(MU);
				setState(469);
				match(ID);
				}
				break;
			case 4:
				_localctx = new DirectValueFilterContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(471);
				match(BVISA);
				setState(472);
				expression();
				setState(473);
				match(MU);
				setState(474);
				match(ID);
				}
				break;
			case 5:
				_localctx = new ComplexFilterContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(476);
				match(BVISA);
				setState(477);
				match(HAS);
				setState(478);
				logicalFilterExpression();
				setState(479);
				match(MU);
				setState(480);
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
	}

	public final LogicalFilterExpressionContext logicalFilterExpression() throws RecognitionException {
		LogicalFilterExpressionContext _localctx = new LogicalFilterExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_logicalFilterExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			match(ID);
			setState(485);
			comparisonOperator();
			setState(486);
			expression();
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 469773312L) != 0)) {
				{
				{
				setState(495);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(487);
					match(KANA);
					setState(488);
					match(KUTI);
					}
					break;
				case 2:
					{
					setState(489);
					match(KANA);
					}
					break;
				case 3:
					{
					setState(490);
					match(OR);
					}
					break;
				case 4:
					{
					setState(491);
					match(LOGICAL_OR);
					}
					break;
				case 5:
					{
					setState(492);
					match(UYE);
					}
					break;
				case 6:
					{
					setState(493);
					match(AND);
					}
					break;
				case 7:
					{
					setState(494);
					match(LOGICAL_AND);
					}
					break;
				}
				setState(497);
				match(ID);
				setState(498);
				comparisonOperator();
				setState(499);
				expression();
				}
				}
				setState(505);
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
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
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
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_htmlElement);
		int _la;
		try {
			int _alt;
			setState(565);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new HtmlBlockElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				match(LT);
				setState(509);
				tagName();
				setState(515);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017613182818287616L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 671088641L) != 0)) {
					{
					setState(513);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WS_IN_HTML:
						{
						setState(510);
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
						setState(511);
						attribute();
						}
						break;
					case NEWLINE:
						{
						setState(512);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(517);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(518);
				match(GT);
				setState(519);
				htmlContent();
				setState(520);
				match(LT);
				setState(521);
				match(SLASH);
				setState(522);
				tagName();
				setState(523);
				match(GT);
				setState(527);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(524);
						match(NEWLINE);
						}
						} 
					}
					setState(529);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				}
				break;
			case 2:
				_localctx = new HtmlSelfClosingElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(530);
				match(LT);
				setState(531);
				tagName();
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017613182818287616L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 671088641L) != 0)) {
					{
					setState(535);
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
						setState(532);
						attribute();
						}
						break;
					case WS_IN_HTML:
						{
						setState(533);
						match(WS_IN_HTML);
						}
						break;
					case NEWLINE:
						{
						setState(534);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(539);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(540);
				match(SLASH);
				setState(541);
				match(GT);
				setState(545);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(542);
						match(NEWLINE);
						}
						} 
					}
					setState(547);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new HtmlVoidElementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(548);
				match(LT);
				setState(549);
				tagName();
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017613182818287616L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 671088641L) != 0)) {
					{
					setState(553);
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
						setState(550);
						attribute();
						}
						break;
					case WS_IN_HTML:
						{
						setState(551);
						match(WS_IN_HTML);
						}
						break;
					case NEWLINE:
						{
						setState(552);
						match(NEWLINE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(557);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(558);
				match(GT);
				setState(562);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(559);
						match(NEWLINE);
						}
						} 
					}
					setState(564);
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
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_tagName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
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
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_attribute);
		try {
			setState(576);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new HtmlAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				attrName();
				setState(570);
				match(EQ);
				setState(573);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
					{
					setState(571);
					match(STRING);
					}
					break;
				case LBRACE:
					{
					setState(572);
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
				setState(575);
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
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_attrName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
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
	}

	public final EventHandlerContext eventHandler() throws RecognitionException {
		EventHandlerContext _localctx = new EventHandlerContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_eventHandler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2017612633061982208L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(581);
			match(EQ);
			setState(582);
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
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_htmlContent);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(584);
					htmlContentElement();
					}
					} 
				}
				setState(589);
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
	}

	public final HtmlContentElementContext htmlContentElement() throws RecognitionException {
		HtmlContentElementContext _localctx = new HtmlContentElementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_htmlContentElement);
		try {
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(591);
				shonaControlFlow();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(592);
				shonaExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(593);
				htmlText();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(594);
				match(NEWLINE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(595);
				match(INDENT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(596);
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
	}

	public final ShonaControlFlowContext shonaControlFlow() throws RecognitionException {
		ShonaControlFlowContext _localctx = new ShonaControlFlowContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_shonaControlFlow);
		try {
			setState(611);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(599);
				match(LBRACE);
				setState(600);
				conditionalInHtml();
				setState(601);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(603);
				match(LBRACE);
				setState(604);
				loopInHtml();
				setState(605);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(607);
				match(LBRACE);
				setState(608);
				whileInHtml();
				setState(609);
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
	}

	public final ConditionalInHtmlContext conditionalInHtml() throws RecognitionException {
		ConditionalInHtmlContext _localctx = new ConditionalInHtmlContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_conditionalInHtml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			match(KANA);
			setState(614);
			expression();
			setState(615);
			match(COLON);
			setState(616);
			htmlContentUntilKeyword();
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KANA) {
				{
				{
				setState(617);
				match(KANA);
				setState(618);
				match(KUTI);
				setState(619);
				expression();
				setState(620);
				match(COLON);
				setState(621);
				htmlContentUntilKeyword();
				}
				}
				setState(627);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ZVIMWE) {
				{
				setState(628);
				match(ZVIMWE);
				setState(629);
				match(COLON);
				setState(630);
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
	}

	public final HtmlContentUntilKeywordContext htmlContentUntilKeyword() throws RecognitionException {
		HtmlContentUntilKeywordContext _localctx = new HtmlContentUntilKeywordContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_htmlContentUntilKeyword);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(633);
					htmlContentPart();
					}
					} 
				}
				setState(638);
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
	}

	public final HtmlContentToEndContext htmlContentToEnd() throws RecognitionException {
		HtmlContentToEndContext _localctx = new HtmlContentToEndContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_htmlContentToEnd);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(639);
					htmlContentPart();
					}
					} 
				}
				setState(644);
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
	}

	public final HtmlContentPartContext htmlContentPart() throws RecognitionException {
		HtmlContentPartContext _localctx = new HtmlContentPartContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_htmlContentPart);
		try {
			setState(659);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(646);
				match(LBRACE);
				setState(647);
				loopInHtml();
				setState(648);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(650);
				match(LBRACE);
				setState(651);
				conditionalInHtml();
				setState(652);
				match(RBRACE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(654);
				shonaExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(655);
				htmlTextNotKeyword();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(656);
				match(NEWLINE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(657);
				match(INDENT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(658);
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
	}

	public final HtmlTextNotKeywordContext htmlTextNotKeyword() throws RecognitionException {
		HtmlTextNotKeywordContext _localctx = new HtmlTextNotKeywordContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_htmlTextNotKeyword);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(662); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(661);
					htmlTextContentNotKeyword();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(664); 
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
	}

	public final HtmlTextContentNotKeywordContext htmlTextContentNotKeyword() throws RecognitionException {
		HtmlTextContentNotKeywordContext _localctx = new HtmlTextContentNotKeywordContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_htmlTextContentNotKeyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
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
	}

	public final LoopInHtmlContext loopInHtml() throws RecognitionException {
		LoopInHtmlContext _localctx = new LoopInHtmlContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_loopInHtml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			match(PANE);
			setState(669);
			match(ID);
			setState(670);
			match(MU);
			setState(671);
			primaryExpression(0);
			setState(672);
			match(COLON);
			setState(673);
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
	}

	public final WhileInHtmlContext whileInHtml() throws RecognitionException {
		WhileInHtmlContext _localctx = new WhileInHtmlContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_whileInHtml);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(KANA);
			setState(676);
			expression();
			setState(677);
			match(DZOKORORA);
			setState(678);
			match(COLON);
			setState(679);
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
	}

	public final HtmlSuiteContext htmlSuite() throws RecognitionException {
		HtmlSuiteContext _localctx = new HtmlSuiteContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_htmlSuite);
		try {
			setState(687);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				_localctx = new HtmlBlockSuiteContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				htmlContent();
				}
				break;
			case 2:
				_localctx = new HtmlIndentedSuiteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(682);
				match(NEWLINE);
				setState(683);
				match(INDENT);
				setState(684);
				htmlContent();
				setState(685);
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
	}

	public final ShonaExpressionContext shonaExpression() throws RecognitionException {
		ShonaExpressionContext _localctx = new ShonaExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_shonaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			match(LBRACE);
			setState(690);
			expression();
			setState(691);
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
	}

	public final HtmlTextContext htmlText() throws RecognitionException {
		HtmlTextContext _localctx = new HtmlTextContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_htmlText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(694); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(693);
					htmlTextContent();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(696); 
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
	}

	public final HtmlTextContentContext htmlTextContent() throws RecognitionException {
		HtmlTextContentContext _localctx = new HtmlTextContentContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_htmlTextContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
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
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(BVUNZA);
			setState(701);
			match(ID);
			setState(702);
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
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode TORA() { return getToken(ShonascriptxParser.TORA, 0); }
		public List<TerminalNode> ID() { return getTokens(ShonascriptxParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ShonascriptxParser.ID, i);
		}
		public TerminalNode KUBVA() { return getToken(ShonascriptxParser.KUBVA, 0); }
		public TerminalNode MU() { return getToken(ShonascriptxParser.MU, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(TORA);
			setState(705);
			match(ID);
			setState(706);
			match(KUBVA);
			setState(707);
			match(MU);
			setState(708);
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
	}

	public final FetchStatementContext fetchStatement() throws RecognitionException {
		FetchStatementContext _localctx = new FetchStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_fetchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			match(TAMBIRA);
			setState(711);
			match(ID);
			setState(712);
			match(KUBVA);
			setState(713);
			match(KU);
			setState(714);
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
	}

	public final PropNameContext propName() throws RecognitionException {
		PropNameContext _localctx = new PropNameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_propName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
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
	}

	public final PropertyRefContext propertyRef() throws RecognitionException {
		PropertyRefContext _localctx = new PropertyRefContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_propertyRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			propName();
			setState(723);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(719);
					match(POS);
					setState(720);
					propName();
					}
					} 
				}
				setState(725);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(726);
			match(POS);
			setState(727);
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
	}

	public final PropertyDeleteContext propertyDelete() throws RecognitionException {
		PropertyDeleteContext _localctx = new PropertyDeleteContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_propertyDelete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			match(BVISA);
			setState(730);
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
	}

	public final DomSelectorContext domSelector() throws RecognitionException {
		DomSelectorContext _localctx = new DomSelectorContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_domSelector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(ID);
			setState(733);
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
	}

	public final DomPropertyRefContext domPropertyRef() throws RecognitionException {
		DomPropertyRefContext _localctx = new DomPropertyRefContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_domPropertyRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			match(ID);
			setState(736);
			match(POS);
			setState(737);
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
	}

	public final EventListenerStatementContext eventListenerStatement() throws RecognitionException {
		EventListenerStatementContext _localctx = new EventListenerStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_eventListenerStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			match(KANA);
			setState(740);
			domSelector();
			setState(741);
			_la = _input.LA(1);
			if ( !(_la==EVENT_CLICK || _la==EVENT_SUBMIT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(742);
			match(COLON);
			setState(743);
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
	}

	public final ClassStatementContext classStatement() throws RecognitionException {
		ClassStatementContext _localctx = new ClassStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_classStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			_la = _input.LA(1);
			if ( !(_la==ISA || _la==BVISA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(746);
			match(CLASS);
			setState(747);
			match(STRING);
			setState(748);
			match(PA);
			setState(749);
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
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			match(PANE);
			setState(752);
			match(ID);
			setState(753);
			match(MU);
			setState(754);
			primaryExpression(0);
			setState(755);
			match(COLON);
			setState(756);
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
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			match(KANA);
			setState(759);
			expression();
			setState(760);
			match(DZOKORORA);
			setState(761);
			match(COLON);
			setState(762);
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
	}

	public final IntervalStatementContext intervalStatement() throws RecognitionException {
		IntervalStatementContext _localctx = new IntervalStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_intervalStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			primaryExpression(0);
			setState(765);
			match(DZOKORORA);
			setState(766);
			expression();
			setState(767);
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
	}

	public final TimeoutStatementContext timeoutStatement() throws RecognitionException {
		TimeoutStatementContext _localctx = new TimeoutStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_timeoutStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			primaryExpression(0);
			setState(770);
			match(MIRIRA);
			setState(771);
			expression();
			setState(772);
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
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
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
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
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
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_assignable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
			assignRoot();
			setState(782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET || _la==DOT) {
				{
				{
				setState(779);
				memberAccess();
				}
				}
				setState(784);
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
	}

	public final AssignRootContext assignRoot() throws RecognitionException {
		AssignRootContext _localctx = new AssignRootContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_assignRoot);
		try {
			setState(788);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(785);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(786);
				propertyRef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(787);
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
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_memberAccess);
		try {
			setState(796);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(790);
				match(DOT);
				setState(791);
				match(ID);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(792);
				match(LBRACKET);
				setState(793);
				expression();
				setState(794);
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			assignable();
			setState(799);
			_la = _input.LA(1);
			if ( !(_la==NDI || _la==EQ) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(800);
				match(NEWLINE);
				}
				}
				setState(805);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(806);
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
	}

	public final NyoraStatementContext nyoraStatement() throws RecognitionException {
		NyoraStatementContext _localctx = new NyoraStatementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_nyoraStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			match(NYORA);
			setState(809);
			expression();
			setState(814);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(810);
					match(COMMA);
					setState(811);
					expression();
					}
					} 
				}
				setState(816);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
	}

	public final ArrayAddContext arrayAdd() throws RecognitionException {
		ArrayAddContext _localctx = new ArrayAddContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_arrayAdd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(817);
			match(ISA);
			setState(818);
			expression();
			setState(819);
			match(MU);
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
	}

	public final ArrayRemoveContext arrayRemove() throws RecognitionException {
		ArrayRemoveContext _localctx = new ArrayRemoveContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_arrayRemove);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			match(BVISA);
			setState(823);
			expression();
			setState(824);
			match(MU);
			setState(825);
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
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_conditionalStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			match(KANA);
			setState(828);
			expression();
			setState(829);
			match(COLON);
			setState(830);
			suite();
			setState(845);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(832);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NEWLINE) {
						{
						setState(831);
						match(NEWLINE);
						}
					}

					setState(837);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
					case 1:
						{
						setState(834);
						match(KANA);
						setState(835);
						match(KUTI);
						}
						break;
					case 2:
						{
						setState(836);
						match(KANA);
						}
						break;
					}
					setState(839);
					expression();
					setState(840);
					match(COLON);
					setState(841);
					suite();
					}
					} 
				}
				setState(847);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(854);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(849);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(848);
					match(NEWLINE);
					}
				}

				setState(851);
				match(ZVIMWE);
				setState(852);
				match(COLON);
				setState(853);
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
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION || _la==BASA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(857);
			match(ID);
			setState(858);
			match(LPAREN);
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(859);
				parameterList();
				}
			}

			setState(862);
			match(RPAREN);
			setState(863);
			match(COLON);
			setState(864);
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
	}

	public final AnonymousFunctionContext anonymousFunction() throws RecognitionException {
		AnonymousFunctionContext _localctx = new AnonymousFunctionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_anonymousFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			_la = _input.LA(1);
			if ( !(_la==FUNCTION || _la==BASA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(867);
			match(LPAREN);
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(868);
				parameterList();
				}
			}

			setState(871);
			match(RPAREN);
			setState(872);
			match(COLON);
			setState(873);
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
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(875);
			_la = _input.LA(1);
			if ( !(_la==RETURN || _la==DZOSA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(876);
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
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_suite);
		int _la;
		try {
			setState(888);
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
				setState(878);
				simpleStatement();
				}
				break;
			case NEWLINE:
				_localctx = new BlockSuiteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(879);
				match(NEWLINE);
				setState(880);
				match(INDENT);
				setState(882); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(881);
					programElement();
					}
					}
					setState(884); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 29115337472012288L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0) );
				setState(886);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
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
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			logicalOrExpression();
			setState(898);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(893);
				match(T__8);
				setState(894);
				expression();
				setState(895);
				match(COLON);
				setState(896);
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
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_logicalOrExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			logicalAndExpression();
			setState(911);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(906);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
					case 1:
						{
						setState(901);
						match(KANA);
						setState(902);
						match(KUTI);
						}
						break;
					case 2:
						{
						setState(903);
						match(KANA);
						}
						break;
					case 3:
						{
						setState(904);
						match(OR);
						}
						break;
					case 4:
						{
						setState(905);
						match(LOGICAL_OR);
						}
						break;
					}
					setState(908);
					logicalAndExpression();
					}
					} 
				}
				setState(913);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
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
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_logicalAndExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			equalityExpression();
			setState(919);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(915);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 201327616L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(916);
					equalityExpression();
					}
					} 
				}
				setState(921);
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
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_equalityExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			comparisonExpression();
			setState(927);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(923);
					_la = _input.LA(1);
					if ( !(_la==EQ_EQ || _la==NOT_EQ) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(924);
					comparisonExpression();
					}
					} 
				}
				setState(929);
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
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_comparisonExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			additiveExpression();
			setState(935);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(931);
					_la = _input.LA(1);
					if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 98307L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(932);
					additiveExpression();
					}
					} 
				}
				setState(937);
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
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_additiveExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(938);
			multiplicativeExpression();
			setState(943);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(939);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(940);
					multiplicativeExpression();
					}
					} 
				}
				setState(945);
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
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_multiplicativeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(946);
			powerExpression();
			setState(951);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(947);
					_la = _input.LA(1);
					if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 3073L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(948);
					powerExpression();
					}
					} 
				}
				setState(953);
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
	}

	public final PowerExpressionContext powerExpression() throws RecognitionException {
		PowerExpressionContext _localctx = new PowerExpressionContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_powerExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			unaryExpression();
			setState(957);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(955);
				match(POWER);
				setState(956);
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
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_unaryExpression);
		int _la;
		try {
			setState(962);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case NOT:
				_localctx = new UnaryOpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(959);
				_la = _input.LA(1);
				if ( !(((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 515L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(960);
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
				setState(961);
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends PrimaryExpressionContext {
		public TerminalNode LPAREN() { return getToken(ShonascriptxParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShonascriptxParser.RPAREN, 0); }
		public ParensContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends PrimaryExpressionContext {
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public StringContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassExistenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode RIPO_SUFFIX() { return getToken(ShonascriptxParser.RIPO_SUFFIX, 0); }
		public NounClassExistenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LengthExprContext extends PrimaryExpressionContext {
		public TerminalNode VERENGA() { return getToken(ShonascriptxParser.VERENGA, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public LengthExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends PrimaryExpressionContext {
		public TerminalNode NUMBER() { return getToken(ShonascriptxParser.NUMBER, 0); }
		public NumberContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JoinExprContext extends PrimaryExpressionContext {
		public TerminalNode BATANIDZA() { return getToken(ShonascriptxParser.BATANIDZA, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public JoinExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprToSetExprContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode VAKASIYANA() { return getToken(ShonascriptxParser.VAKASIYANA, 0); }
		public ExprToSetExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ZvanyorwaVarContext extends PrimaryExpressionContext {
		public TerminalNode ZVANYORWA() { return getToken(ShonascriptxParser.ZVANYORWA, 0); }
		public ZvanyorwaVarContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JsObjLiteralContext extends PrimaryExpressionContext {
		public JsObjectLiteralContext jsObjectLiteral() {
			return getRuleContext(JsObjectLiteralContext.class,0);
		}
		public JsObjLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayRangeContext extends PrimaryExpressionContext {
		public TerminalNode LBRACKET() { return getToken(ShonascriptxParser.LBRACKET, 0); }
		public RangeExpressionContext rangeExpression() {
			return getRuleContext(RangeExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(ShonascriptxParser.RBRACKET, 0); }
		public ArrayRangeContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlExprContext extends PrimaryExpressionContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public HtmlExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjLiteralContext extends PrimaryExpressionContext {
		public ObjectLiteralContext objectLiteral() {
			return getRuleContext(ObjectLiteralContext.class,0);
		}
		public ObjLiteralContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InputExprContext extends PrimaryExpressionContext {
		public TerminalNode BVUNZA() { return getToken(ShonascriptxParser.BVUNZA, 0); }
		public TerminalNode STRING() { return getToken(ShonascriptxParser.STRING, 0); }
		public InputExprContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PropertyGetContext extends PrimaryExpressionContext {
		public PropertyRefContext propertyRef() {
			return getRuleContext(PropertyRefContext.class,0);
		}
		public PropertyGetContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DotAccessContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ShonascriptxParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public DotAccessContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends PrimaryExpressionContext {
		public TerminalNode BOOLEAN() { return getToken(ShonascriptxParser.BOOLEAN, 0); }
		public BooleanContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DomPropertyGetContext extends PrimaryExpressionContext {
		public DomPropertyRefContext domPropertyRef() {
			return getRuleContext(DomPropertyRefContext.class,0);
		}
		public DomPropertyGetContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends PrimaryExpressionContext {
		public TerminalNode ID() { return getToken(ShonascriptxParser.ID, 0); }
		public VariableContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NounClassNonExistenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode SIPO_SUFFIX() { return getToken(ShonascriptxParser.SIPO_SUFFIX, 0); }
		public NounClassNonExistenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
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
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 166;
		enterRecursionRule(_localctx, 166, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1063);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				_localctx = new DomPropertyGetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(965);
				domPropertyRef();
				}
				break;
			case 2:
				{
				_localctx = new PropertyGetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(966);
				propertyRef();
				}
				break;
			case 3:
				{
				_localctx = new PropertyAccessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(967);
				match(ID);
				setState(968);
				match(POS);
				setState(969);
				match(ID);
				setState(972); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(970);
						match(POS);
						setState(971);
						match(ID);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(974); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				{
				_localctx = new MethodCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(976);
				match(BASA);
				setState(977);
				match(POS);
				setState(978);
				match(ID);
				setState(983);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==POS) {
					{
					{
					setState(979);
					match(POS);
					setState(980);
					match(ID);
					}
					}
					setState(985);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(986);
				match(ID);
				setState(987);
				match(LPAREN);
				setState(989);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 8440471L) != 0)) {
					{
					setState(988);
					argumentList();
					}
				}

				setState(991);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(992);
				match(ID);
				setState(993);
				match(LPAREN);
				setState(995);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 8440471L) != 0)) {
					{
					setState(994);
					argumentList();
					}
				}

				setState(997);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new AnonymousFunctionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(998);
				_la = _input.LA(1);
				if ( !(_la==FUNCTION || _la==BASA) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(999);
				match(LPAREN);
				setState(1001);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(1000);
					parameterList();
					}
				}

				setState(1003);
				match(RPAREN);
				setState(1004);
				match(COLON);
				setState(1005);
				suite();
				}
				break;
			case 7:
				{
				_localctx = new ArrayLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1006);
				match(LBRACKET);
				setState(1010);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1007);
						match(NEWLINE);
						}
						} 
					}
					setState(1012);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
				}
				setState(1014);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(1013);
					arrayElements();
					}
					break;
				}
				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(1016);
					match(NEWLINE);
					}
					}
					setState(1021);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1022);
				match(RBRACKET);
				}
				break;
			case 8:
				{
				_localctx = new ArrayRangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1023);
				match(LBRACKET);
				setState(1024);
				rangeExpression();
				setState(1025);
				match(RBRACKET);
				}
				break;
			case 9:
				{
				_localctx = new LengthExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1027);
				match(VERENGA);
				setState(1028);
				primaryExpression(28);
				}
				break;
			case 10:
				{
				_localctx = new JoinExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1029);
				match(BATANIDZA);
				setState(1030);
				primaryExpression(27);
				}
				break;
			case 11:
				{
				_localctx = new IndexOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1031);
				match(PA);
				setState(1032);
				expression();
				setState(1033);
				match(MU);
				setState(1034);
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
				setState(1036);
				match(LBRACKET);
				setState(1038);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 686098535714816L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 142658199L) != 0)) {
					{
					setState(1037);
					arrayElements();
					}
				}

				setState(1040);
				match(RBRACKET);
				setState(1041);
				match(VAKASIYANA);
				}
				break;
			case 13:
				{
				_localctx = new VarToSetExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1042);
				match(ID);
				setState(1043);
				match(VAKASIYANA);
				}
				break;
			case 14:
				{
				_localctx = new InputExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1044);
				match(BVUNZA);
				setState(1045);
				match(STRING);
				}
				break;
			case 15:
				{
				_localctx = new FetchExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1046);
				match(TAMBIRA);
				setState(1047);
				match(ID);
				setState(1048);
				match(KUBVA);
				setState(1049);
				match(KU);
				setState(1050);
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
				setState(1051);
				match(NUMBER);
				}
				break;
			case 17:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1052);
				match(BOOLEAN);
				}
				break;
			case 18:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1053);
				match(STRING);
				}
				break;
			case 19:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1054);
				match(ID);
				}
				break;
			case 20:
				{
				_localctx = new ZvanyorwaVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1055);
				match(ZVANYORWA);
				}
				break;
			case 21:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1056);
				match(LPAREN);
				setState(1057);
				expression();
				setState(1058);
				match(RPAREN);
				}
				break;
			case 22:
				{
				_localctx = new ObjLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1060);
				objectLiteral();
				}
				break;
			case 23:
				{
				_localctx = new JsObjLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1061);
				jsObjectLiteral();
				}
				break;
			case 24:
				{
				_localctx = new HtmlExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1062);
				htmlElement();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1107);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
					case 1:
						{
						_localctx = new NounClassEqualityContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1065);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1066);
						match(NCLASS);
						setState(1067);
						primaryExpression(10);
						}
						break;
					case 2:
						{
						_localctx = new NounClassInequalityContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1068);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1069);
						match(SIRI_SUFFIX);
						setState(1070);
						primaryExpression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprToSetExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1071);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(1072);
						match(VAKASIYANA);
						}
						break;
					case 4:
						{
						_localctx = new IntervalExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1073);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(1074);
						match(DZOKORORA);
						setState(1075);
						expression();
						setState(1076);
						match(SECONDS);
						}
						break;
					case 5:
						{
						_localctx = new TimeoutExprContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1078);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1079);
						match(MIRIRA);
						setState(1080);
						expression();
						setState(1081);
						match(SECONDS);
						}
						break;
					case 6:
						{
						_localctx = new InArrayOpContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1083);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1084);
						match(NCLASS);
						setState(1085);
						match(MU);
						setState(1086);
						expression();
						}
						break;
					case 7:
						{
						_localctx = new InStringOpContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1087);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1088);
						match(NCLASS);
						setState(1089);
						match(MU);
						setState(1090);
						match(STRING);
						}
						break;
					case 8:
						{
						_localctx = new NaturalEqualityOpContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1091);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1092);
						match(EQUALITY_VERB);
						setState(1093);
						match(EQUALITY_PREPOSITION);
						setState(1094);
						expression();
						}
						break;
					case 9:
						{
						_localctx = new NounClassExistenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1095);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1096);
						match(RIPO_SUFFIX);
						}
						break;
					case 10:
						{
						_localctx = new NounClassNonExistenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1097);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1098);
						match(SIPO_SUFFIX);
						}
						break;
					case 11:
						{
						_localctx = new DotAccessContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1099);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1100);
						match(DOT);
						setState(1101);
						match(ID);
						}
						break;
					case 12:
						{
						_localctx = new BracketAccessContext(new PrimaryExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1102);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1103);
						match(LBRACKET);
						setState(1104);
						expression();
						setState(1105);
						match(RBRACKET);
						}
						break;
					}
					} 
				}
				setState(1111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,90,_ctx);
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
	}

	public final ObjectLiteralContext objectLiteral() throws RecognitionException {
		ObjectLiteralContext _localctx = new ObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_objectLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1112);
			_la = _input.LA(1);
			if ( !(_la==PANE || _la==HAS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1113);
			match(COLON);
			setState(1114);
			linearObjectEntries();
			setState(1116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(1115);
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
	}

	public final JsObjectLiteralContext jsObjectLiteral() throws RecognitionException {
		JsObjectLiteralContext _localctx = new JsObjectLiteralContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_jsObjectLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1118);
			match(LBRACE);
			setState(1122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1119);
					match(NEWLINE);
					}
					} 
				}
				setState(1124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			}
			setState(1126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID || _la==STRING) {
				{
				setState(1125);
				jsObjectEntries();
				}
			}

			setState(1131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(1128);
				match(NEWLINE);
				}
				}
				setState(1133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1134);
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
	}

	public final JsObjectEntriesContext jsObjectEntries() throws RecognitionException {
		JsObjectEntriesContext _localctx = new JsObjectEntriesContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_jsObjectEntries);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1136);
			jsObjectEntry();
			setState(1154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1149);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(1137);
						match(COMMA);
						setState(1141);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(1138);
							match(NEWLINE);
							}
							}
							setState(1143);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case NEWLINE:
						{
						setState(1145); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1144);
							match(NEWLINE);
							}
							}
							setState(1147); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1151);
					jsObjectEntry();
					}
					} 
				}
				setState(1156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			}
			setState(1158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1157);
				match(COMMA);
				}
			}

			setState(1163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1160);
					match(NEWLINE);
					}
					} 
				}
				setState(1165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
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
	}

	public final JsObjectEntryContext jsObjectEntry() throws RecognitionException {
		JsObjectEntryContext _localctx = new JsObjectEntryContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_jsObjectEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1166);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1167);
			match(COLON);
			setState(1168);
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
	}

	public final RangeExpressionContext rangeExpression() throws RecognitionException {
		RangeExpressionContext _localctx = new RangeExpressionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_rangeExpression);
		try {
			setState(1182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				_localctx = new FullRangeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1170);
				expression();
				setState(1171);
				match(COMMA);
				setState(1172);
				expression();
				setState(1173);
				match(COMMA);
				setState(1174);
				match(ELLIPSIS);
				setState(1175);
				expression();
				}
				break;
			case 2:
				_localctx = new SimpleRangeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1177);
				expression();
				setState(1178);
				match(COMMA);
				setState(1179);
				match(ELLIPSIS);
				setState(1180);
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
	}

	public final ArrayElementsContext arrayElements() throws RecognitionException {
		ArrayElementsContext _localctx = new ArrayElementsContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_arrayElements);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(1184);
				match(NEWLINE);
				}
				}
				setState(1189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1190);
			arrayElement();
			setState(1208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1203);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(1191);
						match(COMMA);
						setState(1195);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NEWLINE) {
							{
							{
							setState(1192);
							match(NEWLINE);
							}
							}
							setState(1197);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
						break;
					case NEWLINE:
						{
						setState(1199); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1198);
							match(NEWLINE);
							}
							}
							setState(1201); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==NEWLINE );
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1205);
					arrayElement();
					}
					} 
				}
				setState(1210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			}
			setState(1212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1211);
				match(COMMA);
				}
			}

			setState(1217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1214);
					match(NEWLINE);
					}
					} 
				}
				setState(1219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
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
	}

	public final ArrayElementContext arrayElement() throws RecognitionException {
		ArrayElementContext _localctx = new ArrayElementContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_arrayElement);
		try {
			setState(1222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1220);
				objectLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1221);
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
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1224);
			expression();
			setState(1229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1225);
				match(COMMA);
				setState(1226);
				expression();
				}
				}
				setState(1231);
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
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1232);
			match(ID);
			setState(1237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1233);
				match(COMMA);
				setState(1234);
				match(ID);
				}
				}
				setState(1239);
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
		case 83:
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
		"\u0004\u0001b\u04d9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0001\u0000\u0005\u0000\u00bc\b"+
		"\u0000\n\u0000\f\u0000\u00bf\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u00c6\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u00cc\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u00d0\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00eb\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006\u00f6\b\u0006\u000b\u0006\f\u0006"+
		"\u00f7\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0106"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\t\u010e\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0115\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u011a\b\n\n\n\f\n\u011d\t\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u012a\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u012f\b\u000b\u0001\f\u0001\f\u0005"+
		"\f\u0133\b\f\n\f\f\f\u0136\t\f\u0001\f\u0005\f\u0139\b\f\n\f\f\f\u013c"+
		"\t\f\u0001\f\u0005\f\u013f\b\f\n\f\f\f\u0142\t\f\u0001\f\u0005\f\u0145"+
		"\b\f\n\f\f\f\u0148\t\f\u0001\f\u0005\f\u014b\b\f\n\f\f\f\u014e\t\f\u0001"+
		"\f\u0005\f\u0151\b\f\n\f\f\f\u0154\t\f\u0001\f\u0005\f\u0157\b\f\n\f\f"+
		"\f\u015a\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0170\b\r\u0001\r\u0003\r\u0173\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u0178\b\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u017d\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u0183\b\u000e\n\u000e\f\u000e\u0186\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u018d\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u019f\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u01ac\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u01c0\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01e3"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u01f0\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u01f6\b\u0017\n\u0017\f\u0017\u01f9\t\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u0202\b\u0019\n\u0019\f\u0019\u0205\t\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u020e"+
		"\b\u0019\n\u0019\f\u0019\u0211\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u0218\b\u0019\n\u0019\f\u0019\u021b"+
		"\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0220\b\u0019"+
		"\n\u0019\f\u0019\u0223\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0005\u0019\u022a\b\u0019\n\u0019\f\u0019\u022d\t\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u0231\b\u0019\n\u0019\f\u0019\u0234"+
		"\t\u0019\u0003\u0019\u0236\b\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u023e\b\u001b\u0001\u001b"+
		"\u0003\u001b\u0241\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0005\u001e\u024a\b\u001e\n\u001e"+
		"\f\u001e\u024d\t\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0256\b\u001f\u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u0264\b \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0005!\u0270\b!\n!\f!\u0273\t!\u0001!\u0001!\u0001"+
		"!\u0003!\u0278\b!\u0001\"\u0005\"\u027b\b\"\n\"\f\"\u027e\t\"\u0001#\u0005"+
		"#\u0281\b#\n#\f#\u0284\t#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0294\b$\u0001"+
		"%\u0004%\u0297\b%\u000b%\f%\u0298\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001("+
		"\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u02b0\b)\u0001"+
		"*\u0001*\u0001*\u0001*\u0001+\u0004+\u02b7\b+\u000b+\f+\u02b8\u0001,\u0001"+
		",\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u00011\u0001"+
		"1\u00011\u00051\u02d2\b1\n1\f1\u02d5\t1\u00011\u00011\u00011\u00012\u0001"+
		"2\u00012\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00019\u00019\u00019\u00019\u00019\u0001:\u0001"+
		":\u0001:\u0001:\u0001:\u0001;\u0001;\u0001<\u0001<\u0001=\u0001=\u0005"+
		"=\u030d\b=\n=\f=\u0310\t=\u0001>\u0001>\u0001>\u0003>\u0315\b>\u0001?"+
		"\u0001?\u0001?\u0001?\u0001?\u0001?\u0003?\u031d\b?\u0001@\u0001@\u0001"+
		"@\u0005@\u0322\b@\n@\f@\u0325\t@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001"+
		"A\u0005A\u032d\bA\nA\fA\u0330\tA\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"C\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0003"+
		"D\u0341\bD\u0001D\u0001D\u0001D\u0003D\u0346\bD\u0001D\u0001D\u0001D\u0001"+
		"D\u0005D\u034c\bD\nD\fD\u034f\tD\u0001D\u0003D\u0352\bD\u0001D\u0001D"+
		"\u0001D\u0003D\u0357\bD\u0001E\u0001E\u0001E\u0001E\u0003E\u035d\bE\u0001"+
		"E\u0001E\u0001E\u0001E\u0001F\u0001F\u0001F\u0003F\u0366\bF\u0001F\u0001"+
		"F\u0001F\u0001F\u0001G\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0004"+
		"H\u0373\bH\u000bH\fH\u0374\u0001H\u0001H\u0003H\u0379\bH\u0001I\u0001"+
		"I\u0001J\u0001J\u0001J\u0001J\u0001J\u0001J\u0003J\u0383\bJ\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0003K\u038b\bK\u0001K\u0005K\u038e\bK\n"+
		"K\fK\u0391\tK\u0001L\u0001L\u0001L\u0005L\u0396\bL\nL\fL\u0399\tL\u0001"+
		"M\u0001M\u0001M\u0005M\u039e\bM\nM\fM\u03a1\tM\u0001N\u0001N\u0001N\u0005"+
		"N\u03a6\bN\nN\fN\u03a9\tN\u0001O\u0001O\u0001O\u0005O\u03ae\bO\nO\fO\u03b1"+
		"\tO\u0001P\u0001P\u0001P\u0005P\u03b6\bP\nP\fP\u03b9\tP\u0001Q\u0001Q"+
		"\u0001Q\u0003Q\u03be\bQ\u0001R\u0001R\u0001R\u0003R\u03c3\bR\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0004S\u03cd\bS\u000bS\fS"+
		"\u03ce\u0001S\u0001S\u0001S\u0001S\u0001S\u0005S\u03d6\bS\nS\fS\u03d9"+
		"\tS\u0001S\u0001S\u0001S\u0003S\u03de\bS\u0001S\u0001S\u0001S\u0001S\u0003"+
		"S\u03e4\bS\u0001S\u0001S\u0001S\u0001S\u0003S\u03ea\bS\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0005S\u03f1\bS\nS\fS\u03f4\tS\u0001S\u0003S\u03f7\bS"+
		"\u0001S\u0005S\u03fa\bS\nS\fS\u03fd\tS\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0003S\u040f\bS\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0003S\u0428\bS\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001S\u0001"+
		"S\u0005S\u0454\bS\nS\fS\u0457\tS\u0001T\u0001T\u0001T\u0001T\u0003T\u045d"+
		"\bT\u0001U\u0001U\u0005U\u0461\bU\nU\fU\u0464\tU\u0001U\u0003U\u0467\b"+
		"U\u0001U\u0005U\u046a\bU\nU\fU\u046d\tU\u0001U\u0001U\u0001V\u0001V\u0001"+
		"V\u0005V\u0474\bV\nV\fV\u0477\tV\u0001V\u0004V\u047a\bV\u000bV\fV\u047b"+
		"\u0003V\u047e\bV\u0001V\u0005V\u0481\bV\nV\fV\u0484\tV\u0001V\u0003V\u0487"+
		"\bV\u0001V\u0005V\u048a\bV\nV\fV\u048d\tV\u0001W\u0001W\u0001W\u0001W"+
		"\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001"+
		"X\u0001X\u0001X\u0003X\u049f\bX\u0001Y\u0005Y\u04a2\bY\nY\fY\u04a5\tY"+
		"\u0001Y\u0001Y\u0001Y\u0005Y\u04aa\bY\nY\fY\u04ad\tY\u0001Y\u0004Y\u04b0"+
		"\bY\u000bY\fY\u04b1\u0003Y\u04b4\bY\u0001Y\u0005Y\u04b7\bY\nY\fY\u04ba"+
		"\tY\u0001Y\u0003Y\u04bd\bY\u0001Y\u0005Y\u04c0\bY\nY\fY\u04c3\tY\u0001"+
		"Z\u0001Z\u0003Z\u04c7\bZ\u0001[\u0001[\u0001[\u0005[\u04cc\b[\n[\f[\u04cf"+
		"\t[\u0001\\\u0001\\\u0001\\\u0005\\\u04d4\b\\\n\\\f\\\u04d7\t\\\u0001"+
		"\\\u0000\u0001\u00a6]\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8"+
		"\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u0000\u0016\u0002\u0000"+
		"\f\f\u0018\u0018\u0002\u0000==PP\u0001\u0000\u001e\u001f\u0003\u0000\u0001"+
		"\u0001AB[[\u0001\u0000\u0004\b\u0002\u0000GHVY\u0005\u0000\f\r\u001d\u001d"+
		"\u001f!$&CC\u0004\u0000\u000f\u0012\'\':<CC\u0001\u0000:<\t\u0000\u0002"+
		"\b\u001a\u001c\u001f\u001f!%CEITV]``bb\b\u0000\u0002\b\u001a\u001d\u001f"+
		"&CDITV]``bb\u0002\u0000CCEE\u0002\u0000\u001f\u001fCC\u0001\u0000:;\u0001"+
		"\u0000$%\u0001\u0000\"#\u0002\u0000\n\n\u001a\u001b\u0001\u0000XY\u0002"+
		"\u0000GHVW\u0001\u0000QR\u0002\u0000IIST\u0002\u0000QRZZ\u0549\u0000\u00bd"+
		"\u0001\u0000\u0000\u0000\u0002\u00c5\u0001\u0000\u0000\u0000\u0004\u00cb"+
		"\u0001\u0000\u0000\u0000\u0006\u00cf\u0001\u0000\u0000\u0000\b\u00ea\u0001"+
		"\u0000\u0000\u0000\n\u00ec\u0001\u0000\u0000\u0000\f\u00f0\u0001\u0000"+
		"\u0000\u0000\u000e\u00fb\u0001\u0000\u0000\u0000\u0010\u0100\u0001\u0000"+
		"\u0000\u0000\u0012\u0114\u0001\u0000\u0000\u0000\u0014\u0116\u0001\u0000"+
		"\u0000\u0000\u0016\u012e\u0001\u0000\u0000\u0000\u0018\u0130\u0001\u0000"+
		"\u0000\u0000\u001a\u017c\u0001\u0000\u0000\u0000\u001c\u017e\u0001\u0000"+
		"\u0000\u0000\u001e\u018c\u0001\u0000\u0000\u0000 \u018e\u0001\u0000\u0000"+
		"\u0000\"\u0191\u0001\u0000\u0000\u0000$\u0194\u0001\u0000\u0000\u0000"+
		"&\u0198\u0001\u0000\u0000\u0000(\u01ab\u0001\u0000\u0000\u0000*\u01bf"+
		"\u0001\u0000\u0000\u0000,\u01e2\u0001\u0000\u0000\u0000.\u01e4\u0001\u0000"+
		"\u0000\u00000\u01fa\u0001\u0000\u0000\u00002\u0235\u0001\u0000\u0000\u0000"+
		"4\u0237\u0001\u0000\u0000\u00006\u0240\u0001\u0000\u0000\u00008\u0242"+
		"\u0001\u0000\u0000\u0000:\u0244\u0001\u0000\u0000\u0000<\u024b\u0001\u0000"+
		"\u0000\u0000>\u0255\u0001\u0000\u0000\u0000@\u0263\u0001\u0000\u0000\u0000"+
		"B\u0265\u0001\u0000\u0000\u0000D\u027c\u0001\u0000\u0000\u0000F\u0282"+
		"\u0001\u0000\u0000\u0000H\u0293\u0001\u0000\u0000\u0000J\u0296\u0001\u0000"+
		"\u0000\u0000L\u029a\u0001\u0000\u0000\u0000N\u029c\u0001\u0000\u0000\u0000"+
		"P\u02a3\u0001\u0000\u0000\u0000R\u02af\u0001\u0000\u0000\u0000T\u02b1"+
		"\u0001\u0000\u0000\u0000V\u02b6\u0001\u0000\u0000\u0000X\u02ba\u0001\u0000"+
		"\u0000\u0000Z\u02bc\u0001\u0000\u0000\u0000\\\u02c0\u0001\u0000\u0000"+
		"\u0000^\u02c6\u0001\u0000\u0000\u0000`\u02cc\u0001\u0000\u0000\u0000b"+
		"\u02ce\u0001\u0000\u0000\u0000d\u02d9\u0001\u0000\u0000\u0000f\u02dc\u0001"+
		"\u0000\u0000\u0000h\u02df\u0001\u0000\u0000\u0000j\u02e3\u0001\u0000\u0000"+
		"\u0000l\u02e9\u0001\u0000\u0000\u0000n\u02ef\u0001\u0000\u0000\u0000p"+
		"\u02f6\u0001\u0000\u0000\u0000r\u02fc\u0001\u0000\u0000\u0000t\u0301\u0001"+
		"\u0000\u0000\u0000v\u0306\u0001\u0000\u0000\u0000x\u0308\u0001\u0000\u0000"+
		"\u0000z\u030a\u0001\u0000\u0000\u0000|\u0314\u0001\u0000\u0000\u0000~"+
		"\u031c\u0001\u0000\u0000\u0000\u0080\u031e\u0001\u0000\u0000\u0000\u0082"+
		"\u0328\u0001\u0000\u0000\u0000\u0084\u0331\u0001\u0000\u0000\u0000\u0086"+
		"\u0336\u0001\u0000\u0000\u0000\u0088\u033b\u0001\u0000\u0000\u0000\u008a"+
		"\u0358\u0001\u0000\u0000\u0000\u008c\u0362\u0001\u0000\u0000\u0000\u008e"+
		"\u036b\u0001\u0000\u0000\u0000\u0090\u0378\u0001\u0000\u0000\u0000\u0092"+
		"\u037a\u0001\u0000\u0000\u0000\u0094\u037c\u0001\u0000\u0000\u0000\u0096"+
		"\u0384\u0001\u0000\u0000\u0000\u0098\u0392\u0001\u0000\u0000\u0000\u009a"+
		"\u039a\u0001\u0000\u0000\u0000\u009c\u03a2\u0001\u0000\u0000\u0000\u009e"+
		"\u03aa\u0001\u0000\u0000\u0000\u00a0\u03b2\u0001\u0000\u0000\u0000\u00a2"+
		"\u03ba\u0001\u0000\u0000\u0000\u00a4\u03c2\u0001\u0000\u0000\u0000\u00a6"+
		"\u0427\u0001\u0000\u0000\u0000\u00a8\u0458\u0001\u0000\u0000\u0000\u00aa"+
		"\u045e\u0001\u0000\u0000\u0000\u00ac\u0470\u0001\u0000\u0000\u0000\u00ae"+
		"\u048e\u0001\u0000\u0000\u0000\u00b0\u049e\u0001\u0000\u0000\u0000\u00b2"+
		"\u04a3\u0001\u0000\u0000\u0000\u00b4\u04c6\u0001\u0000\u0000\u0000\u00b6"+
		"\u04c8\u0001\u0000\u0000\u0000\u00b8\u04d0\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0003\u0002\u0001\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf"+
		"\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005\u0000\u0000\u0001\u00c1"+
		"\u0001\u0001\u0000\u0000\u0000\u00c2\u00c6\u00032\u0019\u0000\u00c3\u00c6"+
		"\u0003\u0004\u0002\u0000\u00c4\u00c6\u0003\f\u0006\u0000\u00c5\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c5\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c6\u0003\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003"+
		"\u0006\u0003\u0000\u00c8\u00c9\u0005^\u0000\u0000\u00c9\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cc\u0005^\u0000\u0000\u00cb\u00c7\u0001\u0000\u0000"+
		"\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc\u0005\u0001\u0000\u0000"+
		"\u0000\u00cd\u00d0\u0003\b\u0004\u0000\u00ce\u00d0\u0003\u001e\u000f\u0000"+
		"\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d0\u0007\u0001\u0000\u0000\u0000\u00d1\u00eb\u0003\u0010\b\u0000\u00d2"+
		"\u00eb\u0003\u0080@\u0000\u00d3\u00eb\u0003 \u0010\u0000\u00d4\u00eb\u0003"+
		"\"\u0011\u0000\u00d5\u00eb\u0003$\u0012\u0000\u00d6\u00eb\u0003\u0082"+
		"A\u0000\u00d7\u00eb\u0003d2\u0000\u00d8\u00eb\u0003\u008eG\u0000\u00d9"+
		"\u00eb\u0003\u0084B\u0000\u00da\u00eb\u0003\u0086C\u0000\u00db\u00eb\u0003"+
		"(\u0014\u0000\u00dc\u00eb\u0003*\u0015\u0000\u00dd\u00eb\u0003,\u0016"+
		"\u0000\u00de\u00eb\u0003l6\u0000\u00df\u00eb\u0003v;\u0000\u00e0\u00eb"+
		"\u0003x<\u0000\u00e1\u00eb\u0003\u0092I\u0000\u00e2\u00eb\u0003Z-\u0000"+
		"\u00e3\u00eb\u0003\\.\u0000\u00e4\u00eb\u0003r9\u0000\u00e5\u00eb\u0003"+
		"t:\u0000\u00e6\u00eb\u0003^/\u0000\u00e7\u00eb\u0003\u000e\u0007\u0000"+
		"\u00e8\u00eb\u0003\u001c\u000e\u0000\u00e9\u00eb\u0003\n\u0005\u0000\u00ea"+
		"\u00d1\u0001\u0000\u0000\u0000\u00ea\u00d2\u0001\u0000\u0000\u0000\u00ea"+
		"\u00d3\u0001\u0000\u0000\u0000\u00ea\u00d4\u0001\u0000\u0000\u0000\u00ea"+
		"\u00d5\u0001\u0000\u0000\u0000\u00ea\u00d6\u0001\u0000\u0000\u0000\u00ea"+
		"\u00d7\u0001\u0000\u0000\u0000\u00ea\u00d8\u0001\u0000\u0000\u0000\u00ea"+
		"\u00d9\u0001\u0000\u0000\u0000\u00ea\u00da\u0001\u0000\u0000\u0000\u00ea"+
		"\u00db\u0001\u0000\u0000\u0000\u00ea\u00dc\u0001\u0000\u0000\u0000\u00ea"+
		"\u00dd\u0001\u0000\u0000\u0000\u00ea\u00de\u0001\u0000\u0000\u0000\u00ea"+
		"\u00df\u0001\u0000\u0000\u0000\u00ea\u00e0\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e1\u0001\u0000\u0000\u0000\u00ea\u00e2\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e3\u0001\u0000\u0000\u0000\u00ea\u00e4\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e5\u0001\u0000\u0000\u0000\u00ea\u00e6\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e7\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e9\u0001\u0000\u0000\u0000\u00eb\t\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0005\u000e\u0000\u0000\u00ed\u00ee\u0005]\u0000\u0000\u00ee\u00ef\u0003"+
		"\u0006\u0003\u0000\u00ef\u000b\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005"+
		"\u000e\u0000\u0000\u00f1\u00f2\u0005]\u0000\u0000\u00f2\u00f3\u0005^\u0000"+
		"\u0000\u00f3\u00f5\u0005A\u0000\u0000\u00f4\u00f6\u0003\u0002\u0001\u0000"+
		"\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005B\u0000\u0000\u00fa"+
		"\r\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005C\u0000\u0000\u00fc\u00fd"+
		"\u0007\u0000\u0000\u0000\u00fd\u00fe\u0005]\u0000\u0000\u00fe\u00ff\u0003"+
		"\u0012\t\u0000\u00ff\u000f\u0001\u0000\u0000\u0000\u0100\u0101\u0003z"+
		"=\u0000\u0101\u0102\u0007\u0001\u0000\u0000\u0102\u0103\u0007\u0002\u0000"+
		"\u0000\u0103\u0105\u0005L\u0000\u0000\u0104\u0106\u0003\u00b8\\\u0000"+
		"\u0105\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0005M\u0000\u0000\u0108"+
		"\u0109\u0005]\u0000\u0000\u0109\u010a\u0003\u0090H\u0000\u010a\u0011\u0001"+
		"\u0000\u0000\u0000\u010b\u010d\u0003\u0014\n\u0000\u010c\u010e\u0005\u0001"+
		"\u0000\u0000\u010d\u010c\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e\u0115\u0001\u0000\u0000\u0000\u010f\u0110\u0005^\u0000"+
		"\u0000\u0110\u0111\u0005A\u0000\u0000\u0111\u0112\u0003\u0018\f\u0000"+
		"\u0112\u0113\u0005B\u0000\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114"+
		"\u010b\u0001\u0000\u0000\u0000\u0114\u010f\u0001\u0000\u0000\u0000\u0115"+
		"\u0013\u0001\u0000\u0000\u0000\u0116\u011b\u0003\u0016\u000b\u0000\u0117"+
		"\u0118\u0005[\u0000\u0000\u0118\u011a\u0003\u0016\u000b\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u0015"+
		"\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e\u011f"+
		"\u0005C\u0000\u0000\u011f\u0120\u0005P\u0000\u0000\u0120\u012f\u0003\u0092"+
		"I\u0000\u0121\u0122\u0005C\u0000\u0000\u0122\u0123\u0007\u0000\u0000\u0000"+
		"\u0123\u0124\u0005]\u0000\u0000\u0124\u012f\u0003\u0012\t\u0000\u0125"+
		"\u0126\u0007\u0002\u0000\u0000\u0126\u0127\u0005C\u0000\u0000\u0127\u0129"+
		"\u0005L\u0000\u0000\u0128\u012a\u0003\u00b8\\\u0000\u0129\u0128\u0001"+
		"\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b\u0001"+
		"\u0000\u0000\u0000\u012b\u012c\u0005M\u0000\u0000\u012c\u012d\u0005]\u0000"+
		"\u0000\u012d\u012f\u0003\u0092I\u0000\u012e\u011e\u0001\u0000\u0000\u0000"+
		"\u012e\u0121\u0001\u0000\u0000\u0000\u012e\u0125\u0001\u0000\u0000\u0000"+
		"\u012f\u0017\u0001\u0000\u0000\u0000\u0130\u0146\u0003\u001a\r\u0000\u0131"+
		"\u0133\u0005^\u0000\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0133\u0136"+
		"\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0001\u0000\u0000\u0000\u0135\u013a\u0001\u0000\u0000\u0000\u0136\u0134"+
		"\u0001\u0000\u0000\u0000\u0137\u0139\u0007\u0003\u0000\u0000\u0138\u0137"+
		"\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000\u013a\u0138"+
		"\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u0140"+
		"\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u013f"+
		"\u0005^\u0000\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f\u0142\u0001"+
		"\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001"+
		"\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001"+
		"\u0000\u0000\u0000\u0143\u0145\u0003\u001a\r\u0000\u0144\u0134\u0001\u0000"+
		"\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u014c\u0001\u0000"+
		"\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u014b\u0005^\u0000"+
		"\u0000\u014a\u0149\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000"+
		"\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000"+
		"\u0000\u014d\u0152\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000"+
		"\u0000\u014f\u0151\u0007\u0003\u0000\u0000\u0150\u014f\u0001\u0000\u0000"+
		"\u0000\u0151\u0154\u0001\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000"+
		"\u0000\u0152\u0153\u0001\u0000\u0000\u0000\u0153\u0158\u0001\u0000\u0000"+
		"\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0155\u0157\u0005^\u0000\u0000"+
		"\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000"+
		"\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000"+
		"\u0159\u0019\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0005C\u0000\u0000\u015c\u015d\u0005P\u0000\u0000\u015d\u017d"+
		"\u0003\u0092I\u0000\u015e\u015f\u0005C\u0000\u0000\u015f\u0160\u0007\u0000"+
		"\u0000\u0000\u0160\u0161\u0005]\u0000\u0000\u0161\u0162\u0005^\u0000\u0000"+
		"\u0162\u0163\u0005A\u0000\u0000\u0163\u0164\u0003\u0018\f\u0000\u0164"+
		"\u0165\u0005B\u0000\u0000\u0165\u017d\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0005C\u0000\u0000\u0167\u0168\u0007\u0000\u0000\u0000\u0168\u0169\u0005"+
		"]\u0000\u0000\u0169\u017d\u0005\u0001\u0000\u0000\u016a\u016b\u0005C\u0000"+
		"\u0000\u016b\u016c\u0007\u0000\u0000\u0000\u016c\u016d\u0005]\u0000\u0000"+
		"\u016d\u016f\u0003\u0014\n\u0000\u016e\u0170\u0005\u0001\u0000\u0000\u016f"+
		"\u016e\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170"+
		"\u017d\u0001\u0000\u0000\u0000\u0171\u0173\u0007\u0002\u0000\u0000\u0172"+
		"\u0171\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173"+
		"\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0005C\u0000\u0000\u0175\u0177"+
		"\u0005L\u0000\u0000\u0176\u0178\u0003\u00b8\\\u0000\u0177\u0176\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178\u0179\u0001"+
		"\u0000\u0000\u0000\u0179\u017a\u0005M\u0000\u0000\u017a\u017b\u0005]\u0000"+
		"\u0000\u017b\u017d\u0003\u0090H\u0000\u017c\u015b\u0001\u0000\u0000\u0000"+
		"\u017c\u015e\u0001\u0000\u0000\u0000\u017c\u0166\u0001\u0000\u0000\u0000"+
		"\u017c\u016a\u0001\u0000\u0000\u0000\u017c\u0172\u0001\u0000\u0000\u0000"+
		"\u017d\u001b\u0001\u0000\u0000\u0000\u017e\u017f\u00050\u0000\u0000\u017f"+
		"\u0184\u0005C\u0000\u0000\u0180\u0181\u0005[\u0000\u0000\u0181\u0183\u0005"+
		"C\u0000\u0000\u0182\u0180\u0001\u0000\u0000\u0000\u0183\u0186\u0001\u0000"+
		"\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000"+
		"\u0000\u0000\u0185\u001d\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000"+
		"\u0000\u0000\u0187\u018d\u0003\u008aE\u0000\u0188\u018d\u0003j5\u0000"+
		"\u0189\u018d\u0003\u0088D\u0000\u018a\u018d\u0003n7\u0000\u018b\u018d"+
		"\u0003p8\u0000\u018c\u0187\u0001\u0000\u0000\u0000\u018c\u0188\u0001\u0000"+
		"\u0000\u0000\u018c\u0189\u0001\u0000\u0000\u0000\u018c\u018a\u0001\u0000"+
		"\u0000\u0000\u018c\u018b\u0001\u0000\u0000\u0000\u018d\u001f\u0001\u0000"+
		"\u0000\u0000\u018e\u018f\u0003z=\u0000\u018f\u0190\u0005\u0002\u0000\u0000"+
		"\u0190!\u0001\u0000\u0000\u0000\u0191\u0192\u0003z=\u0000\u0192\u0193"+
		"\u0005\u0003\u0000\u0000\u0193#\u0001\u0000\u0000\u0000\u0194\u0195\u0003"+
		"z=\u0000\u0195\u0196\u0003&\u0013\u0000\u0196\u0197\u0003\u0092I\u0000"+
		"\u0197%\u0001\u0000\u0000\u0000\u0198\u0199\u0007\u0004\u0000\u0000\u0199"+
		"\'\u0001\u0000\u0000\u0000\u019a\u019b\u0005C\u0000\u0000\u019b\u019c"+
		"\u0005P\u0000\u0000\u019c\u019e\u0005N\u0000\u0000\u019d\u019f\u0003\u00b2"+
		"Y\u0000\u019e\u019d\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000"+
		"\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a1\u0005O\u0000\u0000"+
		"\u01a1\u01ac\u0005\u0014\u0000\u0000\u01a2\u01a3\u0005C\u0000\u0000\u01a3"+
		"\u01a4\u0005P\u0000\u0000\u01a4\u01a5\u0005C\u0000\u0000\u01a5\u01ac\u0005"+
		"\u0014\u0000\u0000\u01a6\u01a7\u0005C\u0000\u0000\u01a7\u01a8\u0005P\u0000"+
		"\u0000\u01a8\u01a9\u0003\u00a6S\u0000\u01a9\u01aa\u0005\u0014\u0000\u0000"+
		"\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u019a\u0001\u0000\u0000\u0000"+
		"\u01ab\u01a2\u0001\u0000\u0000\u0000\u01ab\u01a6\u0001\u0000\u0000\u0000"+
		"\u01ac)\u0001\u0000\u0000\u0000\u01ad\u01ae\u0005\u0013\u0000\u0000\u01ae"+
		"\u01c0\u0005C\u0000\u0000\u01af\u01b0\u0005\u0013\u0000\u0000\u01b0\u01b1"+
		"\u0005C\u0000\u0000\u01b1\u01c0\u0005\u0015\u0000\u0000\u01b2\u01b3\u0005"+
		"\u0013\u0000\u0000\u01b3\u01b4\u0005C\u0000\u0000\u01b4\u01b5\u0005?\u0000"+
		"\u0000\u01b5\u01b6\u0005C\u0000\u0000\u01b6\u01c0\u0005\u0015\u0000\u0000"+
		"\u01b7\u01b8\u0005\u0013\u0000\u0000\u01b8\u01b9\u0005C\u0000\u0000\u01b9"+
		"\u01ba\u0005?\u0000\u0000\u01ba\u01bb\u0005C\u0000\u0000\u01bb\u01c0\u0005"+
		"\u0016\u0000\u0000\u01bc\u01bd\u0005\u0013\u0000\u0000\u01bd\u01be\u0005"+
		"C\u0000\u0000\u01be\u01c0\u0005\u0016\u0000\u0000\u01bf\u01ad\u0001\u0000"+
		"\u0000\u0000\u01bf\u01af\u0001\u0000\u0000\u0000\u01bf\u01b2\u0001\u0000"+
		"\u0000\u0000\u01bf\u01b7\u0001\u0000\u0000\u0000\u01bf\u01bc\u0001\u0000"+
		"\u0000\u0000\u01c0+\u0001\u0000\u0000\u0000\u01c1\u01c2\u0005%\u0000\u0000"+
		"\u01c2\u01c3\u0005C\u0000\u0000\u01c3\u01c4\u0005\u0018\u0000\u0000\u01c4"+
		"\u01c5\u0005C\u0000\u0000\u01c5\u01c6\u00030\u0018\u0000\u01c6\u01c7\u0003"+
		"\u0092I\u0000\u01c7\u01e3\u0001\u0000\u0000\u0000\u01c8\u01c9\u0005%\u0000"+
		"\u0000\u01c9\u01ca\u0005\u0018\u0000\u0000\u01ca\u01cb\u0005C\u0000\u0000"+
		"\u01cb\u01cc\u00030\u0018\u0000\u01cc\u01cd\u0003\u0092I\u0000\u01cd\u01ce"+
		"\u0005&\u0000\u0000\u01ce\u01cf\u0005C\u0000\u0000\u01cf\u01e3\u0001\u0000"+
		"\u0000\u0000\u01d0\u01d1\u0005%\u0000\u0000\u01d1\u01d2\u0005\u0018\u0000"+
		"\u0000\u01d2\u01d3\u00030\u0018\u0000\u01d3\u01d4\u0003\u0092I\u0000\u01d4"+
		"\u01d5\u0005&\u0000\u0000\u01d5\u01d6\u0005C\u0000\u0000\u01d6\u01e3\u0001"+
		"\u0000\u0000\u0000\u01d7\u01d8\u0005%\u0000\u0000\u01d8\u01d9\u0003\u0092"+
		"I\u0000\u01d9\u01da\u0005&\u0000\u0000\u01da\u01db\u0005C\u0000\u0000"+
		"\u01db\u01e3\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005%\u0000\u0000\u01dd"+
		"\u01de\u0005\u0018\u0000\u0000\u01de\u01df\u0003.\u0017\u0000\u01df\u01e0"+
		"\u0005&\u0000\u0000\u01e0\u01e1\u0005C\u0000\u0000\u01e1\u01e3\u0001\u0000"+
		"\u0000\u0000\u01e2\u01c1\u0001\u0000\u0000\u0000\u01e2\u01c8\u0001\u0000"+
		"\u0000\u0000\u01e2\u01d0\u0001\u0000\u0000\u0000\u01e2\u01d7\u0001\u0000"+
		"\u0000\u0000\u01e2\u01dc\u0001\u0000\u0000\u0000\u01e3-\u0001\u0000\u0000"+
		"\u0000\u01e4\u01e5\u0005C\u0000\u0000\u01e5\u01e6\u00030\u0018\u0000\u01e6"+
		"\u01f7\u0003\u0092I\u0000\u01e7\u01e8\u0005\r\u0000\u0000\u01e8\u01f0"+
		"\u0005 \u0000\u0000\u01e9\u01f0\u0005\r\u0000\u0000\u01ea\u01f0\u0005"+
		"\u001c\u0000\u0000\u01eb\u01f0\u0005\u000b\u0000\u0000\u01ec\u01f0\u0005"+
		"\u001a\u0000\u0000\u01ed\u01f0\u0005\u001b\u0000\u0000\u01ee\u01f0\u0005"+
		"\n\u0000\u0000\u01ef\u01e7\u0001\u0000\u0000\u0000\u01ef\u01e9\u0001\u0000"+
		"\u0000\u0000\u01ef\u01ea\u0001\u0000\u0000\u0000\u01ef\u01eb\u0001\u0000"+
		"\u0000\u0000\u01ef\u01ec\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001\u0000"+
		"\u0000\u0000\u01ef\u01ee\u0001\u0000\u0000\u0000\u01f0\u01f1\u0001\u0000"+
		"\u0000\u0000\u01f1\u01f2\u0005C\u0000\u0000\u01f2\u01f3\u00030\u0018\u0000"+
		"\u01f3\u01f4\u0003\u0092I\u0000\u01f4\u01f6\u0001\u0000\u0000\u0000\u01f5"+
		"\u01ef\u0001\u0000\u0000\u0000\u01f6\u01f9\u0001\u0000\u0000\u0000\u01f7"+
		"\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8"+
		"/\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fb"+
		"\u0007\u0005\u0000\u0000\u01fb1\u0001\u0000\u0000\u0000\u01fc\u01fd\u0005"+
		"G\u0000\u0000\u01fd\u0203\u00034\u001a\u0000\u01fe\u0202\u0005`\u0000"+
		"\u0000\u01ff\u0202\u00036\u001b\u0000\u0200\u0202\u0005^\u0000\u0000\u0201"+
		"\u01fe\u0001\u0000\u0000\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0201"+
		"\u0200\u0001\u0000\u0000\u0000\u0202\u0205\u0001\u0000\u0000\u0000\u0203"+
		"\u0201\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000\u0204"+
		"\u0206\u0001\u0000\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0206"+
		"\u0207\u0005H\u0000\u0000\u0207\u0208\u0003<\u001e\u0000\u0208\u0209\u0005"+
		"G\u0000\u0000\u0209\u020a\u0005I\u0000\u0000\u020a\u020b\u00034\u001a"+
		"\u0000\u020b\u020f\u0005H\u0000\u0000\u020c\u020e\u0005^\u0000\u0000\u020d"+
		"\u020c\u0001\u0000\u0000\u0000\u020e\u0211\u0001\u0000\u0000\u0000\u020f"+
		"\u020d\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000\u0000\u0210"+
		"\u0236\u0001\u0000\u0000\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0212"+
		"\u0213\u0005G\u0000\u0000\u0213\u0219\u00034\u001a\u0000\u0214\u0218\u0003"+
		"6\u001b\u0000\u0215\u0218\u0005`\u0000\u0000\u0216\u0218\u0005^\u0000"+
		"\u0000\u0217\u0214\u0001\u0000\u0000\u0000\u0217\u0215\u0001\u0000\u0000"+
		"\u0000\u0217\u0216\u0001\u0000\u0000\u0000\u0218\u021b\u0001\u0000\u0000"+
		"\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000"+
		"\u0000\u021a\u021c\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000"+
		"\u0000\u021c\u021d\u0005I\u0000\u0000\u021d\u0221\u0005H\u0000\u0000\u021e"+
		"\u0220\u0005^\u0000\u0000\u021f\u021e\u0001\u0000\u0000\u0000\u0220\u0223"+
		"\u0001\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221\u0222"+
		"\u0001\u0000\u0000\u0000\u0222\u0236\u0001\u0000\u0000\u0000\u0223\u0221"+
		"\u0001\u0000\u0000\u0000\u0224\u0225\u0005G\u0000\u0000\u0225\u022b\u0003"+
		"4\u001a\u0000\u0226\u022a\u00036\u001b\u0000\u0227\u022a\u0005`\u0000"+
		"\u0000\u0228\u022a\u0005^\u0000\u0000\u0229\u0226\u0001\u0000\u0000\u0000"+
		"\u0229\u0227\u0001\u0000\u0000\u0000\u0229\u0228\u0001\u0000\u0000\u0000"+
		"\u022a\u022d\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000"+
		"\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u022e\u0001\u0000\u0000\u0000"+
		"\u022d\u022b\u0001\u0000\u0000\u0000\u022e\u0232\u0005H\u0000\u0000\u022f"+
		"\u0231\u0005^\u0000\u0000\u0230\u022f\u0001\u0000\u0000\u0000\u0231\u0234"+
		"\u0001\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0232\u0233"+
		"\u0001\u0000\u0000\u0000\u0233\u0236\u0001\u0000\u0000\u0000\u0234\u0232"+
		"\u0001\u0000\u0000\u0000\u0235\u01fc\u0001\u0000\u0000\u0000\u0235\u0212"+
		"\u0001\u0000\u0000\u0000\u0235\u0224\u0001\u0000\u0000\u0000\u02363\u0001"+
		"\u0000\u0000\u0000\u0237\u0238\u0007\u0006\u0000\u0000\u02385\u0001\u0000"+
		"\u0000\u0000\u0239\u023a\u00038\u001c\u0000\u023a\u023d\u0005P\u0000\u0000"+
		"\u023b\u023e\u0005E\u0000\u0000\u023c\u023e\u0003T*\u0000\u023d\u023b"+
		"\u0001\u0000\u0000\u0000\u023d\u023c\u0001\u0000\u0000\u0000\u023e\u0241"+
		"\u0001\u0000\u0000\u0000\u023f\u0241\u0003:\u001d\u0000\u0240\u0239\u0001"+
		"\u0000\u0000\u0000\u0240\u023f\u0001\u0000\u0000\u0000\u02417\u0001\u0000"+
		"\u0000\u0000\u0242\u0243\u0007\u0007\u0000\u0000\u02439\u0001\u0000\u0000"+
		"\u0000\u0244\u0245\u0007\b\u0000\u0000\u0245\u0246\u0005P\u0000\u0000"+
		"\u0246\u0247\u0003T*\u0000\u0247;\u0001\u0000\u0000\u0000\u0248\u024a"+
		"\u0003>\u001f\u0000\u0249\u0248\u0001\u0000\u0000\u0000\u024a\u024d\u0001"+
		"\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024b\u024c\u0001"+
		"\u0000\u0000\u0000\u024c=\u0001\u0000\u0000\u0000\u024d\u024b\u0001\u0000"+
		"\u0000\u0000\u024e\u0256\u00032\u0019\u0000\u024f\u0256\u0003@ \u0000"+
		"\u0250\u0256\u0003T*\u0000\u0251\u0256\u0003V+\u0000\u0252\u0256\u0005"+
		"^\u0000\u0000\u0253\u0256\u0005A\u0000\u0000\u0254\u0256\u0005B\u0000"+
		"\u0000\u0255\u024e\u0001\u0000\u0000\u0000\u0255\u024f\u0001\u0000\u0000"+
		"\u0000\u0255\u0250\u0001\u0000\u0000\u0000\u0255\u0251\u0001\u0000\u0000"+
		"\u0000\u0255\u0252\u0001\u0000\u0000\u0000\u0255\u0253\u0001\u0000\u0000"+
		"\u0000\u0255\u0254\u0001\u0000\u0000\u0000\u0256?\u0001\u0000\u0000\u0000"+
		"\u0257\u0258\u0005J\u0000\u0000\u0258\u0259\u0003B!\u0000\u0259\u025a"+
		"\u0005K\u0000\u0000\u025a\u0264\u0001\u0000\u0000\u0000\u025b\u025c\u0005"+
		"J\u0000\u0000\u025c\u025d\u0003N\'\u0000\u025d\u025e\u0005K\u0000\u0000"+
		"\u025e\u0264\u0001\u0000\u0000\u0000\u025f\u0260\u0005J\u0000\u0000\u0260"+
		"\u0261\u0003P(\u0000\u0261\u0262\u0005K\u0000\u0000\u0262\u0264\u0001"+
		"\u0000\u0000\u0000\u0263\u0257\u0001\u0000\u0000\u0000\u0263\u025b\u0001"+
		"\u0000\u0000\u0000\u0263\u025f\u0001\u0000\u0000\u0000\u0264A\u0001\u0000"+
		"\u0000\u0000\u0265\u0266\u0005\r\u0000\u0000\u0266\u0267\u0003\u0092I"+
		"\u0000\u0267\u0268\u0005]\u0000\u0000\u0268\u0271\u0003D\"\u0000\u0269"+
		"\u026a\u0005\r\u0000\u0000\u026a\u026b\u0005 \u0000\u0000\u026b\u026c"+
		"\u0003\u0092I\u0000\u026c\u026d\u0005]\u0000\u0000\u026d\u026e\u0003D"+
		"\"\u0000\u026e\u0270\u0001\u0000\u0000\u0000\u026f\u0269\u0001\u0000\u0000"+
		"\u0000\u0270\u0273\u0001\u0000\u0000\u0000\u0271\u026f\u0001\u0000\u0000"+
		"\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u0272\u0277\u0001\u0000\u0000"+
		"\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0274\u0275\u0005\u001d\u0000"+
		"\u0000\u0275\u0276\u0005]\u0000\u0000\u0276\u0278\u0003F#\u0000\u0277"+
		"\u0274\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278"+
		"C\u0001\u0000\u0000\u0000\u0279\u027b\u0003H$\u0000\u027a\u0279\u0001"+
		"\u0000\u0000\u0000\u027b\u027e\u0001\u0000\u0000\u0000\u027c\u027a\u0001"+
		"\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027dE\u0001\u0000"+
		"\u0000\u0000\u027e\u027c\u0001\u0000\u0000\u0000\u027f\u0281\u0003H$\u0000"+
		"\u0280\u027f\u0001\u0000\u0000\u0000\u0281\u0284\u0001\u0000\u0000\u0000"+
		"\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000"+
		"\u0283G\u0001\u0000\u0000\u0000\u0284\u0282\u0001\u0000\u0000\u0000\u0285"+
		"\u0294\u00032\u0019\u0000\u0286\u0287\u0005J\u0000\u0000\u0287\u0288\u0003"+
		"N\'\u0000\u0288\u0289\u0005K\u0000\u0000\u0289\u0294\u0001\u0000\u0000"+
		"\u0000\u028a\u028b\u0005J\u0000\u0000\u028b\u028c\u0003B!\u0000\u028c"+
		"\u028d\u0005K\u0000\u0000\u028d\u0294\u0001\u0000\u0000\u0000\u028e\u0294"+
		"\u0003T*\u0000\u028f\u0294\u0003J%\u0000\u0290\u0294\u0005^\u0000\u0000"+
		"\u0291\u0294\u0005A\u0000\u0000\u0292\u0294\u0005B\u0000\u0000\u0293\u0285"+
		"\u0001\u0000\u0000\u0000\u0293\u0286\u0001\u0000\u0000\u0000\u0293\u028a"+
		"\u0001\u0000\u0000\u0000\u0293\u028e\u0001\u0000\u0000\u0000\u0293\u028f"+
		"\u0001\u0000\u0000\u0000\u0293\u0290\u0001\u0000\u0000\u0000\u0293\u0291"+
		"\u0001\u0000\u0000\u0000\u0293\u0292\u0001\u0000\u0000\u0000\u0294I\u0001"+
		"\u0000\u0000\u0000\u0295\u0297\u0003L&\u0000\u0296\u0295\u0001\u0000\u0000"+
		"\u0000\u0297\u0298\u0001\u0000\u0000\u0000\u0298\u0296\u0001\u0000\u0000"+
		"\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299K\u0001\u0000\u0000\u0000"+
		"\u029a\u029b\u0007\t\u0000\u0000\u029bM\u0001\u0000\u0000\u0000\u029c"+
		"\u029d\u0005\f\u0000\u0000\u029d\u029e\u0005C\u0000\u0000\u029e\u029f"+
		"\u0005&\u0000\u0000\u029f\u02a0\u0003\u00a6S\u0000\u02a0\u02a1\u0005]"+
		"\u0000\u0000\u02a1\u02a2\u0003F#\u0000\u02a2O\u0001\u0000\u0000\u0000"+
		"\u02a3\u02a4\u0005\r\u0000\u0000\u02a4\u02a5\u0003\u0092I\u0000\u02a5"+
		"\u02a6\u00057\u0000\u0000\u02a6\u02a7\u0005]\u0000\u0000\u02a7\u02a8\u0003"+
		"F#\u0000\u02a8Q\u0001\u0000\u0000\u0000\u02a9\u02b0\u0003<\u001e\u0000"+
		"\u02aa\u02ab\u0005^\u0000\u0000\u02ab\u02ac\u0005A\u0000\u0000\u02ac\u02ad"+
		"\u0003<\u001e\u0000\u02ad\u02ae\u0005B\u0000\u0000\u02ae\u02b0\u0001\u0000"+
		"\u0000\u0000\u02af\u02a9\u0001\u0000\u0000\u0000\u02af\u02aa\u0001\u0000"+
		"\u0000\u0000\u02b0S\u0001\u0000\u0000\u0000\u02b1\u02b2\u0005J\u0000\u0000"+
		"\u02b2\u02b3\u0003\u0092I\u0000\u02b3\u02b4\u0005K\u0000\u0000\u02b4U"+
		"\u0001\u0000\u0000\u0000\u02b5\u02b7\u0003X,\u0000\u02b6\u02b5\u0001\u0000"+
		"\u0000\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8\u02b6\u0001\u0000"+
		"\u0000\u0000\u02b8\u02b9\u0001\u0000\u0000\u0000\u02b9W\u0001\u0000\u0000"+
		"\u0000\u02ba\u02bb\u0007\n\u0000\u0000\u02bbY\u0001\u0000\u0000\u0000"+
		"\u02bc\u02bd\u00051\u0000\u0000\u02bd\u02be\u0005C\u0000\u0000\u02be\u02bf"+
		"\u0005E\u0000\u0000\u02bf[\u0001\u0000\u0000\u0000\u02c0\u02c1\u00052"+
		"\u0000\u0000\u02c1\u02c2\u0005C\u0000\u0000\u02c2\u02c3\u00053\u0000\u0000"+
		"\u02c3\u02c4\u0005&\u0000\u0000\u02c4\u02c5\u0005C\u0000\u0000\u02c5]"+
		"\u0001\u0000\u0000\u0000\u02c6\u02c7\u0005\u0017\u0000\u0000\u02c7\u02c8"+
		"\u0005C\u0000\u0000\u02c8\u02c9\u00053\u0000\u0000\u02c9\u02ca\u00054"+
		"\u0000\u0000\u02ca\u02cb\u0007\u000b\u0000\u0000\u02cb_\u0001\u0000\u0000"+
		"\u0000\u02cc\u02cd\u0007\f\u0000\u0000\u02cda\u0001\u0000\u0000\u0000"+
		"\u02ce\u02d3\u0003`0\u0000\u02cf\u02d0\u0005/\u0000\u0000\u02d0\u02d2"+
		"\u0003`0\u0000\u02d1\u02cf\u0001\u0000\u0000\u0000\u02d2\u02d5\u0001\u0000"+
		"\u0000\u0000\u02d3\u02d1\u0001\u0000\u0000\u0000\u02d3\u02d4\u0001\u0000"+
		"\u0000\u0000\u02d4\u02d6\u0001\u0000\u0000\u0000\u02d5\u02d3\u0001\u0000"+
		"\u0000\u0000\u02d6\u02d7\u0005/\u0000\u0000\u02d7\u02d8\u0003\u00a6S\u0000"+
		"\u02d8c\u0001\u0000\u0000\u0000\u02d9\u02da\u0005%\u0000\u0000\u02da\u02db"+
		"\u0003b1\u0000\u02dbe\u0001\u0000\u0000\u0000\u02dc\u02dd\u0005C\u0000"+
		"\u0000\u02dd\u02de\u0005C\u0000\u0000\u02deg\u0001\u0000\u0000\u0000\u02df"+
		"\u02e0\u0005C\u0000\u0000\u02e0\u02e1\u0005/\u0000\u0000\u02e1\u02e2\u0003"+
		"f3\u0000\u02e2i\u0001\u0000\u0000\u0000\u02e3\u02e4\u0005\r\u0000\u0000"+
		"\u02e4\u02e5\u0003f3\u0000\u02e5\u02e6\u0007\r\u0000\u0000\u02e6\u02e7"+
		"\u0005]\u0000\u0000\u02e7\u02e8\u0003\u0090H\u0000\u02e8k\u0001\u0000"+
		"\u0000\u0000\u02e9\u02ea\u0007\u000e\u0000\u0000\u02ea\u02eb\u0005\'\u0000"+
		"\u0000\u02eb\u02ec\u0005E\u0000\u0000\u02ec\u02ed\u0005,\u0000\u0000\u02ed"+
		"\u02ee\u0003f3\u0000\u02eem\u0001\u0000\u0000\u0000\u02ef\u02f0\u0005"+
		"\f\u0000\u0000\u02f0\u02f1\u0005C\u0000\u0000\u02f1\u02f2\u0005&\u0000"+
		"\u0000\u02f2\u02f3\u0003\u00a6S\u0000\u02f3\u02f4\u0005]\u0000\u0000\u02f4"+
		"\u02f5\u0003\u0090H\u0000\u02f5o\u0001\u0000\u0000\u0000\u02f6\u02f7\u0005"+
		"\r\u0000\u0000\u02f7\u02f8\u0003\u0092I\u0000\u02f8\u02f9\u00057\u0000"+
		"\u0000\u02f9\u02fa\u0005]\u0000\u0000\u02fa\u02fb\u0003\u0090H\u0000\u02fb"+
		"q\u0001\u0000\u0000\u0000\u02fc\u02fd\u0003\u00a6S\u0000\u02fd\u02fe\u0005"+
		"7\u0000\u0000\u02fe\u02ff\u0003\u0092I\u0000\u02ff\u0300\u00059\u0000"+
		"\u0000\u0300s\u0001\u0000\u0000\u0000\u0301\u0302\u0003\u00a6S\u0000\u0302"+
		"\u0303\u00058\u0000\u0000\u0303\u0304\u0003\u0092I\u0000\u0304\u0305\u0005"+
		"9\u0000\u0000\u0305u\u0001\u0000\u0000\u0000\u0306\u0307\u00055\u0000"+
		"\u0000\u0307w\u0001\u0000\u0000\u0000\u0308\u0309\u00056\u0000\u0000\u0309"+
		"y\u0001\u0000\u0000\u0000\u030a\u030e\u0003|>\u0000\u030b\u030d\u0003"+
		"~?\u0000\u030c\u030b\u0001\u0000\u0000\u0000\u030d\u0310\u0001\u0000\u0000"+
		"\u0000\u030e\u030c\u0001\u0000\u0000\u0000\u030e\u030f\u0001\u0000\u0000"+
		"\u0000\u030f{\u0001\u0000\u0000\u0000\u0310\u030e\u0001\u0000\u0000\u0000"+
		"\u0311\u0315\u0005C\u0000\u0000\u0312\u0315\u0003b1\u0000\u0313\u0315"+
		"\u0003h4\u0000\u0314\u0311\u0001\u0000\u0000\u0000\u0314\u0312\u0001\u0000"+
		"\u0000\u0000\u0314\u0313\u0001\u0000\u0000\u0000\u0315}\u0001\u0000\u0000"+
		"\u0000\u0316\u0317\u0005\\\u0000\u0000\u0317\u031d\u0005C\u0000\u0000"+
		"\u0318\u0319\u0005N\u0000\u0000\u0319\u031a\u0003\u0092I\u0000\u031a\u031b"+
		"\u0005O\u0000\u0000\u031b\u031d\u0001\u0000\u0000\u0000\u031c\u0316\u0001"+
		"\u0000\u0000\u0000\u031c\u0318\u0001\u0000\u0000\u0000\u031d\u007f\u0001"+
		"\u0000\u0000\u0000\u031e\u031f\u0003z=\u0000\u031f\u0323\u0007\u0001\u0000"+
		"\u0000\u0320\u0322\u0005^\u0000\u0000\u0321\u0320\u0001\u0000\u0000\u0000"+
		"\u0322\u0325\u0001\u0000\u0000\u0000\u0323\u0321\u0001\u0000\u0000\u0000"+
		"\u0323\u0324\u0001\u0000\u0000\u0000\u0324\u0326\u0001\u0000\u0000\u0000"+
		"\u0325\u0323\u0001\u0000\u0000\u0000\u0326\u0327\u0003\u0092I\u0000\u0327"+
		"\u0081\u0001\u0000\u0000\u0000\u0328\u0329\u0005!\u0000\u0000\u0329\u032e"+
		"\u0003\u0092I\u0000\u032a\u032b\u0005[\u0000\u0000\u032b\u032d\u0003\u0092"+
		"I\u0000\u032c\u032a\u0001\u0000\u0000\u0000\u032d\u0330\u0001\u0000\u0000"+
		"\u0000\u032e\u032c\u0001\u0000\u0000\u0000\u032e\u032f\u0001\u0000\u0000"+
		"\u0000\u032f\u0083\u0001\u0000\u0000\u0000\u0330\u032e\u0001\u0000\u0000"+
		"\u0000\u0331\u0332\u0005$\u0000\u0000\u0332\u0333\u0003\u0092I\u0000\u0333"+
		"\u0334\u0005&\u0000\u0000\u0334\u0335\u0003\u0092I\u0000\u0335\u0085\u0001"+
		"\u0000\u0000\u0000\u0336\u0337\u0005%\u0000\u0000\u0337\u0338\u0003\u0092"+
		"I\u0000\u0338\u0339\u0005&\u0000\u0000\u0339\u033a\u0005C\u0000\u0000"+
		"\u033a\u0087\u0001\u0000\u0000\u0000\u033b\u033c\u0005\r\u0000\u0000\u033c"+
		"\u033d\u0003\u0092I\u0000\u033d\u033e\u0005]\u0000\u0000\u033e\u034d\u0003"+
		"\u0090H\u0000\u033f\u0341\u0005^\u0000\u0000\u0340\u033f\u0001\u0000\u0000"+
		"\u0000\u0340\u0341\u0001\u0000\u0000\u0000\u0341\u0345\u0001\u0000\u0000"+
		"\u0000\u0342\u0343\u0005\r\u0000\u0000\u0343\u0346\u0005 \u0000\u0000"+
		"\u0344\u0346\u0005\r\u0000\u0000\u0345\u0342\u0001\u0000\u0000\u0000\u0345"+
		"\u0344\u0001\u0000\u0000\u0000\u0346\u0347\u0001\u0000\u0000\u0000\u0347"+
		"\u0348\u0003\u0092I\u0000\u0348\u0349\u0005]\u0000\u0000\u0349\u034a\u0003"+
		"\u0090H\u0000\u034a\u034c\u0001\u0000\u0000\u0000\u034b\u0340\u0001\u0000"+
		"\u0000\u0000\u034c\u034f\u0001\u0000\u0000\u0000\u034d\u034b\u0001\u0000"+
		"\u0000\u0000\u034d\u034e\u0001\u0000\u0000\u0000\u034e\u0356\u0001\u0000"+
		"\u0000\u0000\u034f\u034d\u0001\u0000\u0000\u0000\u0350\u0352\u0005^\u0000"+
		"\u0000\u0351\u0350\u0001\u0000\u0000\u0000\u0351\u0352\u0001\u0000\u0000"+
		"\u0000\u0352\u0353\u0001\u0000\u0000\u0000\u0353\u0354\u0005\u001d\u0000"+
		"\u0000\u0354\u0355\u0005]\u0000\u0000\u0355\u0357\u0003\u0090H\u0000\u0356"+
		"\u0351\u0001\u0000\u0000\u0000\u0356\u0357\u0001\u0000\u0000\u0000\u0357"+
		"\u0089\u0001\u0000\u0000\u0000\u0358\u0359\u0007\u0002\u0000\u0000\u0359"+
		"\u035a\u0005C\u0000\u0000\u035a\u035c\u0005L\u0000\u0000\u035b\u035d\u0003"+
		"\u00b8\\\u0000\u035c\u035b\u0001\u0000\u0000\u0000\u035c\u035d\u0001\u0000"+
		"\u0000\u0000\u035d\u035e\u0001\u0000\u0000\u0000\u035e\u035f\u0005M\u0000"+
		"\u0000\u035f\u0360\u0005]\u0000\u0000\u0360\u0361\u0003\u0090H\u0000\u0361"+
		"\u008b\u0001\u0000\u0000\u0000\u0362\u0363\u0007\u0002\u0000\u0000\u0363"+
		"\u0365\u0005L\u0000\u0000\u0364\u0366\u0003\u00b8\\\u0000\u0365\u0364"+
		"\u0001\u0000\u0000\u0000\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0367"+
		"\u0001\u0000\u0000\u0000\u0367\u0368\u0005M\u0000\u0000\u0368\u0369\u0005"+
		"]\u0000\u0000\u0369\u036a\u0003\u0090H\u0000\u036a\u008d\u0001\u0000\u0000"+
		"\u0000\u036b\u036c\u0007\u000f\u0000\u0000\u036c\u036d\u0003\u0092I\u0000"+
		"\u036d\u008f\u0001\u0000\u0000\u0000\u036e\u0379\u0003\b\u0004\u0000\u036f"+
		"\u0370\u0005^\u0000\u0000\u0370\u0372\u0005A\u0000\u0000\u0371\u0373\u0003"+
		"\u0002\u0001\u0000\u0372\u0371\u0001\u0000\u0000\u0000\u0373\u0374\u0001"+
		"\u0000\u0000\u0000\u0374\u0372\u0001\u0000\u0000\u0000\u0374\u0375\u0001"+
		"\u0000\u0000\u0000\u0375\u0376\u0001\u0000\u0000\u0000\u0376\u0377\u0005"+
		"B\u0000\u0000\u0377\u0379\u0001\u0000\u0000\u0000\u0378\u036e\u0001\u0000"+
		"\u0000\u0000\u0378\u036f\u0001\u0000\u0000\u0000\u0379\u0091\u0001\u0000"+
		"\u0000\u0000\u037a\u037b\u0003\u0094J\u0000\u037b\u0093\u0001\u0000\u0000"+
		"\u0000\u037c\u0382\u0003\u0096K\u0000\u037d\u037e\u0005\t\u0000\u0000"+
		"\u037e\u037f\u0003\u0092I\u0000\u037f\u0380\u0005]\u0000\u0000\u0380\u0381"+
		"\u0003\u0092I\u0000\u0381\u0383\u0001\u0000\u0000\u0000\u0382\u037d\u0001"+
		"\u0000\u0000\u0000\u0382\u0383\u0001\u0000\u0000\u0000\u0383\u0095\u0001"+
		"\u0000\u0000\u0000\u0384\u038f\u0003\u0098L\u0000\u0385\u0386\u0005\r"+
		"\u0000\u0000\u0386\u038b\u0005 \u0000\u0000\u0387\u038b\u0005\r\u0000"+
		"\u0000\u0388\u038b\u0005\u001c\u0000\u0000\u0389\u038b\u0005\u000b\u0000"+
		"\u0000\u038a\u0385\u0001\u0000\u0000\u0000\u038a\u0387\u0001\u0000\u0000"+
		"\u0000\u038a\u0388\u0001\u0000\u0000\u0000\u038a\u0389\u0001\u0000\u0000"+
		"\u0000\u038b\u038c\u0001\u0000\u0000\u0000\u038c\u038e\u0003\u0098L\u0000"+
		"\u038d\u038a\u0001\u0000\u0000\u0000\u038e\u0391\u0001\u0000\u0000\u0000"+
		"\u038f\u038d\u0001\u0000\u0000\u0000\u038f\u0390\u0001\u0000\u0000\u0000"+
		"\u0390\u0097\u0001\u0000\u0000\u0000\u0391\u038f\u0001\u0000\u0000\u0000"+
		"\u0392\u0397\u0003\u009aM\u0000\u0393\u0394\u0007\u0010\u0000\u0000\u0394"+
		"\u0396\u0003\u009aM\u0000\u0395\u0393\u0001\u0000\u0000\u0000\u0396\u0399"+
		"\u0001\u0000\u0000\u0000\u0397\u0395\u0001\u0000\u0000\u0000\u0397\u0398"+
		"\u0001\u0000\u0000\u0000\u0398\u0099\u0001\u0000\u0000\u0000\u0399\u0397"+
		"\u0001\u0000\u0000\u0000\u039a\u039f\u0003\u009cN\u0000\u039b\u039c\u0007"+
		"\u0011\u0000\u0000\u039c\u039e\u0003\u009cN\u0000\u039d\u039b\u0001\u0000"+
		"\u0000\u0000\u039e\u03a1\u0001\u0000\u0000\u0000\u039f\u039d\u0001\u0000"+
		"\u0000\u0000\u039f\u03a0\u0001\u0000\u0000\u0000\u03a0\u009b\u0001\u0000"+
		"\u0000\u0000\u03a1\u039f\u0001\u0000\u0000\u0000\u03a2\u03a7\u0003\u009e"+
		"O\u0000\u03a3\u03a4\u0007\u0012\u0000\u0000\u03a4\u03a6\u0003\u009eO\u0000"+
		"\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a6\u03a9\u0001\u0000\u0000\u0000"+
		"\u03a7\u03a5\u0001\u0000\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000\u0000"+
		"\u03a8\u009d\u0001\u0000\u0000\u0000\u03a9\u03a7\u0001\u0000\u0000\u0000"+
		"\u03aa\u03af\u0003\u00a0P\u0000\u03ab\u03ac\u0007\u0013\u0000\u0000\u03ac"+
		"\u03ae\u0003\u00a0P\u0000\u03ad\u03ab\u0001\u0000\u0000\u0000\u03ae\u03b1"+
		"\u0001\u0000\u0000\u0000\u03af\u03ad\u0001\u0000\u0000\u0000\u03af\u03b0"+
		"\u0001\u0000\u0000\u0000\u03b0\u009f\u0001\u0000\u0000\u0000\u03b1\u03af"+
		"\u0001\u0000\u0000\u0000\u03b2\u03b7\u0003\u00a2Q\u0000\u03b3\u03b4\u0007"+
		"\u0014\u0000\u0000\u03b4\u03b6\u0003\u00a2Q\u0000\u03b5\u03b3\u0001\u0000"+
		"\u0000\u0000\u03b6\u03b9\u0001\u0000\u0000\u0000\u03b7\u03b5\u0001\u0000"+
		"\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000\u03b8\u00a1\u0001\u0000"+
		"\u0000\u0000\u03b9\u03b7\u0001\u0000\u0000\u0000\u03ba\u03bd\u0003\u00a4"+
		"R\u0000\u03bb\u03bc\u0005U\u0000\u0000\u03bc\u03be\u0003\u00a2Q\u0000"+
		"\u03bd\u03bb\u0001\u0000\u0000\u0000\u03bd\u03be\u0001\u0000\u0000\u0000"+
		"\u03be\u00a3\u0001\u0000\u0000\u0000\u03bf\u03c0\u0007\u0015\u0000\u0000"+
		"\u03c0\u03c3\u0003\u00a4R\u0000\u03c1\u03c3\u0003\u00a6S\u0000\u03c2\u03bf"+
		"\u0001\u0000\u0000\u0000\u03c2\u03c1\u0001\u0000\u0000\u0000\u03c3\u00a5"+
		"\u0001\u0000\u0000\u0000\u03c4\u03c5\u0006S\uffff\uffff\u0000\u03c5\u0428"+
		"\u0003h4\u0000\u03c6\u0428\u0003b1\u0000\u03c7\u03c8\u0005C\u0000\u0000"+
		"\u03c8\u03c9\u0005/\u0000\u0000\u03c9\u03cc\u0005C\u0000\u0000\u03ca\u03cb"+
		"\u0005/\u0000\u0000\u03cb\u03cd\u0005C\u0000\u0000\u03cc\u03ca\u0001\u0000"+
		"\u0000\u0000\u03cd\u03ce\u0001\u0000\u0000\u0000\u03ce\u03cc\u0001\u0000"+
		"\u0000\u0000\u03ce\u03cf\u0001\u0000\u0000\u0000\u03cf\u0428\u0001\u0000"+
		"\u0000\u0000\u03d0\u03d1\u0005\u001f\u0000\u0000\u03d1\u03d2\u0005/\u0000"+
		"\u0000\u03d2\u03d7\u0005C\u0000\u0000\u03d3\u03d4\u0005/\u0000\u0000\u03d4"+
		"\u03d6\u0005C\u0000\u0000\u03d5\u03d3\u0001\u0000\u0000\u0000\u03d6\u03d9"+
		"\u0001\u0000\u0000\u0000\u03d7\u03d5\u0001\u0000\u0000\u0000\u03d7\u03d8"+
		"\u0001\u0000\u0000\u0000\u03d8\u03da\u0001\u0000\u0000\u0000\u03d9\u03d7"+
		"\u0001\u0000\u0000\u0000\u03da\u03db\u0005C\u0000\u0000\u03db\u03dd\u0005"+
		"L\u0000\u0000\u03dc\u03de\u0003\u00b6[\u0000\u03dd\u03dc\u0001\u0000\u0000"+
		"\u0000\u03dd\u03de\u0001\u0000\u0000\u0000\u03de\u03df\u0001\u0000\u0000"+
		"\u0000\u03df\u0428\u0005M\u0000\u0000\u03e0\u03e1\u0005C\u0000\u0000\u03e1"+
		"\u03e3\u0005L\u0000\u0000\u03e2\u03e4\u0003\u00b6[\u0000\u03e3\u03e2\u0001"+
		"\u0000\u0000\u0000\u03e3\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e5\u0001"+
		"\u0000\u0000\u0000\u03e5\u0428\u0005M\u0000\u0000\u03e6\u03e7\u0007\u0002"+
		"\u0000\u0000\u03e7\u03e9\u0005L\u0000\u0000\u03e8\u03ea\u0003\u00b8\\"+
		"\u0000\u03e9\u03e8\u0001\u0000\u0000\u0000\u03e9\u03ea\u0001\u0000\u0000"+
		"\u0000\u03ea\u03eb\u0001\u0000\u0000\u0000\u03eb\u03ec\u0005M\u0000\u0000"+
		"\u03ec\u03ed\u0005]\u0000\u0000\u03ed\u0428\u0003\u0090H\u0000\u03ee\u03f2"+
		"\u0005N\u0000\u0000\u03ef\u03f1\u0005^\u0000\u0000\u03f0\u03ef\u0001\u0000"+
		"\u0000\u0000\u03f1\u03f4\u0001\u0000\u0000\u0000\u03f2\u03f0\u0001\u0000"+
		"\u0000\u0000\u03f2\u03f3\u0001\u0000\u0000\u0000\u03f3\u03f6\u0001\u0000"+
		"\u0000\u0000\u03f4\u03f2\u0001\u0000\u0000\u0000\u03f5\u03f7\u0003\u00b2"+
		"Y\u0000\u03f6\u03f5\u0001\u0000\u0000\u0000\u03f6\u03f7\u0001\u0000\u0000"+
		"\u0000\u03f7\u03fb\u0001\u0000\u0000\u0000\u03f8\u03fa\u0005^\u0000\u0000"+
		"\u03f9\u03f8\u0001\u0000\u0000\u0000\u03fa\u03fd\u0001\u0000\u0000\u0000"+
		"\u03fb\u03f9\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001\u0000\u0000\u0000"+
		"\u03fc\u03fe\u0001\u0000\u0000\u0000\u03fd\u03fb\u0001\u0000\u0000\u0000"+
		"\u03fe\u0428\u0005O\u0000\u0000\u03ff\u0400\u0005N\u0000\u0000\u0400\u0401"+
		"\u0003\u00b0X\u0000\u0401\u0402\u0005O\u0000\u0000\u0402\u0428\u0001\u0000"+
		"\u0000\u0000\u0403\u0404\u0005-\u0000\u0000\u0404\u0428\u0003\u00a6S\u001c"+
		"\u0405\u0406\u0005.\u0000\u0000\u0406\u0428\u0003\u00a6S\u001b\u0407\u0408"+
		"\u0005,\u0000\u0000\u0408\u0409\u0003\u0092I\u0000\u0409\u040a\u0005&"+
		"\u0000\u0000\u040a\u040b\u0007\u000b\u0000\u0000\u040b\u0428\u0001\u0000"+
		"\u0000\u0000\u040c\u040e\u0005N\u0000\u0000\u040d\u040f\u0003\u00b2Y\u0000"+
		"\u040e\u040d\u0001\u0000\u0000\u0000\u040e\u040f\u0001\u0000\u0000\u0000"+
		"\u040f\u0410\u0001\u0000\u0000\u0000\u0410\u0411\u0005O\u0000\u0000\u0411"+
		"\u0428\u0005\u0014\u0000\u0000\u0412\u0413\u0005C\u0000\u0000\u0413\u0428"+
		"\u0005\u0014\u0000\u0000\u0414\u0415\u00051\u0000\u0000\u0415\u0428\u0005"+
		"E\u0000\u0000\u0416\u0417\u0005\u0017\u0000\u0000\u0417\u0418\u0005C\u0000"+
		"\u0000\u0418\u0419\u00053\u0000\u0000\u0419\u041a\u00054\u0000\u0000\u041a"+
		"\u0428\u0007\u000b\u0000\u0000\u041b\u0428\u0005D\u0000\u0000\u041c\u0428"+
		"\u0005\u0019\u0000\u0000\u041d\u0428\u0005E\u0000\u0000\u041e\u0428\u0005"+
		"C\u0000\u0000\u041f\u0428\u0005\u000f\u0000\u0000\u0420\u0421\u0005L\u0000"+
		"\u0000\u0421\u0422\u0003\u0092I\u0000\u0422\u0423\u0005M\u0000\u0000\u0423"+
		"\u0428\u0001\u0000\u0000\u0000\u0424\u0428\u0003\u00a8T\u0000\u0425\u0428"+
		"\u0003\u00aaU\u0000\u0426\u0428\u00032\u0019\u0000\u0427\u03c4\u0001\u0000"+
		"\u0000\u0000\u0427\u03c6\u0001\u0000\u0000\u0000\u0427\u03c7\u0001\u0000"+
		"\u0000\u0000\u0427\u03d0\u0001\u0000\u0000\u0000\u0427\u03e0\u0001\u0000"+
		"\u0000\u0000\u0427\u03e6\u0001\u0000\u0000\u0000\u0427\u03ee\u0001\u0000"+
		"\u0000\u0000\u0427\u03ff\u0001\u0000\u0000\u0000\u0427\u0403\u0001\u0000"+
		"\u0000\u0000\u0427\u0405\u0001\u0000\u0000\u0000\u0427\u0407\u0001\u0000"+
		"\u0000\u0000\u0427\u040c\u0001\u0000\u0000\u0000\u0427\u0412\u0001\u0000"+
		"\u0000\u0000\u0427\u0414\u0001\u0000\u0000\u0000\u0427\u0416\u0001\u0000"+
		"\u0000\u0000\u0427\u041b\u0001\u0000\u0000\u0000\u0427\u041c\u0001\u0000"+
		"\u0000\u0000\u0427\u041d\u0001\u0000\u0000\u0000\u0427\u041e\u0001\u0000"+
		"\u0000\u0000\u0427\u041f\u0001\u0000\u0000\u0000\u0427\u0420\u0001\u0000"+
		"\u0000\u0000\u0427\u0424\u0001\u0000\u0000\u0000\u0427\u0425\u0001\u0000"+
		"\u0000\u0000\u0427\u0426\u0001\u0000\u0000\u0000\u0428\u0455\u0001\u0000"+
		"\u0000\u0000\u0429\u042a\n\t\u0000\u0000\u042a\u042b\u0005(\u0000\u0000"+
		"\u042b\u0454\u0003\u00a6S\n\u042c\u042d\n\b\u0000\u0000\u042d\u042e\u0005"+
		")\u0000\u0000\u042e\u0454\u0003\u00a6S\t\u042f\u0430\n\u0017\u0000\u0000"+
		"\u0430\u0454\u0005\u0014\u0000\u0000\u0431\u0432\n\u0015\u0000\u0000\u0432"+
		"\u0433\u00057\u0000\u0000\u0433\u0434\u0003\u0092I\u0000\u0434\u0435\u0005"+
		"9\u0000\u0000\u0435\u0454\u0001\u0000\u0000\u0000\u0436\u0437\n\u0014"+
		"\u0000\u0000\u0437\u0438\u00058\u0000\u0000\u0438\u0439\u0003\u0092I\u0000"+
		"\u0439\u043a\u00059\u0000\u0000\u043a\u0454\u0001\u0000\u0000\u0000\u043b"+
		"\u043c\n\f\u0000\u0000\u043c\u043d\u0005(\u0000\u0000\u043d\u043e\u0005"+
		"&\u0000\u0000\u043e\u0454\u0003\u0092I\u0000\u043f\u0440\n\u000b\u0000"+
		"\u0000\u0440\u0441\u0005(\u0000\u0000\u0441\u0442\u0005&\u0000\u0000\u0442"+
		"\u0454\u0005E\u0000\u0000\u0443\u0444\n\n\u0000\u0000\u0444\u0445\u0005"+
		">\u0000\u0000\u0445\u0446\u0005?\u0000\u0000\u0446\u0454\u0003\u0092I"+
		"\u0000\u0447\u0448\n\u0007\u0000\u0000\u0448\u0454\u0005*\u0000\u0000"+
		"\u0449\u044a\n\u0006\u0000\u0000\u044a\u0454\u0005+\u0000\u0000\u044b"+
		"\u044c\n\u0003\u0000\u0000\u044c\u044d\u0005\\\u0000\u0000\u044d\u0454"+
		"\u0005C\u0000\u0000\u044e\u044f\n\u0002\u0000\u0000\u044f\u0450\u0005"+
		"N\u0000\u0000\u0450\u0451\u0003\u0092I\u0000\u0451\u0452\u0005O\u0000"+
		"\u0000\u0452\u0454\u0001\u0000\u0000\u0000\u0453\u0429\u0001\u0000\u0000"+
		"\u0000\u0453\u042c\u0001\u0000\u0000\u0000\u0453\u042f\u0001\u0000\u0000"+
		"\u0000\u0453\u0431\u0001\u0000\u0000\u0000\u0453\u0436\u0001\u0000\u0000"+
		"\u0000\u0453\u043b\u0001\u0000\u0000\u0000\u0453\u043f\u0001\u0000\u0000"+
		"\u0000\u0453\u0443\u0001\u0000\u0000\u0000\u0453\u0447\u0001\u0000\u0000"+
		"\u0000\u0453\u0449\u0001\u0000\u0000\u0000\u0453\u044b\u0001\u0000\u0000"+
		"\u0000\u0453\u044e\u0001\u0000\u0000\u0000\u0454\u0457\u0001\u0000\u0000"+
		"\u0000\u0455\u0453\u0001\u0000\u0000\u0000\u0455\u0456\u0001\u0000\u0000"+
		"\u0000\u0456\u00a7\u0001\u0000\u0000\u0000\u0457\u0455\u0001\u0000\u0000"+
		"\u0000\u0458\u0459\u0007\u0000\u0000\u0000\u0459\u045a\u0005]\u0000\u0000"+
		"\u045a\u045c\u0003\u0014\n\u0000\u045b\u045d\u0005\u0001\u0000\u0000\u045c"+
		"\u045b\u0001\u0000\u0000\u0000\u045c\u045d\u0001\u0000\u0000\u0000\u045d"+
		"\u00a9\u0001\u0000\u0000\u0000\u045e\u0462\u0005J\u0000\u0000\u045f\u0461"+
		"\u0005^\u0000\u0000\u0460\u045f\u0001\u0000\u0000\u0000\u0461\u0464\u0001"+
		"\u0000\u0000\u0000\u0462\u0460\u0001\u0000\u0000\u0000\u0462\u0463\u0001"+
		"\u0000\u0000\u0000\u0463\u0466\u0001\u0000\u0000\u0000\u0464\u0462\u0001"+
		"\u0000\u0000\u0000\u0465\u0467\u0003\u00acV\u0000\u0466\u0465\u0001\u0000"+
		"\u0000\u0000\u0466\u0467\u0001\u0000\u0000\u0000\u0467\u046b\u0001\u0000"+
		"\u0000\u0000\u0468\u046a\u0005^\u0000\u0000\u0469\u0468\u0001\u0000\u0000"+
		"\u0000\u046a\u046d\u0001\u0000\u0000\u0000\u046b\u0469\u0001\u0000\u0000"+
		"\u0000\u046b\u046c\u0001\u0000\u0000\u0000\u046c\u046e\u0001\u0000\u0000"+
		"\u0000\u046d\u046b\u0001\u0000\u0000\u0000\u046e\u046f\u0005K\u0000\u0000"+
		"\u046f\u00ab\u0001\u0000\u0000\u0000\u0470\u0482\u0003\u00aeW\u0000\u0471"+
		"\u0475\u0005[\u0000\u0000\u0472\u0474\u0005^\u0000\u0000\u0473\u0472\u0001"+
		"\u0000\u0000\u0000\u0474\u0477\u0001\u0000\u0000\u0000\u0475\u0473\u0001"+
		"\u0000\u0000\u0000\u0475\u0476\u0001\u0000\u0000\u0000\u0476\u047e\u0001"+
		"\u0000\u0000\u0000\u0477\u0475\u0001\u0000\u0000\u0000\u0478\u047a\u0005"+
		"^\u0000\u0000\u0479\u0478\u0001\u0000\u0000\u0000\u047a\u047b\u0001\u0000"+
		"\u0000\u0000\u047b\u0479\u0001\u0000\u0000\u0000\u047b\u047c\u0001\u0000"+
		"\u0000\u0000\u047c\u047e\u0001\u0000\u0000\u0000\u047d\u0471\u0001\u0000"+
		"\u0000\u0000\u047d\u0479\u0001\u0000\u0000\u0000\u047e\u047f\u0001\u0000"+
		"\u0000\u0000\u047f\u0481\u0003\u00aeW\u0000\u0480\u047d\u0001\u0000\u0000"+
		"\u0000\u0481\u0484\u0001\u0000\u0000\u0000\u0482\u0480\u0001\u0000\u0000"+
		"\u0000\u0482\u0483\u0001\u0000\u0000\u0000\u0483\u0486\u0001\u0000\u0000"+
		"\u0000\u0484\u0482\u0001\u0000\u0000\u0000\u0485\u0487\u0005[\u0000\u0000"+
		"\u0486\u0485\u0001\u0000\u0000\u0000\u0486\u0487\u0001\u0000\u0000\u0000"+
		"\u0487\u048b\u0001\u0000\u0000\u0000\u0488\u048a\u0005^\u0000\u0000\u0489"+
		"\u0488\u0001\u0000\u0000\u0000\u048a\u048d\u0001\u0000\u0000\u0000\u048b"+
		"\u0489\u0001\u0000\u0000\u0000\u048b\u048c\u0001\u0000\u0000\u0000\u048c"+
		"\u00ad\u0001\u0000\u0000\u0000\u048d\u048b\u0001\u0000\u0000\u0000\u048e"+
		"\u048f\u0007\u000b\u0000\u0000\u048f\u0490\u0005]\u0000\u0000\u0490\u0491"+
		"\u0003\u0092I\u0000\u0491\u00af\u0001\u0000\u0000\u0000\u0492\u0493\u0003"+
		"\u0092I\u0000\u0493\u0494\u0005[\u0000\u0000\u0494\u0495\u0003\u0092I"+
		"\u0000\u0495\u0496\u0005[\u0000\u0000\u0496\u0497\u0005@\u0000\u0000\u0497"+
		"\u0498\u0003\u0092I\u0000\u0498\u049f\u0001\u0000\u0000\u0000\u0499\u049a"+
		"\u0003\u0092I\u0000\u049a\u049b\u0005[\u0000\u0000\u049b\u049c\u0005@"+
		"\u0000\u0000\u049c\u049d\u0003\u0092I\u0000\u049d\u049f\u0001\u0000\u0000"+
		"\u0000\u049e\u0492\u0001\u0000\u0000\u0000\u049e\u0499\u0001\u0000\u0000"+
		"\u0000\u049f\u00b1\u0001\u0000\u0000\u0000\u04a0\u04a2\u0005^\u0000\u0000"+
		"\u04a1\u04a0\u0001\u0000\u0000\u0000\u04a2\u04a5\u0001\u0000\u0000\u0000"+
		"\u04a3\u04a1\u0001\u0000\u0000\u0000\u04a3\u04a4\u0001\u0000\u0000\u0000"+
		"\u04a4\u04a6\u0001\u0000\u0000\u0000\u04a5\u04a3\u0001\u0000\u0000\u0000"+
		"\u04a6\u04b8\u0003\u00b4Z\u0000\u04a7\u04ab\u0005[\u0000\u0000\u04a8\u04aa"+
		"\u0005^\u0000\u0000\u04a9\u04a8\u0001\u0000\u0000\u0000\u04aa\u04ad\u0001"+
		"\u0000\u0000\u0000\u04ab\u04a9\u0001\u0000\u0000\u0000\u04ab\u04ac\u0001"+
		"\u0000\u0000\u0000\u04ac\u04b4\u0001\u0000\u0000\u0000\u04ad\u04ab\u0001"+
		"\u0000\u0000\u0000\u04ae\u04b0\u0005^\u0000\u0000\u04af\u04ae\u0001\u0000"+
		"\u0000\u0000\u04b0\u04b1\u0001\u0000\u0000\u0000\u04b1\u04af\u0001\u0000"+
		"\u0000\u0000\u04b1\u04b2\u0001\u0000\u0000\u0000\u04b2\u04b4\u0001\u0000"+
		"\u0000\u0000\u04b3\u04a7\u0001\u0000\u0000\u0000\u04b3\u04af\u0001\u0000"+
		"\u0000\u0000\u04b4\u04b5\u0001\u0000\u0000\u0000\u04b5\u04b7\u0003\u00b4"+
		"Z\u0000\u04b6\u04b3\u0001\u0000\u0000\u0000\u04b7\u04ba\u0001\u0000\u0000"+
		"\u0000\u04b8\u04b6\u0001\u0000\u0000\u0000\u04b8\u04b9\u0001\u0000\u0000"+
		"\u0000\u04b9\u04bc\u0001\u0000\u0000\u0000\u04ba\u04b8\u0001\u0000\u0000"+
		"\u0000\u04bb\u04bd\u0005[\u0000\u0000\u04bc\u04bb\u0001\u0000\u0000\u0000"+
		"\u04bc\u04bd\u0001\u0000\u0000\u0000\u04bd\u04c1\u0001\u0000\u0000\u0000"+
		"\u04be\u04c0\u0005^\u0000\u0000\u04bf\u04be\u0001\u0000\u0000\u0000\u04c0"+
		"\u04c3\u0001\u0000\u0000\u0000\u04c1\u04bf\u0001\u0000\u0000\u0000\u04c1"+
		"\u04c2\u0001\u0000\u0000\u0000\u04c2\u00b3\u0001\u0000\u0000\u0000\u04c3"+
		"\u04c1\u0001\u0000\u0000\u0000\u04c4\u04c7\u0003\u00a8T\u0000\u04c5\u04c7"+
		"\u0003\u0092I\u0000\u04c6\u04c4\u0001\u0000\u0000\u0000\u04c6\u04c5\u0001"+
		"\u0000\u0000\u0000\u04c7\u00b5\u0001\u0000\u0000\u0000\u04c8\u04cd\u0003"+
		"\u0092I\u0000\u04c9\u04ca\u0005[\u0000\u0000\u04ca\u04cc\u0003\u0092I"+
		"\u0000\u04cb\u04c9\u0001\u0000\u0000\u0000\u04cc\u04cf\u0001\u0000\u0000"+
		"\u0000\u04cd\u04cb\u0001\u0000\u0000\u0000\u04cd\u04ce\u0001\u0000\u0000"+
		"\u0000\u04ce\u00b7\u0001\u0000\u0000\u0000\u04cf\u04cd\u0001\u0000\u0000"+
		"\u0000\u04d0\u04d5\u0005C\u0000\u0000\u04d1\u04d2\u0005[\u0000\u0000\u04d2"+
		"\u04d4\u0005C\u0000\u0000\u04d3\u04d1\u0001\u0000\u0000\u0000\u04d4\u04d7"+
		"\u0001\u0000\u0000\u0000\u04d5\u04d3\u0001\u0000\u0000\u0000\u04d5\u04d6"+
		"\u0001\u0000\u0000\u0000\u04d6\u00b9\u0001\u0000\u0000\u0000\u04d7\u04d5"+
		"\u0001\u0000\u0000\u0000p\u00bd\u00c5\u00cb\u00cf\u00ea\u00f7\u0105\u010d"+
		"\u0114\u011b\u0129\u012e\u0134\u013a\u0140\u0146\u014c\u0152\u0158\u016f"+
		"\u0172\u0177\u017c\u0184\u018c\u019e\u01ab\u01bf\u01e2\u01ef\u01f7\u0201"+
		"\u0203\u020f\u0217\u0219\u0221\u0229\u022b\u0232\u0235\u023d\u0240\u024b"+
		"\u0255\u0263\u0271\u0277\u027c\u0282\u0293\u0298\u02af\u02b8\u02d3\u030e"+
		"\u0314\u031c\u0323\u032e\u0340\u0345\u034d\u0351\u0356\u035c\u0365\u0374"+
		"\u0378\u0382\u038a\u038f\u0397\u039f\u03a7\u03af\u03b7\u03bd\u03c2\u03ce"+
		"\u03d7\u03dd\u03e3\u03e9\u03f2\u03f6\u03fb\u040e\u0427\u0453\u0455\u045c"+
		"\u0462\u0466\u046b\u0475\u047b\u047d\u0482\u0486\u048b\u049e\u04a3\u04ab"+
		"\u04b1\u04b3\u04b8\u04bc\u04c1\u04c6\u04cd\u04d5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}