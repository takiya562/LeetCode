package com.takiya.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node dumy = new Node(0);
        Node p = dumy;
        while (cur != null) {
            p.next = new Node(cur.val);
            p = p.next;
            map.put(cur, p);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            p = map.get(cur);
            p.random = map.get(cur.random);
            cur = cur.next;
        }
        return dumy.next;
    }
}
