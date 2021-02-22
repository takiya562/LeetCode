package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_494 {
	public int findTargetSumWays(int[] nums, int S) {
		int n = nums.length;
		if (n == 0)	return 0;
		int[] dp = new int[2001];
		dp[nums[0] + 1000] += 1;
		dp[-nums[0] + 1000] += 1;
		for (int i = 1; i < n; i++) {
			int[] next = new int[2001];
			for (int sum = -1000; sum <= 1000; sum++) {
				if (dp[sum + 1000] > 0) {
					next[sum + 1000 + nums[i]] += dp[sum + 1000];
					next[sum + 1000 - nums[i]] += dp[sum + 1000];
				}
			}
			dp = next;
		}
		return S > 1000 ? 0 : dp[S + 1000];
    }

    @Test
    public void test() {
    	int[] nums = Tools.stringToIntegerArray("[1,1,1,1,1]");
    	Assert.assertEquals(5, findTargetSumWays(nums, 3));
    	nums = Tools.stringToIntegerArray("[0,0,0,0,0,0,0,0,1]");
    	Assert.assertEquals(256, findTargetSumWays(nums, 1));
    }
}