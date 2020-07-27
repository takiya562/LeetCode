package com.takiya.笔试;

import java.util.Scanner;

public class minCombine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] coins = new int[n + 1];
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            coins[i] = scanner.nextInt();
            if (i == 1)
                preSum[i] = coins[i];
            else
                preSum[i] = preSum[i - 1] + coins[i];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; ++len) {
            for (int l = 1; l <= n - len + 1; ++l) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int j = l; j < r; ++j)
                    dp[l][r] = Math.min(dp[l][r], dp[l][j] + dp[j + 1][r] + preSum[r] - preSum[l - 1]);
            }
        }
        System.out.println(dp[1][n]);
    }
}
