package com.takiya.LeetCode;


import org.junit.Test;

import java.util.*;

public class LeetCode_17 {
    String[] phone = {
            "",
            "!@#", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };
    public  List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> ans = new LinkedList<>();
        if (chars.length == 0)
            return ans;
        traceBack(ans, chars, 0);
        return ans;
    }
    private  void traceBack(List<String> ans, char[] chars, int index) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }
        int idx = chars[index] - '0';
        char tmp = chars[index];
        for (char c : phone[idx].toCharArray()) {
            chars[index] = c;
            traceBack(ans, chars, index + 1);
            chars[index] = tmp;
        }
    }

    @Test
    public void test() {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        res.stream().forEach(System.out::println);
    }
}
