package com.takiya;

public class LeetCode_42 {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; ++i) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; --j)
                max_left = Math.max(max_left, height[j]);

            int max_right = 0;
            for (int n = i + 1; n < height.length; ++n)
                max_right = Math.max(max_right, height[n]);

            int min = Math.min(max_left, max_right);
            if (min > height[i])
                sum += min - height[i];
        }
        return sum;
    }
}
