package com.takiya.LeetCode;

import org.junit.Test;

import java.util.*;

public class queue_reconstruction_by_height {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        if (n == 0) return new int[][] {};
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0])
                return p1[1] - p2[1];
            return p1[0] - p2[0];
        });
        int[][] result = new int[n][2];
        HashSet<Integer> set = new HashSet<>();
        result[people[0][1]] = people[0];
        set.add(people[0][1]);
        int index = 1;
        int pre = people[0][0];
        int count = 1;
        int left = 0;
        while (left < n && set.contains(left)) left++;
        while (index < n) {
            int[] p = people[index++];
            int i;
            if (pre == p[0]) {
                count++;
                i = left + p[1] - count;
            } else {
                i = left + p[1];
                count = 1;
                pre = p[0];
            }
            while (i < n && set.contains(i))    i++;
            result[i] = p;
            set.add(i);
            while (left < n && set.contains(left))    left++;
        }
        return result;
    }

    @Test
    public void test() {
        int[][] people = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}};
        reconstructQueue(people);
    }
}
