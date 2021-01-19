package com.takiya.LeetCode;

import include.UnionFind;

import java.util.*;

public class LeetCode_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> email2Name = new HashMap<>();
        Map<String, Integer> email2Index = new HashMap<>();
        int emailCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                email2Name.put(email, name);
                if (!email2Index.containsKey(email))
                    email2Index.put(email, emailCount++);
            }
        }
        UnionFind uf = new UnionFind(emailCount);
        for (List<String> account : accounts) {
            int firstEmail = email2Index.get(account.get(1));
            int size = account.size();
            for (int i = 2; i < size; i++) {
                int nextEmail = email2Index.get(account.get(i));
                uf.union(firstEmail, nextEmail);
            }
        }
        Map<Integer, List<String>> index2Email = new HashMap<>();
        for (String email : email2Index.keySet()) {
            int index = uf.find(email2Index.get(email));
            List<String> list = index2Email.getOrDefault(index, new ArrayList<>());
            list.add(email);
            index2Email.put(index, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : index2Email.values()) {
            Collections.sort(list);
            String name = email2Name.get(list.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(list);
            result.add(account);
        }
        return result;
    }
}


