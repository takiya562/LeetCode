package com.takiya;

public class LeetCode_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int mul = 1;
        for (int i = 2; i <=n; ++i) {
            int cur = mul * (i - mul > 3 ? dp[i - mul] : (i - mul));
            int next = (mul + 1) * (i - mul - 1 > 3 ? dp[i - mul - 1] : (i - mul - 1));
            if (next > cur) {
                mul++;
                dp[i] = next;
            }
            else
                dp[i] = cur;
        }
        return dp[n];
    }
}
