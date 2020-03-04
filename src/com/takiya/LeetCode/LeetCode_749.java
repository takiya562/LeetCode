package com.takiya;

public class LeetCode_749 {
    /* 感染面积并不等于需要的防火墙的数量（例子：当一个未感染区域被4个感染区域围绕的时候） */
    static class Wall {
        int walls;
    }

    public static int containVirus(int[][] grid) {
        int ans = 0;
        while (true) {
            int wall = process(grid);
            if (wall == 0)
                break;
            ans += wall;
        }
        return ans;
    }
    public static int process(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int color = -1;
        int row = -1, col = -1;
        int maxArea = 0, wallNum = 0;
        int[][] stateArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0) {
                    Wall wall = new Wall();
                    int cnt = maxAffect(grid, color, stateArray,wall , i, j);
                    if (cnt > maxArea) {
                        maxArea = cnt;
                        wallNum = wall.walls;
                        row = i;
                        col = j;
                    }
                    color--;
                }

            }
        }
        buildWall(grid, row ,col);
        stateArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0)
                    spread(grid, stateArray, i, j);
            }
        }
        return wallNum;
    }

    public static int maxAffect(int[][] grid, int color, int[][] stateArray, Wall wall,int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        if (row < 0 || row == rows || col < 0 || col == cols)
            return 0;
        if (grid[row][col] == 0) {
            ++wall.walls;
            if (stateArray[row][col] != color) {
                stateArray[row][col] = color;
                return 1;
            }
            return 0;
        }
        if (grid[row][col] == 1 && stateArray[row][col] != color) {  //邻近感染区域且没有被搜索过
            stateArray[row][col] = color;
            int[] dir = {1, 0, -1, 0, 1};
            for (int i = 0; i < 4; i++)
                res += maxAffect(grid, color, stateArray, wall, row+dir[i], col+dir[i+1]);
        }
        return res;
    }

    public static void buildWall(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row == rows || col < 0 || col == cols)
            return;
        if (grid[row][col] == 1) {
            grid[row][col] = -1;
            int[] dir = {1, 0, -1, 0, 1};
            for (int i = 0; i < 4; i++)
                buildWall(grid, row+dir[i], col+dir[i+1]);
        }
    }

    public static void spread(int[][] grid, int[][] stateArray, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row == rows || col < 0 || col == cols)
            return;
        if (grid[row][col] == 0 && stateArray[row][col] == 0) {
            stateArray[row][col] = 1;
            grid[row][col] = 1;
        }
        else if (grid[row][col] == 1 && stateArray[row][col] == 0) {
            stateArray[row][col] = 1;
            int[] dir = {1, 0, -1, 0, 1};
            for (int i = 0; i < 4; i++)
                spread(grid, stateArray, row+dir[i], col+dir[i+1]);
        }
    }

    public static void main(String args[]) {
        int[][] grid = {{0,1,0,1,1,1,1,1,1,0},
                        {0,0,0,1,0,0,0,0,0,0},
                        {0,0,1,1,1,0,0,0,1,0},
                        {0,0,0,1,1,0,0,1,1,0},
                        {0,1,0,0,1,0,1,1,0,1},
                        {0,0,0,1,0,1,0,1,1,1},
                        {0,1,0,0,1,0,0,1,1,0},
                        {0,1,0,1,0,0,0,1,1,0},
                        {0,1,1,0,0,1,1,0,0,1},
                        {1,0,1,1,0,1,0,1,0,1}};
        System.out.print(containVirus(grid));
    }
}
