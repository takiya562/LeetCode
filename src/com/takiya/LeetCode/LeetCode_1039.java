package com.takiya.LeetCode;

import java.util.Arrays;

public class LeetCode_1039 {
    public int minScoreTriangulation(int[] A) {
        int length = A.length;
        int[][] dp = new int[length][length];
        for (int[] item : dp)
            Arrays.fill(item, Integer.MAX_VALUE);
        for (int i = 0; i < length; ++i)
            dp[i][(i + 1) % length] = 0;
        for (int len = 2; len < length; ++len) {
            for (int i = 0; i < length; ++i) {
                int j = (i + len) % length;
                for (int k = (i + 1) % length; k != j; k = (k + 1) % length) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
