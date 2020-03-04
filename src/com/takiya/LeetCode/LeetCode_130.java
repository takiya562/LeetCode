package com.takiya.LeetCode;
import include.UnionFind;

public class LeetCode_130 {
    /*
    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i==0 || j == 0 || i == m-1 || j == n-1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j <0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X')
            return;
        board[i][j] = '#';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }*/

    public static void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        UnionFind uf = new UnionFind(rows*cols+1);
        int dummy = rows*cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 || j == 0 || i == rows-1 || j == cols-1)
                        uf.Union(node(i, j, cols), dummy);
                    else {
                        if (i > 0 && board[i-1][j] == 'O')
                            uf.Union(node(i, j, cols), node(i-1, j, cols));
                        if (j > 0 && board[i][j-1] == 'O')
                            uf.Union(node(i, j, cols), node(i, j-1, cols));
                        if (i < rows-1 && board[i+1][j] == 'O')
                            uf.Union(node(i+1, j, cols), node(i, j, cols));
                        if (j < cols-1 && board[i][j+1] == 'O')
                            uf.Union(node(i, j+1, cols), node(i, j, cols));
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.Find(node(i, j, cols)) == dummy)
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    public static int node(int i, int j, int cols) {
        return i*cols+j;
    }


    public static void main(String args[]) {
        char[][] board = {{'O','X','X'},
                         {'X','O','X'},
                         {'X','X','O'}
                        };
        solve(board);
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
    }
}
