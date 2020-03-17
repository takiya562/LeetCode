package com.takiya.Offer;

import include.TreeNode;

public class Offer_28 {
    private boolean DFS(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null)
            return true;
        if (p1 == null || p2 == null)
            return false;
        if (p1.val == p2.val)
            return DFS(p1.left, p2.right) && DFS(p1.right, p2.left);
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        return DFS(root.left, root.right);
    }
}
