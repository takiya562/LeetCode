package com.takiya.LeetCode;

import org.junit.Test;

import java.util.HashSet;

public class LeetCode_904 {
    public int totalFruit(int[] tree) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        int flag = 0;
        for (;r < tree.length; ++r) {
            if (!set.contains(tree[r])) {
                int size = set.size();
                if (size == 2) {
                    max = Math.max(r - l, max);
                    l = flag;
                    set.remove(tree[flag - 1]);
                }
                set.add(tree[r]);
            }
            if (tree[r] != tree[flag])
                flag = r;
        }
        max = Math.max(r - l, max);
        return max;
    }
    @Test
    public void test() {
        int[] tree = {0,1,1,4,3};
        int res = totalFruit(tree);
        System.out.println(res);
    }
}
