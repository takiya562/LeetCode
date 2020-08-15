package com.takiya.LeetCode;

import org.junit.Test;

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
            reserve(nums, i + 1, i + cur - 1);
            k -= (cur - 1) * sum;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            sb.append(num);
        return sb.toString();
    }
    private void reserve(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    @Test
    public void test() {
        String res = getPermutation(4, 19);
        System.out.print(res);
    }
}
