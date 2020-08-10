package com.takiya.LeetCode;


import org.junit.Test;

public class LeetCode_424 {
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        int L = 0;
        int historyMax = 0;
        for (int R = 0; R < chars.length; ++R) {
            int index = chars[R] - 'A';
            map[index]++;
            historyMax = Math.max(map[index], historyMax);
            if (R - L + 1 > historyMax + k) {
                map[chars[L] - 'A']--;
                L++;
            }
        }
        return chars.length - L;
    }

    @Test
    public void test() {
        String s = "AABABBA";
        int k = 1;
        characterReplacement(s, 1);
    }
}
