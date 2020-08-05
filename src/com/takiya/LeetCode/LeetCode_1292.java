package com.takiya.LeetCode;

public class LeetCode_1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] prefix = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int l = 1, r = Math.min(rows, cols);
        int res = 0;
        while (l <= r) {
            boolean find = false;
            int len = (l + r) >>> 1;
            for (int i = 1; i <= rows - len + 1; ++i) {
                for (int j = 1; j <= cols - len + 1; ++j) {
                    if (getSum(prefix, i, j, i + len - 1, j + len - 1) <= threshold) {
                        find = true;
                        break;
                    }
                }
            }
            if (find) {
                l = len + 1;
                res = len;
            }
            else
                r = len - 1;
        }
        return res;
    }
    int getSum(int[][] prefix, int x1, int y1, int x2, int y2) {
        return prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
    }
}
