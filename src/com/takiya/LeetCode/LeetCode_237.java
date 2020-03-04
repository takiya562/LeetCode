package com.takiya;

import include.ListNode;

public class LeetCode_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
