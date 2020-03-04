package com.takiya;

import java.util.List;
import include.Trie;

import javax.swing.*;

public class LeetCode_648 {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String root : dict)
            trie.insert(root);
        String[] words = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        int len = words.length;
        String first = trie.partSearch(words[0]);
        builder.append(first == null ? words[0] : first);
        for (int i = 1; i < len; i++) {
            String root = trie.partSearch(words[i]);
            if (root != null)
                builder.append(" " + root);
            else
                builder.append(" " + words[i]);
        }
        return builder.toString();
    }
}
