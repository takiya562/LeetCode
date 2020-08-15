package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode p = head;
        int n = 1;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        p.next = head;
        p = p.next;
        for (int i = 0; i < n - 1 - k % n; ++i)
            p = p.next;
        head = p.next;
        p.next = null;
        return head;
    }
}
