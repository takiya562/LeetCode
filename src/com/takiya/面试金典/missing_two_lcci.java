package com.takiya.面试金典;

public class missing_two_lcci {
    public int[] missingTwo(int[] nums) {
        int N = nums.length + 2;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        int sumOfTwo = (1 + N) * N / 2 - sum;
        int threshold = sumOfTwo / 2;
        sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= threshold)
                sum += nums[i];
        }
        int a = (1 + threshold) * threshold / 2 - sum;
        int b = sumOfTwo - a;
        return new int[] {a, b};
    }
}
