// Generated from c:/Users/carlo/Documents/Antlr/ilitia/src/main/antlr4/com/example/Language.g4 by ANTLR 4.13.1
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
		FIN_STMT=1, FIN_PROG=2, TIPO=3, OP_ASIG=4, OP_SUMA=5, OP_REST=6, OP_MULT=7, 
		OP_DIV=8, OP_REL=9, PAREIZ=10, PAREDR=11, LLAVEIZQ=12, LLAVEDER=13, SI=14, 
		SINO=15, PARA=16, IMPRIMIR=17, NUM=18, CADENA=19, BOOL=20, ID=21, LINE_COMMENT=22, 
		WS=23;
	public static final int
		RULE_program = 0, RULE_secuencia = 1, RULE_instruccion = 2, RULE_declaracion = 3, 
		RULE_asignacion = 4, RULE_expresion = 5, RULE_expLogica = 6, RULE_expArit = 7, 
		RULE_termino = 8, RULE_factor = 9, RULE_siBloque = 10, RULE_paraBloque = 11, 
		RULE_imprimir = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "secuencia", "instruccion", "declaracion", "asignacion", "expresion", 
			"expLogica", "expArit", "termino", "factor", "siBloque", "paraBloque", 
			"imprimir"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'fin'", "'finprog'", null, "'<-'", "'+'", "'-'", "'*'", "'/'", 
			null, "'('", "')'", "'{'", "'}'", "'si'", "'sino'", "'para'", "'imprimir'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FIN_STMT", "FIN_PROG", "TIPO", "OP_ASIG", "OP_SUMA", "OP_REST", 
			"OP_MULT", "OP_DIV", "OP_REL", "PAREIZ", "PAREDR", "LLAVEIZQ", "LLAVEDER", 
			"SI", "SINO", "PARA", "IMPRIMIR", "NUM", "CADENA", "BOOL", "ID", "LINE_COMMENT", 
			"WS"
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
		public TerminalNode FIN_PROG() { return getToken(LanguageParser.FIN_PROG, 0); }
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
			setState(26);
			secuencia();
			setState(27);
			match(FIN_PROG);
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
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				instruccion();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4146184L) != 0) );
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
		public TerminalNode FIN_STMT() { return getToken(LanguageParser.FIN_STMT, 0); }
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SiBloqueContext siBloque() {
			return getRuleContext(SiBloqueContext.class,0);
		}
		public ParaBloqueContext paraBloque() {
			return getRuleContext(ParaBloqueContext.class,0);
		}
		public ImprimirContext imprimir() {
			return getRuleContext(ImprimirContext.class,0);
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
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				declaracion();
				setState(35);
				match(FIN_STMT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				asignacion();
				setState(38);
				match(FIN_STMT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				expresion();
				setState(41);
				match(FIN_STMT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				siBloque();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				paraBloque();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				imprimir();
				setState(46);
				match(FIN_STMT);
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
		enterRule(_localctx, 6, RULE_declaracion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(TIPO);
			setState(51);
			match(ID);
			setState(52);
			match(OP_ASIG);
			setState(53);
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
		enterRule(_localctx, 8, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ID);
			setState(56);
			match(OP_ASIG);
			setState(57);
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
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCadenaContext extends ExpresionContext {
		public TerminalNode CADENA() { return getToken(LanguageParser.CADENA, 0); }
		public ExprCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAritContext extends ExpresionContext {
		public ExpAritContext expArit() {
			return getRuleContext(ExpAritContext.class,0);
		}
		public ExprAritContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBoolContext extends ExpresionContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public ExprBoolContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIdContext extends ExpresionContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprIdContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLogicaContext extends ExpresionContext {
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public ExprLogicaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expresion);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ExprCadenaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(CADENA);
				}
				break;
			case 2:
				_localctx = new ExprBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(BOOL);
				}
				break;
			case 3:
				_localctx = new ExprIdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(ID);
				}
				break;
			case 4:
				_localctx = new ExprLogicaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				expLogica();
				}
				break;
			case 5:
				_localctx = new ExprAritContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				expArit();
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
		enterRule(_localctx, 12, RULE_expLogica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			expArit();
			setState(67);
			match(OP_REL);
			setState(68);
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
		enterRule(_localctx, 14, RULE_expArit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			termino();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SUMA || _la==OP_REST) {
				{
				{
				setState(71);
				_la = _input.LA(1);
				if ( !(_la==OP_SUMA || _la==OP_REST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(72);
				termino();
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
		enterRule(_localctx, 16, RULE_termino);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			factor();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MULT || _la==OP_DIV) {
				{
				{
				setState(79);
				_la = _input.LA(1);
				if ( !(_la==OP_MULT || _la==OP_DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(80);
				factor();
				}
				}
				setState(85);
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
		enterRule(_localctx, 18, RULE_factor);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(NUM);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				match(ID);
				}
				break;
			case PAREIZ:
				enterOuterAlt(_localctx, 3);
				{
				setState(88);
				match(PAREIZ);
				setState(89);
				expresion();
				setState(90);
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
	public static class SiBloqueContext extends ParserRuleContext {
		public TerminalNode SI() { return getToken(LanguageParser.SI, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public List<TerminalNode> LLAVEIZQ() { return getTokens(LanguageParser.LLAVEIZQ); }
		public TerminalNode LLAVEIZQ(int i) {
			return getToken(LanguageParser.LLAVEIZQ, i);
		}
		public List<SecuenciaContext> secuencia() {
			return getRuleContexts(SecuenciaContext.class);
		}
		public SecuenciaContext secuencia(int i) {
			return getRuleContext(SecuenciaContext.class,i);
		}
		public List<TerminalNode> LLAVEDER() { return getTokens(LanguageParser.LLAVEDER); }
		public TerminalNode LLAVEDER(int i) {
			return getToken(LanguageParser.LLAVEDER, i);
		}
		public TerminalNode SINO() { return getToken(LanguageParser.SINO, 0); }
		public SiBloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_siBloque; }
	}

	public final SiBloqueContext siBloque() throws RecognitionException {
		SiBloqueContext _localctx = new SiBloqueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_siBloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(SI);
			setState(95);
			match(PAREIZ);
			setState(96);
			expLogica();
			setState(97);
			match(PAREDR);
			setState(98);
			match(LLAVEIZQ);
			setState(99);
			secuencia();
			setState(100);
			match(LLAVEDER);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINO) {
				{
				setState(101);
				match(SINO);
				setState(102);
				match(LLAVEIZQ);
				setState(103);
				secuencia();
				setState(104);
				match(LLAVEDER);
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
	public static class ParaBloqueContext extends ParserRuleContext {
		public TerminalNode PARA() { return getToken(LanguageParser.PARA, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<TerminalNode> FIN_STMT() { return getTokens(LanguageParser.FIN_STMT); }
		public TerminalNode FIN_STMT(int i) {
			return getToken(LanguageParser.FIN_STMT, i);
		}
		public ExpLogicaContext expLogica() {
			return getRuleContext(ExpLogicaContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public TerminalNode LLAVEIZQ() { return getToken(LanguageParser.LLAVEIZQ, 0); }
		public SecuenciaContext secuencia() {
			return getRuleContext(SecuenciaContext.class,0);
		}
		public TerminalNode LLAVEDER() { return getToken(LanguageParser.LLAVEDER, 0); }
		public ParaBloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paraBloque; }
	}

	public final ParaBloqueContext paraBloque() throws RecognitionException {
		ParaBloqueContext _localctx = new ParaBloqueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_paraBloque);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(PARA);
			setState(109);
			match(PAREIZ);
			setState(110);
			declaracion();
			setState(111);
			match(FIN_STMT);
			setState(112);
			expLogica();
			setState(113);
			match(FIN_STMT);
			setState(114);
			asignacion();
			setState(115);
			match(PAREDR);
			setState(116);
			match(LLAVEIZQ);
			setState(117);
			secuencia();
			setState(118);
			match(LLAVEDER);
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
	public static class ImprimirContext extends ParserRuleContext {
		public TerminalNode IMPRIMIR() { return getToken(LanguageParser.IMPRIMIR, 0); }
		public TerminalNode PAREIZ() { return getToken(LanguageParser.PAREIZ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREDR() { return getToken(LanguageParser.PAREDR, 0); }
		public ImprimirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imprimir; }
	}

	public final ImprimirContext imprimir() throws RecognitionException {
		ImprimirContext _localctx = new ImprimirContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_imprimir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(IMPRIMIR);
			setState(121);
			match(PAREIZ);
			setState(122);
			expresion();
			setState(123);
			match(PAREDR);
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
		"\u0004\u0001\u0017~\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001"+
		"\u001f\b\u0001\u000b\u0001\f\u0001 \u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"1\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005A\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007J\b\u0007\n\u0007\f\u0007M\t\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0005\bR\b\b\n\b\f\bU\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t]\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nk\b\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002\u0001\u0000\u0005"+
		"\u0006\u0001\u0000\u0007\b\u007f\u0000\u001a\u0001\u0000\u0000\u0000\u0002"+
		"\u001e\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000\u00062\u0001"+
		"\u0000\u0000\u0000\b7\u0001\u0000\u0000\u0000\n@\u0001\u0000\u0000\u0000"+
		"\fB\u0001\u0000\u0000\u0000\u000eF\u0001\u0000\u0000\u0000\u0010N\u0001"+
		"\u0000\u0000\u0000\u0012\\\u0001\u0000\u0000\u0000\u0014^\u0001\u0000"+
		"\u0000\u0000\u0016l\u0001\u0000\u0000\u0000\u0018x\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0003\u0002\u0001\u0000\u001b\u001c\u0005\u0002\u0000\u0000"+
		"\u001c\u0001\u0001\u0000\u0000\u0000\u001d\u001f\u0003\u0004\u0002\u0000"+
		"\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u0003\u0001\u0000"+
		"\u0000\u0000\"#\u0003\u0006\u0003\u0000#$\u0005\u0001\u0000\u0000$1\u0001"+
		"\u0000\u0000\u0000%&\u0003\b\u0004\u0000&\'\u0005\u0001\u0000\u0000\'"+
		"1\u0001\u0000\u0000\u0000()\u0003\n\u0005\u0000)*\u0005\u0001\u0000\u0000"+
		"*1\u0001\u0000\u0000\u0000+1\u0003\u0014\n\u0000,1\u0003\u0016\u000b\u0000"+
		"-.\u0003\u0018\f\u0000./\u0005\u0001\u0000\u0000/1\u0001\u0000\u0000\u0000"+
		"0\"\u0001\u0000\u0000\u00000%\u0001\u0000\u0000\u00000(\u0001\u0000\u0000"+
		"\u00000+\u0001\u0000\u0000\u00000,\u0001\u0000\u0000\u00000-\u0001\u0000"+
		"\u0000\u00001\u0005\u0001\u0000\u0000\u000023\u0005\u0003\u0000\u0000"+
		"34\u0005\u0015\u0000\u000045\u0005\u0004\u0000\u000056\u0003\n\u0005\u0000"+
		"6\u0007\u0001\u0000\u0000\u000078\u0005\u0015\u0000\u000089\u0005\u0004"+
		"\u0000\u00009:\u0003\n\u0005\u0000:\t\u0001\u0000\u0000\u0000;A\u0005"+
		"\u0013\u0000\u0000<A\u0005\u0014\u0000\u0000=A\u0005\u0015\u0000\u0000"+
		">A\u0003\f\u0006\u0000?A\u0003\u000e\u0007\u0000@;\u0001\u0000\u0000\u0000"+
		"@<\u0001\u0000\u0000\u0000@=\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000"+
		"\u0000@?\u0001\u0000\u0000\u0000A\u000b\u0001\u0000\u0000\u0000BC\u0003"+
		"\u000e\u0007\u0000CD\u0005\t\u0000\u0000DE\u0003\u000e\u0007\u0000E\r"+
		"\u0001\u0000\u0000\u0000FK\u0003\u0010\b\u0000GH\u0007\u0000\u0000\u0000"+
		"HJ\u0003\u0010\b\u0000IG\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000L\u000f\u0001\u0000"+
		"\u0000\u0000MK\u0001\u0000\u0000\u0000NS\u0003\u0012\t\u0000OP\u0007\u0001"+
		"\u0000\u0000PR\u0003\u0012\t\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0011"+
		"\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000V]\u0005\u0012\u0000"+
		"\u0000W]\u0005\u0015\u0000\u0000XY\u0005\n\u0000\u0000YZ\u0003\n\u0005"+
		"\u0000Z[\u0005\u000b\u0000\u0000[]\u0001\u0000\u0000\u0000\\V\u0001\u0000"+
		"\u0000\u0000\\W\u0001\u0000\u0000\u0000\\X\u0001\u0000\u0000\u0000]\u0013"+
		"\u0001\u0000\u0000\u0000^_\u0005\u000e\u0000\u0000_`\u0005\n\u0000\u0000"+
		"`a\u0003\f\u0006\u0000ab\u0005\u000b\u0000\u0000bc\u0005\f\u0000\u0000"+
		"cd\u0003\u0002\u0001\u0000dj\u0005\r\u0000\u0000ef\u0005\u000f\u0000\u0000"+
		"fg\u0005\f\u0000\u0000gh\u0003\u0002\u0001\u0000hi\u0005\r\u0000\u0000"+
		"ik\u0001\u0000\u0000\u0000je\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000k\u0015\u0001\u0000\u0000\u0000lm\u0005\u0010\u0000\u0000mn\u0005"+
		"\n\u0000\u0000no\u0003\u0006\u0003\u0000op\u0005\u0001\u0000\u0000pq\u0003"+
		"\f\u0006\u0000qr\u0005\u0001\u0000\u0000rs\u0003\b\u0004\u0000st\u0005"+
		"\u000b\u0000\u0000tu\u0005\f\u0000\u0000uv\u0003\u0002\u0001\u0000vw\u0005"+
		"\r\u0000\u0000w\u0017\u0001\u0000\u0000\u0000xy\u0005\u0011\u0000\u0000"+
		"yz\u0005\n\u0000\u0000z{\u0003\n\u0005\u0000{|\u0005\u000b\u0000\u0000"+
		"|\u0019\u0001\u0000\u0000\u0000\u0007 0@KS\\j";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}