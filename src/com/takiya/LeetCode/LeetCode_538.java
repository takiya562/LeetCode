package com.takiya.LeetCode;

import include.TreeNode;
import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Stack;

public class LeetCode_538 {
	public TreeNode convertBST(TreeNode root) {
		int sum = 0;
		TreeNode cur = root;
		while (cur != null) {
			if (cur.right == null) {
				sum += cur.val;
				cur.val = sum;
				cur = cur.left;
			} else {
				TreeNode succ = getSuccessor(cur);
				if (succ.left == null) {
					succ.left = cur;
					cur = cur.right;
				} else {
					succ.left = null;
					sum += cur.val;
					cur.val = sum;
					cur = cur.left;
				}
			}
		}
		return root;
    }

    private TreeNode getSuccessor(TreeNode node) {
    	TreeNode succ = node.right;
    	while (succ.left != null && succ.left != node) {
    		succ = succ.left;
    	}
    	return succ;
    }


    @Test
    public void test() {
    	TreeNode root = Tools.stringToTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
    	TreeNode res = convertBST(root);
    	String expect = "[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]";
    	Assert.assertEquals(expect, Tools.treeNodeToString(res));
    }
}