package com.takiya.LeetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_49 {
    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private int[] generatePrimes(int len) {
        int[] prime = new int[len];
        int index = 0;
        int n = 2;
        while (index < len) {
            if (isPrime(n)) {
                prime[index++] = n;
            }
            n++;
        }
        return prime;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = generatePrimes(26);
        HashMap<Double, List<String>> map = new HashMap<>();
        for (String s : strs) {
            double key = 1d;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> list = map.getOrDefault(key, new LinkedList<>());
            list.add(s);
            map.put(key, list);
        }
        List<List<String>> ans = new LinkedList<>();
        for (List<String> list : map.values())
            ans.add(list);
        return ans;
    }

    @Test
    public void test() {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(strs);
        ans.stream().forEach(System.out::println);
    }
}
