package com.takiya;

public class LeetCode_400 {
    public static int findNthDigit(int n) {
        long digitalNum = 1;
        long bigBit = 10, nowBit = 1;   //bigBit表示下一个范围的位数，用10^n表示，nowBit表示现在循环所处范围的位数
        long count = bigBit - nowBit;   //当前所在范围的自然数数量
        while (n - digitalNum * count > 0) {   //没有找到所在范围，更新参数
            n -= digitalNum * count;
            digitalNum += 1;
            bigBit *= 10;
            nowBit *= 10;
            count = bigBit - nowBit;
        }
        long pos = n / digitalNum;
        long rest = n % digitalNum;
        long real = nowBit + pos;
        if (rest == 0) {
            real -= 1;
            return (int)real % 10;
        }
        long i = digitalNum - rest;
        while (i != 0) {
            real /= 10;
            i -= 1;
        }
        return (int)real % 10;
    }
    public static void main(String args[]) {
        System.out.print(findNthDigit(1000000000));
    }
}
