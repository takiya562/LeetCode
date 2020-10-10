package com.takiya.Offer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {
    ArrayDeque<Integer> deque;
    Queue<Integer> queue;

    public MaxQueue() {
        deque = new ArrayDeque<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty())
            return -1;
        return deque.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value)    deque.removeLast();
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())    return -1;
        int val = queue.remove();
        if (!deque.isEmpty() && val == deque.peek())
            deque.removeFirst();
        return val;
    }

    public static void main(String[] args) {
        System.out.println(15E2);
    }
}
