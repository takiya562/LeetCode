package test;

import include.*;

import java.util.*;


public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int c = scan.nextInt();
        long[] bitMask = new long[n];
        long base = 1;
        for (int i = 0; i < n; ++i) {
            long bit = 0;
            int num_i = scan.nextInt();
            for (int j = 0; j < num_i; ++j) {
                int pos = scan.nextInt();
                bit |= base << (pos - 1);
            }
            bitMask[i] = bit;
        }
        int l = 0;
        long repeat = 0;
        long colored = 0;
        for (int r = 0; r < n + m - 1; ++r) {
            if (r - l + 1 > m) {
                colored ^= bitMask[l++];
            }
            repeat |= colored & bitMask[r % n];
            colored |= bitMask[r % n];
        }
        int count = 0;
        while (repeat != 0) {
            if ((repeat & 1) == 1)
                ++count;
            repeat = repeat >> 1;
        }
        System.out.print(count);
    }
}
