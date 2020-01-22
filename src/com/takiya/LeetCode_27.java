package com.takiya;

public class LeetCode_27 {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != val) {
                nums[k] = nums[index];
                k++;
            }
            index++;
        }
        return k;
    }
}
