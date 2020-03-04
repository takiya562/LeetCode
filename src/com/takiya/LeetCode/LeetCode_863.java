package com.takiya.LeetCode;

import include.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_863 {
    List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        ans = new LinkedList<>();
        if (root == null)
            return ans;
        if (K == 0) {
            ans.add(target.val);
            return ans;
        }
        post(target, 0, K);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                TreeNode parent = stack.pop();
                if (parent.left == target) {
                    if (K > 1) {
                        post(parent.right, 0, K - 2);
                        break;
                    }
                    else
                        ans.add(parent.val);
                }
                if (parent.right == target) {
                    if (K > 1) {
                        post(parent.left, 0, K - 2);
                        break;
                    }
                    else
                        ans.add(parent.val);
                }
                pre = cur;
            }
            else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
        return ans;
    }

    public void post(TreeNode root, int L, int K) {
        if (root == null)
            return;
        if (L == K) {
            ans.add(root.val);
            return;
        }
        post(root.left, L + 1, K);
        post(root.right, L + 1, K);
    }
}
