package com.takiya.LeetCode;

public class LeetCode_974 {
    public int subarraysDivByK(int[] A, int K) {
        int[] dp = new int[K];
        dp[0] = 1;
        int sum = 0;
        int count = 0;
        for (int num : A) {
            sum += num;
            int module = (sum % K + K) % K;
            count += dp[module]++;
        }
        return count;
    }
}
