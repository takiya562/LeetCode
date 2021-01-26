package com.takiya.LeetCode;

import org.junit.Test;
import org.junit.Assert;
import java.util.Stack;
import include.Tools;

public class LeetCode_85 {
	public int maximalRectangle(char[][] matrix) {
		int r = matrix.length;
		if (r == 0)	return 0;
		int c = matrix[0].length;
		int[][] histograms = new int[r][c];
		for (int i = 0; i < c; i++) {
			int height = 0;
			for (int j = 0; j < r; j++) {
				if (matrix[j][i] == '0'){
					height = 0;
					histograms[j][i] = 0;
				} else {
					height++;
					histograms[j][i] = height;
				}
			}
		}
		//System.out.println(Tools.IntegerMatrixToString(histograms));
		int max = 0;
		for (int i = 0; i < r; i++) {
			max = Math.max(max, largestRectangle(histograms[i]));
		}
		return max;
    }

    private int largestRectangle(int[] histogram) {
    	Stack<Integer> stack = new Stack<>();
    	int n = histogram.length;
    	int[] right = new int[n];
    	int[] left = new int[n];
    	for (int i = 0; i < n; i++) {
    		while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]) {
    			int index = stack.pop();
    			right[index] = i;
    		}
    		left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
    		stack.push(i);
    	}
    	while (!stack.isEmpty()) {
    		int index = stack.pop();
    		right[index] = n;
    	}
    	int max = 0;
    	for (int i = 0; i < n; i++) {
    		max = Math.max(max, histogram[i] * (right[i] - left[i]));
    	}
    	return max;
    }

    @Test
    public void test() {
    	Assert.assertEquals(6, 
    		maximalRectangle(Tools.stringToCharMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]")));
    	Assert.assertEquals(0, maximalRectangle(Tools.stringToCharMatrix("[]")));    	    	Assert.assertEquals(0, maximalRectangle(Tools.stringToCharMatrix("[]")));
    	Assert.assertEquals(0, maximalRectangle(Tools.stringToCharMatrix("[[\"0\"]]")));
    	Assert.assertEquals(1, maximalRectangle(Tools.stringToCharMatrix("[[\"1\"]]")));
    	Assert.assertEquals(0, maximalRectangle(Tools.stringToCharMatrix("[[\"0\",\"0\"]]")));
    	Assert.assertEquals(1, maximalRectangle(Tools.stringToCharMatrix("[[\"0\",\"1\"],[\"1\",\"0\"]]")));
    }
}