package com.takiya.LeetCode;

import include.TreeNode;

public class LeetCode_938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)   return 0;
        if (root.val <= R && root.val >= L) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return rangeSumBST(root.right, L, R);
        }
    }
}
