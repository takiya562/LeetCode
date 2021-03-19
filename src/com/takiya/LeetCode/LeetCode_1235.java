package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Map;
import java.util.HashMap;
import java.awt.List;
import java.util.ArrayList;

public class LeetCode_1235 {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = 0;
		Map<Integer, List<Integer>> end2Start = new HashMap<>();
		Map<Integer, List<Integer>> end2Pro = new HashMap<>();
		for (int i = 0; i < endTime.length; i++) {
			int end = endTime[i];
			n = Math.max(end, n);
			List<Integer> pro
		}
		int[] dp = new int[n + 1];
		for (int i = 1; i < dp.length; i++) {

		}
		return 0;
    }
}