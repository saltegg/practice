package fzu.com.bytedance;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution42 {

    public int trap(int[] height) {

        if (height.length < 3) return 0;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peekLast()]) {
                int t = stack.pollLast();
                if (stack.isEmpty()) break;
                int width = i - stack.peekLast() - 1;
                int minHeight = Math.min(height[i], height[stack.peekLast()]);
                res += width * (height[t] - minHeight);
            }
            stack.addLast(i);
        }
        return res;
    }
}
