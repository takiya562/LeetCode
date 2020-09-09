package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        backTrace(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backTrace(List<List<Integer>> ans, List<Integer> list, int[] nums, int index) {
        if (index == nums.length)
            return;
        int size = list.size();
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            ans.add(new ArrayList<>(list));
            backTrace(ans, list, nums, i + 1);
            list.remove(size);
        }
    }
    @Test
    public void test() {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
        lists.forEach(list -> {
            for (int num : list)
                System.out.print(num + " ");
            System.out.println();
        });
    }
}
