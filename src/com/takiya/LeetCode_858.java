package com.takiya;

public class LeetCode_858 {
    public static int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        int nq = p*q/g;
        int k = nq/p;
        int np = nq*p/q;
        int n = np/p;
        int l_r = n%2;
        int h_l = k%2;
        if (l_r == 1 && h_l == 1) return 1;
        return l_r == 0 ? 2 : 0;
    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String args[]) {
        int result = mirrorReflection(3,1);
        System.out.println(result);
    }
}
