package com.compiler;

import com.compiler.CustomExceptions.SyntaxExceptions;
import com.compiler.CustomExceptions.SyntaxExceptions.*;
import com.compiler.Utils.EnumClass.KeywordType;
import com.compiler.Utils.EnumClass.TokenType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CompilationEngine{
    private final Path outputFilePath;
    private final BufferedWriter writer;
    public final JackTokenizer tokenizer;
    private int indentationLevel;

    public CompilationEngine(Path outputFilePath, JackTokenizer tokenizer) throws IOException {
        this.indentationLevel = 0;
        this.tokenizer = tokenizer;
        this.outputFilePath = outputFilePath;
        writer = new BufferedWriter(new FileWriter(outputFilePath.toFile()));
    }

    private void printIndented(String text) throws IOException{
        for (int i = 0; i < indentationLevel; i++)
            writer.write("  ");
        writer.write(text + "\n");
    }

    public void compileClass() throws IOException, SyntaxExceptions {
        printIndented("<class>");
        indentationLevel++;

        if (tokenizer.tokenType() == TokenType.KEYWORD && tokenizer.keyWord() == KeywordType.CLASS) {
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>");
        } else {
            throw new IllegalClassKeywordException();
        }

        tokenizer.advance(); // Class name
        if (tokenizer.tokenType() == TokenType.IDENTIFIER) {
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
        } else {
            throw new IllegalClassNameException();
        }

        tokenizer.advance(); // '{'
        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '{') {
            printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
        } else {
            throw new InvalidOpeningBracketsException();
        }

        tokenizer.advance(); // class var dec
        while (tokenizer.tokenType() == TokenType.KEYWORD &&
                (tokenizer.keyWord() == KeywordType.STATIC || tokenizer.keyWord() == KeywordType.FIELD)) {
            compileClassVarDec();
        }

        // Compile subroutine declarations
        while (tokenizer.tokenType() == TokenType.KEYWORD &&
                (tokenizer.keyWord() == KeywordType.CONSTRUCTOR ||
                        tokenizer.keyWord() == KeywordType.FUNCTION ||
                        tokenizer.keyWord() == KeywordType.METHOD)) {
            compileSubroutine();
        }

        // Check for closing '}'
        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '}') {
            printIndented("<symbol> } </symbol>");
        } else {
            throw new InvalidClosingBracketsException();
        }

        indentationLevel--;
        printIndented("</class>");
        tokenizer.advance();
    }

    public void compileClassVarDec() throws IOException, SyntaxExceptions{
        printIndented("<classVarDec>");
        indentationLevel++;

        // Process 'static' or 'field'
        if (tokenizer.tokenType() == TokenType.KEYWORD &&
                (tokenizer.keyWord() == KeywordType.STATIC || tokenizer.keyWord() == KeywordType.FIELD)) {
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>");
        } else {
            throw new InvalidClassVariableKeywordException();
        }

        // var type
        tokenizer.advance();
        if (tokenizer.tokenType() == TokenType.KEYWORD)
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>");
        else if(tokenizer.tokenType() == TokenType.IDENTIFIER )
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
        else throw new InvalidVariableTypeException();

        // first var name
        tokenizer.advance();
        if (tokenizer.tokenType() == TokenType.IDENTIFIER) {
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
        } else {
            throw new InvalidVariableNameException();
        }

        // Process additional variable names if separated by commas
        while (true) {
            tokenizer.advance();
            if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == ',') {
                printIndented("<symbol> , </symbol>");
                tokenizer.advance();
                if (tokenizer.tokenType() == TokenType.IDENTIFIER)
                    printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
                else
                    throw new VariableNameNotFoundException();
            } else break;
        }

        // Process ';'
        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == ';') {
            printIndented("<symbol> ; </symbol>");
        } else {
            throw new SemicolonNotFoundException();
        }

        indentationLevel--;
        printIndented("</classVarDec>");
        tokenizer.advance();
    }

    public void compileSubroutine() throws IOException, SyntaxExceptions{
        printIndented("<subroutineDec>");
        indentationLevel++;

        // 'constructor', 'function', or 'method'
        if (tokenizer.tokenType() == TokenType.KEYWORD &&
                (tokenizer.keyWord().equals(KeywordType.CONSTRUCTOR) ||
                        tokenizer.keyWord().equals(KeywordType.FUNCTION) ||
                        tokenizer.keyWord().equals(KeywordType.METHOD))) {
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>");
        } else {
            throw new IllegalArgumentException("Expected 'constructor', 'function', or 'method' at start of subroutineDec.");
        }

        // return type
        tokenizer.advance();
        if (
                tokenizer.tokenType() == TokenType.KEYWORD &&
                        (
                                tokenizer.keyWord().equals(KeywordType.VOID) ||(tokenizer.keyWord().equals(KeywordType.INT))
                                ||(tokenizer.keyWord().equals(KeywordType.CHAR)) ||(tokenizer.keyWord().equals(KeywordType.BOOLEAN))
                        )
        ) {
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>");
        }else if( tokenizer.tokenType() == TokenType.IDENTIFIER){
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
        }
        else {
            throw new IllegalArgumentException("Expected return type (void, int, char, boolean, or class name) in subroutineDec.");
        }

        // Subroutine name
        tokenizer.advance();
        if (tokenizer.tokenType() == TokenType.IDENTIFIER) {
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
        } else {
            throw new IllegalArgumentException("Expected subroutine name identifier in subroutineDec.");
        }

        // '(' and parameter list
        tokenizer.advance();
        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol().equals('(')) {
            printIndented("<symbol> ( </symbol>");
        } else {
            throw new IllegalArgumentException("Expected '(' before parameterList in subroutineDec.");
        }

        // parameter list
        tokenizer.advance();
        compileParameterList();

        // Process ")"
        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol().equals(')')) {
            printIndented("<symbol> "+ tokenizer.symbol()+" </symbol>");
        } else {
            throw new IllegalArgumentException("Expected ')' after parameterList in subroutineDec.");
        }

        // Subroutine body
        tokenizer.advance();
        compileSubroutineBody();

        indentationLevel--;
        printIndented("</subroutineDec>");
    }

    public void compileParameterList() throws IOException{
        printIndented("<parameterList>");
        indentationLevel++;

        // TODO: here check only valid type not all keywords
        if (tokenizer.tokenType() == TokenType.KEYWORD || tokenizer.tokenType() == TokenType.IDENTIFIER) {
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>"); // Type
            tokenizer.advance();
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>"); // VarName

            // additional parameters (',' type varName)*
            while (true) {
                tokenizer.advance();
                if (tokenizer.tokenType()==TokenType.SYMBOL && tokenizer.symbol().equals(',')) {
                    printIndented("<symbol> , </symbol>");
                    tokenizer.advance();
                    printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>"); // Type
                    tokenizer.advance();
                    printIndented("<identifier> " + tokenizer.identifier() + " </identifier>"); // VarName
                } else break;
            }
        }

        indentationLevel--;
        printIndented("</parameterList>");
    }

    public void compileSubroutineBody() throws IOException, SyntaxExceptions{
        printIndented("<subroutineBody>");
        indentationLevel++;

        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '{') {
            printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
        } else {
            throw new InvalidOpeningBracketsException();
        }

        // Compile variable declarations within the body
        tokenizer.advance();
        while (tokenizer.tokenType()==TokenType.KEYWORD &&
                tokenizer.keyWord().equals(KeywordType.VAR)) {
            compileVarDec();
        }

        // Compile statements
        compileStatements();

        // Closing '}'
        if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '}') {
            printIndented("<symbol> } </symbol>");
        } else {
            throw new InvalidClosingBracketsException();
        }

        indentationLevel--;
        printIndented("</subroutineBody>");
        tokenizer.advance();
    }

    public void compileVarDec() throws IOException{
        printIndented("<varDec>");
        indentationLevel++;

        //var
        printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");

        tokenizer.advance(); // type of variable
        if(tokenizer.tokenType()==TokenType.KEYWORD)
            printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");
        else
            printIndented("<identifier> "+tokenizer.identifier()+" </identifier>");

        tokenizer.advance(); // name of variable
        printIndented("<identifier> "+tokenizer.identifier()+" </identifier>");

        // Additional variable names separated by commas
        while (true) {
            tokenizer.advance();
            if (!tokenizer.getCurrentToken().equals(",")) {
                break;
            }
            printIndented("<symbol> , </symbol>");

            // Next variable name
            tokenizer.advance();
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
        }

        //;
        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
        tokenizer.advance();

        indentationLevel--;
        printIndented("</varDec>");
    }

    public void compileStatements() throws IOException{
        printIndented("<statements>");
        indentationLevel++;

        statementsLoop:
        while(tokenizer.hasMoreTokens()){
            switch (tokenizer.getCurrentToken()) {
                case "let":
                    compileLet();
                    break;
                case "do":
                    compileDo();
                    break;
                case "while":
                    compileWhile();
                    break;
                case "return":
                    compileReturn();
                    break;
                case "if":
                    compileIf();
                    break;
                default:
                    break statementsLoop;
            }
        }

        indentationLevel--;
        printIndented("</statements>");
    }

    public void compileLet() throws IOException{
        printIndented("<letStatement>");
        indentationLevel++;

        printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");

        tokenizer.advance(); // variable name
        printIndented("<identifier> "+tokenizer.identifier()+" </identifier>");

        tokenizer.advance();
        if(tokenizer.getCurrentToken().equals("[")){
            printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
            tokenizer.advance(); // Proceed to expression
            compileExpression();
            printIndented("<symbol> ] </symbol>");
            tokenizer.advance(); // = sign
        }

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");// =
        tokenizer.advance();
        compileExpression();

        printIndented("<symbol> ; </symbol>");
        tokenizer.advance();

        indentationLevel--;
        printIndented("</letStatement>");
    }

    public void compileIf() throws IOException{
        printIndented("<ifStatement>");
        indentationLevel++;

        printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");

        tokenizer.advance(); // (
        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        tokenizer.advance();
        compileExpression();

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        tokenizer.advance(); // {
        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        tokenizer.advance();
        compileStatements(); // statements

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        // Check for 'else'
        if (tokenizer.hasMoreTokens()) {
            tokenizer.advance();
            if (tokenizer.tokenType()==TokenType.KEYWORD && tokenizer.keyWord().equals(KeywordType.ELSE)) {
                printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");
                tokenizer.advance(); // '{'
                printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
                tokenizer.advance();
                compileStatements();
                printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
                tokenizer.advance();
            }
        }

        indentationLevel--;
        printIndented("</ifStatement>");
    }

    public void compileWhile() throws IOException{
        printIndented("<whileStatement>");
        indentationLevel++;

        printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");

        tokenizer.advance(); //(
        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        tokenizer.advance(); //i
        compileExpression();

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>"); //)

        tokenizer.advance(); // {
        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        tokenizer.advance();
        compileStatements();

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
        tokenizer.advance();

        indentationLevel--;
        printIndented("</whileStatement>");
    }

    public void compileDo() throws IOException{
        printIndented("<doStatement>");
        indentationLevel++;

        printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");

        tokenizer.advance(); // name of the function / class
        printIndented("<identifier> "+tokenizer.identifier()+" </identifier>");

        tokenizer.advance(); // . or (
        if(tokenizer.getCurrentToken().equals(".")){
            printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
            tokenizer.advance(); // name of the function
            printIndented("<identifier> "+tokenizer.identifier()+" </identifier>");
            tokenizer.advance();
        }

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
        tokenizer.advance();
        compileExpressionList();

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        tokenizer.advance(); // ;
        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");

        indentationLevel--;
        printIndented("</doStatement>");
        tokenizer.advance();
    }

    public void compileReturn() throws IOException{
        printIndented("<returnStatement>");
        indentationLevel++;

        printIndented("<keyword> "+tokenizer.keyWord().toString().toLowerCase()+" </keyword>");

        tokenizer.advance(); // either ";" or expression
        if(!tokenizer.getCurrentToken().equals(";")){
            compileExpression();
        }

        printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
        tokenizer.advance();
        indentationLevel--;
        printIndented("</returnStatement>");
    }

    public void compileExpression() throws IOException{
        printIndented("<expression>");
        indentationLevel++;

        compileTerm();

        while (tokenizer.tokenType() == TokenType.SYMBOL &&
                (tokenizer.symbol() == '+' || tokenizer.symbol() == '-' || tokenizer.symbol() == '/'
                        || tokenizer.symbol() == '*' || tokenizer.symbol() == '&' || tokenizer.symbol() == '|'
                        || tokenizer.symbol() == '>' || tokenizer.symbol() == '<' || tokenizer.symbol() == '=')) {

            printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
            tokenizer.advance();
            compileTerm();
        }


        indentationLevel--;
        printIndented("</expression>");
    }

    public void compileTerm() throws IOException {
        printIndented("<term>");
        indentationLevel++;

        if (tokenizer.tokenType() == TokenType.INT_CONST) {
            printIndented("<integerConstant> " + tokenizer.intVal() + " </integerConstant>");
            tokenizer.advance();
        }
        else if (tokenizer.tokenType() == TokenType.STRING_CONST) {
            printIndented("<stringConstant> " + tokenizer.stringVal() + " </stringConstant>");
            tokenizer.advance();
        }
        else if (tokenizer.tokenType() == TokenType.KEYWORD &&
                (tokenizer.keyWord() == KeywordType.TRUE || tokenizer.keyWord() == KeywordType.FALSE ||
                        tokenizer.keyWord() == KeywordType.NULL || tokenizer.keyWord() == KeywordType.THIS)
        ) {
            printIndented("<keyword> " + tokenizer.keyWord().toString().toLowerCase() + " </keyword>");
            tokenizer.advance();
        }
        else if (tokenizer.tokenType() == TokenType.SYMBOL &&
                (tokenizer.symbol() == '~' || tokenizer.symbol() == '-')) {
            printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
            tokenizer.advance();
            compileTerm();
        }
        else if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '(') {
            printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
            tokenizer.advance();
            compileExpression();
            printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
            tokenizer.advance();
        }
        else if (tokenizer.tokenType() == TokenType.IDENTIFIER) {
            printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
            tokenizer.advance(); // . or [ or (
            if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '[') {
                printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
                tokenizer.advance();
                compileExpression();
                printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
                tokenizer.advance();
            }
            else if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '.') {
                printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
                tokenizer.advance(); // name of the function
                printIndented("<identifier> " + tokenizer.identifier() + " </identifier>");
                tokenizer.advance();
                printIndented("<symbol> ( </symbol>");
                tokenizer.advance();
                compileExpressionList();
                printIndented("<symbol> ) </symbol>");
                tokenizer.advance();
            } else if (tokenizer.tokenType() == TokenType.SYMBOL && tokenizer.symbol() == '(') {
                printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
                tokenizer.advance();
                compileExpressionList();
                printIndented("<symbol> " + tokenizer.symbol() + " </symbol>");
                tokenizer.advance();
            }
        }

        indentationLevel--;
        printIndented("</term>");
    }

    public void compileExpressionList() throws IOException{
        printIndented("<expressionList>");
        indentationLevel++;
        if(!tokenizer.getCurrentToken().equals(")")){
            compileExpression();
            while (tokenizer.tokenType()==TokenType.SYMBOL && tokenizer.symbol()==','){
                printIndented("<symbol> "+tokenizer.symbol()+" </symbol>");
                tokenizer.advance();
                compileExpression();
            }
        }

        indentationLevel--;
        printIndented("</expressionList>");
    }

    public void closeFile() throws IOException{
        writer.close();
    }
}
