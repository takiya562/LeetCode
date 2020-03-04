package com.takiya;

public class LeetCode_540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            if (left == right)
                return nums[left];
            int mid = (left + right) / 2;
            if (mid % 2 != 0) {
                if (nums[mid] != nums[mid-1])
                    right = mid - 1;        //结果只会出现在奇数位上，所以这里取mid-1
                else if (nums[mid] == nums[mid-1])
                    left = mid + 1;
            }
            else if (mid % 2 == 0) {
                if (nums[mid] != nums[mid+1])
                    right = mid;            //可能该奇数位就是结果，所以取mid
                else if (nums[mid] == nums[mid+1])
                    left = mid + 2;
            }
        }
        return 0;                       //并不会到这里
    }
}
