package com.takiya;

import include.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LeetCode_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)   return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> item = new LinkedList<>();
           for (int i = 0; i < size; ++i) {
               Node cur = queue.poll();
               item.add(cur.val);
               for (Node child : cur.children)
                   queue.add(child);
           }
           ans.add(item);
        }
        return ans;
    }
}
