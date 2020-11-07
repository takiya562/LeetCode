package com.takiya.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class how_many_numbers_are_smaller_than_the_current_number {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[] {};
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++)
            indexes[i] = i;
        Arrays.sort(indexes, Comparator.comparingInt(i -> nums[i]));
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[indexes[i]] == nums[indexes[i - 1]])
                res[indexes[i]] = res[indexes[i - 1]];
            else
                res[indexes[i]] = i;
        }
        return res;
    }
}
