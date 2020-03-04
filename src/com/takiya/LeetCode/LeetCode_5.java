package com.takiya.LeetCode;

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
        if (len < 2)    return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; ++i)
            dp[i][i] = true;

        int maxLen = 1;
        int start = 0;
        for (int j = 1; j < len; ++j) {
            for (int i = 0; i < j; ++i) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                else
                    dp[i][j] = false;
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (maxLen < curLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
