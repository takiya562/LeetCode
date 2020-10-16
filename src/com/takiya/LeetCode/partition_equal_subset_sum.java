package com.takiya.LeetCode;

import org.junit.Test;

import java.util.HashSet;

public class partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2)  return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum / 2; i >= num; i--) {
                dp[i] |= dp[i - num];
            }
        }
        return dp[sum / 2];
    }

    @Test
    public void test() {
        int[] nums = {1,2,5};
        canPartition(nums);
    }
}
