package com.takiya.LeetCode;

public class LeetCode_942 {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] ans = new int[N + 1];
        int lo = 0, hi = N;
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I') {
                ans[i] = lo++;
            }else {
                ans[i] = hi--;
            }
        }
        ans[N] = lo;
        return ans;
    }
}
