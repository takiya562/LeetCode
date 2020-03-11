package com.takiya.Offer;

public class Offer_46 {
    public int translateNum(int num) {
        String nums = String.valueOf(num);
        int len = nums.length();
        if (len == 0)   return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; ++i) {
            int combine = Integer.valueOf(nums.substring(i - 1, i + 1));
            if (combine < 26 && combine >= 10)
                dp[i + 1] = dp[i - 1] + dp[i];
            else
                dp[i + 1] = dp[i];
        }
        return dp[len];
    }
}
