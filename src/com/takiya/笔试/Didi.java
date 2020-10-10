package com.takiya.笔试;

import java.util.*;

public class Didi {
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[] s = scanner.nextLine().toCharArray();
        for (int i = 0; i < s.length; i = i + n) {
            reserve(s, i, i + n - 1);
        }
        System.out.println(new String(s));
    }
    private static void reserve(char[] s, int i, int j) {
        if (i >= j) return;
        if (j >= s.length)  j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
    }
    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            if (n == 0) {
                System.out.println("No");
                return;
            }
            if (m < n - 1) {
                System.out.println("No");
                return;
            }
            List<Integer>[] graph = new List[m + 1];
            for (int i = 1; i <= m; i++)
                graph[i] = new ArrayList<>();
            while (m-- != 0) {
                int n1 = scanner.nextInt();
                int n2 = scanner.nextInt();
                int weight = scanner.nextInt();
                if (weight <= k) {
                    graph[n1].add(n2);
                    graph[n2].add(n1);
                }
            }
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(1);
            Set<Integer> set = new HashSet<>();
            set.add(1);
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int nei : graph[node]) {
                    if (!set.contains(nei)) {
                        q.add(nei);
                        set.add(nei);
                    }
                }
            }
            if (set.size() == graph.length - 1)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
    public static void main(String[] args) {
        solution2();
    }
}
