package com.takiya.笔试;

import java.util.Scanner;

public class I360 {
    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] states = new int[n + 1];
        int r1 = 0;
        int r2 = 0;
        int first = -1;
        int last = -1;
        while (m-- != 0) {
            int id = scanner.nextInt();
            int state = scanner.nextInt();
            if (state == 1) {
                r1++;
                states[id] |= 1;
                if (first == -1)
                    first = id;
            } else {
                if (states[id] != 1)
                    r2++;
                else
                    r1--;
                states[id] |= 2;
                last = id;
            }
        }
        if (r2 == 0) states[first] = 0;
        if (r1 == 0) states[last] = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (states[i] == 0)
                sb.append(i).append(" ");
        }
        String res = sb.toString();
        res = res.substring(0, res.length() - 1);
        System.out.println(res);
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (helper(s))
                System.out.println("Ok");
            else
                System.out.println("Irregular password");
        }
    }
    private static boolean helper(String s) {
        int n = s.length();
        if (n < 8)  return false;
        int flag = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                flag |= 1;
            } else if (Character.isUpperCase(c)) {
                flag |= 2;
            } else if (Character.isLowerCase(c)) {
                flag |= 4;
            } else {
                flag |= 8;
            }
        }
        return flag == 15;
    }
    public static void main(String[] args) {
        String s = "3 ";
        System.out.println(s.substring(0, s.length() - 1));
    }
}
