package com.takiya.LeetCode;

import java.util.*;

public class LeetCode_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        int amount = tickets.size();
        if (amount == 0) {
            res.add("JFK");
            return res;
        }
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> list : tickets) {
            String from = list.get(0);
            String to = list.get(1);
            if (graph.containsKey(from))
                graph.get(from).add(to);
            else {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(to);
                graph.put(from, q);
            }
        }
        visit(graph, "JFK", res);
        return res;
    }
    public void visit(HashMap<String, PriorityQueue<String>> graph, String from, List<String> res) {
        PriorityQueue<String> q = graph.get(from);
        while (q != null && !q.isEmpty()) {
            String to = q.poll();
            visit(graph, to, res);
        }
        res.add(0, from);           //逆序插入
    }
    /* 正确性理解
    *  插入是在路走不通的时候进行的，说明插入前的岔口选择了错误的路线，并且错误路线必然在正确路线之后，所以逆序插入 */
}
