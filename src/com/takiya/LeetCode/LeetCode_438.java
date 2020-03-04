package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_438 {
    private boolean helper (int[] map, int[] window, char[] mask) {
        for (char c : mask) {
            if (map[c - 'a'] != window[c - 'a'])
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams_2(String s, String p) {
        int[] map = new int[26];
        char[] mask = p.toCharArray();
        for (char c : mask)
            map[c - 'a']++;
        char[] chars = s.toCharArray();
        int[] window = new int[26];
        int left = 0;
        int len = s.length();
        int maxWin = p.length();
        List<Integer> ans = new ArrayList<>();
        for (int right = 0; right < len; ++right) {
            window[chars[right] - 'a']++;
            if (map[chars[right] - 'a'] == 0)
                while (left <= right) window[chars[left++] - 'a']--;
            if (right - left + 1 == maxWin) {
                if (helper(map, window, mask))
                    ans.add(left);
                window[chars[left++] - 'a']--;
            }
        }
        return ans;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        for (char c : p.toCharArray())
            map[c - 'a']++;
        int[] window = new int[26];
        int needs = p.length();
        int length = needs;
        int left = 0;
        List<Integer> ans = new ArrayList<>();
        for (int right = 0; right < len; ++right) {
            int chr = chars[right] -'a';
            if (map[chr] > 0) {
                window[chr]++;
                if (window[chr] <= map[chr])
                    needs--;
            }
            while (needs == 0) {
                if (right - left + 1 == length)
                    ans.add(left);
                int chl = chars[left] - 'a';
                if (map[chl] > 0) {
                    window[chl]--;
                    if (window[chl] < map[chl])
                        needs++;
                }
                left++;
            }
        }
        return ans;
    }
}
