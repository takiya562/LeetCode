package com.takiya.LeetCode;

import include.Tools;
import include.TreeNode;
import org.junit.Test;
import org.junit.Assert;
import java.util.Stack;

public class LeetCode_114 {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode cur = root;
		TreeNode last = null;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.right;
			}
			cur = stack.peek();
			if (cur.left == null || last == cur.left) {
				cur.right = last;
				last = cur;
				cur.left = null;
				cur = null;
				stack.pop();
			} else {
				cur = cur.left;
			}
		}
    }	

    @Test
    public void test() {
    	TreeNode root = Tools.stringToTreeNode("[1,2,5,3,4,null,6]");
    	flatten(root);
    	System.out.println(Tools.treeNodeToString(root));
    	Assert.assertEquals("[1,null,2,null,3,null,4,null,5,null,6,null,null]", Tools.treeNodeToString(root));
    }
}