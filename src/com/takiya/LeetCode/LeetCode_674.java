package com.takiya;

public class LeetCode_674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int count = 1;
        int max = 0;
        for (int i = 1; i < len; ++i) {
            if (nums[i] > nums[i-1])
                count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
