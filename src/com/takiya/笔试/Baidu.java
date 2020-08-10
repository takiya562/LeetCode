package com.takiya.笔试;

import include.ListNode;
import include.TreeNode;

public class Baidu {
    /**
     * 1. 一个单向链表，反转单向链表
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode p1 = head;
        ListNode dummy = new ListNode(-1);
        while (p1 != null) {
            ListNode tmp = dummy.next;
            ListNode p2 = p1.next;
            dummy.next = p1;
            p1.next = tmp;
            p1 = p2;
        }
        return dummy.next;
    }

    class LinkedList {
        LinkedList pre;
        LinkedList next;
        int val;

        LinkedList(int val) {
            this.val = val;
        }
    }

    /**
     * 2. 一颗二叉树，原地转换成中序遍历的双向链表
     * @param root
     * @return
     */
    public LinkedList midOrder(TreeNode root) {
        if (root == null)
            return null;
        LinkedList pre = midOrder(root.left);
        LinkedList cur = new LinkedList(root.val);
        LinkedList next = midOrder(root.right);
        if (pre != null) {
            while (pre.next != null)
                pre = pre.next;
        }
        cur.pre = pre;
        cur.next = next;
        if (pre != null)
            pre.next = cur;
        if (next != null)
            next.pre = cur;
        return cur;
    }

    /**
     * leetcode 295
     */
}
