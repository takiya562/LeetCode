package com.takiya.Offer;

public class Offer_66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0)   return new int[] {};
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        prefix[0] = a[0];
        suffix[len - 1] = a[len - 1];
        for (int i = 1, j = len - 2; i < a.length; ++i, --j) {
            prefix[i] =  prefix[i - 1] * a[i];
            suffix[j] = suffix[j + 1] * a[j];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; ++i) {
            if (i == 0)
                ans[i] = suffix[i + 1];
            else if (i == len - 1)
                ans[i] = prefix[i - 1];
            else
                ans[i] = suffix[i + 1] * prefix[i - 1];
        }
        return ans;
    }
}
