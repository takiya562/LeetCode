package com.takiya.面试金典;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if (n == 0)
            return ans;
        traceBack(ans, new char[n * 2], 0, 0, 0, n);
        return ans;
    }
    private void traceBack(List<String> ans, char[] chars, int index, int left, int right, int n) {
        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }
        if (left < n) {
            chars[index] = '(';
            traceBack(ans, chars, index + 1, left + 1, right, n);
        }
        if (left > right) {
            chars[index] = ')';
            traceBack(ans, chars, index + 1, left, right + 1, n);
        }
    }
    @Test
    public void test() {
        List<String> list = generateParenthesis(1);
        list.forEach(System.out::println);
    }
}
