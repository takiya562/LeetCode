package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_207 {
    int[] state;
    Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for (int[] pre : prerequisites) {
            List<Integer> dependency = map.getOrDefault(pre[0], new ArrayList<>());
            dependency.add(pre[1]);
            map.put(pre[0], dependency);
        }
        state = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!learn(i))
                return false;
        }
        return true;
    }
    boolean learn(int i) {
        if (state[i] == 2)
            return true;
        if (state[i] == 1)
            return false;
        state[i] = 1;
        List<Integer> dependencies = map.get(i);
        if (dependencies == null) {
            state[i] = 2;
            return true;
        }
        for (int dependency : dependencies) {
            if (!learn(dependency))
                return false;
        }
        state[i] = 2;
        return true;
    }
}
