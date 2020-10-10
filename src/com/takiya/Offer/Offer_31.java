package com.takiya.Offer;

import java.util.Stack;

public class Offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        int n = pushed.length;
        while (j < n) {
            if (i == n && stack.peek() != popped[j])
                return false;
            else if (i < n && (stack.isEmpty() || stack.peek() != popped[j]))
                stack.push(pushed[i++]);
            else if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return true;
    }
}
