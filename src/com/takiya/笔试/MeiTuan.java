package com.takiya.笔试;

import org.junit.Test;

import java.util.*;

public class MeiTuan {
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        List<String> pairs = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            int reserve = i * 4;
            if (helper(i, reserve)) {
                count++;
                pairs.add(i + " " + reserve);
            }
        }
        System.out.println(count);
        for (String s : pairs)
            System.out.println(s);
    }
    private static boolean helper(int i, int reserve) {
        String s1 = String.valueOf(reserve);
        String s2 = String.valueOf(i);
        int len1 = s1.length();
        int len2 = s2.length();
        for (int j = 0; j < len2; ++j) {
            if (s1.charAt(j) != s2.charAt(len2 - j - 1))
                return false;
        }
        for (int j = len2; j < len1; ++j) {
            if (s1.charAt(j) != '0')
                return false;
        }
        return true;
    }
    static class Pair {
        String start;
        String end;

        Pair(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Pair> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            String start = scanner.next();
            String end = scanner.next();
            if (start.equals(end)) {
                count++;
                continue;
            }
            if (stack.isEmpty())
                stack.push(new Pair(start, end));
            else {
                Pair pair = stack.pop();
                if (pair.start.equals(end))
                    count++;
                else
                    stack.push(new Pair(pair.start, end));
            }
        }
        System.out.println(count);
    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; ++i)
            graph[i] = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == b)
                continue;
            graph[a].add(b);
            graph[b].add(a);
        }
        List<List<Integer>> lists = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            if (set.contains(i))
                continue;
            List<Integer> list = new ArrayList<>();
            q.add(i);
            set.add(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                list.add(cur);
                for (int nei : graph[cur]) {
                    if (!set.contains(nei)) {
                        q.add(nei);
                        set.add(nei);
                    }
                }
            }
            lists.add(list);
        }
        System.out.println(lists.size());
        lists.stream().forEach(x -> {
            int size = x.size();
            for (int i = 0; i < size - 1; ++i)
                System.out.print(x.get(i) + " ");
            System.out.println(x.get(size - 1));
        });
    }
    static class Pair0 {
        int a;
        int b;
        Pair0(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void solution4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Pair0[] pairs = new Pair0[n];
        for (int i = 0; i < n; ++i) {
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            pairs[i] = new Pair0(m, k);
        }
        Arrays.sort(pairs, Comparator.comparingInt(x -> Math.abs(x.a - x.b)));
        for (Pair0 pair : pairs) {

        }
    }

    public static void solution5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            count += recursion(i, n, 1, m);
        }
        System.out.println(count);
    }
    private static int recursion(int pre, int n, int index, int m) {
        if (index == m)
           return 1;
        int count = 0;
        for (int i = pre; i <= n; i = i + pre) {
            count += recursion(i, n, index + 1, m);
        }
        return count;
    }

    public static void main(String[] args) {
        solution3();
    }

    @Test
    public void test() {
        boolean helper = helper(11, 1100);
        System.out.print(helper);
    }
}
