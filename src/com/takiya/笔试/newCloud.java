package com.takiya.笔试;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class newCloud {
    public List<List<Integer>> childArray(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        if (n == 0)
            return ans;
        Arrays.sort(nums);
        backTrace(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backTrace(List<List<Integer>> ans, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        int size = list.size();
        int pre = nums[index] - 1;
        for (int i = index; i < nums.length; i++) {
            if (pre != nums[i]) {
                list.add(nums[i]);
                ans.add(new ArrayList<>(list));
                backTrace(ans, list, nums, i + 1);
                list.remove(size);
            }
            pre = nums[i];
        }
    }

    public String solution(char[] chars, int k) {
        reserve(chars, 0, k - 1);
        reserve(chars, k, chars.length - 1);
        reserve(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reserve(char[] chars, int i, int j) {
        if (i == j)
            return;
        int l = i, r = j;
        while (l < r) {
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
    }

    @Test
    public void test() {
        String solution = solution("abcdef".toCharArray(), 2);
        System.out.println(solution);
    }
}
