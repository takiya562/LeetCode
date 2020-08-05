package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum - root.val == 0)
            return true;
        boolean left = hasPathSum(root.left, sum - root.val);
        boolean right = hasPathSum(root.right, sum - root.val);
        return left || right;
    }
}
