package com.takiya.LeetCode;

public class LeetCode_995 {
    public static int minKBitFlips(int[] A, int K) {
        int[] hint = new int[A.length];
        int flip = 0;
        int ans = 0;
        for (int i = 0; i < A.length; ++i) {
            flip ^= hint[i + K];
            if (A[i] == flip) {
                ans++;
                if (i + K > A.length) return -1;
                flip ^= 1;
                if (i + K < A.length)   hint[i + K] ^= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {0,0,1};
        minKBitFlips(A, 2);
    }
}
