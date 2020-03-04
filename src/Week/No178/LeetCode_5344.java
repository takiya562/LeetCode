package Week.No178;


import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_5344 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; ++i)
            index[i] = i;
        Arrays.sort(index, (i, j) -> ((Integer)nums[i]).compareTo(nums[j]));
        int[] ans = new int[len];
        int pre = index[0];
        ans[pre] = 0;
        for (int i = 1; i < len; ++i) {
            int num = nums[index[i]];
            if (num != nums[pre])
                ans[index[i]] = i;
            else
                ans[index[i]] = ans[pre];
            pre = index[i];
        }
        return ans;
    }
    public static void main(String args[]) {
        int[] nums = {8,1,2,2,3};
        smallerNumbersThanCurrent(nums);
    }
}
