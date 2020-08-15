package com.takiya.LeetCode;

public class LeetCode_50 {
    public double myPow(double x, int n) {
        if (x == 1.0)
            return x;
        if (n == 0)
            return 1d;
        boolean negative = n < 0;
        double res = quickPow(x, Math.abs(n));
        return negative ? 1 / res : res;
    }
    private double quickPow(double x, int n) {
        double A = 1.0;
        double T = x;
        while (n != 0) {
            if ((n & 1) == 1)
                A *= T;
            T *= T;
            n >>>= 1;
        }
        return A;
    }
}
