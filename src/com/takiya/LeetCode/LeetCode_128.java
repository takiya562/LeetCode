package com.takiya;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int currentNum = num;
                int currentLen = 1;
                while (set.contains(currentNum+1)) {
                    currentLen += 1;
                    currentNum += 1;
                }
                longest = Math.max(currentLen, longest);
            }
        }
        return longest;
    }
}
