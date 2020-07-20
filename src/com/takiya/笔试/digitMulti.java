package com.takiya.笔试;

import org.junit.Test;

import java.util.Stack;

public class digitMulti {
    public int solution (int n) {
        // write code here
        if (n < 10) return n;
        for (int i = 9; i >= 2; i--) {
            if (n % i == 0) {
                int a = solution(n / i);
                if (a == -1)
                    return -1;
                else
                    return i + 10 * a;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int n = 100;
        System.out.print(solution(n));
    }
}
