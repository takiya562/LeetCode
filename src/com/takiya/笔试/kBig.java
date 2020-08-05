package com.takiya.笔试;

public class kBig {
    public static int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int pos = nums.length - k;
        while (l < r) {
            int cur = nums[l];
            int index = getIndex(nums, l, r);
            //System.out.println(index);
            if (index == pos)
                return cur;
            else if (index > pos)
                r = index - 1;
            else
                l = index + 1;
        }
        return nums[l];
    }
    static int getIndex (int[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp) --r;
            nums[l] = nums[r];
            while (l < r && nums[l] <= tmp)  ++l;
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.print(findKthLargest(nums, 4));
    }
}
