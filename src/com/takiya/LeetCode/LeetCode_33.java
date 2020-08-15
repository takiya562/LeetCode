package com.takiya.LeetCode;

import java.util.ServiceLoader;

public class LeetCode_33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midVal = nums[mid];
            if (midVal == target)
                return mid;
            if (nums[0] <= midVal) {
                if (target >= nums[0] && target < midVal)
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target <= nums[n - 1] && target > midVal)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] nums = {1,3,5};
        int result = search(nums, 1);
        System.out.print(result);
    }
}
