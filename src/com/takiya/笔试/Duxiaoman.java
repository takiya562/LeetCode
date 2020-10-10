package com.takiya.笔试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Duxiaoman {
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long round = (1 + 3 * n) * 3 * n / 2;
        System.out.println(m * round);
    }
    static class Node {
        int row;
        int col;
        int time;

        Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int n;
    static int k;
    static int[] dirs = {-1, 0, 1, 0, -1};
    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        char[][] graph = new char[n][n];
        for (int i = 0; i < n; i++)
            graph[i] = scanner.nextLine().toCharArray();
        int[][] min = new int[n][n];
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        q.add(new Node(0, 0, 0));
        for (int i = 0; i < n; i++)
            Arrays.fill(min[i], Integer.MAX_VALUE);
        min[0][0] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.row == n - 1 && node.col == n - 1) {
                System.out.println(node.time);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int r = node.row + dirs[i];
                int c = node.col + dirs[i + 1];
                if (verify(r, c) && graph[r][c] != '1') {
                    if (graph[r][c] == '0' && node.time + 1 < min[r][c]) {
                        min[r][c] = node.time + 1;
                        q.add(new Node(r, c, min[r][c]));
                    }
                    if (graph[r][c] == '#' && node.time + k + 1 < min[r][c]) {
                        min[r][c] = node.time + 1 + k;
                        q.add(new Node(r, c, min[r][c]));
                    }
                }
            }
        }
        System.out.println("No solution");
    }


    private static boolean verify(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        solution2();
    }
}
