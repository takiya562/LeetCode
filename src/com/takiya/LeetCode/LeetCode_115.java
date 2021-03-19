package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_115 {
	public int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();
		if (m < n) 	return 0;
		int[][] dp = new int[n][m];
		if (s.charAt(0) == t.charAt(0))
			dp[0][0] = 1;
		for (int i = 1; i < m; i++) {
			if (t.charAt(0) == s.charAt(i))
				dp[0][i] = dp[0][i - 1] + 1;
			else
				dp[0][i] = dp[0][i - 1];
		}
		for (int i = 1; i < n; i++) {
			for (int j = i; j < m; j++) {
				if (s.charAt(j) == t.charAt(i))
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				else
					dp[i][j] = dp[i][j - 1];
			}
		}
		return dp[n - 1][m - 1];
    }

    @Test
    public void test() {
    	Assert.assertEquals(3, numDistinct("rabbbit", "rabbit"));
    	Assert.assertEquals(5, numDistinct("babgbag", "bag"));
    }
}