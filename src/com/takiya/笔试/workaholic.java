package com.takiya.笔试;

import java.util.Scanner;

public class workaholic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] company = new int[n];
            int[] gym = new int[n];
            for (int i = 0; i < n; ++i) {
                company[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; ++i) {
                gym[i] = scanner.nextInt();
            }
            System.out.print(n - miniRest(company, gym));
        }
    }
    public static int miniRest(int[] company, int[] gym) {
        int len = company.length;
        int[][] dp = new int[len + 1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i <= len; ++i) {
            if (company[i - 1] == 1)
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + 1;
            if (gym[i - 1] == 1)
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + 1;
            dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
        }
        return Math.max(Math.max(dp[len][0], dp[len][1]), dp[len][2]);
    }
}
