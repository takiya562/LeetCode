package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_995 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        if (n == 0) return 0;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; i++) {
            if (i >= K && A[i - K] >= 2) {
                revCnt ^= 1;
                A[i - K] -= 2;
            }
            if (A[i] == revCnt) {
                if (i + K > n) {
                    return -1;
                }
                ans++;
                A[i] += 2;
                revCnt ^= 1; 
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] A = Tools.stringToIntegerArray("[0,1,0]");
        Assert.assertEquals(2, minKBitFlips(A, 1));
        A = Tools.stringToIntegerArray("[1,1,0]");
        Assert.assertEquals(-1, minKBitFlips(A, 2));
        A = Tools.stringToIntegerArray("[0,0,0,1,0,1,1,0]");
        Assert.assertEquals(3, minKBitFlips(A, 3));
        A = Tools.stringToIntegerArray("[0,1,1]");
        Assert.assertEquals(-1, minKBitFlips(A, 2));
    }

}
