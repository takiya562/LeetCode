package com.takiya.LeetCode;

import include.Tools;
import include.TreeNode;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_124 {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		helper(root);
		return max;
    }

    private int helper(TreeNode root) {
    	if (root == null)	return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		int ret = root.val;
		if (left < 0 && right < 0)
			max = Math.max(max, ret);
		else if (left > right) {
			ret = root.val + left;
		} else {
			ret = root.val + right;
		}
		max = Math.max(max, ret);
		max = Math.max(max, root.val + left + right);
		return ret;
    }
}