package com.takiya.LeetCode;

import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    int count;

    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
    }

    public void addNum(int num) {
        count += 1;
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        if ((count & 1) != 0) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if ((count & 1) != 0) {
            return maxHeap.peek();
        }else {
            return (maxHeap.peek() + minHeap.peek()) / 2d;
        }
    }
}
