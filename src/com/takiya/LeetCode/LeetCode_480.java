package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class LeetCode_480 {
	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (k == 1) {
			double[] res = new double[n];
			for (int i = 0; i < n; i++)
				res[i] = nums[i];
		}
		Queue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
		Queue<Integer> minHeap = new PriorityQueue<>();
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < k; i++) {
			count++;
			maxHeap.add(nums[i]);
			minHeap.add(maxHeap.remove());
			if ((count & 1) != 0) {
				maxHeap.add(minHeap.remove());
			}
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		double[] res = new double[n - k + 1];
		if ((k & 1) != 0) {
			res[0] = maxHeap.peek();
		} else {
			long l = maxHeap.peek();
			long r = minHeap.peek();
			res[0] = (l + r) / 2d;
		}
		int i = k, j = 0;
		while (i < n) {
			int out = nums[j];
			int in = nums[i++];
			if (!maxHeap.isEmpty() && maxHeap.peek() >= out) {
				if (maxHeap.peek() == out) {
					maxHeap.remove();
				}
				if ((k & 1) == 0) {
					maxHeap.add(minHeap.remove());
				}
			} else if (!minHeap.isEmpty() && minHeap.peek() <= out) {
				if (minHeap.peek() == out) {
					minHeap.remove();
				}
				if ((k & 1) != 0) {
					minHeap.add(maxHeap.remove());
				}
			}
			while (!maxHeap.isEmpty() && map.get(maxHeap.peek()) == 0) {
				maxHeap.remove();
			}
			while (!minHeap.isEmpty() && map.get(minHeap.peek()) == 0) {
				minHeap.remove();
			}
			map.put(out, map.get(out) - 1);
			maxHeap.add(in);
			minHeap.add(maxHeap.remove());
			if ((k & 1) != 0) {
				maxHeap.add(minHeap.remove());
			}
			map.put(in, map.getOrDefault(in, 0) + 1);
			if ((k & 1) != 0) {
				res[++j] = maxHeap.peek();
			} else {
				long l = maxHeap.peek();
				long r = minHeap.peek();
				res[++j] = (l + r) / 2d;
			}
		}
		return res;
    }
    @Test
    public void test() {
    	double[] tmp = medianSlidingWindow(Tools.stringToIntegerArray("[1,3,-1,-3,5,3,6,7]"), 3);
		System.out.println(Arrays.toString(tmp));
    }
}