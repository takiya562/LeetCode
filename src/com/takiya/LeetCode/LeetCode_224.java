package com.takiya;

import java.util.Stack;

public class LeetCode_224 {
    public static int calculate(String s) {
        int index = 0;
        int len = s.length();
        Stack<Integer> paras = new Stack<>();
        Stack<Character> operas = new Stack<>();
        while (index < len) {
            char c = s.charAt(index);
            if (c >= 48 && c <= 57) {
                int temp = index;
                while (index < len && s.charAt(index) >= 48 && s.charAt(index) <= 57) ++index;
                paras.push(Integer.valueOf(s.substring(temp, index)));
            }
            else {
                if (c == '+' || c == '-') {
                    if (!operas.isEmpty()) {
                        char opera = operas.peek();
                        if (opera != '(') {
                            helper(paras, opera);
                            operas.pop();
                        }
                    }
                    operas.push(c);
                }

                if (c == '(')   operas.push(c);

                if (c == ')') {
                    char opera = operas.pop();
                    if (opera != '(') {
                        helper(paras, opera);
                        operas.pop();
                    }
                }
                index++;
            }
        }
        if (!operas.isEmpty()) {
            char opera = operas.pop();
            helper(paras, opera);
        }
        return paras.pop();
    }

    public static void helper(Stack<Integer> paras, char opera) {
        int para1 = paras.pop();
        int para2 = paras.pop();
        if (opera == '+')   paras.push(para1 + para2);
        if (opera == '-')   paras.push(para2 - para1);
    }

    public static void main(String args[]) {
        String s = "1 + 1";
        calculate(s);
    }
}
