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
        // System.out.println("Dirbase: " + DIRBASE);
        
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
            // System.out.println("START: " + file);

            LanguageCustomVisitor visitor = new LanguageCustomVisitor();
            EvalVisitor evalVisitor = new EvalVisitor();
            try {
                CharStream in = CharStreams.fromFileName(DIRBASE + file);
                LanguageLexer lexer = new LanguageLexer(in);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LanguageParser parser = new LanguageParser(tokens);

                // Configurar el ErrorListener personalizado
                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPos, String msg, RecognitionException e) {
                        System.err.printf("Error sintaxis %d:%d %s\n", line, charPos, msg);
                    }
                });

                LanguageParser.ProgramContext tree = parser.program();
                visitor.visit(tree);

                System.out.println("=== CÓDIGO JAVA ===");
                visitor.getJavaLines().forEach(System.out::println);
                System.out.println("=== CÓDIGO C++ ===");
                visitor.getCppLines().forEach(System.out::println);

                // Ejecutar el visitor de evaluación
                System.out.println("=== RESULTADOS ===");
                evalVisitor.visit(tree);
                
                System.out.println(evalVisitor.getOutput());


            } catch (ArithmeticException e) {
                System.err.println("Error durante la ejecución: " + e.getMessage());
                System.exit(1); // Detener la ejecución
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage());
                System.exit(1); // Detener la ejecución
            } finally {
                // System.out.println("=== TABLA DE SÍMBOLOS FINAL ===");
                // visitor.tablaSimbolos.forEach((k,v) ->
                //     System.out.printf("%s = %s (%s)\n", k, v.valor, v.tipo)
                // );
                
            }

            // System.out.println("FINISH: " + file);
        }
    }
}
