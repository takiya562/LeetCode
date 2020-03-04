package com.takiya;

import java.util.Arrays;
import java.util.Set;

public class LeetCode_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int left = 0, right = people.length-1;
        while (left <= right) {
            int weight;
            if (left != right)
                weight = people[left] + people[right];
            else
                weight = people[left];
            if (weight <= limit) {
                ++ans;
                ++left;
                --right;
            }
            else {
                --right;
                ++ans;
            }
        }
        return ans;
    }
}
