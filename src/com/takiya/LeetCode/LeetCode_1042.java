package com.takiya;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LeetCode_1042 {
    public static int[] gardenNoAdj(int N, int[][] paths) {
        int[] ans = new int[N];
        List<Integer>[] graph = new List[N+1];
        Set<Integer>[] sets = new Set[N+1];
        for (int i = 1; i <= N; ++i) {
            graph[i] = new LinkedList<>();
            sets[i] = new HashSet<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }
        for (int i = 1; i <= N; ++i) {
            for (int color = 1; color <= 4; ++color) {
                if (!sets[i].contains(color)) {
                    ans[i-1] = color;
                    for (int nei : graph[i])
                        sets[nei].add(color);
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] gardenNoAdj_2(int N, int[][] paths) {
        int[] ans = new int[N];
        List<Integer>[] graph = new List[N + 1];

        for (int i = 1; i <= N; ++i)
            graph[i] = new LinkedList<>();
        for (int[] path : paths) {
            graph[path[0]].add(path[1]);
            graph[path[1]].add(path[0]);
        }

        for (int i = 1; i <= N; ++i) {
            if (ans[i - 1] != 0) continue;
            List<Integer> neighbours = graph[i];
            int[] flowers = new int[4];
            for (int j = 0; j < neighbours.size(); ++j) {
                int nei = neighbours.get(j);
                if (ans[nei - 1] != 0)
                    flowers[ans[nei - 1] - 1] = 1;
            }

            for (int color = 1; color <=N; ++color) {
                if (flowers[color - 1] == 0) {
                    ans[i - 1] = color;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] paths = {{1,2},{2,3},{3,1}};
        gardenNoAdj(3, paths);
    }
}
