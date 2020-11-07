package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binary_tree_preorder_traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty())  {
            while (p != null) {
                ans.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p = p.right;
        }
        return ans;
    }
}
