package com.takiya.LeetCode;

public class LeetCode_926 {
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            dp[i + 1] = dp[i] + (chars[i] == '1' ? 1 : 0);
        }
        int min = len;
        for (int i = 0; i <= len; ++i) {
            min = Math.min(min, dp[i] + len - i - (dp[len] - dp[i]));
        }
        return min;
    }
}
