package com.takiya.笔试;

import org.junit.Test;

public class reversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length < 2)    return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int mergeSort(int[] nums, int low, int high) {
        if (low == high)    return 0;
        int mid = (low + high) >>> 1;
        int left = mergeSort(nums, low, mid);
        int right = mergeSort(nums, mid + 1, high);
        if (nums[mid] <= nums[mid + 1])
            return left + right;
        return left + right + merge(nums, low, mid, high);
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int p1 = low, p2 = mid + 1;
        int[] tmp = new int[high - low + 1];
        int index = 0;
        while (p1 <= mid || p2 <= high) {
            if (p1 > mid) {
                while (p2 <= high)
                    tmp[index++] = nums[p2++];
            } else if (p2 > high) {
                while (p1 <= mid)
                    tmp[index++] = nums[p1++];
            } else if (nums[p1] <= nums[p2]) {
                tmp[index++] = nums[p1++];
            } else if (nums[p1] > nums[p2]) {
                count += mid - p1 + 1;
                tmp[index++] = nums[p2++];
            }
        }
        for (int i = 0, j = low; i < tmp.length; ++i, ++j)
            nums[j] = tmp[i];
        return count;
    }

    @Test
    public void test() {
        int[] nums = {1,3,2,3,1};
        System.out.print(reversePairs(nums));
    }
}
