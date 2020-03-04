package Week.No178;

import java.util.*;

public class LeetCode_5347 {
    static class Node {
        int row;
        int col;
        int totalCost;
        public Node(int row, int col, int totalCost) {
            this.row = row;
            this.col = col;
            this.totalCost = totalCost;
        }
    }
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int minCost(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.addFirst(new Node(0, 0, 0));
        int[][] visited = new int[rows][cols];
        while (!deque.isEmpty()) {
            Node cur = deque.pollFirst();
            int row = cur.row;
            int col = cur.col;
            if (row == rows - 1 && col == cols - 1)
                return cur.totalCost;
            visited[row][col] = 1;
            int sign = grid[row][col] - 1;
            for (int k = 0; k < 4; ++k, sign = (sign + 1) % 4) {
                int x = row + dirs[sign][0];
                int y = col + dirs[sign][1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && visited[x][y] == 0 && k == 0)
                    deque.addFirst(new Node(x, y, cur.totalCost));
                else if (x >= 0 && x < rows && y >= 0 && y < cols && visited[x][y] == 0 && k != 0)
                    deque.addLast(new Node(x, y, cur.totalCost + 1));
            }
        }
        return  0;
    }
    public static void main(String args[]) {
        int[][] grid = {{1,1,3},{3,2,2},{1,1,4}};
        minCost(grid);
    }
}
