package com.takiya;

import include.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p))
                return p;
            set.add(p);
            p = p.next;
        }
        return null;
    }
    public ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise)
                return hare;
        }
        return null;
    }
    public ListNode detectWithoutExtraSpace(ListNode head) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = getIntersect(head);
        if (p2 == null) return null;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
