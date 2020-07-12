package com.takiya.extra;

import java.util.Arrays;

public class Left0Right1 {
    public static void func(int[] nums) {
        int len = nums.length;
        if (len < 2)    return;
        int l = 0, r = len - 1;
        while (l < r) {
            while (l < r && nums[l] == 0) ++l;
            while (l < r && nums[r] == 1) --r;
            swap(nums, l, r);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0,0,1,0,1,0,0};
        func(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
