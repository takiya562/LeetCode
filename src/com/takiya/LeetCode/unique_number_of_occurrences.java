package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class unique_number_of_occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int count : map.values()) {
            if (set.contains(count))
                return false;
            set.add(count);
        }
        return true;
    }
}
