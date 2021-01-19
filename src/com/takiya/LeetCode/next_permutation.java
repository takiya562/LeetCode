package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class next_permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])    i--;
        if (i == - 1)
            reserve(nums, 0, n - 1);
        else {
            int j = n - 1;
            while (j < i && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
            reserve(nums, i + 1, n - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reserve(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
