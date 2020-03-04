package com.takiya;
import include.TreeNode;

import java.util.*;

public class LeetCode_919 {
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> q;

        public CBTInserter(TreeNode root) {
            this.root = root;
            q = new LinkedList<>();
            q.add(root);
        }

        public int insert(int v) {
            int res = 0;
            while (!q.isEmpty()) {
                TreeNode node = q.peek();
                if (node.left == null) {
                    node.left = new TreeNode(v);
                    res = node.val;
                    break;
                }
                if (node.right == null) {
                    node.right = new TreeNode(v);
                    res = node.val;
                    break;
                }
                q.remove();
                q.add(node.left);
                q.add(node.right);
            }
            return res;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
