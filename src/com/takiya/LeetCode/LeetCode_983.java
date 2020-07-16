package com.takiya.LeetCode;

public class LeetCode_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[days[len - 1] + 1];
        int index = 0;
        for (int i = 1; i < dp.length; ++i) {
            if (days[index] == i) {
                int tmp;
                dp[i] = dp[i - 1] + costs[0];
                tmp = (i - 7) > 0 ? (i - 7) : 0;
                dp[i] = Math.min(dp[i], dp[tmp] + costs[1]);
                tmp = (i - 30) > 0 ? (i - 30) : 0;
                dp[i] = Math.min(dp[i], dp[tmp] + costs[2]);
                index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}
