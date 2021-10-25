package fzu.com.lc.pre200;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution295 {

    private Queue<Integer> maxQueue;
    private Queue<Integer> minQueue;
    private int size;

    /** initialize your data structure here. */
    public Solution295() {
        maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minQueue = new PriorityQueue<>();
        size = 0;
    }

    public void addNum(int num) {
        if (size == 0) {
            maxQueue.add(num);
            size = 1;
            return;
        }
        int maxHeapNum = maxQueue.peek();
        if (num <= maxHeapNum) {
            maxQueue.add(num);
            if (size % 2 == 1) {
              minQueue.add(maxQueue.poll());
            }
        } else {
            minQueue.add(num);
            if (size % 2 == 0) {
                maxQueue.add(minQueue.poll());
            }
        }
        size = maxQueue.size() + minQueue.size();
    }

    public double findMedian() {
        if (size % 2 == 0) {
            return (minQueue.peek() * 1.0 + maxQueue.peek()) / 2;
        } else {
            return maxQueue.peek();
        }
    }

}
