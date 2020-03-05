package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_116 {
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
        if (root == null)   return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node pre = null;
        int size;
        while(!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; ++i) {
                Node cur = q.remove();
                cur.next = pre;
                if (cur.left != null) {
                    q.add(cur.right);
                    q.add(cur.left);
                }
                pre = cur;
            }
            pre = null;
        }
        return root;
    }
}
