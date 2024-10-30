package com.vmTranslator;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private int lineNumber;
    private String currentLine;

    public Context(int lineNumber, String currentLine) {
        this.lineNumber = lineNumber;
        this.currentLine = currentLine;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getCurrentLine() {
        return currentLine;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine;
    }


}

