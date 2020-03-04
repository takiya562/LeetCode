package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_46 {
    /*
    public static List<List<Integer>> permute(int[] nums) {
        int[] map = new int[nums.length];
        List<Integer> tuple = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map[i] = 1;
            recursion(i, nums, ans, tuple, map);
            map[i] = 0;
            tuple.remove(tuple.size()-1);
        }
        return ans;
    }

    public static void recursion(int index, int[] nums, List<List<Integer>> ans, List<Integer> tuple, int[] map) {
        tuple.add(nums[index]);
        if (tuple.size() == nums.length)
            ans.add(new ArrayList<>(tuple));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (map[i] == 0) {
                    map[i] = 1;
                    recursion(i, nums, ans, tuple, map);
                    map[i] = 0;
                    tuple.remove(tuple.size()-1);
                }
            }
        }
    }*/

    public static void backTrace(List<List<Integer>> ans, ArrayList<Integer> nums, int index, int len) {
        if (index == len)
            ans.add(new ArrayList<>(nums));
        else {
            for (int i = index; i < len; i++) {
                Collections.swap(nums, index, i);
                backTrace(ans, nums, index+1, len);
                Collections.swap(nums, index, i);  //还原
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ArrayList<Integer> nums_list = new ArrayList<>();
        for (int num : nums)
            nums_list.add(num);
        backTrace(ans, nums_list, 0, nums.length);
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = permute(nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < nums.length; j++)
                System.out.print(ans.get(i).get(j));
            System.out.println();
        }
    }
}
