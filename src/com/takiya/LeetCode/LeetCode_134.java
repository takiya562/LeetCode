package com.takiya.LeetCode;

public class LeetCode_134 {
    public  int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0;
        int cur_tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; ++i) {
            cur_tank += gas[i] - cost[i];
            total_tank += gas[i] - cost[i];
            if (cur_tank < 0) {
                start = i + 1;
                cur_tank = 0;
            }
        }
        return total_tank >= 0 ? start : -1;
    }
}
