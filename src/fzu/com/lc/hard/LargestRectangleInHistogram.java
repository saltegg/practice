package fzu.com.lc.hard;
 
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1068 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {

        int[] t = {3,6,5,7,4,8,1,0};
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(t));
	}
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int largestRectangleArea(int[] heights) { // 84


        int len = heights.length, max = 0;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.add(0);
        for (int i = 1; i < len; i++) {
            int top = stack.getLast();
            if (heights[i] >= heights[top]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                    int index = stack.pollLast();
                    int width;
                    if (stack.isEmpty()) {
                        width = i;
                    } else {
                        width = i - stack.peekLast() - 1;
                    }
                    max = Math.max(max, width * heights[index]);
                }
                stack.addLast(i);
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pollLast();
            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }
            max = Math.max(max, width * heights[index]);
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {   // 84 暴力解

        int maxArea = 0, minHeight;
        for (int i = 0; i < heights.length; i++) {
            minHeight = heights[i];
            maxArea = Math.max(maxArea, minHeight);
            for (int j = i + 1; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }

        return maxArea;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}