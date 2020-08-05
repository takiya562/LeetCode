package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_437 {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        find(root, sum);
        return count;
    }
    void find(TreeNode root, int sum) {
        if (root == null)
            return;
        helper(root, sum);
        find(root.left, sum);
        find(root.right, sum);
    }
    void helper (TreeNode root, int cur) {
        if (root == null)
            return;
        cur -= root.val;
        if (cur == 0) {
            count++;
        }
        helper(root.left, cur);
        helper(root.right, cur);
    }
}
