package com.vmTranslator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestionUtils {
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

    public static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;  // If s1 is empty, all characters of s2 need to be inserted
                } else if (j == 0) {
                    dp[i][j] = i;  // If s2 is empty, all characters of s1 need to be deleted
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
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
}
