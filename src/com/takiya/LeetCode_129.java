package com.takiya;

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode_129 {

    class  TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int sumNumbers(TreeNode root) {
        int ans = 0;
        if (root == null)
            return 0;
        //int ans = dfs(root, new ArrayList<>());
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> state = new Stack<>();
        stack.push(root);
        state.push(0);
        int path = root.val;
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null) {
                ans += path * 10 + node.val;
                stack.pop();
                state.pop();
            }
            else if(state.peek() == 0) {
                if (node.left == null) {
                    Integer i = state.pop();
                    i = i + 1;
                    state.push(i);
                }
                else {
                    Integer i = state.pop();
                    i = i + 1;
                    state.push(i);
                    stack.push(node.left);
                    state.push(0);
                    path = path * 10 + node.val;
                }
            }
            else if (state.peek() == 1 ) {
                if(node.right != null) {
                    Integer i = state.pop();
                    i = i + 1;
                    state.push(i);
                    stack.push(node.right);
                    state.push(0);
                    path = path * 10 + node.val;
                }else{
                    Integer i = state.peek();
                    i = i + 1;
                }
            }
            while (!stack.empty() && state.peek() == 2) {
                stack.pop();
                state.pop();
            }
        }
        return ans;
    }
    /*
    public static int dfs(TreeNode node, ArrayList<Integer> path) {
        int res = 0;
        if (node == null)
            return 0;
        path.add(node.val);
        int len = path.size();
        if (node.left == null && node.right == null) {
            int n = 0;
            for (int i = len-1; i >= 0; i--) {
                res += Math.pow(10,n) * path.get(i);
                n++;
            }
            path.remove(len-1);
            return res;
        }
        res += dfs(node.left, path);
        res += dfs(node.right, path);
        path.remove(len-1);
        return res;
    }
     */

    public static void main(String[] args) {
        return;
    }

}
