package com.takiya.LeetCode;

public class LeetCode_540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (mid % 2 == 0) {
                if (nums[mid] != nums[mid + 1]) {
                    r = mid;
                } else {
                    l = mid + 2;
                }
            } else {
                if (nums[mid] != nums[mid - 1]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        LeetCode_540 test = new LeetCode_540();
        System.out.println(test.singleNonDuplicate(nums));
    }
}
