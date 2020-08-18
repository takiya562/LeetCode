package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode_71 {
    public String simplifyPath(String path) {
        Pattern p = Pattern.compile("(?<=/)[^/]+");
        Matcher matcher = p.matcher(path);
        ArrayDeque<String> deque = new ArrayDeque<>();
        while (matcher.find()) {
            String cur = matcher.group();
            if (cur.equals("..")) {
                if (!deque.isEmpty())
                    deque.removeLast();
            } else if (!cur.equals(".")) {
                deque.addLast(cur);
            }

        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty())
            sb.append("/");
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.removeFirst());
        }
        return sb.toString();
    }
    @Test
    public void test() {
        String s = "/..hidden";
        String s1 = simplifyPath(s);
        System.out.println(s1);
    }
}
