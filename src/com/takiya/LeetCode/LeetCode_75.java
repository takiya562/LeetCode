package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return;
        int red = 0, blue = n - 1;
        int index = 0;
        while (index <= blue) {
            int cur = nums[index];
            if (cur == 0) {
                if (index == red) {
                    index++;
                    red++;
                } else {
                    nums[index] = nums[red];
                    nums[red++] = 0;
                }
            } else if (cur == 2) {
                if (index == blue) {
                    index++;
                    blue--;
                } else {
                    nums[index] = nums[blue];
                    nums[blue--] = 2;
                }
            } else {
                index++;
            }
        }
    }
    @Test
    public void test() {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
