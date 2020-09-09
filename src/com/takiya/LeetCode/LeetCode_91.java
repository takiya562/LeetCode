package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_91 {
    public int numDecodings(String s) {
        int n = s.length();
        int pp = 0;
        int p = 1;
        int pre = 0;
        for (char c : s.toCharArray()) {
            int num = c - '0';
            int cur = p;
            if (num == 0)
                cur = 0;
            int tmp = pre * 10 + num;
            if (tmp <= 26 && tmp >= 10) {
                cur += pp;
            }
            pp = p;
            p = cur;
            pre = num;
        }
        return p;
    }
    @Test
    public void test() {
        String s = "226";
        int i = numDecodings(s);
        System.out.println(i);
    }
}
