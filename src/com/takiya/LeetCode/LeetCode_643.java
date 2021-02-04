package com.takiya.LeetCode;

import include.Tools.
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_643 {
	public double findMaxAverage(int[] nums, int k) {
		int n = nums.length;
		if (n == 0)	return 0;
		double sum = 0;
		int left = 0;
		double max;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		max = sum / k;
		int j = 0;
		for (int i = k; i < n; i++) {
			sum += nums[i];
			sum -= nums[j++];
			max = Math.max(max, sum / k);
		}
		return max;
    }
}