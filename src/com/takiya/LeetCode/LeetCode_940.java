package com.takiya.LeetCode;

public class LeetCode_940 {
	private static final int MOD = (int)1e9 + 7;
	public int distinctSubseqII(String S) {
        int n = S.length();
        if (n == 0)	return 0;
        long[] cnts = new long[26];
        long pre = 0;
        for (char c : S.toCharArray()) {
        	long cur = pre;
        	if (cnts[c - 'a'] == 0) {
        		cur = (cur + pre + 1) % MOD;
        	} else {
        		cur = (cur + pre - cnts[c - 'a'] + 1 + MOD) % MOD;
        	}
        	cnts[c - 'a'] = (cnts[c - 'a'] + cur - pre + MOD) % MOD;
        	pre = cur % MOD;
        }
        return (int)pre;
    }
}