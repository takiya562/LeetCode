package com.takiya;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_646 {
    public static int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = dp[i-1];
            int j = i-1;
            while (j >= 0 && pairs[j][1] >= pairs[i][0]) j--;
            if (j >= 0) dp[i] = Math.max(1+dp[j], dp[i]);
        }
        return dp[pairs.length-1];
    }
    public static void main(String args[]) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        int result = findLongestChain(pairs);
        System.out.println(result);
    }
}
