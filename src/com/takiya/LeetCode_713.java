package com.takiya;

public class LeetCode_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int now = 1, left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) now /= nums[left++];
            ans += right-left+1;
        }
        return ans;
    }
}
