package fzu.com.solution.bi;

public class Solution1011 {

    public int shipWithinDays(int[] weights, int days) {

        int l = 0, r = 0;
        for (int weight : weights) {
            l = Math.max(l, weight);
            r += weight;
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            int t = getDays(mid, weights);
            if (t <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int getDays(int mid, int[] weights) {
        int t = 0, sum = 0;
        for (int weight : weights) {
            if (weight > mid) return Integer.MAX_VALUE;  // 坑！
            if (sum + weight > mid) {
                t++;
                sum = weight;
            } else {
                sum += weight;
            }
        }
        return t + 1;
    }
}
