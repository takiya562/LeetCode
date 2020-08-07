package com.takiya.LeetCode;

public class LeetCode_1344 {
    public static double angleClock(int hour, int minutes) {
        double leftMin = 6.0 * minutes;
        double offset = 30.0 * (minutes / 60.0);
        double leftHour = 30.0 * (hour % 12) + offset;
        double angle1 = Math.abs(leftMin - leftHour);
        double angle2 = 360 - angle1;
        return Math.min(angle1, angle2);
    }

    public static void main(String[] args) {
        angleClock(8, 7);
    }
}
