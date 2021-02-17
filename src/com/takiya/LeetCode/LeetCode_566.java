package com.takiya.LeetCode;


public class LeetCode_566 {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int n = nums.length;
		if (n == 0)	return nums;
		int m = nums[0].length;
		if (m * n != r * c)	return nums;
		int[][] res = new int[r][c];
		int index = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i][j] = nums[index / m][index % m];
				index++;
			}
		}
		return res;
    }
}