package com.takiya.Offer;

import java.util.ArrayList;

public class Offer_57 {
    public int[][] findContinuousSequence(int target) {
        int left = 0;
        int sum = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int right = 1; right <= target / 2 + 1; ++right) {
            sum += right;
            while (sum > target) {
                left++;
                sum -= left;
            }
            if (sum == target) {
                ArrayList<Integer> item = new ArrayList<>();
                for (int i = left + 1; i <= right; ++i)
                    item.add(i);
                list.add(item);
                left++;
                sum -= left;
            }
        }
        int size = list.size();
        int[][] ans = new int[size][];
        for (int i = 0; i < size; ++i) {
            ArrayList<Integer> item = list.get(i);
            ans[i] = new int[item.size()];
            for (int j = 0; j < item.size(); ++j)
                ans[i][j] = item.get(j);
        }
        return ans;
    }
}
