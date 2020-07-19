package com.takiya.笔试;

import java.util.Scanner;

public class softDrink {
    static int[] arr = {0, 0, 0, 1, 1, 2, 2, 3, 3, 4};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(change(n));
        }
    }
    public static int change(int n) {
        if (n == 2) return 1;
        if (n == 1) return 0;
        int c = n / 3;
        int r = n % 3;
        return change(c + r) + c;
    }
}
