package com.takiya.LeetCode;

public class LeetCode_11 {
    public static int maxArea(int[] height) {
        int result = 0;
        int tempArea = 0;
        int h = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                tempArea = (right - left) * height[left];
                left++;
            }else {
                tempArea = (right - left) * height[right];
                right--;
            }
            result = tempArea > result ? tempArea : result;
        }
        return result;
    }
    public static void main(String args[]) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.print(String.valueOf(result));
    }
}
