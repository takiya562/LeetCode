package com.takiya.Offer;


public class Offer_36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        midOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void midOrder(Node root) {
        if (root == null)
            return;
        midOrder(root.left);
        if (pre != null)
            pre.right = root;
        else
            head = root;
        root.left = pre;
        pre = root;
        midOrder(root.right);
    }
}
