package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int target_alter, left, right, sum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                target_alter = target - nums[i] - nums[j];
                left = j+1;
                right = nums.length-1;
                while (left < right) {
                    sum = nums[left] + nums[right];
                    if (sum == target_alter) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum < target_alter) left++;
                    else if (sum > target_alter) right--;
                }
            }
        }
        return result;
    }
    public static void main(String args[]) {
        int[] nums = {0,0,0,0};
        System.out.print(fourSum(nums, 0).toString());
    }
}
