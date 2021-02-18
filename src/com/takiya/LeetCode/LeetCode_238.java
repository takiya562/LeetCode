package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_238 {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		if (n == 0)	return new int[0]{};
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 0; i < n - 1; i++) {
			res[i + 1] = res[i] * nums[i];
		}

		int tmp = 1;
		for (int i = n - 1; i > 0; i--) {
			res[i] = res[i] * tmp;
			tmp *= nums[i];
		}
		return res;
    }
}