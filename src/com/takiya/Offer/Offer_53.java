package com.takiya.Offer;

public class Offer_53 {
    public int bisect_left(int[] nums, int key) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int midValue = nums[mid];
            if (midValue >= key)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    public int bisect_right(int[] nums, int key) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int midValue = nums[mid];
            if (midValue > key)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)   return 0;
        int left = bisect_left(nums, target);
        int right = bisect_right(nums, target);
        return right - left;
    }
}
