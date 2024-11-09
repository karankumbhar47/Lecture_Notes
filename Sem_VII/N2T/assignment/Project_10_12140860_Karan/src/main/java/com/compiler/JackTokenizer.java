package com.compiler;

import com.compiler.Utils.EnumClass.TokenType;
import com.compiler.Utils.EnumClass.KeywordType;
import com.compiler.Utils.RegXUtils;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static com.compiler.Utils.TokenizerUtils.keywordMap;

public class JackTokenizer {
    private final List<String> tokens;
    public int currentTokenIndex;
    private String currentToken;

    public JackTokenizer(Path filePath) throws IOException {
        this.tokens = new ArrayList<>();
        this.currentTokenIndex = -1;
        tokenize(filePath);
    }

    private void tokenize(Path filePath) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(filePath)));

        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            fileContent.append(currentLine).append("\n");
        }

        String input = fileContent
                .toString()
                .replaceAll("//.*|/\\*\\*?[\\s\\S]*?\\*/", "");
        Matcher matcher = RegXUtils.TOKEN_PATTERN.matcher(input);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
    }

    public boolean hasMoreTokens() {
        return currentTokenIndex < tokens.size() - 1;
    }

    public void advance() {
        if(hasMoreTokens()){
            currentTokenIndex++;
            currentToken = tokens.get(currentTokenIndex);
        }
    }

    public TokenType tokenType() {
        if (currentToken.matches(RegXUtils.keyWordRegX)) {
            return TokenType.KEYWORD;
        } else if (currentToken.matches(RegXUtils.symbolRegX)) {
            return TokenType.SYMBOL;
        } else if (currentToken.matches(RegXUtils.integerConstRegX)) {
            return TokenType.INT_CONST;
        } else if (currentToken.matches(RegXUtils.stringConstRegX)) {
            return TokenType.STRING_CONST;
        } else if (currentToken.matches(RegXUtils.identifiersRegX)) {
            return TokenType.IDENTIFIER;
        }
        return null;
    }

    public KeywordType keyWord() {
        if (tokenType() == TokenType.KEYWORD)
            return keywordMap.get(currentToken);
        return null;
    }

    public Character symbol() {
        if (tokenType() == TokenType.SYMBOL)
            return currentToken.charAt(0);
        return null;
    }

    public String identifier() {
        if (tokenType() == TokenType.IDENTIFIER)
            return currentToken;
        return null;
    }

    public Integer intVal() {
        if (tokenType() == TokenType.INT_CONST)
            return Integer.parseInt(currentToken);
        return null;
    }

    public String stringVal() {
        if (tokenType() == TokenType.STRING_CONST)
            return currentToken.substring(1,currentToken.length()-1);
        return null;
    }

    public String getCurrentToken(){
        return currentToken;
    }



}
