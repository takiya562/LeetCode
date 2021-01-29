package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_312 {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		if (n == 0)	return 0;
		int[] temp = new int[n + 2];
		temp[0] = temp[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
			temp[i] = nums[i - 1];
		}
		int[][] dp = new int[n + 2][n + 2];
		for (int len = 3; len <= n + 2; len++) {
			for (int i = 0; i + len - 1 <= n + 1; i++) {
				int max = 0;
				for (int k = i + 1; k < i + len - 1; k++) {
					int left = dp[i][k];
					int right = dp[k][i + len - 1];
					max = Math.max(max, left + temp[i] * temp[k] * temp[i + len - 1] + right);
				}
				dp[i][i + len - 1] = max;
			}
		}
		return dp[0][n + 1];
    }

    @Test
    public void test() {
    	Assert.assertEquals(167, maxCoins(Tools.stringToIntegerArray("[3,1,5,8]")));
    	Assert.assertEquals(10, maxCoins(Tools.stringToIntegerArray("[1,5]")));
    }
}