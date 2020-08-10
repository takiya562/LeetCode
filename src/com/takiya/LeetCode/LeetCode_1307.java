package com.takiya.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_1307 {
    int[] carry;
    boolean[] used;
    HashMap<Character, Integer> map;
    HashSet<Character> lead;
    public boolean isSolvable(String[] words, String result) {
        int len = words.length;
        int rLen = result.length();
        map = new HashMap<>();
        lead = new HashSet<>();
        for (int i = 0;i < len; ++i) {
            if (words[i].length() > rLen)
                return false;
            lead.add(words[i].charAt(0));
            words[i] = reverseAndMark(words[i]);
        }
        lead.add(result.charAt(0));
        result = reverseAndMark(result);
        carry = new int[rLen + 1];
        used = new boolean[10];

        return dfs(words, result, 0, 0, rLen);
    }
    private boolean dfs(String[] words, String result, int col, int row, int len) {
        if (col == len)
            return carry[col] == 0;
        if (row < words.length) {
            int numLen = words[row].length();
            if (col >= numLen || map.get(words[row].charAt(col)) != -1)
                return dfs(words, result, col, row + 1, len);
            else {
                char cur = words[row].charAt(col);
                int i = lead.contains(cur) ? 1 : 0;
                for (; i < 10; ++i) {
                    if (!used[i]) {
                        used[i] = true;
                        map.put(cur, i);
                        boolean check = dfs(words, result, col, row + 1, len);
                        map.put(cur, -1);
                        used[i] = false;
                        if (check)
                            return true;
                    }
                }
                return false;
            }
        } else {
            int sum = carry[col];
            for (String word : words) {
                if (word.length() > col)
                    sum += map.get(word.charAt(col));
            }
            carry[col + 1] = sum / 10;
            sum %= 10;
            char cur = result.charAt(col);
            if (map.get(cur) == sum)
                return dfs(words, result, col + 1, 0, len);
            else if (map.get(cur) == -1 && !used[sum] && !(lead.contains(cur) && sum == 0)) {
                used[sum] = true;
                map.put(cur, sum);
                boolean check = dfs(words, result, col + 1, 0, len);
                map.put(cur, -1);
                used[sum] = false;
                return check;
            } else {
                return false;
            }
        }
    }

    private String reverseAndMark(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            map.put(chars[l], -1);
            map.put(chars[r], -1);
            char tmp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = tmp;
        }
        map.put(chars[l], -1);
        return String.valueOf(chars);
    }

    @Test
    public void test() {
        String[] words = {"THAT","IS","WHY","IT","IS"};
        String result = "TRUE";
        boolean res = isSolvable(words, result);
        System.out.println(res);
    }



    @Test
    public void testReverse() {
        map = new HashMap<>();
        String res = reverseAndMark("SEND");
        System.out.println(res);
    }
}
