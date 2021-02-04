package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class longest_repeating_character_replacement {
	private static final int offset = 'A';
	public int characterReplacement(String s, int k) {
		int n = s.length();
		if (n == 0)
			return 0;
		char[] chars = s.toCharArray();
		int[] window = new int[26];
		int max = 0;
		int left = 0;
		for (int right = 0; right < n; right++) {
			int index = chars[right] - offset;
			window[index]++;
			max = Math.max(max, window[index]);
			if (right - left + 1 > max + k) {
				window[chars[left] - offset]--;
				left++;
			}
		}
		return n - left;
    }

    @Test
    public void test() {
    	Assert.assertEquals(4, characterReplacement("ABAB", 2));
    	Assert.assertEquals(4, characterReplacement("AABABBA", 1));
    }
}