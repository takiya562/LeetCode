package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_152 {
	public int maxProduct(int[] nums) {
		int n = nums.length;
		if (n == 0)	return 0;
		int[][] dp = new int[n][2];
		dp[0][0] = nums[0]; dp[0][1] = nums[0];
		int res = dp[0][0];
		for (int i = 1; i < n; i++) {
			int tmp1 = dp[i - 1][0] * nums[i];
			int tmp2 = dp[i - 1][1] * nums[i];
			dp[i][0] = Math.max(nums[i], tmp1);
			dp[i][0] = Math.max(dp[i][0], tmp2);
			dp[i][1] = Math.min(nums[i], tmp1);
			dp[i][1] = Math.min(dp[i][1], tmp2);
			res = Math.max(res, dp[i][0]);
		}
		return res;
    }

    @Test
    public void test() {
    	Assert.assertEquals(6, maxProduct(Tools.stringToIntegerArray("[2,3,-2,4]")));
    	Assert.assertEquals(0, maxProduct(Tools.stringToIntegerArray("[-2,0,-1]")));
    	Assert.assertEquals(24, maxProduct(Tools.stringToIntegerArray("[-2,3,-4]")));
    }
}