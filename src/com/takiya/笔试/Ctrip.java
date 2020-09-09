package com.takiya.笔试;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ctrip {
    public static void solution1() {
         Scanner scanner = new Scanner(System.in);
         char[] s1 = scanner.nextLine().toCharArray();
         Arrays.sort(s1);
         char[] sentence = scanner.nextLine().toCharArray();
         String s2 = scanner.nextLine();
         StringBuilder sb = new StringBuilder();
         StringBuilder res = new StringBuilder();
         for (int r = 0; r < sentence.length; r++) {
             char cur = sentence[r];
             if ((cur >= 'a' && cur <= 'z') || (cur >= 'A' && cur <= 'Z'))
                 sb.append(cur);
             else {
                 if (helper(s1, sb.toString().toCharArray())) {
                     res.append(s2);
                 } else {
                     res.append(sb.toString());
                 }
                 res.append(cur);
                 sb = new StringBuilder();
             }
         }
         if (sb.toString().length() > 0)
             res.append(sb.toString());
        System.out.println(res.toString());
    }
    private static boolean helper(char[] c1, char[] c2) {
        if (c1.length != c2.length)
            return false;
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                return false;
        }
        return true;
    }
    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        String[] branches = scanner.nextLine().split("\\s+");
        int n = branches.length;
        backTrace(branches, 0, n, new char[n]);
    }
    private static void backTrace(String[] branches, int index, int n, char[] path) {
        if (index == n) {
            Set<Character> set = new HashSet<>();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (set.contains(path[i]))
                    flag = true;
                System.out.print(path[i]);
                set.add(path[i]);
            }
            if (flag)
                System.out.println("--circular dependency");
            else
                System.out.println();
            return;
        }
        char[] chars = branches[index].toCharArray();
        for (char c : chars) {
            path[index] = c;
            backTrace(branches, index + 1, n, path);
        }
    }
    static int min = Integer.MAX_VALUE;
    static int m;
    static int n;
    static int[] dirs = {-1, 0, 1, 0, -1};
    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        int e0 = scanner.nextInt();
        int x = scanner.nextInt();
        int l = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = scanner.nextInt();
        }
        dfs(matrix, 0, 0, e0, x, l, new boolean[m][n], 0);
        if (min == Integer.MAX_VALUE)
            System.out.println("NA");
        else
            System.out.println(min);
    }
    private static void dfs(int[][] matrix, int r, int c, int e, int x, int l, boolean[][] visited, int path) {
        if (r == m - 1 && c == n - 1) {
            min = path;
            return;
        }
        if (path >= min)
            return;
        visited[r][c] = true;
        boolean flag = false;
        for (int k = 0; k < 4; k++) {
            int i = r + dirs[k];
            int j = c + dirs[k + 1];
            if (verify(i, j) && e >= matrix[i][j]) {
                if (!flag)  flag = true;
                if (!visited[i][j])
                    dfs(matrix, i, j, e - matrix[i][j], x, l, visited, path + 1);
            }
        }
        if (!flag && x > 0)
            dfs(matrix, r, c, l, x - 1, l, visited, path);
        visited[r][c] = false;
    }
    private static boolean verify(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    public static void main(String[] args) {
        solution3();
    }
}
