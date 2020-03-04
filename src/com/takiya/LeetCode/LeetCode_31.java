package com.takiya.LeetCode;

import java.util.Arrays;

public class LeetCode_31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int index = nums.length-1;
        while (index > 0) {
            if (nums[index] > nums[index-1])
                break;
            index--;
        }
        if (index == 0) {
            Arrays.sort(nums);
            return;
        }
        int temp = index--;
        for (; temp < nums.length; temp++) {
            if (nums[temp] <= nums[index]) {
                swap(nums, index, temp - 1);
                break;
            }
        }
        if (temp == nums.length)
            swap(nums, index, temp-1);
        Arrays.sort(nums, index+1, nums.length);
        return;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String args[]) {
        int[] nums = {1,5,1};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i]);
    }
}
