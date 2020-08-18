package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_73 {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return;
        int cols = matrix[0].length;
        boolean isCols = false;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)
                isCols = true;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++)
                matrix[0][j] = 0;
        }
        if (isCols) {
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;
        }
    }
    @Test
    public void test() {
        int[][] matrix = {{2147483647},{2},{3}};
        setZeroes(matrix);
    }
}
