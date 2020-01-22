package com.takiya;

public class LeetCode_29 {
    public static int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) break;
                temp_divisor = temp_divisor << 1;
                temp_result = temp_result << 1;
            }
            dividend -= temp_divisor;
            result += temp_result;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -result;
        }
        return result;
    }
    public static void main(String args[]) {
        int result = divide(-2147483648,-1);
        System.out.print(result);
    }
}
