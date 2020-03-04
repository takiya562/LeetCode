package com.takiya;

public class LeetCode_35 {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    public static int binarySearch(int[] nums, int target, int low, int high) {
        while (low < high) {
            int mid = (low + high)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return nums[low] >= target ? low : low+1;
    }
}
