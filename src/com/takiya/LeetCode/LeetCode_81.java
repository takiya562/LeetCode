package com.takiya.LeetCode;

import org.junit.Test;

public class LeetCode_81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return false;
        while (n > 1 && nums[n - 1] == nums[0])  n--;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int midVal = nums[mid];
            if (midVal == target)
                return true;
            if (nums[0] <= midVal) {
                if (nums[0] <= target && target < midVal)
                    r = mid - 1;
                else
                    l = mid + 1;
            } else {
                if (target <= nums[n - 1] && midVal < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return false;
    }
    @Test
    public void test() {
        int[] nums = {1,3,1,1,1};
        boolean result = search(nums, 3);
        System.out.println(result);
    }
}
