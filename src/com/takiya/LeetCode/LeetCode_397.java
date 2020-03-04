package com.takiya;

public class LeetCode_397 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE)
            return 32;
        int count = 0;
        while (n != 1) {
            count++;
            if (n % 2 == 0) n /= 2;
            else {
                if (n == 3) n--;
                else {
                    if (n % 4 == 3) n += 1;
                    else if (n % 4 == 1) n -= 1;
                }
            }
        }
        return count;
    }
}
