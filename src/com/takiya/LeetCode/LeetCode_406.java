package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) ->{
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        List<int[]> output = new LinkedList<>();
        for (int[] p : people)
            output.add(p[1], p);
        int len = output.size();
        return output.toArray(new int[len][2]);
    }
}
