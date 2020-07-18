package com.takiya.LeetCode;

public class LeetCode_440 {
    public int findKthNumber(int n, int k) {
        int pos = 1;    //表示当前第几个数字
        int num = 1;
        while (pos < k) {
            int count = getCount(num, n);
            if (pos + count - 1 < k) {
                num++;
                pos += count;
            } else if (pos + count - 1 >= k) {
                num *= 10;
                pos++;
            }
        }
        return num;
    }

    public int getCount(int prefix, int n) {
        long cur = prefix;
        long next = cur + 1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
