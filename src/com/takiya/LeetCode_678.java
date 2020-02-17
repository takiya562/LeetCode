package com.takiya;

public class LeetCode_678 {
    public boolean checkValidString(String s) {
        int L = 0, H = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                L++;
                H++;
            }
            if (c == ')') {
                if (L > 0)  L--;
                if (H > 0)
                    H--;
                else
                    return false;
            }
            if (c == '*') {
                if (L > 0)  L--;
                H++;
            }
        }
        return L == 0;
    }
}
