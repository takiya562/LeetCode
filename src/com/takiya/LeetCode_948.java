package com.takiya;

import java.util.Arrays;

public class LeetCode_948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        int max = 0;
        int point = 0;
        Arrays.sort(tokens);
        int L = 0, R = tokens.length - 1;
        while (point >= 0 && L <= R) {
            if (P < tokens[L]) {
                P += tokens[R];
                R--;
                point--;
            }
            else {
                P -= tokens[L];
                L++;
                point++;
            }
            max = Math.max(point, max);
        }
        return max;
    }
}
