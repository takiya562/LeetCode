package com.takiya.LeetCode;

public class LeetCode_200 {
    private class UnionSet {
        private int[] father;
        private int count;

        public UnionSet(char[][] grid) {
            count = 0;
            int rows = grid.length;
            int cols = grid[0].length;
            father = new int[rows * cols];
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols; ++j) {
                    father[i * cols + j] = i * cols + j;
                    if (grid[i][j] == '1')
                        count++;
                }
            }
        }

        public int Find(int x) {
            while (father[x] != x)
                x = father[x];
            return x;
        }

        public void Union(int x, int y) {
            int rootX = Find(x);
            int rootY = Find(y);
            if (rootX == rootY) return;
            father[rootY] = rootX;
            count--;
        }

        public int getCount() {
            return count;
        }
    }
    int[] dirs = {-1, 0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0)  return 0;
        int cols = grid[0].length;
        UnionSet us = new UnionSet(grid);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int n = 0; n < 4; ++n) {
                        int x = i + dirs[n];
                        int y = j + dirs[n + 1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1')
                            us.Union(i * cols + j, x * cols + y);
                    }
                }
            }
        }
        return us.getCount();
    }
}
