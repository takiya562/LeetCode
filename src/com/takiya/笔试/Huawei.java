package com.takiya.LeetCode;

import include.Tools;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;

public class Huawei {
	static ArrayList<ArrayList<Integer>> tree;
	static int[] ret;
	public static int[] solution(int n, int[][] edges, String labels) {
		if (n == 0)	return new int[] {};
		tree = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			int father = edge[0];
			int child = edge[1];
			tree.get(father).add(child);
		}
		ret = new int[n];
		helper(tree.get(0), labels, 0);
		return ret;
	}

	private static int helper(List<Integer> node, String labels, int index) {
		int res = 1;
		char label = labels.charAt(index);
		for (int child : node) {
			if (label == labels.charAt(child))
				res += helper(tree.get(child), labels, child);
			helper(tree.get(child), labels, child);
		}
		ret[index] = res;
		return res;
	}

	@Test
	public void test() {

		int[][] edges = Tools.stringToIntegerMatrix("[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]");
		int[] ret = solution(7, edges, "abaedcd");
		System.out.println(Tools.IntegerArrayToString(ret));
	
	}
}