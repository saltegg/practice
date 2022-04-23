package fzu.com.solution;

public class Solution11 {

    public int maxArea(int[] height) {

        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int tmp = Math.min(height[l], height[r]);
            res = Math.max(res, tmp * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
