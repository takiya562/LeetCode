package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0])   return x[1] - y[1];
            return x[0] - y[0];
        });
        int count = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                intervals[i][0] = intervals[i - 1][0];
                intervals[i - 1] = null;
                count++;
            }
        }
        int[][] res = new int[intervals.length - count][2];
        int index = 0;
        for (int[] interval : intervals) {
            if (interval != null)
                res[index++] = interval;
        }
        return res;
    }
    @Test
    public void test() {
        int[][] intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] res = merge(intervals);
        Arrays.stream(res).forEach(x -> {
            System.out.println("[" + x[0] + "," + x[1] + "]");
        });
    }
}
