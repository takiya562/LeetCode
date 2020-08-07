package com.takiya.LeetCode;

public class LeetCode_1020 {
    int[] dirs = {-1, 0, 1, 0, -1};
    int rows, cols;
    public int numEnclaves(int[][] A) {
        rows = A.length;
        cols = A[0].length;
        for (int i = 0; i < rows; ++i) {
            dfs(A, i, 0);
            dfs(A, i, cols - 1);
        }
        for (int i = 0; i < cols; ++i) {
            dfs(A, 0, i);
            dfs(A, rows - 1, i);
        }
        int count = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (A[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
    void dfs(int[][] A, int r, int c) {
        if (A[r][c] == 0)
            return;
        A[r][c] = 0;    //淹没
        for (int i = 0; i < 4; ++i) {
            int x = r + dirs[i];
            int y = c + dirs[i + 1];
            if (x >= 0 && x < rows && y >= 0 && y < cols)
                dfs(A, x, y);
        }
    }
}
