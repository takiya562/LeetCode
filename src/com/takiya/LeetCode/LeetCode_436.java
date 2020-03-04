package com.takiya.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_436 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; ++i)
            index[i] = i;
        Arrays.sort(index, Comparator.comparingInt(i -> intervals[index[i]][0]));

        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            int L = i + 1;
            int R = len - 1;
            int min = Integer.MAX_VALUE;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (intervals[index[i]][1] <= intervals[index[mid]][0]) {
                    min = Math.min(min, index[mid]);
                    R = mid - 1;
                }
                else
                    L = mid + 1;
            }
            res[index[i]] = (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return res;
    }
}
