package com.takiya.LeetCode;

import java.util.*;

/* 去重是难点 */
public class LeetCode_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        int n = nums.length;
        if (n < 3)
            return ans;
        Arrays.sort(nums);
        for (int first = 0; first < n; ++first) {
            if (nums[first] > 0)
                break;
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < third; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                while (second < third && nums[second] + nums[third] > target)
                    --third;
                if (second == third)
                    break;
                if (nums[second] + nums[third] == target) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> result = threeSum(nums);
        System.out.print(result.toString());
    }
}
