package com.takiya.LeetCode;

public class LeetCode_1304 {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int r = n-1;
        for (int i = 1; i <= n/2; i++) {
            ans[i-1] = i;
            ans[r] = -i;
            r--;
        }
        if (n % 2 != 0)
            ans[r] = 0;
        return ans;
    }
}
