package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null)   return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int count = 1;
        while (!q.isEmpty()) {
            double sum = 0;
            int tmp = 0;
            for (int i = 0; i < count; ++i) {
                TreeNode p = q.remove();
                if (p.left != null) {
                    q.add(p.left);
                    tmp++;
                }
                if (p.right != null) {
                    q.add(p.right);
                    tmp++;
                }
                sum += p.val;
            }
            ans.add(sum / count);
            count = tmp;
        }
        return ans;
    }
}
