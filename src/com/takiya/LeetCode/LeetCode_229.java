package com.takiya;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n == 0) return ans;
        int countA = 0, countB = 0;
        int candidateA = nums[0];
        int candidateB = nums[0];

        for (int num : nums) {
            if (num == candidateA) {
                ++countA;
                continue;
            }
            if (num == candidateB) {
                ++countB;
                continue;
            }

            if (countA == 0) {
                candidateA = num;
                ++countA;
                continue;
            }
            if (countB == 0) {
                candidateB = num;
                ++countB;
                continue;
            }

            --countA;
            --countB;
        }

        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (candidateA == num)
                ++countA;
            else if (candidateB == num)
                ++countB;
        }
        if (countA > n / 3)
            ans.add(candidateA);
        if (countB > n / 3)
            ans.add(candidateB);
        return ans;
    }
}
