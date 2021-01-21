package com.takiya.LeetCode;

import include.Tools;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class LeetCode_84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                right[index] = i;
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            right[index] = n;
        }
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, (right[i] - left[i]) * heights[i]);
        return max;
    }

    @Test
    public void test() {
        Assert.assertEquals(10, largestRectangleArea(Tools.stringToIntegerArray("[2,1,5,6,2,3]")));
        Assert.assertEquals(4, largestRectangleArea(Tools.stringToIntegerArray("[2,4]")));
        Assert.assertEquals(2, largestRectangleArea(Tools.stringToIntegerArray("[2]")));
        Assert.assertEquals(0, largestRectangleArea(Tools.stringToIntegerArray("[]")));
        Assert.assertEquals(2, largestRectangleArea(Tools.stringToIntegerArray("[1,1]")));
        Assert.assertEquals(2, largestRectangleArea(Tools.stringToIntegerArray("[2,0,2]")));
        Assert.assertEquals(3, largestRectangleArea(Tools.stringToIntegerArray("[2,1,2]")));
        Assert.assertEquals(4, largestRectangleArea(Tools.stringToIntegerArray("[1,2,2]")));
        Assert.assertEquals(9, largestRectangleArea(Tools.stringToIntegerArray("[1,2,3,4,5]")));
    }
}

