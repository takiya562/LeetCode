package com.takiya.LeetCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LeetCOde_391 {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)    return true;
            if (obj == null || getClass() != obj.getClass())    return false;
            Point point = (Point)obj;
            return Objects.equals(x, point.x) && Objects.equals(y, point.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public boolean isRectangleCover(int[][] rectangles) {
        Set<Point> set = new HashSet<>();
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        for (int[] rectangle : rectangles) {
            x1 = Math.min(rectangle[0], x1);
            y1 = Math.min(rectangle[1], y1);
            x2 = Math.max(rectangle[2], x2);
            y2 = Math.max(rectangle[3], y2);
            area += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);

            Point[] points = {new Point(rectangle[0], rectangle[1]),
                              new Point(rectangle[0], rectangle[3]),
                              new Point(rectangle[2], rectangle[1]),
                              new Point(rectangle[2], rectangle[3])};
            for (Point point : points) {
                if (!set.contains(point))
                    set.add(point);
                else
                    set.remove(point);
            }
        }
        if (set.size() != 4 || !set.contains(new Point(x1, y1)) || !set.contains(new Point(x1, y2)) ||
            !set.contains(new Point(x2, y1)) || !set.contains(new Point(x2, y1)))
            return false;
        return (x2 - x1) * (y2 - y1) == area;
    }
}

