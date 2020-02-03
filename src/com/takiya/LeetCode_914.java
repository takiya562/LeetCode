package com.takiya;

import java.util.Arrays;

public class LeetCode_914 {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) return false;
        Arrays.sort(deck);
        int index = 0;
        while (index < deck.length && deck[index] == deck[0]) ++index;
        if (index == 1) return false;

        int min = index;
        for (int i = index; i < deck.length; ++i) {
            if (deck[i] != deck[index]) {
                int len = i - index;
                int gcd = gcd(len, min);
                if (gcd == 1)
                    return false;
                else {
                    index = i;
                    min = Math.min(min, gcd);
                }
            }
        }
        int len = deck.length - index;
        if (gcd(len, min) == 1)
            return false;
        return true;
    }

    public static int gcd(int a, int b) {
        return (a == 0 ? b : gcd(b % a, a));
    }

    public static void main(String args[]) {
        int[] deck = {1,1,1,1,2,2,2,2,2,2};
        hasGroupsSizeX(deck);
    }
}
