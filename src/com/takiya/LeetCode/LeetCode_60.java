package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode_60 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        int sum = 1;
        for (int i = 1; i <= n; ++i) {
            sum *= i;
            nums[i - 1] = i;
        }
        for (int i = 0; i < n; ++i) {
            if (k == 1)
                break;
            sum /= n - i;
            int cur;
            if (k % sum == 0)
                cur = k / sum;
            else
                cur = k / sum + 1;
            swap(nums, i, i + cur - 1);
            move(nums, i + cur - 1, i + 1);
            k -= (cur - 1) * sum;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            sb.append(num);
        return sb.toString();
    }
    private void move(int[] nums, int i, int j) {
        if (i < j)
            return;
        int tmp = nums[i];
        for (int n = i - 1; n >= j; n--)
            nums[n + 1] = nums[n];
        nums[j] = tmp;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    @Test
    public void test() {
        String res = getPermutation(3, 2);
        System.out.print(res);
    }
    @Test
    public void testMove() {
        int[] nums = {4,2,3,1};
        move(nums, 3, 1);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
}
