package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_76 {
    public static String minWindow(String s, String t) {
        int needs = t.length();
        int length = s.length();
        if (needs == 0)    return "";
        char[] chars = s.toCharArray();
        char[] mask = t.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : mask)
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        HashMap<Character, Integer> win = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int right = 0; right < length; ++right) {
            char chr = chars[right];
            if (hashMap.containsKey(chr) && hashMap.get(chr) > 0) {
                win.put(chr, win.getOrDefault(chr, 0) + 1);
                if (win.get(chr) <= hashMap.get(chr))
                    needs--;
            }
            while (needs == 0) {
                if (right - left + 1 < minLen) {
                    minIndex = left;
                    minLen = right - left + 1;
                }
                char chl = chars[left];
                if (hashMap.containsKey(chl) && hashMap.get(chl) > 0) {
                    win.put(chl, win.getOrDefault(chl, 0) - 1);
                    if (win.get(chl) < hashMap.get(chl))
                        needs++;
                }
                left++;
            }
        }
        return s.substring(minIndex, minIndex + minLen);
    }
    public static void main(String args[]) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.print(minWindow(s, t));
    }
}
