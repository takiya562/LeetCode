package com.takiya.LeetCode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode_72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        // remove operation
        for (int i = 1; i <= len2; i++)
            dp[0][i] = i;
        // add operation
        for (int i = 1; i <= len1; i++)
            dp[i][0] = i;
        for (int i = 1; i <= len1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = word2.charAt(j - 1);
                // replace operation or equal
                dp[i][j] = dp[i - 1][j - 1] + (c1 == c2 ? 0 : 1);
                // remove operation
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                // add operation
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
            }
        }
        return dp[len1][len2];
    }

    @Test
    public void test() {
        Assert.assertEquals(3, minDistance("horse", "ros"));
        Assert.assertEquals(5, minDistance("intention", "execution"));
    }
}
