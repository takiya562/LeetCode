package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class partition_labels {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        List<Integer> ans = new ArrayList<>();
        if (n == 0)
            return ans;
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            map[c - 'a'] = Math.max(map[c - 'a'], i);
        }
        int last = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            last = Math.max(last, map[c - 'a']);
            if (last == i) {
                ans.add(i - prev + 1);
                prev = i + 1;
            }
        }
        return ans;
    }
}
