package com.takiya.LeetCode;

public class LeetCode_709 {
    public String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                stringBuilder.append((char)(c + 32));
            }
            else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
