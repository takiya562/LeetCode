package com.takiya.笔试;


import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tecent2 {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        p = dummy;
        if (n >= k) {
            for (int i = 0; i < k - 1; i++) {
                p = p.next;
            }
            p.next = p.next.next;
        }
        p = dummy.next;
        while (p.next != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println(p.val + " ");
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int k = scanner.nextInt();
        PriorityQueue<String> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (q.size() < k) {
                    q.add(s.substring(i, i + j + 1));
                } else {
                    String res = q.peek();
                    if (j >= res.length() || s.charAt(i + j) > res.charAt(j))
                        break;
                    else if (s.charAt(i + j) < res.charAt(j)) {
                        q.poll();
                        q.add(s.substring(i, i + j + 1));
                    }
                }
            }
        }
        System.out.println(q.peek());
    }
    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int max = 0;
            long n = scanner.nextLong();
            for (long j = 0; j < n / 2; j++) {
                max = Math.max(helper3(j) + helper3(n - j), max);
            }
            System.out.println(max);
        }
    }

    private static int helper3(long n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public void solution4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = 0;
        int extra = 0;
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = scanner.nextInt();
            max = Math.max(cur, max);
            if (pre < cur)
                extra += Math.min(cur - pre, 1);
            pre = cur;
        }
        System.out.println(max + extra);
    }

    public static void main(String[] args) {

    }
    @Test
    public void test() {
        System.out.println((1 << 31) - 1);
    }
}
