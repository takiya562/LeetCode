package com.takiya.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_90 {
    /* 循环迭代 */
    public List<List<Integer>> enumerate(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int start = 1;          //记录上一次的新解从哪里开始
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < len; ++i) {
            List<List<Integer>> ans_temp = new ArrayList<>();
            for (int j = 0; j < ans.size(); ++j) {
                if (i > 0 && nums[i] == nums[i-1] && j < start)
                    continue;
                List<Integer> item = new ArrayList<>(ans.get(j));
                item.add(nums[i]);
                ans_temp.add(item);
            }
            start = ans.size();
            ans.addAll(ans_temp);
        }
        return ans;
    }

    /* 回溯 */
    public static List<List<Integer>> subSetWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), ans, 0);
        return ans;
    }
    public static void backTrack(int[] nums, List<Integer> temp, List<List<Integer>> ans, int index) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            backTrack(nums, temp, ans, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String args[]) {
        int[] nums = {1,2,2};
        subSetWithDup(nums);
    }
}
