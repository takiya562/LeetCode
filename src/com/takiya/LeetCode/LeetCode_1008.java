package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, 0, preorder.length);
    }
    TreeNode construct(int[] preorder, int l, int r) {
        if (l == r)
            return null;
        TreeNode root = new TreeNode(preorder[l]);
        int i = l + 1;
        while (i < r && preorder[i] < preorder[l])   ++i;
        root.left = construct(preorder, l + 1, i);
        root.right = construct(preorder, i, r);
        return root;
    }
}
