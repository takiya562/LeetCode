package com.takiya.LeetCode;

import include.ListNode;

public class swap_nodes_in_pairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)   return head;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode cur = head;
        int count = 1;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = p.next;
            p.next = cur;
            if (count % 2 == 0) {
                p = p.next.next;
            }
            cur = tmp;
            count++;
        }
        return dummy.next;
    }
}
