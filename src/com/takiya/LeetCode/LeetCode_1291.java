package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        int l = getNumLength(low);
        int h = getNumLength(high);
        List<Integer> ans = new LinkedList<>();
        int mask = quickPow(10, l - 1);
        for (int n = l; n <= h; ++n) {
            int first = low / mask;
            int last = Math.min(high / mask, 9 - n + 1);
            for (int base = first; base <= last; ++base) {
                int num = generate(base, n - 1);
                if (num >= low && num <= high)
                    ans.add(num);
            }
            mask *= 10;
            low = mask;
        }
        return ans;
    }
    int getNumLength(int num) {
        return (int)(Math.log10(num) + 1);
    }
    int quickPow(int a, int b) {
        long A = 1;
        long T = a;
        while (b != 0) {
            if ((b & 1) == 1)
                A = (A * T);
            T = (T * T);
            b >>= 1;
        }
        return (int)A;
    }
    int generate(int base, int n) {
        int res = 0;
        for (int i = n, j = base; i >= 0; --i, ++j) {
            res += quickPow(10, i) * j;
        }
        return res;
    }
}
