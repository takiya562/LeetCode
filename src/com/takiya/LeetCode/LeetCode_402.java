package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode_402 {
    public static String removeKdigits_3(String num, int k) {
        int len = num.length();
        int target = len - k;
        if (k >= len)   return "0";
        Stack<Integer> stack = new Stack<>();
        char[] array = num.toCharArray();
        int index = 0;
        String str = "";
        while (k != 0 && str.length() < target) {
            int temp = k;
            for (int i = index; i <= index + temp; ++i) {
                if (stack.isEmpty())    stack.push(i);
                else {
                    if (array[stack.peek()] > array[i]) {
                        int pre = stack.pop();
                        stack.push(i);
                        k -= i - pre;
                    }
                }
            }
            index += temp - k + 1;
            if (array[stack.peek()] == '0' && str.length() == 0)
                stack.pop();
            else
                str += array[stack.pop()];
        }
        if (str.length() == target) return str;
        str += num.substring(index, len);
        return str.equals("") ? "0" : str;
    }

    public static String removeKdigits_2(String num, int k) {
        int target = num.length() - k;
        if (target <= 0)  return "0";
        Stack<Integer> stack = new Stack<>();
        char[] array = num.toCharArray();
        String str = "";
        for (int i = 0; i < array.length; ++i) {
            while (!stack.isEmpty() && array[i] < array[stack.peek()] && k > 0) {
                stack.pop();
                k--;
            }
            if (stack.isEmpty() && array[i] == '0') continue;
            stack.push(i);
        }
        while (stack.size() > target)   stack.pop();
        while (!stack.isEmpty())
           str = array[stack.pop()] + str;
        return str.equals("") ? "0" : str;
    }
    public static String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }

        for (int i = 0; i < k; ++i)
            stack.removeLast();

        StringBuilder stringBuilder = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            stringBuilder.append(digit);
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
    public static void main(String args[]) {
        String num = "112";
        removeKdigits(num, 1);
    }
}
