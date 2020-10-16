package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class populating_next_right_pointers_in_each_node {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null)   return root;
        Node dummy = new Node(-1);
        dummy.left = root;
        Node head = dummy;
        Node p = head;
        Node pre = null;
        while (p != null) {
            if (p.left != null) {
                p.left.next = p.right;
                if (pre == null) {
                    head = p.left;
                } else {
                    pre.next = p.left;
                }
                pre = p.right;
            }
            if (p.next == null) {
                if (head.left == null)  break;
                p = head;
                pre = null;
            } else {
                p = p.next;
            }

        }
        return root;
    }
}
