package com.takiya.LeetCode;
import include.Node;

import java.util.List;
import java.util.Stack;

public class LeetCode_559 {
    public class Pair {
        public Node node;
        public int searched;

        public Pair(Node node) {
            this.node = node;
            this.searched = 0;
        }
        public int plus() {
            return ++this.searched;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;
        Stack<Pair> stack = new Stack<>();
        int max = 0;
        stack.push(new Pair(root));
        while (!stack.isEmpty()) {
            Pair pair = stack.peek();
            List<Node> children = pair.node.children;
            int size = children.size();
            if (size == 0) {
                max = Math.max(max, stack.size());
                stack.pop();
                continue;
            }
            if (pair.searched < size) {
                Node node = children.get(pair.searched);
                stack.push(new Pair(node));
                pair.plus();
            }
            else
                stack.pop();
        }
        return max;
    }
    public int recursion(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(recursion(root.children.get(i)), max);
        }
        return max+1;
    }
}
