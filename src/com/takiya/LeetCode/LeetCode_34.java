package com.takiya.LeetCode;

public class LeetCode_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] {-1, -1};
        int l = bisect_left(nums, target);
        if (l == -1)
            return new int[] {-1, -1};
        int r = bisect_right(nums, target);
        return new int[] {l, r - 1};
    }
    private int bisect_left(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int midVal = nums[mid];
            if (midVal >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == t ? l : -1;
    }
    private int bisect_right(int[] nums, int t) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int midVal = nums[mid];
            if (midVal <= t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
