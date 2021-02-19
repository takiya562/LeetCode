package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_1004 {
    public int longestOnes(int[] A, int K) {
        int n = A.length;
        if (n == 0) return 0;
        int cnt = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            int num = A[r];
            if (num == 0) {
                cnt++;
            }
            if (cnt > K) {
                num = A[l++];
                if (num == 0) {
                    cnt--;
                }
            }
        }
        return n - l;
    }

    @Test
    public void test() {
        int[] A = Tools.stringToIntegerArray("[1,1,1,0,0,0,1,1,1,1,0]");
        Assert.assertEquals(6, longestOnes(A, 2));
        A = Tools.stringToIntegerArray("[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]");
        Assert.assertEquals(10, longestOnes(A, 3));
    }
}
