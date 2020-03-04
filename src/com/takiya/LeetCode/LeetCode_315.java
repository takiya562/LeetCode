package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_315 {
    int[] index;
    int[] count;
    int[] temp;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        if (len == 0)   return ans;
        index = new int[len];
        count = new int[len];
        temp = new int[len];

        for (int i = 0; i < len; ++i)
            index[i] = i;
        mergeAndCountSmaller(nums, 0, len - 1);

        for (int i = 0; i < len; ++i)
            ans.add(count[i]);

        return ans;
    }

    public void mergeAndCountSmaller(int[] nums, int L, int R) {
        if (L == R) return;
        int mid = (L + R) / 2;
        mergeAndCountSmaller(nums, L, mid);
        mergeAndCountSmaller(nums, mid + 1, R);
        if (nums[index[mid]] > nums[index[mid + 1]]) {
            mergeTwoSorted(nums, L, mid, R);
        }
    }

    public void mergeTwoSorted(int[] nums, int L, int mid, int R) {
        int i = L;
        int j = mid + 1;
        for (int n = L; n <= R; ++n)
            temp[n] = index[n];

        for (int k = L; k <= R; ++k) {
            if (i > mid) {
                index[k] = temp[j];
                ++j;
            }
            else if (j > R) {
                index[k] = temp[i];
                ++i;
                count[index[k]] += (j - mid - 1);
            }
            else if (nums[temp[i]] <= nums[temp[j]]) {
                index[k] = temp[i];
                ++i;
                count[index[k]] += (j - mid - 1);
            }
            else {
                index[k] = temp[j];
                ++j;
            }
        }
    }
}
