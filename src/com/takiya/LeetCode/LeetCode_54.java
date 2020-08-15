package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        List<Integer> list = new ArrayList<>();
        if (m == 0)
            return list;
        int n = matrix[0].length;
        int t = (Math.min(m, n) + 1) / 2;
        for (int i = 0; i < t; ++i) {
            for (int j = i; j <= n - i - 1; ++j)
                list.add(matrix[i][j]);
            for (int j = i + 1; j <= m - i - 1; ++j)
                list.add(matrix[j][n - i - 1]);
            for (int j = n - i - 2; j >= i && m - i - 1 != i; --j)
                list.add(matrix[m - i - 1][j]);
            for (int j = m - i - 2; j >= i + 1 && n - i - 1 != i; --j)
                list.add(matrix[j][i]);
        }
        return list;
    }
    @Test
    public void test() {
        int[][] matrix = {{7},{9},{6}};
        List<Integer> list = spiralOrder(matrix);
        list.forEach(x -> {
            System.out.print(x + " ");
        });
    }
}
