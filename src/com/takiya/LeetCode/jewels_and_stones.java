package com.takiya.LeetCode;

import org.junit.Test;

import java.util.HashSet;

public class jewels_and_stones {
    public int numJewelsInStones(String J, String S) {
        long xor = 0;
        for (char c : J.toCharArray()) {
            xor |= 1L << (c - 'A');
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            long mask = 1L << (c - 'A');
            if ((xor & mask) != 0)
                count++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }
}
