package com.takiya.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        search(ans, new ArrayList<>(), target, candidates, 0, n);
        return ans;
    }

    public void search(List<List<Integer>> ans, List<Integer> list, int target, int[] candidates, int low, int high) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (low == high || target < candidates[low])
            return;
        int pre = -1;
        int size = list.size();
        for (int i = low; i < high; ++i) {
            if (pre == candidates[i])
                continue;
            list.add(candidates[i]);
            search(ans, list, target - candidates[i], candidates, i + 1, high);
            list.remove(size);
            pre = candidates[i];
        }
    }
    @Test
    public void test() {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = combinationSum2(candidates, target);
        ans.stream().forEach(System.out::println);
    }
}
