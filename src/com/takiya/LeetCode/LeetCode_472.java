package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import include.Trie;


public class LeetCode_472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        List<String> ans = new LinkedList<>();
        for (String word : words)
            trie.insert(word);
        for (String word : words) {
            if (trie.search(word, 0))
                ans.add(word);
        }
        return ans;
    }
}
