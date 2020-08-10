package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_1312 {
    public int minInsertions(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; ++i) {
            for (int j = i; j >= 0; --j) {
                if (i == j)
                    dp[j][i] = 0;
                else if (chars[i] == chars[j])
                    dp[j][i] = dp[j + 1][i - 1];
                else {
                    dp[j][i] = Math.min(dp[j][i - 1] + 1, dp[j + 1][i] + 1);
                    dp[j][i] = Math.min(dp[j + 1][i - 1] + 2, dp[j][i]);
                }
            }
        }
        return dp[0][len - 1];
    }
    @Test
    public void test() {
        String s = "g";
        int res = minInsertions(s);
        System.out.println(res);
    }
}
