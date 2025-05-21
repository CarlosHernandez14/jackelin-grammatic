package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.LanguageParser.InstruccionContext;

public class LanguageCustomVisitor extends LanguageBaseVisitor<Object> {

    // Clase interna para símbolos (solo guarda tipo)
    private static class Simbolo {
        String tipo;
        Simbolo(String tipo) { this.tipo = tipo; }
    }

    private final Map<String, Simbolo> tablaSimbolos = new HashMap<>();
    private final List<String> javaLines = new ArrayList<>();
    private final List<String> cppLines  = new ArrayList<>();

    private int indentLevel = 0;
    private String indent() { return "    ".repeat(indentLevel); }

    public List<String> getJavaLines() { return javaLines; }
    public List<String> getCppLines()  { return cppLines; }

    // Programa
    @Override
    public Object visitProgram(LanguageParser.ProgramContext ctx) {
        visit(ctx.secuencia());
        return null;
    }

    // Secuencia invoca cada instrucción
    @Override
    public Object visitSecuencia(LanguageParser.SecuenciaContext ctx) {
        for (InstruccionContext instr : ctx.instruccion()) {
            visit(instr);
        }
        return null;
    }

    // Declaración
    @Override
    public Object visitDeclaracion(LanguageParser.DeclaracionContext ctx) {
        String tipo = ctx.TIPO().getText();
        String id   = ctx.ID().getText();
        // expr como cadena target
        String expr = (String) visit(ctx.expresion());
        // Mapear tipos Java/C++
        String jTipo;
        switch (tipo) {
            case "entero":
                jTipo = "int";
                break;
            case "flotante":
                jTipo = "double";
                break;
            case "booleano":
                jTipo = "boolean";
                break;
            case "cadena":
                jTipo = "String";
                break;
            default:
                jTipo = "var";
                break;
        }
        String cTipo;
        switch (tipo) {
            case "entero":
                cTipo = "int";
                break;
            case "flotante":
                cTipo = "double";
                break;
            case "booleano":
                cTipo = "bool";
                break;
            case "cadena":
                cTipo = "std::string";
                break;
            default:
                cTipo = "auto";
                break;
        }
        javaLines.add(indent() + jTipo + " " + id + " = " + expr + ";");
        cppLines .add(indent() + cTipo + " " + id + " = " + expr + ";");
        tablaSimbolos.put(id, new Simbolo(tipo));
        return id + " = " + expr;
    }

    // Asignación
    @Override
    public Object visitAsignacion(LanguageParser.AsignacionContext ctx) {
        String id = ctx.ID().getText();
        String expr = (String) visit(ctx.expresion());
        javaLines.add(indent() + id + " = " + expr + ";");
        cppLines .add(indent() + id + " = " + expr + ";");
        return id + " = " + expr;
    }

    // Imprimir
    @Override
    public Object visitImprimir(LanguageParser.ImprimirContext ctx) {
        String expr = (String) visit(ctx.expresion());
        javaLines.add(indent() + "System.out.println(" + expr + ");");
        cppLines .add(indent() + "std::cout << " + expr + " << std::endl;");
        return null;
    }

    // Si…sino
    @Override
    public Object visitSiBloque(LanguageParser.SiBloqueContext ctx) {
        String cond = (String) visit(ctx.expLogica());
        javaLines.add(indent() + "if (" + cond + ") {");
        cppLines .add(indent() + "if (" + cond + ") {");
        indentLevel++;
        visit(ctx.secuencia(0));
        indentLevel--;
        javaLines.add(indent() + "}");
        cppLines .add(indent() + "}");
        if (ctx.SINO() != null) {
            javaLines.add(indent() + "else {");
            cppLines .add(indent() + "else {");
            indentLevel++;
            visit(ctx.secuencia(1));
            indentLevel--;
            javaLines.add(indent() + "}");
            cppLines .add(indent() + "}");
        }
        return null;
    }

    // Para
    @Override
    public Object visitParaBloque(LanguageParser.ParaBloqueContext ctx) {
        // Generamos la parte init y la capturamos:
        String init    = (String) visit(ctx.declaracion());
        javaLines.remove(javaLines.size()-1);
        String initCpp = (String) visit(ctx.declaracion());
        cppLines .remove(cppLines.size()-1);

        // Condición
        String cond   = (String) visit(ctx.expLogica());

        // Update
        String upd    = (String) visit(ctx.asignacion());
        javaLines.remove(javaLines.size()-1);
        cppLines .remove(cppLines.size()-1);

        // Emitimos el for
        javaLines.add(indent() + "for (" + init + "; " + cond + "; " + upd + ") {");
        cppLines .add(indent() + "for (" + initCpp + "; " + cond + "; " + upd + ") {");

        indentLevel++;
        visit(ctx.secuencia());
        indentLevel--;

        javaLines.add(indent() + "}");
        cppLines .add(indent() + "}");
        return null;
    }

    // Expr wrappers: delegar a reglas base
    @Override
    public Object visitExprLogica(LanguageParser.ExprLogicaContext ctx) {
        return visit(ctx.expLogica());
    }

    @Override
    public Object visitExprArit(LanguageParser.ExprAritContext ctx) {
        return visit(ctx.expArit());
    }

    @Override
    public Object visitExprId(LanguageParser.ExprIdContext ctx) {
        return ctx.ID().getText();
    }

    @Override
    public Object visitExprCadena(LanguageParser.ExprCadenaContext ctx) {
        return ctx.CADENA().getText();
    }

    @Override
    public Object visitExprBool(LanguageParser.ExprBoolContext ctx) {
        return ctx.BOOL().getText().equals("verdadero") ? "true" : "false";
    }

    // Regla base para lógica
    @Override
    public Object visitExpLogica(LanguageParser.ExpLogicaContext ctx) {
        String left  = (String) visit(ctx.expArit(0));
        String right = (String) visit(ctx.expArit(1));
        String op    = ctx.OP_REL().getText();
        return left + " " + op + " " + right;
    }

    // Regla base para aritmética
    @Override
    public Object visitExpArit(LanguageParser.ExpAritContext ctx) {
        String s = (String) visit(ctx.termino(0));
        for (int i = 1; i < ctx.termino().size(); i++) {
            String op = ctx.OP_SUMA(i-1) != null ? "+" : "-";
            s = s + " " + op + " " + (String) visit(ctx.termino(i));
        }
        return s;
    }

    @Override
    public Object visitTermino(LanguageParser.TerminoContext ctx) {
        String s = (String) visit(ctx.factor(0));
        for (int i = 1; i < ctx.factor().size(); i++) {
            String op = ctx.OP_DIV(i-1) != null ? "/" : "*";
            s = s + " " + op + " " + (String) visit(ctx.factor(i));
        }
        return s;
    }

    @Override
    public Object visitFactor(LanguageParser.FactorContext ctx) {
        if (ctx.NUM() != null) {
            return ctx.NUM().getText();
        } else if (ctx.ID() != null) {
            return ctx.ID().getText();
        } else {
            return (String) visit(ctx.expresion());
        }
    }
}