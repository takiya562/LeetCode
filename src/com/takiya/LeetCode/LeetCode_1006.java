package com.takiya.LeetCode;

public class LeetCode_1006 {
    public static int clumsy(int N) {
        if (N < 3)  return N;
        int sum = (N--) * (N--) / (N--) + (N--);
        while (N > 0) {
            int temp = N--;
            for (int i = 0; i < 3 && N > 0; i++) {
                switch (i) {
                    case 0:
                        temp *= N--;
                        break;
                    case 1:
                        temp /= N--;
                        break;
                    case 2:
                        temp -= N--;
                        break;
                }
            }
            sum -= temp;
        }
        return sum;
    }

    public static void main(String args[]) {
        clumsy(10);
    }
}
