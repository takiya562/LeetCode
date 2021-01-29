package com.takiya.LeetCode;

import include.TreeNode;
import java.util.Queue;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.Assert;
public class Codec {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
        	return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        sb.append(root.val);
        queue.add(root);
        while (!queue.isEmpty()) {
        	TreeNode cur = queue.remove();
        	if (cur.left != null) {
        		sb.append(",").append(cur.left.val);
        		queue.add(cur.left);
        	} else {
        		sb.append(",").append("null");
        	}

        	if (cur.right != null) {
        		sb.append(",").append(cur.right.val);
        		queue.add(cur.right);
        	} else {
        		sb.append(",").append("null");
        	}
        }
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.trim();
        data = data.substring(1, data.length() - 1);
        if (data.length() == 0)	return null;
        String[] parts = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
        	TreeNode cur = queue.remove();
        	String left = "", right = "";
        	if (index < parts.length) {
        		left = parts[index++];
        	}
        	if (!left.equals("null")) {
        		cur.left = new TreeNode(Integer.parseInt(left));
        		queue.add(cur.left);
        	}
        	if (index < parts.length) {
        		right = parts[index++];
        	}
        	if (!right.equals("null")) {
        		cur.right = new TreeNode(Integer.parseInt(right));
        		queue.add(cur.right);
        	}
        }
        return root;
    }

    @Test
    public void test() {
    	String data = "";
    	System.out.println(data.split(",").length);
    }
}