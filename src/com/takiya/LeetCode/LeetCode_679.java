package com.takiya.LeetCode;

import org.junit.Test;

import java.util.regex.Matcher;

public class LeetCode_679 {
    public boolean judgePoint24(int[] nums) {
        return backTrace(nums, 0);
    }

    private boolean backTrace(int[] nums, int index) {
        if (index == 4) {
            return judge(nums[0], nums[1], nums[2], nums[3]);
        }
        for (int i = index; i < 4; i++) {
            swap(nums, index, i);
            if (backTrace(nums, index + 1)) return true;
            swap(nums, index, i);
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private boolean judge(double a, double b, double c, double d) {
        return judge(a + b, c ,d) ||
                judge(a * b, c, d) ||
                judge(a / b, c, d) ||
                judge(a - b, c, d);
    }

    private boolean judge(double a, double b, double c) {
        return judge(a + b, c) ||
                judge(a * b, c) ||
                judge(a / b, c) ||
                judge(a - b, c) ||
                judge(b / a, c) ||
                judge(b - a, c) ||
                judge(a, b - c) ||
                judge(a, b * c) ||
                judge(a, b / c) ||
                judge(a, b + c);
    }

    private boolean judge(double a, double b) {
        return Math.abs(a + b - 24) < 0.001 ||
                Math.abs(a * b - 24) < 0.001 ||
                Math.abs(a / b - 24) < 0.001 ||
                Math.abs(a - b - 24) < 0.001 ||
                Math.abs(b - a - 24) < 0.001 ||
                Math.abs(b / a - 24) < 0.001;
    }

    @Test
    public void test() {
        int[] nums = {1,2,1,2};
        judgePoint24(nums);
    }
}
