package com.takiya.LeetCode;

import java.util.ArrayDeque;

public class LeetCode_117 {
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
        if (root == null)
            return root;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        Node dummy = new Node(-1);
        while (!q.isEmpty()) {
            int size = q.size();
            Node p = dummy;
            for (int i = 0; i < size; i++) {
                p.next = q.poll();
                p = p.next;
                if (p.left != null)
                    q.add(p.left);
                if (p.right != null)
                    q.add(p.right);
            }
        }
        return root;
    }
}
