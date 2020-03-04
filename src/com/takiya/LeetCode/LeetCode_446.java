package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_446 {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0;
        Map<Integer, Integer>[] map = new Map[A.length];
        for (int i = 0; i < A.length; ++i) {
            map[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long delta = (long)A[i] - (long)A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE)
                    continue;
                int diff = (int)delta;
                int New = map[j].getOrDefault(diff, 0);
                sum += New;
                map[i].put(diff, map[i].getOrDefault(diff, 0) + New + 1);
            }
        }
        return sum;
    }
}
