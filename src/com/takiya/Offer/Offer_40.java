package com.takiya.Offer;

public class Offer_40 {
    private void swap(int[] heap, int i, int j) {
        heap[i] = heap[i] + heap[j] - (heap[j] = heap[i]);
    }
    private void adjustHeap(int[] heap, int startNode) {
        int len = heap.length;
        int max = startNode;
        int left = (startNode << 1) + 1;
        int right = (startNode << 1) + 2;
        if (left < len && heap[left] > heap[max])
            max = left;
        if (right < len && heap[right] > heap[max])
            max = right;
        if (max != startNode) {
            swap(heap, startNode, max);
            adjustHeap(heap, max);
        }
    }
    private void buildHeap(int[] heap) {
        int lastNode = heap.length - 1;
        int startNode = (lastNode - 1) >> 1;
        while (startNode >= 0)
            adjustHeap(heap, startNode--);
    }
    public int[] getLeastNumbers_1(int[] arr, int k) {
        int len = arr.length;
        if (len == 0 || k == 0)   return new int[] {};
        int[] heap = new int[k];
        for (int i = 0; i < k; ++i)
            heap[i] = arr[i];
        buildHeap(heap);
        for (int i = k; i < len; ++i) {
            if (heap[0] > arr[i]) {
                heap[0] = arr[i];
                adjustHeap(heap, 0);
            }
        }
        return heap;
    }
    private int getIndex(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j <= high; ++j) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
            }
        }
        arr[high] = arr[i];
        arr[i] = pivot;
        return i;
    }
    private void partition(int[] arr, int low, int high, int k) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            int len = index - low + 1;
            if (len == k)
                return;
            else if (len > k)
                partition(arr, low, index - 1, k);
            else
                partition(arr, index + 1, high, k - len);
        }
    }
    public int[] getLeastNumbers_2(int[] arr, int k) {
        int len = arr.length;
        if (len == 0 || k == 0) return new int[] {};
        partition(arr, 0, len - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; ++i)
            res[i] = arr[i];
        return res;
    }
}
