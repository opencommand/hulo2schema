// Generated from d:/opencmd/grammar/cmdParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class cmdParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COLON=2, SUB=3, SEMI=4, COMMA=5, QUEST=6, AT=7, LT=8, GT=9, LPAREN=10, 
		RPAREN=11, LBRACK=12, RBRACK=13, LBRACE=14, RBRACE=15, ASSIGN=16, BITAND=17, 
		BITOR=18, BITXOR=19, DOUBLE_BITAND=20, TILDE=21, STAR=22, DOUBLE_STAR=23, 
		NULL=24, ARROW=25, TOP=26, PARALLEL=27, IMPLIES=28, EQUIVALENT=29, EMPTY=30, 
		AND=31, OR=32, NOT=33, NEQ=34, EXTENDS=35, OPTS=36, CMDS=37, IF=38, ELSE=39, 
		FN=40, CMD=41, CONSTRAINT=42, MAP=43, SINGLE_QUOTE=44, QUOTE=45, NumberLiteral=46, 
		StringLiteral=47, BoolLiteral=48, ESC=49, LineComment=50, BlockComment=51, 
		Identifier=52, WS=53;
	public static final int
		RULE_file = 0, RULE_block = 1, RULE_comment = 2, RULE_statement = 3, RULE_decorator = 4, 
		RULE_expression = 5, RULE_expressionList = 6, RULE_commandDeclaration = 7, 
		RULE_commandBody = 8, RULE_field = 9, RULE_type = 10, RULE_mapType = 11, 
		RULE_arrayType = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "block", "comment", "statement", "decorator", "expression", "expressionList", 
			"commandDeclaration", "commandBody", "field", "type", "mapType", "arrayType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "':'", "'-'", "';'", "','", "'?'", "'@'", "'<'", "'>'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'='", "'&'", "'|'", "'^'", 
			"'&&'", "'~'", "'*'", "'**'", "'null'", "'->'", "'\\u22A5'", "'\\u2225'", 
			"'\\u2192'", "'\\u2194'", "'\\u2205'", "'\\u2227'", "'\\u2228'", "'\\u00AC'", 
			"'\\u2260'", "'extends'", "'opts'", "'cmds'", "'if'", "'else'", "'fn'", 
			"'cmd'", "'constraint'", "'map'", "'''", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "COLON", "SUB", "SEMI", "COMMA", "QUEST", "AT", "LT", "GT", 
			"LPAREN", "RPAREN", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "ASSIGN", 
			"BITAND", "BITOR", "BITXOR", "DOUBLE_BITAND", "TILDE", "STAR", "DOUBLE_STAR", 
			"NULL", "ARROW", "TOP", "PARALLEL", "IMPLIES", "EQUIVALENT", "EMPTY", 
			"AND", "OR", "NOT", "NEQ", "EXTENDS", "OPTS", "CMDS", "IF", "ELSE", "FN", 
			"CMD", "CONSTRAINT", "MAP", "SINGLE_QUOTE", "QUOTE", "NumberLiteral", 
			"StringLiteral", "BoolLiteral", "ESC", "LineComment", "BlockComment", 
			"Identifier", "WS"
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
	public String getGrammarFileName() { return "cmdParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public cmdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(cmdParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(cmdParser.SEMI, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3379898743783424L) != 0)) {
				{
				{
				setState(26);
				statement();
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(27);
					match(SEMI);
					}
					}
					setState(32);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(37);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(cmdParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(cmdParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(cmdParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(cmdParser.SEMI, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(LBRACE);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3379898743783424L) != 0)) {
				{
				{
				setState(39);
				statement();
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(40);
					match(SEMI);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LineComment() { return getToken(cmdParser.LineComment, 0); }
		public TerminalNode BlockComment() { return getToken(cmdParser.BlockComment, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==LineComment || _la==BlockComment) ) {
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
	public static class StatementContext extends ParserRuleContext {
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public CommandDeclarationContext commandDeclaration() {
			return getRuleContext(CommandDeclarationContext.class,0);
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
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				comment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				commandDeclaration();
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
	public static class DecoratorContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(cmdParser.AT, 0); }
		public TerminalNode Identifier() { return getToken(cmdParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(cmdParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(cmdParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public DecoratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorator; }
	}

	public final DecoratorContext decorator() throws RecognitionException {
		DecoratorContext _localctx = new DecoratorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decorator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(AT);
			setState(60);
			match(Identifier);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(61);
				match(LPAREN);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 492581209243648L) != 0)) {
					{
					setState(62);
					expressionList();
					}
				}

				setState(65);
				match(RPAREN);
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
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(cmdParser.StringLiteral, 0); }
		public TerminalNode BoolLiteral() { return getToken(cmdParser.BoolLiteral, 0); }
		public TerminalNode NumberLiteral() { return getToken(cmdParser.NumberLiteral, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 492581209243648L) != 0)) ) {
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
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(cmdParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(cmdParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			expression();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(71);
				match(COMMA);
				setState(72);
				expression();
				}
				}
				setState(77);
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
	public static class CommandDeclarationContext extends ParserRuleContext {
		public TerminalNode CMD() { return getToken(cmdParser.CMD, 0); }
		public List<TerminalNode> Identifier() { return getTokens(cmdParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(cmdParser.Identifier, i);
		}
		public TerminalNode LBRACE() { return getToken(cmdParser.LBRACE, 0); }
		public CommandBodyContext commandBody() {
			return getRuleContext(CommandBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(cmdParser.RBRACE, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(cmdParser.EXTENDS, 0); }
		public CommandDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandDeclaration; }
	}

	public final CommandDeclarationContext commandDeclaration() throws RecognitionException {
		CommandDeclarationContext _localctx = new CommandDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_commandDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LineComment || _la==BlockComment) {
				{
				{
				setState(78);
				comment();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(CMD);
			setState(85);
			match(Identifier);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(86);
				match(EXTENDS);
				setState(87);
				match(Identifier);
				}
			}

			setState(90);
			match(LBRACE);
			setState(91);
			commandBody();
			setState(92);
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
	public static class CommandBodyContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<CommandDeclarationContext> commandDeclaration() {
			return getRuleContexts(CommandDeclarationContext.class);
		}
		public CommandDeclarationContext commandDeclaration(int i) {
			return getRuleContext(CommandDeclarationContext.class,i);
		}
		public CommandBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandBody; }
	}

	public final CommandBodyContext commandBody() throws RecognitionException {
		CommandBodyContext _localctx = new CommandBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_commandBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7883498371154048L) != 0)) {
				{
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(94);
					field();
					}
					break;
				case 2:
					{
					setState(95);
					commandDeclaration();
					}
					break;
				}
				}
				setState(100);
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
	public static class FieldContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(cmdParser.Identifier, 0); }
		public TerminalNode COLON() { return getToken(cmdParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<DecoratorContext> decorator() {
			return getRuleContexts(DecoratorContext.class);
		}
		public DecoratorContext decorator(int i) {
			return getRuleContext(DecoratorContext.class,i);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LineComment || _la==BlockComment) {
				{
				{
				setState(101);
				comment();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(107);
				decorator();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(Identifier);
			setState(114);
			match(COLON);
			setState(115);
			type();
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(cmdParser.Identifier, 0); }
		public MapTypeContext mapType() {
			return getRuleContext(MapTypeContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public TerminalNode QUEST() { return getToken(cmdParser.QUEST, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(117);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(118);
				mapType();
				}
				break;
			case 3:
				{
				setState(119);
				arrayType();
				}
				break;
			}
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUEST) {
				{
				setState(122);
				match(QUEST);
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
	public static class MapTypeContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(cmdParser.MAP, 0); }
		public TerminalNode LT() { return getToken(cmdParser.LT, 0); }
		public List<TerminalNode> Identifier() { return getTokens(cmdParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(cmdParser.Identifier, i);
		}
		public TerminalNode GT() { return getToken(cmdParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(cmdParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(cmdParser.COMMA, i);
		}
		public MapTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapType; }
	}

	public final MapTypeContext mapType() throws RecognitionException {
		MapTypeContext _localctx = new MapTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mapType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(MAP);
			setState(126);
			match(LT);
			setState(127);
			match(Identifier);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(128);
				match(COMMA);
				setState(129);
				match(Identifier);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(GT);
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
	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(cmdParser.Identifier, 0); }
		public TerminalNode LBRACK() { return getToken(cmdParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(cmdParser.RBRACK, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(Identifier);
			setState(138);
			match(LBRACK);
			setState(139);
			match(RBRACK);
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

	public static final String _serializedATN =
		"\u0004\u00015\u008e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0005\u0000\u001d\b\u0000\n\u0000\f"+
		"\u0000 \t\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001*\b\u0001\n\u0001\f\u0001-\t\u0001"+
		"\u0005\u0001/\b\u0001\n\u0001\f\u00012\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003:\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004@\b\u0004"+
		"\u0001\u0004\u0003\u0004C\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006J\b\u0006\n\u0006\f\u0006M\t\u0006"+
		"\u0001\u0007\u0005\u0007P\b\u0007\n\u0007\f\u0007S\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007Y\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\ba\b\b\n\b"+
		"\f\bd\t\b\u0001\t\u0005\tg\b\t\n\t\f\tj\t\t\u0001\t\u0005\tm\b\t\n\t\f"+
		"\tp\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003"+
		"\ny\b\n\u0001\n\u0003\n|\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u0083\b\u000b\n\u000b\f\u000b\u0086\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0000"+
		"\u0000\r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u0000\u0002\u0001\u000023\u0001\u0000.0\u0092\u0000#\u0001\u0000\u0000"+
		"\u0000\u0002&\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000\u0006"+
		"9\u0001\u0000\u0000\u0000\b;\u0001\u0000\u0000\u0000\nD\u0001\u0000\u0000"+
		"\u0000\fF\u0001\u0000\u0000\u0000\u000eQ\u0001\u0000\u0000\u0000\u0010"+
		"b\u0001\u0000\u0000\u0000\u0012h\u0001\u0000\u0000\u0000\u0014x\u0001"+
		"\u0000\u0000\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u0089\u0001\u0000"+
		"\u0000\u0000\u001a\u001e\u0003\u0006\u0003\u0000\u001b\u001d\u0005\u0004"+
		"\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000"+
		"\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000"+
		"\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000"+
		"!\u001a\u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$\u0001\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000&0\u0005\u000e\u0000\u0000\'+\u0003\u0006\u0003"+
		"\u0000(*\u0005\u0004\u0000\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,/\u0001"+
		"\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.\'\u0001\u0000\u0000\u0000"+
		"/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u000013\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000034\u0005\u000f"+
		"\u0000\u00004\u0003\u0001\u0000\u0000\u000056\u0007\u0000\u0000\u0000"+
		"6\u0005\u0001\u0000\u0000\u00007:\u0003\u0004\u0002\u00008:\u0003\u000e"+
		"\u0007\u000097\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\u0007"+
		"\u0001\u0000\u0000\u0000;<\u0005\u0007\u0000\u0000<B\u00054\u0000\u0000"+
		"=?\u0005\n\u0000\u0000>@\u0003\f\u0006\u0000?>\u0001\u0000\u0000\u0000"+
		"?@\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0005\u000b\u0000"+
		"\u0000B=\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000C\t\u0001\u0000"+
		"\u0000\u0000DE\u0007\u0001\u0000\u0000E\u000b\u0001\u0000\u0000\u0000"+
		"FK\u0003\n\u0005\u0000GH\u0005\u0005\u0000\u0000HJ\u0003\n\u0005\u0000"+
		"IG\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000L\r\u0001\u0000\u0000\u0000MK\u0001\u0000"+
		"\u0000\u0000NP\u0003\u0004\u0002\u0000ON\u0001\u0000\u0000\u0000PS\u0001"+
		"\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RT\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005)\u0000\u0000"+
		"UX\u00054\u0000\u0000VW\u0005#\u0000\u0000WY\u00054\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0005\u000e\u0000\u0000[\\\u0003\u0010\b\u0000\\]\u0005\u000f\u0000"+
		"\u0000]\u000f\u0001\u0000\u0000\u0000^a\u0003\u0012\t\u0000_a\u0003\u000e"+
		"\u0007\u0000`^\u0001\u0000\u0000\u0000`_\u0001\u0000\u0000\u0000ad\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"c\u0011\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000eg\u0003\u0004"+
		"\u0002\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000in\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000km\u0003\b\u0004\u0000lk\u0001\u0000\u0000\u0000"+
		"mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u00054\u0000"+
		"\u0000rs\u0005\u0002\u0000\u0000st\u0003\u0014\n\u0000t\u0013\u0001\u0000"+
		"\u0000\u0000uy\u00054\u0000\u0000vy\u0003\u0016\u000b\u0000wy\u0003\u0018"+
		"\f\u0000xu\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xw\u0001\u0000"+
		"\u0000\u0000y{\u0001\u0000\u0000\u0000z|\u0005\u0006\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0015\u0001\u0000\u0000"+
		"\u0000}~\u0005+\u0000\u0000~\u007f\u0005\b\u0000\u0000\u007f\u0084\u0005"+
		"4\u0000\u0000\u0080\u0081\u0005\u0005\u0000\u0000\u0081\u0083\u00054\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000"+
		"\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005\t\u0000\u0000\u0088\u0017\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u00054\u0000\u0000\u008a\u008b\u0005\f\u0000\u0000\u008b"+
		"\u008c\u0005\r\u0000\u0000\u008c\u0019\u0001\u0000\u0000\u0000\u0011\u001e"+
		"#+09?BKQX`bhnx{\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}