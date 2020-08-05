package com.takiya.笔试;

public class divideNum {
    static StringBuilder sb = new StringBuilder();
    public static String solution(int num) {
        if (num == 1)
            return "1";
        helper(num);
        return sb.toString();
    }
    static void helper(int num) {
        if (num == 1)
            return;
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                sb.append(i + " * ");
                helper(num / i);
                return;
            }
        }
        sb.append(num);
        return;
    }

    public static void main(String[] args) {
        System.out.print(solution(1024));
    }
}
