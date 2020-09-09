package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        if (k == 0)
            return ans;
        traceBack(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }
    private void traceBack(List<List<Integer>> ans, List<Integer> list, int index, int k, int n) {
        int size = list.size();
        if (size == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            traceBack(ans, list, i + 1, k, n);
            list.remove(size);
        }
    }
    @Test
    public void test() {
        List<List<Integer>> combine = combine(4, 2);
        combine.forEach(x -> {
            for (int i : x)
                System.out.print(i + " ");
            System.out.println();
        });
    }
}
