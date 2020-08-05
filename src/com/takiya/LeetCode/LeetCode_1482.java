package com.takiya.LeetCode;

public class LeetCode_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k)    return -1;
        int max = 0;
        for (int day : bloomDay)
            max = Math.max(max, day);
        int l = 0, r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int count = getCount(bloomDay, mid, k);
            if (count >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    int getCount(int[] bloomDay, int wait, int k) {
        int count = 0;
        int res = 0;
        for (int day : bloomDay) {
            if (day <= wait)
                count++;
            else
                count = 0;
            if (count == k) {
                res++;
                count = 0;
            }
        }
        return res;
    }
}
