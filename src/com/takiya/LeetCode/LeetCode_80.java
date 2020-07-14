package com.takiya.LeetCode;

public class LeetCode_80 {
    public int removeDuplicates(int[] nums) {
        int anchor = 0;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == nums[anchor] && index - anchor < 2) {
                nums[index++] = nums[i];
            } else if (nums[i] != nums[anchor]) {
                anchor = index;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
