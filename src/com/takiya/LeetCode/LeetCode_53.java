package com.takiya.LeetCode;

public class LeetCode_53 {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
    public static void main(String args[]) {
        int[] nums = {-2,1};
        System.out.println(maxSubArray(nums));
    }
}
