package com.takiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (len == 0)   return ans;
        Arrays.sort(nums);
        int[] dp = new int[len];
        int[] pre = new int[len];
        dp[0] = 1;
        int max = 1;
        int tail = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                tail = i;
            }
        }
        for (int i = 0; i < max; ++i) {
            ans.add(nums[tail]);
            tail = pre[tail];
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {3,4,16,8};
        largestDivisibleSubset(nums);
    }
}
