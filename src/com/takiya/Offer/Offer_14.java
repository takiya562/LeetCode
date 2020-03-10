package com.takiya.Offer;

import include.Util;

public class Offer_14 {
    public int cuttingRope(int n) {
        if (n < 4)  return n - 1;
        int m = n % 3;
        int b = n / 3;
        int a = 3;
        int c = (int)(1e9 + 7);
        long A = Util.QuickPow(a, b - 1, c);
        if (m == 0) A *= 3;
        if (m == 1) A *= 4;
        if (m == 2) A *= 6;
        return (int)(A % c);
    }
}
