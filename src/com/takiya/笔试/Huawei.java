package com.takiya.笔试;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Huawei {
    static class Pair {
        int id;
        int count;

        Pair(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Pair> list1 = new ArrayList<>();
        ArrayList<Pair> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = scanner.nextInt();
            int type = scanner.nextInt();
            if (type == 1)
                list1.add(new Pair(i + 1, count));
            else
                list2.add(new Pair(i + 1, count));
        }
        if (list1.size() < 3 && list2.size() < 3) {
            System.out.println("null");
            return;
        }
        list1.sort((x, y) -> {
            if (x.count == y.count)
                return x.id - y.id;
            return y.count - x.count;
        });
        list2.sort((x, y) -> {
            if (x.count == y.count)
                return x.id - y.id;
            return y.count - x.count;
        });
        int max1 = 0, max2 = 0;
        if (list1.size() >= 3) {
            for (int k = 0; k < 3; k++) {
                max1 += list1.get(k).count;
            }
        }
        if (list2.size() >= 3) {
            for (int k = 0; k < 3; k++) {
                max2 += list2.get(k).count;
            }
        }
        if (max1 > max2) {
            int[] result = {list1.get(0).id, list1.get(1).id, list1.get(2).id};
            Arrays.sort(result);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
            System.out.println(1);
            System.out.println(max1);
        } else if (max1 < max2) {
            int[] result = {list2.get(0).id, list2.get(1).id, list2.get(2).id};
            Arrays.sort(result);
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
            System.out.println(2);
            System.out.println(max2);
        } else {
            int[] result1 = {list1.get(0).id, list1.get(1).id, list1.get(2).id};
            int[] result2 = {list2.get(0).id, list2.get(1).id, list2.get(2).id};
            Arrays.sort(result1);
            Arrays.sort(result2);
            if (result1[0] < result2[0]) {
                System.out.println(result1[0] + " " + result1[1] + " " + result1[2]);
                System.out.println(1);
                System.out.println(max1);
            } else {
                System.out.println(result2[0] + " " + result2[1] + " " + result2[2]);
                System.out.println(2);
                System.out.println(max2);
            }
        }
    }

    static int m;
    static int n;
    static boolean[][] visited;
    static int[] dirs = {-1, 0, 1, 0, -1};
    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        String[] tmp = scanner.next().split(",");
        m = Integer.parseInt(tmp[0]);
        n = Integer.parseInt(tmp[1]);
        char[][] graph = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = scanner.next();
             for (int j = 0; j < n; j++) {
                 graph[i][j] = row.charAt(j);
             }
        }
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 'S' && !visited[i][j]) {
                    dfs(graph, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean verify(int i, int j) {
        return i >= 0 && i < m &&
                j >= 0 && j < n &&
                !visited[i][j];
    }

    private static void dfs(char[][] graph, int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (verify(x, y) && graph[x][y] != 'H')
                dfs(graph, x, y);
        }
    }

    static class Box {
        int w;
        int v;

        Box(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        Box[] boxes = new Box[n];
        for (int i = 0; i < n; i++) {
            boxes[i] = new Box(scanner.nextInt(), 0);
        }
        for (int i = 0; i < n; i++) {
            boxes[i].v = scanner.nextInt();
        }
        Arrays.sort(boxes, (x, y) -> {
            double rate1 = x.v / (double)x.w;
            double rate2 = y.v / (double)y.w;
            if (rate1 == rate2)
                return y.w - x.w;
            else if (rate1 < rate2)
                return 1;
            else
                return -1;
        });
        int max = 0;

        System.out.println(max);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        int n = s1.length();
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            counts[index]++;
        }
        int l = 0;
        int[] window = new int[26];
        for (int r = 0; r < s2.length(); r++) {
            int index =  s2.charAt(r) - 'a';
            window[index]++;
            if (r - l + 1 == n) {
                if(verify(counts, window))
                    return true;
                window[s2.charAt(l++) - 'a']--;
            }
        }
        return false;
    }

    private static boolean verify(int[] counts, int[] window) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != window[i])
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
        boolean b = checkInclusion("ab", "ebibaool");
        System.out.println(b);
    }
}
