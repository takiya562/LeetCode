package com.takiya.LeetCode;

import org.junit.Test;
import org.junit.Assert;
import include.Tools;
import java.util.Map;
import java.util.HashMap;

public class LeetCode_1128 {
	public int numEquivDominoPairs(int[][] dominoes) {
		int n = dominoes.length;
		if (n == 0)	return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] dominoe : dominoes) {
			int i = dominoe[0] < dominoe[1] ? dominoe[0] : dominoe[1];
			int j = dominoe[0] < dominoe[1] ? dominoe[1] : dominoe[0];
			int key = (i << 4) + j;
			//System.out.println("" + i + "," + j + "," + key);
			int count = map.getOrDefault(key, 0);
			map.put(key, count + 1);
		}
		int result = 0;
		for (int value : map.values()) {
			result += (value - 1) * value / 2;
		}
		return result;
    }

    @Test
    public void test() {
    	Assert.assertEquals(
    		1, numEquivDominoPairs(Tools.stringToIntegerMatrix("[[1,2],[2,1],[3,4],[5,6]]"))
    		);
    	Assert.assertEquals(11, 
    		numEquivDominoPairs(Tools.stringToIntegerMatrix("[[2,1],[5,4],[3,7],[6,2],[4,4],[1,8],[9,6],[5,3],[7,4],[1,9],[1,1],[6,6],[9,6],[1,3],[9,7],[4,7],[5,1],[6,5],[1,6],[6,1],[1,8],[7,2],[2,4],[1,6],[3,1],[3,9],[3,7],[9,1],[1,9],[8,9]]")));
    }
}