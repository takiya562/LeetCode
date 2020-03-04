package com.takiya;

public class LeetCode_693 {
    public static boolean hasAlternatingBits_1(int n) {
        if (n == 0) return true;
        int right = n & (-n);
        n >>= 1;
        while (n != 0) {
            int ver = (right == 1) ? 2 : 1;
            right = n & (-n);
            if (ver != right)
                return false;
            n >>= 1;
        }
        return true;
    }

    public boolean hasAlternatingBits_2(int n) {
        while (n != 0) {
            int last = n % 2;
            n >>= 1;
            int rest_last = n % 2;
            if (last == rest_last)
                return false;
        }
        return true;
    }
}
