package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode preHead =new ListNode(-1);
        ListNode pre = preHead;
        ListNode odd = head;
        ListNode even = head.next;
        while (even != null) {
            odd.next = even.next;
            even.next = odd;
            pre.next = even;
            pre = odd;
            odd = odd.next;
            if (odd == null)
                return preHead.next;
            even = odd.next;
        }
        return preHead.next;
    }
    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 0; i < 3; i++) {
            p.next = new ListNode(i+2);
            p = p.next;
        }
        p = swapPairs(head);
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
