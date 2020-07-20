package com.takiya.笔试;

import java.util.Scanner;

public class reversePairsPro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int len = 1 << n;
            int[] nums = new int[len];
            for (int i = 0; i < len; ++i)
                nums[i] = scanner.nextInt();
            int[] order = new int[n + 1];
            int[] reorder = new int[n + 1];
            mergeSort(nums, 0, len - 1, n, reorder);
            reverseArray(nums);
            mergeSort(nums, 0, len - 1, n, order);
            int m = scanner.nextInt();
            for(int i = 0; i < m; ++i) {
                int cnt = 0;
                int q = scanner.nextInt();
                for (int j = 1; j <= q; ++j) {
                    swap(order, reorder, j);
                }
                for (int j = 1; j <= n; ++j) {
                    cnt += reorder[j];
                }
                System.out.println(cnt);
            }
        }
    }

    private static void mergeSort(int[] nums, int low, int high, int index, int[] cnt) {
        if (low == high)
            return;
        int mid = (low + high) >>> 1;
        mergeSort(nums, low, mid, index - 1,  cnt);
        mergeSort(nums, mid + 1, high, index - 1, cnt);
        merger(nums, low, mid, high, index, cnt);
    }

    private static void merger(int[] nums, int low, int mid, int high, int index, int[] cnt) {
        int p1 = low, p2 = mid + 1;
        int count = 0;
        while (p1 <= mid && p2 <= high) {
            if (nums[p1] <= nums[p2])
                p1++;
            else {
                count += mid - p1 + 1;
                p2++;
            }
        }
        cnt[index] += count;
    }

    private static void reverseArray(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int tmp = nums[low];
            nums[low++] = nums[high];
            nums[high--] = tmp;
        }
    }

    private static void swap(int[] order, int[] reorder, int i) {
        int tmp = order[i];
        order[i] = reorder[i];
        reorder[i] = tmp;
    }
}
