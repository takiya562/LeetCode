package com.takiya.LeetCode;

public class LeetCode_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];

        dp[rows -1][cols - 1] = (1 - dungeon[rows - 1][cols - 1] > 0) ? 1 - dungeon[rows - 1][cols - 1] : 1;
        for (int i = rows - 2; i >= 0; --i)
            dp[i][cols - 1] = (dp[i + 1][cols - 1] - dungeon[i][cols - 1] > 0) ? dp[i + 1][cols - 1] - dungeon[i][cols - 1] : 1;
        for (int i = cols - 2; i >= 0; --i)
            dp[rows - 1][i] = (dp[rows - 1][i + 1] - dungeon[rows - 1][i] > 0) ? dp[rows - 1][i + 1] - dungeon[rows - 1][i] : 1;

        for (int i = rows -2; i >= 0; --i) {
            for (int j = cols - 2; j >= 0; --j) {
                int r2l = (dp[i][j + 1] - dungeon[i][j] > 0) ? dp[i][j + 1] - dungeon[i][j] : 1;
                int d2u = (dp[i + 1][j] - dungeon[i][j] > 0) ? dp[i + 1][j] - dungeon[i][j] : 1;
                dp[i][j] = Math.min(r2l, d2u);
            }
        }
        return dp[0][0];
    }
}
