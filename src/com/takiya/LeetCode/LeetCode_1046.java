package com.takiya.LeetCode;

import java.util.PriorityQueue;

public class LeetCode_1046 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> (y - x));
        for (int stone : stones)
            q.offer(stone);
        while (q.size() > 1) {
            int a = q.poll() - q.poll();
            if (a != 0)
                q.offer(a);
        }
        return q.size() == 0 ? 0 : q.poll();
    }

    public static void main(String[] args) {
        int[] stones = {4,3,4,3,2};
        lastStoneWeight(stones);
    }
}
