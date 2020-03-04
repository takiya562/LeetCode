package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode_9 {
    public static boolean isPalindrome_backup(int x) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        if (x >= 0 && x < 10)
            return true;
        if (x < 0)
            return false;
        while (x != 0) {
            stack.push(x % 10);
            queue.add(x % 10);
            x /= 10;
        }
        while (!stack.empty() && !queue.isEmpty()) {
            if (stack.pop() != queue.poll())
                return false;
        }
        return true;
    }
    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)  // x % 10 == 0这个判断很关键
            return false;
        int revertNum = 0;
        while (revertNum < x) {
            revertNum = x % 10 + revertNum * 10;
            x /= 10;
        }
        return revertNum == x || revertNum / 10 == x; //当x的长度是奇数的时候只需要判断revertNum/10和x是否相等
    }
    public static void main(String args[]) {
        if (isPalindrome(121))
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}
