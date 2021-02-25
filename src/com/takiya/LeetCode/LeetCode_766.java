package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_766 {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int n = matrix.length;
		if (n == 0)	return true;
		int m = matrix[0].length;
		for (int i = 0; i < m - 1; i++) {
			int r = 0, c = i;
			while (r < n - 1 && c < m - 1) {
				if (matrix[r][c] != matrix[r + 1][c + 1])
					return false;
				r++;
				c++;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int r = i, c = 0;
			while (r < n - 1 && c < m - 1) {
				if (matrix[r][c] != matrix[r + 1][c + 1])
					return false;
				r++;
				c++;
			}
		}
		return true;
    }

    @Test
    public void test() {
    	int[][] matrix = Tools.stringToIntegerMatrix("[[1,2,3,4],[5,1,2,3],[9,5,1,2]]");
    	Assert.assertTrue(isToeplitzMatrix(matrix));
    	matrix = Tools.stringToIntegerMatrix("[[1,2],[2,2]]");
    	Assert.assertFalse(isToeplitzMatrix(matrix));
    }
}