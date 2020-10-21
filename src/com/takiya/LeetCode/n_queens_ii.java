package com.takiya.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class n_queens_ii {
    int[][] dirs = {{-1, 1}, {-1, -1}};
    int[][] graph;
    int count;
    Set<Integer> colSet;
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        count = 0;
        graph = new int[n][n];
        colSet = new HashSet<>();
        backTrace(0, n);
        return count;
    }

    private void backTrace(int row, int n) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (colSet.contains(i) || isConflict(row, i, n, dirs[0]) || isConflict(row, i, n, dirs[1])) continue;
            graph[row][i] = 1;
            colSet.add(i);
            backTrace(row + 1, n);
            colSet.remove(i);
            graph[row][i] = 0;
        }
    }

    private boolean isConflict(int row, int col, int n, int[] dir) {
        while (row >= 0 && row < n && col >= 0 && col < n) {
            if (graph[row][col] == 1)   return true;
            row += dir[0];
            col += dir[1];
        }
        return false;
    }
}
