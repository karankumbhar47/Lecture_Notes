package com.vmTranslator.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vmTranslator.VMExceptions.SyntaxExceptions;
import com.vmTranslator.VMExceptions.SyntaxExceptions.*;

public class Utils {
    public static List<String> segmentList = new ArrayList<>();

    static {
        segmentList.add("local");
        segmentList.add("argument");
        segmentList.add("this");
        segmentList.add("that");
        segmentList.add("constant");
        segmentList.add("static"); //0-239
        segmentList.add("pointer"); // 0-1
        segmentList.add("temp"); // 0-7
    }

    public static List<String> commandList = Arrays.asList(
            "push", "pop", "call", "function", "label", "goto", "if-goto",
            "return", "add", "sub", "neg", "eq", "gt", "lt", "and", "or", "not");


    public static void validateIndex(int index, int max, Context context) throws SyntaxExceptions {
        if(index<0)
            throw  new NegativeIndexException(context.getLineNumber(),context.getCurrentLine());
        if (index > max)
            throw new IndexOutOfBondException(index, 0, max,context.getLineNumber(),context.getCurrentLine());
    }

    public static String cleanLine(String line) {
        Pattern pattern = Pattern.compile("(^\\s+)|(//.*)|(\\s+$)|((\\r)?\\n)|(\\s{2,})");
        Matcher matcher = pattern.matcher(line);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (matcher.group(1) != null || matcher.group(2) != null || matcher.group(3) != null
                    || matcher.group(4) != null) {
                matcher.appendReplacement(result, "");
            } else if (matcher.group(6) != null) {
                matcher.appendReplacement(result, " ");
            }
        }
        matcher.appendTail(result);
        return result.toString().trim();
    }

    public static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static String findClosestCommand(String invalidWord, List<String> list) {
        String closestCommand = null;
        int minDistance = Integer.MAX_VALUE;

        for (String command : list) {
            int distance = levenshteinDistance(invalidWord, command);
            if (distance < minDistance) {
                minDistance = distance;
                closestCommand = command;
            }
        }
        return closestCommand;
    }

    public static boolean isValidInteger(String str) {
        return str != null && str.matches("-?\\d+");
    }
}