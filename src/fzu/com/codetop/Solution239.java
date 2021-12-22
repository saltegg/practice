package fzu.com.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (!deque.isEmpty() && nums[r] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.addLast(nums[r]);
            if (r - l + 1 == k) {
                int t = deque.getFirst();
                res.add(t);
                if (t == nums[l]) {
                    deque.pollFirst();
                }
                l++;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
