package com.takiya.LeetCode;

public class LeetCode_1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] s = croakOfFrogs.toCharArray();
        int len = s.length;
        if (len % 5 != 0)   return -1;
        int k = 0, a = 0, o = 0, r = 0, c = 0;
        int ans = 1;
        int tmp = 0;
        while (k < len) {
            while (k < len && s[k] != 'k') {
                if (s[k++] == 'c')  tmp++;
            }
            if (k == len)   return -1;
            while (a < k && s[a] != 'a') a++;
            if (a == k) return -1;
            while (o < a && s[o] != 'o') o++;
            if (o == a) return -1;
            while (r < o && s[r] != 'r') r++;
            if (r == o) return -1;
            while (c < r && s[c] != 'c') c++;
            if (c == r) return -1;
            a++;
            o++;
            r++;
            c++;
            k++;
            ans = Math.max(ans, tmp);
            tmp--;
        }
        return ans;
    }
}
