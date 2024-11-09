package com.compiler.Utils;

public class EnumClass {
    public enum KeywordType{
        CLASS,METHOD,FUNCTION,CONSTRUCTOR,
        INT,BOOLEAN,CHAR,VOID,VAR,STATIC,
        FIELD,LET,DO,IF,ELSE,WHILE,RETURN,
        TRUE,FALSE,NULL,THIS
    }

    public enum TokenType {
        KEYWORD, SYMBOL, IDENTIFIER, INT_CONST, STRING_CONST
    }
}
