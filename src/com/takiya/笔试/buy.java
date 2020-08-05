package com.takiya.笔试;

import java.util.Scanner;

public class buy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] counts = new int[5];
        for (int i = 0; i < counts.length; ++i)
            counts[i] = scanner.nextInt();
        int target = scanner.nextInt();
        int[] moneys = {1, 5, 10, 50, 100};
        int index = 4;
        int ret = 0;
        while (target != 0 && index != -1) {
            while (moneys[index] <= target && counts[index] > 0) {
                target -= moneys[index];
                counts[index]--;
                ret++;
            }
            index--;
        }
        System.out.println(ret);
    }
}
