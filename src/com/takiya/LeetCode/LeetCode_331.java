package com.takiya.LeetCode;

import java.util.Stack;

public class LeetCode_331 {
    public static class Pair {
        public String node;
        public int flag;

        public Pair(String node) {
            this.node = node;
            this.flag = 0;
        }

        public int plus() {
            return ++this.flag;
        }
    }
    public static boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        int len = split.length;
        if (len == 1 && split[0].equals("#"))
            return true;
        if (len < 3) return false;
        Stack<Pair> stack = new Stack<>();
        int index = 0;
        for (; index < len; index++) {
            String node = split[index];
            if (!node.equals("#"))
                stack.push(new Pair(node));
            else {
                if (stack.isEmpty())
                    return false;
                while (!stack.isEmpty() && stack.peek().plus() == 2)
                    stack.pop();
                if (stack.isEmpty()) break;
            }
        }
        return (index == len - 1 && stack.isEmpty());
    }
    public static void main(String args[]) {
        isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
