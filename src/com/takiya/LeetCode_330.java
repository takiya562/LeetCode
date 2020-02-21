package com.takiya;

public class LeetCode_330 {
    public int minPatches(int[] nums, int n) {
        int len = nums.length;
        long sum = 0;
        int count = 0;
        if (len == 0 || nums[0] != 1) {
            count++;
            sum += 1;
        }
        int index = 0;
        while (sum < n) {
            if (index >= len || nums[index] > sum + 1) {
                count++;
                sum += sum + 1;
            }
            else {
                sum += nums[index];
                index++;
            }
        }
        return count;
    }
}
