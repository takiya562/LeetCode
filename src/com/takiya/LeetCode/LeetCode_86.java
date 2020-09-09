package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode h = new ListNode(-1);
        ListNode p = head;
        ListNode dummy = new ListNode(-1);
        ListNode t1 = dummy;
        ListNode t2 = h;
        while (p != null) {
            if (p.val < x) {
                t1.next = p;
                t1 = t1.next;
                p = p.next;
                t1.next = null;
            } else {
                t2.next = p;
                t2 = t2.next;
                p = p.next;
                t2.next = null;
            }
        }
        t1.next = h.next;
        return dummy.next;
    }
}
