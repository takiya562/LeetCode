package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == p.val) {
                while (p.next != null && p.next.val == p.val) p = p.next;
                pre.next = p.next;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
