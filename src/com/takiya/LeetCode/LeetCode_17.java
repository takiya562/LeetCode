package com.takiya.LeetCode;

import com.sun.source.tree.Tree;

import java.util.*;

public class LeetCode_17 {
    static Map<Character, String> map = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int max_level = digits.length();
        if (max_level == 0)
            return result;
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        String first_level_str = map.get(digits.charAt(0));
        for (int index = 0; index < first_level_str.length(); index++)
            preTravel(digits, result, "", max_level, 0, index, first_level_str);
        return result;
    }
    public static void preTravel(String digits, List<String> result, String str, int max_level, int level, int index, String level_str) {
        if (level == max_level-1) {
            str += level_str.charAt(index);
            result.add(str.toString());
        }
        else {
            str += level_str.charAt(index);
            String temp_str = map.get(digits.charAt(level+1));
            for (int i = 0; i < temp_str.length(); i++)
                preTravel(digits, result, str, max_level, level + 1, i, temp_str);
        }
    }
    public static void main(String args[]) {
        List<String> result = letterCombinations("234");
        System.out.print(result.toString());
    }
}
