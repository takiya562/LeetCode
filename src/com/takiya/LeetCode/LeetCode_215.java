package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for (int parent = len / 2 - 1; parent >= 0; parent--) {
            adjust(nums, parent, len);
        }
        for (int i = 0; i < k - 1; ++i) {
            swap(nums, 0, len - i - 1);
            adjust(nums, 0, len - i - 1);
        }
        return nums[0];
    }
    void adjust(int[] nums, int parent, int len) {
        int cur = nums[parent];
        for (int child = parent * 2 + 1; child < len; child = parent * 2 + 1) {
            if (child + 1 < len && nums[child] < nums[child + 1]) {
                child++;
            }
            if (cur < nums[child]) {
                nums[parent] = nums[child];
                parent = child;
            } else {
                break;
            }
        }
        nums[parent] = cur;
    }
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Map<Integer, List<List<Integer>> map = new HashMap<>();
//        int n = scanner.nextInt();
//        int[] arr = new int[3];
//        for (int i = 0; i < n; ++i) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = 0; j < 2; ++j) {
//                int a = scanner.nextInt(), b = scanner.nextInt();
//                list.add(a);
//                list.add(b);
//                arr[j] = a + b;
//            }
//            Arrays.sort(arr);
//            int key = encode(arr);
//            List<List<Integer>> value = map.getOrDefault(key, new LinkedList<>());
//            value.add(list);
//            map.put(key, value);
//        }
//        Collection<List<List<Integer>>> values = map.values();
//        int count = values.size();
//        for (List<List<Integer>> lists : values) {
//            int a = lists.size();
//            if (a == 1) continue;
//            Set<Integer> set = new HashSet<>();
//            List<Integer> pattern = lists.get(0);
//            set.add(lists.get(0).get(0));
//            set.add(lists.get(0).get(1));
//            int first = lists.get(0).get(2);
//            for (int i = 1; i < a; ++i) {
//                List<Integer> list = lists.get(i);
//                int index = 0;
//                while (list.get(index) != first)
//                    index++;
//                for (int j = index; j != index; j = (j + 1) % list.size()) {
//
//                }
//            }
//        }
//    }
//    static int encode(int[] arr) {
//        return arr[0] + (arr[1] << 4) + (arr[2] << 8);
//    }
    static int[] dirs = {-1, 0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] graph = new int[6][6];
        long res = 1;
        for (int i = 0; i < 6; ++i) {
            String s = scanner.next();
            for (int j = 0; j < 6; ++j) {
                char c = s.charAt(j);
                if (c == '#') {
                    graph[i][j] = -1;
                    continue;
                } else {
                    graph[i][j] = 1;
                    int flag = 0;
                    for (int n = 0; n < 4; ++n) {
                        int row = i + dirs[n];
                        int col = j + dirs[n + 1];
                        if (row >= 0 && row < 6 && col >= 0 && col < 6 && graph[row][col] == 1)
                            flag++;
                    }
                    res = res * (6 - flag);
                }
            }
        }
        System.out.print(res % 1000000009);
    }
}
