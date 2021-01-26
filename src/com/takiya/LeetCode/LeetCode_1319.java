package com.takiya.LeetCode;

import include.Tools;
import include.UnionFind;
import org.junit.Assert;
import org.junit.Test;

public class LeetCode_1319 {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if (edges < n - 1)  return -1;
        if (n == 0) return 0;
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            int index1 = connection[0], index2 = connection[1];
            if (uf.find(index1) != uf.find(index2))
                uf.union(index1, index2);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i)
                result++;
        }
        return result - 1;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, makeConnected(4, Tools.stringToIntegerMatrix("[[0,1],[0,2],[1,2]]")));
        Assert.assertEquals(2, makeConnected(6, Tools.stringToIntegerMatrix("[[0,1],[0,2],[0,3],[1,2],[1,3]]")));
        Assert.assertEquals(-1, makeConnected(6, Tools.stringToIntegerMatrix("[[0,1],[0,2],[0,3],[1,2]]")));
        Assert.assertEquals(0, makeConnected(5, Tools.stringToIntegerMatrix("[[0,1],[0,2],[3,4],[2,3]]")));
    }
}
