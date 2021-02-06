package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_1423 {
	public int maxScore(int[] cardPoints, int k) {
		int n = cardPoints.length;
		if (n < k)	return 0;
		int max = 0;
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + cardPoints[i - 1];
		}
		for (int left = 0; left <= k; left++) {
			int right = k - left;
			max = Math.max(max, sum[left] + sum[n] - sum[n - right]);
		}
		return max;
    }

    @Test
    public void test() {
    	Assert.assertEquals(12, maxScore(Tools.stringToIntegerArray("[1,2,3,4,5,6,1]"), 3));
    	Assert.assertEquals(4, maxScore(Tools.stringToIntegerArray("[2,2,2]"), 2));	
    	Assert.assertEquals(55, maxScore(Tools.stringToIntegerArray("[9,7,7,9,7,7,9]"),7));
    	Assert.assertEquals(1, maxScore(Tools.stringToIntegerArray("[1,1000,1]"),1));
    	Assert.assertEquals(202, maxScore(Tools.stringToIntegerArray("[1,79,80,1,1,1,200,1]"),3));
    }
}