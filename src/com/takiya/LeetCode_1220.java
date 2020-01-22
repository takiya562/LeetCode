package com.takiya;

public class LeetCode_1220 {
    public static int countVowelPermutation(int n) {
        int[][] dp = new int[5][2];
        for (int i = 0; i < 5; i++)
            dp[i][0] = 1;
        int flag = 0;
        int pow = (int)(Math.pow(10, 9) + 7);
        for (int i = 1; i < n; i++) {
            int index = 1 - flag;
            dp[0][index] = ((dp[1][flag] + dp[2][flag]) % pow + dp[4][flag]) % pow;
            dp[1][index] = (dp[0][flag] + dp[2][flag]) % pow;
            dp[2][index] = (dp[1][flag] + dp[3][flag]) % pow;
            dp[3][index] = dp[2][flag] % pow;
            dp[4][index] = (dp[2][flag] + dp[3][flag]) % pow;
            flag = index;
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[i][flag];
            ans %= pow;
        }
        return ans;
    }
    public static void main(String[] args) {
        countVowelPermutation(144);
    }
}
