package com.takiya.LeetCode;

public class LeetCode_887 {
    class Pair {
        int fir;
        int sec;

    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = i; j < n; ++j)
                dp[i][j] = new Pair();
        for (int i = 0; i < n; ++i) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int left = piles[j] + dp[j + 1][i].sec;
                int right = piles[i] + dp[j][i - 1].sec;
                if (left > right) {
                    dp[j][i].fir = left;
                    dp[j][i].sec = dp[j + 1][i].fir;
                } else {
                    dp[j][i].fir = right;
                    dp[j][i].sec = dp[j][i - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec > 0;
    }
}
