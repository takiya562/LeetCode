package com.takiya.LeetCode;

import include.ListNode;


public class linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        if (head == null)   return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                slow = head;
                fast = fast.next;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
}
