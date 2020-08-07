package com.takiya.面试金典;

public class MaxMatrix {
    public static int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int sum;
        int max = Integer.MIN_VALUE;
        int[] ans = new int[4];
        int[] dp;
        int x1 = 0, y1 = 0;
        for (int i = 0; i < rows; ++i) {
            dp = new int[cols];
            for (int j = i; j < rows; ++j) {
                sum = 0;
                for (int n = 0; n < cols; ++n) {
                    dp[n] += matrix[j][n];
                    if (sum > 0)
                        sum += dp[n];
                    else {
                        sum = dp[n];
                        x1 = i;
                        y1 = n;
                    }
                    if (sum > max) {
                        max = sum;
                        ans[0] = x1;
                        ans[1] = y1;
                        ans[2] = j;
                        ans[3] = n;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}};
        getMaxMatrix(matrix);
    }
}
