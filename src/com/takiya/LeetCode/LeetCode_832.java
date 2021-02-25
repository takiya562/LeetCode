package com.takiya.LeetCode;

import include.Tools;
import org.junit.Test;
import org.junit.Assert;

public class LeetCode_832 {
	public int[][] flipAndInvertImage(int[][] A) {
		for (int[] a : A) 
			flip(a);
		return A;
    }

    private void flip(int[] a) {
    	int r = a.length - 1;
    	int l = 0;
    	while (l < r) {
    		int tmp = a[l];
    		a[l++] = a[r] ^ 1;
    		a[r--] = tmp ^ 1;
    	}
    }

   
}