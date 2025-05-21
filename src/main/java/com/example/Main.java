package com.example;

import com.example.views.HomeWindow;
import com.github.weisj.darklaf.theme.laf.DarculaThemeDarklafLookAndFeel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class Main {

    private static final String EXTENSION = "lang";
    private static final String DIRBASE = "src/test/resources/";


    public static void main(String[] args) throws IOException {
        String files[] = args.length == 0 ? new String[]{"test." + EXTENSION} : args;
        System.out.println("Dirbase: " + DIRBASE);
        
        try {
            UIManager.setLookAndFeel(new DarculaThemeDarklafLookAndFeel());
            // (opcional) seleccionar un tema específico:
            // LafManager.setTheme(LafManager.getInstalledThemes().get(0));
        } catch (UnsupportedLookAndFeelException ex) {
        }

        // 2. Crear y mostrar tu ventana
        SwingUtilities.invokeLater(() -> {
            new HomeWindow().setVisible(true);
        });
        
        for (String file : files) {
            System.out.println("START: " + file);

            LanguageCustomVisitor visitor = new LanguageCustomVisitor();
            try {
                CharStream in = CharStreams.fromFileName(DIRBASE + file);
                LanguageLexer lexer = new LanguageLexer(in);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LanguageParser parser = new LanguageParser(tokens);

                // Configurar el ErrorListener personalizado
                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                        System.err.println("Error de sintaxis en la línea " + line + ":" + charPositionInLine + " - " + msg);
                        throw new RuntimeException("Error de sintaxis detectado. Deteniendo ejecución.");
                    }
                });

                LanguageParser.ProgramContext tree = parser.program();
                visitor.visit(tree);
            } catch (ArithmeticException e) {
                System.err.println("Error durante la ejecución: " + e.getMessage());
                System.exit(1); // Detener la ejecución
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage());
                System.exit(1); // Detener la ejecución
            } finally {
                System.out.println("\n=== TABLA DE SÍMBOLOS FINAL ===");
                visitor.getTablaSimbolos().forEach((k, v) -> 
                    System.out.printf("%-10s = %-8s (%s)%n", k, v, (v != null) ? v.getClass().getSimpleName() : "null"));
            }

            System.out.println("FINISH: " + file);
        }
    }
}
