package fzu.com.bytedance;

public class Solution121 {

    public int maxProfit(int[] prices) {

        int min = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }
}
