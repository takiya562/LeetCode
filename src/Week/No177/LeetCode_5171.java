package Week.No177;

public class LeetCode_5171 {
    int[] ans = new int[2];
    int min = Integer.MAX_VALUE;
    public void helper(int target) {
        for (int i = 1; i <= Math.sqrt(target); ++i) {
            int p = target / i;
            int gap = Math.abs(p - i);
            if (target % i == 0 && gap < min) {
                min = gap;
                ans[0] = p; ans[1] = i;
            }
        }
    }
    public int[] closestDivisors(int num) {
        helper(num + 1);
        helper(num + 2);
        return ans;
    }
}
