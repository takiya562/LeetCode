package com.takiya;

import include.TreeNode;

public class LeetCode_222 {
    public static int countNodes(TreeNode root) {
        int depth = countDepth(root);
        if (depth < 2)  return depth;
        int res = (1 << depth - 1) - 1;
        int L = 0;
        int R = (1 << depth - 1) - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (isExist(depth, root, mid))
                L = mid + 1;
            else
                R = mid - 1;
        }
        res += (L > R) ? L : R;
        return res;
    }

    public static boolean isExist(int depth, TreeNode node, int index) {
        int L = 0, R = (1 << depth - 1) - 1;
        int pivot;
        for (int i = 0; i < depth - 1; ++i) {
            pivot = (L + R) / 2;
            if (pivot >= index) {
                node = node.left;
                R = pivot;
            }
            else {
                node = node.right;
                L = pivot;
            }
        }
        return node != null;
    }

    public static int countDepth(TreeNode root) {
        if (root == null)   return 0;
        TreeNode cur = root;
        int depth = 0;
        while (cur != null) {
            depth++;
            cur = cur.left;
        }
        return depth;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
        countNodes(root);
    }
}
