package com.takiya.LeetCode;

import java.util.Arrays;

public class LeetCode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] tmp = new int[len1 < len2 ? len1 : len2];
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                tmp[index++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(tmp, 0, index);
    }
}
