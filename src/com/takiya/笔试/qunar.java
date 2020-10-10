package com.takiya.笔试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class qunar {
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        long[][] dp = new long[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int k = 0; k < j; k++)
                    dp[i][j] += dp[i - 1][k];
            }
        }
        long sum = 0;
        for (int i = 0; i < m; i++)
            sum += dp[n - 1][i];
        System.out.println(sum);
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[] map = new int[26];
        int idx = 0;
        for (String s : s1.split("\\s+")) {
            int index = s.charAt(0) - 'a';
            map[index] = idx++;
        }
        int[] nums = new int[n];
        idx = 0;
        for (String s : s2.split("\\s+")) {
            nums[idx++] = map[s.charAt(0) - 'a'];
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }

    static class Pair {
        char type;
        int num;

        Pair(char type, int num) {
            this.type = type;
            this.num = num;
        }
    }
    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] cards = new String[n];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
           put('J', 11);
           put('Q', 12);
           put('K', 13);
           put('A', 1);
        }};
        HashMap<Character, Integer> typeMap = new HashMap<Character, Integer>() {{
            put('S', 0);
            put('H', 1);
            put('C', 2);
            put('D', 3);
        }};
        int[] typeCounts = new int[4];
        int Tmax = 1;
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.next();
            typeCounts[typeMap.get(cards[i].charAt(0))]++;
            Tmax = Math.max(Tmax, typeCounts[typeMap.get(cards[i].charAt(0))]);
        }
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            String s = cards[i];
            char type = s.charAt(0);
            String num = s.substring(1);
            int len = num.length();
            if (len == 1) {
                if (Character.isUpperCase(num.charAt(0))) {
                    pairs[i] = new Pair(type, map.get(num.charAt(0)));
                }
                if (Character.isDigit(num.charAt(0))) {
                    pairs[i] = new Pair(type, Integer.parseInt(num));
                }
            }
            if (len == 2) {
                pairs[i] = new Pair(type, Integer.parseInt(num));
            }
        }
        Arrays.sort(pairs, (pair1, pair2) -> {
            if (pair1.num == pair2.num)
                return pair1.type - pair2.type;
            return pair1.num - pair2.num;
        });
        
    }

    public static void main(String[] args) {
        System.out.println("S10".substring(1));
    }
}
