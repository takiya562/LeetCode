package com.takiya.LeetCode;

import java.util.Arrays;

public class LeetCode_962 {
    public int maxWidthRamp_1(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = A.length - 1; j - i > max; --j) {
                if (A[j] >= A[i])
                    max = j - i;
            }
        }
        return max;
    }
    public int maxWidthRamp_2(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;
        Arrays.sort(B, (i, j) -> ((Integer)A[i]).compareTo(A[j]));

        int ans = 0;
        int min = N;    //小于 A[j] 的最左边的 index
        for (int j : B) {
            ans = Math.max(ans, j - min);
            min = Math.min(min, j);
        }
        return ans;
    }
}
