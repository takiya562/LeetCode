package com.takiya.笔试;

import include.ListNode;

import java.util.*;

public class RedBook {
    static int findMin(int[] tree) {
        Set<Integer> set = new HashSet<>();
        for (int num : tree)
            set.add(num);
        int i = 1;
        while (set.contains(i)) i++;
        return i;
    }

    static int solution(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            List<Integer> positions = map.getOrDefault(c, new ArrayList<>());
            dp[i] = dp[i - 1] + 1;
            for (int pos : positions) {
                dp[i] = Math.min(dp[i], dp[pos - 1] + 1);
            }
            positions.add(i);
            map.put(c, positions);
        }
        return dp[n];
    }
    static class Pair {
        int l1;
        int l2;
        int height;

        Pair(int l1, int l2, int height) {
            this.l1 = l1;
            this.l2 = l2;
            this.height = height;
        }

        int getArea() {
            return l1 * l2;
        }
    }
    static void solution3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Pair[] boxes = new Pair[3 * n];
            int index = 0;
            while (n-- != 0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int c = scanner.nextInt();
                boxes[index++] = new Pair(a, b ,c);
                boxes[index++] = new Pair(a, c ,b);
                boxes[index++] = new Pair(b, c ,a);
            }
            Arrays.sort(boxes, (x, y) -> {
                if (x.getArea() == y.getArea())
                    return y.height - x.height;
                return y.getArea() - x.getArea();
            });
            n = boxes.length;
            int[] dp = new int[n];
            dp[0] = boxes[0].height;
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                Pair cur = boxes[i];
                dp[i] = cur.height;
                for (int j = i - 1; j >= 0; j--) {
                    Pair pre = boxes[j];
                    if ((cur.l1 < pre.l1 && cur.l2 < pre.l2) || (cur.l1 < pre.l2 && cur.l2 < pre.l1)) {
                        dp[i] = Math.max(dp[j] + cur.height, dp[i]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args) {
        solution3();
    }
}
