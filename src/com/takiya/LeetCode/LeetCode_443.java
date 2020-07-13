package com.takiya.LeetCode;

public class LeetCode_443 {
    public int compress(char[] chars) {
        int index = 1;
        char pre = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; ++i) {
            char cur = chars[i];
            if (cur == pre) {
                count++;
            }
            if (cur != pre || i + 1 == chars.length){
                if (count > 1) {
                    int tmp = index;
                    while (count != 0) {
                        chars[index++] = (char)((count % 10) + 48);
                        count /= 10;
                    }
                    reverse(chars, tmp, index);
                }
                count = 1;
                if (cur != pre)
                    chars[index++] = chars[i];
            }
            pre = chars[i];
        }
        return index;
    }

    public void reverse(char[] chars, int i, int j) {
        int l = i, r = j - 1;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }
}
