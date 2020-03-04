package com.takiya.LeetCode;

public class LeetCode_38 {
    public static String countAndSay(int n) {
        int count = 0;
        StringBuilder result = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            String currentStr = new String(result);
            result.delete(0, result.length());
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if (c == currentChar)
                    count ++;
                else {
                    result.append((char)('0'+ count));
                    result.append(currentChar);
                    currentChar = c;
                    count = 1;
                }
            }
            result.append((char)('0'+count));
            result.append(currentChar);
            count = 0;
        }
        return result.toString();
    }
    public static void main(String args[]) {
        String result = countAndSay(4);
        System.out.println(result);
    }
}
