package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int t = (n + 1) / 2;
        int num = 1;
        for (int i = 0; i < t; ++i) {
            for (int j = i; j <= n - i - 1; ++j)
                res[i][j] = num++;
            for (int j = i + 1; j < n - i - 1; ++j)
                res[j][n - i - 1] = num++;
            for (int j = n - i - 1; j > i; --j)
                res[n - i - 1][j] = num++;
            for (int j = n - i - 1; j > i; --j)
                res[j][i] = num++;
        }
        return res;
    }
    @Test
    public void test() {
        int[][] res = generateMatrix(0);
        Arrays.stream(res).forEach(x -> {
            for (int n : x)
                System.out.print(n + " ");
            System.out.println();
        });
    }
}
