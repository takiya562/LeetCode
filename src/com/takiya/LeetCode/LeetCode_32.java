package com.takiya;

import java.util.Stack;

public class LeetCode_32 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '（')
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(')
                    dp[i] = dp[i-1] + (i - dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0) + 2;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int longestValidParentheses_2(String s) {
        int len = s.length();
        if (len < 2) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
