package com.takiya;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(n, k, new ArrayList<>(), ans, 1);
        return ans;
    }
    public void recursion(int n, int k, List<Integer> temp, List<List<Integer>> ans, int index) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            recursion(n, k, temp, ans, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
