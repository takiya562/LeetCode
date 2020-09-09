package com.takiya.LeetCode;

import include.TreeNode;

import java.util.Stack;

public class LeetCode_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode cur = stack.pop();
            if (pre != null && pre.val >= cur.val)  return false;
            pre = cur;
            p = cur.right;
        }
        return true;
    }
}
