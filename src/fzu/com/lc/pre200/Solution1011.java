package fzu.com.lc.pre200;

/**
 * @Author: linxiaohui
 * @Date: 2021/11/13 9:27
 * @Description:
 */
public class Solution1011 {

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 1;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (f(weights, mid) <= days) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int f(int[] weights, int x) {  // x为装载能力
        int days = 0, sum = 0;
        for (int weight : weights) {
            if (weight > x) return Integer.MAX_VALUE; // 装载能力太小， 需要提高
            if (sum + weight > x) {
                days++;
                sum = weight;
            } else {
                sum += weight;
            }
        }
        return days + 1;
    }
}
