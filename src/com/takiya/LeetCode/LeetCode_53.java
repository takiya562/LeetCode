package com.takiya.LeetCode;

public class LeetCode_53 {
    public static int maxSubArray(int[] nums) {
        int max_ending_pre = nums[0];
        int max_so_far = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_ending_pre + nums[i];
            max_ending_pre = Math.max(nums[i], temp);
            max_so_far = Math.max(max_ending_pre, max_so_far);
        }
        return max_so_far;
    }
    public static void main(String args[]) {
        int[] nums = {-2,1};
        System.out.println(maxSubArray(nums));
    }
}
