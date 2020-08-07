package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len1 = A.length;
        int len2 = numLen(K);
        int[] B = toArray(K, len2);
        int len = Math.max(len1, len2);
        int[] ans = new int[len + 1];
        int i = len1 - 1; int j = len2 - 1;
        int c = 0;
        while (i >= 0 || j >= 0) {
            int cur;
            if (i < 0) {
                cur = B[j--] + c;
            } else if (j < 0) {
                cur = A[i--] + c;
            } else {
                cur = A[i--] + B[j--] + c;
            }
            c = cur / 10;
            ans[len--] = cur % 10;
        }
        ans[len] = c;
        int index = 0;
        while (index < ans.length - 1 && ans[index] == 0) index++;
        List<Integer> list = new ArrayList<>();
        for (; index < ans.length; ++index)
            list.add(ans[index]);
        return list;
    }
    int numLen(int a) {
        if (a == 0)
            return 1;
        return (int)(Math.log10(a) + 1);
    }
    int[] toArray(int k, int len) {
        int[] res = new int[len];
        int index = len - 1;
        while (k != 0) {
            res[index--] = k % 10;
            k /= 10;
        }
        return res;
    }
}
