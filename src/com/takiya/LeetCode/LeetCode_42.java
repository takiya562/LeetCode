package com.takiya;

public class LeetCode_42 {
    public int trap_1(int[] height) {
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

    public int trap_2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length; i++)
            max_left[i] = Math.max(max_left[i-1], height[i-1]);

        for (int j = height.length - 2; j > 0; j--)
            max_right[j] = Math.max(max_right[j+1], height[j+1]);

        for (int n = 0; n < height.length; n++) {
            int min = Math.min(max_left[n], max_right[n]);
            if (min > height[n])
                sum += min - height[n];
        }
        return sum;
    }

    public int trap_3(int[] height) {
        int sum = 0;
        int[] max_right = new int[height.length];
        int max_left = 0;

        for (int i = height.length - 2; i > 0; --i)
            max_right[i] = Math.max(max_right[i+1], height[i+1]);

        for (int i = 1; i < height.length - 1; ++i) {
            max_left = Math.max(max_left, height[i-1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i])
                sum += min - height[i];
        }
        return sum;
    }

    public int trap_4(int[] height) {
        int sum = 0;
        int right = height.length - 2;
        int left = 1;
        int max_left = 0, max_right = 0;

        for (int i = 1; i < height.length - 1; ++i) {
            if (height[left-1] < height[right+1]) {
                max_left = Math.max(max_left, height[left-1]);
                int min = max_left;
                if (min > height[left])
                    sum += min - height[left];
                left++;
            }
            else {
                max_right = Math.max(max_right, height[right+1]);
                int min = max_right;
                if (min > height[right])
                    sum += min - height[right];
                right--;
            }
        }
        return sum;
    }
}
