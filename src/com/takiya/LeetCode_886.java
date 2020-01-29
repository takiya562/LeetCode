package com.takiya;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LeetCode_886 {
    static LinkedList<Integer>[] graph;
    static Map<Integer, Integer> color;
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new LinkedList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new LinkedList<>();

        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap<>();
        for (int node = 1; node <= N; ++node) {
            if (!color.containsKey(node) && !dfs(node, 0))
                return false;
        }
        return true;
    }

    public static boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);
        for (int neighbour : graph[node]) {
            if (!dfs(neighbour, c ^ 1))
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        possibleBipartition(4, dislikes);
    }
}
