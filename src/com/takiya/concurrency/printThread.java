package com.takiya.concurrency;

import java.util.concurrent.CountDownLatch;

public class printThread {
    private String s;
    private volatile char current;
    private int next;
    private CountDownLatch countDownLatch;

    private class printHandler implements Runnable {

        char target;

        public printHandler(char target) {
            this.target = target;
        }

        @Override
        public void run() {
            while (current != ' ') {
                if (current == target) {
                    System.out.print(target);
                    countDownLatch.countDown();
                    if (next == s.length())
                        current = ' ';
                    else
                        current = s.charAt(next++);
                }
            }
        }
    }

    public printThread(String s, CountDownLatch countDownLatch) {
        this.s = s;
        current = s.charAt(0);
        next = 1;
        this.countDownLatch = countDownLatch;
        for (int i = 0; i < 10; ++i)
            new Thread(new printHandler((char)(i + 48))).start();
    }
    public static void main(String[] args) throws InterruptedException {
        String s = "32323232323232323232323";
        CountDownLatch countDownLatch = new CountDownLatch(s.length());
        new printThread(s, countDownLatch);
        countDownLatch.await();
    }
}
