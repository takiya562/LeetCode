package com.takiya;

public class LeetCode_6 {
    public static String convert_backup(String s, int numRows) {
        int len = s.length();
        StringBuffer str = new StringBuffer(len);
        int gap_down, gap_up;
        int total_gap = (numRows-1)*2;
        int index;
        if(numRows==1)
            return s;
        for (int i=1; i<=numRows; i++) {
            gap_down = (numRows-i)*2;
            gap_up = total_gap - gap_down;
            index = i-1;
            if(gap_down==0||gap_up==0){
                while(index<len) {
                    str.append(s.charAt(index));
                    index+=total_gap;
                }
            }else{
                while(index<len){
                    str.append(s.charAt(index));
                    index+=gap_down;
                    if(index<len) {
                        str.append(s.charAt(index));
                        index += gap_up;
                    }
                }
            }
        }
        return str.toString();
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuffer str = new StringBuffer();
        int gap = (numRows - 1) * 2;
        int index_1, index_2;
        for (int i = 0; i < numRows; i++) {
            if (i != 0 && i != numRows-1) {
                index_1 = i;
                index_2 = gap - i;
                while (index_1 < s.length() || index_2 < s.length()) {
                    if (index_1 < s.length()) {
                        str.append(s.charAt(index_1));
                    }
                    index_1 += gap;
                    if (index_2 < s.length()) {
                        str.append(s.charAt(index_2));
                    }
                    index_2 += gap;
                }
                continue;
            }
            index_1 = i;
            while (index_1 < s.length()) {
                str.append(s.charAt(index_1));
                index_1 += gap;
            }
        }
        return str.toString();
    }
    public static void main(String args[]) {
        String result = convert("A", 1);
        System.out.print(result);
    }
}
