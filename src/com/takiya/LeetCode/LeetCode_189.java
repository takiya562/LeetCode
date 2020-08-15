package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return;
        int  index = n - k % n -1;
        reserve(nums, 0, index);
        reserve(nums, index + 1, n - 1);
        reserve(nums, 0, n - 1);
    }

    private void reserve(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    @Test
    public void test1() {
        int[] nums = {1,2,3,4,5,6,7};
        reserve(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
    @Test
    public void test2() {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
