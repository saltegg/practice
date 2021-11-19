package fzu.com.lc.pre200;

/**
 * @Author: linxiaohui
 * @Date: 2021/11/09 10:04
 * @Description:
 */
public class Solution1094 {

    public boolean carPooling(int[][] trips, int capacity) {

        int[] res = new int[1001];
        for (int[] trip : trips) {
            int c = trip[0], a = trip[1], b = trip[2];
            res[a] += c;
            if (b < res.length) {
                res[b] -= c;
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (i > 0) res[i] += res[i - 1];
            if (res[i] > capacity) return false;
        }
        return true;
    }
}
