package com.takiya;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78 {
    /* 递归解法 */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int len = 0; len <= nums.length; ++len)
            recursion(ans, new ArrayList<>(), nums, len, 0);
        return ans;
    }
    public static void recursion(List<List<Integer>> ans, List<Integer> item, int[] nums, int len, int index) {
        int size = item.size();
        if (len == size)
            ans.add(new ArrayList<>(item));
        else {
            for (int i = index; i < nums.length; ++i) {
                item.add(nums[i]);
                recursion(ans, item, nums, len, i + 1);
                item.remove(size);
            }
        }
    }
    /* 回溯法 */
    public static List<List<Integer>> subSetWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    public static void backTrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; ++i) {
            temp.add(nums[i]);
            backTrack(nums, ans, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /* 利用二进制（数组长度不能超过32） */
    public static List<List<Integer>> binarySet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); ++i) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            ans.add(sub);
        }
        return ans;
    }

    /* 循环枚举 */
    public List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int num : nums) {
            int size = ans.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> item = new ArrayList<>(ans.get(i));
                item.add(num);
                ans.add(item);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = subSetWithDup(nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }
}
