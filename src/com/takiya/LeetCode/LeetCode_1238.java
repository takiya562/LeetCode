package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> gray = new ArrayList<>(List.of(0));
        int index = -1;
        for (int k = 0, add = 1 << k; k < n; k++, add = 1 << k) {
            for (int i = gray.size() - 1; i >= 0; i--) {
                if (gray.get(i) + add == start) index = gray.size();
                gray.add(gray.get(i) + add);
            }
        }
        if (start == 0) return gray;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != gray.size()) {
            ans.add(gray.get(index));
            index = (index + 1) % gray.size();
        }
        return ans;
    }
}
