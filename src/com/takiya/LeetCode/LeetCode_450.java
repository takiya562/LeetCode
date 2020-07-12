package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode p = root;
        while (p != null && p.val != key) {
            parent = p;
            if (p.val <= key) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null)
            return root;
        if (p.left != null) {
            TreeNode tmp = p.left;
            p.val = tmp.val;
            p.left = tmp.left;
            addNode(p, tmp.right);
        } else if (p.right != null){
            p.val = p.right.val;
            p.left = p.right.left;
            p.right = p.right.right;
        } else {
            if (parent == null) return null;
            if (parent.val <= key)  parent.right = null;
            if (parent.val > key)   parent.left = null;
        }
        return root;
    }

    public void addNode(TreeNode root, TreeNode node) {
        while (root != null && node != null) {
            if (root.val <= node.val) {
                if (root.right == null) {
                    root.right = node;
                    break;
                }
                root = root.right;
            } else {
                if (root.left == null) {
                    root.left = node;
                    break;
                }
                root = root.left;
            }
        }
    }
}
