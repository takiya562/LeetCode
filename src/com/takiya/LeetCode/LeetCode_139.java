package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LeetCode_139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				String sub = s.substring(j, i);
				dp[i] = dp[i] | (dp[j] & set.contains(sub));
			}
		}
		return dp[n];
    }	
    @Test
	public void test() {
		List<String> wordDict = new ArrayList<String>(){{
			add("aaaa");
			add("aaa");
		}};
		Assert.assertTrue(wordBreak("aaaaaaa", wordDict));
	}
}