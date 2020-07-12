package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;
        ListNode q = head;
        ListNode pre = null;
        int num = n - m + 1;
        while (p != null && m != 1) {
            pre = p;
            p = p.next;
            --m;
        }
        if (m != 1) return head;
        while (q != null && n != 0) {
            q = q.next;
            --n;
        }
        if (n != 0) return head;
        for (int i = 0; i < num; ++i) {
            ListNode tmp = p.next;
            p.next = q;
            q = p;
            p = tmp;
        }
        if (pre != null)
            pre.next = q;
        return pre != null ? head : q;
    }
}
