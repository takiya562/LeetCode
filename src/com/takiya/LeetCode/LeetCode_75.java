package com.takiya.LeetCode;

public class LeetCode_75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int red = 0, blue = len - 1;
        int cur = 0;
        while (cur <= blue) {
            if (nums[cur] == 0) {
                if (cur == red) {
                    cur++;
                    red++;
                } else {
                    nums[cur] = nums[red];
                    nums[red++] = 0;
                }
            } else if (nums[cur] == 2) {
                nums[cur] = nums[blue];
                nums[blue--] = 2;
            } else {
                cur++;
            }
        }
    }
}
