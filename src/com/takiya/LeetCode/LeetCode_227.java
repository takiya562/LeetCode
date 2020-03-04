package com.takiya.LeetCode;

import java.util.Stack;

public class LeetCode_227 {
    public static int calculate(String s) {
        Stack<Integer> paras = new Stack<>();
        Stack<Character> operas = new Stack<>();
        int index = 0;
        int len = s.length();
        while (index < len) {
            char c = s.charAt(index);
            if (c >= 48 && c <= 57) {
                int temp = index;
                while (index < len && s.charAt(index) >= 48 && s.charAt(index) <= 57) ++index;
                paras.push(Integer.valueOf(s.substring(temp, index)));
            }
            else if (c == ' ') {
                index++;
                continue;
            }
            else {
                while (!operas.isEmpty() && levelCompare(operas.peek(), c) != -1)
                    helper(paras, operas.pop());
                operas.push(c);
                index++;
            }
        }
        while (!operas.isEmpty())
            helper(paras, operas.pop());
        return paras.pop();
    }

    public static void helper(Stack<Integer> paras, char opera) {
        int para1 = paras.pop();
        int para2 = paras.pop();
        switch (opera) {
            case '+' :
                paras.push(para2 + para1);
                break;
            case '-' :
                paras.push(para2 - para1);
                break;
            case '*' :
                paras.push(para2 * para1);
                break;
            case '/' :
                paras.push(para2 / para1);
                break;
        }
    }

    public static int levelCompare(char opera, char c) {
        if (opera == '+' || opera == '-')
            return (c == '+' || c == '-') ? 0 : -1;

        else
            return (c == '*' || c == '/') ? 0 : 1;
    }

    public static void main(String args[]) {
        String s = "1*2-3/4+5*6-7*8+9/10";
        calculate(s);
    }
}
