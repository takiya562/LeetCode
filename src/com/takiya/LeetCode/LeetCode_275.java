package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_275 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midVal = citations[mid];
            int h = n - mid;
            if (midVal < h) {
                l = mid + 1;
            } else if (midVal > h){
                r = mid - 1;
            } else {
                return h;
            }
        }
        return n - l;
    }
    @Test
    public void test() {
        int[] citations = {0, 1, 3, 5,6};
        hIndex(citations);
    }
}
