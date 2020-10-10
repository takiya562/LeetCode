package com.takiya.LeetCode;

import include.TreeNode;

import java.util.HashMap;

public class LeetCode_106 {
    int index;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        index = postorder.length - 1;
        TreeNode root = buildTree0(inorder, postorder, 0, postorder.length);
        return root;
    }
    private TreeNode buildTree0(int[] inorder, int[] postorder, int left, int right) {
        if (left >= right)
            return null;
        int val = postorder[index];
        int mid = map.get(val);
        TreeNode root = new TreeNode(val);
        index--;
        TreeNode r = buildTree0(inorder, postorder, mid + 1, right);
        TreeNode l = buildTree0(inorder, postorder, left, mid);
        root.left = l;
        root.right = r;
        return root;
    }
}
