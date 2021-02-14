package com.takiya.LeetCode;

import org.junit.Test;
import org.junit.Assert;
import include.Tools;
import java.util.Arrays;

public class LeetCode_765 {
	public int minSwapsCouples(int[] row) {
		int n = row.length;
		if (n % 2 != 0)	return -1;
		int[] map = new int[n];
		Arrays.fill(map, -1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			int c1 = row[i];
			int c2 = getCouple(c1);
			if (map[c2] == -1) {
				map[c1] = i;
			} else if (!isCouple(map[c2], i)) {
				swap(row, map, i, getCouple(map[c2]));
				res++;
			}
		}
		return res;
    }

    private void swap(int[] nums, int[] map, int i, int j) {
    	map[nums[i]] = j;
		map[nums[j]] = i;
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

    private boolean isCouple(int i, int j) {
    	if ((i & 1) == 1) {
    		return i - 1 == j;
    	} else {
    		return i + 1 == j;
    	}
    }

    private int getCouple(int i) {
    	if ((i & 1) == 1) {
    		return i - 1;
    	} else {
    		return i + 1;
    	}
    }

    @Test
    public void test() {
    	Assert.assertEquals(1, minSwapsCouples(Tools.stringToIntegerArray("[0,2,1,3]")));
    	Assert.assertEquals(0, minSwapsCouples(Tools.stringToIntegerArray("[3,2,0,1]")));
    }
}