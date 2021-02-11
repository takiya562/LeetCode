package com.takiya.LeetCode;

import org.junit.Test;
import org.junit.Assert;

public class LeetCode_567 {
	public boolean checkInclusion(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();	
		if (m < n)	return false;			
		int[] freq = new int[26];
		for (char c : s1.toCharArray()) {
			freq[c - 'a']++;
		}
		int l = 0;
		int[] window = new int[26];
		for (int r = 0; r < m; r++) {
			int index = s2.charAt(r) - 'a';
			window[index]++;
			while (window[index] > freq[index]) {
				window[s2.charAt(l) - 'a']--;
				l++;
			}
			if (r - l + 1 == n)
				return true;
		}
		return false;
    }
    @Test
    public void test() {
    	Assert.assertEquals(true, checkInclusion("ab", "eidbaooo"));
    	Assert.assertEquals(false, checkInclusion("ab", "eidboaoo"));
    }

}