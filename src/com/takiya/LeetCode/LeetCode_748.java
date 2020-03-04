package com.takiya;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);

            if (c >= 65 && c <= 90)
                c += 32;

            if (c >= 97 && c <= 122) {
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                else
                    map.put(c, 1);

                count++;
            }
        }

        int minLen = 1001;
        String ans = "";
        for (String word : words) {
            int len = word.length();
            if (len < count)
                continue;
            Map<Character, Integer> temp = new HashMap<>(map);
            for (int i = 0; i < len; ++i) {
                char c = word.charAt(i);
                if (temp.containsKey(c)) {
                    int value = temp.get(c) - 1;
                    if (value == 0)
                        temp.remove(c);
                    else
                        temp.put(c, value);
                }
            }
            if (temp.size() == 0 && minLen > len) {
                minLen = len;
                ans = word;
            }
        }
        return ans;
    }

    public String shortestCompletingWord_2(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for (String word : words) {
            if ((ans.length() > word.length() || ans.length() == 0) && compare(target, count(word.toLowerCase())))
                ans = word;
        }
        return ans;
    }

    public boolean compare(int[] target, int[] count) {
        for (int i = 0; i < 26; ++i) {
            if (target[i] > count[i])
                return false;
        }
        return true;
    }

    public int[] count(String licensePlate) {
        int[] target = new int[26];
        for (char letter : licensePlate.toCharArray()) {
            int index = Character.toLowerCase(letter) - 'a';
            if (index >= 0 && index < 26)
                target[index]++;
        }
        return target;
    }
}
