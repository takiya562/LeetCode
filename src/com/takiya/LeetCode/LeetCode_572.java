package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val)
            return helper(s.left, t.left) && helper(s.right, t.right);
        return false;
    }
}
