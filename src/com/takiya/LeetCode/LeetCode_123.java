package com.takiya.LeetCode;

public class LeetCode_123 {
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2)
            return 0;
        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < len; ++i)  {
            if (i == 1) {
                dp[i][1][0] = dp[i - 1][1][1] + prices[i];
            } else if (i == 2){
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]); // i >= 2
                dp[i][2][0] = 0;
                dp[i][2][1] = dp[i - 1][1][0] - prices[i];
            } else {
                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]); // i >= 3
                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]); // i >= 3
            }
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
        }
        return dp[len - 1][2][0] > dp[len - 1][1][0] ? dp[len - 1][2][0] : dp[len - 1][1][0];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.print(maxProfit(prices));
    }
}
