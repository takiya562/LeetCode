package com.takiya.LeetCode;

public class LeetCode_440 {
    public static int findKthNumber(int n, int k) {
        int pos = 1;
        int num = 1;
        while (pos < k) {
            int count = count(num, n);
            if (pos + count >= k) {
                num *= 10;
                pos++;
            } else {
                num++;
                pos += (count + 1);
            }
        }
        return num;
    }
    static int count(int prefix, int n) {
        long cur = prefix;
        long next = cur + 1;
        int count = 0;
        while (cur * 10 <=  n) {
            cur *= 10;
            next *= 10;
            count += Math.min(next, n + 1) - cur;
        }
        return count;
    }

    public static void main(String[] args) {
        findKthNumber(681692778, 351251360);
    }
}
