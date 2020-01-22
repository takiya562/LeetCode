package com.takiya;

public class LeetCode_925 {
    public static boolean isLongPressedName(String name, String typed) {
        int len = typed.length();
        int end = name.length();
        int index = 0;
        char last = '#';
        for (int i = 0; i < len; i++) {
            if (index == end)
                break;
            char t = typed.charAt(i);
            char c = name.charAt(index);
            if (t != c && t != last)
                break;
            if (t == c)
                index++;
            last = t;
        }
        return index == end ? true : false;
    }
    public static void main(String args[]) {
        isLongPressedName("alex", "aaleex");
    }
}
