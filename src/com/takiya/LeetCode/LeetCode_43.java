package com.takiya.LeetCode;


import java.util.Arrays;

public class LeetCode_43 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[][] results = new int[len2][len1 + len2];
        int[] rNum1 = reverse(num1);
        int[] rNum2 = reverse(num2);
        for (int i = 0; i < len2; ++i) {
            int c = 0;
            for (int j = 0, n = i; j < len1; ++j, ++n) {
                int cur = rNum2[i] * rNum1[j] + c;
                c = cur / 10;
                results[i][n] = cur % 10;
            }
            results[i][i + len1] = c;
        }
        int[] result = new int[len1 + len2];
        int c = 0;
        for (int i = 0; i < len1 + len2; ++i) {
            result[i] = c;
            for (int j = 0; j < len2; ++j) {
                result[i] += results[j][i];
            }
            c = result[i] / 10;
            result[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        int index = len1 + len2 - 1;
        while (index >= 0 && result[index] == 0)  index--;
        for (int i = index; i >= 0; --i) {
            sb.append(result[i]);
        }
        if (index == -1)
            sb.append(0);
        return sb.toString();
    }
    private int[] reverse(String num) {
        int len = num.length();
        int[] res = new int[len];
        for (int i = len - 1, j = 0; i >= 0; --i, ++j) {
            res[j] = num.charAt(i) - 48;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_43 test = new LeetCode_43();
        String result = test.multiply("9", "9");
        System.out.println(result);
    }
}
