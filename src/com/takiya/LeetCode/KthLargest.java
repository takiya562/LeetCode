package com.takiya.LeetCode;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int i = 0; i < k && i < nums.length; ++i) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
