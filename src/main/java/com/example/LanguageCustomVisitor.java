package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object> {

    // Clase auxiliar para almacenar tipo y valor
    private static class Simbolo {
        String tipo;
        Object valor;
        Simbolo(String tipo, Object valor) {
            this.tipo = tipo;
            this.valor = valor;
        }
    }

    private final Map<String, Simbolo> tablaSimbolos = new HashMap<>();
    private static final Set<String> PALABRAS_RESERVADAS = Set.of("int", "double", "if", "else", "for", "while", "return");

    public static void main(String[] args) throws IOException {
        String files[] = args.length == 0 ? new String[]{"test.lang"} : args;
        System.out.println("Dirbase: src/test/resources/");
        for (String file : files) {
            System.out.println("START: " + file);

            LanguageCustomVisitor visitor = new LanguageCustomVisitor(); // Declarar fuera del bloque try
            try {
                CharStream in = CharStreams.fromFileName("src/test/resources/" + file);
                LanguageLexer lexer = new LanguageLexer(in);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LanguageParser parser = new LanguageParser(tokens);
                parser.removeErrorListeners(); // Elimina los listeners predeterminados
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                        System.err.println("Error de sintaxis en la línea " + line + ":" + charPositionInLine + " - " + msg);
                    }
                });
                LanguageParser.ProgramContext tree = parser.program();
                visitor.visit(tree);
            } catch (ArithmeticException e) {
                System.err.println("Error durante la ejecución: " + e.getMessage());
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                System.out.println("\n=== TABLA DE SÍMBOLOS FINAL ===");
                visitor.getTablaSimbolos().forEach((k, v) -> 
                    System.out.printf("%-10s = %-8s (%s)%n", k, v, (v != null) ? v.getClass().getSimpleName() : "null"));
            }

            System.out.println("FINISH: " + file);
        }
    }

    @Override
    public Object visitProgram(LanguageParser.ProgramContext ctx) {
        System.out.println("=== INICIANDO EJECUCIÓN ===");
        visit(ctx.secuencia());
        return null;
    }

    @Override
    public Object visitSecuencia(LanguageParser.SecuenciaContext ctx) {
        for (LanguageParser.InstruccionContext instruccion : ctx.instruccion()) {
            visit(instruccion);
        }
        return null;
    }

    @Override
    public Object visitInstruccion(LanguageParser.InstruccionContext ctx) {
        try {
            if (ctx.declaracion() != null) {
                return visit(ctx.declaracion());
            } else if (ctx.asignacion() != null) {
                return visit(ctx.asignacion());
            } else if (ctx.expArit() != null) {
                Object resultado = visit(ctx.expArit());
                System.out.println("Resultado de expresión aritmética: " + resultado);
                return resultado;
            } else if (ctx.expLogica() != null) {
                Object resultado = visit(ctx.expLogica());
                System.out.println("Resultado de expresión lógica: " + resultado);
                return resultado;
            } else if (ctx.printInstruccion() != null) {
                return visit(ctx.printInstruccion()); // Llama a visitPrintInstruccion
            } else if (ctx.ifBlock() != null) {
                return visit(ctx.ifBlock());
            } else if (ctx.forBlock() != null) {
                return visit(ctx.forBlock());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al procesar la instrucción: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Object visitDeclaracion(LanguageParser.DeclaracionContext ctx) {
        String id = ctx.ID().getText();
        String tipo = ctx.TIPO().getText();
        if (PALABRAS_RESERVADAS.contains(id)) {
            throw new RuntimeException("Error: '" + id + "' es una palabra reservada y no puede usarse como identificador.");
        }
        if (tablaSimbolos.containsKey(id)) {
            throw new RuntimeException("Error: La variable '" + id + "' ya ha sido declarada.");
        }
        Object valor = null;
        if (ctx.expresion() != null) {
            valor = visit(ctx.expresion());
            valor = convertirTipo(tipo, valor);
        }
        tablaSimbolos.put(id, new Simbolo(tipo, valor));
        System.out.println("Declaración: " + tipo + " " + id + " = " + valor);
        return null;
    }

    @Override
    public Object visitAsignacion(LanguageParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        if (!tablaSimbolos.containsKey(id)) {
            throw new RuntimeException("Error: La variable '" + id + "' no ha sido declarada.");
        }
        Simbolo simbolo = tablaSimbolos.get(id);
        Object valor = visit(ctx.expresion());
        valor = convertirTipo(simbolo.tipo, valor);
        simbolo.valor = valor;
        System.out.println("Asignación: " + id + " = " + valor);
        return null;
    }

    private Object convertirTipo(String tipo, Object valor) {
        if (valor == null) return null;
        switch (tipo) {
            case "int":
                if (valor instanceof Integer) return valor;
                if (valor instanceof Double) return ((Double) valor).intValue();
                break;
            case "float":
                if (valor instanceof Integer) return ((Integer) valor).doubleValue();
                if (valor instanceof Double) return valor;
                break;
            case "boolean":
                if (valor instanceof Boolean) return valor;
                break;
            case "string":
                return valor.toString();
        }
        throw new RuntimeException("Error: Tipo de dato incompatible para la variable de tipo '" + tipo + "'.");
    }

    @Override
    public Object visitIfBlock(LanguageParser.IfBlockContext ctx) {
        boolean condicion = (Boolean) visit(ctx.expLogica());
        System.out.println("Condición del if: " + condicion);
        if (condicion) {
            visit(ctx.secuencia());
        } else if (ctx.elseIfBlock() != null) {
            for (LanguageParser.ElseIfBlockContext elseIfCtx : ctx.elseIfBlock()) {
                boolean condicionElseIf = (Boolean) visit(elseIfCtx.expLogica());
                System.out.println("Condición del else if: " + condicionElseIf);
                if (condicionElseIf) {
                    visit(elseIfCtx.secuencia());
                    return null;
                }
            }
        }
        if (ctx.elseBlock() != null) {
            visit(ctx.elseBlock().secuencia());
        }
        return null;
    }

    @Override
    public Object visitExpLogica(LanguageParser.ExpLogicaContext ctx) {
        Object left = visit(ctx.expArit(0));
        Object right = visit(ctx.expArit(1));

        if (!(left instanceof Number) || !(right instanceof Number)) {
            throw new RuntimeException("Error: Operación lógica no válida entre tipos no numéricos.");
        }

        double leftValue = ((Number) left).doubleValue();
        double rightValue = ((Number) right).doubleValue();
        boolean result = false;

        switch (ctx.OP_REL().getText()) {
            case ">":
                result = leftValue > rightValue;
                break;
            case "<":
                result = leftValue < rightValue;
                break;
            case ">=":
                result = leftValue >= rightValue;
                break;
            case "<=":
                result = leftValue <= rightValue;
                break;
            case "==":
                result = leftValue == rightValue;
                break;
        }

        System.out.println("Expresión lógica: " + leftValue + " " + ctx.OP_REL().getText() + " " + rightValue + " = " + result);
        return result;
    }

    @Override
    public Object visitExpArit(LanguageParser.ExpAritContext ctx) {
        Object result = visit(ctx.termino(0));
        for (int i = 1; i < ctx.termino().size(); i++) {
            Object termino = visit(ctx.termino(i));
            if (!(result instanceof Number) || !(termino instanceof Number)) {
                throw new RuntimeException("Operación aritmética no válida entre tipos no numéricos.");
            }
            if (ctx.OP_SUMA(i - 1) != null) {
                result = ((Number) result).doubleValue() + ((Number) termino).doubleValue();
            } else if (ctx.OP_REST(i - 1) != null) {
                result = ((Number) result).doubleValue() - ((Number) termino).doubleValue();
            }
        }
        return result;
    }

    @Override
    public Object visitTermino(LanguageParser.TerminoContext ctx) {
        Object result = visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            Object factor = visit(ctx.factor(i));
            if (ctx.OP_DIV(i - 1) != null) {
                if (((Number) factor).doubleValue() == 0) {
                    throw new ArithmeticException("Error: División por cero. Deteniendo ejecución.");
                }
                result = ((Number) result).doubleValue() / ((Number) factor).doubleValue();
            }
        }
        return result;
    }

    @Override
    public Object visitFactor(LanguageParser.FactorContext ctx) {
        if (ctx.NUM() != null) {
            // Manejo de números
            String numText = ctx.NUM().getText();
            if (numText.contains(".")) {
                return Double.parseDouble(numText);
            } else {
                return Integer.parseInt(numText);
            }
        } else if (ctx.STRING() != null) {
            // Manejo de cadenas
            String text = ctx.STRING().getText();
            return text.substring(1, text.length() - 1); // Elimina las comillas dobles
        } else if (ctx.ID() != null) {
            // Manejo de identificadores (variables)
            String id = ctx.ID().getText();
            if (!tablaSimbolos.containsKey(id)) {
                throw new RuntimeException("Error: La variable '" + id + "' no ha sido declarada.");
            }
            Simbolo simbolo = tablaSimbolos.get(id);
            if (simbolo.valor == null) {
                throw new RuntimeException("Error: La variable '" + id + "' no ha sido asignada.");
            }
            return simbolo.valor;
        } else if (ctx.expresion() != null) {
            // Manejo de expresiones entre paréntesis
            return visit(ctx.expresion());
        }
        return null;
    }

    @Override
    public Object visitForBlock(LanguageParser.ForBlockContext ctx) {
        // Inicialización
        visit(ctx.declaracion());

        // Evaluación de la condición
        while ((Boolean) visit(ctx.expLogica())) {
            // Ejecutar el cuerpo del ciclo
            visit(ctx.secuencia());

            // Actualización de la variable
            visit(ctx.asignacion());
        }

        return null;
    }

    @Override
    public Object visitPrintInstruccion(LanguageParser.PrintInstruccionContext ctx) {
    System.out.println("Procesando instrucción print...");
    Object value = visit(ctx.expresion()); // Evalúa la expresión dentro de print
    System.out.println("Valor a imprimir: " + value);
    return null;
}

    public Map<String, Object> getTablaSimbolos() {
        // Para mantener compatibilidad con el método existente
        Map<String, Object> tabla = new HashMap<>();
        tablaSimbolos.forEach((k, v) -> tabla.put(k, v.valor));
        return tabla;
    }
}
