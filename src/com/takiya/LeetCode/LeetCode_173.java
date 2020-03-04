package com.takiya;

import include.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_173 {
    class BSTIterator {

        Queue<Integer> queue;

        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            inOrder(root);
        }

        /** @return the next smallest number */
        public int next() {
            return queue.remove();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        public void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            queue.add(root.val);
            inOrder(root.right);
        }
    }
}
