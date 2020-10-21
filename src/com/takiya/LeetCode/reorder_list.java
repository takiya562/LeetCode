package com.takiya.LeetCode;

import include.ListNode;

import java.util.ArrayDeque;

public class reorder_list {
    public void reorderList(ListNode head) {
        if (head == null)   return;
        ListNode mid = findMid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reserveList(l2);
        ListNode l1 = head;
        mergeList(l1, l2);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null)   return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reserveList(ListNode head) {
        if (head == null)   return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Tmp = l1.next;
            ListNode l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }
}
