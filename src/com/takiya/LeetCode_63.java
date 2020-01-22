package com.takiya;

public class LeetCode_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = 0, j = 0;
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1)
            return 0;
        for (; i < obstacleGrid.length; i++) {
            for (j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    if (i == 0 && j < obstacleGrid[0].length-1)
                        obstacleGrid[i][j+1] = 1;
                    else if (j == 0 && i < obstacleGrid.length-1)
                        obstacleGrid[i+1][j] = 1;
                    obstacleGrid[i][j] = 0;
                }
                else {
                    if (i == 0 || j == 0)
                        obstacleGrid[i][j] = 1;
                    else
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[i-1][j-1];
    }
    public static void main(String args[]) {
        int[][] obstacleGrid = new int[2][2];
        obstacleGrid[1][0] = 1;
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
