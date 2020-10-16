package com.takiya.LeetCode;

public class squares_of_a_sorted_array {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        if (n == 0) return new int[] {};
        int[] res = new int[n];
        int positive = 0;
        while (positive < n && A[positive] < 0)    positive++;
        int negative = positive - 1;
        int index = 0;
        while (positive < n || negative >= 0) {
            if (positive >= n) {
                res[index++] = A[negative] * A[negative--];
            } else if (negative < 0) {
                res[index++] = A[positive] * A[positive++];
            } else {
                if (-A[negative] > A[positive]) {
                    res[index++] = A[positive] * A[positive++];
                } else {
                    res[index++] = A[negative] * A[negative--];
                }
            }
        }
        return res;
    }
}
