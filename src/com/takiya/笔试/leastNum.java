package com.takiya.笔试;

public class leastNum {
    public int solution(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            if (arr[l] == l + 1)
                l++;
            else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l])
                arr[l] = arr[--r];
            else
                swap(arr, l, arr[l] - 1);
        }
        return l + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        leastNum test = new leastNum();
        System.out.println(test.solution(new int[]{-1,1,3,4,5,8}));
    }
}
