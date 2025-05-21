// Generated from c:/Users/carlo/Downloads/ilitia/ilitia/src/main/antlr4/com/example/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TIPO=1, OP_ASIG=2, OP_SUMA=3, OP_REST=4, OP_MULT=5, OP_DIV=6, OP_REL=7, 
		PAREIZ=8, PAREDR=9, KEYIZ=10, KEYDR=11, IF=12, ELSE=13, FOR=14, PRINT=15, 
		PYC=16, NUM=17, STRING=18, BOOL=19, ID=20, LINE_COMMENT=21, WS=22;
	public static final int
		RULE_program = 0, RULE_secuencia = 1, RULE_instruccion = 2, RULE_forBlock = 3, 
		RULE_printInstruccion = 4, RULE_declaracion = 5, RULE_asignacion = 6, 
		RULE_expresion = 7, RULE_expLogica = 8, RULE_expArit = 9, RULE_termino = 10, 
		RULE_factor = 11, RULE_ifBlock = 12, RULE_elseIfBlock = 13, RULE_elseBlock = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "secuencia", "instruccion", "forBlock", "printInstruccion", 
			"declaracion", "asignacion", "expresion", "expLogica", "expArit", "termino", 
			"factor", "ifBlock", "elseIfBlock", "elseBlock"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'='", "'+'", "'-'", "'*'", "'/'", null, "'('", "')'", "'{'", 
			"'}'", "'if'", "'else'", "'for'", "'print'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TIPO", "OP_ASIG", "OP_SUMA", "OP_REST", "OP_MULT", "OP_DIV", "OP_REL", 
			"PAREIZ", "PAREDR", "KEYIZ", "KEYDR", "IF", "ELSE", "FOR", "PRINT", "PYC", 
			"NUM", "STRING", "BOOL", "ID", "LINE_COMMENT", "WS"
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public SecuenciaContext secuencia() {
			return getRuleContext(SecuenciaContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LanguageParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			secuencia();
			setState(31);
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
	public static class SecuenciaContext extends ParserRuleContext {
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public SecuenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secuencia; }
	}

	public final SecuenciaContext secuencia() throws RecognitionException {
		SecuenciaContext _localctx = new SecuenciaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_secuencia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				instruccion();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2019586L) != 0) );
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
	public static class InstruccionContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public TerminalNode PYC() { return getToken(LanguageParser.PYC, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ExpAritContext expArit() {
			return getRuleContext(ExpAritContext.class,0);
		}
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public ForBlockContext forBlock() {
			return getRuleContext(ForBlockContext.class,0);
		}
		public PrintInstruccionContext printInstruccion() {
			return getRuleContext(PrintInstruccionContext.class,0);
		}
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instruccion);
		try {
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				declaracion();
				setState(39);
				match(PYC);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				asignacion();
				setState(42);
				match(PYC);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				expArit();
				setState(45);
				match(PYC);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				expLogica();
				setState(48);
				match(PYC);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				ifBlock();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				forBlock();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				printInstruccion();
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
	public static class ForBlockContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LanguageParser.FOR, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<TerminalNode> PYC() { return getTokens(LanguageParser.PYC); }
		public TerminalNode PYC(int i) {
			return getToken(LanguageParser.PYC, i);
		}
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public TerminalNode KEYIZ() { return getToken(LanguageParser.KEYIZ, 0); }
		public SecuenciaContext secuencia() {
			return getRuleContext(SecuenciaContext.class,0);
		}
		public TerminalNode KEYDR() { return getToken(LanguageParser.KEYDR, 0); }
		public ForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBlock; }
	}

	public final ForBlockContext forBlock() throws RecognitionException {
		ForBlockContext _localctx = new ForBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(FOR);
			setState(56);
			match(PAREIZ);
			setState(57);
			declaracion();
			setState(58);
			match(PYC);
			setState(59);
			expLogica();
			setState(60);
			match(PYC);
			setState(61);
			asignacion();
			setState(62);
			match(PAREDR);
			setState(63);
			match(KEYIZ);
			setState(64);
			secuencia();
			setState(65);
			match(KEYDR);
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
	public static class PrintInstruccionContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(LanguageParser.PRINT, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public TerminalNode PYC() { return getToken(LanguageParser.PYC, 0); }
		public PrintInstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printInstruccion; }
	}

	public final PrintInstruccionContext printInstruccion() throws RecognitionException {
		PrintInstruccionContext _localctx = new PrintInstruccionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_printInstruccion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(PRINT);
			setState(68);
			match(PAREIZ);
			setState(69);
			expresion();
			setState(70);
			match(PAREDR);
			setState(71);
			match(PYC);
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
	public static class DeclaracionContext extends ParserRuleContext {
		public TerminalNode TIPO() { return getToken(LanguageParser.TIPO, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode OP_ASIG() { return getToken(LanguageParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaracion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(TIPO);
			setState(74);
			match(ID);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASIG) {
				{
				setState(75);
				match(OP_ASIG);
				setState(76);
				expresion();
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
	public static class AsignacionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode OP_ASIG() { return getToken(LanguageParser.OP_ASIG, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ID);
			setState(80);
			match(OP_ASIG);
			setState(81);
			expresion();
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
	public static class ExpresionContext extends ParserRuleContext {
		public ExpAritContext expArit() {
			return getRuleContext(ExpAritContext.class,0);
		}
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expresion);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				expArit();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				expLogica();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
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
	public static class ExpLogicaContext extends ParserRuleContext {
		public List<ExpAritContext> expArit() {
			return getRuleContexts(ExpAritContext.class);
		}
		public ExpAritContext expArit(int i) {
			return getRuleContext(ExpAritContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(LanguageParser.OP_REL, 0); }
		public ExpLogicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expLogica; }
	}

	public final ExpLogicaContext expLogica() throws RecognitionException {
		ExpLogicaContext _localctx = new ExpLogicaContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expLogica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			expArit();
			setState(90);
			match(OP_REL);
			setState(91);
			expArit();
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
	public static class ExpAritContext extends ParserRuleContext {
		public List<TerminoContext> termino() {
			return getRuleContexts(TerminoContext.class);
		}
		public TerminoContext termino(int i) {
			return getRuleContext(TerminoContext.class,i);
		}
		public List<TerminalNode> OP_SUMA() { return getTokens(LanguageParser.OP_SUMA); }
		public TerminalNode OP_SUMA(int i) {
			return getToken(LanguageParser.OP_SUMA, i);
		}
		public List<TerminalNode> OP_REST() { return getTokens(LanguageParser.OP_REST); }
		public TerminalNode OP_REST(int i) {
			return getToken(LanguageParser.OP_REST, i);
		}
		public ExpAritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expArit; }
	}

	public final ExpAritContext expArit() throws RecognitionException {
		ExpAritContext _localctx = new ExpAritContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expArit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			termino();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SUMA || _la==OP_REST) {
				{
				{
				setState(94);
				_la = _input.LA(1);
				if ( !(_la==OP_SUMA || _la==OP_REST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(95);
				termino();
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
	public static class TerminoContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> OP_MULT() { return getTokens(LanguageParser.OP_MULT); }
		public TerminalNode OP_MULT(int i) {
			return getToken(LanguageParser.OP_MULT, i);
		}
		public List<TerminalNode> OP_DIV() { return getTokens(LanguageParser.OP_DIV); }
		public TerminalNode OP_DIV(int i) {
			return getToken(LanguageParser.OP_DIV, i);
		}
		public TerminoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termino; }
	}

	public final TerminoContext termino() throws RecognitionException {
		TerminoContext _localctx = new TerminoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_termino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			factor();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MULT || _la==OP_DIV) {
				{
				{
				setState(102);
				_la = _input.LA(1);
				if ( !(_la==OP_MULT || _la==OP_DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(103);
				factor();
				}
				}
				setState(108);
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(LanguageParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(NUM);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(STRING);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(BOOL);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				match(ID);
				}
				break;
			case PAREIZ:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				match(PAREIZ);
				setState(114);
				expresion();
				setState(115);
				match(PAREDR);
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
	public static class IfBlockContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public TerminalNode KEYIZ() { return getToken(LanguageParser.KEYIZ, 0); }
		public SecuenciaContext secuencia() {
			return getRuleContext(SecuenciaContext.class,0);
		}
		public TerminalNode KEYDR() { return getToken(LanguageParser.KEYDR, 0); }
		public List<ElseIfBlockContext> elseIfBlock() {
			return getRuleContexts(ElseIfBlockContext.class);
		}
		public ElseIfBlockContext elseIfBlock(int i) {
			return getRuleContext(ElseIfBlockContext.class,i);
		}
		public ElseBlockContext elseBlock() {
			return getRuleContext(ElseBlockContext.class,0);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IF);
			setState(120);
			match(PAREIZ);
			setState(121);
			expLogica();
			setState(122);
			match(PAREDR);
			setState(123);
			match(KEYIZ);
			setState(124);
			secuencia();
			setState(125);
			match(KEYDR);
			setState(129);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(126);
					elseIfBlock();
					}
					} 
				}
				setState(131);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(132);
				elseBlock();
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
	public static class ElseIfBlockContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public TerminalNode KEYIZ() { return getToken(LanguageParser.KEYIZ, 0); }
		public SecuenciaContext secuencia() {
			return getRuleContext(SecuenciaContext.class,0);
		}
		public TerminalNode KEYDR() { return getToken(LanguageParser.KEYDR, 0); }
		public ElseIfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfBlock; }
	}

	public final ElseIfBlockContext elseIfBlock() throws RecognitionException {
		ElseIfBlockContext _localctx = new ElseIfBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elseIfBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ELSE);
			setState(136);
			match(IF);
			setState(137);
			match(PAREIZ);
			setState(138);
			expLogica();
			setState(139);
			match(PAREDR);
			setState(140);
			match(KEYIZ);
			setState(141);
			secuencia();
			setState(142);
			match(KEYDR);
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
	public static class ElseBlockContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public TerminalNode KEYIZ() { return getToken(LanguageParser.KEYIZ, 0); }
		public SecuenciaContext secuencia() {
			return getRuleContext(SecuenciaContext.class,0);
		}
		public TerminalNode KEYDR() { return getToken(LanguageParser.KEYDR, 0); }
		public ElseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseBlock; }
	}

	public final ElseBlockContext elseBlock() throws RecognitionException {
		ElseBlockContext _localctx = new ElseBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(ELSE);
			setState(145);
			match(KEYIZ);
			setState(146);
			secuencia();
			setState(147);
			match(KEYDR);
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
		"\u0004\u0001\u0016\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0004\u0001#\b\u0001\u000b\u0001\f\u0001"+
		"$\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007X\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0005\ta\b\t\n\t\f\td\t\t\u0001\n\u0001\n\u0001\n\u0005"+
		"\ni\b\n\n\n\f\nl\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bv\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0080"+
		"\b\f\n\f\f\f\u0083\t\f\u0001\f\u0003\f\u0086\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u0000\u0002\u0001\u0000\u0003\u0004\u0001\u0000\u0005\u0006\u0099\u0000"+
		"\u001e\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000\u0000\u00045"+
		"\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\bC\u0001\u0000"+
		"\u0000\u0000\nI\u0001\u0000\u0000\u0000\fO\u0001\u0000\u0000\u0000\u000e"+
		"W\u0001\u0000\u0000\u0000\u0010Y\u0001\u0000\u0000\u0000\u0012]\u0001"+
		"\u0000\u0000\u0000\u0014e\u0001\u0000\u0000\u0000\u0016u\u0001\u0000\u0000"+
		"\u0000\u0018w\u0001\u0000\u0000\u0000\u001a\u0087\u0001\u0000\u0000\u0000"+
		"\u001c\u0090\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0002\u0001\u0000"+
		"\u001f \u0005\u0000\u0000\u0001 \u0001\u0001\u0000\u0000\u0000!#\u0003"+
		"\u0004\u0002\u0000\"!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\u0003\u0001\u0000"+
		"\u0000\u0000&\'\u0003\n\u0005\u0000\'(\u0005\u0010\u0000\u0000(6\u0001"+
		"\u0000\u0000\u0000)*\u0003\f\u0006\u0000*+\u0005\u0010\u0000\u0000+6\u0001"+
		"\u0000\u0000\u0000,-\u0003\u0012\t\u0000-.\u0005\u0010\u0000\u0000.6\u0001"+
		"\u0000\u0000\u0000/0\u0003\u0010\b\u000001\u0005\u0010\u0000\u000016\u0001"+
		"\u0000\u0000\u000026\u0003\u0018\f\u000036\u0003\u0006\u0003\u000046\u0003"+
		"\b\u0004\u00005&\u0001\u0000\u0000\u00005)\u0001\u0000\u0000\u00005,\u0001"+
		"\u0000\u0000\u00005/\u0001\u0000\u0000\u000052\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u00006\u0005\u0001\u0000"+
		"\u0000\u000078\u0005\u000e\u0000\u000089\u0005\b\u0000\u00009:\u0003\n"+
		"\u0005\u0000:;\u0005\u0010\u0000\u0000;<\u0003\u0010\b\u0000<=\u0005\u0010"+
		"\u0000\u0000=>\u0003\f\u0006\u0000>?\u0005\t\u0000\u0000?@\u0005\n\u0000"+
		"\u0000@A\u0003\u0002\u0001\u0000AB\u0005\u000b\u0000\u0000B\u0007\u0001"+
		"\u0000\u0000\u0000CD\u0005\u000f\u0000\u0000DE\u0005\b\u0000\u0000EF\u0003"+
		"\u000e\u0007\u0000FG\u0005\t\u0000\u0000GH\u0005\u0010\u0000\u0000H\t"+
		"\u0001\u0000\u0000\u0000IJ\u0005\u0001\u0000\u0000JM\u0005\u0014\u0000"+
		"\u0000KL\u0005\u0002\u0000\u0000LN\u0003\u000e\u0007\u0000MK\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000N\u000b\u0001\u0000\u0000\u0000"+
		"OP\u0005\u0014\u0000\u0000PQ\u0005\u0002\u0000\u0000QR\u0003\u000e\u0007"+
		"\u0000R\r\u0001\u0000\u0000\u0000SX\u0003\u0012\t\u0000TX\u0003\u0010"+
		"\b\u0000UX\u0005\u0012\u0000\u0000VX\u0005\u0014\u0000\u0000WS\u0001\u0000"+
		"\u0000\u0000WT\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001"+
		"\u0000\u0000\u0000X\u000f\u0001\u0000\u0000\u0000YZ\u0003\u0012\t\u0000"+
		"Z[\u0005\u0007\u0000\u0000[\\\u0003\u0012\t\u0000\\\u0011\u0001\u0000"+
		"\u0000\u0000]b\u0003\u0014\n\u0000^_\u0007\u0000\u0000\u0000_a\u0003\u0014"+
		"\n\u0000`^\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000b`\u0001\u0000"+
		"\u0000\u0000bc\u0001\u0000\u0000\u0000c\u0013\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000ej\u0003\u0016\u000b\u0000fg\u0007\u0001\u0000"+
		"\u0000gi\u0003\u0016\u000b\u0000hf\u0001\u0000\u0000\u0000il\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\u0015"+
		"\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mv\u0005\u0011\u0000"+
		"\u0000nv\u0005\u0012\u0000\u0000ov\u0005\u0013\u0000\u0000pv\u0005\u0014"+
		"\u0000\u0000qr\u0005\b\u0000\u0000rs\u0003\u000e\u0007\u0000st\u0005\t"+
		"\u0000\u0000tv\u0001\u0000\u0000\u0000um\u0001\u0000\u0000\u0000un\u0001"+
		"\u0000\u0000\u0000uo\u0001\u0000\u0000\u0000up\u0001\u0000\u0000\u0000"+
		"uq\u0001\u0000\u0000\u0000v\u0017\u0001\u0000\u0000\u0000wx\u0005\f\u0000"+
		"\u0000xy\u0005\b\u0000\u0000yz\u0003\u0010\b\u0000z{\u0005\t\u0000\u0000"+
		"{|\u0005\n\u0000\u0000|}\u0003\u0002\u0001\u0000}\u0081\u0005\u000b\u0000"+
		"\u0000~\u0080\u0003\u001a\r\u0000\u007f~\u0001\u0000\u0000\u0000\u0080"+
		"\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0086\u0003\u001c\u000e\u0000\u0085"+
		"\u0084\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0019\u0001\u0000\u0000\u0000\u0087\u0088\u0005\r\u0000\u0000\u0088\u0089"+
		"\u0005\f\u0000\u0000\u0089\u008a\u0005\b\u0000\u0000\u008a\u008b\u0003"+
		"\u0010\b\u0000\u008b\u008c\u0005\t\u0000\u0000\u008c\u008d\u0005\n\u0000"+
		"\u0000\u008d\u008e\u0003\u0002\u0001\u0000\u008e\u008f\u0005\u000b\u0000"+
		"\u0000\u008f\u001b\u0001\u0000\u0000\u0000\u0090\u0091\u0005\r\u0000\u0000"+
		"\u0091\u0092\u0005\n\u0000\u0000\u0092\u0093\u0003\u0002\u0001\u0000\u0093"+
		"\u0094\u0005\u000b\u0000\u0000\u0094\u001d\u0001\u0000\u0000\u0000\t$"+
		"5MWbju\u0081\u0085";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}