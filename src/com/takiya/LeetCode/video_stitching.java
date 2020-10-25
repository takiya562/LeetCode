package com.takiya.LeetCode;

import org.junit.Test;

import java.util.Arrays;

public class video_stitching {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) return 0;
        int[] maxN = new int[T];
        int last = 0, res = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T)
                maxN[clip[0]] = Math.max(maxN[clip[0]], clip[1]);
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxN[i]);
            if (i == last)
                return -1;
            if (pre == i) {
                res++;
                pre = last;
            }
        }
        return res;
    }
    @Test
    public void test() {
        int[][] clips = {{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}};
        int i = videoStitching(clips, 9);
        System.out.println(i);
    }
}
