package com.takiya.LeetCode;

import include.TreeNode;
import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Map;
import java.util.HashMap;


public class LeetCode_105 {
	Map<Integer, Integer> map;
    int i;
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		if (n == 0)	return null;
		map = new HashMap<>();
        i = 0;
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		return build(preorder, inorder, 0, n - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int l, int r) {
    	if (i == preorder.length)
    		return null;
    	if (l == r) {
    		return new TreeNode(inorder[l]);
    	}
    	int index = map.get(preorder[i]); 
    	TreeNode root = new TreeNode(preorder[i]);
    	if (l <= index - 1) {
            i++;
    		root.left = build(preorder, inorder, l, index - 1);
    	}
    	if (r >= index + 1) {
            i++;
    		root.right = build(preorder, inorder, index + 1, r); 
    	}
    	return root;
    }

    @Test
    public void test() {
		buildTree(Tools.stringToIntegerArray("[7,-10,-4,3,-1,2,-8,11]"), Tools.stringToIntegerArray("[-4,-10,3,-1,7,11,-8,2]"));
    }
}