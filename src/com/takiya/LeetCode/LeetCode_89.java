package com.takiya.LeetCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new LinkedList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(mask | ans.get(j));
            }
        }
        return ans;
    }
    @Test
    public void test() {
        List<Integer> list = grayCode(2);
        list.forEach(System.out::println);
    }
}
