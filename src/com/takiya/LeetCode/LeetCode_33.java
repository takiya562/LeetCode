package com.takiya.LeetCode;

import java.util.ServiceLoader;

public class LeetCode_33 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        int left = 0;
        int right = nums.length-1;
        if (target < nums[left] && target > nums[right])
            return -1;
        boolean in_left = false;
        if (target > nums[left])
            in_left= true;
        while (left <= right) {
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            if (nums[left] > nums[left+1]) {
                if (in_left) return -1;
                else
                    return binarySearch(nums, left+1, right, target);
            }
            if (nums[right] < nums[right-1]) {
                if (!in_left) return -1;
                else
                    return binarySearch(nums, left, right-1, target);
            }
            left++;
            right--;
        }
        return -1;
    }
    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = (left+right)/2;
        if (target > nums[mid])
            return binarySearch(nums, mid+1, right, target);
        else if (target < nums[mid])
            return binarySearch(nums, left, mid-1, target);
        else
            return mid;
    }
    public static void main(String args[]) {
        int[] nums = {1};
        int result = search(nums, 0);
        System.out.print(result);
    }
}
