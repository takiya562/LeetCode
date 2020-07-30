package com.takiya.LeetCode;

public class LeetCode_718 {
    public int findLength(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    private int findMax(int[] A, int[] B) {
        int an = A.length;
        int bn = B.length;
        int max = 0;
        for (int len = 1; len <= an; ++len)
            max = Math.max(max, maxLen(A, B, 0, bn - len, len));
        for (int j = bn - an; j >= 0; --j)
            max = Math.max(max, maxLen(A, B, 0, j, an));
        for (int i = 1; i < an; ++i)
            max = Math.max(max, maxLen(A, B, i, 0, an - i));
        return max;

    }

    private int maxLen(int[] A, int[] B, int i, int j, int len) {
        int max = 0;
        int count = 0;
        for (int k = 0; k < len; ++k) {
            if (A[i + k] == B[j + k])
                count++;
            else {
                if (count > 0)
                    max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(count, max);

    }
}
