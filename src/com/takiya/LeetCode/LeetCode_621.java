package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LeetCode_621 {
	private static final long POS = 0xffffffff << 32;
	private static final long MASK = 0xffffffff;
	public int leastInterval(char[] tasks, int n) {
		int m = tasks.length;
		if (n == 0)	return m;
		int[] cnts = new int[26];
		for (char task : tasks) {
			int index = task - 'A';
			cnts[index]++;
		}
		PriorityQueue<Long> prior = new PriorityQueue<>((i, j) -> ((j & MASK) - (i & MASK)));
		for (int i = 0; i < 26; i++) {
			int cnt = cnts[i];
			prior.add((i << 32) + cnt);
		}
		int state = 0;
		int res = 0;
		int scheduled = 0;
		Queue<Long> q = new LinkedList<>();
		while (scheduled < m) {
			if (!q.isEmpty()) {
				long item = q.peek();
				int pos = (int)((item & POS) >> 32);
				if (pos == res) {
					state ^= (int)(item & MASK);
					q.remove();
				}
			}
			for (int index : priority) {
				if (cnts[index] == 0)
					continue;
				int mask = 1 << index;
				if ((state & mask) == 0) {
					scheduled++;
					cnts[index]--;
					state |= mask;
					long item = ((long)res + n + 1 << 32) + mask;
					q.add(item);
					break;
				}
			}
			res++;
		}
		return res;
    }

    @Test
    public void test() {
    	char[] tasks = Tools.stringToCharArray("[\"A\",\"A\",\"A\",\"B\",\"B\",\"B\"]");
    	Assert.assertEquals(8, leastInterval(tasks, 2));
    	tasks = Tools.stringToCharArray("[\"A\",\"A\",\"A\",\"A\",\"A\",\"A\",\"B\",\"C\",\"D\",\"E\",\"F\",\"G\"]");
    	Assert.assertEquals(16, leastInterval(tasks, 2));
    	tasks = Tools.stringToCharArray("[\"A\",\"A\",\"A\",\"B\",\"B\",\"B\",\"C\",\"C\",\"C\",\"D\",\"D\",\"E\"]");
    	Assert.assertEquals(12, leastInterval(tasks, 2));
    }
}