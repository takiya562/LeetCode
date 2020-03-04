package com.takiya.LeetCode;

import java.util.Stack;

public class LeetCode_20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if (len == 0)
            return true;
        if (len == 1)
            return false;
        stack.push(s.charAt(0));
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' ||s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.empty())
                    return false;
                char temp = stack.peek();
                if (temp == '(' && s.charAt(i) == ')')
                    stack.pop();
                else if (temp == '[' && s.charAt(i) == ']')
                    stack.pop();
                else if (temp == '{' && s.charAt(i) == '}')
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.empty())
            return true;
        return false;
    }
    public static void main(String args[]) {
        if (isValid("([]){}"))
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
