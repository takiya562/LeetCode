package com.takiya;

public class LeetCode_122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {                             //参数 i 表示第 i 天
            /* 不管是dp[i][0]还是dp[i][1]都是表示状态 0 和 1 时能够持有的最大利润量
            *  状态 0 表示持有现金
            *  状态 1 表示持有股票
            *  状态 0 和 1 都可以从对方或者自身转移 */
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}
