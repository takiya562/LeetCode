package test;

import include.*;

import java.util.*;


public class Test {
    private static double helper(double x, int n) {
        double A = 1;
        double T = x;
        while ((n & 1) != 0) {
            A = A * T;
            T = T * T;
            n >>= 1;
        }
        return A;
    }
    public static void main(String args[]) {
        double res = helper(2.0, 10);
        System.out.println(res);
    }
}
