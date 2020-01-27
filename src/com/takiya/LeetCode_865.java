package com.takiya;

import include.TreeNode;

import java.security.interfaces.RSAKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_865 {
    Map<TreeNode, Integer> depth;
    int max_depth;
    public TreeNode subtreeWithAllDeepest_1(TreeNode root) {
        depth = new HashMap<>();
        max_depth = 0;
        depth.put(null, -1);
        DFS(root, null);
        for (Integer depth : depth.values())
            max_depth = Math.max(depth, max_depth);
        return answer(root);
    }
    public void DFS(TreeNode node, TreeNode parent) {
        if (node != null) {
            depth.put(node, depth.get(parent) + 1);
            DFS(node.left, node);
            DFS(node.right, node);
        }
    }
    public TreeNode answer(TreeNode root) {
        if (root == null || depth.get(root) == max_depth)
            return root;
        TreeNode left = answer(root.left);
        TreeNode right = answer(root.right);
        if (left != null && right != null)
            return root;
        return left == null ? right :left;
    }

    public TreeNode subtreeWithAllDeepest_2(TreeNode root) {
        return DFS(root).node;
    }

    public Result DFS(TreeNode root) {
        if (root == null) return new Result(null, 0);
        Result left = DFS(root.left);
        Result right = DFS(root.right);
        if (left.dist > right.dist) return new Result(left.node, left.dist + 1);
        if (left.dist < right.dist) return new Result(right.node, right.dist + 1);
        return new Result(root, left.dist + 1);
    }

    public class Result {
        TreeNode node;
        int dist;

        public Result(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
