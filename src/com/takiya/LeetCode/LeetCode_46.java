package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            list.add(num);
        List<List<Integer>> ans = new LinkedList<>();
        backTrace(ans, list, 0, nums.length);
        return ans;
    }
    private void backTrace(List<List<Integer>> ans, List<Integer> nums, int index, int len) {
        if (index == len) {
            ans.add(new ArrayList<>(nums));
            return;
        }
        for (int i = index; i < len; ++i) {
            Collections.swap(nums, index, i);
            backTrace(ans, nums, index + 1, len);
            Collections.swap(nums, index, i);
        }
    }


}
