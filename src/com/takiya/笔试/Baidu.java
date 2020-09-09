package com.takiya.笔试;

import include.ListNode;
import include.TreeNode;

import java.util.*;

public class Baidu {
    /**
     * 1. 一个单向链表，反转单向链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode p1 = head;
        ListNode dummy = new ListNode(-1);
        while (p1 != null) {
            ListNode tmp = dummy.next;
            ListNode p2 = p1.next;
            dummy.next = p1;
            p1.next = tmp;
            p1 = p2;
        }
        return dummy.next;
    }

    class LinkedList {
        LinkedList pre;
        LinkedList next;
        int val;

        LinkedList(int val) {
            this.val = val;
        }
    }

    /**
     * 2. 一颗二叉树，原地转换成中序遍历的双向链表
     * @param root
     * @return
     */
    public LinkedList midOrder(TreeNode root) {
        if (root == null)
            return null;
        LinkedList pre = midOrder(root.left);
        LinkedList cur = new LinkedList(root.val);
        LinkedList next = midOrder(root.right);
        if (pre != null) {
            while (pre.next != null)
                pre = pre.next;
        }
        cur.pre = pre;
        cur.next = next;
        if (pre != null)
            pre.next = cur;
        if (next != null)
            next.pre = cur;
        return cur;
    }

    /**
     * leetcode 295
     */

    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c5 = 0;
        int c0 = 0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num == 5)
                c5++;
            else
                c0++;
        }
        if (c0 == 0) {
            System.out.println(-1);
            return;
        }
        if (c5 == 0) {
            System.out.println(0);
            return;
        }
        int count = c5 / 9 * 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("5");
        }
        for (int i = 0; i < c0; i++) {
            sb.append("0");
        }
        System.out.println(sb.toString());
    }

    static class Pair {
        int l;
        int r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] counts = new int[n + 1];
            int[] mark = new int[n + 1];
            for (int i = 1; i <= m; i++) {
                int k = scanner.nextInt();
                for (int j = 0; j < k; j++) {
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    for (int p = l; p <= r; p++) {
                        if (mark[p] != i) {
                            mark[p] = i;
                            counts[p]++;
                        }
                    }
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (counts[i] == m) {
                    list.add(i);
                    count++;
                }
            }
            System.out.println(count);
            if (count == 0) {
                return;
            }
            for (int i = 0; i < list.size() - 1; i++)
                System.out.print(list.get(i) + " ");
            System.out.println(list.get(list.size() - 1));
        }
    }



    public static void main(String[] args) {
        solution2();
    }
}
