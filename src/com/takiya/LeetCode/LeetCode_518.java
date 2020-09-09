package com.takiya.LeetCode;

public class LeetCode_518 {
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
