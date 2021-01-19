package com.takiya.LeetCode;

import java.util.PriorityQueue;

public class k_closest_points_to_origin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (x, y) -> x[0] * x[0] + x[1] * x[1] - y[0] * y[0] - y[1] * y[1]
        );
        for (int[] point : points) {
            queue.add(point);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++)
            res[i] = queue.poll();
        return res;
    }
}
