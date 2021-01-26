package com.takiya.LeetCode;

import java.util.*;

import include.UnionFind;
import include.Tools;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode_1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        Integer[] indexes = new Integer[len];
        for (int i = 0; i < len; i++)
            indexes[i] = i;
        Arrays.sort(indexes, Comparator.comparingInt(i -> edges[i][2]));
        UnionFind uf = new UnionFind(n);
        int initial = 0;
        Set<Integer> initEdge = new HashSet<>();
        for (int i : indexes) {
            int[] edge = edges[i];
            int index1 = edge[0], index2 = edge[1];
            if (uf.find(index1) != uf.find(index2)) {
                uf.union(index1, index2);
                initial += edge[2];
                initEdge.add(i);
            }
        }
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            uf.clear();
            int weight = 0;
            if (!initEdge.contains(i)) {
                int[] first = edges[i];
                uf.union(first[0], first[1]);
                weight += first[2];
            }
            for (int j : indexes) {
                if (j == i) continue;
                int[] edge = edges[j];
                int index1 = edge[0], index2 = edge[1];
                if (uf.find(index1) != uf.find(index2)) {
                    uf.union(index1, index2);
                    weight += edge[2];
                }
            }
            if (weight == initial)
                pseudo.add(i);
            if (!uf.isMST() || (initEdge.contains(i) && weight > initial))
                critical.add(i);
        }
        return new ArrayList<List<Integer>>() {{
            add(critical);
            add(pseudo);
        }};
    }

    @Test
    public void test() {
        Assert.assertEquals("[[0,1],[2,3,4,5]]", Tools.ListsToString(findCriticalAndPseudoCriticalEdges(5, Tools.stringToIntegerMatrix("[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]"))));
        Assert.assertEquals("[[],[0,1,2,3]]", Tools.ListsToString(findCriticalAndPseudoCriticalEdges(4, Tools.stringToIntegerMatrix("[[0,1,1],[1,2,1],[2,3,1],[0,3,1]]"))));
        Assert.assertEquals("[[3],[0,1,2,4,5,6]]", Tools.ListsToString(findCriticalAndPseudoCriticalEdges(6, Tools.stringToIntegerMatrix("[[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]]"))));
        Assert.assertEquals("[[0,2,3,5],[1,4]]", Tools.ListsToString(findCriticalAndPseudoCriticalEdges(6, Tools.stringToIntegerMatrix("[[0,1,2],[0,2,5],[2,3,5],[1,4,4],[2,5,5],[4,5,2]]"))));
    }
}
