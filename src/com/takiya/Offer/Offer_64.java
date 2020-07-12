package com.takiya.Offer;

public class Offer_64 {
    public int sumNums(int n) {
        boolean b = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }
}

