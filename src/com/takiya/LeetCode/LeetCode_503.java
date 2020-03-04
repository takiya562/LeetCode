package com.takiya;

import java.util.Stack;

public class LeetCode_503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 2 * len - 1; i >= 0; --i) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % len])
                stack.pop();
            ans[i % len] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.push(i % len);
        }
        return ans;
    }
}
