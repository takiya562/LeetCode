package com.takiya.LeetCode;

import java.util.Stack;

public class LeetCode_8 {
    private static int edge = Integer.MIN_VALUE / 10;
    public int myAtoi(String str) {
        int res = 0;
        str = str.trim();
        if (str.equals(""))
            return 0;
        char first = str.charAt(0);
        boolean isNegative = str.charAt(0) == '-' ? true : false;
        int digital;
        boolean isFirst = true;
        for (int c : str.toCharArray()) {
            if (isFirst && (c == '-' || c == '+')) {
                isFirst = false;
                continue;
            }
            if (isFirst)
                isFirst = false;
            if (c < 48 || c > 57)
                break;
            else {
                digital = c - '0';
                if (res < edge || (res == edge && digital > 8)) {
                    res = Integer.MIN_VALUE;
                    break;
                }
                res = res * 10 - digital;
            }
        }
        if (!isNegative) {
            if (res == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else
                return -res;
        }
        return res;
    }
}
