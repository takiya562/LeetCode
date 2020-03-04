package com.takiya.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_421 {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums)
                set.add(num & mask);
            int temp = res | (1 << i);
            for (int num : set) {
                if (set.contains(num ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
