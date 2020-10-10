package com.takiya.面试金典;

public class missing_two_lcci {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int bitMask = 0;
        for (int i = 1; i <= n; i++)
            bitMask ^= i;
        for (int num : nums)
            bitMask ^= num;
        int diff = bitMask & (-bitMask);
        int x = 0;
        for (int i = 1; i <=n; i++) {
            if ((diff & i) != 0)
                x ^= i;
        }
        for (int num : nums) {
            if ((diff & num) != 0)
                x ^= num;
        }
        int y = bitMask ^ x;
        return new int[] {x, y};
    }
}
