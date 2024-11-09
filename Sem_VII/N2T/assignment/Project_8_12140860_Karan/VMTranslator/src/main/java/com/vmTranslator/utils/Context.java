package com.vmTranslator.utils;

public class Context {
    private int lineNumber;
    private String currentLine;
    private String fileName;

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

    public String getFileName() {
        return fileName;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine;
    }

    public void setFileName(String fileName) { this.fileName = fileName; }
}

