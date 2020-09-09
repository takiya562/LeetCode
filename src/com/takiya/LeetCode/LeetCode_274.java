package com.takiya.LeetCode;


public class LeetCode_274 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n)
                counts[n]++;
            else
                counts[citation]++;
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += counts[i];
            if (sum == i || sum > i)
                return i;
        }
        return 0;
    }
}
