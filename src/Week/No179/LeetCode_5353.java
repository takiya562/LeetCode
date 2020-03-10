package Week.No179;

public class LeetCode_5353 {
    public int numTimesAllBlue(int[] light) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < light.length; ++i) {
            int number = light[i];
            max = Math.max(max, number);
            if (max == i + 1)
                res++;
        }
        return res;
    }
}
