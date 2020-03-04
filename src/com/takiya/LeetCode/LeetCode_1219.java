package com.takiya.LeetCode;

public class LeetCode_1219 {
    public int getMaximumGold(int[][] grid) {
        int rows = grid .length;
        int cols = grid[0].length;
        int max = 0;
        int[][] state = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = recursion(grid, i, j, state);
                max = Math.max(max, temp);
            }
        }
        return max;
    }
    public int recursion(int[][] grid, int start_x, int start_y, int[][] state) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (start_x < 0 || start_x >= rows)
            return 0;
        if (start_y < 0 || start_y >= cols)
            return 0;
        if (grid[start_x][start_y] == 0 || state[start_x][start_y] == -1)
            return 0;
        int max = 0;
        int[] dirs = {0,1,0,-1,0};
        state[start_x][start_y] = -1;
        for (int i = 0; i < 4; i++) {
            int temp = recursion(grid, start_x+dirs[i], start_y+dirs[i+1], state) + grid[start_x][start_y];
            max = Math.max(max, temp);
        }
        state[start_x][start_y] = 0;
        return max;
    }
}
