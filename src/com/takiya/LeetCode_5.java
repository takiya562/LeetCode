package com.takiya;

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
}
