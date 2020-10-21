package com.takiya.LeetCode;

public class long_pressed_name {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        if (len1 > len2)    return false;
        int index = 0;
        for (int i = 0; i < len1; i++) {
            if (index == len2)  return false;
            char c = name.charAt(i);
            if (typed.charAt(index) != c) {
                if (i == 0)
                    return false;
                else {
                    while (index < len2 && typed.charAt(index) == name.charAt(i - 1))   index++;
                    if (index == len2 || typed.charAt(index) != c)
                        return false;
                }
            }
            index++;
        }
        while (index < len2 && typed.charAt(index) == name.charAt(len1 - 1))    index++;
        return index == len2;
    }
}
