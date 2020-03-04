package com.takiya.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_365 {
    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /*超出内存限制*/
    public boolean canMeasureWater_1(int x, int y, int z) {
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[x][y];
        visited[0][0] = 1;
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int cur_x = cur.x;
            int cur_y = cur.y;
            if (cur_x + cur_y == z || cur_x == z || cur_y == z)
                return true;
            //清空水
            if (visited[0][cur_y] != 1) {
                queue.add(new Pair(0, cur_y));
                visited[0][cur_y] = 1;
            }
            if (visited[cur_x][0] != 1) {
                queue.add(new Pair(cur_x, 0));
                visited[cur_x][0] = 1;
            }
            //加满水
            if (visited[x][cur_y] != 1) {
                queue.add(new Pair(x, cur_y));
                visited[x][cur_y] = 1;
            }
            if (visited[cur_x][y] != 1) {
                queue.add(new Pair(cur_x, y));
                visited[cur_x][y] = 1;
            }
            //互相倒水
            if (cur_x + cur_y >= y && visited[cur_x + cur_y - y][y] != 1) {
                queue.add(new Pair(cur_x + cur_y - y, y));
                visited[cur_x + cur_y - y][y] = 1;
            }
            else if (cur_x + cur_y < y && visited[0][cur_x + cur_y] != 1) {
                queue.add(new Pair(0, cur_x + cur_y));
                visited[0][cur_x + cur_y] = 1;
            }
            if (cur_x + cur_y >= x && visited[x][cur_x + cur_y -x] != 1) {
                queue.add(new Pair(x, cur_x + cur_y - x));
                visited[x][cur_x + cur_y - x] = 1;
            }
            else if (cur_x + cur_y < x && visited[cur_x + cur_y][0] != 1) {
                queue.add(new Pair(cur_x + cur_y, 0));
                visited[cur_x + cur_y][0] = 1;
            }
        }
        return false;
    }
    public long gcd(long a, long b) {
        return (a == 0 ? b : gcd(b % a, a));
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z)  return false;
        if (x == z || y == z)   return true;
        return z % gcd(x, y) == 0;
    }
}
