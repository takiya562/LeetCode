package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0)   return ans;
        ans.add(Arrays.asList(1));
        for (int i = 2; i <= numRows; ++i) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> pre = ans.get(i - 2);
            temp.add(1);
            for (int j = 1; j < i - 1; ++j)
                temp.add(pre.get(j - 1) + pre.get(j));
            temp.add(1);
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
