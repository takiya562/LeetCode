package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_403 {
    public static boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones)
            map.put(stone, new HashSet<>());
        map.get(0).add(0);
        int len = stones.length;
        for (int i = 0; i < len; ++i) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step))
                        map.get(stones[i] + step).add(step);
                }
            }
        }
        return map.get(stones[len - 1]).size() > 0;
    }
    public static void main(String args[]) {
        int[] stones = {0,1,3,5,6,8,12,17};
        canCross(stones);
    }
}
