package com.takiya.Offer;

import java.util.HashMap;
import java.util.Map;

public class Offer_48 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1)   return len;
        char[] chars = s.toCharArray();
        int left = 0;
        int max = 0;
        Map<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < len; ++right) {
            char c = chars[right];
            if (window.containsKey(c)) {
                max = Math.max(right - left, max);
                left = Math.max(window.get(c) + 1, left);
            }
            window.put(c, right);
        }
        max = Math.max(len - left, max);
        return max;
    }
    public static void main(String args[]) {
        String s = "tmmzuxt";
        lengthOfLongestSubstring(s);
    }
}
