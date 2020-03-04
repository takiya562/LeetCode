package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_51 {
    List<List<String>> ans;
    int[][] dirs = {{1,1},{1,-1},{-1,1},{-1,-1}};
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        int[][] board = new int[n][n];
        traceBack(board, 0, n, new ArrayList<>());
        return ans;
    }

    public void traceBack(int[][] board, int row, int boundary, List<String> temp) {
        if (row < 0 || row >= boundary) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int col = 0; col < boundary; ++col) {
            boolean success = true;
            for (int i = 0; i < 4; ++i) {
                int r = row, c = col;
                while (r >= 0 && r < boundary && c >= 0 && c < boundary) {
                    if (board[r][c] == 1) {
                        success = false;
                        break;
                    }
                    r += dirs[i][0];
                    c += dirs[i][1];
                }
                if (!success)   break;
            }
            if (!success)   continue;
            for (int i = 0; i < boundary; ++i) {
                if (board[i][col] == 1) {
                    success = false;
                    break;
                }
            }
            if (!success)   continue;
            temp.add(createString(boundary, col));
            board[row][col] = 1;
            traceBack(board, row + 1, boundary, temp);
            board[row][col] = 0;
            temp.remove(temp.size() - 1);
        }
    }

    public String createString(int boundary, int col) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < boundary; ++i) {
            if (i == col)
                str.append("Q");
            else
                str.append(".");
        }
        return str.toString();
    }
}
