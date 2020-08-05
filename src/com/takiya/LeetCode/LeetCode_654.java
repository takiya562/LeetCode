package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int index = l;
        int max = nums[l];
        for (int i = l; i < r; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, l, index);
        root.right = construct(nums, index + 1, r);
        return root;
    }
}
