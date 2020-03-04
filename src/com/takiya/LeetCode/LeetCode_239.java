package com.takiya;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        if (len == 0 || k == 0)
            return new int[0];

        int[] res = new int[len - k + 1];
        for (int i = 0; i < k; ++i) {
            if (deque.isEmpty())
                deque.offerFirst(i);
            else {
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                    deque.pollLast();
                deque.offerLast(i);
            }
        }
        res[0] = nums[deque.peekFirst()];

        for (int i = 0; i + k < len; ++i) {
            if (deque.peekFirst() == i)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i + k])
                deque.pollLast();
            deque.offerLast(i + k);
            res[i + 1] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String args[]) {
        int[] nums = {-95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22};
        maxSlidingWindow(nums, 10);
    }
}
