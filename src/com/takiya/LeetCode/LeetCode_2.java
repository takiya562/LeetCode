package com.takiya.LeetCode;

public class LeetCode_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p = null;
        ListNode n;
        int carry = 0;
        int temp, i, j;
        while(l1 != null || l2 != null || carry !=0)
        {
            i = l1 != null ? l1.val : 0;
            j = l2 != null ? l2.val : 0;
            temp = i + j + carry;
            if (p == null)
            {
                l3.val = temp % 10;
                p = l3;
            }else {
                n = new ListNode(temp % 10);
                p.next = n;
                p = p.next;
            }
            carry = temp / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return l3;
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

