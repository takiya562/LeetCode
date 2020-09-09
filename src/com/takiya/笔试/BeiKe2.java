package com.takiya.笔试;

import java.util.*;

public class BeiKe2 {
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        char[] c1 = new char[2];
        char[] c2 = new char[2];
        while (t-- != 0) {
            for (int i = 0; i < 2; i++)
                c1[i] = scanner.next().charAt(0);
            for (int i = 0; i < 2; i++)
                c2[i] = scanner.next().charAt(0);
            int left = 0, right = 0;
            char cur = c1[0];
            for (int j = 0; j < 2; j++) {
                if (helper(cur, c2[j]))
                    left++;
            }
            cur = c1[1];
            for (int j = 0; j < 2; j++) {
                if (helper(cur, c2[j]))
                    right++;
            }
            if (left > right)
                System.out.println("left");
            else if (left < right)
                System.out.println("right");
            else
                System.out.println("same");
        }
    }
    private static boolean helper(char c1, char c2) {
        if ((c1 == 'J' && c2 == 'B')|| (c1 == 'S' && c2 == 'J') || (c1 == 'B' && c2 == 'S')) {
            return true;
        }
        return false;
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        HashMap<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = counts.getOrDefault(c, 0);
            counts.put(c, count + 1);
        }
        boolean flag = false;
        int res = 0;
        for (int value : counts.values()) {
            if (value == 1)
                res++;
            else if (value % 2 == 0) {
                res += value / 2;
                if (!flag)
                    flag = true;
            } else {
                res += value - value / 2;
                if (!flag)
                    flag = true;
            }
        }
        if (flag)
            res++;
        System.out.println(res);
    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- != 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            Set<Integer>[] sets = new Set[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {

                }
            }
        }
    }

    public static void solution4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[2 * n];
        int[] b = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            a[i] = scanner.nextInt();
        for (int i = 0; i < 2 * n; i++)
            b[i] = scanner.nextInt();
        int[] profit = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            profit[i] = a[i] - b[i];
        }
        int l = 0, r = 2 * n - 1;
        long health = 1;
        while (l <= n - 1 || r >= n) {
            if (l >= n) {
                health += profit[r];
                health = Math.max(health, a[r--] + 1);
            }else if (r < n) {
                health += profit[l];
                health = Math.max(health, a[l++] + 1);
            } else {
                if (profit[l] >= profit[r]) {
                    health += profit[l];
                    health = Math.max(health, a[l++] + 1);
                } else {
                    health += profit[r];
                    health = Math.max(health, a[r--] + 1);
                }
            }
        }
        System.out.println(health);
    }
    public static void main(String[] args) {
        solution3();
    }
}
