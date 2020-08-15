package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int stepLen = nums[i];
            if (i > max)
                return false;
            max = Math.max(max, i + stepLen);
        }
        return true;
    }
    @Test
    public void test() {
        int[] nums = {};
        boolean res = canJump(nums);
        System.out.println(res);
    }
}
