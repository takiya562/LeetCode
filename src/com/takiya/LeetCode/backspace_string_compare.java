package com.takiya.LeetCode;

import java.util.Stack;

public class backspace_string_compare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c != '#')
                s1.push(c);
            else {
                if (!s1.isEmpty())
                    s1.pop();
            }
        }
        for (char c : T.toCharArray()) {
            if (c != '#')
                s2.push(c);
            else {
                if (!s2.isEmpty())
                    s2.pop();
            }
        }
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop())
                return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }
}
