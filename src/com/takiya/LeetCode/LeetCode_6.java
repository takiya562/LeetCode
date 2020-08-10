package com.takiya.LeetCode;

import java.util.ArrayList;

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
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); ++i)
            list.add(new StringBuilder());
        boolean goDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            StringBuilder sb = list.get(curRow);
            sb.append(c);
            if (curRow == 0 || curRow == numRows - 1) goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list)
            res.append(sb.toString());
        return res.toString();
    }
    public static void main(String args[]) {
        String result = convert("PAYPALISHIRING", 3);
        System.out.print(result);
    }
}
