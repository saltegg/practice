package fzu.com.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution42 {

    public int trap(int[] height) {

        if (height.length < 3) return 0;
        int res = 0;
        int[] dpLeft = new int[height.length];
        int[] dpRight = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            dpLeft[i] = Math.max(height[i - 1], dpLeft[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            dpRight[i] = Math.max(height[i + 1], dpRight[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int t = Math.min(dpLeft[i], dpRight[i]);
            if (height[i] < t) {
                res += t - height[i];
            }
        }
        return res;
    }

    public int trap1(int[] height) {
        if (height.length < 3) return 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peekLast()]) {
                int t = stack.pollLast();
                if (stack.isEmpty()) break;
                int width = i - stack.peekLast() - 1;
                int h = Math.min(height[i], height[stack.peekLast()]);
                res += width * (h - height[t]);
            }
            stack.addLast(i);
        }
        return res;
    }
}
