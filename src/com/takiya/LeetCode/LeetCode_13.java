package com.takiya;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_13 {
    public static int romanToInt(String s) {
        int result = 0;
        int i = s.length()-1;
        int last = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        while (i >= 0) {
            if (map.get(s.charAt(i)) >= last)
                result += map.get(s.charAt(i));
            else
                result -=map.get(s.charAt(i));
            last = map.get(s.charAt(i));
            i--;
        }
        return result;
    }
    public static void main(String args[]) {
        int result = romanToInt("IX");
        System.out.print(String.valueOf(result));
    }
}
