package com.takiya.LeetCode;

public class LeetCode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            int cur = matrix[i][j];
            if (cur == target)
                return true;
            else if (cur > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
