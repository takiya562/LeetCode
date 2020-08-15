package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int t = n / 2;
        int step = n - 1;
        for (int i = 0; i < t; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                helper(matrix, i, j, step);
            }
        }
    }

    private void helper(int[][] matrix, int i, int j, int step) {
        int x = i, y = j;
        int num = matrix[i][j];
        for (int n = 0; n < 4; ++n) {
            int tmp = i;
            i = j;
            j = step - tmp;
            tmp = matrix[i][j];
            matrix[i][j] = num;
            num = tmp;
        }
    }
    @Test
    public void test1() {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Arrays.stream(matrix).forEach(ints -> {
            Arrays.stream(ints).forEach(num -> {
                System.out.print(num + " ");
            });
            System.out.println();
        });
        rotate(matrix);
        System.out.println("----------------------");
        Arrays.stream(matrix).forEach(ints -> {
            Arrays.stream(ints).forEach(num -> {
                System.out.print(num + " ");
            });
            System.out.println();
        });
    }
}
