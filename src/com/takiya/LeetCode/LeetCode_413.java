package com.takiya;

public class LeetCode_413 {
    int sum = 0;
    public int numberOfArithmeticSlices_1(int[] A) {
        int len = A.length;
        if (len < 3) return 0;
        int ans = 0;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp[i] = dp[i-1] + 1;                //dp[i]表示第i个数处新增的等差数列数量
                ans += dp[i];
            }
        }
        return ans;
    }
    /* 递归方法 */
    public int numberOfArithmeticSlices_2(int[] A) {
        recursion(A, A.length-1);
        return sum;
    }
    public int recursion(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
            ap = 1 + recursion(A, i-1);
            sum += ap;
        }else
            recursion(A, i-1);
        return ap;
    }
    /* 动态规划空间压缩 */
    public int numberOfArithmeticSlices_3(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                dp = 1 + dp;
                sum += dp;
            }else
                dp = 0;
        }
        return sum;
    }
}
