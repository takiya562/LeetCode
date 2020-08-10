package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_960 {
    public int minDeletionSize(String[] A) {
        int rows = A.length;
        if (rows == 0)
            return 0;
        int cols = A[0].length();
        char[][] chars = new char[rows][cols];
        for (int i = 0; i < rows; ++i)
            chars[i] = A[i].toCharArray();
        int[] dp = new int[cols];
        int max = 1;
        for (int i = 0; i < cols; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                boolean flag = true;
                for (int r = 0; r < rows; ++r) {
                    if (chars[r][i] < chars[r][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return cols - max;
    }

    @Test
    public void test() {
        String[] A = {"aaa","aaa","aaa"};
        int res = minDeletionSize(A);
        System.out.println(res);
    }
}
