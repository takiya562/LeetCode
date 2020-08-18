package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] != 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m -  1][n - 1];
    }
    @Test
    public void test() {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }
}
