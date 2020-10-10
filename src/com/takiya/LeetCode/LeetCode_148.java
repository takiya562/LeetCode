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

    public ListNode listQuickSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        listQuickSort0(head, null);
        return head;
    }

    private void listQuickSort0(ListNode left, ListNode right) {
        if (left == right || left.next == right)
            return;
        ListNode p = getPartition(left, right);
        listQuickSort0(left, p);
        listQuickSort0(p.next, right);
    }

    private ListNode getPartition(ListNode left, ListNode right) {
        if (left == right || left.next == right)
            return left;
        ListNode p = left, q = left.next;
        int pivot = left.val;
        while (q != right) {
            if (q.val < pivot) {
                p = p.next;
                listValSwap(p, q);
            }
            q = q.next;
        }
        listValSwap(left, p);
        return p;
    }

    private void listValSwap(ListNode p, ListNode q) {
        if (p == q)
            return;
        int tmp = p.val;
        p.val = q.val;
        q.val = tmp;
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
        listQuickSort(head);
        p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
