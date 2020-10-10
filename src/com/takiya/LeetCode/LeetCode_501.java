package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayList;

public class LeetCode_501 {
    int base;
    int maxCount;
    int count;
    ArrayList<Integer> list;
    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        if (root == null)
            return new int[] {};
        maxCount = 0;
        count = 0;
        TreeNode cur = root, pre;
        base = cur.val;
        while (cur != null) {
            if (cur.left == null) {
                //visit
                visit(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    //visit
                    visit(cur.val);
                    cur = cur.right;
                }
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++)
            res[i] = list.get(i);
        return res;
    }

    private void visit(int x) {
        if (x == base)
            count++;
        else {
            count = 1;
            base = x;
        }
        if (count > maxCount) {
            list.clear();
            list.add(base);
            maxCount = count;
        } else if (count == maxCount)
            list.add(base);
    }
}
