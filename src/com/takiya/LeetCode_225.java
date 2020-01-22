package com.takiya;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_225 {
    class MyStack {

        Queue<Integer> Q1;
        Queue<Integer> Q2;

        /** Initialize your data structure here. */
        public MyStack() {
            Q1 = new LinkedList<>();
            Q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Q2.add(x);
            while (!Q1.isEmpty())
                Q2.add(Q1.remove());
            Queue<Integer> temp = Q1;
            Q1 = Q2;
            Q2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return Q1.remove();
        }

        /** Get the top element. */
        public int top() {
            return Q1.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return Q1.isEmpty();
        }
    }
}
