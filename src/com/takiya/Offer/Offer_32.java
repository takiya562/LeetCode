package com.takiya.Offer;

import include.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer_32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)   return new int[] {};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            list.add(cur.val);
            if (cur.left != null)   q.add(cur.left);
            if (cur.right != null)  q.add(cur.right);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
