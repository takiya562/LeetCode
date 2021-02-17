package com.takiya.LeetCode;

public class LeetCode_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1)
                count++;
            else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}
