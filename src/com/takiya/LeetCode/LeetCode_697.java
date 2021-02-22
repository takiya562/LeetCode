package com.takiya.LeetCode;

import java.util.Map;
import java.util.HashMap;
import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_697 {
	public int findShortestSubArray(int[] nums) {
		int n = nums.length;
		if (n == 0)	return 0;
		Map<Integer, Integer> cnts = new HashMap<>();
		Map<Integer, Integer> pos = new HashMap<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int cnt = cnts.getOrDefault(nums[i], 0);
			max = Math.max(max, ++cnt);
			cnts.put(nums[i], cnt);
			if (!pos.containsKey(nums[i]))
				pos.put(nums[i], i);
		}
		int min = n;
		for (int i = n - 1; i >= 0; i--) {
			if (cnts.get(nums[i]) == max && pos.get(nums[i]) <= i) {
				min = Math.min(min, i - pos.get(nums[i]) + 1);
				pos.put(nums[i], i);
			}
		}
		return min;
    }

    @Test
    public void test() {
    	int[] nums = Tools.stringToIntegerArray("[1,2,2,3,1]");
    	Assert.assertEquals(2, findShortestSubArray(nums));
    	nums = Tools.stringToIntegerArray("[1,2,2,3,1,4,2]");
    	Assert.assertEquals(6, findShortestSubArray(nums));
    	nums = Tools.stringToIntegerArray("[2,1]");
    	Assert.assertEquals(1, findShortestSubArray(nums));
    }
}