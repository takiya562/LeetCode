package com.takiya.LeetCode;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_3 {
//    public static int lengthOfLongestSubstring(String s) {
//        int result = 0;
//        int i = 0,j = 0;
//        int str_len = s.length();
//        char temp;
//        int temp_len = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        while(i < str_len&&(i+j) <str_len)
//        {
//            temp = s.charAt(i+j);
//            if (map.get(temp)==null)
//            {
//                map.put(s.charAt(i+j),1);
//                temp_len++;
//                j++;
//            }else if (map.get(temp)==1){
//                map.clear();
//                temp_len = 0;
//                i++;
//                j=0;
//            }
//            result = result > temp_len ? result : temp_len;
//        }
//        return result;
//    }
    public static int lengthOfLongestSubstring(String s)
    {
        int result = 0;
        int left = 0;   //窗口的左边界（出现重复字符时移动左边界，只能向左移动）
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++)
        {
            if (map.containsKey(s.charAt(i)))
            {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i-left+1);
        }
        return result;
    }
    public static void main(String args[])
    {
        int result = lengthOfLongestSubstring("tmmzuxt");
        System.out.print(String.valueOf(result));
    }
}
