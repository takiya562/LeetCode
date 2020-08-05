package com.takiya.LeetCode;

import include.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_508 {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[]{};
        int sum = helper(root);
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = Math.max(max, count);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                list.add(entry.getKey());
        }
        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; ++i)
            res[i] = list.get(i);
        return res;
    }
    int helper(TreeNode root) {
        int count;
        int left = 0;
        if (root.left != null) {
            left = helper(root.left);
            count = map.getOrDefault(left, 0) + 1;
            max = Math.max(count, max);
            map.put(left, count);
        }
        int right = 0;
        if (root.right != null) {
            right = helper(root.right);
            count = map.getOrDefault(right, 0) + 1;
            max = Math.max(count, max);
            map.put(right, count);
        }
        return root.val + left + right;
    }

}
