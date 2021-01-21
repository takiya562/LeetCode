package com.takiya.LeetCode;

import include.Tools;
import org.junit.Assert;
import org.junit.Test;


public class LeetCode_628 {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n < 3)  return 0;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }

            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    @Test
    public void test() {
        Assert.assertEquals(6, maximumProduct(Tools.stringToIntegerArray("[1,2,3]")));
        Assert.assertEquals(24, maximumProduct(Tools.stringToIntegerArray("[1,2,3,4]")));
        Assert.assertEquals(-6, maximumProduct(Tools.stringToIntegerArray("[-1,-2,-3]")));
    }
}
