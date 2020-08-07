package com.takiya.面试金典;

import java.util.ArrayList;
import java.util.List;

public class StreamRank {
    List<Integer> list;
    public StreamRank() {
        list = new ArrayList<>();
    }

    public void track(int x) {
        int index = besect(x);
        list.add(index, x);
    }

    public int getRankOfNumber(int x) {
        return besect(x);
    }
    int besect(int x) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            int midVal = list.get(mid);
            if (midVal <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
