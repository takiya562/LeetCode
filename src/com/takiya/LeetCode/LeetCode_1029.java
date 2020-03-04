package com.takiya.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> {
            int gap1 = Math.abs(o1[1] - o1[0]);
            int gap2 = Math.abs(o2[1] - o2[0]);
            return gap2 - gap1;
        });
        int sum = 0;
        int N1 = costs.length / 2;
        int N2 = N1;
        for (int[] cost : costs) {
            if (N1 == 0 || N2 == 0)
                sum += (N1 == 0) ? cost[1] : cost[0];
            else if (cost[0] < cost[1]) {
                --N1;
                sum += cost[0];
            }
            else {
                --N2;
                sum += cost[1];
            }
        }
        return sum;
    }
}
