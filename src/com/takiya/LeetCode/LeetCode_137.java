package com.takiya.LeetCode;

public class LeetCode_137 {
    public int singleNumber(int[] nums) {
        int res1 = nums[0];
        int res2 = ~nums[0];
        for (int i = 0; i < nums.length; ++i) {
            res1 ^= nums[i];
            res2 ^= ~nums[i];
        }
        return res1 ^ res2;
    }
}
