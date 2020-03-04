package com.takiya.LeetCode;

public class LeetCode_309 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int profit = prices[i] - prices[j];
                profit += j > 1 ? dp[j-2] : 0;
                dp[i] = Math.max(dp[i], profit);
                if (dp[i] < max)
                    dp[i] = max;
                else
                    max = dp[i];
            }
        }
        return max;
    }

    public static int maxProfit_2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][2] - prices[i], dp[i-1][1]);
            dp[i][2] = dp[i-1][0];
        }
        return Math.max(dp[len-1][0], dp[len-1][2]);
    }
    public static void main(String args[]) {
        int[] prices = {1,2,3,0,2};
        maxProfit_2(prices);
    }
}
