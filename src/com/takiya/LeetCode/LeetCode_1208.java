package com.takiya.LeetCode;

import org.junit.Test;
import org.junit.Assert;

public class LeetCode_1208 {
	public int equalSubstring(String s, String t, int maxCost) {
		int n = s.length();
		char[] char1 = s.toCharArray();
		char[] char2 = t.toCharArray();
		int l = 0;
		int cost = 0;
		for (int r = 0; r < n; r++) {
			cost += Math.abs(char2[r] - char1[r]);
			if (cost > maxCost) {
				cost -= Math.abs(char2[l] - char1[l]);
				l++;
			}
		}
		return n - l;
    }

    @Test
    public void test() {
    	Assert.assertEquals(3, equalSubstring("abcd", "bcdf", 3));
    	Assert.assertEquals(1, equalSubstring("abcd", "cdef", 3));
    	Assert.assertEquals(1, equalSubstring("abcd", "acde", 0));
    }
}