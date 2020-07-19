package com.takiya.笔试;

import java.util.Scanner;

public class sequenceSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        if (L == 1)
            System.out.println(N);
        for (int i = L; i <= 100; ++i) {
            int tmp = 2 * N + i - i * i;
            if (tmp % (2 * i) == 0) {
                int start = tmp / (2 * i);
                for (int j = start; j < start + i - 1; j++) {
                    System.out.print(j + " ");
                }
                System.out.print(start + i - 1);
                return;
            }
        }
        System.out.print("No");
    }
}
