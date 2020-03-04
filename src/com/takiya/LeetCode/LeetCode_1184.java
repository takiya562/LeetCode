package com.takiya.LeetCode;

public class LeetCode_1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int now = start;
        int sequence = 0, reverse = 0;
        int n = distance.length;
        while (now != destination) {
            sequence += distance[now];
            now = (now + 1) % n;
        }
        now = destination;
        while (now != start) {
            reverse += distance[now];
            now = (now + 1) % n;
        }
        return sequence < reverse ? sequence : reverse;
    }
}
