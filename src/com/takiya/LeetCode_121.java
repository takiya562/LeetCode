package com.takiya;

public class LeetCode_121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < len; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }
}
