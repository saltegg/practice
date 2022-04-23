package fzu.com.bytedance;

public class Solution122 {

    public int maxProfit(int[] prices) {

        int min = prices[0], maxProfit = 0, res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                res += maxProfit;
                maxProfit = 0;
            } else {
                if (maxProfit > prices[i] - min) {
                    res += maxProfit;
                    maxProfit = 0;
                    min = prices[i];
                } else {
                    maxProfit = prices[i] - min;
                }
            }
        }
        return res + maxProfit;
    }
}
