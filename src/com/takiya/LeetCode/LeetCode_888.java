package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;

public class LeetCode_888 {
	public int[] fairCandySwap(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int a = 0, b = 0;
		for (int i = 0; i < m; i++) {
			a += A[i];
		}
		for (int i = 0; i < n; i++) {
			b += B[i];
		}
		//Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < m; i++) {
			int low = 0, high = n - 1;
			while (low <= high) {
				int mid = (low + high) >>> 1;
				int na = a - A[i] + B[mid];
				int nb = b - B[mid] + A[i];
				if (na == nb) {
					return new int[] {A[i], B[mid]};
				} else if (na < nb) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return null;
    }

    @Test
    public void test() {
    	Assert.assertEquals("[1,2]", Tools.IntegerArrayToString(fairCandySwap(Tools.stringToIntegerArray("[1,1]"), Tools.stringToIntegerArray("[2,2]"))));
    	Assert.assertEquals("[1,2]", Tools.IntegerArrayToString(fairCandySwap(Tools.stringToIntegerArray("[1,2]"), Tools.stringToIntegerArray("[2,3]"))));
    	Assert.assertEquals("[2,3]", Tools.IntegerArrayToString(fairCandySwap(Tools.stringToIntegerArray("[2]"), Tools.stringToIntegerArray("[1,3]"))));
    	Assert.assertEquals("[5,4]", Tools.IntegerArrayToString(fairCandySwap(Tools.stringToIntegerArray("[1,2,5]"), Tools.stringToIntegerArray("[2,4]"))));
    }
}