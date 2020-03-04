package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        recursion(candidates, target, new ArrayList<>(), ans, sum,0);
        return ans;
    }

    public void recursion(int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans, int sum, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target)
            return;
        for (int i = index; i < candidates.length; i++) {
            int candidate = candidates[i];
            sum += candidate;
            temp.add(candidate);
            recursion(candidates, target, temp, ans, sum, i);
            sum -= candidate;
            temp.remove(temp.size()-1);
        }
    }
}
