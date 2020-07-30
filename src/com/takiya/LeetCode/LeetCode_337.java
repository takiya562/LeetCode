package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_337 {
    public int rob(TreeNode root) {
        int[] ret = helper(root);
        return Math.max(ret[0], ret[1]);
    }

    int[] helper(TreeNode root) {
        if (root == null)   return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] ret = new int[2];
        ret[0] = root.val + left[1] + right[1];
        ret[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return ret;
    }
}
