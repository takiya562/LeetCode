package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_896 {
	public boolean isMonotonic(int[] A) {
		int n = A.length;
		if (n <= 2)	return true;
		int pre = 0;
		for (int i = 1; i < n; i++) {
			int cur = A[i] - A[i - 1] == 0 ? 0 : A[i] - A[i - 1] > 0 ? 1 : -1;
			if (pre != 0 && pre + cur == 0)
				return false;
			if (cur != 0)
				pre = cur;
		}
		return true;
    }

    @Test
    public void test() {
    	int[] A = Tools.stringToIntegerArray("[1,2,2,3]");
    	Assert.assertTrue(isMonotonic(A));
    	A = Tools.stringToIntegerArray("[6,5,4,4]");
    	Assert.assertTrue(isMonotonic(A));
    	A = Tools.stringToIntegerArray("[1,3,2]");
    	Assert.assertFalse(isMonotonic(A));
    	A = Tools.stringToIntegerArray("[1,1,1]");
    	Assert.assertTrue(isMonotonic(A));
    }
}