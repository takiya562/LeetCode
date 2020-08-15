package com.takiya.笔试;

import org.junit.Test;

import java.util.*;

public class NETEASE {
    /**
     * 网易8.8笔试第三题
     * 给一个整数序列，问最少丢弃和为多少的元素能够讲序列均分成两份。
     */
    int sum = 0;
    int min = Integer.MAX_VALUE;
    public int solution1(int[] nums) {
        for (int num : nums)
            sum += num;
        helper1(nums, 0, 0, 0);
        return min;
    }
    void helper1(int[] nums, int index, int p1, int p2) {
        if (index == nums.length) {
            if (p1 == p2)
                min = Math.min(min, sum - 2 * p1);
            return;
        }
        int num = nums[index];
        //丢弃
        helper1(nums, index + 1, p1, p2);
        //分在第一个堆里
        helper1(nums, index + 1, p1 + num, p2);
        //分在第二堆里
        helper1(nums, index + 1, p1, p2 + num);
    }

    @Test
    public void test1() {
        int[] nums = {30, 15, 5, 30, 60};
        System.out.println(solution1(nums));
    }

    public void solution2() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; ++i) {
            String[] strs = new String[7];
            for (int j = 0; j < 7; ++j)
                strs[j] = scanner.next();
            if (helper2(strs))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static boolean helper2(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> {
            if (o1.charAt(1) == o2.charAt(1))
                return o1.charAt(0) - o2.charAt(0);
            return o1.charAt(1) - o2.charAt(1);
        });
        HashSet<Integer> set = new HashSet<>();
        int prenum = -1;
        char pretype = '*';
        int count = 0;
        boolean flag = false;
        for (String s : strs) {
            int num = s.charAt(0) - '0';
            char type = s.charAt(1);
            if (pretype == type)
                count++;
            if (count > 3)  return false;
            if (set.contains(num))  return false;
            if (prenum != -1 && pretype == type) {
                if ((num - prenum) % 3 != 0)
                    return false;
                if (count == 1 && num - prenum == 6) {
                    flag = true;
                }
                if (count == 2 && flag)
                    return false;
            }
            if (pretype != type) {
                count = 1;
                flag = false;
            }
            pretype = type;
            prenum = num;
            set.add(num);
        }
        return true;
    }

    static class Record {
        int time;
        int id;
        int other;

        Record(int start, int id) {
            this.time = start;
            this.id = id;
            other = 0;
        }
    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            Stack<Record> stack = new Stack<>();
            int max = 0;
            int res = -1;
            for (int i = 0; i < n; ++i) {
                Record record = new Record(scanner.nextInt(), scanner.nextInt());
                scanner.nextInt();
                if (stack.isEmpty()) {
                    stack.push(record);
                    continue;
                }
                Record top = stack.peek();
                if (top.id == record.id) {
                    stack.pop();
                    int ttime = record.time - top.time;
                    int otime = ttime - top.other;
                    if (max < otime) {
                        max = otime;
                        res = top.id;
                    }
                    if (max == otime)
                        res = Math.min(top.id, res);
                    if (!stack.isEmpty())
                        stack.peek().other += ttime;
                } else {
                    stack.push(record);
                }
            }
            System.out.println(res);
        }
    }

    public static void main(String[] args) {
        solution3();
    }
}
