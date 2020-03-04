package com.takiya.LeetCode;

public class LeetCode_396 {
    public int maxRotateFunction(int[] A) {
        long sum = 0;
        long temp = 0;
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            sum += A[i];
            temp += i * A[i];
        }
        long res = temp;
        for (int i = 1; i < len; ++i) {
            temp = temp + sum - len * A[len - i];
            res = Math.max(res, temp);
        }
        return (int)res;
    }
}
