package com.takiya;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_407 {
    class Node {
        int x;
        int y;
        int h;
        Node (int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    int[] dirs = {-1, 0, 1, 0, -1};
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length;
        if (rows < 3)   return 0;
        int cols = heightMap[0].length;
        if (cols < 3)   return 0;
        Comparator<Node> comparator = Comparator.comparingInt(o -> o.h);
        int[][] visited = new int[rows][cols];
        PriorityQueue<Node> pq = new PriorityQueue<>(comparator);

        for (int i = 0; i < rows; ++i) {
            pq.offer(new Node(i, 0, heightMap[i][0]));
            pq.offer(new Node(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][0] = 1; visited[i][cols - 1] = 1;
        }

        for (int j = 0; j < cols; ++j) {
            pq.offer(new Node(0, j, heightMap[0][j]));
            pq.offer(new Node(rows - 1, j, heightMap[rows - 1][j]));
            visited[0][j] = 1; visited[rows - 1][j] = 1;
        }

        int res = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = 0; i < 4; ++i) {
                int x = node.x + dirs[i];
                int y = node.y + dirs[i + 1];
                if (x >=0 && x < rows && y >= 0 && y < cols && visited[x][y] != 1) {
                    res += Math.max(node.h - heightMap[x][y], 0);
                    visited[x][y] = 1;
                    pq.offer(new Node(x, y, Math.max(heightMap[x][y], node.h)));
                }
            }
        }
        return res;
    }
}
