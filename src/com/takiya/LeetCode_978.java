package com.takiya;

public class LeetCode_978 {
    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        int left = 0;
        while (left < len - 1 && A[left] == A[left + 1]) left++;
        if (left == len - 1)    return 1;
        int pre = (A[left + 1] - A[left] > 0) ? 1 : 0;
        int max = 2;
        for (int right = left + 1; right < len - 1; ++right) {
            int next = (A[right + 1] - A[right] == 0) ? -1 : (A[right + 1] - A[right] > 0) ? 1 : 0;
            if ((pre ^ next) != 1) {
                max = Math.max(max, right - left + 1);
                left = right;
            }
            pre = next;
        }
        max = Math.max(len - left, max);
        return max;
    }
}
