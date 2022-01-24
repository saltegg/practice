package fzu.com.codetop;

/**
 * @Author: linxiaohui
 * @Date: 2022/01/23 13:51
 * @Description:
 */
public class Solution11 {

    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            res = Math.max(res, (r - l) * minHeight);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }
}
