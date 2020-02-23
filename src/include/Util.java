package include;

public class Util {
    public long gcd(long a, long b) {
        return (a == 0 ? b : gcd(b % a, a));
    }

    public int factors(int n) {
        int count = 0;
        int i = 1;
        for (; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                count += 2;
        }
        if (i * i == n)
            count++;
        return count;
    }

    static int[] norm = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    static int[] leap = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
    public static int timestamp(String str) {
        String[] split = str.split("-");
        int year = Integer.valueOf(split[0]);
        int month = Integer.valueOf(split[1]);
        int day = Integer.valueOf(split[2]);
        int res = 0;
        int y_gap = year - 1900 - 1;
        int leaps = y_gap / 4 + 1;
        res += leaps * 366 + (y_gap - leaps) * 365;
        res += (year % 4 == 0) ? leap[month - 1] : norm[month - 1];
        res += day;
        return res;
    }
}
