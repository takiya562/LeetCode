package com.takiya;

public class LeetCode_375 {
    public int calculate(int low, int high) {
        if (low >= high)    return 0;
        int min = Integer.MAX_VALUE;
        for (int i = (low + high) / 2; i <= high; ++i) {
            int res = i + Math.max(calculate(low, i - 1), calculate(i + 1, high));
            min = Math.min(min, res);
        }
        return min;
    }
    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }
}
