package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayDeque;

public class LeetCode_1438 {
	public int longestSubarray(int[] nums, int limit) {
		int n = nums.length;
		if (n == 0)	return 0;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		ArrayDeque<Integer> ascend = new ArrayDeque<>();
		ArrayDeque<Integer> descend = new ArrayDeque<>();
		int l = 0;
		for (int r = 0; r < n; r++) {
			while (!ascend.isEmpty() && ascend.peekLast() > nums[r]) {
				ascend.removeLast();
			}
			while (!descend.isEmpty() && descend.peekLast() < nums[r]) {
				descend.removeLast();
			}
			ascend.addLast(nums[r]);
			descend.addLast(nums[r]);
			max = Math.max(max, nums[r]);
			min = Math.min(min, nums[r]);
			if (max - min > limit) {
				int num = nums[l++];
				if (ascend.peekFirst() == num) {
					ascend.removeFirst();
					min = ascend.peekFirst();
				}
				if (descend.peekFirst() == num) {
					descend.removeFirst();
					max = descend.peekFirst();
				} 
			}
		}	
		return n - l;
    }

    @Test

    public void test() {
    	int[] nums = Tools.stringToIntegerArray("[8,2,4,7]");
    	Assert.assertEquals(2, longestSubarray(nums, 4));
    	nums = Tools.stringToIntegerArray("[10,1,2,4,7,2]");
    	Assert.assertEquals(4, longestSubarray(nums, 5));
		nums = Tools.stringToIntegerArray("[4,2,2,2,4,4,2,2]");
    	Assert.assertEquals(3, longestSubarray(nums, 0));
    }
}