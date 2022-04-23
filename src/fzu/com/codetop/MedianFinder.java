package fzu.com.codetop;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();  // 默认小顶堆
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {

        if (maxHeap.size() > 0 && num >= maxHeap.peek()) {
            minHeap.add(num);
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
        } else {
            maxHeap.add(num);
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {

        int size = maxHeap.size() + maxHeap.size();
        if (size % 2 == 1) {
            return 1.0 * maxHeap.peek();
        } else {
            int a = maxHeap.peek();
            int b = minHeap.peek();
            return 1.0 * (a + b) / 2;
        }
    }
}
