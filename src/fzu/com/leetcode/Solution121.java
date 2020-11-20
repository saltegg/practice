package fzu.com.leetcode;

public class Solution121 {

    //暴力O(n2)两次循环
    public static int maxProfit1(int[] prices) {

        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[i] < prices[j]) {
                    ans = Math.max(ans, prices[j] - prices[i]);
                }
            }
        }
        return ans;
    }

    /*
    我们在每个节点其实只会做两件事（第一个节点除外，只能买入不能卖出），这两件事分别是：买入或卖出。
    那么我们其实可以用一个循环来计算出最大的利润，我们只需要依次对于每个节点做以下两个判断：

    1. 判断当前节点是不是相对最低价，如果是，则将它设置为最低价（也就是买入）；
    2. 如果当前节点不是最低价，那我们就将它卖出，然后计算卖出的收益（当前节点减去相对最低价），
        如果卖出的收益大于目前的最高收益，则将此值设置为最高收益。
     */
    public static int maxProfit(int[] prices) {

        int ans = 0, minPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if(i == 0) {
                minPrice = prices[i];
            } else if (prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
