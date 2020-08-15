package com.takiya.笔试;

import java.util.Scanner;

public class BeiKe {
    public void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        int count = 0;
        while (i < j) {
            if (chars[i] != chars[j])
                count++;
            i++;
            j--;
        }
        System.out.println(count);
    }

    public void solution2() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int res = helper2(n, m);
            System.out.println(res);
        }
    }

    private int helper2(int n, int m) {
        if (n % 2 == 0 || m % 2 == 0)
            return 2;
        for (int i = 3;; i = i + 2)
            if (m % i == 0 || n % i == 0)
                return i;
    }

    public static void solution3(int[] nums) {
        int n = nums.length;
        int l = 0;
        int min = Integer.MAX_VALUE;
        int tmp = 0;
        for (int r = 0; r < n; ++r) {
            int t2 = l;
            while (l < r && ((nums[r] ^ nums[l]) & nums[l]) == 0)
                l++;
            if (t2 != l) {
                min = Math.min(r - l + 1, min);
            }
            int t = tmp;
            tmp |= nums[r];
            if (t < tmp)
                min = r - l + 1;
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2};
        solution3(nums);
    }
}
