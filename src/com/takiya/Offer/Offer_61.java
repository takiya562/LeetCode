package com.takiya.Offer;

public class Offer_61 {
    public boolean isStraight(int[] nums) {
        int max = 0, min = Integer.MAX_VALUE;
        boolean[] repeat = new boolean[14];
        for (int num : nums) {
            if (num == 0)
                continue;
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (repeat[num])
                return false;
            else
                repeat[num] = true;
        }
        return max - min + 1 <= 5;
    }
}
