package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Arrays;

public class LeetCode_1631 {
	int[] dirs = {-1, 0, 1, 0, -1};
	public int minimumEffortPath(int[][] heights) {
		int r = heights.length;
		if (r == 0)	
			return 0;
		int c = heights[0].length;
		int[][] dp = new int[r][c];
		for (int[] array : dp) {
			Arrays.fill(array, Integer.MAX_VALUE);
		}
		Queue<helper> queue = new PriorityQueue<>(Comparator.comparingInt((h) -> (h.max)));
		queue.add(new helper(0, 0, 0));
		while (!queue.isEmpty()) {
			helper cur = queue.remove();
			if (cur.r == r - 1 && cur.c == c - 1) {
				dp[r - 1][c - 1] = Math.min(dp[r - 1][c - 1], cur.max);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int ni = cur.r + dirs[i], nj = cur.c + dirs[i + 1];
				if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
					int diff = Math.abs(heights[cur.r][cur.c] - heights[ni][nj]);
					int max = Math.max(diff, cur.max);
					if (max < dp[ni][nj]) {
						dp[ni][nj] = max;
						queue.add(new helper(ni, nj, max));
					}
				}
			}
		}
		return dp[r - 1][c - 1];
    }

    class helper {
    	int r;
    	int c;
    	int max;

    	helper(int r, int c, int max) {
    		this.r = r;
    		this.c = c;
    		this.max = max;
    	}
    }

    @Test
    public void test() {
    	Assert.assertEquals(2, minimumEffortPath(Tools.stringToIntegerMatrix("[[1,2,2],[3,8,2],[5,3,5]]")));
    	Assert.assertEquals(1, minimumEffortPath(Tools.stringToIntegerMatrix("[[1,2,3],[3,8,4],[5,3,5]]")));
    	Assert.assertEquals(0, minimumEffortPath(Tools.stringToIntegerMatrix("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]")));


    }
}