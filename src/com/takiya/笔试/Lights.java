package com.takiya.笔试;

import java.util.Scanner;

public class Lights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int[] counts = new int[l];
            int[] hopes = new int[l];
            count(counts, n, scanner);
            count(hopes, n, scanner);
            int count;
            if ((count = helper(counts, hopes, n)) == -1)
                System.out.println("impossible");
            else
                System.out.println(count);
        }
    }
    private static void count(int[] arr, int n, Scanner scanner) {
        for (int i = 0; i < n; ++i) {
            String s = scanner.next();
            int index = 0;
            for (char c : s.toCharArray()) {
                if (c == '1')
                    arr[index]++;
                index++;
            }
        }
    }

    private static int helper(int[] counts, int[] hopes, int n) {
        int l = counts.length;
        int count = 0;
        for (int i = 0; i < l; ++i) {
            if (counts[i] == hopes[i])
                continue;
            else if (n - counts[i] == hopes[i])
                count++;
            else
                return -1;
        }
        return count;
    }
}
