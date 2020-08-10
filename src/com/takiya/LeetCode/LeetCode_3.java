package com.takiya.LeetCode;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_3 {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int r = 0; r < chars.length; ++r) {
            char cur = chars[r];
            if (map.containsKey(cur)) {
                max = Math.max(max, r - l);
                l = Math.max(l, map.get(cur) + 1);
            }
            map.put(cur, r);
        }
        max = Math.max(max, chars.length - l);
        return max;
    }
    public static void main(String args[])
    {
        int result = lengthOfLongestSubstring("tmmzuxt");
        System.out.print(String.valueOf(result));
    }
}
