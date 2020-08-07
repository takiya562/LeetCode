package com.takiya.LeetCode;

public class LeetCode_457 {
    private static void setZeros(int[] nums, int start) {
        int i = start;
        int j;
        int len = nums.length;
        while (true) {
            j = ((i + nums[i]) % len + len) % len;
            if (nums[j] == 0 || nums[i] * nums[j] < 0) {
                nums[i] = 0;
                break;
            }
            nums[i] = 0;
            i = j;
        }
    }
    public static boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return false;
        for (int i = 0; i < len; ++i) {
            if (nums[i] == 0)
                continue;
            int slow = i;
            int fast = i;
            while (true) {
                int last = slow;
                slow = ((slow + nums[slow]) % len + len) % len;
                if (slow == last || nums[slow] == 0 || nums[slow] * nums[last] < 0) {
                    setZeros(nums, i);
                    break;
                }
                last = fast;
                fast = ((fast + nums[fast]) % len + len) % len;
                if (fast == last || nums[fast] == 0 || nums[fast] * nums[last] < 0) {
                    setZeros(nums, i);
                    break;
                }
                last = fast;
                fast = ((fast + nums[fast]) % len + len) % len;
                if (fast == last || nums[fast] == 0 || nums[fast] * nums[last] < 0) {
                    setZeros(nums, i);
                    break;
                }
                if (slow == fast)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-3,-9};
        System.out.println(circularArrayLoop(nums));
    }
}
