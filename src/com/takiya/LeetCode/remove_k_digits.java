package com.takiya.LeetCode;

import java.util.ArrayDeque;

public class remove_k_digits {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n <= k)
            return "0";
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && deque.peekLast() > c && k > 0) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        while (k != 0) {
            deque.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty() && deque.peekFirst() == '0')
            deque.removeFirst();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        String s = sb.toString();
        return s.equals("") ? "0" : s;
    }
}
