package com.takiya;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LeetCode_354 {
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) return 0;
        int max = 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o1[1] - o2[0] * o2[1];
            }
        });
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            int[] big = envelopes[i];
            for (int j = i - 1; j >= 0; j--) {
                int[] small = envelopes[j];
                if (big[0] > small[0] && big[1] > small[1])
                    dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        return dp[len-1];
    }
}
