package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_119 {
	public List<Integer> getRow(int rowIndex) {
		if (rowIndex == 0) {
			return new ArrayList<Integer>() {{
				add(1);
			}};
		}
		if (rowIndex == 1) {
			return new ArrayList<Integer>() {{
				add(1);
				add(1);
			}};
		}
		ArrayDeque<Integer> q = new ArrayDeque<Integer>() {{
			addLast(1);
			addLast(1);
		}};
		for (int i = 2; i <= rowIndex; i++) {
			int size = q.size();
			for (int j = 0; j < size - 1; j++) {
				int cur =  q.removeFirst();
				q.addLast(cur + q.peekFirst());
			}
			q.removeFirst();
			q.addFirst(1);
			q.addLast(1);
		}
		List<Integer> res = new ArrayList<>();
		while (!q.isEmpty()) {
			res.add(q.removeFirst());
		}
		return res;
    }

    @Test
    public void test() {
    	Assert.assertEquals("[1,3,3,1]", Tools.ListToString(getRow(3)));
    	Assert.assertEquals("[1]", Tools.ListToString(getRow(0)));
    	Assert.assertEquals("[1,1]", Tools.ListToString(getRow(1)));
    }
}