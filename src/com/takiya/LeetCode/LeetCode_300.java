package com.takiya.LeetCode;

import com.sun.source.tree.WhileLoopTree;

public class LeetCode_300 {
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
    public static int lengthOfLIS_2(int[] nums) {
        int len = nums.length;
        if (len == 0)   return 0;
        int[] tails = new int[len];
        int res = 0;
        for (int i = 0; i < len; ++i) {
            int L = 0, R = res;
            while (L < R) {
                int mid = (L + R) / 2;
                if (tails[mid] < nums[i])
                    L = mid + 1;
                else
                    R = mid;
            }
            tails[L] = nums[i];
            if (R == res)   res++;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] nums = {10,9,2,5,3,7,101,18};
        lengthOfLIS(nums);
    }
}
