package com.takiya;

public class LeetCode_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mods = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; ++i) {
            int mod = time[i] % 60;
            if (mod == 0)
                count += mods[0];
            else
                count += mods[60 - mod];
            mods[mod]++;
        }
        return count;
    }
}
