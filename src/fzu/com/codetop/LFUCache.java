package fzu.com.codetop;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    PriorityQueue<Integer> queue;

    Map<Integer, Integer> map1; // K V

    Map<Integer, Integer> map2; // K cnt

    int c;

    public LFUCache(int capacity) {
        queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map2.get(o1) - map2.get(o2);
            }
        });
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        c = capacity;
    }

    public int get(int key) {
        if (map1.containsKey(key)) {
            map2.put(key, map2.get(key) + 1);
            queue.remove(key);
            queue.add(key);
            return map1.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (c == 0) return;
        if (map1.size() + 1 > c) {
            int k = queue.poll();
            map1.remove(k);
            map2.remove(k);
        }
        map1.put(key, value);
        map2.put(key, 1);
        queue.remove(key);
        queue.add(key);
    }
}
