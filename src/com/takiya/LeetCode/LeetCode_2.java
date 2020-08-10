package com.takiya.LeetCode;

public class LeetCode_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 == null) {
                val = l2.val + carry;
                l2 = l2.next;
            }
            else if (l2 == null) {
                val = l1.val + carry;
                l1 = l1.next;
            }
            else {
                val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = val / 10;
            p.next = new ListNode(val % 10);
            p = p.next;
        }
        if (carry != 0)
            p.next = new ListNode(carry);
        return dummy.next;
    }
    public static void main(String args[])
    {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode l3 = addTwoNumbers(l1,l2);
        while(l3!=null)
        {
            System.out.print(String.valueOf(l3.val));
            l3 = l3.next;
        }
    }
}

