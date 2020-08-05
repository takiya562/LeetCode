package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        postOrder(root);
        return max;
    }
    int postOrder(TreeNode root) {
        if (root == null)
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.val == root.left.val)
            arrowLeft += left + 1;
        if (root.right != null && root.val == root.right.val)
            arrowRight += right + 1;
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowRight, arrowLeft);
    }
}
