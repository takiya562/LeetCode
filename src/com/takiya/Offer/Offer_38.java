package com.takiya.Offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Offer_38 {
    List<String> ans;
    char[] chars;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        ans = new LinkedList<>();
        dfs(0);
        return ans.toArray(new String[ans.size()]);
    }
    void dfs(int index) {
        if (index == chars.length) {
            ans.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; ++i) {
            if (set.contains(chars[i]))
                continue;
            set.add(chars[i]);
            swap(i, index);
            dfs(index + 1);
            swap(i, index);
        }
    }
    void swap(int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
