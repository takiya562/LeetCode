package com.takiya;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new LinkedList<>();
        char[] pat = pattern.toCharArray();
        for (String word : words) {
            HashMap<Character, Character> map = new HashMap<>();
            StringBuilder str = new StringBuilder();
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    if (!map.containsValue(pat[i])) {
                        map.put(arr[i], pat[i]);
                        str.append(pat[i]);
                    }
                    else
                        break;
                }
                else if (map.containsKey(arr[i])) {
                    char c = map.get(arr[i]);
                    str.append(c);
                }
            }
            if (str.toString().equals(pattern))
                ans.add(word);
        }
        return ans;
    }
}
