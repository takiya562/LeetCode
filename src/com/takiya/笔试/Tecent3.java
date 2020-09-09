package com.takiya.笔试;

import include.ListNode;

import java.util.*;

public class Tecent3 {
    public static void main(String[] args) {
        solution2();
    }

    public static void solution1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode list1 = new ListNode(-1);
        ListNode p = list1;
        for (int i = 0; i < n; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        int m = scanner.nextInt();
        ListNode list2 = new ListNode(-1);
        p = list2;
        for (int i = 0; i < m; i++) {
            p.next = new ListNode(scanner.nextInt());
            p = p.next;
        }
        ListNode p1 = list1.next;
        ListNode p2 = list2.next;
        ListNode res = new ListNode(-1);
        p = res;
        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.val > p2.val) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
        }
        p = res.next;
        while (p.next != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println(p.val);
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, List<Integer>> groups = new HashMap<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                int num = scanner.nextInt();
                list.add(num);
                List<Integer> tmp = map.getOrDefault(num, new ArrayList<>());
                tmp.add(i);
                map.put(num, tmp);
            }
            groups.put(i, list);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        HashSet<Integer> set =  new HashSet<>();
        queue.add(0);
        set.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            for (int group : map.get(num)) {
                for (int k : groups.get(group)) {
                    if (!set.contains(k)) {
                        queue.add(k);
                        set.add(k);
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void solution3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int count = counts.getOrDefault(s, 0);
            count++;
            counts.put(s, count);
        }
        String[] strs = new String[counts.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            strs[index++] = entry.getKey();
        }
        Arrays.sort(strs, (x, y) -> {
            if (counts.get(x).equals(counts.get(y)))
                return x.compareTo(y);
            return counts.get(y) - counts.get(x);
        });
        for (int i = 0; i < k; i++) {
            System.out.println(strs[i] + " " + counts.get(strs[i]));
        }
        Arrays.sort(strs, (x, y) -> {
            if (counts.get(x).equals(counts.get(y)))
                return x.compareTo(y);
            return counts.get(x) - counts.get(y);
        });
        for (int i = 0; i < k; i++) {
            System.out.println(strs[i] + " " + counts.get(strs[i]));
        }
    }

    public static void solution4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            tmp[i] = nums[i];
        }
        Arrays.sort(nums);
        int left = nums[n / 2 - 1];
        int right = nums[n / 2];
        for (int num : tmp) {
            if (num <= left) {
                System.out.println(right);
            }
            if (num >= right) {
                System.out.println(left);
            }
        }
    }

    public static void solution5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            nums[i] = scanner.nextInt();

    }
}
