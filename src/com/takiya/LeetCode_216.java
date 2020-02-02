package com.takiya;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        recursion(ans, new ArrayList<>(), 1, k, n, 0);
        return ans;
    }

    public void recursion(List<List<Integer>> ans, List<Integer> temp, int index, int k, int n, int sum) {
        int size = temp.size();
        if (sum > n || size > k) return;

        if (sum == n && size == k) ans.add(new ArrayList<>(temp));

        for (int i = index; i <= 9; ++i) {
            temp.add(i);
            recursion(ans, temp, i + 1, k, n, sum + i);
            temp.remove(size);
        }
    }
}
