package Week.No177;

public class LeetCode_5169 {
    int[] norm = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    int[] leap = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
    public int timestamp(String str) {
        String[] split = str.split("-");
        int year = Integer.valueOf(split[0]);
        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        int res = 0;
        int y_gap = year - 1900 - 1;
        int leaps = y_gap / 4 + 1;
        res += leaps * 366 + (y_gap - leaps) * 365;
        res += (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? leap[month - 1] : norm[month - 1];
        res += day;
        return res;
    }
    public int daysBetweenDates(String date1, String date2) {
        int timestamp1 = timestamp(date1);
        int timestamp2 = timestamp(date2);
        return Math.abs(timestamp1 - timestamp2);
    }
}
