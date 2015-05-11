package com.boyko.quickcodeinspector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.theme.ThemeMidnight;

public class test {
    static JFrame frame;
    File file;
    int index;
    SyntaxHighlighter highlighter;
    static List<File> parentList;
    static KeyListener keyListener;

    private static SyntaxHighlighter createHighlighter(File file) {
        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeMidnight());
        highlighter.setHighlightOnMouseOver(true);

        try {
            highlighter.setContent(file);
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        return highlighter;
    }

    private static JFrame createJFrame(File file) {
        SyntaxHighlighter highlighter = createHighlighter(file);
        test.frame = new JFrame();
        frame.setTitle(file.getName());
        frame.setFocusable(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(highlighter);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    private static KeyListener createKyeListener(final test quickCodeInspector) {

        final KeyListener keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent key) {
            }

            @Override
            public void keyReleased(KeyEvent key) {
            }

            @Override
            public void keyPressed(KeyEvent key) {
                switch (key.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        frame = onLeftClick(quickCodeInspector);
                        break;
                    case KeyEvent.VK_RIGHT:
                        frame = onRightClick(quickCodeInspector);
                        break;
                    default:
                        break;
                }
            }
        };
        return keyListener;
    }

    private static List<File> getParentFileList(File file) throws IOException {
        File parent = file.getParentFile();
        List<File> parentList = new ArrayList<File>(Arrays.asList(parent.listFiles()));

        for (File checkFile : parentList) {
            String canonicalPath = checkFile.getCanonicalPath();
//            if (!canonicalPath.endsWith(".java")) {
//                parentList.remove(checkFile);
//            }
        }
        return parentList;
    }

    private static File getPreviousFile(File file) {
        int index = parentList.indexOf(file);
        File previousFile;
        if (index == 0) {
            previousFile = parentList.get(parentList.size() - 1);
        } else {
            previousFile = parentList.get(index - 1);
        }
        return previousFile;
    }

    private static File getNextFile(File file) {
        int index = parentList.indexOf(file);
        File nextFile;
        if (index == (parentList.size() - 1)) {
            nextFile = parentList.get(0);
        } else {
            nextFile = parentList.get(index + 1);
        }
        return nextFile;
    }

    private static JFrame onLeftClick(test quickCodeInspector) {
        frame.dispose();
        File newFile = getPreviousFile(quickCodeInspector.file);
        quickCodeInspector.file = newFile;
        frame = createJFrame(newFile);
        frame.addKeyListener(keyListener);
        return frame;
    }

    public static JFrame onRightClick(test quickCodeInspector) {
        frame.dispose();
        File newFile = getNextFile(quickCodeInspector.file);
        quickCodeInspector.file = newFile;
        frame = createJFrame(newFile);
        frame.addKeyListener(keyListener);
        return frame;
    }

    public static void main(String[] args) {
        final test quickCodeInspector = new test();
        quickCodeInspector.file = new File("C:\\Users\\Bojko\\Desktop");

        try {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    quickCodeInspector.highlighter = createHighlighter(quickCodeInspector.file);

                    try {
                        parentList = getParentFileList(quickCodeInspector.file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    keyListener = createKyeListener(quickCodeInspector);
                    frame = createJFrame(quickCodeInspector.file);
                    frame.addKeyListener(keyListener);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
