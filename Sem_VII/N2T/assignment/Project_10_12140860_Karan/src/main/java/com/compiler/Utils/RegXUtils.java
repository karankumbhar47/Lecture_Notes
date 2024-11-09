package com.compiler.Utils;

import java.util.regex.Pattern;

public class RegXUtils {
    public static final String keyWordRegX =
            "\\b(class|constructor|function|method|field|static|var|int|boolean|char|void|true|" +
                    "false|null|this|let|do|if|else|while|return)\\b";

    public static final String symbolRegX =
            "[\\{\\}\\(\\)\\[\\]\\.\\,\\;\\+\\-\\*\\/\\&\\|\\<\\>\\=\\~]";

    public static final String integerConstRegX =
            "\\b(3276[0-7]|327[0-5][0-9]|32[0-6][0-9]{2}|[1-9][0-9]{0,3}|0)\\b";

    public static final String stringConstRegX = "\"[^\"]*\"";

    public static final String identifiersRegX = "[a-zA-Z_][a-zA-Z_0-9]*";

    public static final Pattern TOKEN_PATTERN = Pattern.compile(
            stringConstRegX + "|" +
                    keyWordRegX + "|" +
                    symbolRegX + "|" +
                    integerConstRegX + "|" +
                    identifiersRegX
    );
}
