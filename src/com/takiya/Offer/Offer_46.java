package com.takiya.Offer;

public class Offer_46 {
    public int translateNum_1(int num) {
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
    public int translateNum(int num) {
        if (num <= 9)   return 1;
        int lastTwo = num % 100;
        if (lastTwo <= 9 || lastTwo >= 26)  return translateNum(num / 10);
        else    return translateNum(num / 10) + translateNum(num / 100);
    }
}
