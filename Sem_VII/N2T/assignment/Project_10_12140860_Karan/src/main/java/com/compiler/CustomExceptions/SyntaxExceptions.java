package com.compiler.CustomExceptions;

public class SyntaxExceptions extends Exception{
    public SyntaxExceptions(String message){
        super(message);
    }

    public static class IllegalClassKeywordException extends SyntaxExceptions{
        public IllegalClassKeywordException(){
            super("Expected 'class' keyword at start of class declaration.");
        }
    }

    public static class IllegalClassNameException extends SyntaxExceptions{
        public IllegalClassNameException(){
            super("Expected class name identifier after 'class'.");
        }
    }

    public static class InvalidOpeningBracketsException extends SyntaxExceptions{
        public InvalidOpeningBracketsException(){
            super("Expected '{' after class name.");
        }
    }

    public static class InvalidClosingBracketsException extends SyntaxExceptions{
        public InvalidClosingBracketsException(){
            super("Expected '}' at end of class declaration.");
        }
    }

    public static class InvalidClassVariableKeywordException extends SyntaxExceptions{
        public InvalidClassVariableKeywordException(){
            super("Expected 'static' or 'field' at start of classVarDec.");
        }
    }

    public static class InvalidVariableTypeException extends SyntaxExceptions{
        public InvalidVariableTypeException(){
            super("Expected type (int, char, boolean, or class name) in classVarDec.");
        }
    }

    public static class InvalidVariableNameException extends SyntaxExceptions{
        public InvalidVariableNameException(){
            super("Expected variable name identifier in classVarDec.");
        }
    }

    public static class VariableNameNotFoundException extends SyntaxExceptions{
        public VariableNameNotFoundException(){
            super("Expected variable name identifier after ',' in classVarDec.");
        }
    }

    public static class SemicolonNotFoundException extends SyntaxExceptions{
        public SemicolonNotFoundException(){
            super("Expected ';' at end of classVarDec.");
        }
    }

}
