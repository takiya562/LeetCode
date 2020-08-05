package include;


import java.util.concurrent.ThreadLocalRandom;

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

    /**
     * calculate a^b
     * @param a
     * @param b
     * @param c
     * @return a^b % c
     */
    public static int QuickPow(int a, int b, int c) {
        long A = 1;
        long T = a % c;
        while (b != 0) {
            if ((b & 1) == 1)
                A = (A * T) % c;
            T = (T * T) % c;
            b >>= 1;
        }
        return (int)A;
    }
    public static int QuickPow(int a, int b) {
        long A = 1;
        long T = a;
        while (b != 0) {
            if ((b & 1) == 1)
                A = (A * T);
            T = (T * T);
            b >>= 1;
        }
        return (int)A;
    }

    public static int numberOfOne(int n){
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void quickSort(int[] arr) {
        quickSort0(arr, 0, arr.length);
    }

    private static void quickSort0(int[] arr, int start, int end) {
        if (start == end)   return;
        int t = arr[start];
        int l = start;
        int r = end - 1;
        while (l < r) {
            while (l < r && arr[r] > t)  r--;
            arr[l] = arr[r];
            while (l < r && arr[l] <= t) l++;
            arr[r] = arr[l];
        }
        arr[l] = t;
        quickSort0(arr, start, l);
        quickSort0(arr, l + 1, end);
    }

    public static int getNumLength(long num) {
        num = num > 0 ? num : -num;
        if (num == 0)
            return 1;
        return (int)(Math.log10(num) + 1);
    }

    public static void main(String args[]) {
        System.out.print(QuickPow(10, 3));
    }
}
