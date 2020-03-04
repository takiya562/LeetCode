package com.takiya.LeetCode;

import java.util.Arrays;

public class LeetCode_673 {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int[] lengths = new int[len];
        int[] counts = new int[len];
        Arrays.fill(counts, 1);
        for (int j = 0; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[j] > nums[i]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    }
                    else if (lengths[i] + 1 == lengths[j])
                        counts[j] += counts[i];
                }
            }
        }
        int longest = 0, ans = 0;
        for (int length : lengths)
            longest = Math.max(longest, length);
        for (int i = 0; i < len; ++i) {
            if (lengths[i] == longest)
                ans += counts[i];
        }
        return ans;
    }
}
