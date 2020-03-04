package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_329 {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    int[] dirs = {-1, 0, 1, 0, -1};
    public int longestIncreasingPath_1(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)  return 0;
        int cols = matrix[0].length;

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j)
                if (helper(matrix, i, j, rows, cols))
                    queue.add(new Pair(i, j));
        }
        int size;
        int max = 0;
        while (!queue.isEmpty()) {
            max++;
            size = queue.size();
            int[][] state = new int[rows][cols];
            for (int n = 0; n < size; ++n) {
                Pair cur = queue.poll();
                int row = cur.row;
                int col = cur.col;
                for (int k = 0; k < 4; ++k) {
                    int i = row + dirs[k];
                    int j = col + dirs[k + 1];
                    if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i][j] > matrix[row][col]) {
                        if (state[i][j] == 0) {
                            state[i][j] = 1;
                            queue.add(new Pair(i, j));
                        }
                    }
                }
            }
        }
        return max;
    }
    public boolean helper(int[][] matrix, int row, int col, int rows, int cols) {
        for (int k = 0; k < 4; ++k) {
            int i = row + dirs[k];
            int j = col + dirs[k + 1];
            if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i][j] < matrix[row][col])
                return false;
        }
        return true;
    }

    int[][] degrees;
    Queue<Pair> queue;
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)  return 0;
        int cols = matrix[0].length;
        degrees = new int[rows][cols];
        queue = new LinkedList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j)
                degrees[i][j] = calHelper(matrix, i, j, rows, cols);
        }
        int size;
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            size = queue.size();
            for (int n = 0; n < size; ++n) {
                Pair cur = queue.poll();
                int row = cur.row;
                int col = cur.col;
                searchHelper(matrix, row, col, rows, cols);
            }
        }
        return res;
    }

    public int calHelper(int[][] matrix, int row, int col, int rows, int cols) {
        int res = 0;
        for (int k = 0; k < 4; ++k) {
            int i = row + dirs[k];
            int j = col + dirs[k + 1];
            if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i][j] < matrix[row][col])
                res++;
        }
        if (res == 0)   queue.add(new Pair(row, col));
        return res;
    }

    public void searchHelper(int[][] matrix, int row, int col, int rows, int cols) {
        for (int k = 0; k < 4; ++k) {
            int i = row + dirs[k];
            int j = col + dirs[k + 1];
            if (i >= 0 && i < rows && j >= 0 && j < cols && matrix[i][j] > matrix[row][col]) {
                degrees[i][j]--;
                if (degrees[i][j] == 0)
                    queue.add(new Pair(i, j));
            }
        }
    }
}
