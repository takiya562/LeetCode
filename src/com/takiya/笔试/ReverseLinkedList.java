package com.takiya.笔试;

/**
 * 原地逆置双向链表
 */
public class ReverseLinkedList {
    static class LinkedList {
        int val;
        LinkedList pre;
        LinkedList next;

        LinkedList(int val) {
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    /**
     * @param head
     * @return
     */
    public LinkedList Reverse(LinkedList head) {
        LinkedList p = head;
        LinkedList q = head;
        while (q.next != null) q = q.next;
        head = q;
        while (p != q && p.next != q) {
            Swap(p, q);
            LinkedList tmp = p;
            p = q;
            q = tmp;
            p = p.next;
            q = q.pre;
        }
        return head;
    }
    private void Swap(LinkedList p, LinkedList q) {
        LinkedList pn = p.next;
        LinkedList pq = p.pre;
        LinkedList qp = q.pre;
        LinkedList qn = q.next;
        p.pre = qp;
        qp.next = p;
        p.next = qn;
        if (qn != null)
            qn.pre = p;
        q.next = pn;
        pn.pre = q;
        q.pre = pq;
        if (pq != null)
            pq.next = q;
    }
    public static void test(LinkedList p) {
        LinkedList tmp = p.next;
        tmp.next = p;
        tmp.pre = null;
        p.pre = tmp;
        p.next = null;
    }

    public static void main(String[] args) {
        ReverseLinkedList test = new ReverseLinkedList();
        LinkedList head = new LinkedList(1);
        LinkedList p = head;
        for (int i = 2; i <= 9; ++i) {
            LinkedList pre = p;
            p.next = new LinkedList(i);
            p = p.next;
            p.pre = pre;
        }
        head = test.Reverse(head);
        p = head;
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
