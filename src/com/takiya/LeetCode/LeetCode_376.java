package com.takiya.LeetCode;

public class LeetCode_376 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2)   return len;
        int preDiff = nums[1] - nums[0];
        int count = preDiff == 0 ? 1 : 2;
        for (int i = 2; i < len; ++i) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0))
                count++;
            preDiff = diff;
        }
        return count;
    }
}
