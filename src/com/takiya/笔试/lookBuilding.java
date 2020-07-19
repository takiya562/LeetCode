package com.takiya.笔试;

import java.util.Scanner;
import java.util.Stack;

public class lookBuilding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] buildings = new int[n];
            for (int i = 0; i < n; ++i) {
                buildings[i] = scanner.nextInt();
            }
            look(buildings);
        }
    }

    public static void look(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int len = heights.length;
        int[] right = new int[len];
        int[] left = new int[len];
        for (int i = 0; i < len; ++i) {
            left[i] = stack.size();
            while (!stack.isEmpty() && stack.peek() <= heights[i]) stack.pop();
            stack.push(heights[i]);
        }
        while (!stack.isEmpty())    stack.pop();
        for (int i = len - 1; i >= 0; --i) {
            right[i] = stack.size();
            while (!stack.isEmpty() && stack.peek() <= heights[i])  stack.pop();
            stack.push(heights[i]);
        }
        for (int i = 0; i < len - 1; ++i)
            System.out.print(left[i] + right[i] + 1 + " ");
        System.out.print(left[len - 1] + right[len - 1] + 1);
    }
}
