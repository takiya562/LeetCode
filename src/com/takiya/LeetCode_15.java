package com.takiya;

import java.util.*;

/* 去重是难点 */
public class LeetCode_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 3)
            return result;
        Arrays.sort(nums);
        int left, right;
        int sum;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //去重
            left = i + 1;
            right = len - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;  //去重
                    while (left < right && nums[right] == nums[right - 1]) right--;  //去重
                    left++;
                    right--;
                }
                else if (sum > 0) right--;
                else if (sum < 0) left++;
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result = threeSum(nums);
        System.out.print(result.toString());
    }
}
