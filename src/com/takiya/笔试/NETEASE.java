package com.takiya.笔试;

import org.junit.Test;

public class NETEASE {
    /**
     * 网易8.8笔试第三题
     * 给一个整数序列，问最少丢弃和为多少的元素能够讲序列均分成两份。
     */
    int sum = 0;
    int min = Integer.MAX_VALUE;
    public int solution1(int[] nums) {
        for (int num : nums)
            sum += num;
        helper1(nums, 0, 0, 0);
        return min;
    }
    void helper1(int[] nums, int index, int p1, int p2) {
        if (index == nums.length) {
            if (p1 == p2)
                min = Math.min(min, sum - 2 * p1);
            return;
        }
        int num = nums[index];
        //丢弃
        helper1(nums, index + 1, p1, p2);
        //分在第一个堆里
        helper1(nums, index + 1, p1 + num, p2);
        //分在第二堆里
        helper1(nums, index + 1, p1, p2 + num);
    }

    @Test
    public void test1() {
        int[] nums = {30, 15, 5, 30, 60};
        System.out.println(solution1(nums));
    }
}
