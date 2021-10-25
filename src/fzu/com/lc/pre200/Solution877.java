package fzu.com.lc.pre200;

public class Solution877 {
    /**
     * 贪心不行
     * 用例[4,3,9,5]
     *
     * 偶数对
     * 我们设数组总长度为n，并且已知n%2 == 0：
     * 当先手取第一位时，剩下的位置是 2～n， 后手能取的位置为2或n，都为偶数位置。 后手取后总长度变为n-2，产生递归。
     * 当先手取最后一位时，.......，后手只能取1或n-1，都为奇数位置。 后手取......递归。
     * 不难看出，先手取的位置必定限制了后手能取的位置，即： 先手取首位后手只能取偶数位，先手取末位后手只能取奇数位。
     * 因此先手只需要计算好奇偶数位总和，则必赢。
     */

    /**
     * dp 区间DP
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {

        int[][] dp = new int[piles.length + 1][piles.length + 1];
        for (int i = 1; i <= piles.length; i++) dp[i][i] = piles[i - 1];
        for (int l = 1; l <= piles.length; l++) {
            for (int start = 1; start <= piles.length - l; start++) {
                int r = start + l;
                dp[l][r] = Math.max(piles[r - 1] - dp[start][r - 1], piles[start - 1] - dp[start + 1][r]);
            }
        }
        return dp[1][piles.length] >= 0;
    }
}
