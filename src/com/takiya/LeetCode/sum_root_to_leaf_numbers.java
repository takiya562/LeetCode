package com.takiya.LeetCode;

import include.TreeNode;


public class sum_root_to_leaf_numbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode root, int prevSum) {
        if (root == null)
            return 0;
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        else
            return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
