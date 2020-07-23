package com.takiya.笔试;

import java.util.Scanner;

public class examGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] counts = new int[m][5];
        for (int i = 0; i < n; ++i) {
            String s = scanner.next();
            int index = 0;
            for (char c : s.toCharArray()) {
                counts[index++][c - 65]++;
            }
        }
        int sum = 0;
        for (int i = 0; i < m; ++i) {
            int max = 0;
            for (int j = 1; j < 5; ++j) {
                if (counts[i][j] > counts[i][max])
                    max = j;
            }
            sum += counts[i][max] * scanner.nextInt();
        }
        System.out.println(sum);
    }
}
