package com.takiya.LeetCode;

import include.Tools;
import include.UnionFind;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode_1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int len = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                list.add(new Edge(i, j, len));
            }
        }
        list.sort(Comparator.comparingInt(e -> e.len));
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        for (Edge e : list) {
            if (uf.find(e.x) != uf.find(e.y)) {
                uf.union(e.x, e.y);
                cost += e.len;
            }
        }
        return cost;
    }

    @Test
    public void test() {
        Assert.assertEquals(18, minCostConnectPoints(Tools.stringToIntegerMatrix("[[3,12],[-2,5],[-4,1]]")));
        Assert.assertEquals(4, minCostConnectPoints(Tools.stringToIntegerMatrix("[[0,0],[1,1],[1,0],[-1,1]]")));
        Assert.assertEquals(4000000, minCostConnectPoints(Tools.stringToIntegerMatrix("[[-1000000,-1000000],[1000000,1000000]]")));
        Assert.assertEquals(0, minCostConnectPoints(Tools.stringToIntegerMatrix("[[0,0]]")));
    }
}

class Edge {
    int x, y, len;
    Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}

