package Week.No181;

import java.util.Arrays;

public class LeetCode_1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        if (len == 0)   return new int[] {};
        int[] res = new int[len];
        Arrays.fill(res, -1);
        int pos, num;
        int tmp;
        for (int i = 0; i < len; ++i) {
            pos = index[i];
            num = nums[i];
            if (res[pos] == -1)
                res[pos] = num;
            else {
                while (num != -1) {
                    tmp = res[pos];
                    res[pos] = num;
                    num = tmp;
                    pos++;
                }
            }
        }
        return res;
    }
}
