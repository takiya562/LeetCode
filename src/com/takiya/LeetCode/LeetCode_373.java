package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> ((nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]])));
        List<List<Integer>> ans = new ArrayList<>();
        if (n1 == 0 || n2 == 0 || k == 0) return ans;
        for (int i = 0; i < n1; ++i) queue.offer(new int[]{i, 0});

        while (!queue.isEmpty() && k > 0) {
            int[] pair = queue.poll();
            if (pair[1] + 1 < n2) queue.offer(new int[]{pair[0], pair[1]+1});
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pair[0]]);
            list.add(nums2[pair[1]]);
            ans.add(list);
            k--;
        }
        return ans;
    }

}
