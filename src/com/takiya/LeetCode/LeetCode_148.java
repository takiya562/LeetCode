package com.takiya.LeetCode;

import include.ListNode;
import org.junit.Test;

public class LeetCode_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        head = merge(left, right);
        return head;
    }
    private ListNode merge(ListNode left, ListNode right) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (left != null || right != null) {
            if (left == null) {
                pre.next = right;
                right = right.next;
            } else if (right == null) {
                pre.next = left;
                left = left.next;
            } else {
                if (left.val <= right.val) {
                    pre.next = left;
                    left = left.next;
                } else {
                    pre.next = right;
                    right = right.next;
                }
            }
            pre = pre.next;
        }
        return preHead.next;
    }
    @Test
    public void test() {
        ListNode head = new ListNode(4);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(3);
        sortList(head);
    }
}
