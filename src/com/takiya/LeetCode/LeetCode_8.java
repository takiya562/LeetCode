package com.takiya.LeetCode;

import org.junit.Test;


public class LeetCode_8 {
    public int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        int n = chars.length;
        if (n == 0)
            return 0;
        int index = 0;
        boolean negative = false;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }
        int ans = 0;
        while (index < n && Character.isDigit(chars[index])) {
            int cur = chars[index] - '0';
            if (ans > (Integer.MAX_VALUE - cur) / 10)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            ans *= 10;
            ans += cur;
            index++;
        }
        return negative ? -ans : ans;
    }

    @Test
    public void test() {
        String str = "-91283472332";
        int res = myAtoi(str);
        System.out.println(res);
    }
}
