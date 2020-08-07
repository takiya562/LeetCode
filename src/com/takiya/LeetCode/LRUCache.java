package com.takiya.LeetCode;

import java.util.HashMap;

public class LRUCache {
    private final int capacity;

    private HashMap<Integer, Entry> cache;

    private Entry head;

    private Entry tail;

    class Entry {
        int key;
        int value;
        Entry pre;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        //dummy head
        head = new Entry(0, 0);
        tail = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Entry entry = cache.get(key);
            popToTail(entry);
            return entry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Entry entry;
        if (cache.containsKey(key)) {
            entry = cache.get(key);
            entry.value = value;
            cache.put(key, entry);
            popToTail(entry);
        } else {
            if (cache.size() == capacity) {
                entry = removeFirst();
                cache.remove(entry.key);
            }
            entry = new Entry(key, value);
            cache.put(key, entry);
            addNew(entry);
        }
    }

    private void popToTail(Entry entry) {
        if (tail == entry)
            return;
        Entry pre = entry.pre;
        Entry next = entry.next;
        pre.next = next;
        next.pre = pre;
        addNew(entry);
    }

    private Entry removeFirst() {
        Entry entry = head.next;
        if (tail == entry) {
            head.next = null;
        } else {
            Entry next = entry.next;
            head.next = next;
            next.pre = head;
        }
        return entry;
    }

    private void addNew(Entry newTail) {
        tail.next = newTail;
        newTail.pre = tail;
        newTail.next = null;
        tail = newTail;
    }

    public static void main(String[] args) {
        LRUCache Cache = new LRUCache(2);
        Cache.put(2, 1);
        Cache.put(1, 1);
        Cache.put(2, 3);
        Cache.put(4, 1);
        Cache.get(1);
        Cache.get(2);
        Cache.put(3,2);
        Cache.get(2);
        Cache.get(3);
    }
}
