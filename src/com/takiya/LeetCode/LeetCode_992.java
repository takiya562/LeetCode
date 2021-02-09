package com.takiya.LeetCode;

import include.Tools;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_992 {
	public int subarraysWithKDistinct(int[] A, int K) {
		int n = A.length;
		if (n == 0)	return 0;
		Map<Integer, Integer> counts = new HashMap<>();
		int winCount = 0;
		int l = 0;
		int r = 0;
		int res = 0;
		int[] bounds = new int[n];
		for (; r < n; r++) {
			int num = A[r];
			int count = counts.getOrDefault(num, 0);
			if (count == 0) {
				winCount++;
			}
			counts.put(num, count + 1);
			if (winCount == K) {
				while (winCount == K && l <= r) {
					bounds[l] = r;
					num = A[l++];
					count = counts.get(num);
					if (count == 1) {
						winCount--;
					}
					counts.put(num, count - 1);
				}
			}
		}
		for (; l < n; l++) {
			bounds[l] = -1;
			counts.put(A[l], 0);
		}
		l = 0;
		r = 0;
		winCount = 0;
		while (r < n) {
			int num;
			int count;
			while (r < n) {
				num = A[r];
				count = counts.get(num);
				if (count == 0) {
					winCount++;
				}
				if (winCount > K) {
					winCount--;
					break;
				}
				counts.put(num, count + 1);
				r++;
			}
			while (l < r && winCount == K) {
				num = A[l];
				count = counts.get(num);
				if (count == 1) {
					winCount--;
				}
				if (bounds[l] != -1 && bounds[l] < r) {
					res += r - bounds[l];
					l++;
				}
				counts.put(num, count - 1);
			}
		}
		return res;
    }
    @Test
    public void test() {
    	Assert.assertEquals(7, subarraysWithKDistinct(Tools.stringToIntegerArray("[1,2,1,2,3]"), 2));
    	Assert.assertEquals(3, subarraysWithKDistinct(Tools.stringToIntegerArray("[1,2,1,3,4]"), 3));
    }
}