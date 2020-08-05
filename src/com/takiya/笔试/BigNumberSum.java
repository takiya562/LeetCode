package com.takiya.笔试;

public class BigNumberSum {
    public static String Sum(String num1, String num2) {
        char sign1 = num1.charAt(0);
        char sign2 = num2.charAt(0);
        if (sign1 == '-')
            num1 = num1.substring(1);
        else
            sign1 = '+';
        if (sign2 == '-')
            num2 = num2.substring(1);
        else
            sign2 = '+';
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 >= len2 ? len1 + 1 : len2 + 1;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; ++i) {
                s1.append(0);
            }
        } else {
            for (int i = 0; i < len1 - len2; ++i) {
                s2.append(0);
            }
        }
        s1.append(num1);
        s2.append(num2);
        num1 = s1.toString();
        num2 = s2.toString();
        char[] n1 = s1.reverse().toString().toCharArray();
        char[] n2 = s2.reverse().toString().toCharArray();
        int[] result = new int[len];
        char sign = '+';
        if (sign1 == sign2) {
            sign = sign1;
            int c = 0;
            for (int i = 0; i < len - 1; ++i) {
                int cur = n1[i] - '0' + n2[i] - '0' + c;
                c = cur / 10;
                result[i] = cur % 10;
            }
            result[len - 1] = c;
        } else {
            sign = sign1;
            if (num1.compareTo(num2) < 0) {
                sign = sign2;
                char[] tmp = n1;
                n1 = n2;
                n2 = tmp;
            }
            int c = 0;
            for (int i = 0; i < len - 1; ++i) {
                int cur = n1[i] - '0' - (n2[i] - '0') - c;
                c = cur < 0 ? 1 : 0;
                result[i] = (cur % 10 + 10) % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = len - 1;
        while (result[index] == 0) index--;
        for (int i = index; i >= 0; --i)
            sb.append(result[i]);
        if (sign == '-')
            return '-' + sb.toString();
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "-29";
        System.out.print(Sum(num1, num2));
    }
}
