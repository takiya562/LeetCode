package com.takiya.extra;

public class BigFactorial {
    private static double PI = 3.141592654;
    private static double E = 2.71828182846;
    private static int MASK = 10000;

    private static int lenEstimate(int n) {
        if (n > 3) {
            return (int)(Math.log10(2 * PI * n) / 2 + n * Math.log10(n / E) + 1);
        }
        return 1;
    }

    public static String Fac(int n) {
        int l = lenEstimate(n);
        int len = l % 4 == 0 ? (l / 4) : (l/ 4 + 1);
        short[] array = new short[len];
        array[0] = 1;
        int cur = 1;
        for (int i = 1; i <= n; ++i) {
            int c = 0;
            for (int j = 0; j < cur; ++j) {
                int prod = array[j] * i + c;
                array[j] = (short)(prod % MASK);
                c = prod / MASK;
            }
            while (c > 0) {
                array[cur++] = (short)(c % MASK);
                c /= MASK;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int index = cur - 1; index >= 0; index--) {
            sb.append(array[index]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Fac(1000));
    }
}
