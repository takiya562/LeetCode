package com.takiya.LeetCode;

public class count_of_range_sum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) return 0;
        long[] sums = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
        int ret = mergeSort(sums, 0, n, lower, upper);
        return 0;
    }

    private int mergeSort(long[] sums, int left, int right, int lower, int upper) {
        if (left == right)
            return 0;
        int mid = (left + right) >>> 1;
        int n1 = mergeSort(sums, left, mid, lower, upper);
        int n2 = mergeSort(sums, mid + 1, right, lower, upper);
        int ret = n1 + n2;
        int i = left;
        int l = mid + 1;
        int r = mid + 1;
        while (i <= mid) {
            while (l <= right && sums[l] - sums[i] < lower)
                l++;
            while (r <= right && sums[r] - sums[i] <= upper)
                r++;
            ret += r - l;
            i++;
        }
        long[] sorted = new long[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid || p2 <= right) {
            if (p1 > mid)
                sorted[p++] = sums[p2++];
            else if (p2 > right)
                sorted[p++] = sums[p1++];
            else if (sums[p1] < sums[p2])
                sorted[p++] = sums[p1++];
            else
                sorted[p++] = sums[p2++];
        }
        for (int j = 0; j < sorted.length; j++)
            sums[left + j] = sorted[j];
        return ret;
    }
}
