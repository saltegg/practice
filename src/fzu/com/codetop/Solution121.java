package fzu.com.codetop;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int res = 0, curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin) {
                res = Math.max(res, prices[i] - curMin);
            } else {
                curMin = prices[i];
            }
        }
        return res;
    }
}
