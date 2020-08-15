package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double)num);
        }
        return solve(list);
    }
    private boolean solve(List<Double> nums) {
        int size = nums.size();
        if (size == 0)
            return false;
        if (size == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                List<Double> nums2 = new ArrayList<>();
                if (j != i) {
                    for (int k = 0; k < size; ++k) {
                        if (k != i && k != j)
                            nums2.add(nums.get(k));
                    }
                    int size2 = nums2.size();
                    Set<Double> set = calculate(nums.get(i), nums.get(j));
                    for (double num : set) {
                        nums2.add(num);
                        if (solve(nums2))
                            return true;
                        nums2.remove(size2);
                    }
                }
            }
        }
        return false;
    }

    private Set<Double> calculate(double a, double b) {
        HashSet<Double> set = new HashSet<>();
        set.add(a + b);
        set.add(a - b);
        set.add(b - a);
        set.add(a * b);
        if (b != 0)
            set.add(a / b);
        if (a != 0)
            set.add(b / a);
        return set;
    }

    @Test
    public void test() {
        int[] nums = {1,2,1,2};
        judgePoint24(nums);
    }
}
