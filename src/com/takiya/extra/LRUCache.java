package com.takiya.extra;

import java.util.HashMap;

public class LRUCache<K, V> {
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> pre;
        Entry<K, V> next;

        Entry() {
            key = null;
            value = null;
            pre = null;
            next = null;
        }

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private final HashMap<K, Entry<K, V>> cache;
    private final int capacity;
    private final Entry<K, V> head;
    private Entry<K, V> tail;

    public LRUCache() {
        this.cache = new HashMap<>();
        this.capacity = DEFAULT_CAPACITY;
        head = new Entry<>();
        tail = head;
    }

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new Entry<>();
        tail = head;
    }

    public void put(K key, V value) {
        Entry<K, V> entry;
        if (cache.containsKey(key)) {
            entry = cache.get(key);
            entry.value = value;
            popToTail(entry);
        } else {
            if (capacity == cache.size()) {
                entry = removeFirst();
                cache.remove(entry.key);
            }
            entry = new Entry<>(key, value);
            addNew(entry);
        }
        cache.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry;
        if (cache.containsKey(key)) {
            entry = cache.get(key);
            popToTail(entry);
            return entry.value;
        }
        return null;
    }

    private void addNew(Entry<K, V> newTail) {
        tail.next = newTail;
        newTail.pre = tail;
        tail = newTail;
    }

    private void popToTail(Entry<K, V> entry) {
        if (tail == entry)
            return;
        Entry<K, V> pre = entry.pre;
        Entry<K, V> next = entry.next;
        pre.next = next;
        next.pre = pre;
        addNew(entry);
    }

    private Entry<K, V> removeFirst() {
        Entry<K, V> entry = head.next;
        if (tail == entry) {
            head.next = null;
            tail = head;
        }
        else {
            Entry<K, V> next = entry.next;
            head.next = next;
            next.pre = head;
        }
        return entry;
    }


    public static void main(String[] args) {
        LRUCache<Integer, Integer> Cache = new LRUCache<>(2);
        Cache.put(2, 1);
        Cache.put(1, 1);
        Cache.put(2, 3);
        Cache.put(4, 1);
        System.out.println(Cache.get(1));
        System.out.println(Cache.get(2));
        Cache.put(3,2);
        System.out.println(Cache.get(2));
        System.out.println(Cache.get(3));
    }
}
