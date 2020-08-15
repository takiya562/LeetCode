package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_11 {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;
        int r = n - 1;
        int l = 0;
        int max = 0;
        while (l < r) {
            int left = height[l];
            int right = height[r];
            max = Math.max(max, (r - l) * Math.min(left, right));
            if (left >= right) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }
}
