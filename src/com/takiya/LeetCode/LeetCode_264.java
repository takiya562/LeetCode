package com.takiya.LeetCode;

public class LeetCode_264 {
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            int min = Math.min(dp[i2] * 2, dp[i3] * 3);
            min = Math.min(min, dp[i5] * 5);
            if (dp[i2] * 2 == min)
                i2 += 1;
            if (dp[i3] * 3 == min)
                i3 += 1;
            if (dp[i5] * 5 == min)
                i5 += 1;
        }
        return dp[n - 1];
    }
}
