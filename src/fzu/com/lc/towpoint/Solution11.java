package fzu.com.lc.towpoint;

/**
 * @program: practice
 * @description: leetcode
 * @author: linxiaohui
 * @create: 2020-09-20 20:19
 **/
public class Solution11 {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int w = Math.abs(j - i);   //底边
                int l = Math.min(height[i], height[j]); //高
                max = Math.max(w * l, max);
            }
        }
        return max;
    }

}
