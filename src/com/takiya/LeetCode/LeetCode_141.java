package com.takiya.LeetCode;

import include.ListNode;

public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }
}
