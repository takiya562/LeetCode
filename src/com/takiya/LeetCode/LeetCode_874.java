package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_874 {
    public static int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            long ox = (long)obstacle[0] + 30000;
            long oy = (long)obstacle[1] + 30000;
            obstacleSet.add((ox << 16) + oy);
        }
        int row = 0, col = 0;
        int ans = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        int dir = 0;
        for (int command : commands) {
            if (command > 0) {
                for (int i = 0; i < command; i++) {
                    int nx = row + dirs[dir];
                    int ny = col + dirs[dir+1];
                    long code = (((long)nx + 30000) << 16) + ((long)ny + 30000);
                    if (!obstacleSet.contains(code)) {
                        row = nx;
                        col = ny;
                        ans = Math.max(ans, row * row + col * col);
                    }
                    else
                        break;
                }
            }
            else {
                if (command == -1) {
                    dir = (dir + 1) % 4;

                }
                if (command == -2)
                    dir = (dir + 3) % 4;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        robotSim(commands, obstacles);
    }
}
