package com.takiya.LeetCode;
import include.Tools;
import include.UnionFind;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode_130 {
    int[] dirs = {-1, 0, 1, 0, -1};
    int r, c;
    public void solve(char[][] board) {
        r = board.length;
        if (r == 0) return;
        c = board[0].length;
        UnionFind uf = new UnionFind(r * c);
        boolean[][] visited = new boolean[r][c];
        //上
        for (int i = 0; i < c - 1; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                visited[0][i] = true;
                dfs(board, visited, uf, 0, i);
            }
        }
        //右
        for (int i = 0; i < r - 1; i++) {
            if (!visited[i][c - 1] && board[i][c - 1] == 'O') {
                visited[i][c - 1] = true;
                dfs(board, visited, uf, i, c - 1);
            }
        }
        //下
        for (int i = c - 1; i > 0; i--) {
            if (!visited[r - 1][i] && board[r - 1][i] == 'O') {
                visited[r - 1][i] = true;
                dfs(board, visited, uf, r - 1, i);
            }
        }
        //左
        for (int i = r - 1; i > 0; i--) {
            if (!visited[i][0] && board[i][0] == 'O') {
                visited[i][0] = true;
                dfs(board, visited, uf, i, 0);
            }
        }
        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                int parent = uf.find(i * c + j);
                if (parent / c == 0 || parent / c == r - 1 || parent % c == 0 || parent % c == c - 1)
                    continue;
                board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, UnionFind uf, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i], ny = y + dirs[i + 1];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && board[nx][ny] == 'O') {
                uf.union(x * c + y, nx * c + ny);
                visited[nx][ny] = true;
                dfs(board, visited, uf, nx, ny);
            }
        }
    }

    @Test
    public void test() {
        String expected = "[[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"]]";
        String origin = "[[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\",\"O\",\"X\"]]";
        char[][] board = Tools.stringToCharMatrix(origin);
        solve(board);
        Assert.assertEquals(expected, Tools.prettyCharMatrixToString(board));
        origin = "[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]";
        expected = "[[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]]";
        board = Tools.stringToCharMatrix(origin);
        solve(board);
        Assert.assertEquals(expected, Tools.prettyCharMatrixToString(board));
        origin = "[[\"O\",\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"O\",\"X\",\"O\"],[\"X\",\"O\",\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\",\"O\",\"O\"],[\"X\",\"X\",\"O\",\"X\",\"O\"]]";
        expected = "[[\"O\",\"X\",\"X\",\"O\",\"X\"],[\"X\",\"X\",\"X\",\"X\",\"O\"],[\"X\",\"X\",\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\",\"O\",\"O\"],[\"X\",\"X\",\"O\",\"X\",\"O\"]]";
        board = Tools.stringToCharMatrix(origin);
        solve(board);
        Assert.assertEquals(expected, Tools.prettyCharMatrixToString(board));
        origin = "[[\"X\",\"O\",\"X\",\"X\"],[\"O\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\"]]";
        expected = "[[\"X\",\"O\",\"X\",\"X\"],[\"O\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"O\"],[\"O\",\"X\",\"O\",\"X\"]]";
        board = Tools.stringToCharMatrix(origin);
        solve(board);
        Assert.assertEquals(expected, Tools.prettyCharMatrixToString(board));
    }
}
