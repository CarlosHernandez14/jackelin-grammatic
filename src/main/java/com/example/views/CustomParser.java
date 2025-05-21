/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.views;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.fife.ui.rsyntaxtextarea.RSyntaxDocument;
import org.fife.ui.rsyntaxtextarea.RSyntaxUtilities;
import org.fife.ui.rsyntaxtextarea.parser.DefaultParseResult;
import org.fife.ui.rsyntaxtextarea.parser.DefaultParserNotice;
import org.fife.ui.rsyntaxtextarea.parser.ExtendedHyperlinkListener;
import org.fife.ui.rsyntaxtextarea.parser.ParseResult;
import org.fife.ui.rsyntaxtextarea.parser.ParserNotice;

import com.example.EvalVisitor;
import com.example.LanguageCustomVisitor;
import com.example.LanguageLexer;
import com.example.LanguageParser;
import com.example.utils.Language;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class CustomParser implements org.fife.ui.rsyntaxtextarea.parser.Parser {

    private final List<ParserNotice> notices = new ArrayList<>();


    private JTextArea textAreaConverted;
    private JTextArea textAreaOutput;
    private Language selectedLanguage;

    public void setTextAreaOutput(JTextArea textAreaOutput) {
        this.textAreaOutput = textAreaOutput;
    }

    public void setTextAreaConverted(JTextArea textAreaConverted) {
        this.textAreaConverted = textAreaConverted;
    }

    public void setSelectedLanguage(Language selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    @Override
    public ParseResult parse(RSyntaxDocument doc, String style) {
        notices.clear();
        DefaultParseResult result = new DefaultParseResult(this);

        try {
            String code = doc.getText(0, doc.getLength());
            CharStream input = CharStreams.fromString(code);
            LanguageLexer lexer = new LanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LanguageParser parser = new LanguageParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg, RecognitionException e) {
                    try {
                        int offset = doc.getDefaultRootElement().getElement(line - 1).getStartOffset() + charPositionInLine;
                        notices.add(new DefaultParserNotice(
                            CustomParser.this, msg, line, offset, 1));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            LanguageParser.ProgramContext tree = parser.program();

            try {
                EvalVisitor evalVisitor = new EvalVisitor();
                evalVisitor.visit(tree);
                textAreaOutput.setText(evalVisitor.getOutput());

                LanguageCustomVisitor visitor = new LanguageCustomVisitor();
                visitor.visit(tree);

                if (selectedLanguage == Language.JAVA) {
                    System.out.println("JAVA CHOSEN");
                    textAreaConverted.setText(String.join("\n", visitor.getJavaLines()));
                } else if (selectedLanguage == Language.CPP) {
                    System.out.println("CPP CHOSEN");
                    textAreaConverted.setText(String.join("\n", visitor.getCppLines()));
                }

            } catch (RuntimeException semEx) {
                String msg = semEx.getMessage();
                notices.add(new DefaultParserNotice(
                    CustomParser.this, msg, 1, 0, 1));
            }

        } catch (BadLocationException ble) {
            ble.printStackTrace();
        }

        for (ParserNotice pn : notices) {
            result.addNotice(pn);
        }
        return result;
    }

    @Override
    public ExtendedHyperlinkListener getHyperlinkListener() {
        return null;
    }

    @Override
    public URL getImageBase() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}