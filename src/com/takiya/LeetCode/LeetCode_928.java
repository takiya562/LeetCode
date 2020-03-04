package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_928 {
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
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            weights[rootY] += weights[rootX];
            father[rootX] = rootY;
        }

        public int getWeight(int x) {
            return weights[x];
        }
    }
    public int minMalwareSpread(int[][] graph, int[] initial) {
        HashSet<Integer> set = new HashSet<>();
        for (int index : initial)
            set.add(index);
        UnionSet us = new UnionSet(graph.length);
        for (int i = 0; i < graph.length; ++i) {
            if (set.contains(i))
                continue;
            for (int j = 0; j < graph[0].length; ++j) {
                if (set.contains(j))
                    continue;
                if (graph[i][j] != 0) {
                    int rootX = us.find(i); int rootY = us.find(j);
                    us.union(rootX, rootY);
                }
            }
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int[] count = new int[graph.length];
        for (int index : initial) {
            HashSet<Integer> component = new HashSet<>();
            for (int j = 0; j < graph.length; ++j) {
                if (!set.contains(j) && graph[index][j] == 1)
                    component.add(us.find(j));
            }
            map.put(index, component);
            for (int c : component)
                count[c]++;
        }
        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int index : initial) {
            HashSet<Integer> component = map.get(index);
            int profit = 0;
            for (int c : component) {
                if (count[c] == 1)
                    profit += us.getWeight(c);
            }
            if (profit > max || (profit == max && res > index)) {
                max = profit;
                res = index;
            }
        }
        return res;
    }
}
