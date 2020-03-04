package com.takiya.LeetCode;

public class LeetCode_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int k;
        isOdd = (len % 2 == 1) ? true : false;
        k = len / 2;
        int k1 = 0, k2 = 0;
        int t = 1;
        while (t != k) {
            int m1 = (len1 - k1) / 2;
            int m2 = (len2 - k2) / 2;
            if (nums1[m1] <= nums2[m2]) {
                t += m1 - k1;
                k1 = m1;
            }
            else {
                t += m2 - k2;
                k2 = m2;
            }
        }
        if (isOdd)
            return nums1[k1] > nums2[k2] ? nums1[k1] : nums2[k2];
        else {
            int a1 = nums1[k1] <= nums2[k2] ? nums1[k1++] : nums2[k2++];
            int a2;
            if (k1 >= len1 || k2 >= len2)
                a2 = k1 >= len1 ? nums2[k2] : nums1[k1];
            else
                a2 = nums1[k1] <= nums2[k2] ? nums1[k1++] : nums2[k2++];
            return (double)(a1 + a2) / 2;
        }
    }
    public static void main(String args[]) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        findMedianSortedArrays(nums1, nums2);
    }
}
