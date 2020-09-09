package com.takiya.LeetCode;

import org.junit.Assert;
import org.junit.Test;


public class LeetCode_79 {
    int[] dirs = {-1, 0, 1, 0, -1};
    int m, n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        m = board.length;
        if (m == 0) return false;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, chars, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[] word, int index, int i, int j) {
        if (index == word.length - 1)
            return board[i][j] == word[index];
        if (board[i][j] == word[index]) {
            visited[i][j] = true;
            for (int n = 0; n < dirs.length - 1; n++) {
                int x = i + dirs[n];
                int y = j + dirs[n + 1];
                if (verify(x, y) && !visited[x][y]) {
                    if (dfs(board, word, index + 1, x, y))
                        return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
    private boolean verify(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    @Test
    public void test() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'a','a'}};
        Assert.assertFalse(exist(board, "ABCCED"));
    }
}
