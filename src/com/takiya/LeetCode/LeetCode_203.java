package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_203 {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)   return null;
        while (head != null && head.val == val)    head = head.next;
        ListNode p = head;
        while (p != null) {
            while (p.next != null && p.next.val == val)
                p.next = p.next.next;
            p = p.next;
        }
        return head;
    }
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 6; ++i) {
            p.next = new ListNode(i);
            p = p.next;
        }
        removeElements(head, 6);
    }
}
