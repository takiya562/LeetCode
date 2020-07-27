package com.takiya.LeetCode;

public class LeetCode_198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            int index = i + 1;
            if (i == 0)
                dp[index] = nums[i];
            else {
                dp[index] = Math.max(dp[i], dp[i - 1] + nums[i]);
            }
        }
        return dp[nums.length];
    }
}
