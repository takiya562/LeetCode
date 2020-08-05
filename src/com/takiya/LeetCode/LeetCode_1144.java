package com.takiya.LeetCode;

public class LeetCode_1144 {
    public int movesToMakeZigzag(int[] nums) {
        int res1 = 0;
        int res2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            int left = i - 1 >= 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i + 1 < len ? nums[i + 1] : Integer.MAX_VALUE;
            int min = Math.min(left, right);
            if (nums[i] >= min) {
                int tmp = nums[i] - min + 1;
                if (i % 2 == 0)
                    res1 += tmp;
                else
                    res2 += tmp;
            }
        }
        return Math.min(res1, res2);
    }
}
