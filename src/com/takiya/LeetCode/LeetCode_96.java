package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
    @Test
    public void test() {
        int i = numTrees(8);
        System.out.println(i);
    }
}
