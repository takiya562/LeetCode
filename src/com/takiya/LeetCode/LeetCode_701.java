package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode p = root;
        while (true) {
            if (p.val > val) {
                if (p.left == null) {
                    p.left = new TreeNode(val);
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = new TreeNode(val);
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return root;
    }
}
