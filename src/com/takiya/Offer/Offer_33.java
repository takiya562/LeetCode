package com.takiya.Offer;

import java.util.Arrays;
import java.util.Comparator;

public class Offer_33 {
    public boolean helper(int[] postorder, int low, int high, int min, int max) {
        if (low > high) return true;
        if (postorder[high] > min && postorder[high] < max) {
            int root = postorder[high];
            int temp = high;
            while (temp >= low && root <= postorder[temp]) temp--;
            return helper(postorder, low, temp, min, root) && helper(postorder, temp + 1, high - 1, root, max);
        }
        return false;
    }
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
