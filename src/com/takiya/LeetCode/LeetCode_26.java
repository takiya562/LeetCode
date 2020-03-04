package com.takiya;

public class LeetCode_26 {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        int n = 1;
        while (n < nums.length) {
            if (nums[k-1] != nums[n]) {
                nums[k] = nums[n];
                k++;
            }
            n++;
        }
        return k;
    }
    public static void main(String args[]) {
        int[] nums = {1,1,2};
        int result = removeDuplicates(nums);
        System.out.print(result);
    }
}
