package com.takiya.extra;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class HihoCoder_1478 {
    /**
     * 描述：
     * 给定一个N x M的01矩阵，其中1表示陆地，0表示水域。对于每一个位置，求出它距离最近的水域的距离是多少。
     * 矩阵中每个位置与它上下左右相邻的格子距离为1。
     *
     * 输入：
     * 第一行包含两个整数，N和M。
     * 以下N行每行M个0或者1，代表地图。
     * 数据保证至少有1块水域。
     * 对于30%的数据，1 <= N, M <= 100
     * 对于100%的数据，1 <= N, M <= 800
     *
     * 输出：
     * 输出N行，每行M个空格分隔的整数。每个整数表示该位置距离最近的水域的距离
     *
     * 样例输入
     *
     * 4 4
     * 0110
     * 1111
     * 1111
     * 0110
     * 样例输出
     *
     * 0 1 1 0
     * 1 2 2 1
     * 1 2 2 1
     * 0 1 1 0
     * @param args
     */
    public static void main(String[] args) {
        int[] dirs = {-1, 0, 1, 0, -1};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] graph = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
                if (graph[i][j] == 0) {
                    q.add(new Pair(i, j));
                    graph[i][j] = 10;
                }
            }
        }
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair cur = q.remove();
                for (int j = 0; j < 4; j++) {
                    int newX = cur.x + dirs[j];
                    int newY = cur.y + dirs[j + 1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && graph[newX][newY] < 10) {
                        q.add(new Pair(newX, newY));
                        graph[newX][newY] = 10 + level;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++)
                System.out.print(graph[i][j] - 10 + " ");
            System.out.println(graph[i][m - 1] - 10 + " ");
        }
    }
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
