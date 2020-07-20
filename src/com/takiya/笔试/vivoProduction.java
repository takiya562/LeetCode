package com.takiya.笔试;

import org.junit.Test;

public class vivoProduction {
    public int solution (int n) {
        // write code here
        int i = 1;
        while ((1 + i) * i / 2 < n)
            ++i;
        int days = (1 + i) * i / 2;
        int fullSum = i * (i + 1) * (2 * i + 1) / 6;
        return fullSum - (days - n) * i;
    }

    @Test
    public void test() {
        System.out.print(solution(11));
    }
}
