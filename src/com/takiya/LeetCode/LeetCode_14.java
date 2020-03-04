package com.takiya.LeetCode;

public class LeetCode_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        StringBuilder result = new StringBuilder();
        int index = 0;
        int i;
        while (true) {
            for (i = 0; i < strs.length-1; i++) {
                if (strs[i].equals("") || strs[i+1].equals(""))
                    return "";
                if (strs[i].length()-1 < index || strs[i+1].length()-1 < index)
                    break;
                if (strs[i].charAt(index) != strs[i+1].charAt(index))
                    break;
            }
            if (i != strs.length-1)
                break;
            result.append(strs[0].charAt(index));
            index++;
        }
        return result.toString();
    }
    public static void main(String args[]) {
        String[] strs = {"c","c"} ;
        String result = longestCommonPrefix(strs);
        System.out.print(result);
    }
}
