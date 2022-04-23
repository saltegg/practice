package fzu.com.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution862 {

    public int shortestSubarray(int[] nums, int k) {

        int res = nums.length + 1;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            int t = preSum[i];
            while (!deque.isEmpty() && t - preSum[deque.peek()] >= k) {
                res = Math.min(i - deque.poll(), res);
            }
            while (!deque.isEmpty() && t <= preSum[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);
        }
        return res == nums.length + 1? -1 : res;
    }
}
