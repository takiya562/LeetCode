package com.takiya.笔试;

import java.util.*;

public class questionnaire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int num = scanner.nextInt();
                if (set.contains(num))
                    continue;
                int pos = bisect_left(list, num);
                list.add(pos, num);
                set.add(num);
            }
            list.stream().forEach(System.out::println);
        }
    }

    public static int bisect_left(List<Integer> list, int num) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal >= num)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
