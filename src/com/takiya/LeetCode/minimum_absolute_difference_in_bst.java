package com.takiya.LeetCode;

import include.TreeNode;

import java.util.Stack;

public class minimum_absolute_difference_in_bst {
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null)   return min;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int pre = -1;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != -1) {
                min = Math.min(min, cur.val - pre);
            }
            pre = cur.val;
            cur = cur.right;
        }
        return min;
    }
}
