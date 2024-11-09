package com.compiler.Utils;

import com.compiler.JackTokenizer;
import com.compiler.Utils.EnumClass.KeywordType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class TokenizerUtils {
    public static final Map<String,KeywordType> keywordMap = new HashMap<>();

    static {
        keywordMap.put("class", KeywordType.CLASS);
        keywordMap.put("constructor", KeywordType.CONSTRUCTOR);
        keywordMap.put("function", KeywordType.FUNCTION);
        keywordMap.put("method", KeywordType.METHOD);
        keywordMap.put("int", KeywordType.INT);
        keywordMap.put("boolean", KeywordType.BOOLEAN);
        keywordMap.put("char", KeywordType.CHAR);
        keywordMap.put("void", KeywordType.VOID);
        keywordMap.put("var", KeywordType.VAR);
        keywordMap.put("static", KeywordType.STATIC);
        keywordMap.put("field", KeywordType.FIELD);
        keywordMap.put("let", KeywordType.LET);
        keywordMap.put("do", KeywordType.DO);
        keywordMap.put("if", KeywordType.IF);
        keywordMap.put("else", KeywordType.ELSE);
        keywordMap.put("while", KeywordType.WHILE);
        keywordMap.put("return", KeywordType.RETURN);
        keywordMap.put("true", KeywordType.TRUE);
        keywordMap.put("false", KeywordType.FALSE);
        keywordMap.put("null", KeywordType.NULL);
        keywordMap.put("this", KeywordType.THIS);
    }

    public static void writeTokensToFile(JackTokenizer tokenizer, Path outputPath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write("<tokens>\n");
            while (tokenizer.hasMoreTokens()) {
                tokenizer.advance();
                EnumClass.TokenType type = tokenizer.tokenType();
                switch (type) {
                    case KEYWORD:
                        writer.write("<keyword> " + tokenizer.keyWord().name().toLowerCase() + " </keyword>\n");
                        break;
                    case SYMBOL:
                        String symbol = tokenizer.symbol().toString();
                        writer.write("<symbol> " + symbol + " </symbol>\n");
                        break;
                    case IDENTIFIER:
                        writer.write("<identifier> " + tokenizer.identifier() + " </identifier>\n");
                        break;
                    case INT_CONST:
                        writer.write("<integerConstant> " + tokenizer.intVal() + " </integerConstant>\n");
                        break;
                    case STRING_CONST:
                        writer.write("<stringConstant> " + tokenizer.stringVal() + " </stringConstant>\n");
                        break;
                }
            }
            writer.write("</tokens>\n");
        }
    }
}
