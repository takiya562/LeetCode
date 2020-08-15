package com.takiya.笔试;

import org.junit.Test;

import java.util.HashSet;
import java.util.Stack;

public class Bilibili {
    /**
     *
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    HashSet<Integer> set = new HashSet<>();
    public boolean Game24Points (int[] arr) {
        // write code here
        return true;
    }



    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean IsValidExp (String s) {
        // write code here
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty() && (c == ')' || c == ']' || c =='}'))
                return false;
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (c == ')' && stack.pop() != '(')
                    return false;
                if (c == ']' && stack.pop() != '[')
                    return false;
                if (c == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     *
     * @param N int整型
     * @return int整型
     */
    public int GetCoinCount (int N) {
        // write code here
        int num = 1024 - N;
        int sum = 0;
        sum += num / 64;
        num %= 64;
        sum += num / 16;
        num %= 16;
        sum += num / 4;
        return sum;
    }

    @Test
    public void test2() {
        boolean res = IsValidExp("");
        System.out.println(res);
    }
}
