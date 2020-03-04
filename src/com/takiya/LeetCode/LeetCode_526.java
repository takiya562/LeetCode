package com.takiya.LeetCode;

public class LeetCode_526 {
    int count = 0;
    public int countArrangement(int N) {
        int[] visited = new int[N + 1];
        recursion(N, 1, visited);
        return count;
    }

    public void recursion(int N, int pos, int[] visited) {
        if (pos > N) {
            count++;
            return;
        }
        for (int i = 1; i <= N; ++i) {
            if (visited[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                visited[i] = 1;
                recursion(N, pos + 1, visited);
                visited[i] = 0;
            }
        }
    }
}
