package com.dncoyote.DSA.blind75.linked_list;

import java.util.ArrayList;
import java.util.List;

class LRUCache {
    int capacity;
    List<int[]> cache;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ArrayList<>();
    }

    void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                cache.remove(i);
                cache.add(new int[] { key, value });
                return;
            }
        }
        if (cache.size() == capacity) {
            cache.remove(0);
        }

        cache.add(new int[] { key, value });
    }

    int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i)[0] == key) {
                int[] item = cache.remove(i);
                cache.add(item);
                return item[1];
            }
        }
        return -1;
    }
}

public class LRUCacheBrute {
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
