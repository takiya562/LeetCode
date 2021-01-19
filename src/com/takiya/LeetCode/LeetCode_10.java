package com.takiya.LeetCode;

import org.junit.Assert;
import org.junit.Test;

public class LeetCode_10 {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        if (len2 != 0 && pa[0] == '*')   return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            if (pa[i - 1] == '*') {
                if (i == 2)
                    dp[0][i] = true;
                else
                    dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char c1 = sa[i - 1], c2 = pa[j - 1];
                if (c1 == c2 || c2 == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (c2 == '*') {
                    char pre = pa[j - 2];
                    if (pre == c1 || pre == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else
                        dp[i][j] = dp[i][j - 2];
                }
            }
        }
        return dp[len1][len2];
    }
    @Test
    public void test() {
        Assert.assertFalse(isMatch("aa", "a"));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));
        Assert.assertFalse(isMatch("mississippi", "mis*is*p*."));
        Assert.assertTrue(isMatch("mississippi", "mis*is*ip*."));
        Assert.assertTrue(isMatch("aaa", "a*aa"));
        Assert.assertTrue(isMatch("aaa", "a*a"));
        Assert.assertTrue(isMatch("aaa", "a*aaa"));
        Assert.assertTrue(isMatch("aaa", "ab*a*c*a"));
        Assert.assertFalse(isMatch("aaa", "ab*a"));
        Assert.assertTrue(isMatch("aaa", "ab*a*c*a"));
        Assert.assertFalse(isMatch("a", ""));
    }
}
