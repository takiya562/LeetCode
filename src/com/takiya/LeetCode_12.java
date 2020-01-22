package com.takiya;

import javax.print.DocFlavor;
import java.beans.beancontext.BeanContextServiceRevokedEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode_12 {
    /*public static String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        int n = -1;
        int i;
        while (num != 0) {
            n++;
            switch (num % 10) {
                case 0 :
                    break;
                case 1 :
                    mySwitch(n, stack, 1);
                    break;
                case 2 :
                    mySwitch(n, stack, 2);
                    break;
                case 3 :
                    mySwitch(n, stack, 3);
                    break;
                case 4 :
                    mySwitch(n, stack, 4);
                    break;
                case 5 :
                    mySwitch(n, stack, 5);
                    break;
                case 6 :
                    mySwitch(n ,stack, 6);
                    break;
                case 7 :
                    mySwitch(n, stack, 7);
                    break;
                case 8 :
                    mySwitch(n, stack, 8);
                    break;
                case 9 :
                    mySwitch(n, stack, 9);
                    break;
            }
            num /= 10;
        }
        while (!stack.empty())
            result.append(stack.pop());
        return result.toString();
    }
    public static void mySwitch(int n, Stack stack, int spec) {
        int i;
        if (spec >= 1 && spec <= 3) {
            switch (n) {
                case 0:
                    for (i = 0; i < spec; i ++)
                        stack.push('I');
                    break;
                case 1:
                    for (i = 0; i < spec; i ++)
                        stack.push('X');
                    break;
                case 2:
                    for (i = 0; i < spec; i ++)
                        stack.push('C');
                    break;
                case 3:
                    for (i = 0; i < spec; i ++)
                        stack.push('M');
                    break;
            }
        }
        if (spec >= 6 && spec <= 8) {
            spec -= 5;
            switch (n) {
                case 0 :
                    for (i = 0; i < spec; i ++)
                        stack.push('I');
                    stack.push('V');
                    break;
                case 1 :
                    for (i = 0; i < spec; i ++)
                        stack.push('X');
                    stack.push('L');
                    break;
                case 2 :
                    for (i = 0; i < spec; i ++)
                        stack.push('C');
                    stack.push('D');
            }
        }
        if (spec == 4) {
            switch (n) {
                case 0 :
                    stack.push('V');
                    stack.push('I');
                    break;
                case 1 :
                    stack.push('L');
                    stack.push('X');
                    break;
                case 2 :
                    stack.push('D');
                    stack.push('C');
                    break;
            }
        }
        if (spec == 5) {
            switch (n) {
                case 0 :
                    stack.push('V');
                    break;
                case 1 :
                    stack.push('L');
                    break;
                case 2 :
                    stack.push('D');
                    break;
            }
        }
        if (spec == 9) {
            switch (n) {
                case 0 :
                    stack.push('X');
                    stack.push('I');
                    break;
                case 1 :
                    stack.push('C');
                    stack.push('X');
                    break;
                case 2 :
                    stack.push('M');
                    stack.push('C');
                    break;
            }
        }
    }*/
    public static String intToRoman(int num) {
        // 把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        // 并且按照阿拉伯数字的大小降序排列，这是贪心选择思想
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index] && num != 0) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();
    }
    public static void main(String args[]) {
        String result = intToRoman(1994);
        System.out.print(result);
    }
}
