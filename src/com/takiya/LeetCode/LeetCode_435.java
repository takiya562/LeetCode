package com.takiya;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)  return 0;
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        int[] pre = intervals[0];
        int len = 1;
        for (int i = 1; i < intervals.length; ++i) {
            int[] interval = intervals[i];
            if (interval[0] >= pre[0] && interval[0] < pre[1] && pre[1] > interval[1])
                pre = interval;
            else if (interval[0] >= pre[1]) {
                pre = interval;
                len++;
            }
        }
        return intervals.length - len;
    }
}
