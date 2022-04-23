package fzu.com.codetop;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (int num : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (map.get(num) > map.get(priorityQueue.peek())) {
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }
        }
        int[] res = new int[k];
        for (int num : priorityQueue) {
            res[--k] = num;
        }
        return res;
    }
}
