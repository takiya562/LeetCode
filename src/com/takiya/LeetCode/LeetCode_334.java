package com.takiya.LeetCode;

public class LeetCode_334 {
    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3)   return false;
        int[] tails = new int[3];
        int next = 0;
        for (int num : nums) {
            int L = 0, R = next;
            while (L < R) {
                int mid = (L + R) / 2;
                if (num > tails[mid])
                    L = mid + 1;
                else
                    R = mid;
            }
            tails[L] = num;
            if (R == next)  next++;
            if (next == 3)  return true;
        }
        return false;
    }
    public static void main(String args[]) {
        int[] nums = {2,5,3,4,5};
        increasingTriplet(nums);
    }
}
