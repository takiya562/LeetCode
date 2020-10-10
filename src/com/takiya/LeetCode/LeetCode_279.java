package com.takiya.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_279 {
    public int numSquares(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = (int)Math.sqrt(cur); j >= 1; j--) {
                    int tmp = j * j;
                    if (cur - tmp == 0)
                        return level;
                    else
                        queue.add(cur - tmp);
                }
            }
        }
        return 0;
    }
}
