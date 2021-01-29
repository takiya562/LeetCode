package com.takiya.LeetCode;

import include.UnionFind;
import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_1579 {
	public int maxNumEdgesToRemove(int n, int[][] edges) {
		if (n == 0)
			return 0;
		int len = edges.length;
		if (len < n - 1)
			return -1;
		UnionFind uf1 = new UnionFind(n);
		UnionFind uf2 = new UnionFind(n);
		int count = 0;
		for (int[] edge : edges) {
			if (edge[0] == 3) {
				if (uf1.find(edge[1] - 1) != uf1.find(edge[2] - 1)) {
					uf1.union(edge[1] - 1, edge[2] - 1);
					uf2.union(edge[1] - 1, edge[2] - 1);
				} else {
					count++;
				}
			}
		}
		for (int[] edge : edges) {
			if (edge[0] == 2) {
				if (uf2.find(edge[1] - 1) != uf2.find(edge[2] - 1)) {
					uf2.union(edge[1] - 1, edge[2] - 1);
				} else {
					count++;
				}
			}
		}
		for (int[] edge : edges) {
			if (edge[0] == 1) {
				if (uf1.find(edge[1] - 1) != uf1.find(edge[2] - 1)) {
					uf1.union(edge[1] - 1, edge[2] - 1);
				} else {
					count++;
				}
			}
		}
		return uf1.isMST() && uf2.isMST() ? count : -1;
    }
    @Test
    public void test() {
    	Assert.assertEquals(2, maxNumEdgesToRemove(4, Tools.stringToIntegerMatrix("[[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]")));
    	Assert.assertEquals(0, maxNumEdgesToRemove(4, Tools.stringToIntegerMatrix("[[3,1,2],[3,2,3],[1,1,4],[2,1,4]]")));
    	Assert.assertEquals(-1, maxNumEdgesToRemove(4, Tools.stringToIntegerMatrix("[[3,2,3],[1,1,2],[2,3,4]]")));
    	Assert.assertEquals(2, maxNumEdgesToRemove(2, Tools.stringToIntegerMatrix("[[1,1,2],[2,1,2],[3,1,2]]")));
    }
}