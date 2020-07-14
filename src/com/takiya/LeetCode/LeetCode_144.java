package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                ans.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return ans;
    }
}
