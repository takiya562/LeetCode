package com.takiya.LeetCode;

import org.junit.Test;

import java.util.*;

public class LeetCode_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < len; ++i) {
            if (set.contains(nums.get(i)))
                continue;
            Collections.swap(nums, index, i);
            backTrace(ans, nums, index + 1, len);
            Collections.swap(nums, index, i);
            set.add(nums.get(i));
        }
    }
    @Test
    public void test() {
        int[] nums = {3,3,0,3};
        List<List<Integer>> ans = permuteUnique(nums);
        ans.stream().forEach(System.out::println);
    }
}
