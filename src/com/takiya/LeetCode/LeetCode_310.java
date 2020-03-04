package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if (n == 0) return minHeightTrees;
        if (n == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }
        int[] degrees = new int[n];
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adjacencyList.add(new ArrayList<>());
        int first, second;
        for (int i = 0; i < edges.length; ++i) {
            first = edges[i][0];
            second = edges[i][1];
            degrees[first]++;
            degrees[second]++;
            adjacencyList.get(first).add(second);
            adjacencyList.get(second).add(first);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degrees[i] == 1)
                queue.add(i);
        }
        List<Integer> nextNodes;
        int curNode, size;
        while (!queue.isEmpty()) {
            size = queue.size();
            minHeightTrees.clear();
            for (int i = 0; i < size; ++i) {
                curNode = queue.poll();
                minHeightTrees.add(curNode);
                nextNodes = adjacencyList.get(curNode);
                for (int nextNode : nextNodes) {
                    degrees[nextNode]--;
                    if (degrees[nextNode] == 1)
                        queue.add(nextNode);
                }
            }
        }
        return minHeightTrees;
    }
}
