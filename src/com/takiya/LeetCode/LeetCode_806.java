package com.takiya.LeetCode;

public class LeetCode_806 {
    public int[] numberOfLines(int[] widths, String S) {
        int len = 0;
        int cur = 1;
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            len += widths[index];
            if (len > 100) {
                len = widths[index];
                cur++;
            }
        }
        return new int[]{cur, len};
    }
}
