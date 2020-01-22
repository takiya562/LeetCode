package com.takiya;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_7 {
    public static int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE + 1)
            return 0;
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean is_minus = false;
        int n = -1;
        while (x != 0) {
            n++;
            if (x < 0) {
                is_minus = true;
                x = Math.abs(x);
            }
            queue.add(x % 10);
            x = x / 10;
        }
        while (!queue.isEmpty()) {
            result += queue.poll() * Math.pow(10, n);
            n--;
        }
        result = is_minus ? -result : result;
        if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE + 1)
            return 0;
        return result;
    }

    public static void main(String args[]) {
        int result = reverse(-120);
        System.out.print(String.valueOf(result));
    }
}
