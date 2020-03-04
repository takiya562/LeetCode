package com.takiya;

import java.util.Stack;

public class LeetCode_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int para1 = stack.pop(), para2 = stack.pop();
                switch (token) {
                    case "+" :
                        stack.push(para2 + para1);
                        break;
                    case "-" :
                        stack.push(para2 - para1);
                        break;
                    case "*" :
                        stack.push(para2 * para1);
                        break;
                    case "/" :
                        stack.push(para2 / para1);
                        break;
                }
            }
            else
                stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}
