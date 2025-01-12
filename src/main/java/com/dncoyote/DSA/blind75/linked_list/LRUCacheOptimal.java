package com.dncoyote.DSA.blind75.linked_list;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> cache;
    Node left; // least recently used
    Node right; // most recently used

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = right;
        right.prev = left;
    }

    void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.next = this.right;
        this.right.prev = node;
    }
}

public class LRUCacheOptimal {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // Cache: {1=1}
        lruCache.put(2, 2); // Cache: {2=2, 1=1}
        System.out.println(lruCache.get(1)); // Output: 1, Cache: {1=1, 2=2}
        lruCache.put(3, 3); // Removes key 2, Cache: {3=3, 1=1}
        System.out.println(lruCache.get(2)); // Output: -1 (not found)
        lruCache.put(4, 4); // Removes key 1, Cache: {4=4, 3=3}
        System.out.println(lruCache.get(1)); // Output: -1 (not found)
        System.out.println(lruCache.get(3)); // Output: 3, Cache: {3=3, 4=4}
        System.out.println(lruCache.get(4)); // Output: 4, Cache: {4=4, 3=3}
    }
}
