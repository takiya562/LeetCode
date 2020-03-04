package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_508 {
    static int max = 0;
    static Map<Integer, Integer> map;
    public static int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        postOrder(root);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                list.add(entry.getKey());
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i)
            res[i] = list.get(i);
        return res;
    }

    public static int postOrder(TreeNode root) {
        int sum = 0;
        if (root == null)   return sum;
        sum += postOrder(root.left);
        sum += postOrder(root.right);
        sum += root.val;
        int count = 1;
        if (map.containsKey(sum)) {
            count = map.get(sum) + 1;
            map.put(sum, count);
        }
        else
            map.put(sum, 1);
        max = Math.max(max, count);
        return sum;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        findFrequentTreeSum(root);
    }
}
