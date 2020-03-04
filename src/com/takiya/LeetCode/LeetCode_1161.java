package com.takiya;

import include.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_1161 {
    public int maxLevelSum(TreeNode root) {
        if (root ==null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int count = 1;
        int searched = 0;
        int level = 1;
        int next = 0;
        int max = 0;
        int ans = 1;
        int sum = 0;
        while (!q.isEmpty()) {
            if (searched == count) {
                count = next;
                next = 0;
                if (sum > max) {
                    max = sum;
                    ans = level;
                }
                level++;
                sum = 0;
                searched = 0;
                continue;
            }
            TreeNode node = q.remove();
            sum += node.val;
            searched++;
            if (node.left != null) {
                next++;
                q.add(node.left);
            }
            if (node.right != null) {
                next++;
                q.add(node.right);
            }
        }
        return ans;
    }
}
