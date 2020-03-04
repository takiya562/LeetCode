package com.takiya.LeetCode;

public class LeetCode_463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    if (i == 0 || grid[i-1][j] == 0)
                        ans++;
                    if (j == 0 || grid[i][j-1] == 0)
                        ans++;
                }
            }
        }
        return ans*2;
    }
}
