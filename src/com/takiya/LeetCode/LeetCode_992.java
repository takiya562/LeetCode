package com.takiya.LeetCode;

import include.Tools;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_992 {
	public int subarraysWithKDistinct(int[] A, int K) {
		return atMostDistinct(A, K) - atMostDistinct(A, K - 1);
    }

    private int atMostDistinct(int[] A, int K) {
    	int n = A.length;
    	int[] freq = new int[n + 1];

    	int l = 0, r = 0;
    	int winCount = 0;
    	int res = 0;
    	while (r < n) {
    		if (freq[A[r]] == 0) {
    			winCount++;
    		}
    		freq[A[r]]++;
    		r++;

    		while (winCount > K) {
    			freq[A[l]]--;
    			if (freq[A[l]] == 0) {
    				winCount--;
    			}
    			l++;
    		}

    		res += r - l + 1;
    	}
    	return res;
    }
    @Test
    public void test() {
    	Assert.assertEquals(7, subarraysWithKDistinct(Tools.stringToIntegerArray("[1,2,1,2,3]"), 2));
    	Assert.assertEquals(3, subarraysWithKDistinct(Tools.stringToIntegerArray("[1,2,1,3,4]"), 3));
    }
}