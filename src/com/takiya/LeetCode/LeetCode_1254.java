package com.takiya.LeetCode;

public class LeetCode_1254 {
    static int rows;
    static int cols;
    static int[] dir = {-1, 0, 1, 0, -1};
    public static int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int ans = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    if (recursion(grid, row, col))
                        ans++;
                }
            }
        }
        return ans;
    }
    public static boolean recursion(int[][] grid, int row, int col) {
        if (row < 0 || row == rows || col < 0 || col == cols)
            return false;
        if (grid[row][col] == -1)
            return true;
        if (grid[row][col] == 1)
            return true;
        if (grid[row][col] == 0) {
            grid[row][col] = -1;
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                if (!recursion(grid, row+dir[i], col+dir[i+1]))
                    flag = false;
            }
            if (!flag)
                return false;
        }
        return true;
    }
    public static void main(String args[]) {
        int[][] grid = {{0,0,1,1,0,1,0,0,1,0},
                        {1,1,0,1,1,0,1,1,1,0},
                        {1,0,1,1,1,0,0,1,1,0},
                        {0,1,1,0,0,0,0,1,0,1},
                        {0,0,0,0,0,0,1,1,1,0},
                        {0,1,0,1,0,1,0,1,1,1},
                        {1,0,1,0,1,1,0,0,0,1},
                        {1,1,1,1,1,1,0,0,0,0},
                        {1,1,1,0,0,1,0,1,0,1},
                        {1,1,1,0,1,1,0,1,1,0}};

        int ans = closedIsland(grid);
        System.out.print(ans);
    }
}
