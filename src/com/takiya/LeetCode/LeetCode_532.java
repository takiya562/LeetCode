package com.takiya;

import java.util.Arrays;

public class LeetCode_532 {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        if (len < 2)
            return 0;
        Arrays.sort(nums);
        int pre = 0x7fffffff;
        int start = 0;
        for (int i = 1; i < len; i++) {
            if (nums[start] == pre || nums[i] - nums[start] > k) {
                start++;
                if (start != i)     //start为匹配基准，每个基准从上一个基准差值大于K的地方开始，所以要回滚i
                    i--;
            }
            else if (nums[i] - nums[start] == k) {
                ans++;
                pre = nums[start++];
            }
        }
        return ans;
    }
}
