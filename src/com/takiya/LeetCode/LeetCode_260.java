package com.takiya.LeetCode;

public class LeetCode_260 {
    public static int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums)    bitmask ^= num;
        /* 分离出两数的差异，diff保留了bitmask最右边的 1 */
        int diff = bitmask & (-bitmask);

        int x = 0;
        for (int num : nums) {
            if ((num & diff) != 0)
                x ^= num;
        }
        int y = bitmask ^ x;

        return new int[]{x, y};
    }
    public static void main(String args[]) {
        int[] nums = {1,2,1,3,2,5};
        singleNumber(nums);
    }
}
