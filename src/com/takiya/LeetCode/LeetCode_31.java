package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])   --i;
        if (i == -1) {
            reserve(nums, 0, n - 1);
            return;
        }
        int j = n - 1;
        while (j > i && nums[j] <= nums[i]) --j;
        swap(nums, i, j);
        reserve(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reserve(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
    @Test
    public void test() {
        int[] start = {1,2,3,4,5};
        int[] nums = {1,2,3,4,5};
        do {
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
            nextPermutation(nums);
        } while (!Arrays.equals(start, nums));
    }

    @Test
    public void singleTest() {
        int[] nums = {5,1,1};
        nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
