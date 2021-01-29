package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_1000 {
	public int mergeStones(int[] stones, int K) {
        
        return 0;
    }

    @Test
    public void test() {
    	Assert.assertEquals(20, mergeStones(Tools.stringToIntegerArray("[3,2,4,1]"), 2));
        Assert.assertEquals(25, mergeStones(Tools.stringToIntegerArray("[3,5,1,2,6]"), 3));
    }
}