package com.takiya;

import include.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_623 {
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 1;
        int amount = 1;
        int nextAmount = 0;
        int searched = 0;
        while (level < d) {
            if (searched == amount) {
                level++;
                amount = nextAmount;
                nextAmount = 0;
                searched = 0;
                continue;
            }
            TreeNode node = q.remove();
            if (level == d - 1) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                node.left = new TreeNode(v);
                node.right = new TreeNode(v);
                node.left.left = left;
                node.right.right = right;
            }
            else {
                if (node.left != null) {
                    q.add(node.left);
                    nextAmount++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    nextAmount++;
                }
            }
            searched++;
        }
        return root;
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        addOneRow(root, 1, 3);
    }
}
