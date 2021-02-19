package com.takiya.LeetCode;

import org.junit.Test;
import org.junit.Assert;
import java.util.Stack;

public class LeetCode_394 {
	public String decodeString(String s) {
		int n = s.length();
		if (n == 0)	return "";
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < n) {
			char c = s.charAt(i);
			if (c == ']') {
				StringBuilder str = new StringBuilder();
				while (!stack.peek().equals("[")) {
					str.insert(0, stack.pop());
				}
				stack.pop();
				String part = str.toString();
				int repeat = Integer.parseInt(stack.pop());
				StringBuilder strs = new StringBuilder();
				for (int k = 0; k < repeat; k++) {
					strs.append(part);
				}
				stack.push(strs.toString());
				i++;
			} else if (Character.isDigit(c)) {
				int start = i;
				while (Character.isDigit(c)) {
					c = s.charAt(++i);
				}
				stack.push(s.substring(start, i));
			} else if (c == '[') {
				i++;
				stack.push("[");
			} else if (Character.isLetter(c)) {
				int start = i;
				while (i < n && Character.isLetter(s.charAt(i))){
					i++;
				}
				stack.push(s.substring(start, i));
			}
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.insert(0, stack.pop());
		}
		return res.toString();
    }

    @Test
    public void test() {
    	Assert.assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    	Assert.assertEquals("accaccacc", decodeString("3[a2[c]]"));
    	Assert.assertEquals("aaaaaaaaaabcbc", decodeString("10[a]2[bc]"));
    	Assert.assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    }
}