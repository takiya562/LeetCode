package com.takiya.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_924 {
    public class UnionSet {
        private int[] father;
        private int[] weights;

        UnionSet(int size) {
            father = new int[size];
            weights = new int[size];
            for (int i = 0; i < size; ++i) {
                father[i] = -1;
                weights[i] = 1;
            }
        }

        public int find(int x) {
            while (father[x] >= 0)
                x = father[x];
            return x;
        }

        public void union(int x, int y) {
            if (x == y) return;
            if (weights[x] > weights[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            weights[y] += weights[x];
            father[x] = y;
        }

        public int getWeight(int x) {
            return weights[x];
        }
    }
    public int minMalwareSpread(int[][] graph, int[] initial) {
        Arrays.sort(initial);
        UnionSet us = new UnionSet(graph.length);
        for (int i = 0; i < graph.length; ++i)
            for (int j = i + 1; j < graph[0].length; ++j)
                if (graph[i][j] != 0) {
                    int rootX = us.find(i); int rootY = us.find(j);
                    us.union(rootX, rootY);
                }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index :initial) {
            int root = us.find(index);
            if (map.containsKey(root))
                map.put(root, -1);
            else
                map.put(root, index);
        }
        int max = -1, res = initial[0];
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int root = entry.getKey();
            int index = entry.getValue();
            if (index == -1)
                continue;
            int count = us.getWeight(root);
            if (count > max || (count == max && index < res)) {
                res = index;
                max = count;
            }
        }
        return res;
    }
}
