package com.takiya.笔试;

import java.util.Scanner;

public class stoneStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            weights[i] = scanner.nextInt();
            sum += weights[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < weights.length; ++i) {
            for (int j = sum / 2; j >= weights[i]; --j) {
                dp[j] |= dp[j - weights[i]];
            }
        }
        int result = 0;
        for (int i = sum / 2; i >= 0; --i) {
            if (dp[i]) {
                result = Math.abs(i - (sum - i));
                break;
            }
        }
        System.out.println(result);
    }
}
