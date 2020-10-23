package com.takiya.LeetCode;

import include.ListNode;

public class palindrome_linked_list {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)   return true;
        ListNode mid = findMid(head);
        ListNode p = head;
        ListNode q = mid.next;
        mid.next = null;
        q = reserveList(q);
        while (q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
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
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
