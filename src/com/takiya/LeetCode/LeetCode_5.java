package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Stack;

public class LeetCode_5 {
    public static String longestPalindrome(String s) {
        String result=null;
        int i, j, n,gap = s.length()-1;
        boolean is_Palindrome = true;
        if (s.length()==0)
            return "";
        while(gap>=0)
        {
            i = 0;
            j = i+gap;
            while (j<s.length()) {
                is_Palindrome = true;
                for (n = 0; n <= gap / 2; n++)
                {
                    if (s.charAt(i + n) != s.charAt(j - n)) {
                        is_Palindrome = false;
                        break;
                    }
                }
                if (is_Palindrome)
                {
                    result = s.substring(i, j+1);
                    break;
                }
                i++;
                j++;
            }
            if (is_Palindrome)
               break;
            gap--;
        }
        return result;
    }
    public static void main(String args[])
    {
        String result = longestPalindrome("babad");
        System.out.print(result);
    }
    public String longestPalindrome_2(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        int start = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i) {
            for (int j = i; j >= 0; --j) {
                if (i == j)
                    dp[j][i] = true;
                else {
                    dp[j][i] = s.charAt(i) == s.charAt(j);
                    if (i - j + 1 > 2) {
                        dp[j][i] = dp[j][i] && dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, maxLen + start);
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome_2("babad"));
    }
}
