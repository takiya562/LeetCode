package com.takiya.LeetCode;


public class LeetCode_889 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    int[] pre;
    int[] post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length;
        this.pre = pre;
        this.post = post;
        TreeNode root = recursion(0, len-1, 0, len-1);
        return root;
    }
    public TreeNode recursion(int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart == preEnd) return new TreeNode(pre[preStart]);
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int val = pre[++preStart];
        int len;
        for (int i = postStart; i < postEnd; i++) {
            if (post[i] == val) {
                len = i - postStart;
                root.left = recursion(preStart, preStart+len, postStart, postStart+len);
                root.right = recursion(preStart+len+1, preEnd, postStart+len+1, postEnd);
                return root;
            }
        }
        return null;
    }
}