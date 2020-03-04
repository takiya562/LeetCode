package com.takiya.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_452 {
    public static int findMinArrowShots(int[][] points) {
        int total = points.length;
        if (total == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int ans = 1;
        int low = points[0][0];
        int high = points[0][1];
        for (int i = 1; i < total; ++i) {
            int[] point = points[i];
            if (point[0] > high) {
                ans++;
                high = point[1];
            }
            else
                high = Math.min(high, point[1]);
            low = Math.max(low, point[0]);
        }
        return ans;
    }
    public static void main(String args[]) {
        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        findMinArrowShots(points);
    }
}
