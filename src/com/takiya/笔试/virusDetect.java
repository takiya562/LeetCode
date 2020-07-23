package com.takiya.笔试;

import java.util.Scanner;

public class virusDetect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int k = scanner.nextInt();
            String s = scanner.next();
            detectVirus(s, k);
        }
    }

    public static void detectVirus(String s, int k) {
        int len = s.length();
        if (len == 0 || k > len) {
            System.out.println(0);
            return;
        }
        int[][] dp = new int[len + 1][len];
        char[] chars = s.toCharArray();
        long count = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '1')
                dp[1][i] = 1;
            if (dp[1][i] == k)
                count++;
        }
        for (int i = 2; i <= len; ++i) {
            for (int j = 0; j <= len - i; ++j) {
                dp[i][j] = dp[i - 1][j + 1] + dp[1][j];
                if (dp[i][j] == k)
                    count++;
            }
        }
        System.out.println(count);
    }
}
