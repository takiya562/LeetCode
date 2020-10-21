package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_21 {
    /*
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result;
        if (l1.val < l2.val) {
            result = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            result = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode p = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            while (l2 != null) {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
                p = p.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
                p = p.next;
            }
        }
        return result;
    }
     */
    /*
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }
            else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 :l1;
        return preHead.next;
    }
    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
    }
}
