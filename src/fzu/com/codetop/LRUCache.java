package fzu.com.codetop;

import java.util.*;

public class LRUCache {

    private Deque<Integer> deque;
    private Map<Integer, Integer> map;
    private int size;

    public LRUCache(int capacity) {
        deque = new ArrayDeque<>();
        map = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
            map.put(key, value);
        } else {
            if (map.size() >= size) {
                map.remove(deque.pollLast());
            }
            map.put(key, value);
            deque.addFirst(key);
        }
    }
}
