package com.takiya.LeetCode;

import include.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)  return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode head : lists) {
            if (head != null)
                queue.add(head);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode cur = queue.remove();
            p.next = new ListNode(cur.val);
            p = p.next;
            if (cur.next != null)
                queue.add(cur.next);
        }
        return dummy.next;
    }
}
