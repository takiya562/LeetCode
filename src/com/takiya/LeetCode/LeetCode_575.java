package com.takiya;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies)
            set.add(candy);
        int size = set.size();
        return size > candies.length / 2 ?  candies.length / 2 : size;
    }
}
