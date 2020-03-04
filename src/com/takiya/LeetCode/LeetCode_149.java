package com.takiya.LeetCode;

import java.util.HashMap;

public class LeetCode_149 {
    public static int maxPoints(int[][] points) {
        if (points.length < 3)
            return points.length;
        int count = 1;
        int max = 0;
        String line;
        boolean flag;
        boolean same;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            count = 1;
            int x1 = points[i][0], y1 = points[i][1];
            flag = true;
            for (int j = i+1; j < points.length; j++) {
                same = false;
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    count++;
                    same = true;
                }
                double k = getK(x1, y1, x2, y2);
                double b = getB(x1, y1, k);
                if (k == Double.POSITIVE_INFINITY && b == Double.POSITIVE_INFINITY)
                    line = String.valueOf(x1);
                else
                    line = k + "@" + b;
                int tempMax = 0;
                if (map.containsKey(line)) {
                    if (flag) {
                        if (same)
                            tempMax = map.get(line) + 1;
                        else {
                            tempMax = map.get(line) + count;
                            map.put(line, tempMax);
                            flag = false;
                        }
                    }
                }
                else {
                    tempMax = count + 1;
                    map.put(line, count+1);
                    flag = false;
                }
                max = Math.max(tempMax, max);
                if (!same)
                    count = 1;
            }
        }
        return max;
    }
    public static double getK(int x1, int y1, int x2, int y2) {
        if (x1 == x2)
            return Double.POSITIVE_INFINITY;
        if (y1 == y2)
            return 0;
        return (double)(y1 - y2)/(x1 - x2);
    }
    public static double getB(int x1, int y1, double k) {
        if (k == Double.POSITIVE_INFINITY)
            return Double.POSITIVE_INFINITY;
        return y1-k*x1;
    }
    public static void main(String args[]) {
        int[][] points = {{0,0},{1,1},{0,0}};
        int result = maxPoints(points);
        System.out.println(result);
    }
}
