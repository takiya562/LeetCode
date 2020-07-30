package com.takiya.LeetCode;

public class LeetCode_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int winSum = 0;
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        while (r < nums.length) {
            winSum += nums[r++];
            while (l < r && winSum - nums[l] >= s)
                winSum -= nums[l++];
            //System.out.println(winSum);
            if (winSum >= s) {
                min = Math.min(min, r - l);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
