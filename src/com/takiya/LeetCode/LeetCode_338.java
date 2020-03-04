package com.takiya;

public class LeetCode_338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if (num == 0) return res;
        res[1] = 1;
        if (num == 1) return res;
        int high = 2;
        int low = 1;
        for (int i = 2; i <= num; ++i) {
            if (i == high) {
                res[i] = 1;
                high <<= 1;
                low <<= 1;
            }
            else
                res[i] = res[low] + res[i- low];
        }
        return res;
    }
}
