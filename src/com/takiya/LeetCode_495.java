package com.takiya;

public class LeetCode_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonTime = 0;
        int end = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (end <= timeSeries[i])
                poisonTime += duration;
            else
                poisonTime += timeSeries[i] - timeSeries[i-1];
            end = timeSeries[i] + duration;
        }
        return poisonTime;
    }
}
