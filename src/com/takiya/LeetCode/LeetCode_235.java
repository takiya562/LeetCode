package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (p.val > root.val && q.val > root.val) {
            TreeNode right = lowestCommonAncestor(root.right,p ,q);
            return right;
        }
        else if (p.val < root.val && q.val < root.val) {
            TreeNode left = lowestCommonAncestor(root.left, p ,q);
            return left;
        }
        else {
            TreeNode left = lowestCommonAncestor(root.left,p ,q);
            TreeNode right = lowestCommonAncestor(root.right, p,q);
            if (left != null && right != null)
                return root;
            return left == null ? right : left;
        }
    }
}
