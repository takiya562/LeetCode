package com.takiya.LeetCode;

import org.junit.Test;

import java.util.*;

public class LeetCode_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrace(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
    private void backTrace(List<List<Integer>> ans, List<Integer> list, int index, int[] nums) {
        if (index == nums.length)
            return;
        int size = list.size();
        int last = size == 0 ? Integer.MIN_VALUE : list.get(size - 1);
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!set.contains(nums[i]) && nums[i] >= last) {
                set.add(nums[i]);
                list.add(nums[i]);
                if (size > 0)   ans.add(new ArrayList<>(list));
                backTrace(ans, list, i + 1, nums);
                list.remove(size);
            }
        }
    }
    @Test
    public void test() {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        List<List<Integer>> subsequences = findSubsequences(nums);
        subsequences.forEach(list -> {
            for(int i : list)
                System.out.print(i + " ");
            System.out.println();
        });
    }
}
