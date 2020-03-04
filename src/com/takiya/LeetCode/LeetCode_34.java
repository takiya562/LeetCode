package com.takiya.LeetCode;

public class LeetCode_34 {
    /*
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        int left = binarySearchAlter(nums, target, true);
        if (left == nums.length || nums[left] != target)
            return result;
        int right = binarySearchAlter(nums, target, false);
        result[0] = left;
        result[1] = right-1;
        return result;
    }
    public static int binarySearchAlter(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low+high)/2;
            if (nums[mid] > target || (left && nums[mid] == target))
                high = mid;
            else
                low = mid+1;
        }
        return low;
    }
    */
    public static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid-1;
            else if (nums[mid] < target)
                left = mid+1;
        }
        return -1;
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int first;
        if ((first = binarySearch(nums, target, 0, nums.length-1)) != -1) {
            int prev = first;
            int post = first;
            int last_prev=prev, last_post=post;
            while (prev != -1) {
                last_prev = prev;
                prev = binarySearch(nums, target, 0, prev-1);
            }
            while (post != -1) {
                last_post = post;
                post = binarySearch(nums, target, post+1, nums.length-1);
            }
            return new int[]{last_prev, last_post};
        }
        return new int[]{-1, -1};
    }
    public static void main(String args[]) {
        int[] nums = {5,7,7,8,8,10};
        int[] result = searchRange(nums, 8);
       // int result = binarySearch(nums, 0 ,nums.length-1, 8);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
