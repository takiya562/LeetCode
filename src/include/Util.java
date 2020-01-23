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
}
