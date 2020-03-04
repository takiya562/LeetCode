package com.takiya.LeetCode;

public class LeetCode_1004 {
    public static int longestOnes(int[] A, int K) {
        int L = 0;
        int R = 0;
        int max = 0;
        while (R < A.length) {
            if (A[R] == 1)  R++;
            else {
                if (K > 0) {
                    R++;
                    K--;
                }
                else {
                    max = Math.max(max, R - L);
                    while (L < R && A[L] == 1)   L++;
                    if (A[L] == 0) {
                        L++;
                        K++;
                    }
                }
            }
        }
        return Math.max(max, R - L);
    }
    public static void main(String args[]) {
        int[] A = {1,0,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,1};
        int res = longestOnes(A, 9);
        System.out.println(res);
    }
}
