package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_221 {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		if (n == 0)	return 0;
		int m = matrix[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			 for (int j = 1; j <= m; j++) {
			 	if (matrix[i - 1][j - 1] == '1') {
			 		dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
			 	} else {
			 		dp[i][j] = 0;
			 	}
			 	max = Math.max(max, dp[i][j]);
			 }
		}
		return max * max;
    }

    @Test
    public void test() {
    	String s = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";
    	char[][] matrix = Tools.stringToCharMatrix(s);
    	Assert.assertEquals(4, maximalSquare(matrix));
    	s = "[[\"0\",\"1\"],[\"1\",\"0\"]]";
    	matrix = Tools.stringToCharMatrix(s);
    	Assert.assertEquals(1, maximalSquare(matrix));
    }
}