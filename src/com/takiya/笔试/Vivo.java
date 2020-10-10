package com.takiya.笔试;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Vivo {
    static int min = -1;
    static int n;
    static int iEnd;
    static int jEnd;
    static int[] dirs = {-1, 0, 1, 0, -1};
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int iStart = scanner.nextInt();
        int jStart = scanner.nextInt();
        iEnd = scanner.nextInt();
        jEnd = scanner.nextInt();
        char[][] graph = new char[n][n];
        for (int i = 0; i < n; i++) {
            graph[i] = scanner.next().toCharArray();
        }
        dfs(graph, iStart, jStart, 0, new boolean[n][n]);
        System.out.println(min);
    }

    private static void dfs(char[][] graph, int i, int j, int path, boolean[][] visited) {
        if (i == iEnd && j == jEnd) {
            if (min == -1)
                min = path;
            else
                min = Math.min(path, min);
            return;
        }
        if (min != -1 && path >= min)
            return;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int r = i + dirs[k];
            int c = j + dirs[k + 1];
            if (verify(r, c) && !visited[r][c] && graph[r][c] != '#' && graph[r][c] != '@' && graph[r][c] != '0')
                dfs(graph, r, c, path + 1, visited);
        }
        visited[i][j] = false;
    }

    private static boolean verify(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = s.length();
        if (n == 1) {
            System.out.println("");
            return;
        }
        if (n == 2) {
            System.out.println(s.charAt(1));
            return;
        }
        int i = 0, j = n - 1;
        int remove = -1;
        boolean flag = false;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 == c2) {
                i++;
                j--;
            } else {
                if (flag)
                    System.out.println("false");
                if (c2 == s.charAt(i + 1)) {
                    remove = i;
                    flag = true;
                    i++;
                } else if (c1 == s.charAt(j - 1)) {
                    remove = j;
                    flag = true;
                    j--;
                } else {
                    System.out.println("false");
                    return;
                }
            }
        }
        String res = "";
        if (remove == -1) {
            if (n % 2 == 0) {
                System.out.println("false");
                return;
            } else {
                res = s.substring(0, n / 2) + s.substring(n / 2 + 1, n);
            }
        } else {
            res = s.substring(0, remove) + s.substring(remove + 1, n);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        solution2();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 编译顺序
     * @param input string字符串
     * @return string字符串
     */
    public String compileSeq (String input) {
        // write code here
        String[] splits = input.split(",");
        int n = splits.length;
        int[] depends = new int[n];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int depended = Integer.parseInt(splits[i]);
            if (depended == -1)
                q.add(depended);
            else
                depends[depended] = i;
        }
        StringBuilder sb = new StringBuilder();
        int pre = n;
        if (q.isEmpty())
            return null;
        else
            pre = q.poll();
        sb.append(pre).append(",");
        int count = 1;
        while (count != n) {
            int next = depends[pre];
            while (!q.isEmpty() && q.peek() < next) {
                sb.append(q.poll()).append(",");
                count++;
            }
            sb.append(next).append(",");
            pre = next;
        }
        String res = sb.toString();
        res = res.substring(0, res.length() - 1);
        return res;
    }
}
