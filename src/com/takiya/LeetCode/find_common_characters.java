package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class find_common_characters {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            for (char c : word.toCharArray())
                freq[c - 'a']++;
            for (int i = 0; i < 26; i++)
                minFreq[i] = Math.min(minFreq[i], freq[i]);
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++)
                ans.add(String.valueOf((char)(i + 'a')));
        }
        return ans;
    }
}
