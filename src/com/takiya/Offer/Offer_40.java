package com.takiya.Offer;

import org.junit.Test;

import java.util.Arrays;

public class Offer_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        return helper(arr, 0, arr.length - 1, k);
    }
    private int[] helper(int[] arr, int low, int high, int k) {
        if (low > high)
            return arr;
        int tmp = arr[low];
        int l = low, r = high;
        while (l < r) {
            while (l < r && arr[r] >= tmp)  r--;
            arr[l] = arr[r];
            while (l < r && arr[l] < tmp)   l++;
            arr[r] = arr[l];
        }
        arr[l] = tmp;
        if (l == k)
            return Arrays.copyOfRange(arr, 0, l);
        else if (l < k)
            return helper(arr, l + 1, high, k);
        else
            return helper(arr, low, l - 1, k);
    }
    @Test
    public void test() {
        int[] arr = {3,2,1};
        int[] leastNumbers = getLeastNumbers(arr, 1);
        Arrays.stream(leastNumbers).forEach(x -> System.out.print(x + " "));
    }
}
