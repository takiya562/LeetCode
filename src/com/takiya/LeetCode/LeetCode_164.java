package com.takiya.LeetCode;

public class LeetCode_164 {
    public static int maximumGap(int[] nums) {
        int len = nums.length;
        int maxVal = 0;
        for (int i = 0; i < len; ++i)
            maxVal = Math.max(nums[i], maxVal);

        int exp = 1;
        int radix = 10;

        while (maxVal / exp > 0) {
            int[] count = new int[radix];

            for (int i = 0; i < len ; ++i)
                count[(nums[i] / exp) % 10]++;

            for (int i = 1; i < radix; ++i)
                count[i] += count[i - 1];

            int[] temp = new int[len];
            for (int i = len - 1; i >=0; --i)
                temp[--count[(nums[i] / exp) % 10]] = nums[i];

            for (int i = 0; i < len; ++i)
                nums[i] = temp[i];

            exp *= 10;
        }

        int max = 0;
        for (int i = 0; i < len - 1; ++i)
            max = Math.max(nums[i + 1] - nums[i], max);

        return max;
    }

    public static void main(String args[]) {
        int[] nums = {3,6,9,1};
        maximumGap(nums);
    }
}
