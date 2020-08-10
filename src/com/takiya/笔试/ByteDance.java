package com.takiya.笔试;

import org.junit.Test;

import java.util.Arrays;

public class ByteDance {
    class Pair implements Comparable<Pair>{
        int hi;
        int wi;
        Pair(int hi, int wi) {
            this.hi = hi;
            this.wi = wi;
        }

        @Override
        public int compareTo(Pair o) {
            if (hi == o.hi)
                return wi - o.wi;
            return hi - o.hi;
        }
    }
    public int solution1(int[] hi, int[] wi) {
        int n = hi.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i) {
            pairs[i] = new Pair(hi[i], wi[i]);
        }
        Arrays.sort(pairs);
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (pairs[j].wi < pairs[i].wi)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    @Test
    public void test1() {
        int[] hi = {1,2,4,5,6};
        int[] wi = {3,4,1,5,2};
        int res = solution1(hi, wi);
        System.out.println(res);
    }

    public int solution3(String s, int k) {
        char[] chars = s.toCharArray();
        int winMax = 0;
        int l = 0;
        int[] win = new int[26];
        for (int r = 0; r < chars.length; ++r) {
            int index = chars[r] - 'a';
            win[index]++;
            winMax = Math.max(winMax, win[index]);
            if (r - l + 1 > winMax + k) {
                win[chars[l] - 'a']--;
                l++;
            }
        }
        return chars.length - l;
    }

    @Test
    public void test2() {
        String s = "aabaabba";
        int k = 1;
        int res = solution3(s, k);
        System.out.println(res);
    }
}
