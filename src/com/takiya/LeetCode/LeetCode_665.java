package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_665 {
	public boolean checkPossibility(int[] nums) {
		int n = nums.length;
		if (n == 0)	return true;
		int pre = nums[0];
		boolean flag = false;
		int bound = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			if (nums[i] < pre) {
				if (flag)
					return false;
				else {
					flag = true;
					if (nums[i] >= bound) {
						bound = nums[i];
						pre = nums[i];
					} else {
						bound = nums[i - 1];
						pre = nums[i - 1];
					}
				}
			} else {
				pre = nums[i];
				bound = nums[i - 1];
			}
		}
		return true;
    }

    @Test
    public void test() {
    	Assert.assertEquals(true, checkPossibility(Tools.stringToIntegerArray("[4,2,3]")));
    	Assert.assertEquals(false, checkPossibility(Tools.stringToIntegerArray("[4,2,1]")));
    	Assert.assertEquals(false, checkPossibility(Tools.stringToIntegerArray("[3,4,2,3]")));
    }
}	