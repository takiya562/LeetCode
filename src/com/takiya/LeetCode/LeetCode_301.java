package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;
import include.Tools;
import java.util.Set;
import java.util.HashSet;

public class LeetCode_301 {
	List<String> res;
	int left = 0;
	Set<String> set = new HashSet<>();
	public List<String> removeInvalidParentheses(String s) {
		char[] chars = s.toCharArray();
		int misRight = 0;
		for (char c : chars) {
			if (c == '(') {
				left++;
			} else if (c == ')') {
				if (left == 0) {
					misRight++;
				} else {
					left--;
				}
			}
		}
		int misLeft = left;
		left = 0;
		res = new ArrayList<>();
		int len = chars.length - misLeft - misRight;
		if (len == 0) {
			res.add("");
			return res;
		}
		char[] out = new char[len];
		//System.out.printf("misLeft: %d\n misRight: %d\n", misLeft, misRight);
		dfs(chars, misLeft, misRight, 0, 0, out);
		return res;
    }

    private void dfs(char[] chars, int misLeft, int misRight, int index, int pos, char[] out) {
    	if (index == chars.length) {
    		if (misLeft != 0 || misRight != 0)
    			return;
    		String s = new String(out);
    		if (!set.contains(s)) {
    			res.add(s);
    			set.add(s);
    		}
    		return;
    	}
    	char c = chars[index];
    	if (c == '(') {
    		if (misLeft > 0) {
    			dfs(chars, misLeft - 1, misRight, index + 1, pos, out);
    		}
    		if (pos < out.length) {
    			out[pos] = c;
    			left++;
    			dfs(chars, misLeft, misRight, index + 1, pos + 1, out);
    			left--;
    		}
    	} else if (c == ')') {
    		if (misRight > 0) {
    			dfs(chars, misLeft, misRight - 1, index + 1, pos, out);
    		}
    		if (left > 0 && pos < out.length) {
    			out[pos] = c;
    			left--;
    			dfs(chars, misLeft, misRight, index + 1, pos + 1, out);
    			left++;
    		}
    	} else {
    		if (pos < out.length) {
    			out[pos] = c;
    			dfs(chars, misLeft, misRight, index + 1, pos + 1, out);
    		}
    	}
    }

    @Test
    public void test() {
    	Assert.assertEquals("[(())(),()()()]", Tools.ListToString(removeInvalidParentheses("()())()")));
		Assert.assertEquals("[x]", Tools.ListToString(removeInvalidParentheses("x(")));
    }

}