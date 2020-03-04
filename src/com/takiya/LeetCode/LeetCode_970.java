package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_970 {
    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        if (x == 1 && y == 1) {
            if (bound < 2)
                return new ArrayList<>();
            else {
                set.add(2);
                return new ArrayList<>(set);
            }
        }
        else if (x == 1 || y == 1) {
            x = y == 1 ? x : y;
            while ((int) Math.pow(x, i) + 1 <= bound) {
                set.add((int) Math.pow(x, i) + 1);
                i++;
            }
        }
        else {
            while ((int) Math.pow(x, i) <= bound) {
                int temp = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (temp <= bound) {
                    set.add(temp);
                    j++;
                } else {
                    i++;
                    j = 0;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String args[]) {
        List<Integer> ans = powerfulIntegers(2,1, 10);
        for (int i = 0; i < ans.size(); i++)
            System.out.print(ans.get(i));
    }
}
