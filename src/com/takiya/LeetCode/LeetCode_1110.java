package com.takiya.LeetCode;

import include.TreeNode;

import java.util.*;

public class LeetCode_1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if (root == null)   return ans;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < to_delete.length; ++i) {
            set.add(to_delete[i]);
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.peek();
            while (p.left != null) {
                p = p.left;
                stack.push(p);
            }
            if (p.right == null) {
                stack.pop();
                while (!stack.isEmpty()) {
                    if (p == stack.peek().left) {
                        if (set.contains(p.val)) {
                            if (p.left != null) ans.add(p.left);
                            if (p.right != null) ans.add(p.right);
                            stack.peek().left = null;
                        }
                        if (stack.peek().right != null) {
                            stack.push(stack.peek().right);
                            break;
                        }
                    } else {
                        if (set.contains(p.val)) {
                            if (p.left != null) ans.add(p.left);
                            if (p.right != null) ans.add(p.right);
                            stack.peek().right = null;
                        }
                    }
                    p = stack.pop();
                }
            } else {
                stack.push(p.right);
            }
        }
        if (set.contains(root.val)) {
            if (root.left != null) ans.add(root.left);
            if (root.right != null) ans.add(root.right);
        } else {
            ans.add(root);
        }
        return ans;
    }
}
