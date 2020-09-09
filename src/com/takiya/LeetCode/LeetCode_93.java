package com.takiya.LeetCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_93 {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> ans = new LinkedList<>();
        if (len > 12 || len < 4)
            return ans;
        backTrace(ans, new int[3], 0, 0, s, len);
        return ans;
    }
    private void backTrace(List<String> ans, int[] positions, int pos, int index, String s, int len) {
        if (pos == positions.length) {
            int last = Integer.parseInt(s.substring(positions[2]));
            if (last > 255 || (positions[2] != len - 1 && s.charAt(positions[2]) == '0'))
                return;
            StringBuilder sb = new StringBuilder();
            int l = 0;
            for (int position : positions) {
                sb.append(s, l, position);
                sb.append(".");
                l = position;
            }
            sb.append(s, l, len);
            ans.add(sb.toString());
            return;
        }
        if (index != len - 1 && s.charAt(index) == '0') {
            positions[pos] = index + 1;
            backTrace(ans, positions, pos + 1, index + 1, s, len);
        }else {
            for (int i = index; i < len - 1 && i < index + 3; i++) {
                int num = Integer.parseInt(s.substring(index, i + 1));
                if (num > 255)
                    break;
                positions[pos] = i + 1;
                backTrace(ans, positions, pos + 1, i + 1, s, len);
            }
        }
    }
    @Test
    public void test() {
        List<String> list = restoreIpAddresses("0690");
        list.forEach(System.out::println);
    }
}
