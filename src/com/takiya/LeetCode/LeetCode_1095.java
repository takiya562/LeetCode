package com.takiya.LeetCode;


public class LeetCode_1095 {
    class MountainArray {
        public int get(int index) {
            return 0;
        }
        public int length(){
            return 0;
        }
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int peek = peek(mountainArr, 0, len-1);
        int left = binarySearch(target, mountainArr, 0, peek);
        int right = binarySearchReverse(target, mountainArr, peek+1, len-1);
        if (left == -1 && right == -1)
            return -1;
        if (left == -1 || right == -1)
            return left == -1 ? right : left;
        return left < right ? left : right;
    }
    public int peek (MountainArray mountainArray, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (mountainArray.get(mid) > mountainArray.get(mid + 1))
            return peek(mountainArray, l, mid);
        return peek(mountainArray, mid + 1, r);
    }
    public int binarySearch (int target, MountainArray mountainArray, int left, int right) {
        int mid = 0;
        int index = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            int temp = mountainArray.get(mid);
            if (temp < target)
                left = mid + 1;
            else if (temp > target)
                right = mid - 1;
            else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
    public int binarySearchReverse (int target, MountainArray mountainArray, int left, int right) {
        int mid = 0;
        int index = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            int temp = mountainArray.get(mid);
            if (temp < target)
                right = mid - 1;
            else if (temp > target)
                left = mid + 1;
            else {
                index = mid;
                right = mid - 1;
            }
        }
        return index;
    }
    public static void main(String args[]) {

    }
}
