package com.takiya;

import java.util.Arrays;

public class LeetCode_16 {
    public static int threeSumClosest(int[] nums, int target) {
        int result;
        int len = nums.length;
        if (len < 3)
            return 0;
        Arrays.sort(nums);
        result = nums[0] + nums[1] + nums[len - 1] - target;
        int sum;
        int left, right;
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] - target;
            left = i + 1;
            right = len - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0)
                    return target;
                if (Math.abs(sum) < Math.abs(result)) result = sum;
                if (sum < 0) left++;
                if (sum > 0) right--;
            }
        }
        return result+target;
    }
    public static void main(String args[]) {
        int[] nums = {-1,2,1,-4};
        int result = threeSumClosest(nums, 1);
        System.out.print(String.valueOf(result));
    }
}
