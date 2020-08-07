package com.takiya.LeetCode;

public class LeetCode_1143 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        if (text1.charAt(0) == text2.charAt(0))
            dp[0][0] = 1;
        for (int i = 1; i < len1; ++i) {
            if (text1.charAt(i) == text2.charAt(0))
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i - 1][0];
        }
        for (int j = 1; j < len2; ++j) {
            if (text1.charAt(0) == text2.charAt(j))
                dp[0][j] = 1;
            else
                dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < len1; ++i) {
            for (int j = 1; j < len2; ++j) {
                if (text1.charAt(i) == text2.charAt((j)))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }
}
