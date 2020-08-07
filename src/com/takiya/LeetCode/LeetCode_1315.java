package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_1315 {
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 0);
    }
    int dfs(TreeNode root, int state) {
        if (root == null)
            return 0;
        int ret = 0;
        if ((state & 2) == 2)
            ret += root.val;
        state <<= 1;
        if (root.val % 2 == 0) {
            state |= 1;
        }
        return ret + dfs(root.left, state) + dfs(root.right, state);
    }
}
