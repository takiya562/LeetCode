package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class word_break_ii {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int maxLen = 0;
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
            set.add(word);
        }
        HashMap<Integer, List<String>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            List<String> parts = dp.get(i - 1);
            if (parts == null)    continue;
            for (int j = i; j <= Math.min(i + maxLen - 1, n); j++) {
                String word = s.substring(i - 1, j);
                if (set.contains(word)) {
                    List<String> list = dp.getOrDefault(j, new ArrayList<>());
                    for (String part : parts) {
                        list.add(part + " " + word);
                    }
                    if (i == 1)
                        list.add(word);
                    dp.put(j, list);
                }
            }
        }
        return dp.getOrDefault(n, new ArrayList<>());
    }

    @Test
    public void test() {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<String >() {{
           add("aaaa");
           add("aa");
           add("a");
        }};
        wordBreak(s, wordDict);
    }
}
