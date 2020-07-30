package com.takiya.LeetCode;

public class LeetCode_213 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n + 1];
        for (int i = 0; i < n; ++i) {
            int index = i + 1;
            if (i == 0) {
                dp[0][index] = nums[i];
            } else if (i == n - 1) {
                dp[0][index] = dp[0][i];
                dp[1][index] = Math.max(dp[1][i], dp[1][i - 1] + nums[i]);
            }else {
                dp[0][index] = Math.max(dp[0][i], dp[0][i - 1] + nums[i]);
                dp[1][index] = Math.max(dp[1][i], dp[1][i - 1] + nums[i]);
            }
        }
        return dp[0][n] > dp[1][n] ? dp[0][n] : dp[1][n];
    }
}
