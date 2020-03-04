package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_205 {
    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    public boolean helper(String s, String t) {
        if (s.length() != t.length())   return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (map.containsKey(x) && map.get(x) != y)
                return false;
            else
                map.put(x, y);
        }
        return true;
    }

    public boolean isIsomorphic_2(String s, String t) {
        if (s.length() != t.length())   return false;
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (map1[x] != map2[y])
                return false;
            else {
                if (map1[x] == 0) {
                    map1[x] = i + 1;
                    map2[y] = i + 1;
                }
            }
        }
        return true;
    }
}
