package com.takiya;

public class LeetCode_258 {
    public int addDigits(int num) {
        if (num == 0)   return 0;
        return (num % 9 == 0) ? 9 : num % 9;
    }
}
