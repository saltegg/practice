package fzu.com.lc.pre200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution480 {


    public double[] medianSlidingWindow(int[] nums, int k) {

        List<Double> list = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        for (int l = 0, r = 0; r < nums.length; r++) {
            maxHeap.add(nums[r]);
            minHeap.add(maxHeap.remove());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }
            if (r - l + 1 == k) {
                if (minHeap.size() == maxHeap.size()) {
                    list.add(minHeap.peek() / 2.0 + maxHeap.peek() / 2.0);
                } else {
                    list.add(maxHeap.peek() * 1.0);
                }
                if (minHeap.contains(nums[l])) {
                    minHeap.remove(nums[l]);
                    if (maxHeap.size() - minHeap.size() > 1) {
                        minHeap.add(maxHeap.remove());
                    }
                } else {
                    maxHeap.remove(nums[l]);
                    if (minHeap.size() > maxHeap.size()) {
                        maxHeap.add(minHeap.remove());
                    }
                }
                l++;
            }
        }
        double[] res = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
