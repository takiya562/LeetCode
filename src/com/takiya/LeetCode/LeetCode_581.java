package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_581 {
	public int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		if (n == 0)	return 0;
		boolean flag = false;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			if (nums[i] < nums[i - 1]) 
				flag = true;
			if (flag)
				min = Math.min(min, nums[i]);
		}
		flag = false;
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1]) 
				flag = true;
			if (flag)
				max= Math.max(max, nums[i]);
		}
		int l, r;
		for (l = 0; l < n; l++) {
			if (min < nums[l])
				break;
		}
		for (r = n - 1; r >= 0; r--) {
			if (max > nums[r])
				break;
		}
		return r - l > 0 ? r - l + 1 : 0;
    }

    @Test
    public void test() {
    	int[] nums = Tools.stringToIntegerArray("[2,6,4,8,10,9,15]");
    	Assert.assertEquals(5, findUnsortedSubarray(nums));
    	nums = Tools.stringToIntegerArray("[1,2,3,4]");
    	Assert.assertEquals(0, findUnsortedSubarray(nums));
    	nums = Tools.stringToIntegerArray("[1,3,2,2,2]");
    	Assert.assertEquals(4, findUnsortedSubarray(nums));
    	nums = Tools.stringToIntegerArray("[2,3,3,2,4]");
    	Assert.assertEquals(3, findUnsortedSubarray(nums));
    }
}