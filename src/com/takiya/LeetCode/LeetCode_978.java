package com.takiya.LeetCode;

public class LeetCode_978 {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int left = 0;
        while (left < len - 1 && arr[left] == arr[left + 1]) left++;
        if (left == len - 1)    return 1;
        int pre = (arr[left + 1] - arr[left] > 0) ? 1 : 0;
        int max = 2;
        for (int right = left + 1; right < len - 1; ++right) {
            int next = (arr[right + 1] - arr[right] == 0) ? -1 : (arr[right + 1] - arr[right] > 0) ? 1 : 0;
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
