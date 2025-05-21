package com.example;

import java.util.HashMap;
import java.util.Map;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object> {

    // Representa una variable con tipo y valor
    public static class Simbolo {
        String tipo;
        Object valor;
        Simbolo(String tipo, Object valor) {
            this.tipo = tipo;
            this.valor = valor;
        }
    }

    public final Map<String, Simbolo> tablaSimbolos = new HashMap<>();

    @Override
    public Object visitProgram(LanguageParser.ProgramContext ctx) {
        visit(ctx.secuencia());
        return null;
    }

    @Override
    public Object visitDeclaracion(LanguageParser.DeclaracionContext ctx) {
        String id = ctx.ID().getText();
        String tipo = ctx.TIPO().getText();
        Object valor = visit(ctx.expresion());
        tablaSimbolos.put(id, new Simbolo(tipo, convertirTipo(tipo, valor)));
        return null;
    }

    @Override
    public Object visitAsignacion(LanguageParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        Simbolo simb = tablaSimbolos.get(id);
        if (simb == null) {
            throw new RuntimeException("Variable no declarada: " + id);
        }
        Object valor = convertirTipo(simb.tipo, visit(ctx.expresion()));
        simb.valor = valor;
        return null;
    }

    // Literales
    @Override
    public Object visitExprCadena(LanguageParser.ExprCadenaContext ctx) {
        String raw = ctx.CADENA().getText();
        return raw.substring(1, raw.length() - 1);
    }

    @Override
    public Object visitExprBool(LanguageParser.ExprBoolContext ctx) {
        return ctx.BOOL().getText().equals("verdadero");
    }

    // Identificador en expresión
    @Override
    public Object visitExprId(LanguageParser.ExprIdContext ctx) {
        String id = ctx.ID().getText();
        Simbolo simb = tablaSimbolos.get(id);
        if (simb == null || simb.valor == null) {
            throw new RuntimeException("Variable sin valor o no declarada: " + id);
        }
        return simb.valor;
    }

    // Lógica
    @Override
    public Object visitExpLogica(LanguageParser.ExpLogicaContext ctx) {
        double left = ((Number) visit(ctx.expArit(0))).doubleValue();
        double right = ((Number) visit(ctx.expArit(1))).doubleValue();
        switch (ctx.OP_REL().getText()) {
            case ">":  return left > right;
            case "<":  return left < right;
            case ">=": return left >= right;
            case "<=": return left <= right;
            case "==": return left == right;
            default:    return false;
        }
    }

    // Aritmética
    @Override
    public Object visitExpArit(LanguageParser.ExpAritContext ctx) {
        double res = ((Number) visit(ctx.termino(0))).doubleValue();
        for (int i = 1; i < ctx.termino().size(); i++) {
            double val = ((Number) visit(ctx.termino(i))).doubleValue();
            if (ctx.OP_SUMA(i - 1) != null) res += val;
            else                              res -= val;
        }
        return res;
    }

    @Override
    public Object visitTermino(LanguageParser.TerminoContext ctx) {
        double res = ((Number) visit(ctx.factor(0))).doubleValue();
        for (int i = 1; i < ctx.factor().size(); i++) {
            double val = ((Number) visit(ctx.factor(i))).doubleValue();
            if (ctx.OP_DIV(i - 1) != null) {
                if (val == 0) throw new RuntimeException("División por cero");
                res /= val;
            } else {
                res *= val;
            }
        }
        return res;
    }

    @Override
    public Object visitFactor(LanguageParser.FactorContext ctx) {
        if (ctx.NUM() != null) {
            String txt = ctx.NUM().getText();
            return txt.contains(".") ? Double.parseDouble(txt) : Integer.parseInt(txt);
        } else if (ctx.ID() != null) {
            // Acceso directo a variable
            String id = ctx.ID().getText();
            Simbolo simb = tablaSimbolos.get(id);
            if (simb == null || simb.valor == null) {
                throw new RuntimeException("Variable sin valor o no declarada: " + id);
            }
            return simb.valor;
        } else {
            // Subexpresión
            return visit(ctx.expresion());
        }
    }

    // Si…sino
    @Override
    public Object visitSiBloque(LanguageParser.SiBloqueContext ctx) {
        boolean cond = (Boolean) visit(ctx.expLogica());
        if (cond) {
            visit(ctx.secuencia(0));
        } else if (ctx.SINO() != null) {
            visit(ctx.secuencia(1));
        }
        return null;
    }

    // Para
    @Override
    public Object visitParaBloque(LanguageParser.ParaBloqueContext ctx) {
        // inicialización
        visit(ctx.declaracion());
        // iteración
        while ((Boolean) visit(ctx.expLogica())) {
            visit(ctx.secuencia());
            visit(ctx.asignacion());
        }
        return null;
    }

    // imprimir solo muestra el valor
    @Override
    public Object visitImprimir(LanguageParser.ImprimirContext ctx) {
        Object val = visit(ctx.expresion());
        System.out.println(val);
        return null;
    }

    // Conversión de tipos según el TIPO
    private Object convertirTipo(String tipo, Object val) {
        if (val == null) return null;
        switch (tipo) {
            case "entero":   return ((Number) val).intValue();
            case "flotante": return ((Number) val).doubleValue();
            case "booleano": return (Boolean) val;
            case "cadena":   return val.toString();
            default: throw new RuntimeException("Tipo desconocido: " + tipo);
        }
    }
}