package com.takiya.LeetCode;

import org.junit.*;
import include.UnionFind;
import include.Tools;

public class LeetCode_959 {
	public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int[][] graph = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '/') {
                    graph[i * 3 + 2][j * 3] = graph[i * 3 + 1][j * 3 + 1] = graph[i * 3][j * 3 + 2] = 1;
                } else if (chars[j] == '\\') {
                    graph[i * 3][j * 3] = graph[i * 3 + 1][j * 3 + 1] = graph[i * 3 + 2][j * 3 + 2] = 1; 
                }
            } 
        }
        int result = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0) {
                    dfs(graph, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] graph, int i, int j) {
        if (i >= 0 && i < graph.length && j >= 0 && j < graph[0].length && graph[i][j] == 0) {
            graph[i][j] = 1;
            dfs(graph, i + 1, j);
            dfs(graph, i, j + 1);
            dfs(graph, i - 1, j);
            dfs(graph, i, j - 1);
        }
    }
    @Test
    public void test() {
    	Assert.assertEquals(2, regionsBySlashes(Tools.stringToStringArray("[\" /\",\"/ \"]")));
        Assert.assertEquals(1, regionsBySlashes(Tools.stringToStringArray("[\" /\",\"  \"]")));
        Assert.assertEquals(4, regionsBySlashes(Tools.stringToStringArray("[\"\\/\",\"/\\\"]")));
        Assert.assertEquals(5, regionsBySlashes(Tools.stringToStringArray("[\"/\\\",\"\\/\"]")));
    }
}	