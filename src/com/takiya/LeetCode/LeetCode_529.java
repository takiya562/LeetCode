package com.takiya.LeetCode;

public class LeetCode_529 {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    int rows;
    int cols;
    public char[][] updateBoard(char[][] board, int[] click) {
        rows = board.length;
        cols = board[0].length;
        helper(board, click[0], click[1]);
        return board;
    }
    void helper (char[][] board, int row, int col) {
        char c = board[row][col];
        if (c == 'M') {
            board[row][col] = 'X';
            return;
        }
        if (c != 'E')
            return;
        int count = 0;
        for (int i = 0; i < dirs.length; ++i) {
            int x = row + dirs[i][0];
            int y = col + dirs[i][1];
            if (verify(x, y) && board[x][y] == 'M')
                count++;
        }
        if (count == 0) {
            board[row][col] = 'B';
            for (int i = 0; i < dirs.length; ++i) {
                int x = row + dirs[i][0];
                int y = col + dirs[i][1];
                if (verify(x, y))
                    helper(board, x, y);
            }
        } else
            board[row][col] = (char)(count + 48);
    }
    boolean verify(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
