package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_113 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return ans;
    }
    void helper(TreeNode root, int sum, List<Integer> list) {
        if (root == null)
            return;
        int size = list.size();
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(list));
        }
        helper(root.left, sum, list);
        helper(root.right, sum, list);
        list.remove(size);
    }
}
