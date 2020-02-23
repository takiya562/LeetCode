package Week.No177;

public class LeetCode_5172 {
    int[] cnt = new int[10];
    String ans = "";
    public int del(int m) {
        for (int i = m; i <= 9; i += 3) {
            if (cnt[i] > 0) {
                cnt[i]--;
                return 1;
            }
        }
        return 0;
    }
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
            cnt[digit]++;
        }
        if (cnt[0] == digits.length)    return "0";
        if (sum % 3 == 1) {
            if (del(1) == 0) {
                del(2);
                del(2);
            }
        }
        if (sum % 3 == 2) {
            if (del(2) == 0) {
                del(1);
                del(1);
            }
        }
        for (int i = 9; i >= 0; --i) {
            while (cnt[i] > 0) {
                ans += i;
                cnt[i]--;
            }
        }
        return ans;
    }
}
