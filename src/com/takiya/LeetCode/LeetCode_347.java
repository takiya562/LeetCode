package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.PriorityQueue;

public class LeetCode_347 {
	public int[] topKFrequent(int[] nums, int k) {
		int n = nums.length;
		if (n == 0)	return new int[] {};
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int cnt = map.getOrDefault(num, 0);
			map.put(num, cnt + 1);
		}
		Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if (q.size() == k) {
				if (q.peek()[1] < value) {
					q.remove();
					q.add(new int[] {key, value});
				}
			} else {
				q.add(new int[] {key, value});
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = q.poll()[0];
		}
		return res;
    }

    @Test
    public void test() {
    	int[] nums = Tools.stringToIntegerArray("[1,1,1,2,2,3]");
    	int[] res = topKFrequent(nums, 2);
    	Assert.assertEquals("[2,1]", Tools.IntegerArrayToString(res));
    }
}