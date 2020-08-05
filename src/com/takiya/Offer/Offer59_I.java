package com.takiya.Offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer59_I {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new ArrayDeque<>();
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < k; ++i) {
            if (window.isEmpty())
                window.addFirst(i);
            else {
                while (!window.isEmpty() && nums[i] >= nums[window.peekLast()])
                    window.removeLast();
                window.addLast(i);
            }
        }
        ans[0] = window.peekFirst();
        for (int i = 0; i + k < len; ++i) {
            if (window.peekFirst() == i)
                window.removeFirst();
            while (!window.isEmpty() && nums[i + k] >= nums[window.peekLast()])
                window.removeLast();
            window.addLast(i + k);
            ans[i + 1] = window.peekFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }
}
