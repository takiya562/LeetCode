package com.takiya.LeetCode;

import include.ListNode;

public class remove_nth_node_from_end_of_list {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            if (right != null)
                right = right.next;
            else
                return null;
        }
        if (right == null)
            return left.next;
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 0; i < 1; i++) {
            p.next = new ListNode(i+2);
            p = p.next;
        }
        ListNode result = removeNthFromEnd(head, 2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
