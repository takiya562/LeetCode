package com.takiya.LeetCode;

import java.util.Arrays;

public class LeetCode_16 {
    public static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {
            int tmp = nums[i] - target;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = tmp + nums[l] + nums[r];
                if (sum == 0)
                    return target;
                if (Math.abs(result) > Math.abs(sum))
                    result = sum;
                if (sum > 0)    r--;
                if (sum < 0)    l++;
            }
        }
        return result + target;
    }
    public static void main(String args[]) {
        int[] nums = {-1,2,1,-4};
        int result = threeSumClosest(nums, 1);
        System.out.print(String.valueOf(result));
    }
}
