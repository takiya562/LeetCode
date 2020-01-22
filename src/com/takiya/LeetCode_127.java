package com.takiya;
import java.util.*;

public class LeetCode_127 {
    class Pair {
        String str;
        int level;

        Pair(String node, int level) {
            this.str = node;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word-> {
                    for (int i = 0; i < len; i++) {
                        String newWord = word.substring(0, i) + "*" + word.substring(i+1, len);
                        ArrayList<String> combo = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        combo.add(word);
                        allComboDict.put(newWord, combo);
                    }
                }
        );
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));
        Set<String> searched = new HashSet<>();
        while(!Q.isEmpty()) {
            Pair node = Q.remove();
            int level = node.level;
            String str = node.str;
            for (int i = 0; i < len; i++) {
                String newWord = str.substring(0, i) + "*" + str.substring(i+1, len);
                for (String nearWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (!searched.contains(nearWord)) {
                        if (nearWord.equals(endWord))
                            return level + 1;
                        searched.add(nearWord);
                        Q.add(new Pair(nearWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}
