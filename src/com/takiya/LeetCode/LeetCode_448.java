package com.takiya.LeetCode;

import java.util.List;
import java.util.ArrayList;
import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		List<Integer> ans = new ArrayList<>();
		if (n == 0)	return ans;
		for (int i = 0; i < n; i++) {
			int k = nums[i];
			while (k != nums[k - 1]) {
				int tmp = nums[k - 1];
				nums[k - 1] = k;
				k = tmp;
			}
		}
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				ans.add(i + 1);
			}
		}
		return ans;
    }

    @Test
    public void test() {
    	Assert.assertEquals("[5,6]", Tools.ListToString(findDisappearedNumbers(Tools.stringToIntegerArray("[4,3,2,7,8,2,3,1]"))));
    }
}