package com.takiya.LeetCode;

import java.util.*;
import java.util.zip.CheckedOutputStream;

public class LeetCode_767 {
        public static String reorganizeString(String S) {
            int N = S.length();
            int[] counts = new int[26];
            for (char c: S.toCharArray())
                counts[c-'a'] += 100;  //编码出现次数
            for (int i = 0; i < 26; ++i)
                counts[i] += i;         //编码字符
            Arrays.sort(counts);
            char[] ans = new char[N];
            int t = 1;
            for (int code: counts) {
                /* 解码过程 */
                int ct = code / 100;
                char ch = (char) ('a' + (code % 100));
                if (ct > (N+1) / 2)
                    return "";
                for (int i = 0; i < ct; ++i) {
                    if (t >= N) t = 0;
                    ans[t] = ch;
                    t += 2;
                }
            }
            return String.valueOf(ans);
        }

        public static void main(String args[]) {
            reorganizeString("ogccckcwmbmxtsbmozli");
        }
}
