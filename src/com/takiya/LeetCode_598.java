package com.takiya;

public class LeetCode_598 {
    public int maxCount(int m, int n, int[][] ops) {
        int max = m * n;
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
            max = Math.min(max, m * n);
        }
        return max;
    }
}
