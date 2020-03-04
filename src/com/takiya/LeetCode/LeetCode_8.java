package com.takiya;

import java.util.Stack;

public class LeetCode_8 {
    public static int myAtoi(String str) {
        int result = 0;
        int i = 0;
        int ascii;
        int n = -1;
        boolean is_minus = false;
        boolean head_zero = true;
        Stack<Integer> stack = new Stack<>();
        int plus_edge = Integer.MAX_VALUE;
        plus_edge -= 2 * Math.pow(10, 9);
        int minus_edge = Integer.MIN_VALUE;
        minus_edge += 2 * Math.pow(10, 9);
        minus_edge = Math.abs(minus_edge);
        while(i < str.length()) {
            ascii = str.charAt(i);
            if (ascii == 32) {
                i++;
                continue;
            }
            if (ascii == 45) {
                is_minus = true;
                i++;
                break;
            }
            if (ascii == 43) {
                is_minus = false;
                i++;
                break;
            }
            if (ascii < 48 || ascii > 57)
                return 0;
            break;
        }
        while (i < str.length()) {
            ascii = str.charAt(i);
            if (ascii == 48 && head_zero) {
                i++;
                continue;
            }
            head_zero = false;
            if (!head_zero && ascii >= 48 && ascii <=57) {
                stack.push(ascii - 48);
                i++;
                continue;
            }
            break;
        }
        while (!stack.empty()) {
            if (stack.size() > 10) {
                if (is_minus)
                    return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            n++;
            if (n == 9 && stack.peek() >= 2 && plus_edge < result && !is_minus) {
                return Integer.MAX_VALUE;
            }
            if (n == 9 && stack.peek() >= 2 && minus_edge <= result && is_minus) {
                return Integer.MIN_VALUE;
            }
            result += Math.pow(10, n) * stack.pop();
        }
        result = is_minus ? -result : result;
        return result;
    }

    public static void main(String args[]) {
        int result = myAtoi(" 1175109307q7");
        System.out.print(String.valueOf(result));
    }
}
