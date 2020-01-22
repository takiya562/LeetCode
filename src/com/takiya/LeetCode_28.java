package com.takiya;

public class LeetCode_28 {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals("") && needle.equals(""))
            return 0;
        if (needle.equals(""))
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int hay_index = 0;
        while (hay_index < haystack.length()) {
            if (haystack.charAt(hay_index) == needle.charAt(0)) {
                int j = 1;
                int i = hay_index+1;
                while (i < haystack.length() && j < needle.length()) {
                    if (haystack.charAt(i) == needle.charAt(j)) {
                        i++;
                        j++;
                    }
                    else break;
                }
                if (j == needle.length()) return hay_index;
                else if (i == haystack.length()) return -1;
            }
            hay_index++;
        }
        return -1;
    }
    public static void main(String args[]) {
        int result = strStr("mississippi","issip");
        System.out.print(result);
    }
}
