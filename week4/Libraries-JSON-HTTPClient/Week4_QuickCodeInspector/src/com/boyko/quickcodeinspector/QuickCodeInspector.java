package com.boyko.quickcodeinspector;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushCss;
import syntaxhighlighter.brush.BrushJScript;
import syntaxhighlighter.brush.BrushPhp;
import syntaxhighlighter.brush.BrushXml;
import syntaxhighlighter.theme.ThemeRDark;

public class QuickCodeInspector {
    public static void main(String[] args) throws IOException {
        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushXml());
        parser.setHtmlScript(true);
        parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(), new BrushJScript(), new BrushPhp()));
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
        highlighter.setFirstLine(10);
        highlighter.setContent(new File("KeyCodeTable.html"));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(highlighter);
        frame.pack();
        frame.setVisible(true);
    }
}
