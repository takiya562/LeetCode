package com.takiya.LeetCode;

import java.util.Stack;

public class LeetCode_1003 {
    public boolean isValid(String S) {
        int len = S.length();
        if (S == null || len < 3)   return false;
        int top = -1;
        char[] stack = new char[len];
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (top < 0 || stack[top--] != 'b')
                    return false;
                if (top < 0 || stack[top--] != 'a')
                    return false;
            } else {
                if (top < 0 && c != 'a')
                    return false;
                stack[++top] = c;
            }
        }
        return top < 0;
    }
}
